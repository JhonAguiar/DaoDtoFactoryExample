/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import AccessData.Dao;
import AccessData.JsonComputerDao;
import Model.Computer;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;


/**
 *
 * @author user
 */
public class JsonConnectionFactory implements IConnection{
    private static Dao<Computer> jsonComputerDao;
    
    @Override
    public void getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Computer> getAll() {
        
        try {
            jsonComputerDao = new JsonComputerDao();
        } catch (IOException ex) {
            Logger.getLogger(JsonConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JsonConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Computer> computer = jsonComputerDao.getAll();
        
        return computer;

    }

    @Override
    public void save(Computer c) {
        try {
            jsonComputerDao = new JsonComputerDao();
        } catch (IOException ex) {
            Logger.getLogger(JsonConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JsonConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsonComputerDao.save(c);
        
    }
    
}
