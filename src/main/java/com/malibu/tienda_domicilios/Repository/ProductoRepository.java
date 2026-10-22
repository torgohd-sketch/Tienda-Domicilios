package com.malibu.tienda_domicilios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.malibu.tienda_domicilios.Model.ProductoModel;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {


    List<ProductoModel> findBynombreContainingIgnoreCase(String keyword);
    List<ProductoModel> findByEstadoTrue();
}