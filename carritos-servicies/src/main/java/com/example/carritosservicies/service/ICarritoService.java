package com.example.carritosservicies.service;

import com.example.carritosservicies.dto.CarritoDTO;
import com.example.carritosservicies.model.Carrito;

import java.util.List;

public interface ICarritoService {

    public List<Carrito> getCarrito();
    public Carrito traerCarrito(Long id_carrito);
    public void eliminarCarrito(Long id_carrito);
    public void saveCarrito(Carrito carro);
    public void editCarrito(Carrito carro);
    public Carrito addProductoCarrito (Long id_carrito, Long codigo_producto);
    public Carrito removeProductoCarrito(Long id_carrito, Long codigo_producto);

}
