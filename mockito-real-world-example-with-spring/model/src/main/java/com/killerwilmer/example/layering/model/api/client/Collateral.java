package com.killerwilmer.example.layering.model.api.client;

/**
 * Collateral Model API.
 */
public interface Collateral {
	
	long getId();
	
	String getName();

    CollateralType getType();
}
