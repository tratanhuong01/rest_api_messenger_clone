package commessenger_app.clone_messenger.message;

import commessenger_app.clone_messenger.DTO.MessageGroupUser;
import commessenger_app.clone_messenger.DTO.Nickname;
import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @CrossOrigin
    @GetMapping("messages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @CrossOrigin
    @GetMapping("messages/{id}")
    public Optional<Message> getMessageById(@PathVariable  String id) {
        return messageService.getMessageById(id);
    }

    @CrossOrigin
    @PostMapping("messages")
    public Message addMessages(@RequestBody Message message) {
        return messageService.addMessages(message);
    }

    @CrossOrigin
    @PostMapping("messagesGroup")
    public Message addMessagesGroup(@RequestBody List<Message> messageList) {
        return messageService.addMessagesGroup(messageList);
    }

    @CrossOrigin
    @GetMapping("messagesByGroupMessage/{id}")
    public List<MessageGroupUser> getMessagesByGroupMessage(@PathVariable String id) {
        return messageService.getMessagesByGroupMessage(id);
    }

    @CrossOrigin
    @GetMapping("getDistinctGroupMessageById/{id}")
    public List<String> getDistinctGroupMessageById(@PathVariable String id) {
        return messageService.getDistinctGroupMessageById(id);
    }

    @CrossOrigin
    @GetMapping("createAllMessagesUser/{id}")
    public List<List<MessageGroupUser>> createAllMessagesUser(@PathVariable String id) {
        return messageService.createAllMessagesUser(id);
    }

    @CrossOrigin
    @GetMapping("getListGroupMessageById/{id}")
    public List<List<MessageGroupUser>> getListGroupMessageById(@PathVariable String id) {
        return messageService.getListGroupMessage(id);
    }

    @CrossOrigin
    @GetMapping("getIdNewMessage")
    public Message getIdBestNew() {
        return messageService.getIDBestNew();
    }

    @CrossOrigin
    @PutMapping("updateMessage/nickName")
    public int updateNickNameByUser(@RequestBody Nickname nickname) {
        return messageService.updateNickNameByUser(nickname.getNameNickName(),
                nickname.getIdGroupMessage(),nickname.getIdUser());
    }
}
