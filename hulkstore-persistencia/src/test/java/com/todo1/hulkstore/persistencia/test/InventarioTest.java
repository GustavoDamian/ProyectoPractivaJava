package com.todo1.hulkstore.persistencia.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.todo1.hulkstore.persistencia.DAO.ArticuloDAO;
import com.todo1.hulkstore.persistencia.DAO.InventarioDAO;
import com.todo1.hulkstore.persistencia.DAO.TipoArticuloDAO;
import com.todo1.hulkstore.persistencia.entities.Articulo;
import com.todo1.hulkstore.persistencia.entities.Inventario;
import com.todo1.hulkstore.persistencia.entities.TipoArticulo;


/****
 * Clase para para probar el crud de Inventario
 * @author gustavo
 * fecha 28/07/2018
 */
public class InventarioTest {

	private static EntityManagerFactory entityManagerFactory;
	@PersistenceContext
	private static EntityManager entityManager;
	private static Inventario inventario;
	private static Inventario inventario2;
	static InventarioDAO inventarioDAO;
	private static TipoArticulo tipoArticulo1;
	private static ArticuloDAO articuloDAO;
	private static Articulo articulo1;
	private static TipoArticuloDAO tipoArticuloDAO;

	@BeforeClass
	public static void beforeClass() throws EntityExistsException,
			SQLIntegrityConstraintViolationException, PersistenceException {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("hulstorePU");
		entityManager = entityManagerFactory.createEntityManager();
		inventarioDAO = new InventarioDAO(inventario, entityManager);
		inventarioDAO = new InventarioDAO(inventario2, entityManager);
		articuloDAO = new ArticuloDAO(articulo1, entityManager);
		tipoArticuloDAO = new TipoArticuloDAO(tipoArticulo1, entityManager);

		tipoArticulo1 = new TipoArticulo();
		tipoArticulo1.setCodigoTipoArticulo(null);
		tipoArticulo1.setNombreTipoArticulo("Camiseta");
		tipoArticulo1.setFechaRregistro(new Date());

		entityManager.getTransaction().begin();
		tipoArticuloDAO.guardar(tipoArticulo1);
		entityManager.getTransaction().commit();

		articulo1 = new Articulo();
		articulo1.setCodigoArticulo(null);
		articulo1.setNombre("Camiseta talla M");
		articulo1.setCodigoBarras("100000001");
		articulo1.setTipoArticulo(tipoArticulo1);
		articulo1.setPrecio(24.50d);
		articulo1.setFechaRegistro(new Date());

		entityManager.getTransaction().begin();
		articuloDAO.guardar(articulo1);
		entityManager.getTransaction().commit();
	}

	@Test
	public void deberiaGuardarInventario() {
		try {

			System.out
					.println("--------deberiaGuardarInventario--------------");

			inventario = new Inventario();
			inventario.setArticulo(articulo1);
			inventario.setFechaRegistro(new Date());
			inventario.setCantidadArticuloEntrada(180L);
			inventario.setCantidadArticuloSalida(0L);
			
			inventario2 = new Inventario();
			inventario2.setArticulo(articulo1);
			inventario2.setFechaRegistro(new Date());
			inventario2.setCantidadArticuloEntrada(0L);
			inventario2.setCantidadArticuloSalida(100L);
			
			System.out.println("articulo1:" + articulo1.getCodigoArticulo());
			entityManager.getTransaction().begin();
			inventarioDAO.guardar(inventario);
			inventarioDAO.guardar(inventario2);
			assertTrue(inventario.getCodigoInventario() != null);
		} catch (SQLIntegrityConstraintViolationException
				| PersistenceException e) {
			e.printStackTrace();
		} finally {
			entityManager.getTransaction().commit();
		}
	}

	@Test
	public void deberiaRetornaStock() {
	Long disponibilidad=	inventarioDAO.obtenerStock(articulo1);
	assertTrue(disponibilidad== 80L);
	}
}
