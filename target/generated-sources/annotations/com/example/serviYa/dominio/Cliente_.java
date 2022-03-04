package com.example.serviYa.dominio;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Long> idCliente;
	public static volatile SingularAttribute<Cliente, String> nombreCliente;
	public static volatile SingularAttribute<Cliente, Long> idUsuario;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile SingularAttribute<Cliente, Usuario> usuario;
	public static volatile SingularAttribute<Cliente, String> telefono;
	public static volatile SingularAttribute<Cliente, Long> dni;

	public static final String ID_CLIENTE = "idCliente";
	public static final String NOMBRE_CLIENTE = "nombreCliente";
	public static final String ID_USUARIO = "idUsuario";
	public static final String DIRECCION = "direccion";
	public static final String USUARIO = "usuario";
	public static final String TELEFONO = "telefono";
	public static final String DNI = "dni";

}

