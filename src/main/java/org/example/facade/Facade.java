package org.example.facade;

import subSystem1.crm.CrmService;
import subSystem2.cep.CepAPI;

public class Facade {

    public void migrateClient(String name, String cep) {
        String city = CepAPI.getInstance().recoverTheCity(cep);
        String state = CepAPI.getInstance().recoverTheState(cep);


        CrmService.toRecordClient(name, cep, city, state);
    }
}
