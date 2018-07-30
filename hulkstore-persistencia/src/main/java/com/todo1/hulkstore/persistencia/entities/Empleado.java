package com.todo1.hulkstore.persistencia.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HSEmpleado")
public class Empleado implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigoEmpleado")
    Long codigoEmpleado;   
	
	@Column(name = "nombreApellido", nullable = false, length = 80)
    String nombreApellido;
	
	@Column(name = "identificacion", nullable = false, length = 13)
    String identificacion;
	
	@Column(name = "pais", nullable = false, length = 50)
    String pais;

	public Long getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(Long codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Empleado [codigoEmpleado=" + codigoEmpleado
				+ ", nombreApellido=" + nombreApellido + ", identificacion="
				+ identificacion + ", pais=" + pais + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoEmpleado == null) ? 0 : codigoEmpleado.hashCode());
		result = prime * result
				+ ((identificacion == null) ? 0 : identificacion.hashCode());
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
		Empleado other = (Empleado) obj;
		if (codigoEmpleado == null) {
			if (other.codigoEmpleado != null)
				return false;
		} else if (!codigoEmpleado.equals(other.codigoEmpleado))
			return false;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}  
	
	
    
}
