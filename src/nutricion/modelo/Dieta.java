package nutricion.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Dieta {
    int codDieta;
    String nombreD;
    List<MenuDiario> menus = new ArrayList<>();
    LocalDate fechaInicio;
    LocalDate fechaFinal;
    float pesoFinal;
    int totalCalorias;
    Paciente paciente;
    
    //Constructores

    public Dieta() {
    }

    public Dieta(int codDieta, String nombreD, LocalDate fechaInicio, LocalDate fechaFinal, float pesoFinal, int totalCalorias, Paciente paciente) {
        this.codDieta = codDieta;
        this.nombreD = nombreD;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
    }

    public Dieta(String nombreD, LocalDate fechaInicio, LocalDate fechaFinal, float pesoFinal, int totalCalorias) {
        this.nombreD = nombreD;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
    }
    
    //Getter y Setter

    public int getCodDieta() {
        return codDieta;
    }

    public void setCodDieta(int codDieta) {
        this.codDieta = codDieta;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public List<MenuDiario> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDiario> menus) {
        this.menus = menus;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public float getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(float pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(int totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    //To string

    @Override
    public String toString() {
        return "Dieta{" + "codDieta=" + codDieta + ", nombreD=" + nombreD + ", menus=" + menus + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", pesoFinal=" + pesoFinal + ", totalCalorias=" + totalCalorias + ", paciente=" + paciente + '}';
    }
    
}
