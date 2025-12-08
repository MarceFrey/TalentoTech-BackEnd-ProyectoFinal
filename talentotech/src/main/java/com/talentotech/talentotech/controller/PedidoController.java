package com.talentotech.talentotech.controller;

import com.talentotech.talentotech.dto.request.PedidoRequestDTO;
import com.talentotech.talentotech.dto.response.PedidoResponseDTO;
import com.talentotech.talentotech.service.IPedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private IPedidoService pediService;

    public PedidoController (IPedidoService pediService){
        this.pediService = pediService;
    }

    @GetMapping
    public List<PedidoResponseDTO> verPedidos(){
        return pediService.traerPedidos();
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO traerPedido(@PathVariable int id) {
        return pediService.trerPedido(id);
    }

    @PostMapping
    public PedidoResponseDTO crearPedido(@RequestBody PedidoRequestDTO pedido){
        return pediService.crearPedido(pedido);
    }

    @PutMapping("/{id}")
    public PedidoResponseDTO editarPedido(@PathVariable int id, @RequestBody PedidoRequestDTO nuevoPedido){
        return pediService.editarPedido(id , nuevoPedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable int id){
        pediService.borrarPedido(id);
    }

}
