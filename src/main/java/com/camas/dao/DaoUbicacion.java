
package com.camas.dao;

import com.camas.model.Cls_conexion;
import com.camas.model.Ubicacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoUbicacion {
    
    
    public ArrayList<String> getProvincia(){
		ArrayList<String> lista_provincia = new ArrayList<>();
		try {
			ResultSet re;
			Cls_conexion cl = new Cls_conexion();
			re = cl.consulta("select provincia from dim_ubicacion\n" +
"group by provincia");
			//String genero;
			while (re.next()) {
				
				lista_provincia.add(re.getString(1));
                                
			}
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return lista_provincia;
	}
    
    

}
