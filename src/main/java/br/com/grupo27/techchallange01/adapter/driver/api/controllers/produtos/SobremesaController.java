package br.com.grupo27.techchallange01.adapter.driver.api.controllers.produtos;

import br.com.grupo27.techchallange01.core.application.dto.SobremesaDTO;
import br.com.grupo27.techchallange01.core.domain.ports.service.SobremesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos/sobremesa")
public class SobremesaController {

    private final SobremesaService sobremesaService;

    public SobremesaController(SobremesaService sobremesaService) {
        this.sobremesaService = sobremesaService;
    }

    @PostMapping
    public ResponseEntity<SobremesaDTO> createSobremesa(@RequestBody SobremesaDTO sobremesaDTO) {
        SobremesaDTO createdSobremesa = sobremesaService.createSobremesa(sobremesaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSobremesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SobremesaDTO> updateSobremesa(@PathVariable Long id, @RequestBody SobremesaDTO sobremesaDTO) {
        try {
            SobremesaDTO updatedSobremesa = sobremesaService.updateSobremesa(id, sobremesaDTO);
            if (updatedSobremesa != null) {
                return ResponseEntity.ok(updatedSobremesa);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SobremesaDTO> getSobremesaById(@PathVariable Long id) {
        try {
            SobremesaDTO sobremesa = sobremesaService.getSobremesaById(id);
            if (sobremesa != null) {
                return ResponseEntity.ok(sobremesa);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSobremesa(@PathVariable Long id) {
        try {
            boolean deleted = sobremesaService.deleteSobremesa(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<SobremesaDTO>> getAllSobremesas() {
        List<SobremesaDTO> sobremesas = sobremesaService.getAllSobremesas();
        return ResponseEntity.ok(sobremesas);
    }
}
