package com.leysoft.app.models;

import java.util.Arrays;

public class Labor {
	
	private String[] fecha;
	
	private double totalHoras;

	public Labor() {}

	public Labor(String[] fecha, double totalHoras) {
		this.fecha = fecha;
		this.totalHoras = totalHoras;
	}
	
	public String[] getFecha() {
		return fecha;
	}

	public void setFecha(String[] fecha) {
		this.fecha = fecha;
	}

	public double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(double totalHoras) {
		this.totalHoras = totalHoras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(fecha);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Labor other = (Labor) obj;
		if (!Arrays.equals(fecha, other.fecha))
			return false;
		return true;
	}
}