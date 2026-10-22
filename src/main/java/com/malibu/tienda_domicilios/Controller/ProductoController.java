package com.malibu.tienda_domicilios.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.malibu.tienda_domicilios.Model.ProductoModel;
import com.malibu.tienda_domicilios.Service.ProductoService;




@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    
    private ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoModel> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @PostMapping
    public ProductoModel crearProducto(@RequestBody ProductoModel producto) {
        return productoService.guardarProducto(producto);
    }
    
    @PutMapping("/{id}")
    public ProductoModel actualizarProducto(@PathVariable Long id, @RequestBody ProductoModel producto) {
        
        return productoService.actualizarProducto(id, producto);
    }

    @PatchMapping("/{id}/estado")
    public ProductoModel cambiarEstado(@PathVariable Long id){
        return productoService.cambiarEstado(id);

    }

    @GetMapping("/buscar")
    public List<ProductoModel> buscarPalabra(@RequestParam String keyword) {
    return productoService.buscarPalabra(keyword);
    }
    

    @GetMapping("/{id}")
    public ProductoModel buscarPorId(@PathVariable Long id) {
    return productoService.buscarPorId(id);
    }

}

