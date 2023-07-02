package br.com.grupo27.techchallange01.adapter.driver.api.controllers.produtos;

import br.com.grupo27.techchallange01.core.application.dto.BebidaDTO;
import br.com.grupo27.techchallange01.core.domain.ports.service.BebidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos/bebida")
public class BebidaController {

    private final BebidaService bebidaService;

    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @PostMapping
    public ResponseEntity<BebidaDTO> createBebida(@RequestBody BebidaDTO bebidaDTO) {
        BebidaDTO createdBebida = bebidaService.createBebida(bebidaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBebida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BebidaDTO> updateBebida(@PathVariable Long id, @RequestBody BebidaDTO bebidaDTO) {
        try {
            BebidaDTO updatedBebida = bebidaService.updateBebida(id, bebidaDTO);
            if (updatedBebida != null) {
                return ResponseEntity.ok(updatedBebida);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BebidaDTO> getBebidaById(@PathVariable Long id) {
        try {
            BebidaDTO bebida = bebidaService.getBebidaById(id);
            if (bebida != null) {
                return ResponseEntity.ok(bebida);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBebida(@PathVariable Long id) {
        try {
            boolean deleted = bebidaService.deleteBebida(id);
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
    public ResponseEntity<List<BebidaDTO>> getAllBebidas() {
        List<BebidaDTO> bebidas = bebidaService.getAllBebidas();
        return ResponseEntity.ok(bebidas);
    }
}
