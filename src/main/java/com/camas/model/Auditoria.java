/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camas.model;

import java.util.Date;

/**
 *
 * @author luisfer
 */
public class Auditoria{
    
    private int id;
    private String tabla;
    private String operacion;
    private String valorA;
    private String valorN;
    private Date fecha;
    private String usuario;

    public Auditoria(int id,String tabla, String operacion, String valorA, String valorN, Date fecha, String usuario) {
        this.id = id;
        this.tabla = tabla;
        this.operacion = operacion;
        this.valorA = valorA;
        this.valorN = valorN;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Auditoria() {
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
    
    

    
}
