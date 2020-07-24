package com.camas.controller;

import com.camas.ejb.UsuarioFacadeLocal;
import com.camas.model.Usuario;
import java.io.Serializable;
import java.util.List;
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
    private int perfil;
    private List<Usuario> usuariolist;
    private String accion;

    public UsuarioController() {
    }
   
    
    
    @PostConstruct
    public void init(){
        usuariolist = usuarioEJB.findAll();
        usuario = new Usuario(1);
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    
    
    
    public Usuario getUsuario() {
        return usuario;
        
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuariolist() {
        return usuariolist;
    }

    public void setUsuariolist(List<Usuario> usuariolist) {
        this.usuariolist = usuariolist;
    }

    
    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public void registrar(){
        
        try{
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"","Registro Exitoso"));
        } catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"","Error"));
        
        }
        
    }
    public void crearUsuario(){
        
        try{
           if(perfil==1){
                usuarioEJB.create(usuario);
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"","Registro Exitoso"));
           
           
           } else if(perfil==2){
                
                usuario.setPerfil(2);
               usuarioEJB.create(usuario);
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"","Registro Exitoso"));
           
           }
               
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
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
               redireccion = "menu_administrador?faces-redirect=true";
                 } else {
           FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,""," Usuario Incorrecto"));
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
     public String mostrarUsuarioNombre(){
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           return us.getNombres();
}
     public String mostrarUsuarioApellido(){
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           return us.getApellidos();
}
     public void leer(Usuario Useleccion){
          usuariolist = usuarioEJB.findAll();
         usuario = Useleccion;
            
         
     }
     
     public void modificar(){
         usuarioEJB.edit(usuario);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"","Usuario modificado"));
           
     }
     public void eliminar(Usuario us){
         usuarioEJB.remove(us);
      FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"","Usuario Eliminado"));
           
     }
     
}
