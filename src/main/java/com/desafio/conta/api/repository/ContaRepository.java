package com.desafio.conta.api.repository;


import com.desafio.conta.api.document.Conta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContaRepository extends MongoRepository<Conta, String> {
}
