package Problema2;
public class vehiculos 
{
    private static int total = 0;

	private float tarifa;
    private String nombre;

    vehiculos(){
        total++;
    } 

    @Override
    public String toString() {
        return "Tipo de Vehículo seleccionado: " + nombre + String.format("\nTarifa: %.2f ",getTarifa() ) + "$";

    }  

    public float getTarifa() 
    {
        return tarifa;
    }

    public void setTarifa(float tarifa) 
    {
        this.tarifa = tarifa;
    }

    public static int getTotal() 
    {
		return total;
	}

    public static void setTotal(int total) {
		vehiculos.total = total;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
