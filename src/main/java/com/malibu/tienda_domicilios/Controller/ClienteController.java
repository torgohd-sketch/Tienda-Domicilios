package com.malibu.tienda_domicilios.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.malibu.tienda_domicilios.Model.ClienteModel;
import com.malibu.tienda_domicilios.Service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteModel> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @GetMapping("/{id}")
    public ClienteModel obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping("/buscar")
    public List<ClienteModel> buscarClientes(@RequestParam String keyword) {
        return clienteService.buscarClientesPorNombre(keyword);
    }

    @PostMapping
    public ClienteModel crearCliente(@RequestBody ClienteModel cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @PutMapping("/{id}")
public ClienteModel actualizarCliente(@PathVariable Long id, @RequestBody ClienteModel cliente) {
    return clienteService.actualizarCliente(id, cliente);
}
}