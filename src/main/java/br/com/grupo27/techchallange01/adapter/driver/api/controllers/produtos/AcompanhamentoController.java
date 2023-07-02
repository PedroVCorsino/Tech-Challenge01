package br.com.grupo27.techchallange01.adapter.driver.api.controllers.produtos;

import br.com.grupo27.techchallange01.core.application.dto.AcompanhamentoDTO;
import br.com.grupo27.techchallange01.core.domain.ports.service.AcompanhamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos/acompanhamento")
public class AcompanhamentoController {

    private final AcompanhamentoService acompanhamentoService;

    public AcompanhamentoController(AcompanhamentoService acompanhamentoService) {
        this.acompanhamentoService = acompanhamentoService;
    }

    @PostMapping
    public ResponseEntity<AcompanhamentoDTO> createAcompanhamento(@RequestBody AcompanhamentoDTO acompanhamentoDTO) {
        AcompanhamentoDTO createdAcompanhamento = acompanhamentoService.createAcompanhamento(acompanhamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAcompanhamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcompanhamentoDTO> updateAcompanhamento(@PathVariable Long id, @RequestBody AcompanhamentoDTO acompanhamentoDTO) {
        try {
            AcompanhamentoDTO updatedAcompanhamento = acompanhamentoService.updateAcompanhamento(id, acompanhamentoDTO);
            if (updatedAcompanhamento != null) {
                return ResponseEntity.ok(updatedAcompanhamento);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcompanhamentoDTO> getAcompanhamentoById(@PathVariable Long id) {
        try {
            AcompanhamentoDTO acompanhamento = acompanhamentoService.getAcompanhamentoById(id);
            if (acompanhamento != null) {
                return ResponseEntity.ok(acompanhamento);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcompanhamento(@PathVariable Long id) {
        try {
            boolean deleted = acompanhamentoService.deleteAcompanhamento(id);
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
    public ResponseEntity<List<AcompanhamentoDTO>> getAllAcompanhamentos() {
        List<AcompanhamentoDTO> acompanhamentos = acompanhamentoService.getAllAcompanhamentos();
        return ResponseEntity.ok(acompanhamentos);
    }
}
