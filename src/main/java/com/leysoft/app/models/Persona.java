package com.leysoft.app.models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	
	private String nombre;
	
	private List<Labor> labores;

	public Persona() {
		this.labores = new ArrayList<>();
	}

	public Persona(String nombre) {
		this.nombre = nombre;
		this.labores = new ArrayList<>();
	}

	public Persona(String nombre, List<Labor> labores) {
		this.nombre = nombre;
		this.labores = labores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Labor> getLabores() {
		return labores;
	}

	public void setLabores(List<Labor> labores) {
		this.labores = labores;
	}
	
	public void addLabor(Labor labor) {
		if(labores.contains(labor)) {
			labores.forEach(l -> {
				if(l.equals(labor)){
					l.setTotalHoras(l.getTotalHoras() + labor.getTotalHoras());
				}
			});
		} else {
			labores.add(labor);
		}
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Persona other = (Persona) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}