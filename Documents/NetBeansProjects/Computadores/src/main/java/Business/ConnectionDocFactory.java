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
public class ConnectionDocFactory extends AbstractFactory {

    @Override
    public IConnection getConnection(String connectionType) {
        if(connectionType.equalsIgnoreCase("json")){
         return new JsonConnectionFactory();         
        }else if(connectionType.equalsIgnoreCase("xml")){
         return new XmlConnectionFactory();
        }
        return null;
    }
    
}
