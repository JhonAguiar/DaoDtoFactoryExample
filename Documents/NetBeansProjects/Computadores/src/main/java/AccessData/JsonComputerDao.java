/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessData;

import Model.Computer;
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
    JSONParser parser = new  JSONParser();
    
    public JsonComputerDao() throws FileNotFoundException, IOException, ParseException{
        if(computer == null ){
            computer = new ArrayList<Computer>();
            Object obj = parser.parse(new FileReader("C:\\Users\\user\\Documents\\NetBeansProjects\\Computadores\\src\\main\\java\\Computadores.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray array = (JSONArray) jsonObject.get("computadores");

            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                //computer.add(new Computer()));
                //String.valueOf(jsonObject1.get("name")),String.valueOf(jsonObject1.get("description")
                computer.add(new Computer(String.valueOf(jsonObject1.get("name")) , String.valueOf(jsonObject1.get("descripcion"))));
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
