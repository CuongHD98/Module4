package com.casemodule.repository;

import com.casemodule.model.Message;
import com.casemodule.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepo extends JpaRepository<Message, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Message where receiver_id= :receiver_id")
    List<Message> getAllMessageByAccountId(@Param("receiver_id") int receiver_id);

    @Query(nativeQuery = true, value = "SELECT * FROM Message where (receiver_id= :receiver_id and sender_id= :sender_id) or (receiver_id= :sender_id and sender_id= :receiver_id) ORDER BY id")
    List<Message> getAllMessageBySenderId(@Param("receiver_id") int receiver_id, @Param("sender_id") int sender_id);

    @Query(nativeQuery = true, value = "SELECT * FROM Message where receiver_id= :receiver_id and sender_id= :sender_id ORDER BY id DESC LIMIT 1")
    Message getLastMessageBySenderId(@Param("receiver_id") int receiver_id, @Param("sender_id") int sender_id);

    @Query(nativeQuery = true, value = "SELECT * FROM Message where receiver_id= :receiver_id AND (sender_id,id) IN (SELECT sender_id, MAX(id) as max_id FROM Message WHERE receiver_id= :receiver_id GROUP BY sender_id)")
    List<Message> getAllLastMessageByAccountId(@Param("receiver_id") int receiver_id);
}
