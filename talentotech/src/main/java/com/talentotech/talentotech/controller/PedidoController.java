package com.talentotech.talentotech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    @GetMapping
    public String verPedidos(){
        return "Lista de Pedidos";
    }

}
