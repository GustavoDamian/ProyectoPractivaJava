package com.todo1.hulkstore.persistencia.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="HSDetalleVenta")
public class DetalleVenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigoDetalleVenta")
	private Long codigoDetalleVenta;
	
	@ManyToOne
    @JoinColumn(name="codigoArticulo")
	private Articulo articulo;
	
	@ManyToOne
    @JoinColumn(name="codigoVenta")
	private Venta venta;
	
	@Column(name = "cantidadVendida", nullable = false)
	private Long cantidadVendida;
	
	@Column(name = "valor", nullable = false)
	private double valor; 
	
	public DetalleVenta()	{	
	}

	public Long getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}

	public void setCodigoDetalleVenta(Long codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}


	public Long getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(Long cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((articulo == null) ? 0 : articulo.hashCode());
		result = prime * result
				+ ((cantidadVendida == null) ? 0 : cantidadVendida.hashCode());
		result = prime
				* result
				+ ((codigoDetalleVenta == null) ? 0 : codigoDetalleVenta
						.hashCode());
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
		DetalleVenta other = (DetalleVenta) obj;
		if (articulo == null) {
			if (other.articulo != null)
				return false;
		} else if (!articulo.equals(other.articulo))
			return false;
		if (cantidadVendida == null) {
			if (other.cantidadVendida != null)
				return false;
		} else if (!cantidadVendida.equals(other.cantidadVendida))
			return false;
		if (codigoDetalleVenta == null) {
			if (other.codigoDetalleVenta != null)
				return false;
		} else if (!codigoDetalleVenta.equals(other.codigoDetalleVenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalleVenta [codigoDetalleVenta=" + codigoDetalleVenta
				+ ", articulo=" + articulo + ", venta=" + venta
				+ ", cantidadVendida=" + cantidadVendida + ", valor=" + valor
				+ "]";
	}

	
	
}
