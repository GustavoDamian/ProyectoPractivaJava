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
@Table(name = "HSArticulo")
public class Articulo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigoArticulo")
	 private Long codigoArticulo;

	@Column(name = "nombre", nullable = false, length = 80)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private Double precio;

	@Column(name = "codigoBarras")
	private String codigoBarras;

	@Column(name = "fechaRegistro")
	private Date fechaRegistro;
	
	@ManyToOne
    @JoinColumn(name="codigoTipoArticulo")
	private TipoArticulo tipoArticulo;
	
//	@OneToMany(mappedBy="tipoArticulo" )
//	List<Articulo> articulos;
	
	public Articulo() {
	}

	
	public Articulo(Long codigoArticulo, String nombre, Double precio,
			String codigoBarras, Date fechaRegistro, TipoArticulo tipoArticulo) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.nombre = nombre;
		this.precio = precio;
		this.codigoBarras = codigoBarras;
		this.fechaRegistro = fechaRegistro;
		this.tipoArticulo = tipoArticulo;
	}


	public Long getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(Long codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public TipoArticulo getTipoArticulo() {
		return tipoArticulo;
	}

	public void setTipoArticulo(TipoArticulo tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoArticulo == null) ? 0 : codigoArticulo.hashCode());
		result = prime * result
				+ ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		result = prime * result
				+ ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
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
		Articulo other = (Articulo) obj;
		if (codigoArticulo == null) {
			if (other.codigoArticulo != null)
				return false;
		} else if (!codigoArticulo.equals(other.codigoArticulo))
			return false;
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
			return false;
		if (fechaRegistro == null) {
			if (other.fechaRegistro != null)
				return false;
		} else if (!fechaRegistro.equals(other.fechaRegistro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Articulo [codigoArticulo=" + codigoArticulo + ", nombre="
				+ nombre + ", precio=" + precio + ", codigoBarras="
				+ codigoBarras + ", fechaRegistro=" + fechaRegistro
				+ ", tipoArticulo=" + tipoArticulo + "]";
	}
	
	
	
}
