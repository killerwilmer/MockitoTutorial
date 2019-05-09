package com.killerwilmer.example.layering.data.api.client;

import com.killerwilmer.example.layering.model.impl.client.Client;

/**
 * Data Object for the Client entity.
 */
public interface ClientDO {

    /**
     * Retrieves details of the client.
     * 
     * @param clientId the client id to search for.
     */
    Client getClientDetails(long clientId);

	void saveClient(Client client);
}
