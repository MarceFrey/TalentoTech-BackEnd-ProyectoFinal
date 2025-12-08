package com.talentotech.talentotech.service;

import com.talentotech.talentotech.dto.request.ProductoRequestDTO;
import com.talentotech.talentotech.dto.response.ProductoResponseDTO;
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
    public List<ProductoResponseDTO> traerProductos() {
        return produRepo.findAll().stream().map(this::toResponseDTO).toList();
    }

    @Override
    public ProductoResponseDTO traerProducto(int id) {
        Producto producto = produRepo.findById(id).orElse(null);
        if (producto == null) return null;
        return toResponseDTO(producto);
    }

    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO productoDTO) {
        Producto producto = toEntity(productoDTO);
        Producto guardado = produRepo.save(producto);
        return toResponseDTO(guardado);
    }

    @Override
    public ProductoResponseDTO editarProducto(int idProducto, ProductoRequestDTO productoDTO) {
        Producto p = produRepo.findById(idProducto).orElse(null);

        if(p == null) return null;

        p.setNombreProducto(productoDTO.getNombreProducto());
        p.setPrecio(productoDTO.getPrecio());
        p.setStock(productoDTO.getStock());

        Producto actualizado = produRepo.save(p);

        return toResponseDTO(actualizado);
    }

    @Override
    public void borrarProducto(int id) {
        produRepo.deleteById(id);
    }

    private ProductoResponseDTO toResponseDTO(Producto producto) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(producto.getId());
        dto.setNombreProducto(producto.getNombreProducto());
        dto.setDescripcion(producto.getDescripcion());
        dto.setImagen(producto.getImagen());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        return dto;
    }

    private Producto toEntity(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombreProducto(dto.getNombreProducto());
        p.setDescripcion(dto.getDescripcion());
        p.setImagen(dto.getImagen());
        p.setPrecio(dto.getPrecio());
        p.setStock(dto.getStock());
        return p;
    }
}
