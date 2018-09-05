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
public class PaypalStrategy implements PaymentStrategy {

    private String emailId;
    private String password;

    public PaypalStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }  
   
    
    @Override
    public void pay(int amount) {
        System.out.println(amount+" Paid using Paypal");
    }
    
}
