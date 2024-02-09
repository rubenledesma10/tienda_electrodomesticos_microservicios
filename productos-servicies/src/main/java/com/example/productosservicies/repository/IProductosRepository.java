package com.example.productosservicies.repository;

import com.example.productosservicies.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<Productos, Long> {
}
