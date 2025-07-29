package nutricion.persistencia;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nutricion.modelo.Comida;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author ACER
 */
public class ComidaData {

    private Connection con = null;

    //Constructor
    public ComidaData() {
        con = Conexion.getConexion();
    }

    //Metodos
    //Guardar comida 
    public void guardarComida(Comida comida) {
        String sql = "INSERT INTO comida (nombre, tipoComida, caloriasPor100g, detalle, baja)"
                + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getTipoComida());
            ps.setInt(3, comida.getCaloriasPor100g());
            ps.setString(4, comida.getDetalle());
            ps.setBoolean(5, comida.isBaja());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setCodComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida guardada con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida.");
        }
    }
    
    //Eliminar comida
    public void borrarComida(int codComida) {
        String sql = "DELETE FROM comida WHERE codComida=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codComida);

            int x = ps.executeUpdate();

            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Comida eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la comida.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la comida: " + ex.getMessage());
        }
    }

    //Filtrar por ingrediente
    public ArrayList<Comida> listarComidasPorIngrediente(String ingrediente) {
        String sql = "SELECT * FROM comida WHERE detalle LIKE ?";
        ArrayList<Comida> comidasIngrediente = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ingrediente + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comida c = new Comida();
                c.setCodComida(rs.getInt("codComida"));
                c.setNombre(rs.getString("nombre"));
                c.setTipoComida(rs.getString("tipoComida"));
                c.setDetalle(rs.getString("detalle"));
                c.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                c.setBaja(rs.getBoolean("baja"));
                comidasIngrediente.add(c);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la lista de comidas");
        }

        return comidasIngrediente;
    }

    //Filtrar por nombre
    public ArrayList<Comida> listarComidasPorNombre(String nombre) {
        String sql = "SELECT * FROM comida WHERE nombre LIKE ?";
        ArrayList<Comida> comidasNombre = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comida c = new Comida();
                c.setCodComida(rs.getInt("codComida"));
                c.setNombre(rs.getString("nombre"));
                c.setTipoComida(rs.getString("tipoComida"));
                c.setDetalle(rs.getString("detalle"));
                c.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                c.setBaja(rs.getBoolean("baja"));
                comidasNombre.add(c);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la lista de comidas");
        }

        return comidasNombre;
    }

    //Filtrar por calorías
    public ArrayList<Comida> listarComidasPorCalorias(int caloria) {
        String sql = "SELECT * FROM comida WHERE caloriasPor100g <= ?";
        ArrayList<Comida> comidasCalorias = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, caloria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comida c = new Comida();
                c.setCodComida(rs.getInt("codComida"));
                c.setNombre(rs.getString("nombre"));
                c.setTipoComida(rs.getString("tipoComida"));
                c.setDetalle(rs.getString("detalle"));
                c.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                c.setBaja(rs.getBoolean("baja"));
                comidasCalorias.add(c);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la lista de comidas");
        }

        return comidasCalorias;
    }

    //Filtrar por tipo
    public ArrayList<Comida> listarComidasPorTipo(String tipoComida) {
        String sql = "SELECT * FROM comida WHERE tipoComida LIKE ?";
        ArrayList<Comida> comidasTipo = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tipoComida + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comida c = new Comida();
                c.setCodComida(rs.getInt("codComida"));
                c.setNombre(rs.getString("nombre"));
                c.setTipoComida(rs.getString("tipoComida"));
                c.setDetalle(rs.getString("detalle"));
                c.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                c.setBaja(rs.getBoolean("baja"));
                comidasTipo.add(c);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la lista de comidas");
        }

        return comidasTipo;
    }

    //Filtrar por id
    public Comida buscarComidaPorId(int id) {
        Comida comida = null;
        String sql = "SELECT * FROM comida WHERE codComida = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                comida = new Comida();
                comida.setCodComida(rs.getInt("codComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setTipoComida(rs.getString("tipoComida"));
                comida.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setBaja(rs.getBoolean("baja"));
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la comida por ID.");
        }
        return comida;
    }

}
