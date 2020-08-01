package com.camas.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import com.camas.controller.ControllerReportes;
import com.camas.dao.DaoReportes;
import com.camas.model.Reportes;

@Named(value = "beanReportes")
@SessionScoped
public class BeanReportes implements Serializable{
    
        private static final long serialVersionUID = 1L;
	private int contador;
	private String datos;
        private PieChartModel torta;
        private PieChartModel torta2;
          private PieChartModel torta3;
	private List<Reportes> lista;
        private List<Reportes> lista2;
      	private List<Reportes> lista3;
        private Reportes datosreportes = new Reportes();
        
        
        public BeanReportes() {
		//listar();

	}

	@PostConstruct
	public void init() {
		graficarProvincias();
                graficarAno();
                graficarEstablecimiento();
	}

        
        public void graficarProvincias() {
		DaoReportes dao;
		try {
			dao = new DaoReportes();
			lista = dao.consultaxProvincia();
		} catch (Exception e) {
			e.printStackTrace();

		}
		torta = new PieChartModel();
		
		for (Reportes dr : lista) {
			torta.set(dr.getDatos(), dr.getContador());
		}

		torta.setTitle("Total de camas por Provincia");
		torta.setLegendPosition("e");
		torta.setFill(true);
		torta.setShowDataLabels(true);
		torta.setDiameter(300);
	}
        
        public void graficarAno() {
		DaoReportes dao;
		try {
			dao = new DaoReportes();
			lista2 = dao.consultaxAno();
		} catch (Exception e) {
			e.printStackTrace();

		}
		torta2 = new PieChartModel();
		
		for (Reportes dr : lista2) {
			torta2.set(dr.getDatos(), dr.getContador());
		}

		torta2.setTitle("Total camas por Año");
		torta2.setLegendPosition("e");
		torta2.setFill(true);
		torta2.setShowDataLabels(true);
		torta2.setDiameter(200);
	}
                public void graficarEstablecimiento() {
		DaoReportes dao;
		try {
			dao = new DaoReportes();
			lista3 = dao.consultaxEstablecimiento();
		} catch (Exception e) {
			e.printStackTrace();

		}
		torta3 = new PieChartModel();
		
		for (Reportes dr : lista3) {
			torta3.set(dr.getDatos(), dr.getContador());
		}

		torta3.setTitle("Total camas por Establecimiento");
		torta3.setLegendPosition("e");
		torta3.setFill(true);
		torta3.setShowDataLabels(true);
		torta3.setDiameter(300);
	}

    public PieChartModel getTorta() {
        return torta;
    }

    public void setTorta(PieChartModel torta) {
        this.torta = torta;
    }

    public List<Reportes> getLista() {
        return lista;
    }

    public void setLista(List<Reportes> lista) {
        this.lista = lista;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public Reportes getDatosreportes() {
        return datosreportes;
    }

    public void setDatosreportes(Reportes datosreportes) {
        this.datosreportes = datosreportes;
    }

    public PieChartModel getTorta2() {
        return torta2;
    }

    public void setTorta2(PieChartModel torta2) {
        this.torta2 = torta2;
    }

    public List<Reportes> getLista2() {
        return lista2;
    }

    public void setLista2(List<Reportes> lista2) {
        this.lista2 = lista2;
    }

    public PieChartModel getTorta3() {
        return torta3;
    }

    public void setTorta3(PieChartModel torta3) {
        this.torta3 = torta3;
    }

    public List<Reportes> getLista3() {
        return lista3;
    }

    public void setLista3(List<Reportes> lista3) {
        this.lista3 = lista3;
    }
    
    
        
    
}
        
        
