/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camas.bean;

import com.camas.controller.AuditoriaController;
import com.camas.model.Auditoria;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Jeffry
 */

@Named(value = "Auditoriabean")
@SessionScoped
public class AuditoriaBean implements Serializable{
    
        
    private static final long serialVersionUID = 1L;
    private int id;
    private String tabla;
    private String operacion;
    private String valorA;
    private String valorN;
    private Date fecha;
    private String usuario;

    private Auditoria auditoria = new Auditoria();

    public AuditoriaBean() {
    }

    

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getValorA() {
        return valorA;
    }

    public void setValorA(String valorA) {
        this.valorA = valorA;
    }

    public String getValorN() {
        return valorN;
    }

    public void setValorN(String valorN) {
        this.valorN = valorN;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    public ArrayList<Auditoria> listaAuditoria() throws SQLException {
		AuditoriaController controller = new AuditoriaController();
		return controller.ImprimirAuditoria();
	}
    
}
