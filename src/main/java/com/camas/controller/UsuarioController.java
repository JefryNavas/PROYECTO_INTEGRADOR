package com.camas.controller;

import com.camas.ejb.UsuarioFacadeLocal;
import com.camas.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    @PostConstruct
    public void init(){
        usuario = new Usuario(1);
    }
    
    public void registrar(){
        try{
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"","Registro Exitoso"));
        } catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"","Error"));
        
        }
        
    }
    
     public String iniciarSesion(){
        Usuario us;
        String redireccion = null;
        try{
           us = usuarioEJB.iniciarSesion(usuario);
           if(us!=null && us.getPerfil()==1){
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
               redireccion = "principal?faces-redirect=true";
           } else if(us!=null && us.getPerfil()==2){
               redireccion = "menu_administrador?faces-redirect=true";
                 } else {
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"","Usuario Incorrecto"));
           }
        }catch(Exception e){
             FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"","ERROR"));
        }
        return redireccion;
    }
     
     public String mostrarUsuarioLogeado(){
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           return us.getUsuario();
}

}
