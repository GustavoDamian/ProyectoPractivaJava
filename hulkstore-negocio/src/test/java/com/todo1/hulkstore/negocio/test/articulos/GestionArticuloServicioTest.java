package com.todo1.hulkstore.negocio.test.articulos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.todo1.hulkstore.negocio.articulos.GestionArticulos;
import com.todo1.hulkstore.negocio.inventario.GestionInventarioServicio;
import com.todo1.hulkstore.persistencia.DAO.ArticuloDAO;
import com.todo1.hulkstore.persistencia.entities.Articulo;

/***
 * Clase de prueba la funcionalidad de Articulo Servicio
 * 
 * @author gustavo 
 * fecha 28/070/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class GestionArticuloServicioTest {

	@InjectMocks
	private GestionArticulos gestionArticulos;
	@Mock
	private ArticuloDAO articuloDAO;
	@Mock
	private GestionInventarioServicio gestionInvetarioServicio;
	private List<Articulo> articulos;
	private Articulo articulo;

	@Before
	public void inicio() {
		 articulos = new ArrayList<Articulo>();
		articulo = new Articulo();
		articulos.add(articulo);
	}

	@Test
	public void deberiaMostrarStock() {

		Mockito.when(articuloDAO.obtenerTodos()).thenReturn(articulos);
		Mockito.when(gestionInvetarioServicio.obtenerStock(articulo))
				.thenReturn(10L);
		assertEquals(1, gestionArticulos.obtenerArticulosDisponibles().size());
		Mockito.verify(gestionInvetarioServicio).obtenerStock(articulo);
	}

	@Test
	public void deberiaMostrarArticuloSinStock() {
		Mockito.when(articuloDAO.obtenerTodos()).thenReturn(articulos);
		Mockito.when(gestionInvetarioServicio.obtenerStock(articulo))
				.thenReturn(0L);
		assertEquals(0, gestionArticulos.obtenerArticulosDisponibles().size());
		Mockito.verify(gestionInvetarioServicio).obtenerStock(articulo);
	}

}
