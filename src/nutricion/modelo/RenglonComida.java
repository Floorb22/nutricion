package nutricion.modelo;

/**
 *
 * @author ACER
 */
public class RenglonComida {
   int nroRenglon;
   Comida alimento;
   double cantidadGrs;
   int subtotalCalorias;
   
   //Constructores

    public RenglonComida() {
    }

    public RenglonComida(int nroRenglon, Comida alimento, double cantidadGrs, int subtotalCalorias) {
        this.nroRenglon = nroRenglon;
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subtotalCalorias = (int)((alimento.getCaloriasPor100g() * cantidadGrs) / 100);
    }

    public RenglonComida(Comida alimento, double cantidadGrs, int subtotalCalorias) {
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subtotalCalorias = (int)((alimento.getCaloriasPor100g() * cantidadGrs) / 100);
    }
    
    
   
    //Getters y Setters

    public int getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(int nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public Comida getAlimento() {
        return alimento;
    }

    public void setAlimento(Comida alimento) {
        this.alimento = alimento;
    }

    public double getCantidadGrs() {
        return cantidadGrs;
    }

    public void setCantidadGrs(double cantidadGrs) {
        this.cantidadGrs = cantidadGrs;
    }

    public int getSubtotalCalorias() {
        return subtotalCalorias;
    }

    public void setSubtotalCalorias(int subtotalCalorias) {
        this.subtotalCalorias = subtotalCalorias;
    }
    
    //To String

    @Override
    public String toString() {
        return "RenglonComida{" + "nroRenglon=" + nroRenglon + ", alimento=" + alimento + ", cantidadGrs=" + cantidadGrs + ", subtotalCalorias=" + subtotalCalorias + '}';
    }
    
    //Metodos
}
