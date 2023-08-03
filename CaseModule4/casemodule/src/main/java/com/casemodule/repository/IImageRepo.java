package com.casemodule.repository;

import com.casemodule.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepo extends JpaRepository<Image, Integer> {
}
