package com.todo1.hulkstore.negocio.empleado;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;

import com.todo1.hulkstore.persistencia.DAO.EmpleadoDAO;
import com.todo1.hulkstore.persistencia.entities.Empleado;


/****
 * Clase para gestionar los servicios de Empleados que adquieren articulos
 * @author gustavo
 * fecha 28/07/2018
 */
@LocalBean
@Stateless
public class GestionEmpleadoServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmpleadoDAO empleadoDAO;
	
	public void registrarEmpleado(Empleado empleado) throws EntityExistsException, SQLIntegrityConstraintViolationException, PersistenceException
	{
		empleadoDAO.guardar(empleado);
	}
	
	public Empleado obtenerEmpleado(Empleado empleado)
	{
		 return empleadoDAO.obtenerPorCodigo(empleado.getCodigoEmpleado());
	}

}
