package com.talentotech.talentotech.service;

import com.talentotech.talentotech.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> traerProductos();
    Producto traerProducto(int id);
    Producto crearProducto(Producto producto);
    Producto editarProducto(int idProducto, Producto producto);
    void borrarProducto(int id);
}
