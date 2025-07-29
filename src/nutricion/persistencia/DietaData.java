package nutricion.persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nutricion.modelo.Dieta;
import nutricion.modelo.Paciente;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author ACER
 */
public class DietaData {
    
    private Connection con = null;
    
    //Constructor

    public DietaData() {
        con = Conexion.getConexion();
    }
    
    //Metodos
    //Guardar dieta
    public void guardarDieta(Dieta dieta, int nroPaciente) {
        Paciente p;
        String sql = "INSERT INTO dieta (nombreDieta, fechaInicio, fechaFin, pesoFinal, totalCalorias, nroPaciente)"
                + "VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombreD());
             ps.setDate(2, Date.valueOf(dieta.getFechaInicio()));
             ps.setDate(3, Date.valueOf(dieta.getFechaFinal()));
            ps.setFloat(4, dieta.getPesoFinal());
            ps.setInt(5,dieta.getTotalCalorias());
            ps.setInt(6, nroPaciente);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dieta.setCodDieta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Dieta guardada con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta.");
        }
    }
    
    //Borrar dieta
    public void borrarDieta(String nombreDieta){
        String sql = "DELETE FROM dieta WHERE nombreDieta=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreDieta);

            int x = ps.executeUpdate();

            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Dieta eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la dieta.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la dieta: " + ex.getMessage());
        }
    }
        
}
