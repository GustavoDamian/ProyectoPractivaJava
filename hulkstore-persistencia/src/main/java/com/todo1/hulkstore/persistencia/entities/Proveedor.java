package com.todo1.hulkstore.persistencia.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Proveedor {    
    @Id
    Long codigoProveedor;
    String nombre;
    Date fechaRegistro;
    Date fechaAlta;
}
