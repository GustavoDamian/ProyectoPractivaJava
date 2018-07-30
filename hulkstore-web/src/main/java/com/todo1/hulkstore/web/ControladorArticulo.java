package com.todo1.hulkstore.web;

import com.todo1.hulkstore.negocio.articulos.GestionArticulos;

public class ControladorArticulo {
	
	private GestionArticulos gestionArticulos;
	
	public void motrarArticulos()
	{
		gestionArticulos.obtenerArticulos();
	}

}
