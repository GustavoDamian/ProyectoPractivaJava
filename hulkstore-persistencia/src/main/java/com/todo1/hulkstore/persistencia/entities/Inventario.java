package com.todo1.hulkstore.persistencia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HSInventario")
public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigoInventario")
	Long codigoInventario;
	

	Long cantidadArticuloEntrada;
	
	Long cantidadArticuloSalida;
	
	Date fechaRegistro;
	
	@ManyToOne
    @JoinColumn(name="codigoArticulo")
	private Articulo articulo;

	public Inventario() {
	}

	public Long getCodigoInventario() {
		return codigoInventario;
	}

	public void setCodigoInventario(Long codigoInventario) {
		this.codigoInventario = codigoInventario;
	}

	public Long getCantidadArticuloEntrada() {
		return cantidadArticuloEntrada;
	}

	public void setCantidadArticuloEntrada(Long cantidadArticuloEntrada) {
		this.cantidadArticuloEntrada = cantidadArticuloEntrada;
	}

	public Long getCantidadArticuloSalida() {
		return cantidadArticuloSalida;
	}

	public void setCantidadArticuloSalida(Long cantidadArticuloSalida) {
		this.cantidadArticuloSalida = cantidadArticuloSalida;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	@Override
	public String toString() {
		return "Inventario [codigoInventario=" + codigoInventario
				+ ", cantidadArticuloEntrada=" + cantidadArticuloEntrada
				+ ", cantidadArticuloSalida=" + cantidadArticuloSalida
				+ ", fechaRegistro=" + fechaRegistro + ", articulo=" + articulo
				+ "]";
	}
	
	
}
