package com.example.productosservicies.controller;

import com.example.productosservicies.model.Productos;
import com.example.productosservicies.service.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private IProductosService productosService;

    @GetMapping("/traer")
    public List<Productos> traerTodos(){
        return productosService.getProductos();
    }

    @PostMapping("/crear")
    public String crearProducto(@RequestBody Productos productos){
        productosService.saveProductos(productos);
        return "Producto creado";
    }

    @DeleteMapping("/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        productosService.deleteProductos(codigo_producto);
        return "Producto eliminado";
    }

    @GetMapping("/traer/{codigo_producto}")
    public Productos traerProductos(@PathVariable Long codigo_producto){
        return productosService.findProductos(codigo_producto);
    }

    @PutMapping("/editar")
    public Productos editarProductos(@RequestBody Productos prod){
        productosService.editProductos(prod);
        return productosService.findProductos(prod.getId_codigo());
    }

    /*
    @GetMapping("/carrito/{id_carrito}")
    public List<Productos> getProductosCarrito(@PathVariable Long id_carrito){
        return productosService.getProductosCarrito(id_carrito);
    }

     */

}
