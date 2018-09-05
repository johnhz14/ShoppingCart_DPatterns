/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2_carrito_compras;

import java.util.Iterator;
import java.util.Scanner;

/**
  John Hernandez   --   Victor Restrepo
  *             23/02/18
 */
public class CarritoCompra{
    Scanner entrada = new Scanner(System.in);
    Stack<Producto> productos = new Stack<>();
//Como el objetivo del proyecto es realizar un carrito de compras adaptando  la clase pila a su funcionamiento
//Procedemos a implementar la clase pila donde se almacenaran los distintos items y hacemos que implementa la
//interfaz iterable para que nos permita iterar sobre los distintos items de la pila o en este caso carrito
    private class Stack<Item> implements Iterable<Item> {

        private Node first;
        int N;

        private class Node {

            Item item;
            Node next;

        }
         //Para relacionar el funcionamiento de la pila con un carrito de compra, creamos el metodo moveToPeak
          //El cual se encargara de colocar un item al inicio de la lista.Ya que las pilas solo remueven el primer item


        public Boolean moveToPeak(String nombreProducto) {
            for (Node i = first; i != null; i = i.next) {

                if (nombreProducto.equals(((Producto) i.item).nombre)) {
                    //CICLOS Y CONDICIONAl para ubicarlo el elemento encontrado de primero
                    if (i != first) {

                        Node anterior = first;
                        while (anterior.next != i) {
                            anterior = anterior.next;
                        }
                     
                        //ya tenemos el anterior
                        anterior.next = i.next;
                        i.next = first;
                        first=i;

                    }

                    return true;

                }

            }

            return false;
        }

        public void push(Item x) {
            Node n = new Node();
            n.item = x;
            n.next = first;
            first = n;
            N++;
        }

        public Item pop() {
            if (first == null) {
                System.out.println("Pila vacia");
                return null;
            }
            Item i = first.item;
            first = first.next;
            N--;
            return i;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return N;
        }
//PATRON ITERABLE
        //Implementacion de los metodos para hacer la clase iterable(next, hasnext,etc)
        public Iterator<Item> iterator() {
            return new IteradorDePila();
        }

        private class IteradorDePila<Item> implements Iterator<Item> {

            Node i = first;

            public boolean hasNext() {
                return i != null;
            }

            public Item next() {
                Item x = (Item) i.item;
                i = i.next;
                return x;

            }

            public void Remove() {
            }

        }

    }

    //constructor   
    public CarritoCompra() {
    }

    public void agregarAlCarrito() {
        String nombre;
        int cantidad, precio;
        System.out.println("Nombre producto: ");
        nombre = entrada.next();
        do{
        System.out.println("Cantidad: ");
        cantidad = entrada.nextInt();
        if(cantidad<=0) System.out.println("La cantidad debe ser mayor a 0");
        }while(cantidad<=0);
        do{
        System.out.println("Precio: ");
        precio = entrada.nextInt();
        if(precio<=0) System.out.println("El precio debe ser mayor a 0");
        }while(precio<=0);
        
        

        Producto producto = new Producto(nombre, cantidad, precio);

        // addproducto
        productos.push(producto);
    }

    public void removerProducto() {
        String nombre;
        System.out.println("Nombre producto: ");
        nombre = entrada.next();

        if (!productos.moveToPeak(nombre)) {
            System.out.println("El producto no esta en el carrito");

        } else {
            System.out.println("Se ha eliminado el producto:" + productos.pop().nombre);
        }
        // busco el producto con el nombre, si no lo encuentra digo que no estaba en la coleccion
        //si lo encuentra eliminarlo

    }

    public void modificarCantidad() {
        String nombre;
        int cantidad;
        System.out.println("Nombre producto: ");
        nombre = entrada.next();
        System.out.println("Nueva cantidad del producto:");
        cantidad = entrada.nextInt();

        for (Producto i : productos) {

            if (nombre.equals(i.nombre)) {
                i.setCantidad(cantidad);

            }
        }

    }

    public void listar() {
        //recorro con un ciclo for each/for e imprimir el atributo nombre, cantidad,valor total;     
        System.out.println("------------------PRODUCTOS------------------");
        for (Producto i : productos) {
            System.out.println(i.toString());
        }

    }
//haremos el metodo int para adaptarlo al nuevo metodo de pago
    public int  precioTotal() {
        //crear suma, recorrer la coleccion y sumar el precioTotal de cada producto
        int total =0;
        for(Producto i:productos){
        total+=i.precioTotal;
        
        }
       // System.out.println("PRECIO TOTAL DE LOS PRODUCTOS DEL CARRITO ES:"+total);
          return total;      
    }
    
    //Creamos el metodo para realizar el pago PATRON STRATEGY
    public void pay(PaymentStrategy paymentMethod){
    int amount= precioTotal();
    paymentMethod.pay(amount);
    
    }

    private class Producto {

        public String nombre;
        public int cantidad, precio, precioTotal;

        public Producto(String nombre, int cantidad, int precio) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.precio = precio;
            this.precioTotal = cantidad * precio;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
            this.precioTotal = cantidad * precio;
        }

        @Override
        public String toString() {
            return "Nombre=" + nombre + ", Cantidad=" + cantidad + ", Precio Unitario=" + precio + ", precioTotal=" + precioTotal;
        }

    }

}
