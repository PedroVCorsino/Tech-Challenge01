package br.com.grupo27.techchallange01.adapter.driver.api.controllers;

import br.com.grupo27.techchallange01.core.application.dto.PedidoDTO;
import br.com.grupo27.techchallange01.core.domain.enums.StatusPedido;
import br.com.grupo27.techchallange01.core.domain.model.Pedido;
import br.com.grupo27.techchallange01.core.domain.ports.service.PedidoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO createdPedido = pedidoService.createPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        try {
            PedidoDTO updatedPedido = pedidoService.updatePedido(id, pedidoDTO);
            if (updatedPedido != null) {
                return ResponseEntity.ok(updatedPedido);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        try {
            PedidoDTO pedido = pedidoService.getPedidoById(id);
            if (pedido != null) {
                return ResponseEntity.ok(pedido);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        try {
            boolean deleted = pedidoService.deletePedido(id);
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
    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> pedidos = pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/verifica-pagamento/{id}")
    public ResponseEntity<Boolean> verificaPagamento(@PathVariable Long id) {
        try {
            PedidoDTO pedidoAtualizado = pedidoService.verificaStatusPagamento(id);
            if (pedidoAtualizado != null) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.ok(false);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }


    @GetMapping("/status-pagamento")
    public ResponseEntity<List<PedidoDTO>> getPedidosByStatusPagamento(@RequestParam boolean pago) {
        try {
            List<PedidoDTO> pedidos = pedidoService.findPedidosByStatusPagamento(pago);
            if (pedidos != null && !pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   @GetMapping("/status/{status}")
    public ResponseEntity<List<Pedido>> getPedidosByStatus(@PathVariable StatusPedido status) {
        try {
            List<Pedido> pedidos = pedidoService.findPedidosByStatus(status);
            if (!pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
