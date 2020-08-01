/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camas.model;

/**
 *
 * @author Jeffry
 */
public class Reportes {
    
        private String datos;
        private int contador;
	
	
	public Reportes() {
		
	}
	
	public Reportes(String datos,int contador) {
		this.contador = contador;
		this.datos = datos;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}
	
}
