package com.camas.model;



import java.sql.ResultSet;
import java.sql.SQLException;

public class QUERY extends CONEXION {

	public ResultSet consulta(String query) {
		try {
			stmt = (java.sql.Statement) cadenaConexion().createStatement();
			res = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
}
