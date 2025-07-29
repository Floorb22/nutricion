package nutricion.persistencia;

import nutricion.modelo.RenglonComida;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import nutricion.modelo.Comida;
/**
 *
 * @author ACER
 */
public class RenglonComidaData {
    private Connection con = null;
    
    //Constructor 

    public RenglonComidaData() {
        con = Conexion.getConexion();
    }
    
    //Metodos
    //Guardar renglon de comida
    public void crearRenglon(RenglonComida renglon, int idMenu) {
    String sql = "INSERT INTO renglondemenu (codComida, codMenu, cantidadGrs, subtotalCalorias) VALUES (?, ?, ?, ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, renglon.getAlimento().getCodComida());
        ps.setInt(2, idMenu);
        ps.setDouble(3, renglon.getCantidadGrs());
        ps.setInt(4, renglon.getSubtotalCalorias());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            renglon.setNroRenglon(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Renglón creado con éxito.");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar el renglón en la base de datos.");
    }
}

    //Agregar renglones automatico
    public void agregarRenglonesAutomaticos(int idMenu) {
    String[] tipos = {"Desayuno", "Almuerzo", "Snack", "Merienda", "Cena"};
    ComidaData cd = new ComidaData();
    
    for (String tipo : tipos) {
        ArrayList<Comida> comidas = cd.listarComidasPorTipo(tipo);
        
        if (!comidas.isEmpty()) {
            Comida comidaSeleccionada = comidas.get((int)(Math.random() * comidas.size()));
            RenglonComida renglon = new RenglonComida();
            renglon.setAlimento(comidaSeleccionada);
            renglon.setCantidadGrs(100); 
            renglon.setSubtotalCalorias((int)(comidaSeleccionada.getCaloriasPor100g())); 
            
            crearRenglon(renglon, idMenu);
        }
    }
}

    //Listar renglones
    public ArrayList<RenglonComida> listarRenglonesPorMenu(int idMenu) {
    ComidaData cdata= new ComidaData();
    ArrayList<RenglonComida> lista = new ArrayList<>();
    String sql = "SELECT * FROM renglondemenu WHERE codMenu = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idMenu);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            RenglonComida renglon = new RenglonComida();
            renglon.setNroRenglon(rs.getInt("nroRenglon"));
            renglon.setCantidadGrs(rs.getDouble("cantidadGrs"));
            renglon.setSubtotalCalorias(rs.getInt("subtotalCalorias"));
            int idComida = rs.getInt("codComida");
            Comida c = cdata.buscarComidaPorId(idComida);
            renglon.setAlimento(c);

            lista.add(renglon);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener renglones del menú.");
    }

    return lista;
}

    
}
