package com.todo1.hulkstore.persistencia.entities;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Inventario.class)
public class Inventario_ {
public static volatile SingularAttribute<Inventario, Long>  codigoInventario;
public static volatile SingularAttribute<Inventario, Long>  cantidadArticuloEntrada;
public static volatile SingularAttribute<Inventario, Long>  cantidadArticuloSalida;
public static volatile SingularAttribute<Inventario, Date>  fechaRegistro;
public static volatile SingularAttribute<Inventario, Articulo >  articulo;
}
