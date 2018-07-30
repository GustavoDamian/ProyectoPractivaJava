package com.todo1.hulkstore.persistencia.DAO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import com.todo1.hulkstore.persistencia.entities.Venta;

/****
 * Clase para implementar el CRUD de Ventas
 * @author gustavo
 * fecha 28/07/2018
 */
@Stateless
@Local
public class VentaDAO extends BaseDao<Venta, Long> {

	public VentaDAO() {
		super(Venta.class);
	}
	
	public VentaDAO(final Venta tipoEntidad, final EntityManager entityManager )
	{
		super(Venta.class,entityManager);
	}

}
