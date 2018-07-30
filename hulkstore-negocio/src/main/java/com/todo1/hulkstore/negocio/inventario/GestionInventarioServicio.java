package com.todo1.hulkstore.negocio.inventario;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import com.todo1.hulkstore.persistencia.DAO.InventarioDAO;
import com.todo1.hulkstore.persistencia.entities.Articulo;
import com.todo1.hulkstore.persistencia.entities.Inventario;


/****
 * Clase para gestionar los servicios Inventario de articulos
 * @author gustavo
 * fecha 28/07/2018
 */
@LocalBean
@Stateless
public class GestionInventarioServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private InventarioDAO iventarioDAO;

	public Long obtenerStock(Articulo articulo) {
		return iventarioDAO.obtenerStock(articulo);	
	}
	
	public void cargarInventario(Inventario inventario) throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException
	{
		iventarioDAO.guardar(inventario);
	}
	public void registrarSalidaInventario(Inventario inventario) throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException
	{
		iventarioDAO.guardar(inventario);
	}

}
