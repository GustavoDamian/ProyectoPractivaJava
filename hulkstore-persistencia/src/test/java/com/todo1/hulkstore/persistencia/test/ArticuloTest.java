package com.todo1.hulkstore.persistencia.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.todo1.hulkstore.persistencia.entities.Articulo;
import com.todo1.hulkstore.persistencia.entities.TipoArticulo;


/****
 * Clase para probar el crud de Articulos
 * @author gustavo
 * fecha 28/07/2018
 */
public class ArticuloTest {
	@PersistenceContext
	static EntityManager em = null;
	static EntityManagerFactory emf = null;
	Logger log = LogManager.getRootLogger();

	@BeforeClass
	public static void init() throws Exception {
		emf = Persistence.createEntityManagerFactory("hulstorePU");
	}

	@Before
	public void setup() {
		try {
			em = emf.createEntityManager();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void deberiaRegistrarArticulo() {

		System.out.println("-------------Inicio--------------------------");
		log.debug("Iniciando test Persona Entity con JPA");
		assertTrue(em != null);
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		TipoArticulo tipoArticulo = new TipoArticulo();
		tipoArticulo.setCodigoTipoArticulo(null);
		tipoArticulo.setNombreTipoArticulo("Camiseta");
		tipoArticulo.setFechaRregistro(new Date());

		em.persist(tipoArticulo);

		Articulo articulo1 = new Articulo();
		articulo1.setCodigoArticulo(null);
		articulo1.setNombre("Camiseta talla M");
		articulo1.setCodigoBarras("100000001");
		articulo1.setTipoArticulo(tipoArticulo);
		articulo1.setPrecio(24.50d);
		articulo1.setFechaRegistro(new Date());

		log.debug("Objeto a persistir:" + articulo1);
		em.persist(articulo1);

		Articulo articulo2 = new Articulo();
		articulo2.setCodigoArticulo(null);
		articulo2.setNombre("Camiseta talla L");
		articulo2.setCodigoBarras("100000001");
		articulo2.setTipoArticulo(tipoArticulo);
		articulo2.setPrecio(24.50d);
		articulo2.setFechaRegistro(new Date());

		em.persist(articulo2);
		tx.commit();
		assertTrue(articulo1.getCodigoArticulo() != null);
		System.out.println("Objeto persistido:" + articulo1);
		log.debug("Objeto persistido:" + articulo1);
		log.debug("Fin test Persona Entity con JPA");
	}

}
