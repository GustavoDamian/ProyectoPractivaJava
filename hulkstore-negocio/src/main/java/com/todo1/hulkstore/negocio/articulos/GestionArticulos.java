package com.todo1.hulkstore.negocio.articulos;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import com.todo1.hulkstore.negocio.inventario.GestionInventarioServicio;
import com.todo1.hulkstore.negocio.ventas.GestionVentasServicio;
import com.todo1.hulkstore.persistencia.DAO.ArticuloDAO;
import com.todo1.hulkstore.persistencia.entities.Articulo;


/****
 *  Clase para gestionar los servicios que proporciona Articulos
 * @author gustavo
 * fecha 28/070/2018
 */
@LocalBean
@Stateless
public class GestionArticulos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ArticuloDAO articuloDAO;

	@EJB
	private GestionVentasServicio gestionVentasServicio;

	@EJB
	private GestionInventarioServicio gestionInvetarioServicio;

	public List<Articulo> obtenerArticulos() {
		return articuloDAO.obtenerTodos();
	}

	/***
	 * Otiene articulos disponebles una vez verificado en el inventario
	 * @return
	 */
	public List<Articulo> obtenerArticulosDisponibles() {
		List<Articulo> articulosDisponibles = new ArrayList<Articulo>();
		for (Articulo articulo : articuloDAO.obtenerTodos()) {
			if (gestionInvetarioServicio.obtenerStock(articulo) > 0L) {
				articulosDisponibles.add(articulo);
			}
		}
		return articulosDisponibles;
	}

	public void guardarArticulo(Articulo articulo)
			throws EntityExistsException,
			SQLIntegrityConstraintViolationException, PersistenceException {
		articuloDAO.guardar(articulo);
	}


	public void actualizarArticulo(Articulo articulo) {
		articuloDAO.actualizar(articulo);
	}

	public void eliminarArticulo(Articulo articulo) {
		articuloDAO.eliminar(articulo);
	}

}
