
import Business.ProducerFactory;
import Business.AbstractFactory;
import Business.IConnection;
import Model.Computer;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        //get an object of Connection xml
        IConnection computer = elementFactory.getConnection("xml");
            
        //Call method getAll
        computer.getAll().forEach(c -> {
            System.out.println("Computador xml: [Descripcion : " + c.getDescripcion()+ ", Name : " + c.getName() + " ]");
        });
           
        Computer comp = new Computer("f","f");

        
        //get an object of Connection xml
        IConnection computer2 = elementFactory.getConnection("json");
        computer2.save(comp);
        computer2.getAll().forEach(c -> {
                System.out.println("Computador json: [Descripcion : " + c.getDescripcion()+ ", Name : " + c.getName() + " ]");
        });
        
        
    }
    
}
