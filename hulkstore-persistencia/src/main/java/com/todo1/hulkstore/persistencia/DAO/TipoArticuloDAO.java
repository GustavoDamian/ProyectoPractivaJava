package com.todo1.hulkstore.persistencia.DAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.todo1.hulkstore.persistencia.entities.TipoArticulo;


/****
 * Clase para gestionar CRUD TipoArticulos
 * @author gustavo
 * fecha 28/07/2018
 */
@LocalBean
@Stateless
public class TipoArticuloDAO  extends  BaseDao<TipoArticulo, Long> {

	
	public TipoArticuloDAO()
	{
		super(TipoArticulo.class);
	}
	
	public TipoArticuloDAO(final TipoArticulo tipoEntidad, final EntityManager entityManager )
	{
		super(TipoArticulo.class,entityManager);
	}

}
