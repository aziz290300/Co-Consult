package tn.esprit.careerlink.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.careerlink.entities.Chat;
import tn.esprit.careerlink.entities.MessageStatus;
import tn.esprit.careerlink.entities.User;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findBySender(User user);



    List<Chat> findByReceiverAndStatus(User receiver, MessageStatus status);


    List<Chat> findBySenderAndReceiverOrSenderAndReceiverOrderByTimestampAsc(User sender1, User receiver1, User sender2, User receiver2);
    List<Chat> findByReceiver(User receiver);
}