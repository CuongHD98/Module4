package com.casemodule.repository;

import com.casemodule.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFriendshipRepo extends JpaRepository<Friendship, Integer> {
}
