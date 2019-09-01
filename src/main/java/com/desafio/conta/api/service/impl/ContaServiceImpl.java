package com.desafio.conta.api.service.impl;

import com.desafio.conta.api.document.Conta;
import com.desafio.conta.api.repository.ContaRepository;
import com.desafio.conta.api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    private ContaRepository contaRepository;

    @Autowired
    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Page<Conta> findAll(Pageable pageable) {
        return this.contaRepository.findAll(pageable);
    }

    @Override
    public Conta findById(String id) {
        return this.contaRepository.findOne(id);

    }

    @Override
    public Conta save(Conta conta) {
        conta.setDataCriacao(LocalDate.now());
        conta.setStatus(Boolean.TRUE);
        return this.contaRepository.save(conta);
    }

    @Override
    public Conta update(Conta conta, String id) {
        conta.setDataAtualizacao(LocalDate.now());
        conta.setId(id);
        return this.contaRepository.save(conta);
    }

    @Override
    public void delete(String id) {
        Conta conta = this.contaRepository.findOne(id);
        conta.setStatus(Boolean.FALSE);
        conta.setDataAtualizacao(LocalDate.now());
        this.contaRepository.save(conta);
    }
}
