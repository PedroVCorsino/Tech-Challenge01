package br.com.grupo27.techchallange01.adapter.driver.api.controllers;

import br.com.grupo27.techchallange01.core.application.dto.*;
import br.com.grupo27.techchallange01.core.domain.ports.service.AcompanhamentoService;
import br.com.grupo27.techchallange01.core.domain.ports.service.BebidaService;
import br.com.grupo27.techchallange01.core.domain.ports.service.LancheService;
import br.com.grupo27.techchallange01.core.domain.ports.service.SobremesaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutosController {

    private final LancheService lancheService;
    private final AcompanhamentoService acompanhamentoService;
    private final BebidaService bebidaService;
    private final SobremesaService sobremesaService;

    public ProdutosController(LancheService lancheService, AcompanhamentoService acompanhamentoService, BebidaService bebidaService, SobremesaService sobremesaService) {
        this.lancheService = lancheService;
        this.acompanhamentoService = acompanhamentoService;
        this.bebidaService = bebidaService;
        this.sobremesaService = sobremesaService;
    }

    @PostMapping("/lanche")
    public ResponseEntity<LancheDTO> createLanche(@RequestBody LancheDTO lancheDTO) {
        LancheDTO createdLanche = lancheService.createLanche(lancheDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLanche);
    }

    @PutMapping("/lanche/{id}")
    public ResponseEntity<LancheDTO> updateLanche(@PathVariable Long id, @RequestBody LancheDTO lancheDTO) {
        try {
            LancheDTO updatedLanche = lancheService.updateLanche(id, lancheDTO);
            if (updatedLanche != null) {
                return ResponseEntity.ok(updatedLanche);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/lanche/{id}")
    public ResponseEntity<LancheDTO> getLancheById(@PathVariable Long id) {
        try {
            LancheDTO lanche = lancheService.getLancheById(id);
            if (lanche != null) {
                return ResponseEntity.ok(lanche);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/lanche/{id}")
    public ResponseEntity<Void> deleteLanche(@PathVariable Long id) {
        try {
            boolean deleted = lancheService.deleteLanche(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/lanche/all")
    public ResponseEntity<List<LancheDTO>> getAllLanches() {
        List<LancheDTO> lanches = lancheService.getAllLanches();
        return ResponseEntity.ok(lanches);
    }

    @PostMapping("/acompanhamento")
    public ResponseEntity<AcompanhamentoDTO> createAcompanhamento(@RequestBody AcompanhamentoDTO acompanhamentoDTO) {
        AcompanhamentoDTO createdAcompanhamento = acompanhamentoService.createAcompanhamento(acompanhamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAcompanhamento);
    }

    @PutMapping("/acompanhamento/{id}")
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

    @GetMapping("/acompanhamento/{id}")
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

    @DeleteMapping("/acompanhamento/{id}")
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

    @GetMapping("/acompanhamento/all")
    public ResponseEntity<List<AcompanhamentoDTO>> getAllAcompanhamentos() {
        List<AcompanhamentoDTO> acompanhamentos = acompanhamentoService.getAllAcompanhamentos();
        return ResponseEntity.ok(acompanhamentos);
    }

    @PostMapping("/bebida")
    public ResponseEntity<BebidaDTO> createBebida(@RequestBody BebidaDTO bebidaDTO) {
        BebidaDTO createdBebida = bebidaService.createBebida(bebidaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBebida);
    }

    @PutMapping("/bebida/{id}")
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

    @GetMapping("/bebida/{id}")
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

    @DeleteMapping("/bebida/{id}")
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

    @GetMapping("/bebida/all")
    public ResponseEntity<List<BebidaDTO>> getAllBebidas() {
        List<BebidaDTO> bebidas = bebidaService.getAllBebidas();
        return ResponseEntity.ok(bebidas);
    }

    @PostMapping("/sobremesa")
    public ResponseEntity<SobremesaDTO> createSobremesa(@RequestBody SobremesaDTO sobremesaDTO) {
        SobremesaDTO createdSobremesa = sobremesaService.createSobremesa(sobremesaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSobremesa);
    }

    @PutMapping("/sobremesa/{id}")
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

    @GetMapping("/sobremesa/{id}")
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

    @DeleteMapping("/sobremesa/{id}")
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

    @GetMapping("/sobremesa/all")
    public ResponseEntity<List<SobremesaDTO>> getAllSobremesas() {
        List<SobremesaDTO> sobremesas = sobremesaService.getAllSobremesas();
        return ResponseEntity.ok(sobremesas);
    }
}
