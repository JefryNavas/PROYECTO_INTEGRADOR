
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
		String sql = "select dim_tiempo.anio,\n" +
"SUM(fact_camas.total_dotacion_camas + fact_camas.total_camas_disponibles) as total_camas_hospitalarias_por_año\n" +
"from dim_tiempo, fact_camas\n" +
"where dim_tiempo.sk_tiempo = fact_camas.sk_tiempo\n" +
"group by dim_tiempo.anio;";
		
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
                public List<Reportes>consultaAniobarra() {
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
                
                
                public List<Reportes>consultaANIO2017() {
		String sql = "SELECT\n" +
"DIM_UBICACION.PROVINCIA,\n" +
"SUM (FACT_CAMAS.TOTAL_CAMAS_DISPONIBLES + FACT_CAMAS.TOTAL_DOTACION_CAMAS) AS TOTAL_CAMAS,\n" +
"DIM_TIEMPO.ANIO\n" +
"FROM FACT_CAMAS, DIM_TIEMPO,DIM_UBICACION\n" +
"WHERE DIM_TIEMPO.ANIO = 2017\n" +
"AND DIM_TIEMPO.SK_TIEMPO = FACT_CAMAS.SK_TIEMPO\n" +
"AND DIM_UBICACION.SK_UBICACION = FACT_CAMAS.SK_UBICACION\n" +
"GROUP BY DIM_UBICACION.PROVINCIA,DIM_TIEMPO.ANIO\n" +
"ORDER BY TOTAL_CAMAS DESC;";
		
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
                        public List<Reportes>consultaANIO2018() {
		String sql = "SELECT\n" +
"DIM_UBICACION.PROVINCIA,\n" +
"SUM (FACT_CAMAS.TOTAL_CAMAS_DISPONIBLES + FACT_CAMAS.TOTAL_DOTACION_CAMAS) AS TOTAL_CAMAS,\n" +
"DIM_TIEMPO.ANIO\n" +
"FROM FACT_CAMAS, DIM_TIEMPO,DIM_UBICACION\n" +
"WHERE DIM_TIEMPO.ANIO = 2018\n" +
"AND DIM_TIEMPO.SK_TIEMPO = FACT_CAMAS.SK_TIEMPO\n" +
"AND DIM_UBICACION.SK_UBICACION = FACT_CAMAS.SK_UBICACION\n" +
"GROUP BY DIM_UBICACION.PROVINCIA,DIM_TIEMPO.ANIO\n" +
"ORDER BY TOTAL_CAMAS DESC;";
		
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
                        public List<Reportes>consultaxMESES2017() {
		String sql = "select \n" +
"dt.nombre_mes,\n" +
"SUM (FC.TOTAL_CAMAS_DISPONIBLES + fc.total_dotacion_camas) AS total_camas,\n" +
"dt.anio,\n" +
"dt.mes\n" +
"FROM DIM_TIEMPO AS DT,FACT_CAMAS AS FC\n" +
"WHERE dt.anio = 2017 \n" +
"and DT.SK_TIEMPO = FC.SK_TIEMPO\n" +
"GROUP BY DT.ANIO,dt.nombre_mes,dt.mes\n" +
"order by anio,mes asc";
		
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
         public List<Reportes>consultaxMESES2018() {
		String sql = "select \n" +
"dt.nombre_mes,\n" +
"SUM (FC.TOTAL_CAMAS_DISPONIBLES + fc.total_dotacion_camas) AS total_camas,\n" +
"dt.anio,\n" +
"dt.mes\n" +
"FROM DIM_TIEMPO AS DT,FACT_CAMAS AS FC\n" +
"WHERE dt.anio = 2018 \n" +
"and DT.SK_TIEMPO = FC.SK_TIEMPO\n" +
"GROUP BY DT.ANIO,dt.nombre_mes,dt.mes\n" +
"order by anio,mes asc";
		
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
         
         public List<Reportes>consultaProvincias() {
		String sql = "select dim_ubicacion.provincia,\n" +
"SUM(fact_camas.total_dotacion_camas + fact_camas.total_camas_disponibles) as Total_Camas,\n" +
"SUM(fact_camas.total_camas_disponibles) as camas_disponibles,\n" +
"SUM(fact_camas.total_dotacion_camas) as camas_ocupadas\n" +
"from fact_camas, dim_ubicacion\n" +
"where dim_ubicacion.sk_ubicacion = fact_camas.sk_ubicacion\n" +
"Group by dim_ubicacion.provincia\n" +
"order by total_camas desc;";
		
		ResultSet rs = null;
		List<Reportes> datos = new ArrayList<Reportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				Reportes dr= new Reportes();
                                dr.setDatos(rs.getString(1));
				dr.setContador(rs.getInt(2));
				dr.setContador2(rs.getInt(3));
                                dr.setContador3(rs.getInt(4));
				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
         
                  public List<Reportes>consultaArea() {
		String sql = "select dim_ubicacion.area,\n" +
"SUM(fact_camas.total_dotacion_camas + fact_camas.total_camas_disponibles) as Total_Camas,\n" +
"SUM(fact_camas.total_camas_disponibles) as camas_disponibles,\n" +
"SUM(fact_camas.total_dotacion_camas) as camas_ocupadas\n" +
"from fact_camas, dim_ubicacion\n" +
"where dim_ubicacion.sk_ubicacion = fact_camas.sk_ubicacion\n" +
"Group by dim_ubicacion.area\n" +
"order by total_camas desc;";
		
		ResultSet rs = null;
		List<Reportes> datos = new ArrayList<Reportes>();
		Cls_conexion con = new Cls_conexion();
		try {
			rs = con.consulta(sql);
			while (rs.next()) {
				Reportes dr= new Reportes();
                                dr.setDatos(rs.getString(1));
				dr.setContador(rs.getInt(2));
				dr.setContador2(rs.getInt(3));
                                dr.setContador3(rs.getInt(4));
				datos.add(dr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			con.cerrarConexion();
		}
		return datos;

	}
                  
                           public List<Reportes>consultaSector() {
		String sql = "select \n" +
"de.sector_establecimiento,\n" +
"SUM(fc.total_dotacion_camas + fc.total_camas_disponibles) as total_camas_hospitalarias\n" +
"from dim_establecimiento as de, dim_ubicacion as du ,fact_camas as fc\n" +
"where du.sk_ubicacion = fc.sk_ubicacion\n" +
"and de.sk_establecimiento = fc.sk_establecimiento\n" +
"group by de.sector_establecimiento";
		
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
         public List<Reportes>consultaTipo() {
		String sql = "select \n" +
"de.tipo_establecimiento,\n" +
"SUM(fc.total_dotacion_camas + fc.total_camas_disponibles) as total_camas_hospitalarias\n" +
"from dim_establecimiento as de, dim_ubicacion as du ,fact_camas as fc\n" +
"where du.sk_ubicacion = fc.sk_ubicacion\n" +
"and de.sk_establecimiento = fc.sk_establecimiento\n" +
"group by de.tipo_establecimiento";
		
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
         
                  public List<Reportes>consultaClase() {
		String sql = "select \n" +
"de.clase_establecimiento,\n" +
"SUM(fc.total_dotacion_camas + fc.total_camas_disponibles) as total_camas_hospitalarias\n" +
"from dim_establecimiento as de,fact_camas as fc\n" +
"where de.sk_establecimiento = fc.sk_establecimiento\n" +
"group by de.clase_establecimiento\n" +
"";
		
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
