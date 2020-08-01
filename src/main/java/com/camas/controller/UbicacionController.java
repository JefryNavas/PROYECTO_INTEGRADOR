
package com.camas.controller;

import com.camas.dao.DaoUbicacion;
import com.camas.model.Ubicacion;
import java.sql.SQLException;
import java.util.ArrayList;

public class UbicacionController {
    
    public ArrayList<String> ImprimirProvincia() throws SQLException {
		DaoUbicacion daoubicacion;
		daoubicacion = new DaoUbicacion();
		return daoubicacion.getProvincia();
	}

    
}
