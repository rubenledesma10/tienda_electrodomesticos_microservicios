package com.example.ventasservicies.repository;

import com.example.ventasservicies.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="carritos-servicies")
public interface ICarritoAPI {

    @GetMapping("/carrito/{id_carrito}")
    public CarritoDTO traerCarrito(@PathVariable("id_carrito") Long id_carrito);

}
