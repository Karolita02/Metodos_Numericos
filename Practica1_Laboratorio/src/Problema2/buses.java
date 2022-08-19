package Problema2;
public class buses extends vehiculos
{
    private static int cantidad = 0;

    public buses() 
    {
        super();
        cantidad++;
        setNombre("Buses");
        setTarifa(5.30f);
    }

    public static int getCantidad() 
    {
        return cantidad;
    }
    
    public static void setCantidad(int cantidad) {
		buses.cantidad = cantidad;
	}
    
}
