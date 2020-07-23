package com.camas.model;

import java.sql.*;

public interface CONFIGURABLE {
	public final String user = "postgres";
	public final String psw = "123";
	public final String bd = "RELACIONAL_PROYECTO";
	public final String driver = "org.postgresql.Driver";
	public final String ip = "localhost:5432";
	public final String url = "jdbc:postgresql://" + ip + "/" + bd + "";

	public abstract Connection cadenaConexion();

	public abstract void cerrarConexion();

}
