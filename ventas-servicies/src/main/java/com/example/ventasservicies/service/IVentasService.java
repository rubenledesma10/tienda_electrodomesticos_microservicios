package com.example.ventasservicies.service;

import com.example.ventasservicies.dto.CarritoDTO;
import com.example.ventasservicies.dto.VentasDTO;
import com.example.ventasservicies.model.Ventas;

import java.util.List;

public interface IVentasService {

    public List<Ventas> getVentas();
    public Ventas bringVenta(Long id_venta);
    public void deleteVenta(Long id_venta);
    public void saveVenta(Ventas ventas);
    public void editVenta(Ventas ventas);
    public VentasDTO getVentasCarrito(Long id_carrito);

}
