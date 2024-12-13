package tn.esprit.careerlink.services;

import tn.esprit.careerlink.entities.Chat;
import tn.esprit.careerlink.entities.User;

import java.util.List;

public interface IChatService {
    Chat sendMessage(User sender, User receiver, String message);
    List<Chat> getMessagesBetweenUsers(User user1, User user2);
    void markMessageAsRead(Chat message);
    List<Chat> getUnreadMessages(User user);

    void deleteMessage(Integer chatId);

    List<Chat> getSentMessages(User user);
    List<Chat> getReceivedMessages(User user);


}
