package com.talentotech.talentotech.controller;

import com.talentotech.talentotech.model.Pedido;
import com.talentotech.talentotech.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    private PedidoService pediService;

    public PedidoController (PedidoService pediService){
        this.pediService = pediService;
    }

    @GetMapping
    public List<Pedido> verPedidos(){
        return pediService.traerPedidos();
    }

    @GetMapping("/{id}")
    public Pedido traerPedido(@PathVariable int id) {
        return pediService.trerPedido(id);
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido){
        return pediService.crearPedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido editarPedido(@PathVariable int id, @RequestBody Pedido nuevoPedido){
        return pediService.editarPedido(id , nuevoPedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable int id){
        pediService.borrarPedido(id);
    }

}
