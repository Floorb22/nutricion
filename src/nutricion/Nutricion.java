package nutricion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import nutricion.modelo.Comida;
import nutricion.modelo.Dieta;
import nutricion.modelo.MenuDiario;
import nutricion.modelo.Paciente;
import nutricion.modelo.RenglonComida;
import nutricion.persistencia.ComidaData;
import nutricion.persistencia.Conexion;
import nutricion.persistencia.DietaData;
import nutricion.persistencia.MenuDiarioData;
import nutricion.persistencia.PacienteData;
import nutricion.persistencia.RenglonComidaData;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author ACER
 */
public class Nutricion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Conexiones
        Connection con = Conexion.getConexion();
        PacienteData pd = new PacienteData();
        DietaData dd = new DietaData();
        MenuDiarioData mdata = new MenuDiarioData();
        ComidaData cdata = new ComidaData();
        RenglonComidaData rcdata = new RenglonComidaData();

        Scanner scanner = new Scanner(System.in);

//Paciente
/*Pacientes creados
        Paciente p = new Paciente("Antonella", 19, 1.68f, 75.3f, 70.0f)
        pd.guardarPaciente(p);
        Paciente p2 = new Paciente ("Florencia", 25, 1.80f, 88.8f, 80.0f);
        pd.guardarPaciente(p2);
        Paciente p3 = new Paciente ("Francisco", 25, 1.77f, 80.0f, 77.5f);
        pd.guardarPaciente(p3);

//Metodos y consultas
        pd.borrarPaciente(1);
        pd.actualizarPesoActual(75.0f, "Florencia");
        pd.listarPacientes();
        pd.cambiarPesoBuscado(78.0f, "Florencia");
         */
//Dieta
/*Dietas creadas
        Dieta d = new Dieta("Baja en calorías", LocalDate.of(2025, 2, 15), LocalDate.of(2025, 5, 30), 70.0f, 1000);
        dd.guardarDieta(d, 2);
         */
