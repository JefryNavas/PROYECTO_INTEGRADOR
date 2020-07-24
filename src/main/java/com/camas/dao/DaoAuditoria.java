package com.camas.dao;

import com.camas.model.Auditoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.camas.model.Cls_conexion;
import java.util.Date;

public class DaoAuditoria {
	ResultSet re;
	public ArrayList<Auditoria> totalAuditoria() throws SQLException {
		ArrayList<Auditoria> auditoria = new ArrayList<>();

		
		Cls_conexion cl = new Cls_conexion();
		re = cl.consulta("select * from tb_auditoria");
		Integer id;
		String tabla;
		String operacion;
		String valorA;
		String valorN;
		Date fecha;
                String usuario;
		while (re.next()) {
			id = re.getInt("id_aud");
			tabla = re.getString("tabla_aud");
			operacion = re.getString("operacion_aud");
			valorA = re.getString("valoranterior_aud");
			valorN = re.getString("valornuevo_aud");
			fecha = re.getDate("fecha_aud");
                        usuario = re.getString("usuario_aud");
			auditoria.add(new Auditoria(id,tabla,operacion,valorA,valorN,fecha,usuario));
			
		}
		return auditoria;
		
	}

}
