package com.talentotech.talentotech.service;

import com.talentotech.talentotech.model.Pedido;

import java.util.List;

public interface IPedidoService {
    List<Pedido> traerPedidos();
    Pedido trerPedido(int id);
    Pedido crearPedido(Pedido pedido);
    Pedido editarPedido(int idPedido, Pedido nuevoPedido);
    void borrarPedido(int idPedido);
}
