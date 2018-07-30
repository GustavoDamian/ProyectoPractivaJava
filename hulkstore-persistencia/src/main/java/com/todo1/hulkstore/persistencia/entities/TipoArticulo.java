package com.todo1.hulkstore.persistencia.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HSTipoArticulo")
public class TipoArticulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoTipoArticulo")
	private Long codigoTipoArticulo;

	@Column(name = "nombreTipoArticulo", nullable = false, length = 45)
	private String nombreTipoArticulo;

	@Column(name = "fechaRregistro", nullable = false)
	private Date fechaRregistro;

	@Column(name = "fechaAlta")
	private Date fechaAlta;

//	@OneToMany(mappedBy="tipoArticulo" )
//	List<Articulo> articulos;

	public TipoArticulo() {
	}

	public TipoArticulo(Long codigoTipoArticulo, String nombreTipoArticulo,
			Date fechaRregistro, Date fechaAlta, List<Articulo> articulos) {
		super();
		this.codigoTipoArticulo = codigoTipoArticulo;
		this.nombreTipoArticulo = nombreTipoArticulo;
		this.fechaRregistro = fechaRregistro;
		this.fechaAlta = fechaAlta;
	}

	public Long getCodigoTipoArticulo() {
		return codigoTipoArticulo;
	}

	public void setCodigoTipoArticulo(Long codigoTipoArticulo) {
		this.codigoTipoArticulo = codigoTipoArticulo;
	}

	public String getNombreTipoArticulo() {
		return nombreTipoArticulo;
	}

	public void setNombreTipoArticulo(String nombreTipoArticulo) {
		this.nombreTipoArticulo = nombreTipoArticulo;
	}

	public Date getFechaRregistro() {
		return fechaRregistro;
	}

	public void setFechaRregistro(Date fechaRregistro) {
		this.fechaRregistro = fechaRregistro;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "TipoArticulo [codigoTipoArticulo=" + codigoTipoArticulo
				+ ", nombreTipoArticulo=" + nombreTipoArticulo
				+ ", fechaRregistro=" + fechaRregistro + ", fechaAlta="
				+ fechaAlta + "]";
	}

	
}
