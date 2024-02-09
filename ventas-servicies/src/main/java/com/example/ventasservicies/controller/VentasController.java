package com.example.ventasservicies.controller;

import com.example.ventasservicies.dto.CarritoDTO;
import com.example.ventasservicies.dto.VentasDTO;
import com.example.ventasservicies.model.Ventas;
import com.example.ventasservicies.repository.ICarritoAPI;
import com.example.ventasservicies.service.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private IVentasService iVentasService;

    @Autowired
    private ICarritoAPI iCarritoAPI;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/traer")
    public List<Ventas> getVentas(){
        return iVentasService.getVentas();
    }

    @GetMapping("/traer/venta/{id_venta}")
    public Ventas bringVentas (@PathVariable Long id_venta){
        return iVentasService.bringVenta(id_venta);
    }

    @DeleteMapping("/eliminar/{id_venta}")
    public String deleteVenta(@PathVariable Long id_venta){
        iVentasService.deleteVenta(id_venta);
        return "Venta eliminada";
    }

    @PostMapping("/crear")
    public String crearVenta(@RequestBody Ventas ventas){
        iVentasService.saveVenta(ventas);
        return "Venta creada";
    }

    @PutMapping("/editar")
    public Ventas editVenta(@RequestBody Ventas ventas){
        iVentasService.editVenta(ventas);
        return iVentasService.bringVenta(ventas.getId_venta());
    }

    /*
    @GetMapping("/carrito/{id_carrito}")
    public CarritoDTO traerCarrito(@PathVariable("id_carrito") Long id_carrito){
        return iCarritoAPI.traerCarrito(id_carrito);
    }

     */


    @GetMapping("/carrito/{id_carrito}")
    public VentasDTO getCarritoForVentas(@PathVariable("id_carrito") Long id_carrito){
        //System.out.println("--------- ESTOY EN EL PUERTO " +serverPort); esto es para comprobar que si funciona el springcloud load balancer
        return iVentasService.getVentasCarrito(id_carrito);
    }

}
