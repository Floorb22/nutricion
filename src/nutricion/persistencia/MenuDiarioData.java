package nutricion.persistencia;

import nutricion.modelo.MenuDiario;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JOptionPane;
import nutricion.modelo.Comida;
import nutricion.modelo.RenglonComida;

/**
 *
 * @author ACER
 */
public class MenuDiarioData {

    private Connection con = null;

    //Constructor
    public MenuDiarioData() {
        con = Conexion.getConexion();
    }

    //Metodos
    //Guardar menu
    public void guardarMenuDiario(MenuDiario menu) {
        String sql = "INSERT INTO menudiario (diaNro, estado, codDieta) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, menu.getDiaNro());
            ps.setBoolean(2, menu.isEstado());
            ps.setInt(3, menu.getCodDieta());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                menu.setCodMenu(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Menú guardado con éxito.");
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al guardar el menú diario: " + ex.getMessage());
        }

    }

    //Mostrar menus de una dieta
    public ArrayList<RenglonComida> imprimirMenusDeDieta(int codDieta) {
        RenglonComidaData rcdata = new RenglonComidaData();
        ArrayList<RenglonComida> renglones = new ArrayList<>();
        String sql = "SELECT * FROM menudiario WHERE codDieta = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codDieta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codMenu = rs.getInt("codMenu");
                int diaNro = rs.getInt("diaNro");
                int totalCalorias = 0;
                ArrayList<RenglonComida> renglonesDelMenu = rcdata.listarRenglonesPorMenu(codMenu);
                
                for (RenglonComida r : renglonesDelMenu) {
                    totalCalorias += r.getSubtotalCalorias();
                }

                //System.out.println(diaNro + " - Día " + obtenerNombreDelDia(diaNro) + ": " + totalCalorias + " kcal");

                for (RenglonComida r : renglonesDelMenu) {
                    String nombreAlimento = r.getAlimento().getNombre();
                    double cantidad = r.getCantidadGrs();
                    System.out.println("- " + nombreAlimento + " (" + cantidad + "g)");
                }

                renglones.addAll(renglonesDelMenu);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar menús diarios");
        }
        return renglones;
    }

    //Menus por dieta
    public ArrayList<MenuDiario> obtenerMenusPorDieta(int codDieta) {
    ArrayList<MenuDiario> lista = new ArrayList<>();
    String sql = "SELECT * FROM menudiario WHERE codDieta = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codDieta);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            MenuDiario md = new MenuDiario();
            md.setCodMenu(rs.getInt("codMenu"));
            md.setDiaNro(rs.getInt("diaNro"));
            md.setCodDieta(codDieta); 
            lista.add(md);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener menús.");
    }

    return lista;
}

    //Generar menu automatico
    public void generarMenuSugerido(ArrayList<String> ingredientes, int codDieta) {
    ComidaData cdata = new ComidaData();
    RenglonComidaData rdata = new RenglonComidaData();

    HashSet<Comida> comidasSugeridas = new HashSet<>();

    for (String ingrediente : ingredientes) {
        ArrayList<Comida> comidasPorIng = cdata.listarComidasPorIngrediente(ingrediente);
        comidasSugeridas.addAll(comidasPorIng); // evitar repetidas
    }

    ArrayList<Comida> listaComidas = new ArrayList<>(comidasSugeridas);

    Random r = new Random();
    int cantidadMenus = r.nextInt(5) + 3; // 3 a 7

    for (int i = 0; i < cantidadMenus; i++) {
        int diaNro = i + 1;

        MenuDiario menu = new MenuDiario();
        menu.setCodDieta(codDieta);
        menu.setDiaNro(diaNro);
        menu.setEstado(true);

        guardarMenuDiario(menu);

        for (int j = 0; j < 5; j++) {
            Comida comida = listaComidas.get(r.nextInt(listaComidas.size()));
            double cantidad = 100; 
            int subtotal = (int)((comida.getCaloriasPor100g() * cantidad) / 100);

            RenglonComida renglon = new RenglonComida();
            renglon.setAlimento(comida);
            renglon.setCantidadGrs(cantidad);
            renglon.setSubtotalCalorias(subtotal);

            rdata.crearRenglon(renglon, menu.getCodMenu());
        }
    }

    JOptionPane.showMessageDialog(null, "Menús sugeridos creados con éxito.");
}

    
}
