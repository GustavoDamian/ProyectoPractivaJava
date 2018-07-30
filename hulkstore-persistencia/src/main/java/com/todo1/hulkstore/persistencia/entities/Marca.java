package com.todo1.hulkstore.persistencia.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HSMarca")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoMarca")
	Long codigoMarca;

	@Column(name = "nombreTipoArticulo", nullable = false, length = 45)
	String nombre;

	@Column(name = "fechaRegistro")
	Date fechaRegistro;
	@Column(name = "fechaAlta")
	Date fechaAlta;
}
