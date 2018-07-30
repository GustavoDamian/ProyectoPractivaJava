package com.todo1.hulkstore.negocio.test.inventario;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.todo1.hulkstore.negocio.inventario.GestionInventarioServicio;
import com.todo1.hulkstore.persistencia.DAO.InventarioDAO;
import com.todo1.hulkstore.persistencia.entities.Inventario;


/***
 *  Clase de prueba la funcionalidad de Inventario Servicio
 * @author gustavo
 * fecha 28/070/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class GestionInventarioServicioTest {

	
	@InjectMocks
	GestionInventarioServicio gestionInventarioServicio;
	
	@Mock
	private InventarioDAO iventarioDAO;
	
	@Test
	public void deberiaRegistrarSalidaInventario() throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException
	{
		Inventario inventario= new Inventario();
		inventario.setCantidadArticuloEntrada(100l);
		inventario.setCantidadArticuloSalida(0L);
		iventarioDAO.guardar(inventario);
		Mockito.verify(iventarioDAO).guardar(inventario);
	}
	
	@Test
	public void deberiaCargarInventario() throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException
	{
		Inventario inventario= new Inventario();
		inventario.setCantidadArticuloEntrada(0l);
		inventario.setCantidadArticuloSalida(50l);
		iventarioDAO.guardar(inventario);
		Mockito.verify(iventarioDAO).guardar(inventario);
	}
}
