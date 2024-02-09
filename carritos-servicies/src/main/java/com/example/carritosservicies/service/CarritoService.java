package com.example.carritosservicies.service;

import com.example.carritosservicies.dto.CarritoDTO;
import com.example.carritosservicies.dto.ProductosDTO;
import com.example.carritosservicies.model.Carrito;
import com.example.carritosservicies.repository.ICarritoRepository;
import com.example.carritosservicies.repository.IProductosAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService implements ICarritoService {

    @Autowired
    private ICarritoRepository carritoRepository;

    @Autowired
    private IProductosAPI productosAPI;

    @Override
    public List<Carrito> getCarrito() {
        return carritoRepository.findAll();
    }

    @Override
    public Carrito traerCarrito(Long id_carrito) {
        return carritoRepository.findById(id_carrito).orElse(null);
    }

    @Override
    public void eliminarCarrito(Long id_carrito) {
        carritoRepository.deleteById(id_carrito);
    }

    @Override
    public void saveCarrito(Carrito carro) {
        carritoRepository.save(carro);
    }

    @Override
    public void editCarrito(Carrito carro) {
        this.saveCarrito(carro);
    }

    @Override
    public Carrito addProductoCarrito(Long id_carrito, Long codigo_producto) {
        Carrito carrito = this.traerCarrito(id_carrito);
        ProductosDTO productosDTO = productosAPI.traerProducto(codigo_producto);
        carrito.getListaProductos().add(productosDTO.getNombre());
        carrito.setPrecio_total(carrito.getPrecio_total() + productosDTO.getPrecio_individual());
        carritoRepository.save(carrito);
        return carrito;
    }

    @Override
    public Carrito removeProductoCarrito(Long id_carrito, Long codigo_producto) {
        Carrito carrito = this.traerCarrito(id_carrito);
        ProductosDTO productosDTO = productosAPI.traerProducto(codigo_producto);
        carrito.getListaProductos().remove(productosDTO.getNombre());
        carrito.setPrecio_total(carrito.getPrecio_total() - productosDTO.getPrecio_individual());
        carritoRepository.save(carrito);
        return carrito;
    }

}
