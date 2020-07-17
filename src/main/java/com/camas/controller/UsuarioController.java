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
        usuario = new Usuario();
    }
    
    public void registrar(){
        try{
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"","Registro Exitoso"));
        } catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"","Error"));
        
        }
        
    }
}
