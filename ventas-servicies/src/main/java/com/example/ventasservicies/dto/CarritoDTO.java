package com.example.ventasservicies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {

    private Long id_carrito;
    private Double precio_total;
    private List<String> listaProductos;

}
