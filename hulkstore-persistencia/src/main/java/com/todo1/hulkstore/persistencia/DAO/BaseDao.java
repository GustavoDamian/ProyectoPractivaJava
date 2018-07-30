
package  com.todo1.hulkstore.persistencia.DAO;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Implementacion base con JPA del patron {@link GenericoDAO}.
 * 
 * En el metodo {@link #todos()} se ejemplifica una consulta dinamica, para la cual se utiliza el API de Criteria Query.
 * 
 * @author mgdamian
 * 
 */
public abstract class BaseDao<T, I extends Serializable> implements GenericoDAO<T, I> {

	@PersistenceContext(unitName = "hulstorePU")
	protected EntityManager entityManager;
	private final Class<T> tipoEntidad;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public BaseDao(final Class<T> tipoEntidad) {
		this(tipoEntidad, null);
	}

	/**
	 * @param entityManager
	 * @param tipoEntidad
	 */
	public BaseDao(final Class<T> tipoEntidad, final EntityManager entityManager) {
		this.tipoEntidad = tipoEntidad;
		this.entityManager = entityManager;
	}


	@Override
	public void guardar(final T entidad) throws EntityExistsException, SQLIntegrityConstraintViolationException,
			PersistenceException {
		entityManager.persist(entidad);
	}


	@Override
	public T actualizar(final T entidad) {
		return entityManager.merge(entidad);
	}

	@Override
	public void eliminar(final T entidad) {
		entityManager.remove(actualizar(entidad));
	}

	@Override
	public T obtenerPorCodigo(final I clavePrimaria) {
		final T entidad = entityManager.find(tipoEntidad, clavePrimaria);
		if (null == entidad) {
			throw new NoResultException("No existe registro con clave primaria " + clavePrimaria);
		}
		return entidad;
	}


	@Override
	public List<T> obtenerTodos() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(tipoEntidad);
		Root<T> rootEntry = query.from(tipoEntidad);
		CriteriaQuery<T> all = query.select(rootEntry);
		TypedQuery<T> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();

	}
}
