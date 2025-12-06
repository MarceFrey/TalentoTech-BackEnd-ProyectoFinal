package com.talentotech.talentotech.service;

import com.talentotech.talentotech.model.Producto;
import com.talentotech.talentotech.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    private ProductoRepository produRepo;

    public ProductoService(ProductoRepository productoRepository) {
        this.produRepo = productoRepository;
    }

    @Override
    public List<Producto> traerProductos() {
        return produRepo.findAll();
    }

    @Override
    public Producto traerProducto(int id) {
        return produRepo.findById(id).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return produRepo.save(producto);
    }

    @Override
    public Producto editarProducto(int idProducto, Producto producto) {
        Producto p = produRepo.findById(idProducto).orElse(null);

        if(p == null) return null;

        p.setNombreProducto(producto.getNombreProducto());
        p.setPrecio(producto.getPrecio());
        p.setStock(producto.getStock());

        return produRepo.save(p);
    }

    @Override
    public void borrarProducto(int id) {
        produRepo.deleteById(id);
    }
}
