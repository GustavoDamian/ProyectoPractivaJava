package com.todo1.hulkstore.persistencia.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaccion {

	@Id
	Long codigoTransaccion;
	Long codigoAticulo;
	Long codigoPersona;
	Date fechaRegistro;
	Long cantidadArticulo;
	Long agenteVendedor;

	public Transaccion() {
	}

}
