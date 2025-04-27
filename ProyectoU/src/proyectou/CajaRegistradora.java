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
        Scanner input = new Scanner(System.in);
        boolean Seguir = true;
        int Opcion = 0;
        //Menu Inicial
        while (Seguir == true){
        System.out.println("***MENU***"+
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
                System.out.println("Abrir Caja");
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
