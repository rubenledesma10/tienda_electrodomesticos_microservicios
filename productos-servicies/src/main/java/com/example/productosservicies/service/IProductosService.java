package com.example.productosservicies.service;

import com.example.productosservicies.model.Productos;

import java.util.List;

public interface IProductosService {

    public List<Productos> getProductos();

    public void saveProductos(Productos productos);
    public void deleteProductos(Long codigo_producto);
    public Productos findProductos(Long codigo_producto);
    public void editProductos(Productos productos);

}
