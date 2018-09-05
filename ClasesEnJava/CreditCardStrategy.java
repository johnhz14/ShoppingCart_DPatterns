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
public class CreditCardStrategy implements PaymentStrategy,Card{

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }
    
    
    
    @Override
    public void pay(int amount) {
       
        System.out.println(amount+"Paid using creditCard");   
        
    }
    
    
}
