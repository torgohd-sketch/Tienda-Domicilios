package com.malibu.tienda_domicilios.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.malibu.tienda_domicilios.Model.ProductoModel;
import com.malibu.tienda_domicilios.Repository.ProductoRepository;

@Service 
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    
    public List<ProductoModel> obtenerProductos() {
        return productoRepository.findByEstadoTrue();
    }
 
    
    public ProductoModel guardarProducto(@RequestBody ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public ProductoModel obtenerPorId(Long id) {
    return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public ProductoModel actualizarProducto(Long id, ProductoModel DatosNuevos){
        ProductoModel producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(DatosNuevos.getNombre());
        producto.setPrecio(DatosNuevos.getPrecio());

         return productoRepository.save(producto);

    }

    public ProductoModel cambiarEstado(Long id){
        ProductoModel producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setEstado(!producto.getEstado());

        return productoRepository.save(producto);
    }

    public  List<ProductoModel> buscarPalabra(String keyword){

        return productoRepository.findBynombreContainingIgnoreCase(keyword);
    }

    public ProductoModel buscarPorId(Long id) {
    return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
}


}
