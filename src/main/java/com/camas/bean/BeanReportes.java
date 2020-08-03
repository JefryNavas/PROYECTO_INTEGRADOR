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
        private BarChartModel barra2017;
        private BarChartModel barra2018;
        private BarChartModel barraANIOS;
        private BarChartModel barraMESES;
        private BarChartModel barraMESES2018;
        private BarChartModel barraProvincias;
        private BarChartModel barratotal;
        private BarChartModel barraArea;
        private BarChartModel barraSector;
        private BarChartModel barraTipo;
        private BarChartModel barraClase;
        
        private Reportes datosreportes = new Reportes();
        
        
        public BeanReportes() {
		//listar();

	}

	@PostConstruct
	public void init() {
		graficarProvincias();
                graficarAno();
                graficarEstablecimiento();
                graficarBarra2017();
                graficarBarra2018();
                graficarBarraMESES2017();
                graficarBarraMESES2018();
                graficarProvinciasTotales();
                graficarArea();
                graficarAniosbarra();
               graficarSector();
               graficarTipo();
               graficarClase();
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
		torta2.setDiameter(300);
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
                
                
        public void graficarBarra2017() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaANIO2017();
		barra2017 = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("2017", lista.get(i).getContador());
			barra2017.addSeries(serie);
			
		}
		
		barra2017.setTitle("Total de camas en el año 2017");
		barra2017.setLegendPosition("ne");
		Axis x = barra2017.getAxis(AxisType.X);
		x.setLabel("Año");
		Axis y = barra2017.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(10000);

	}
        public void graficarBarra2018() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaANIO2018();
		barra2018 = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("2018", lista.get(i).getContador());
			barra2018.addSeries(serie);
			
		}
		
		barra2018.setTitle("Total de camas en el año 2018");
		barra2018.setLegendPosition("ne");
		Axis x = barra2018.getAxis(AxisType.X);
		x.setLabel("Año");
		Axis y = barra2018.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(10000);

	}
        
         public void graficarBarraMESES2017() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaxMESES2017();
		barraMESES = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("2017", lista.get(i).getContador());
			barraMESES.addSeries(serie);
			
		}
                
		
		barraMESES.setTitle("Total de camas por Meses en el año 2017");
		barraMESES.setLegendPosition("ne");
		Axis x = barraMESES.getAxis(AxisType.X);
		x.setLabel("Meses");
		Axis y = barraMESES.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(5000);

	}
         public void graficarBarraMESES2018() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaxMESES2018();
		barraMESES2018 = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("2018", lista.get(i).getContador());
			barraMESES2018.addSeries(serie);
			
		}
                
		
		barraMESES2018.setTitle("Total de camas por Meses en el año 2018");
		barraMESES2018.setLegendPosition("ne");
		Axis x = barraMESES2018.getAxis(AxisType.X);
		x.setLabel("Meses");
		Axis y = barraMESES2018.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(5000);

	}
         
                  public void graficarProvinciasTotales() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaProvincias();
		barraProvincias = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("2018", lista.get(i).getContador());
			barraProvincias.addSeries(serie);
			
		}
                
		
		barraProvincias.setTitle("Total de camas por Provincias");
		barraProvincias.setLegendPosition("ne");
		Axis x = barraProvincias.getAxis(AxisType.X);
		x.setLabel("Meses");
		Axis y = barraProvincias.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(8000);

	}
        public void graficarArea() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaArea();
		barraArea = new BarChartModel();
		ChartSeries serie1; 
		for (int i = 0; i < lista.size(); i++) {
			serie1 = new ChartSeries();
			serie1.setLabel(lista.get(i).getDatos());
			serie1.set(lista.get(i).getDatos(), lista.get(i).getContador());
			barraArea.addSeries(serie1);
			
		}
                
		barraArea.setTitle("Total de camas por Area");
		barraArea.setLegendPosition("ne");
		Axis x = barraArea.getAxis(AxisType.X);
		x.setLabel("Meses");
		Axis y = barraArea.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(47000);

	}
        
        public void graficarAniosbarra() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaAniobarra();
		barratotal = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("Años", lista.get(i).getContador());
			barratotal.addSeries(serie);
			
		}
                
		
		barratotal.setTitle("Total camas Disponibles");
		barratotal.setLegendPosition("ne");
		Axis x =barratotal.getAxis(AxisType.X);
		x.setLabel("Años");
		Axis y = barratotal.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(15000);

	}
        
        public void graficarSector() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaSector();
		barraSector = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("Sectores", lista.get(i).getContador());
			barraSector.addSeries(serie);
			
		}
                
		
		barraSector.setTitle("Total camas por Sectores");
		barraSector.setLegendPosition("ne");
		Axis x =barraSector.getAxis(AxisType.X);
		x.setLabel("Sectores");
		Axis y = barraSector.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(30000);

	}
        
                public void graficarTipo() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaTipo();
		barraTipo = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("Tipos", lista.get(i).getContador());
			barraTipo.addSeries(serie);
			
		}
                
		
		barraTipo.setTitle("Total camas por Tipo de establecimiento");
		barraTipo.setLegendPosition("ne");
		Axis x =barraTipo.getAxis(AxisType.X);
		x.setLabel("Tipos");
		Axis y = barraTipo.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(30000);

	}

                
                public void graficarClase() {
		DaoReportes dao = new DaoReportes();
		lista = dao.consultaClase();
		barraClase = new BarChartModel();
		ChartSeries serie; 
		for (int i = 0; i < lista.size(); i++) {
			serie = new ChartSeries();
			serie.setLabel(lista.get(i).getDatos());
			serie.set("Clases", lista.get(i).getContador());
			barraClase.addSeries(serie);
			
		}
                
		
		barraClase.setTitle("Total camas por Clase de establecimiento");
		barraClase.setLegendPosition("ne");
		Axis x =barraClase.getAxis(AxisType.X);
		x.setLabel("Clase");
		Axis y = barraClase.getAxis(AxisType.Y);
		y.setLabel("Total Camas");
		y.setMin(0);
		y.setMax(30000);

	}
                
    public BarChartModel getBarraMESES() {
        return barraMESES;
    }

    public void setBarraMESES(BarChartModel barraMESES) {
        this.barraMESES = barraMESES;
    }

        
        

    public BarChartModel getBarraANIOS() {
        return barraANIOS;
    }

    public void setBarraANIOS(BarChartModel barraANIOS) {
        this.barraANIOS = barraANIOS;
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

    public BarChartModel getBarra2017() {
        return barra2017;
    }

    public void setBarra2017(BarChartModel barra2017) {
        this.barra2017 = barra2017;
    }

    public BarChartModel getBarraArea() {
        return barraArea;
    }

    public void setBarraArea(BarChartModel barraArea) {
        this.barraArea = barraArea;
    }

    
    
    public BarChartModel getBarra2018() {
        return barra2018;
    }

    public void setBarra2018(BarChartModel barra2018) {
        this.barra2018 = barra2018;
    }

    public BarChartModel getBarraMESES2018() {
        return barraMESES2018;
    }

    public void setBarraMESES2018(BarChartModel barraMESES2018) {
        this.barraMESES2018 = barraMESES2018;
    }

    public BarChartModel getBarraProvincias() {
        return barraProvincias;
    }

    public void setBarraProvincias(BarChartModel barraProvincias) {
        this.barraProvincias = barraProvincias;
    }

    public BarChartModel getBarratotal() {
        return barratotal;
    }

    public void setBarratotal(BarChartModel barratotal) {
        this.barratotal = barratotal;
    }

    public BarChartModel getBarraSector() {
        return barraSector;
    }

    public void setBarraSector(BarChartModel barraSector) {
        this.barraSector = barraSector;
    }

    public BarChartModel getBarraTipo() {
        return barraTipo;
    }

    public void setBarraTipo(BarChartModel barraTipo) {
        this.barraTipo = barraTipo;
    }

    public BarChartModel getBarraClase() {
        return barraClase;
    }

    public void setBarraClase(BarChartModel barraClase) {
        this.barraClase = barraClase;
    }
    
    
    
    
}
        
        
