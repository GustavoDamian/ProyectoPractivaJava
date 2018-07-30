package com.todo1.hulkstore.negocio.ventas;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import com.todo1.hulkstore.negocio.inventario.GestionInventarioServicio;
import com.todo1.hulkstore.persistencia.DAO.VentaDAO;
import com.todo1.hulkstore.persistencia.entities.Articulo;
import com.todo1.hulkstore.persistencia.entities.DetalleVenta;
import com.todo1.hulkstore.persistencia.entities.Inventario;
import com.todo1.hulkstore.persistencia.entities.Venta;


/****
 * Clase para gestionar los servicios Ventas de los articulos seleccionado por el empleado
 * @author gustavo
 * fecha 28/07/2018
 */

@Local
@Stateless
public class GestionVentasServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private GestionInventarioServicio gestionInventarioServicio;
	
	@EJB
	private VentaDAO ventaDAO;
	
	public void registrarVenta(Venta venta) throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException
	{
		ventaDAO.guardar(venta);
		for ( DetalleVenta detalle : venta.getDetalle())
		{
			Inventario  inventario= new Inventario();
			inventario.setArticulo(detalle.getArticulo());
			inventario.setCantidadArticuloEntrada(0l);
			inventario.setCantidadArticuloSalida(detalle.getCantidadVendida());
			inventario.setFechaRegistro(new Date());
			gestionInventarioServicio.registrarSalidaInventario(inventario);
		}
	}

}
