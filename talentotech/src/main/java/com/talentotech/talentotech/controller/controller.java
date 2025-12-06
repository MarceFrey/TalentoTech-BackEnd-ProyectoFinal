package com.talentotech.talentotech.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    @GetMapping("/hello/{nombre}/{profesion}")
    public String sayHello(@PathVariable String nombre, @PathVariable String profesion){
        return "Hola " + nombre + " - " + profesion;
    }

    @GetMapping("/bye")
    public String sayBye(@RequestParam String nombre, @RequestParam String mensaje){
        return "Adios " + nombre + " - " + mensaje;
    }
/*
    @PostMapping("/crearcliente")
    public void crearCliente(@RequestBody Client cliente){
        System.out.println("Cliente");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
    }

    @GetMapping("/cliente/traer")
    @ResponseBody
    public List<Client> traerCliente(){
        List<Client> listaClientes = new ArrayList<Client>();

        listaClientes.add(new Client(1L,"Marcelo","Frey"));
        listaClientes.add(new Client(2L,"Keila","Oliva"));

        return listaClientes;
    }

    @GetMapping("/pedido/{id}")
    @ResponseBody
    public PedidoDTO verPedido(@PathVariable Long id){
        Client cliente = new Client(1L,"Marcelo","Frey");
        Product product = new Product(1L, "Zapatillas", 95);

        PedidoDTO pedido = new PedidoDTO();

        pedido.setId(5L);
        pedido.setCliente(cliente.getNombre());
        pedido.setPrecio(product.getPrecio());
        pedido.setProducto(product.getNombreProducto());

        return pedido;
    }

 */
}
