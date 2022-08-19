package Problema2;

import java.util.Random;
import java.util.Scanner;

/**
 * Se desea simular una estación de peajes de vehículos. 
 *  Cada vehículo tiene una tarifa: vehículos livianos B/. 2.30, buses B/. 5.30,
 *  camiones livianos B/. 3.35, camiones pesados B/. 7.00.  
 *  Al finalizar el programa debe mostrar la cantidad de vehículos y la cantidad por
 *  tipo de vehículo y total. 
 */
public class principal 
{
    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    public static void main(String[] args) 
    {
      
        int opcion = menuPrincipal();
        float tarifaTotal = 0;
        int opcionElegida, cantidad = 0, limite = aleatorio.nextInt(5,20+1);
        vehiculos vehiculoElegido;
        
        do {
            if (opcion == 1)
                opcionElegida = menuModoManual();
            else    
                opcionElegida = aleatorio.nextInt(1,4+1);
            vehiculoElegido = tipoVehiculo(opcionElegida);
            tarifaTotal += vehiculoElegido.getTarifa(); 
            System.out.println(vehiculoElegido.toString());
        } while (continuar(opcion, cantidad++, limite));
        if (opcion == 2)
            pausarPrograma();
        mostrarVehiculos();
        System.out.println(String.format("\nLa tarifa total por todos los vehículos registrados es de: %.2f $",  tarifaTotal));
        reiniciarContadores();

    }

    // metodos utilizados en el desarrollo del programa 

    public static boolean continuar(int opcion, int cantidad, int limite){
        if(opcion == 1)
            return registrarVehiculo().equalsIgnoreCase("si");
        else
            return cantidad < limite;
    }

    public static void reiniciarContadores()
    {
        vehiculos.setTotal(0);
        buses.setCantidad(0);
        camionesLivianos.setCantidad(0);
        camionesPesados.setCantidad(0);
        vehiculosLivianos.setCantidad(0);
    }

    static void mostrarVehiculos()
    {
        limpiarPantalla();
        System.out.println("\nInforme - Estación de Peajes de Vehículos\n");
        System.out.println("Cantidad de vehículos registrados: " + vehiculos.getTotal()); 
        System.out.println("Cantidad de Buses: " + buses.getCantidad()); 
        System.out.println("Cantidad de Camiones Livianos: " + camionesLivianos.getCantidad()); 
        System.out.println("Cantidad de Camiones Pesados: " + camionesPesados.getCantidad()); 
        System.out.println("Cantidad de Vehiculos Livianos: " + vehiculosLivianos.getCantidad()); 
    }
    static int menuPrincipal()
    {
        int opcion = 0;
        do {
            limpiarPantalla();
            System.out.println("°°°°° ESTACIÓN DE PEAJES DE VEHÍCULOS °°°°°");
            System.out.println("Bienvenido a nuestro programa !!");
            System.out.println("Elija un modo para el registro de vehículos");
            System.out.println("1) Manual ");
            System.out.println("2) Automático ");
        } while ((opcion = comprobarNumero("Ingrese su selección: ",2)) == -1);
        return opcion;
    }

    static int menuModoManual()
    {
        int opcion = 0;
        do{
            limpiarPantalla();
            System.out.println("Seleccione un tipo de vehiculo");
            System.out.println("1)Buses");
            System.out.println("2)Camiones Livianos");
            System.out.println("3)Camiones Pesados");
            System.out.println("4)Vehículos Livianos");
        }while((opcion = comprobarNumero("Ingrese su selección: ",4)) == -1);
        return opcion;
    }

    static int ingresarDatos(String texto)
    {
        System.out.print(texto);
        return leer.nextInt();
    }
    
    static vehiculos tipoVehiculo(int numero)
    {
        vehiculos vehiculo = null;
        switch (numero) 
        {
            case 1:
                vehiculo = new buses();
                break;
            case 2:
                vehiculo = new camionesLivianos();
                break;
            case 3:
                vehiculo = new camionesPesados();
                break;
            case 4:
                vehiculo = new vehiculosLivianos();
                break;
        }
        return vehiculo;

    }
    
    static int comprobarNumero(String texto, int limite)
    {
        int numero = ingresarDatos(texto);
        if (numero > 0 && numero <= limite)
            return numero;
        System.out.println("Error, el número ingresado debe estar en el rango de 1 a " + limite);
        pausarPrograma();
        return -1;
    }
 
    static String registrarVehiculo()
    {
        String opcion;
        while(true)
        {
            System.out.print("Desea registrar otro vehículo? Si/No: ");
            opcion = leer.next();
            if(opcion.equalsIgnoreCase("Si")|| opcion.equalsIgnoreCase("No"))
                return opcion;
            System.out.println("Error, escriba si o no para seleccionar la opción que desea ejecutar");
            pausarPrograma();
        }

    }

    public static void limpiarPantalla()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void pausarPrograma()
    {
        System.out.println("o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o");
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
