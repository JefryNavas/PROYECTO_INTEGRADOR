
package com.camas.bean;

import com.camas.controller.UbicacionController;
import com.camas.model.Ubicacion;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value = "ubicacionBean")
@SessionScoped
public class UbicacionBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String provincia;
    
    private Ubicacion ubicacion = new Ubicacion();

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public ArrayList<String> listaUbicacion() throws SQLException {
		UbicacionController controller = new UbicacionController();
		return controller.ImprimirProvincia();
	}

    
    
}
