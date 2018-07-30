/**
 * 
 */
package com.todo1.hulkstore.persistencia.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.todo1.hulkstore.persistencia.entities.Articulo;
import com.todo1.hulkstore.persistencia.entities.Inventario;
import com.todo1.hulkstore.persistencia.entities.Inventario_;

/**
 * @author gustavo
 *
 */
@LocalBean
@Stateless
public class InventarioDAO extends  BaseDao<Inventario, Long> {

	public Long obtenerStock( Articulo articulo)
	{
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = criteriaBuilder.createTupleQuery();
		Root<Inventario> rootInventario = query.from(Inventario.class);
		List<Predicate> inventarioPredicado = new ArrayList<Predicate>();
		inventarioPredicado.add(criteriaBuilder.equal(rootInventario.get(Inventario_.articulo), articulo));
		Expression<Long> sumEntrada = criteriaBuilder.sum(rootInventario.get(Inventario_.cantidadArticuloEntrada));
		Expression<Long> sumSalida = criteriaBuilder.sum(rootInventario.get(Inventario_.cantidadArticuloSalida));
		Expression<Long> difSalida= criteriaBuilder.diff(sumEntrada, sumSalida);
		query.multiselect(difSalida.alias("disponibilidad"));
		query.where(inventarioPredicado.toArray(new Predicate[]{}));
		Tuple tuple=	 entityManager.createQuery(query).getSingleResult();
		return (Long)tuple.get(0);
	}
	
	public InventarioDAO()
	{
		super(Inventario.class);
	}
	
	public InventarioDAO(final Inventario tipoEntidad, final EntityManager entityManager )
	{
		super(Inventario.class,entityManager);
	}
	
	
	
}
