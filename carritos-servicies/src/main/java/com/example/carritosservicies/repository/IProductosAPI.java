package com.example.carritosservicies.repository;

import com.example.carritosservicies.dto.ProductosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="productos-servicies")
public interface IProductosAPI {

    @GetMapping("/productos/carrito/{id_carrito}")
    public List<ProductosDTO> getProductosCarrito(@PathVariable("id_carrito") Long id_carrito);

    @GetMapping("/productos/traer/{codigo_producto}")
    public ProductosDTO traerProducto(@PathVariable("codigo_producto") Long codigo_producto);



}
