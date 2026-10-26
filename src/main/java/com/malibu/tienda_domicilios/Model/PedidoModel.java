package com.malibu.tienda_domicilios.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora = LocalDateTime.now(); // Se genera automáticamente al crear el pedido
    private String estado = "PENDIENTE"; // Estado inicial del domicilio
    private String metodoPago; // Ejemplo: Nequi, Efectivo, Transferencia

   
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    // Constructores
    public PedidoModel() {
    }

    public PedidoModel(Long id, String metodoPago, ClienteModel cliente) {
        this.id = id;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
}