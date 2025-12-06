package com.talentotech.talentotech.controller;

import com.talentotech.talentotech.model.Producto;
import com.talentotech.talentotech.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    private  ProductoService produService;

    public ProductoController(ProductoService productService) {
        this.produService = productService;
    }

    @GetMapping
    public List<Producto> traerProductos(){
        return produService.traerProductos();
    }

    @GetMapping("/{id}")
    public Producto traerProducto(@PathVariable int id){
        return produService.traerProducto(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return produService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto editarProducto(@PathVariable int id, @RequestBody Producto producto){
        return produService.editarProducto(id, producto);
    }

    @DeleteMapping ("/{id}")
    public void eliminarProducto(@PathVariable int id){
        produService.borrarProducto(id);
    }
}
