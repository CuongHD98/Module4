package com.casemodule.repository;

import com.casemodule.model.Friendship;
import com.casemodule.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificationRepo extends JpaRepository<Notification, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Notification where account_id= :account_id")
    List<Notification> getAllNotificationByAccountId(@Param("account_id") int account_id);
}
