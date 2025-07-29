package nutricion.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class MenuDiario {
    int codMenu;
    int diaNro;
    List<RenglonComida> comidas = new ArrayList<>();
    boolean estado;
    int codDieta;
    Dieta dieta;
    
    //Constructores

    public MenuDiario() {
    }

    public MenuDiario(int codMenu, int diaNro, boolean estado, int codDieta, Dieta dieta) {
        this.codMenu = codMenu;
        this.diaNro = diaNro;
        this.estado = estado;
        this.codDieta = codDieta;
        this.dieta = dieta;
    }

    public MenuDiario(int diaNro, boolean estado, int codDieta) {
        this.diaNro = diaNro;
        this.estado = estado;
        this.codDieta = codDieta;
    }

    
    //Getter y Setters

    public int getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(int codMenu) {
        this.codMenu = codMenu;
    }

    public int getDiaNro() {
        return diaNro;
    }

    public void setDiaNro(int diaNro) {
        this.diaNro = diaNro;
    }

    public List<RenglonComida> getComidas() {
        return comidas;
    }

    public void setComidas(List<RenglonComida> comidas) {
        this.comidas = comidas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCodDieta() {
        return codDieta;
    }

    public void setCodDieta(int codDieta) {
        this.codDieta = codDieta;
    }
    

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    
    //To String


    @Override
    public String toString() {
        return "MenuDiario{" + "codMenu=" + codMenu + ", diaNro=" + diaNro + ", comidas=" + comidas + ", estado=" + estado + ", codDieta=" + codDieta + ", dieta=" + dieta + '}';
    }
}
