
package com.camas.controller;

import com.camas.model.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class VerificarController implements Serializable{
    
    
    
    public void verificarSesion(){
        try{
            FacesContext context = FacesContext.getCurrentInstance();
             Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
             if(us == null){
                   context.getExternalContext().redirect("permisos.xhtml");
             }
        }catch(Exception e){
            
        }
    }
    
  public void cerrarSesion(){
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  }
    
}

  