package com.desafio.conta.api.controller;

import com.desafio.conta.api.document.Conta;
import com.desafio.conta.api.event.ResourceCreatedEvent;
import com.desafio.conta.api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/contas")
public class ContaController {

    private ContaService contaService;
    private ApplicationEventPublisher publisher;

    @Autowired
    public ContaController(ContaService contaService, ApplicationEventPublisher publisher) {
        this.contaService = contaService;
        this.publisher = publisher;
    }

    @GetMapping
    public ResponseEntity<Page<Conta>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.contaService.findAll(pageable));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Conta> findById(@PathVariable String id) {
        Conta conta = this.contaService.findById(id);
        return conta != null ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Conta> save(@Valid @RequestBody Conta conta, HttpServletResponse response) {
        Conta contaSaved = this.contaService.save(conta);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, contaSaved.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(contaSaved);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Conta> update(@PathVariable String id, @Valid @RequestBody Conta conta) {
        return ResponseEntity.ok().body(this.contaService.update(conta, id));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.contaService.delete(id);
    }
}
