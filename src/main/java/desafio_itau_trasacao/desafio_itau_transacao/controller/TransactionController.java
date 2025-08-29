package desafio_itau_trasacao.desafio_itau_transacao.controller;


import desafio_itau_trasacao.desafio_itau_transacao.dto.TransactionRequest;
import desafio_itau_trasacao.desafio_itau_transacao.entity.Transaction;
import desafio_itau_trasacao.desafio_itau_transacao.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")

public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction (@Valid @RequestBody TransactionRequest request) {
        if (request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction((new Transaction(request.getValor(), request.getDataHora())));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransaction () {
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();
    }
}