//MenuDiario
/*MenuDiario creados
        MenuDiario menu1 = new MenuDiario(1, true, 2);
        mdata.guardarMenuDiario(menu1);
        MenuDiario menu2 = new MenuDiario(2, true, 2);
        mdata.guardarMenuDiario(menu2);
        MenuDiario menu3 = new MenuDiario(3, true, 2);
        mdata.guardarMenuDiario(menu3);
        MenuDiario menu4 = new MenuDiario(4, true, 2);
        mdata.guardarMenuDiario(menu4);
        --
        MenuDiario menu5 = new MenuDiario(1,true,8);
        mdata.guardarMenuDiario(menu5);
        MenuDiario menu6 = new MenuDiario(2, true, 8);
        mdata.guardarMenuDiario(menu6);
        MenuDiario menu7 = new MenuDiario(3, true, 8);
        mdata.guardarMenuDiario(menu7);
        
        MenuDiario menu8 = new MenuDiario(1, true, 6);
        mdata.guardarMenuDiario(menu8);
        MenuDiario menu9 = new MenuDiario(2, true, 6);
        mdata.guardarMenuDiario(menu9);
        MenuDiario menu10 = new MenuDiario(3, true, 6);
        mdata.guardarMenuDiario(menu10);
        MenuDiario menu11 = new MenuDiario(4, true, 6);
        mdata.guardarMenuDiario(menu11);
        MenuDiario menu12 = new MenuDiario(5, true, 6);
        mdata.guardarMenuDiario(menu12);
        MenuDiario menu13 = new MenuDiario(6, true, 6);
        mdata.guardarMenuDiario(menu13);
        
//Comida
//Comidas creadas
        /*Desayuno
        Comida cd1 = new Comida("Yogur con cereales", "Desayuno", 140, "Yogur y cereal", true);
        Comida cd2 = new Comida("Tostadas con palta y huevo", "Desayuno", 300, "Tostadas, palta y huevo", true);
        Comida cd3 = new Comida("Cafe con galletas de limón", "Desayuno", 100, "Cafe y galletas", true);
        Comida cd4 = new Comida("Licuado de frutas", "Desayuno", 130, "Frutas", true);
        cdata.guardarComida(cd1);
        cdata.guardarComida(cd2);
        cdata.guardarComida(cd3);
        cdata.guardarComida(cd4);
        
        //Snacks
        Comida cs1 = new Comida("Barrita de cereal", "Snack", 350, "Cereal", true);
        Comida cs2 = new Comida("Manzana", "Snack", 52, "Manzana", true);
        Comida cs3 = new Comida("Yogur griego", "Snack", 100, "Yogur", true);
        Comida cs4 = new Comida("Frutos secos", "Snack", 160, "Frutos secos", true);
        cdata.guardarComida(cs1);
        cdata.guardarComida(cs2);
        cdata.guardarComida(cs3);
        cdata.guardarComida(cs4);
        
        //Meriendas
        Comida cm1 = new Comida("Tostadas con mermelada", "Merienda", 250, "Tostadas", true);
        Comida cm2 = new Comida("Cafe y medialunas", "Merienda", 280, "Cafe y facturas", true);
        Comida cm3 = new Comida("Te y budin", "Merienda", 180, "Te y budin", true);
        Comida cm4 = new Comida("Ensalada de frutas", "Merienda", 100, "Frutas", true);
        cdata.guardarComida(cm1);
        cdata.guardarComida(cm2);
        cdata.guardarComida(cm3);
        cdata.guardarComida(cm4);
        
        //Almuerzos
        Comida ca1 = new Comida("Arroz con pollo", "Almuerzo", 363, "Cuenta con arroz, pollo, cebolla y pimiento", true);
        Comida ca2 = new Comida("Milanesa con púre", "Almuerzo", 550, "La milanesa puede ser de carne o pollo con púre de verdura", true);
        Comida ca3 = new Comida("Tarta de verduras", "Almuerzo", 350, "Puede ser de zapallo o acelga", true);
        Comida ca4 = new Comida("Pollo al horno con ensalada", "Almuerzo", 400, "Pollo y ensaladas verdes", true);
        cdata.guardarComida(ca1);
        cdata.guardarComida(ca2);
        cdata.guardarComida(ca3);
        cdata.guardarComida(ca4);
        
        //Cenas
        Comida cc1 = new Comida("Huevo revuelto con verduras salteadas", "Cena", 250, "Huevo y verduras", true);
        Comida cc2 = new Comida("Sopa de verduras", "Cena", 150, "Verduras con caldo", true);
        Comida cc3 = new Comida("Filet de merluza con ensalada", "Cena", 300, "Pescado y ensaladas", true);
        Comida cc4 = new Comida("Hamburguesa con púre", "Cena", 500, "La hamburguesa puede ser de carne o pollo con puré de verduras", true);
        //cdata.guardarComida(cc1);
        //cdata.guardarComida(cc2);
        //cdata.guardarComida(cc3);
        cdata.guardarComida(cc4);

// Metodos y consultas
        System.out.println("Ingrese un ingrediente que le guste:");
        String ingrediente = scanner.nextLine();
        cdata.listarComidasPorIngrediente(ingrediente);

        System.out.println("Ingrese una comida que le guste:");
        String comida = scanner.nextLine();
        cdata.listarComidasPorNombre(comida); 
       
        System.out.println("Ingrese el máximo número de calorías que esta dispuesto a comer:");
        int caloria = scanner.nextInt();
        cdata.listarComidasPorCalorias(caloria);

        System.out.println("Ingrese si quiere saber de desayuno, snack, merienda, almuerzo o cena:");
        String tipo = scanner.nextLine;
        cdata.listarComidasPorTipo(tipo);
       
//Renglon Comida
    //Armando renglones  para los 4 menús hechos manualmente (DIETA cod2)
        for (int id = 1; id <= 4; id++) {
            rcdata.agregarRenglonesAutomaticos(id);
        }
    }
        
    //Armando renglones para los 3 menús hechos manualmente (DIETA cod8)
        for (int id = 5; id <= 7; id++){
            rcdata.agregarRenglonesAutomaticos(id);
        }
    }
        
    //Armando renglones para los 6 menús hechos manualmente (DIETA cod6)
        for (int id= 8; id <=13; id++){
            rcdata.agregarRenglonesAutomaticos(id);
        }
*/
}
}
