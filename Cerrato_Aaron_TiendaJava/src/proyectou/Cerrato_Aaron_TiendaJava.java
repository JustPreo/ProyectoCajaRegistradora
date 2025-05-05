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
public class Cerrato_Aaron_TiendaJava {
    public static void main(String[]args)
    {
        //VARIABLES
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        String siNo = "";
        boolean siNoValido = false;//Para las opciones de elegir si o no
        boolean seguirMenu = true; //Para seguir con el menu
        boolean primeraVez = true; //Para ver si es la primera vez que abre caja
        int Opcion = 0; //Crear la vaiable opcion
        double cajaEfectivoT = 0;//El efectivo de la caja como tal , asi se calcula todo lo que hay
        double cajaEfectivoV = 0;//Efectivo de ventas , se usara para medir el total de dinero ese dia
        double cajaEfectivoI = 0;//Efectivo ingresado
        boolean valido = false;//Numero valido en try
        boolean cajaEstado = false; //Estado de la caja
        double stockProducto1 = 0;
        double stockProducto2 = 0;
        double stockProducto3 = 0;
        double stockProducto4 = 0;
        String clienteIngresado = "";
        int productoElegidoCliente = 0;
        double cantidadElegidaCliente =0;
        double precioProducto1 = 30;
        double precioProducto2 = 25;
        double precioProducto3 = 32;
        double precioProducto4 = 20;
        
        //-------------------------------------
        //Menu Inicial
        while (seguirMenu == true){
            valido = false;
        System.out.println("\n---MENU---"+
                "\n1.Abrir Caja"+
                "\n2.Ventas"+
                "\n3.Compras"+
                "\n4.Reportes"+
                "\n5.Cerrar Caja"+
                "\n6.Salir del programa"+
                "\n----------");
        System.out.println("Porfavor ingrese la opcion a elegir");
        try { //Misma logica que el try de python
        Opcion = input.nextInt();
        }
        catch (InputMismatchException e) //Cuando haya un error va a hacer el bloque de codigo de abajo
        {
        System.out.println("Error: Debe de ingresar un numero valido");
        input.next();
        continue; //Volver al bucle del y que no se repita eso de ingrese uno correcto
      
        }
        switch(Opcion)
        {
            case 1://Abrir Caja
                /*Para el primer dia hay que meter pisto si o si
                //Segundo dia en adelante se podria crear un menu para ingresar efectivo y abrir caja)?
                O solo abrir caja */
                siNoValido = false;
                if (primeraVez == true)

                    {
                    while (!valido)
                    {
                    try 
                    {
                    System.out.println("Ingresar la cantidad de efectivo a agregar a la caja");
                    cajaEfectivoI = input.nextDouble();

                    if (cajaEfectivoI >= 0){//Prueba si es un numero positivo
                    cajaEfectivoT += cajaEfectivoI;
                    valido = true;
                    primeraVez = false;
                    cajaEstado = true;
                    System.out.printf("\nSe a ingresado:Lps.%.2f",cajaEfectivoI);
                    System.out.printf("\nEfectivo Total en caja:Lps.%.2f",cajaEfectivoT);
                    //Cuando se usa el printf con el %.2fn se tiene que poner , y no +

                    }

                    else //Si es negativo entonces
                    {
                    System.out.println("Error:No se permiten cantidades negativas");//Mensaje de error Nums negativos
                    }

                    }//Try
                    catch(InputMismatchException e)
                    {
                    System.out.println("Porfavor ingresar un numero valido");
                    input.next();
                    valido = false;

                    }//Mismatch

                    }//!Valido
                    break;
                    }//PrimeraVez
                else {
                    while (!siNoValido){    
                    System.out.println("Desea ingresar efectivo a la caja? Si/No");
                    siNo = input.next();

                if (siNo.equalsIgnoreCase("si")) 
                    {
                        while (!valido)
                    {
                    try 
                    {
                    System.out.println("Ingresar la cantidad de efectivo a agregar a la caja");
                    cajaEfectivoI = input.nextDouble();

                    if (cajaEfectivoI >= 0){//Prueba si es un numero positivo
                    cajaEfectivoT += cajaEfectivoI;
                    valido = true;
                    System.out.printf("\nSe a ingresado:Lps.%.2f",cajaEfectivoI);
                    System.out.printf("\nEfectivo Total en caja:Lps.%.2f",cajaEfectivoT);
                    cajaEstado = true;  
                    //Cuando se usa el printf con el %.2fn se tiene que poner , y no +
                    break;
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
                        break;
                    }//Fin Si
                
                else if (siNo.equalsIgnoreCase("no")) 
                    {
                    cajaEstado = true;
                    System.out.println("\nLa Caja esta abierta");
                    
                    break;   
                    }//Fin No
                
                else 
                    {
                    System.out.println("Escribir Si o No");
                    }
                    }//Fin del while valido
                    }//Else del if primera vez
                break;
            case 2://Ventas
                if (cajaEstado == true)
                    {
                        String facturacion = "---Factura---";
                        double subTotal = 0;
                        double total = 0;
                        double descuento = 0;
                        double impuesto = 0;
                        //precioProductox es una variable para los precios de venta
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| Codigo | Producto | Precio Venta  | Stock    |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 1      | Azucar   | Lps.30        | "+stockProducto1+" KG |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 2      | Avena    | Lps.25        | "+stockProducto2+" KG |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 3      | Trigo    | Lps.32        | "+stockProducto3+" KG |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 4      | Maiz     | Lps.20        | "+stockProducto4+" KG |");
                        
                        System.out.println("-------------------------------------------------------------");                       
                        System.out.println("Tipo de clientes");
                        System.out.println("A - Cliente tipo A: puede comprar cualquier producto (códigos 1, 2, 3 y 4).");
                        System.out.println("B - Cliente tipo B: puede comprar solo productos con código 1, 2 y 3.");
                        System.out.println("C - Cliente tipo C: puede comprar solo el producto con código 4.");
                        System.out.println("-------------------------------------------------------------");

                        
                        
                        while (!valido)
                        {
                            System.out.print("Ingrese el tipo de cliente (A, B o C): ");
                            clienteIngresado = input.next();
                            if (!clienteIngresado.equalsIgnoreCase("A") && !clienteIngresado.equalsIgnoreCase("B")&& 
                                !clienteIngresado.equalsIgnoreCase("C") )
                            {
                            System.out.println("Ingrese un cliente valido");
                            }
                            else 
                            {
                            valido = true;
                            }
                        }
                        
                        productoElegidoCliente =0;
                        if (clienteIngresado.equalsIgnoreCase("A"))
                        {

                            siNo = "si"; //Para que se reinicie la seleccion de siNo
                            while (siNo.equalsIgnoreCase("si")){   
                            valido = false;
                            System.out.println("Ingrese codigo del producto a comprar");
                            while (!valido) {
                              try {
                                  productoElegidoCliente =0;//Resetear producto elegido por si elige que si
                                  productoElegidoCliente = input.nextInt();

                                  if (productoElegidoCliente >= 1 && productoElegidoCliente <= 4) {//Revisa que el cliente este dentro del 1-4
                                      valido = true;
                                  } else {
                                      System.out.println("Código inválido. Debe ser un número del 1 al 4.");
                                      valido = false;
                                  }
                              } catch (InputMismatchException e) {
                                  System.out.println("Ingrese un número válido.");
                                  input.next(); // limpia el scanner
                              }
                              

                              
                              if (productoElegidoCliente == 1) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto1 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto1 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto1);
                                        facturacion = facturacion + 
                                                "\nCodigo: 1" + 
                                                "   Nombre Producto: Azucar"+ 
                                                "   Precio Unitario: "+precioProducto1+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              } //Fin If A
                              //INICIO IF 1
                              //---------------------------------------------------------------------
                              if (productoElegidoCliente == 2) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto2 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto2 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto2);
                                        facturacion = facturacion + 
                                                "\nCodigo: 2" + 
                                                "   Nombre Producto: Avena"+ 
                                                "   Precio Unitario: "+precioProducto2+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              }//Fin if 2
                              //---------------------------------------------------------------------
                              if (productoElegidoCliente == 3) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto3 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto3 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto3);
                                        facturacion = facturacion + 
                                                "\nCodigo: 3" + 
                                                "   Nombre Producto: Trigo"+ 
                                                "   Precio Unitario: "+precioProducto3+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              }//Fin if 3
                              //---------------------------------------------------------------------
                              if (productoElegidoCliente == 4) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto4 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto4 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto4);                                        
                                        facturacion = facturacion + 
                                                "\nCodigo: 4" + 
                                                "   Nombre Producto: Maiz"+ 
                                                "   Precio Unitario: "+precioProducto4+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                    
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              }//Fin if 2
                              //---------------------------------------------------------------------
                              
                              /*
                              else //Agregar un else if para que si elige x producto que no sea los permitidos entonces hacer eso  
                              {
                              System.out.println("No puede comprar dicho producto");
                              }
                              */
                            }//FinValido
                    siNoValido = false;
                            while (!siNoValido){
                                System.out.println("Desea seguir comprando productos?Si/No");
                                siNo = input.next();

                            if (siNo.equalsIgnoreCase("si") ||siNo.equalsIgnoreCase("no") )
                            {
                            siNoValido = true;
                            }
                            else {System.out.println("Ingresa Si/No");
                            siNoValido = false;}
                            
                            }
                        }//Fin SiNo
                        }//Fin del if cliente A
                            
                            
                        
                        else if(clienteIngresado.equalsIgnoreCase("B"))
                        {
                        siNo = "si"; //Para que se reinicie la seleccion de siNo
                            while (siNo.equalsIgnoreCase("si")){   
                            valido = false;
                            System.out.println("Ingrese codigo del producto a comprar");
                            while (!valido) {
                              try {
                                  productoElegidoCliente =0;//Resetear producto elegido por si elige que si
                                  productoElegidoCliente = input.nextInt();

                                  if (productoElegidoCliente >= 1 && productoElegidoCliente <= 4) {//Revisa que el cliente este dentro del 1-4
                                      valido = true;
                                  } else {
                                      System.out.println("Código inválido. Debe ser un número del 1 al 4.");
                                      valido = false;
                                  }
                              } catch (InputMismatchException e) {
                                  System.out.println("Ingrese un número válido.");
                                  input.next(); // limpia el scanner
                              }
                              

                              
                              if (productoElegidoCliente == 1) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto1 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto1 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto1);
                                        facturacion = facturacion + 
                                                "\nCodigo: 1" + 
                                                "   Nombre Producto: Azucar"+ 
                                                "   Precio Unitario: "+precioProducto1+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              } //Fin If A
                              //INICIO IF 1
                              //---------------------------------------------------------------------
                              if (productoElegidoCliente == 2) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto2 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto2 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto2);
                                        facturacion = facturacion + 
                                                "\nCodigo: 2" + 
                                                "   Nombre Producto: Avena"+ 
                                                "   Precio Unitario: "+precioProducto2+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              }//Fin if 2
                              //---------------------------------------------------------------------
                              if (productoElegidoCliente == 3) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto3 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto3 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto3);
                                        facturacion = facturacion + 
                                                "\nCodigo: 3" + 
                                                "   Nombre Producto: Trigo"+ 
                                                "   Precio Unitario: "+precioProducto3+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              }//Fin if 3
                              //---------------------------------------------------------------------
                              
                              
                              
                              else if (productoElegidoCliente == 4)//Agregar un else if para que si elige x producto que no sea los permitidos entonces hacer eso  
                              {
                              System.out.println("No puede comprar dicho producto");
                              }
                              
                            }//FinValido
                    siNoValido = false;
                            while (!siNoValido){
                                System.out.println("Desea seguir comprando productos?Si/No");
                                siNo = input.next();

                            if (siNo.equalsIgnoreCase("si") ||siNo.equalsIgnoreCase("no") )
                            {
                            siNoValido = true;
                            }
                            else {System.out.println("Ingresa Si/No");
                            siNoValido = false;}
                            
                            }
                        }
                        }//Fin cliente B
                        
                        
                        
                        else if(clienteIngresado.equalsIgnoreCase("C"))
                        {
                        siNo = "si"; //Para que se reinicie la seleccion de siNo
                            while (siNo.equalsIgnoreCase("si")){   
                            valido = false;
                            System.out.println("Ingrese codigo del producto a comprar");
                            while (!valido) {
                              try {
                                  productoElegidoCliente =0;//Resetear producto elegido por si elige que si
                                  productoElegidoCliente = input.nextInt();

                                  if (productoElegidoCliente >= 1 && productoElegidoCliente <= 4) {//Revisa que el cliente este dentro del 1-4
                                      valido = true;
                                  } else {
                                      System.out.println("Código inválido. Debe ser un número del 1 al 4.");
                                      valido = false;
                                  }
                              } catch (InputMismatchException e) {
                                  System.out.println("Ingrese un número válido.");
                                  input.next(); // limpia el scanner
                              }
                              

                              
                              if (productoElegidoCliente == 4) 
                                //Para que tengan la misma logica todos lo hice individual
                              {
                              //Pedir cantidad en KG y restar eso de stock SOLO SI HAY STOCK SUFICIENTE
                              valido = false;
                              while (!valido) {
                              System.out.println("Ingresar cantidad de producto a comprar(KG)");
                                try {
                                cantidadElegidaCliente = input.nextDouble();
                                    if (cantidadElegidaCliente >= 0 && cantidadElegidaCliente <= stockProducto4 ) //Comparar cada uno de los que pueda elegir)?
                                    {
                                        stockProducto4 -= cantidadElegidaCliente;
                                        subTotal += (cantidadElegidaCliente * precioProducto4);                                        
                                        facturacion = facturacion + 
                                                "\nCodigo: 4" + 
                                                "   Nombre Producto: Maiz"+ 
                                                "   Precio Unitario: "+precioProducto4+
                                                "   Cantidad: "+cantidadElegidaCliente;
                                        
                                        valido = true;
                                    }
                                    else 
                                    {
                                        System.out.println("No hay stock suficiente de ese producto");
                                    }
                                    
                                }
                                catch (InputMismatchException e) 
                                {
                                    System.out.println("Ingrese un numero valido");
                                }
                              } //Fin while valido
                              }//Fin if 4

                              
                              
                              
                              else if (productoElegidoCliente == 1 || productoElegidoCliente ==2 || productoElegidoCliente ==3)//Agregar un else if para que si elige x producto que no sea los permitidos entonces hacer eso  
                              {
                              System.out.println("No puede comprar dicho producto");
                              }
                              
                            }//FinValido
                    siNoValido = false;
                            while (!siNoValido){
                                System.out.println("Desea seguir comprando productos?Si/No");
                                siNo = input.next();

                            if (siNo.equalsIgnoreCase("si") ||siNo.equalsIgnoreCase("no") )
                            {
                            siNoValido = true;
                            }
                            else {System.out.println("Ingresa Si/No");
                            siNoValido = false;}
                            
                            }
                        }
                        }//Fin C
                        int cantidadDesc = 0;
                        if (subTotal >=1000 &&  subTotal<=5000)  {
                            descuento = subTotal * 0.05;
                            cantidadDesc =5;
                            
                        }
                        else if (subTotal>5000) {
                        descuento = subTotal * 0.1;
                        cantidadDesc = 10;
                        
                        
                        }
                        
                        
                        //-----------------FACTURACION DESPUES DE TODO-------------------------
                        impuesto = 0.07 * subTotal;
                        total = (subTotal - descuento)+impuesto;
                        facturacion = facturacion + "\n-------------------"+ 
                                "\nsubTotal:Lps."+String.format("%.2f", subTotal)+
                                "\nImpuesto:Lps."+String.format("%.2f",impuesto)+
                                "\nDescuento:Lps."+String.format("%.2f",descuento)+
                                "\nPorcentaje de descuento:"+cantidadDesc+"%"+
                                "\nTotal:Lps."+String.format("%.2f",total);
                        
                        System.out.println(facturacion);
                        cajaEfectivoV+=total;
                        cajaEfectivoT+=total;
                    }//Caja estado true
                            
                        
                        
                    else 
                    {
                     System.out.println("La caja ocupa estar abierta para realizar esta accion");
                    }

                break;
                
                
            case 3://Compras
                if (cajaEstado == true)
                {
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| Codigo | Producto | Precio Compra | Proveedor |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 1      | Azucar   |Lps.25         | A         |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 2      | Avena    |Lps.20         | B         |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 2      | Avena    |Lps.22         | C         |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 3      | Trigo    | Lps.30        | B         |");
                        System.out.println("+--------+----------+---------------+----------+");
                        System.out.println("| 4      | Maiz     | Lps.18        | A         |");
                        
                        String tipoProveedor = "";
                        int productoElegidoUsuario =0;
                        boolean productoPermitido = false;
                        
                        valido = false;
                        

                        //--------------------------------------------------------------------
                        //Intentare optimizar el codigo de arriba , despues solo es usarlo como guia
                        //TIPO DE PROVEEDOR
                        while (valido ==false){
                            System.out.println("Ingrese el tipo de proveedor (A,B,C):");
                            tipoProveedor = input.next();
                            if (!tipoProveedor.equalsIgnoreCase("A") && !tipoProveedor.equalsIgnoreCase("B")&& 
                                !tipoProveedor.equalsIgnoreCase("C") )
                            {
                            System.out.println("Ingrese un cliente valido");
                            }
                            else 
                            {
                            valido = true;
                            }
                        }
                        //----------------------------------------------------------------------------
                        valido = false;
                        boolean numeroValido = false;
                        
                        while (numeroValido==false){
                            try{
                            while (numeroValido == false){
                                System.out.println("Escriba el codigo del producto que comprara:");
                            productoElegidoUsuario = input.nextInt();
                            switch (tipoProveedor.toUpperCase())
                                {
                                    case "A":
                                        productoPermitido = (productoElegidoUsuario == 1 || productoElegidoUsuario == 4);
                                        numeroValido = true;
                                        /*
                                        *La manera en la que esto funciona es que si declaro esas condiciones (Lo de arribas)
                                        y no se cumplen cuando lo compare con lo que voy a pedir de productoElegidoUsuario 
                                        entonces me va a retornar un false y lo seguire validando con eso
                                        */
                                        break;
                                    case "B":
                                        productoPermitido = (productoElegidoUsuario == 2 || productoElegidoUsuario ==3);
                                        numeroValido = true;
                                        break;
                                    case "C":
                                        productoPermitido = (productoElegidoUsuario ==2);
                                        numeroValido = true;
                                        break;
                                    default:
                                        System.out.println("Proveedor no valido");
                                    }
                            }

                                if (!productoPermitido)
                                {
                                    System.out.println("Este proveedor no vende ese producto");
                                    

                                }
                                else if (productoPermitido)
                                {
                                    double cantidadKG = 0;
                                    
                                    while (true)
                                    {
                                        try
                                        {
                                            System.out.println("Ingrese la cantidad a comprar(KG)");
                                            cantidadKG = input.nextDouble();
                                            if (cantidadKG < 0)
                                            {
                                                System.out.println("No puedes usar numeros negativos");
                                            }
                                            else if (cantidadKG >= 0)
                                            {
                                                double costoUnitario =0;
                                                double costoTotal = 0;
                                                switch(tipoProveedor.toUpperCase())
                                                {
                                                    case "A":
                                                        if (productoElegidoUsuario==1)
                                                        {
                                                            costoUnitario = 25;
                                                        }
                                                        else if(productoElegidoUsuario==4)
                                                        {
                                                            costoUnitario =18;
                                                        }
                                                        break;
                                                    case "B":
                                                        if (productoElegidoUsuario==2)
                                                        {
                                                            costoUnitario = 20;
                                                        }
                                                        else if(productoElegidoUsuario==3)
                                                        {
                                                            costoUnitario =30;
                                                        }
                                                        break;
                                                    case "C":
                                                        if (productoElegidoUsuario==2)
                                                        {
                                                            costoUnitario = 22;
                                                        }
                                                        break;
                                                            
                                                }
                                              costoTotal = costoUnitario * cantidadKG;
                                              
                                              if (costoTotal <= cajaEfectivoT)
                                              {
                                                  String nombreP = "";
                                                  cajaEfectivoT -= costoTotal;
                                                  if (productoElegidoUsuario==1) 
                                                  {
                                                      stockProducto1 += cantidadKG;
                                                      nombreP = "Azucar";
                                                  }
                                                  else if (productoElegidoUsuario==2)
                                                  {
                                                      stockProducto2 += cantidadKG;
                                                      nombreP = "Avena";
                                                  }
                                                  else if (productoElegidoUsuario==3)
                                                  {
                                                      stockProducto3 += cantidadKG;
                                                      nombreP = "Trigo";
                                                  }
                                                  else if (productoElegidoUsuario==4)
                                                  {
                                                      stockProducto4 += cantidadKG;
                                                      nombreP = "Maiz";
                                                  }
                                              

                                                //Logica de facturacion)?
                                                String facturacion = "---Factura---";
                                                
                                                
                                                facturacion = facturacion + 
                                                "\nCodigo: " +productoElegidoUsuario+ 
                                                "   Nombre Producto: "+ nombreP + 
                                                "   Precio Unitario: "+ costoUnitario +
                                                "   Cantidad: "+cantidadKG +" KG"+
                                                "\nTotal:Lps "+String.format("%.2fn",costoTotal);
                                                
                                              
                                              
                                              
                                              }//FinIfCostoTotal
                                              else 
                                              {
                                                  System.out.println("Fondos Insuficientes");
                                                  break;
                                              }
                                            
                                            
                                            
                                            
                                            } 
                                            
                                        }
                                        
                                        catch(InputMismatchException e)
                                        {
                                            System.out.println("Ingrese una cantidad valida");
                                        }
                                    }
                                }
                                
                            }
                            
                            catch (InputMismatchException e)
                            {
                                System.out.println("Ingrese un numero valido");
                                input.next();
                            }
                       
                        }//fin valido false para producto elegido usuario 
                            
                            
                            
                                        
      
                }//Estado caja True

 
                
                break;
            case 4://Facturacion
                System.out.println("Facturacion");
                break;
            case 5://Cerrar Caja
                System.out.println("Cerrar Caja");
                break;
            case 6:
                System.out.println("Salir del programa");
                break;
            default:
                System.out.println("Elige una opcion valida");
                break;
        
        }//Switch
        }//Seguir

    
    }//Static void
    
}