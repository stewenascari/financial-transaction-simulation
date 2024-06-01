package ssa.com.br.transaction_simulation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssa.com.br.transaction_simulation.dtos.ClientRequestDTO;
import ssa.com.br.transaction_simulation.dtos.ClientResponseDTO;
import ssa.com.br.transaction_simulation.services.ClientService;

@RestController
@RequestMapping("clientes")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> insert(@RequestBody @Validated ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(clientRequestDTO));
    }

    @GetMapping("/id/{id:\\d+}")
    public ResponseEntity<ClientResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping("/{conta}")
    public ResponseEntity<ClientResponseDTO> getByConta(@PathVariable String conta) {
        return ResponseEntity.ok().body(service.getByConta(conta));
    }

    @PutMapping("{id:\\d+}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @RequestBody ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.ok().body(service.update(id, clientRequestDTO));
    }

    @DeleteMapping("{id:\\d+}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }

}
