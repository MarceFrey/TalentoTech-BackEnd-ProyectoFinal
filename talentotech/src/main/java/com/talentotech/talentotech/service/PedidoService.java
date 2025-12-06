package com.talentotech.talentotech.service;

import com.talentotech.talentotech.model.Pedido;
import com.talentotech.talentotech.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService implements IPedidoService{

    private PedidoRepository pediRepo;

    public PedidoService(PedidoRepository pediRepo){
        this.pediRepo = pediRepo;
    }

    @Override
    public List<Pedido> traerPedidos() {
        return pediRepo.findAll();
    }

    @Override
    public Pedido trerPedido(int id) {
        return pediRepo.findById(id).orElse(null);
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pediRepo.save(pedido);
    }

    @Override
    public Pedido editarPedido(int idPedido, Pedido nuevoPedido) {
        Pedido p = pediRepo.findById(idPedido).orElse(null);

        if(p == null){
            return null;
        }

        p.setDetallePedido(nuevoPedido.getDetallePedido());
        p.setEstado(nuevoPedido.getEstado());

        return pediRepo.save(p);
    }

    @Override
    public void borrarPedido(int idPedido) {
         pediRepo.deleteById(idPedido);
    }
}
