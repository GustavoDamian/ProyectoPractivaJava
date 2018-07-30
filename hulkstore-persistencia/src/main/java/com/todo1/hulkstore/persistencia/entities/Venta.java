package com.todo1.hulkstore.persistencia.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HSVenta")
public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigoVenta")
	Long codigoVenta;
	
	@Column(name = "precio", nullable = false)
	Date fechaRegistro;
	
	@ManyToOne
    @JoinColumn(name="codigoEmpleado")
	private Empleado empleado;
	
	
	@OneToMany(mappedBy="venta" )
	List<DetalleVenta> detalle;
	
	@Column(name = "valorTotal", nullable = false)
	private double valorTotal;
	
	public Venta() {
	}

	public Long getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<DetalleVenta> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleVenta> detalle) {
		this.detalle = detalle;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoVenta == null) ? 0 : codigoVenta.hashCode());
		result = prime * result + ((detalle == null) ? 0 : detalle.hashCode());
		result = prime * result
				+ ((empleado == null) ? 0 : empleado.hashCode());
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
		Venta other = (Venta) obj;
		if (codigoVenta == null) {
			if (other.codigoVenta != null)
				return false;
		} else if (!codigoVenta.equals(other.codigoVenta))
			return false;
		if (detalle == null) {
			if (other.detalle != null)
				return false;
		} else if (!detalle.equals(other.detalle))
			return false;
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		return true;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Venta [codigoVenta=" + codigoVenta + ", fechaRegistro="
				+ fechaRegistro + ", empleado=" + empleado + ", detalle="
				+ detalle + ", valorTotal=" + valorTotal + "]";
	}



}
