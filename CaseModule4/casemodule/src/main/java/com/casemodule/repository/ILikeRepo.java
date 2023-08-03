package com.casemodule.repository;

import com.casemodule.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepo extends JpaRepository<Like, Integer> {
}
