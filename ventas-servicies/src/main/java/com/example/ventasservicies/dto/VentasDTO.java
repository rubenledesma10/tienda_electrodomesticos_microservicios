package com.example.ventasservicies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentasDTO {

    private Long id_venta;
    private Long id_carrito;
    private Date fecha;
    private CarritoDTO carritoDTO;

}
