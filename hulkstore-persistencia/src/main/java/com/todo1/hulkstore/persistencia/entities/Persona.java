package com.todo1.hulkstore.persistencia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
    
    @Id
    Long codigoPersona;    
    String nombreApellido;
    String Identificacion;
    String Agencia;    
    
}
