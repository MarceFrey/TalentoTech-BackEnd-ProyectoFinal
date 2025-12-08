package com.talentotech.talentotech.service;

import com.talentotech.talentotech.dto.request.PedidoRequestDTO;
import com.talentotech.talentotech.dto.request.ProductoPedidoRequestDTO;
import com.talentotech.talentotech.dto.response.PedidoResponseDTO;
import com.talentotech.talentotech.dto.response.ProductoPedidoResponseDTO;
import com.talentotech.talentotech.model.DetallePedido;
import com.talentotech.talentotech.model.Pedido;
import com.talentotech.talentotech.model.Producto;
import com.talentotech.talentotech.repository.PedidoRepository;
import com.talentotech.talentotech.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements IPedidoService{

    private PedidoRepository pediRepo;
    private ProductoRepository produRepo;

    public PedidoService(PedidoRepository pediRepo, ProductoRepository produRepo) {
        this.pediRepo = pediRepo;
        this.produRepo = produRepo;
    }

    @Override
    public List<PedidoResponseDTO> traerPedidos() {
        return pediRepo.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public PedidoResponseDTO trerPedido(int id) {
        Pedido pedido = pediRepo.findById(id).orElse(null);
        if (pedido == null) return null;

        return toResponseDTO(pedido);
    }

    @Override
    public PedidoResponseDTO crearPedido(PedidoRequestDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setEstado(pedidoDTO.getEstado());
        List<DetallePedido> detalles = new ArrayList<>();
        for(ProductoPedidoRequestDTO item : pedidoDTO.getProductosPedidos()){
            Producto producto = produRepo.findById(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getProductoId()));

            DetallePedido detalle = new DetallePedido();
            detalle.setProducto(producto);
            detalle.setCantidadProductos(item.getCantidad());

            detalles.add(detalle);
        }
        pedido.setDetallePedido(detalles);

        Pedido guardado = pediRepo.save(pedido);
        return toResponseDTO(guardado);
    }

    @Override
    public PedidoResponseDTO editarPedido(int idPedido, PedidoRequestDTO pedidoDTO) {

        Pedido pedido = pediRepo.findById(idPedido).orElse(null);
        if (pedido == null) return null;

        pedido.setEstado(pedidoDTO.getEstado());

        pedido.getDetallePedido().clear();

        for (ProductoPedidoRequestDTO item : pedidoDTO.getProductosPedidos()) {

            Producto producto = produRepo.findById(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getProductoId()));

            DetallePedido det = new DetallePedido();
            det.setProducto(producto);
            det.setCantidadProductos(item.getCantidad());

            pedido.getDetallePedido().add(det);
        }

        Pedido actualizado = pediRepo.save(pedido);
        return toResponseDTO(actualizado);
    }

    @Override
    public void borrarPedido(int idPedido) {
         pediRepo.deleteById(idPedido);
    }

    // -------------------------
    // MAPPER: Pedido → PedidoResponseDTO
    // -------------------------
    private PedidoResponseDTO toResponseDTO(Pedido pedido) {
        PedidoResponseDTO dto = new PedidoResponseDTO();

        dto.setIdPedido(pedido.getIdPedido());
        dto.setEstado(pedido.getEstado());

        List<ProductoPedidoResponseDTO> detalles = pedido.getDetallePedido().stream().map(det -> {
            ProductoPedidoResponseDTO d = new ProductoPedidoResponseDTO();

            d.setIdDetalle(det.getId());
            d.setProductoId(det.getProducto().getId());
            d.setNombreProducto(det.getProducto().getNombreProducto());
            d.setPrecioUnitario(det.getProducto().getPrecio());
            d.setCantidad(det.getCantidadProductos());
            d.setSubtotal(det.getProducto().getPrecio() * det.getCantidadProductos());

            return d;
        }).toList();

        dto.setDetalles(detalles);

        return dto;
    }
}
