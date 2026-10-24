package com.malibu.tienda_domicilios.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.malibu.tienda_domicilios.Model.ClienteModel;
import com.malibu.tienda_domicilios.Repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public ClienteModel obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public ClienteModel guardarCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteModel> buscarClientesPorNombre(String keyword) {
        return clienteRepository.findBynombreContainingIgnoreCase(keyword);
    }

    public ClienteModel actualizarCliente(Long id, ClienteModel datos) {
    ClienteModel cliente = obtenerClientePorId(id);
    cliente.setNombre(datos.getNombre());
    cliente.setTelefono(datos.getTelefono());
    cliente.setApartamento(datos.getApartamento());
    return clienteRepository.save(cliente);
}
}