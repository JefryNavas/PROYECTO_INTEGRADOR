
package com.camas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.camas.model.Cls_conexion;
import com.camas.model.Reportes;


public class DaoReportes {
    
public List<Reportes>consultaxProvincia() {
		String sql = "select dim_ubicacion.provincia,\n" +
"SUM(fact_camas.total_dotacion_camas + fact_camas.total_camas_disponibles) as camas_hospitalarias_por_provincia\n" +
"from fact_camas, dim_ubicacion\n" +
"where dim_ubicacion.sk_ubicacion = fact_camas.sk_ubicacion\n" +
"Group by dim_ubicacion.provincia\n" +
"order by camas_hospitalarias_por_provincia desc;";
		
		ResultSet rs = null;
		List<Reportes> datos = new ArrayList<Reportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				Reportes dr= new Reportes();
                                dr.setDatos(rs.getString(1));
				dr.setContador(rs.getInt(2));
				

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}

        public List<Reportes>consultaxAno() {
		String sql = "select anio, sum(total_camas_disponibles) as Camas_Disponibles\n" +
"from dim_tiempo, fact_camas\n" +
"where dim_tiempo.sk_tiempo = fact_camas.sk_tiempo\n" +
"group by anio\n" +
"order by Camas_disponibles desc;";
		
		ResultSet rs = null;
		List<Reportes> datos = new ArrayList<Reportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				Reportes dr= new Reportes();
                                dr.setDatos(rs.getString(1));
				dr.setContador(rs.getInt(2));
				

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
                public List<Reportes>consultaxEstablecimiento() {
		String sql = "select dim_establecimiento.entidad_establecimiento,\n" +
"SUM(fact_camas.total_dotacion_camas + fact_camas.total_camas_disponibles) as camas_hospitalarias_por_provincia\n" +
"from fact_camas, dim_establecimiento\n" +
"where dim_establecimiento.sk_establecimiento = fact_camas.sk_establecimiento\n" +
"Group by dim_establecimiento.entidad_establecimiento\n" +
"order by camas_hospitalarias_por_provincia desc;";
		
		ResultSet rs = null;
		List<Reportes> datos = new ArrayList<Reportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				Reportes dr= new Reportes();
                                dr.setDatos(rs.getString(1));
				dr.setContador(rs.getInt(2));
				

				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
}
