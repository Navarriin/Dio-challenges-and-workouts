package com.navarro.padroesprojetospring.PPS.service;

import com.navarro.padroesprojetospring.PPS.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    Address consultCep(@PathVariable("cep") String cep);
}
