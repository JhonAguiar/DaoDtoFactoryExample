/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author user
 */
public class ProducerFactory {
    public static AbstractFactory getFactory(boolean eval){   
      
        return new ConnectionDocFactory();         
      
   }
}
