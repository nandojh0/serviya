package com.example.serviYa.dominio;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Solicitud.class)
public abstract class Solicitud_ {

	public static volatile SingularAttribute<Solicitud, String> descripcion;
	public static volatile SingularAttribute<Solicitud, Cliente> cliente;
	public static volatile SingularAttribute<Solicitud, String> tipo;
	public static volatile SingularAttribute<Solicitud, String> resumen;
	public static volatile SingularAttribute<Solicitud, Long> idSolicitud;

	public static final String DESCRIPCION = "descripcion";
	public static final String CLIENTE = "cliente";
	public static final String TIPO = "tipo";
	public static final String RESUMEN = "resumen";
	public static final String ID_SOLICITUD = "idSolicitud";

}

