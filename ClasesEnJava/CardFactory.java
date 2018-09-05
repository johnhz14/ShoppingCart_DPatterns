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
public class CardFactory {
    
    
    //Dependiendo del tipo requerido se creara la clase de tarjeta solicitada con los demas parametros
    public Card createCard(String type,String name, String cardNumber, String cvv, String dateOfExpiry){
        
        if(type.equals("creditCard")){
        
            return new CreditCardStrategy(name,cardNumber,cvv,dateOfExpiry);
        
        
        }else if (type.equals("debitCard")){
            return new DebitCardStrategy(name,cardNumber,cvv,dateOfExpiry);
            
        
        
        
        }
    
    return null;
    }
    
}
