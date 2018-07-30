package com.todo1.hulkstore.negocio.articulos;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import com.todo1.hulkstore.persistencia.DAO.TipoArticuloDAO;
import com.todo1.hulkstore.persistencia.entities.TipoArticulo;


/****
 * Clase para gestionar los servicios TipoArticulos
 * @author gustavo
 * fecha 28/07/2018
 */
@LocalBean
@Stateless
public class GestionTipoArticuloServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private TipoArticuloDAO tipoArticuloDAO;

	public void guardarTipoArticulo(TipoArticulo tipoArticulo)
			throws EntityExistsException,
			SQLIntegrityConstraintViolationException, PersistenceException {
		tipoArticuloDAO.guardar(tipoArticulo);
	}

}
