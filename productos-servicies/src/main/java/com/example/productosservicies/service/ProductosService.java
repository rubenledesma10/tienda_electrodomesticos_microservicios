package com.example.productosservicies.service;

import com.example.productosservicies.model.Productos;
import com.example.productosservicies.repository.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosService implements IProductosService {



    @Autowired
    private IProductosRepository productosRepository;

    @Override
    public List<Productos> getProductos() {
        return productosRepository.findAll();
    }

    @Override
    public void saveProductos(Productos productos) {
        productosRepository.save(productos);
    }

    @Override
    public void deleteProductos(Long codigo_producto) {
        productosRepository.deleteById(codigo_producto);
    }

    @Override
    public Productos findProductos(Long codigo_producto) {
        return productosRepository.findById(codigo_producto).orElse(null);
    }

    @Override
    public void editProductos(Productos prod) {
        this.saveProductos(prod);
    }
    /*
    @Override
    public List<Productos> getProductosCarrito(Long id_carrito) {
        List<Productos> productosList = productosRepository.findAll();
        List<Productos> productosCarrito = new ArrayList<Productos>();
        for(Productos p:productosList){
            if(p.getId_carrito()==id_carrito){
                productosCarrito.add(p);
            }
        }
        return productosCarrito;
    }

     */
}
