/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectou;
import java.util.Scanner; //Import Scanner
import java.util.InputMismatchException; //Import MismatchException
/**
 *
 * @author user
 */
public class CajaRegistradora {
    public static void main(String[]args)
    {
        //VARIABLES
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        boolean Seguir = true; //Para seguir con el menu
        boolean primeravez = true; //Para ver si es la primera vez que abre caja
        int Opcion = 0; //Crear la vaiable opcion
        double CajaEfectivoT = 0;//El efectivo de la caja como tal , asi se calcula todo lo que hay
        double CajaEfectivoV = 0;//Efectivo de ventas , se usara para medir el total de dinero ese dia
        double CajaEfectivoI = 0;//Efectivo ingresado
        boolean valido = false;//Numero valido en try
        boolean CajaEstado = false; //Estado de la caja
        //-------------------------------------
        //Menu Inicial
        while (Seguir == true){
        System.out.println("---MENU---"+
                "\n1.Abrir Caja"+
                "\n2.Ventas"+
                "\n3.Compras"+
                "\n4.Cerrar Caja"+
                "\n5.Salir del programa");
        System.out.println("Porfavor ingrese la opcion a elegir");
        try { //Misma logica que el try de python
        Opcion = input.nextInt();
        }
        catch (InputMismatchException e) //Esto es necesario es como el try ; except de python
        {
        System.out.println("Error: Debe de ingresar un numero entero");
        input.next();
        continue; //Volver al bucle y que no se repita eso de ingrese uno correcto
        
        }
        switch(Opcion)
        {
            case 1:
                if (primeravez == true)
                    valido = false;
                {
                while (!valido)
                {
                try 
                {
                System.out.println("Ingresar la cantidad de efectivo a agregar a la caja");
                CajaEfectivoI = input.nextDouble();
                
                if (CajaEfectivoI >= 0){//Prueba si es un numero positivo
                CajaEfectivoT += CajaEfectivoI;
                valido = true;
                primeravez = false;
                System.out.printf("\nSe a ingresado:Lps.%.2fn",CajaEfectivoI);
                System.out.printf("\nEfectivo Total en caja:Lps.%.2fn",CajaEfectivoT);
                //Cuando se usa el printf con el %.2fn se tiene que poner , y no +
                }
                else //Si es negativo entonces
                {
                System.out.println("Error:No se permiten cantidades negativas");//Mensaje de error Nums negativos
                //input.next();
                }
                
                }//Try
                catch(InputMismatchException e)
                {
                System.out.println("Porfavor ingresar un numero valido");
                input.next();
                valido = false;
                
                }//Mismatch
                    
                }//!Valido
                }//PrimeraVez
                CajaEstado = true;
                System.out.println("\nLa Caja esta abierta");
                break;
            case 2:
                System.out.println("Ventas");
                break;
            case 3:
                System.out.println("Compras");
                break;
            case 4:
                System.out.println("Cerrar Caja");
                break;
            case 5:
                System.out.println("Salir del programa");
                break;
            default:
                System.out.println("Elige una opcion valida");
                break;
        
        }//Switch
        }//Seguir

    
    }//Static void
    
}