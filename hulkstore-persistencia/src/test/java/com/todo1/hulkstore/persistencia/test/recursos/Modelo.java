package com.todo1.hulkstore.persistencia.test.recursos;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.todo1.hulkstore.persistencia.DAO.ArticuloDAO;
import com.todo1.hulkstore.persistencia.entities.Articulo;
import com.todo1.hulkstore.persistencia.entities.TipoArticulo;


public class Modelo {
	

	 @PersistenceContext
	 private static EntityManager entityManager;
     private static ArticuloDAO articuloDAO;
	
 
	public void inicializarArticulo() throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException
	{
		
		TipoArticulo tipoArticulo1 = new TipoArticulo();
		tipoArticulo1.setCodigoTipoArticulo(null);
		tipoArticulo1.setNombreTipoArticulo("Camiseta");
		tipoArticulo1.setFechaRregistro(new Date());	
		
		Articulo articulo1 = new Articulo();
		articulo1.setCodigoArticulo(null);
		articulo1.setNombre("Camiseta talla M");
		articulo1.setCodigoBarras("100000001");
		articulo1.setTipoArticulo(tipoArticulo1);
		articulo1.setPrecio(24.50d);
		articulo1.setFechaRegistro(new Date());
		
		 entityManager.getTransaction().begin();	
		 articuloDAO.guardar(articulo1);
		 entityManager.getTransaction().commit();
		
		Articulo articulo2 = new Articulo();
		articulo2.setCodigoArticulo(null);
		articulo2.setNombre("Camiseta Mujer Verde S");
		articulo2.setCodigoBarras("100000002");
		articulo2.setTipoArticulo(tipoArticulo1);
		articulo2.setPrecio(12.50d);
		articulo2.setFechaRegistro(new Date());
		
		
		 entityManager.getTransaction().begin();	
		 articuloDAO.guardar(articulo2);
		 entityManager.getTransaction().commit();
		
	}

}
