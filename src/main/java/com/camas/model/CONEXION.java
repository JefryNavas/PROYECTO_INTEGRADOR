package com.camas.model;

import com.camas.model.CONFIGURABLE.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.*;
import java.sql.*;
import java.sql.Statement;

public class CONEXION implements CONFIGURABLE {
	private Connection conexion = null;
	protected Statement stmt = null;
	protected ResultSet res = null;

	
	public Connection cadenaConexion() {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, psw);
			if (conexion != null) {
				System.out.println("Conexion Establecida...");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conexion;
	}

	
	public void cerrarConexion() {
		// TODO Auto-generated method stub
		try {
			if (conexion != null) {
				conexion.close();
			}
			if (stmt != null) {
				stmt.close();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
