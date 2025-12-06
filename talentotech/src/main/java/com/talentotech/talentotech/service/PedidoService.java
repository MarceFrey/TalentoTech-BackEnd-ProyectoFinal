package com.talentotech.talentotech.service;

import com.talentotech.talentotech.model.Pedido;

import java.util.List;

public class PedidoService implements IPedidoService{

    @Override
    public List<Pedido> traerPedidos() {
        return List.of();
    }

    @Override
    public Pedido trerPedido(int id) {
        return null;
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido editarPedido(int idPedido, Pedido nuevoPedido) {
        return null;
    }

    @Override
    public void borrarPedido(int idPedido) {

    }
}
