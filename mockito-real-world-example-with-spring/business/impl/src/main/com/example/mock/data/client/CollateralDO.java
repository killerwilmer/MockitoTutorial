package com.killerwilmer.example.layering.data.api.client;

import java.util.List;

import com.killerwilmer.example.layering.model.impl.client.Collateral;

/**
 * Data Object for the Client entity.
 */
public interface CollateralDO {

    /**
     * Retrieve collaterals for the client.
     * 
     * @param clientId client id.
     */
    List<Collateral> getAllCollaterals(long clientId);
}
