package com.camas.model;



import com.camas.model.CONEXION;
import java.sql.SQLException;
import java.sql.Statement;

public class UPDATE extends CONEXION {

	public boolean update(String query) {
		try {
			stmt = (Statement) cadenaConexion().createStatement();
			stmt.executeUpdate(query);
			cerrarConexion();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
