
import Business.ProducerFactory;
import Business.AbstractFactory;
import Business.IConnection;
import Model.Computer;
import Model.ComputerComponents;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class NewMain {
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, ParserConfigurationException, SAXException {
            
        //get factory
        AbstractFactory elementFactory = ProducerFactory.getFactory(true);
        //Obtener conexión con el objeto XML.
        IConnection computerXML = elementFactory.getConnection("xml");
        
        //Call method getAll
        computerXML.getAll().forEach(computer -> {
            computer.getComponents().forEach(component -> {
                System.out.println(
                "Computador xml: [Descripcion : " + computer.getDescripcion()+ ", nombre : " + computer.getName() + ", nombre componente : " + component.getComponentName() +", referencia componente : " + component.getComponentReference() + " ]"
                );            
            });            
        });
        
        
        
        // Realizar consultar para obtener los valores desde archivo JSON
        List<ComputerComponents> computerComponent = new ArrayList<>();     
        computerComponent.add(new ComputerComponents("g", "g"));
        Computer comp = new Computer("f","f", computerComponent);        
        //Obtener conexión con el objeto JSON.
        IConnection computerJSON = elementFactory.getConnection("json");
        computerJSON.save(comp);
        computerJSON.getAll().forEach(computer -> {            
            computer.getComponents().forEach(component -> {
                System.out.println("Computador json: [Descripcion : " + computer.getDescripcion()+ ", Name : " + computer.getName() + ", nombre componente : " + component.getComponentName() + ", referencia : " + component.getComponentReference() + " ]");                
            });            
        });
        
    }    
}
