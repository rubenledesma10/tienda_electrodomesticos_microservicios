package com.example.ventasservicies.service;

import com.example.ventasservicies.dto.CarritoDTO;
import com.example.ventasservicies.dto.VentasDTO;
import com.example.ventasservicies.model.Ventas;
import com.example.ventasservicies.repository.ICarritoAPI;
import com.example.ventasservicies.repository.IVentasRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentasService implements IVentasService {

    @Autowired
    private IVentasRepository ventasRepository;

    @Autowired
    private ICarritoAPI iCarritoAPI;

    @Override
    public List<Ventas> getVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas bringVenta(Long id_venta) {
        return ventasRepository.findById(id_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long id_venta) {
        ventasRepository.deleteById(id_venta);
    }

    @Override
    public void saveVenta(Ventas ventas) {
        ventasRepository.save(ventas);
    }

    @Override
    public void editVenta(Ventas ventas) {
        this.saveVenta(ventas);
    }

    @Override
    @CircuitBreaker(name="carritos-servicies", fallbackMethod = "fallbackGetVentasCarrito")
    @Retry(name="carritos-servicies") //para que reintente comunicarse con el servicio de carrito
    public VentasDTO getVentasCarrito(Long id_carrito) {
        Ventas ventas = this.bringVenta(id_carrito);
        VentasDTO ventasDTO = new VentasDTO();
        CarritoDTO carritoDTO = iCarritoAPI.traerCarrito(id_carrito);
        ventasDTO.setId_venta(ventas.getId_venta());
        ventasDTO.setId_carrito(ventas.getId_carrito());
        ventasDTO.setFecha(ventas.getFecha());
        ventasDTO.setCarritoDTO(carritoDTO);
        //createException();
        return ventasDTO;
    }

    //este es el metodo al que tiene que ir en caso de que no funcione la comunicacion entre los servicios
    public VentasDTO fallbackGetVentasCarrito(Throwable throwable){
        return new VentasDTO(1111111111L, 1111111111L, new Date(1111-11-11), null);
    }

    //creo este metodo que contiene una excepcion para saber si funciona correctamente el circuit breaker
    public void createException(){
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }

}
