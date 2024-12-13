package tn.esprit.careerlink.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.careerlink.entities.Chat;
import tn.esprit.careerlink.entities.User;
import tn.esprit.careerlink.services.IChatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private final IChatService chatService;

    @PostMapping("/send")
    public Chat sendMessage(@RequestParam("senderId") Integer senderId,
                            @RequestParam("receiverId") Integer receiverId,
                            @RequestParam("message") String message) {
        User sender = new User();
        sender.setId(senderId);
        User receiver = new User();
        receiver.setId(receiverId);
        return chatService.sendMessage(sender, receiver, message);
    }

    @GetMapping("/between")
    public List<Chat> getMessagesBetweenUsers(@RequestParam("user1Id") Integer user1Id,
                                              @RequestParam("user2Id") Integer user2Id) {
        User user1 = new User();
        user1.setId(user1Id);
        User user2 = new User();
        user2.setId(user2Id);
        return chatService.getMessagesBetweenUsers(user1, user2);
    }

    @GetMapping("/received")
    public List<Chat> getReceivedMessages(@RequestParam("userId") Integer userId) {
        User user = new User();
        user.setId(userId);
        return chatService.getReceivedMessages(user);
    }

    @GetMapping("/unread")
    public List<Chat> getUnreadMessages(@RequestParam("userId") Integer userId) {
        User user = new User();
        user.setId(userId);
        return chatService.getUnreadMessages(user);
    }

    @DeleteMapping("/delete")
    public void deleteMessage(@RequestParam("chatId") Integer chatId) {
        chatService.deleteMessage(chatId);
    }




}
