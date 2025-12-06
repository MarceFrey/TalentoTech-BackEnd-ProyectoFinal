package com.talentotech.talentotech.dto;

import com.talentotech.talentotech.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PedidoDTO {
    private int idPedido;
    private ArrayList<Producto> productos;
    private String estado;
}
