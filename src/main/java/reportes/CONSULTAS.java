package reportes;

import java.sql.ResultSet;

import com.camas.model.*;

public class CONSULTAS {
	private QUERY query;
	private UPDATE modificar;
	private ResultSet resultados = null;

	public CONSULTAS() {
		// TODO Auto-generated constructor stub
		query = new QUERY();
		modificar = new UPDATE();
	}

	public String provincias() {
		String resultado = "<SELECT name=\"cmbejes\" class=\"content-select\" id=\"cmbgeo\"\r\n"
				+ "				onchange='geo()'>\r\n"
				+ "				<OPTION VALUE=\"0\">Seleccione una Provincia</OPTION>";
		try {
			resultados = query.consulta("select pk_provincia,provincia from dim_ubicacion\r\n"
					+ "group by pk_provincia,provincia\r\n" + "order by pk_provincia");
			while (resultados.next()) {
				resultado += "<OPTION VALUE=" + resultados.getInt("pk_provincia") + ">"
						+ resultados.getString("provincia") + "</OPTION>";
			}
			resultado += "</SELECT>";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
