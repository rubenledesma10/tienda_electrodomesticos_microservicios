package com.example.ventasservicies.repository;

import com.example.ventasservicies.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasRepository extends JpaRepository<Ventas, Long> {
}
