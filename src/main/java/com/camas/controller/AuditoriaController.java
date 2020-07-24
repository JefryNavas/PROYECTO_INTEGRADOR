/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camas.controller;


import com.camas.dao.DaoAuditoria;
import com.camas.model.Auditoria;
import java.sql.SQLException;
import java.util.ArrayList;



public class AuditoriaController {

        
  
        public ArrayList<Auditoria> ImprimirAuditoria() throws SQLException {
		DaoAuditoria daousuario;
		daousuario = new DaoAuditoria();
		return daousuario.totalAuditoria();
	}
        
    
}
