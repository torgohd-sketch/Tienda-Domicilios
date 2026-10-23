package com.malibu.tienda_domicilios.Service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
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
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public ClienteModel guardarCliente(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteModel> buscarClientesPorNombre(String keyword) {
        return clienteRepository.findBynombreContainingIgnoreCase(keyword);
    }

}

