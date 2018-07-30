package com.todo1.hulkstore.persistencia.DAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.todo1.hulkstore.persistencia.entities.Empleado;

/****
 * Clase para gestionar el CRUD de Empleados
 * @author gustavo
 * fecha 28/07/2018
 */
@LocalBean
@Stateless
public class EmpleadoDAO extends BaseDao<Empleado, Long> {
	
	public EmpleadoDAO()
	{
		super(Empleado.class);
	}

}
