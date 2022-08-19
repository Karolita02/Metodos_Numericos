package Problema2;
public class vehiculosLivianos extends vehiculos
{
    private static int cantidad = 0;

	public vehiculosLivianos() 
    {
        super();
        cantidad++;
        setNombre("Vehiculos Livianos");
        setTarifa(2.30f);
    } 
    
    public static int getCantidad() 
    {
        return cantidad;
    }
        
    public static void setCantidad(int cantidad) {
		vehiculosLivianos.cantidad = cantidad;
	}
}
