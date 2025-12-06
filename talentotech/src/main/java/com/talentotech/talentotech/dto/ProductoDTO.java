package com.talentotech.talentotech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductoDTO {
    private int id;
    private String nombreProducto;
    private float precio;
    private int stock;
}
