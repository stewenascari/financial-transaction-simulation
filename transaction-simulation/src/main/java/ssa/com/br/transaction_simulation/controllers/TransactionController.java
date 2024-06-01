package ssa.com.br.transaction_simulation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssa.com.br.transaction_simulation.dtos.TransactionRequestDTO;
import ssa.com.br.transaction_simulation.dtos.TransactionResponseDTO;
import ssa.com.br.transaction_simulation.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> insert(@RequestBody @Validated TransactionRequestDTO transactionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(transactionDTO));
    }

    @GetMapping("/{idClient:\\d+}")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransaction(@PathVariable Long ClientId) {
        return ResponseEntity.ok().body(service.getById(ClientId));
    }
}
