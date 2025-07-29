package nutricion.persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import nutricion.modelo.Paciente;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author ACER
 */
public class PacienteData {

    private Connection con = null;

    //Constructor
    public PacienteData() {
        con = Conexion.getConexion();
    }

    //Metodos
    //Guardar paciente
    public void guardarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nombre, edad, altura, pesoActual, pesoBuscado)"
                + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getEdad());
            ps.setFloat(3, paciente.getAltura());
            ps.setFloat(4, paciente.getPesoActual());
            ps.setFloat(5, paciente.getPesoBuscado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setNroPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente guardado con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla paciente.");
        }
    }

    //Eliminar paciente 
    public void borrarPaciente(int nroPaciente) {
        String sql = "DELETE FROM paciente WHERE nroPaciente=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nroPaciente);

            int x = ps.executeUpdate();

            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el paciente: " + ex.getMessage());
        }
    }

 
 
    //Actualizar peso actual
    public void actualizarPesoActual(float pesoActual, String nombre) {
        String sql = "UPDATE paciente SET pesoActual=? WHERE nombre=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, pesoActual);
            ps.setString(2, nombre);

            int x = ps.executeUpdate();

            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Peso actual modificado.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el peso actual." + ex.getMessage());
        }
    }
    

    //Listas de pacientes que llegaron a la meta
    public ArrayList<Paciente> listarPacientesPesoLogrado() {

        String sql = "SELECT * FROM paciente WHERE pesoActual <= pesoBuscado";
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
                pacientes.add(paciente);
            }
            //System.out.println(pacientes);
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la lista");

        }

        return pacientes;
    }

//Lista todos los pacientes
 public ArrayList<Paciente> listarPacientes() {

        String sql = "SELECT * FROM paciente";
        ArrayList<Paciente> p = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
                p.add(paciente);
            }
            //System.out.println(pacientes);
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la lista");

        }

        return p;
    }
}
