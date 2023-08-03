package com.casemodule.repository;

import com.casemodule.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepo extends JpaRepository<Status, Integer> {
}
