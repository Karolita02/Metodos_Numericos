package Problema2;
public class camionesLivianos extends vehiculos
{
    private static int cantidad = 0;
    public camionesLivianos() 
    {
        super();
        cantidad++;
        setNombre("Camiones Livianos");
        setTarifa(3.35f);
    } 
    
    public static int getCantidad() 
    {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
		camionesLivianos.cantidad = cantidad;
	}
}
