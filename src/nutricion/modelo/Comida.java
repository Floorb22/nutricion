package nutricion.modelo;

/**
 *
 * @author ACER
 */
public class Comida {
    int codComida;
    String nombre;
    String tipoComida;
    int caloriasPor100g;
    String detalle;
    boolean baja;
    
    //Constructores

    public Comida() {
    }

    public Comida(int codComida, String nombre, String tipoComida, int caloriasPor100g, String detalle, boolean baja) {
        this.codComida = codComida;
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.baja = baja;
    }

    public Comida(String nombre, String tipoComida, int caloriasPor100g, String detalle, boolean baja) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.baja = baja;
    }
    
    
    //Getter y Setters

    public int getCodComida() {
        return codComida;
    }

    public void setCodComida(int codComida) {
        this.codComida = codComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public int getCaloriasPor100g() {
        return caloriasPor100g;
    }

    public void setCaloriasPor100g(int caloriasPor100g) {
        this.caloriasPor100g = caloriasPor100g;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
    
    //To String

    @Override
    public String toString() {
        return "Comida{" + "codComida=" + codComida + ", nombre=" + nombre + ", tipoComida=" + tipoComida + ", caloriasPor100g=" + caloriasPor100g + ", detalle=" + detalle + ", baja=" + baja + '}';
    }
    
    //Metodos
}
