/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessData;

import Model.Computer;
import Model.ComputerComponents;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author user
 */
public class JsonComputerDao implements Dao<Computer> {
    
    private List<Computer> computer ;
    private List<ComputerComponents> computerComponent;
    JSONParser parser = new  JSONParser();
    
    public JsonComputerDao() throws FileNotFoundException, IOException, ParseException{
        if(computer == null ){
            computer = new ArrayList<Computer>();
            //Object obj = parser.parse(new FileReader("C:\\Users\\user\\Documents\\NetBeansProjects\\Computadores\\src\\main\\java\\Computadores.json"));
            Object obj = parser.parse(new FileReader("D:\\02 Projects And Learning\\DaoDtoFactoryExample\\Documents\\NetBeansProjects\\Computadores\\src\\main\\java\\Computadores.json"));
            JSONObject computersJson = (JSONObject) obj;

            JSONArray computerArray = (JSONArray) computersJson.get("computadores");

            for(int computerItem = 0 ; computerItem < computerArray.size() ; computerItem++) {                
                JSONObject computerJson = (JSONObject)computerArray.get(computerItem);
                // Recuperar lista de componentes del computador del objeto computador
                JSONArray componentArray = (JSONArray) computerJson.get("components");                
                for (int componentItem = 0; componentItem < componentArray.size(); componentItem++) {
                    JSONObject componentJson = (JSONObject)componentArray.get(componentItem);
                    // Agregar en la lista los componentes de cada computador.
                    computerComponent.add(
                        new ComputerComponents(
                                String.valueOf(componentJson.get("")),
                                String.valueOf(componentJson.get(""))
                        )                            
                    );                    
                }
                // Agregar objeto tipo lista para el computador.
                computer.add(
                    new Computer(
                        String.valueOf(computerJson.get("name")),
                        String.valueOf(computerJson.get("descripcion")),
                        computerComponent                        
                    )
                );
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
