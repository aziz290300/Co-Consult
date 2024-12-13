package tn.esprit.careerlink.services.Impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.careerlink.entities.Chat;
import tn.esprit.careerlink.entities.MessageStatus;
import tn.esprit.careerlink.entities.User;
import tn.esprit.careerlink.repositories.ChatRepository;
import tn.esprit.careerlink.repositories.UserRepository;
import tn.esprit.careerlink.services.IChatService;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChatServiceImpl implements IChatService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Chat sendMessage(User sender, User receiver, String message) {
        Chat chat = new Chat();
        chat.setContent(message);
        chat.setSender(sender);
        chat.setReceiver(receiver);
        chat.setTimestamp(LocalDate.now());
        chat.setStatus(MessageStatus.UNREAD);
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getMessagesBetweenUsers(User user1, User user2) {
        return chatRepository.findBySenderAndReceiverOrSenderAndReceiverOrderByTimestampAsc(user1, user2, user2, user1);
    }
    @Override
    public List<Chat> getReceivedMessages(User user) {
        return chatRepository.findByReceiver(user);
    }
    @Override
    public void markMessageAsRead(Chat message) {
        message.setStatus(MessageStatus.READ);
        chatRepository.save(message);
    }

    @Override
    public List<Chat> getUnreadMessages(User user) {
        return chatRepository.findByReceiverAndStatus(user, MessageStatus.UNREAD);
    }




    @Override
    public List<Chat> getSentMessages(User user) {
        return chatRepository.findBySender(user);
    }

    @Override
    public void deleteMessage(Integer chatId) {
        chatRepository.deleteById(chatId);
    }

}
