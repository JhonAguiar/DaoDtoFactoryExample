/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessData;

import Model.Computer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author user
 */
public class XmlComputerDao implements Dao<Computer> {
    
    private List<Computer> computer = new ArrayList<>();
    
    public XmlComputerDao() throws ParserConfigurationException, SAXException, IOException{
        File file = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\Computadores\\src\\main\\java\\Computadores.xml"); 
        computer = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);  
        doc.getDocumentElement().normalize();
        
        NodeList nodeList = doc.getElementsByTagName("part"); 

        for (int itr = 0; itr < nodeList.getLength(); itr++)   
        {  
            Node node = nodeList.item(itr);  
            //System.out.println("\nNode Name :" + node.getNodeName());  
            if (node.getNodeType() == Node.ELEMENT_NODE)   
            {  
                Element eElement = (Element) node;  
                computer.add(new Computer(eElement.getElementsByTagName("name").item(0).getTextContent() , eElement.getElementsByTagName("descripcion").item(0).getTextContent()));
            }
        }
    }
    
    @Override
    public List<Computer> getAll() {
        return computer;
    }

    @Override
    public void save(Computer t) {
        computer.add(t);
    }

    @Override
    public void update(Computer t, String[] params) {
        t.setName(Objects.requireNonNull(
          params[0], "Nombre no puede ser nulo"));
        t.setDescripcion(Objects.requireNonNull(
          params[1], "Descripcion no puede ser nula"));
        
        computer.add(t);
    }

    @Override
    public void delete(Computer t) {
        computer.remove(t);
    }
    
}
