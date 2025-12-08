package com.talentotech.talentotech.service;

import com.talentotech.talentotech.dto.request.PedidoRequestDTO;
import com.talentotech.talentotech.dto.response.PedidoResponseDTO;
import com.talentotech.talentotech.model.Pedido;

import java.util.List;

public interface IPedidoService {
    List<PedidoResponseDTO> traerPedidos();
    PedidoResponseDTO trerPedido(int id);
    PedidoResponseDTO crearPedido(PedidoRequestDTO pedidoDTO);
    PedidoResponseDTO editarPedido(int idPedido, PedidoRequestDTO pedidoDTO);
    void borrarPedido(int idPedido);
}
