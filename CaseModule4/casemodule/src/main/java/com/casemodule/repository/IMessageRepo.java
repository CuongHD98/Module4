package com.casemodule.repository;

import com.casemodule.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepo extends JpaRepository<Message, Integer> {
}
