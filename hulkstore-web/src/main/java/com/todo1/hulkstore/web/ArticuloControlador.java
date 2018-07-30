package com.todo1.hulkstore.web;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

import com.todo1.hulkstore.negocio.articulos.GestionArticulos;
import com.todo1.hulkstore.negocio.articulos.GestionTipoArticuloServicio;
import com.todo1.hulkstore.negocio.empleado.GestionEmpleadoServicio;
import com.todo1.hulkstore.negocio.inventario.GestionInventarioServicio;
import com.todo1.hulkstore.negocio.ventas.GestionVentasServicio;
import com.todo1.hulkstore.persistencia.entities.Articulo;
import com.todo1.hulkstore.persistencia.entities.DetalleVenta;
import com.todo1.hulkstore.persistencia.entities.Empleado;
import com.todo1.hulkstore.persistencia.entities.Inventario;
import com.todo1.hulkstore.persistencia.entities.TipoArticulo;
import com.todo1.hulkstore.persistencia.entities.Venta;
import com.todo1.hulkstore.web.controlador.ControladorBase;

/****
 * Clase controlador de la vista de articulos
 * @author gustavo
 * fecha 28/07/2018
 */
@ManagedBean
@ViewScoped
public class ArticuloControlador  extends ControladorBase  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private GestionArticulos gestionArticulos;

	@EJB
	private GestionVentasServicio gestionVentaServicio;

	@EJB
	private GestionTipoArticuloServicio gestionTipoArticuloServicio;

	@EJB
	private GestionInventarioServicio gestionInvetarioServicio;
	@EJB
	GestionEmpleadoServicio gestionEmpleadoServicio;

	private List<Articulo> articulos = new ArrayList<Articulo>();
	private Venta venta;
	private DetalleVenta detalleVenta;
	private List<DetalleVenta> detalles;
	private Articulo articuloSeleccionado;
	private Long dispomibilidadArticulos;
	private Empleado empleado;

	@PostConstruct
	public void init() {
		if (!isPostback()) {
			detalleVenta = new DetalleVenta();
			detalles = new ArrayList<DetalleVenta>();
			venta = new Venta();
			venta.setCodigoVenta(null);
			venta.setEmpleado(new Empleado());
			venta.setFechaRegistro(new Date());
			venta.setValorTotal(0.0);
			cargarDatosIniciales();
			motrarArticulos();
			System.out.println("por is pos");
		}

		else {
			System.out.println("xxxxxxxxxxxxxxxxxxx");
		}

	}

	public boolean isPostback() {
		return FacesContext.getCurrentInstance().isPostback();
	}

	public void motrarArticulos() {
		articulos = gestionArticulos.obtenerArticulosDisponibles();
	}

	public void AgregarArticulos() {
		detalleVenta = new DetalleVenta();
		detalleVenta.setArticulo(articuloSeleccionado);
		detalleVenta.setVenta(venta);

		detalles.add(detalleVenta);
		motrarArticulos();

	}

	public void pagar() {
		try {

			venta.setEmpleado(empleado);
			venta.setDetalle(detalles);
			venta.setFechaRegistro(new Date());
			venta.setValorTotal(0L);
			gestionVentaServicio.registrarVenta(venta);
			System.out.println("Venta :" + venta.toString());
			nuevaVenta();
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		}

	}
	
	public void nuevaVenta()
	{
		articulos = gestionArticulos.obtenerArticulosDisponibles();	
		venta = new Venta();
		detalleVenta = new DetalleVenta();
		
	}

	public String retornarStock(Articulo articulo) {
		return gestionInvetarioServicio.obtenerStock(articulo).toString();
	}

	/****
	 * Metodo para inicializar productos solo para la demo.
	 */
	public void cargarDatosIniciales() {
		TipoArticulo tipoArticulo1 = new TipoArticulo();
		tipoArticulo1.setNombreTipoArticulo("Camiseta");
		tipoArticulo1.setFechaRregistro(new Date());
		try {
			gestionTipoArticuloServicio.guardarTipoArticulo(tipoArticulo1);
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		}

		Articulo articulo1 = new Articulo();
		articulo1.setNombre("Camiseta talla M");
		articulo1.setCodigoBarras("100000001");
		articulo1.setTipoArticulo(tipoArticulo1);
		articulo1.setPrecio(24.50d);
		articulo1.setFechaRegistro(new Date());
		try {
			gestionArticulos.guardarArticulo(articulo1);
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		}

		Articulo articulo2 = new Articulo();
		articulo2.setNombre("Camiseta Mujer Verde S");
		articulo2.setCodigoBarras("100000002");
		articulo2.setTipoArticulo(tipoArticulo1);
		articulo2.setPrecio(12.50d);
		articulo2.setFechaRegistro(new Date());

		try {
			gestionArticulos.guardarArticulo(articulo2);
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		}

		Inventario inventario = new Inventario();
		inventario.setArticulo(articulo1);
		inventario.setCantidadArticuloEntrada(100L);
		inventario.setCantidadArticuloSalida(0L);
		inventario.setFechaRegistro(new Date());
		try {
			gestionInvetarioServicio.cargarInventario(inventario);
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		}

		Inventario inventario2 = new Inventario();
		inventario2.setArticulo(articulo2);
		inventario2.setCantidadArticuloEntrada(50L);
		inventario2.setCantidadArticuloSalida(0L);
		inventario2.setFechaRegistro(new Date());
		try {
			gestionInvetarioServicio.cargarInventario(inventario2);
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		}

		empleado = new Empleado();
		empleado.setIdentificacion("1803617267");
		empleado.setNombreApellido("Gustavo Damian");
		empleado.setPais("Ecuador");
		try {
			gestionEmpleadoServicio.registrarEmpleado(empleado);
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		}

	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}


	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public DetalleVenta getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(DetalleVenta detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

	public Articulo getArticuloSeleccionado() {
		return articuloSeleccionado;
	}

	public void setArticuloSeleccionado(Articulo articuloSeleccionado) {
		this.articuloSeleccionado = articuloSeleccionado;
	}

}
