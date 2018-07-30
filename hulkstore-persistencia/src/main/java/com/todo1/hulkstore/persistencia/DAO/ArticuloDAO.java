package com.todo1.hulkstore.persistencia.DAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.todo1.hulkstore.persistencia.entities.Articulo;


/****
 * Clase de Acceso a Datos de Articulo
 * @author gustavo
 * fecha 28/07/2018
 */
@LocalBean
@Stateless
public class ArticuloDAO extends BaseDao<Articulo, Long> {

	public ArticuloDAO() {
		super(Articulo.class);
	}

	public String ObtenerArituculos() {
		return null;
	}

	public ArticuloDAO(final Articulo tipoEntidad,
			final EntityManager entityManager) {
		super(Articulo.class, entityManager);
	}

}
