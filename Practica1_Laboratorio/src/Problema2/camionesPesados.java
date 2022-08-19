package Problema2;
public class camionesPesados extends vehiculos
{
    private static int cantidad = 0;
    public camionesPesados() 
    {
        super();
        cantidad++;
        setNombre("Camiones Pesados");
        setTarifa(7f);
    }

    public static int getCantidad() 
    {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
		camionesPesados.cantidad = cantidad;
	}
}
