package com.desafio.conta.api.service;

import com.desafio.conta.api.document.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContaService {

    Page<Conta> findAll(Pageable pageable);

    Conta findById(String id);

    Conta save(Conta conta);

    Conta update(Conta conta, String id);

    void delete(String id);
}
