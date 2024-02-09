package com.example.carritosservicies.controller;

import com.example.carritosservicies.dto.CarritoDTO;
import com.example.carritosservicies.dto.ProductosDTO;
import com.example.carritosservicies.model.Carrito;
import com.example.carritosservicies.repository.IProductosAPI;
import com.example.carritosservicies.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ICarritoService carritoService;

    @Autowired
    private IProductosAPI productosAPI;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/traer")
    public List<Carrito> traerCarritos(){
        return carritoService.getCarrito();
    }

    @GetMapping("/{id_carrito}")
    public Carrito traerCarrito(@PathVariable Long id_carrito){
        //System.out.println("Estoy en el puerto: " +serverPort);
        return carritoService.traerCarrito(id_carrito);
    }

    @DeleteMapping("/eliminar/{id_carrito}")
    public String eliminarCarrito(@PathVariable Long id_carrito){
        carritoService.eliminarCarrito(id_carrito);
        return "Carrito eliminado";
    }

    @PostMapping("/crear")
    public String crearCarrito(@RequestBody Carrito carro){
        carritoService.saveCarrito(carro);
        return "Carrito creado";
    }

    @PutMapping("/editar")
    public Carrito editarCarrito (@RequestBody Carrito carro){
        carritoService.editCarrito(carro);
        return carritoService.traerCarrito(carro.getId_carrito());
    }

    @PutMapping("/agregar")
    public String addProductoCarrito (@RequestParam Long id_carrito, @RequestParam Long id_codigo){
        carritoService.addProductoCarrito(id_carrito, id_codigo);
        return "Producto agregado correctamente";
    }

    @PutMapping("/eliminar")
    public String removeProductoCarrito(@RequestParam Long id_carrito, @RequestParam Long id_codigo){
        carritoService.removeProductoCarrito(id_carrito, id_codigo);
        return "Producto quitado correctamente";
    }

}
