/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2_carrito_compras;

/**
 *
 * @author johnh
 */

//Fuente : https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial
public interface PaymentStrategy {
    
    public void pay(int amount);
    
}
