/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author crisc
 */
public class ComputerComponents {
    private String componentName;
    private String componentReference;
           
    public ComputerComponents(String componentName, String componentReference){
        this.componentName = componentName;
        this.componentReference = componentReference;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentReference() {
        return componentReference;
    }

    public void setComponentReference(String componentReference) {
        this.componentReference = componentReference;
    }    
}
