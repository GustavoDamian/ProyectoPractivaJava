
package  com.todo1.hulkstore.persistencia.DAO;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

/**

 * Las implementaciones de este contrato deben proveer las operaciones basicas
 * para la manipulacion de datos mapeados como entidades del sistema.
 * 
 */
public interface GenericoDAO<T, I extends Serializable> {

	/**
	 * Guarda la entidad en la base de datos de manera persistente.
	 * 
	 * @param entidad es la entidad a guardar.
	 * @throws EntityExistsException si el registro representado por la
	 *         instancia de T ya existe en la base de datos.
	 * @throws PersistenceException 
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	void guardar(T entidad) throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException;
	
	/**
	 * Actualiza la base de datos con el estado de la entidad.
	 * 
	 * @param entidad es la entidad con los datos actualizados.
	 * @return la entidad actualizada
	 */
	T actualizar(T entidad);

	/**
	 * Elimina el registro representado por la entidad de la base de datos.
	 * 
	 * @param entidad es la entidad a eliminarse.
	 */
	void eliminar(T entidad);

	/**
	 * @param clavePrimaria es la clave primaria de la entidad en la base de
	 *        datos.
	 * @return una entidad con la clave primaria provista como criterio de
	 *         busqueda.
	 */
	T obtenerPorCodigo(I clavePrimaria);

	/**
	 * @return el listado completo de entidades existentes en la base de datos.
	 */
	List<T> obtenerTodos();
	

}
