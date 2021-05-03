/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author user
 */
public class Computer {
    private String name;
    private String descripcion;
    private List<ComputerComponents> components;    

    public Computer(String name, String descripcion, List<ComputerComponents> components) {
        this.name = name;
        this.descripcion = descripcion;
        this.components = components;
    }

    public List<ComputerComponents> getComponents() {
        return components;
    }

    public void setComponents(List<ComputerComponents> components) {
        this.components = components;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
 
    
    
}
