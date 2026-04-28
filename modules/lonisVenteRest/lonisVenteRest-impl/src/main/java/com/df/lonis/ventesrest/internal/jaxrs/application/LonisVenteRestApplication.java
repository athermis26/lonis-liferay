package com.df.lonis.ventesrest.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author HP
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false", "osgi.jaxrs.application.base=/lonisVenteRest",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=LonisVenteRest"
	},
	service = Application.class
)
@Generated("")
public class LonisVenteRestApplication extends Application {
}