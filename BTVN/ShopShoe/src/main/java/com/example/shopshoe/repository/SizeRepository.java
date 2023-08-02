package com.example.shopshoe.repository;

import com.example.shopshoe.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
}
