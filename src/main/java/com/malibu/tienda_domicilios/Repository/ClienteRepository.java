package com.malibu.tienda_domicilios.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.malibu.tienda_domicilios.Model.ProductoModel;

import java.util.List;

import com.malibu.tienda_domicilios.Model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {


    List<ClienteModel> findBynombreContainingIgnoreCase(String keyword);
    
}
