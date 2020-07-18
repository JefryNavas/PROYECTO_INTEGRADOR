/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camas.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jeffry
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    @Column(name = "id_perfil")
    private int perfil;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contraseña")
    private String contraseña;

    public Usuario(int perfil) {
        this.perfil = perfil;
    }
    
    public Usuario() {
      
    }

    public int getPerfil() {
        return perfil;
    }
    
    
    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

   
    public String getUsuario() {
        return usuario;
    }

    
 

    public int getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    

}
