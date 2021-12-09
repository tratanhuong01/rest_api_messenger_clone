package commessenger_app.clone_messenger.message;

import commessenger_app.clone_messenger.DTO.MessageDetail;
import commessenger_app.clone_messenger.DTO.MessageGroupUser;
import commessenger_app.clone_messenger.DTO.Nickname;
import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
  public Optional<Message> getMessageById(@PathVariable String id) {
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
  public List<MessageDetail> getMessagesByGroupMessage(@PathVariable String id) {
    return messageService.getMessagesByGroupMessage(id);
  }

  @CrossOrigin
  @GetMapping("getDistinctGroupMessageById/{id}")
  public List<String> getDistinctGroupMessageById(@PathVariable String id) throws ParseException {
    return messageService.getDistinctGroupMessageById(id);
  }

  @CrossOrigin
  @GetMapping("createAllMessagesUser/{id}")
  public List<List<MessageDetail>> createAllMessagesUser(@PathVariable String id) throws ParseException {
    return messageService.createAllMessagesUser(id);
  }

  @CrossOrigin
  @GetMapping("createAllMessagesUserWait/{id}")
  public List<List<MessageDetail>> createAllMessagesUserWait(@PathVariable String id) throws ParseException {
    return messageService.createAllMessagesUserWait(id);
  }

  @CrossOrigin
  @GetMapping("getListGroupMessageById/{id}")
  public List<List<MessageDetail>> getListGroupMessageById(@PathVariable String id) {
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
        nickname.getIdGroupMessage(), nickname.getIdUser());
  }

  @CrossOrigin
  @GetMapping("getGroupMessage/{idMain}/{idView}")
  public Message getGroupMessageByUserIdAndIdGroupMessage(@PathVariable String idMain,@PathVariable String idView) {
    return messageService.getGroupMessageByUserIdAndIdGroupMessage(idMain,idView);
  }

  @CrossOrigin
  @DeleteMapping("deleteMessages/{idGroupMessage}/{idUser}")
  public int deleteMemberOutGroup(@PathVariable String idGroupMessage,@PathVariable String idUser) {
    return messageService.deleteMemberOutGroup(idGroupMessage,idUser);
  }

  @CrossOrigin
  @GetMapping("getMemberGroupChat/{idGroupMessage}")
  public List<Optional<User>> listMemberGroupChat(@PathVariable String idGroupMessage) {
    return messageService.listMemberGroupChat(idGroupMessage);
  }

  @CrossOrigin
  @GetMapping("getMemberGroupChat/{idGroupMessage}/{idUser}")
  public List<Optional<User>> listMemberGroupChatSpliceIdUser(@PathVariable String idGroupMessage,@PathVariable String idUser) {
    return messageService.listMemberGroupChatSpliceIdUser(idGroupMessage,idUser);
  }

  @CrossOrigin
  @PutMapping("updateAdminGroup/{idUser}/{idMessage}")
  public int updateAdminGroup(@PathVariable String idUser,@PathVariable String idMessage) {
    return messageService.updateAdminGroup(idUser,idMessage);
  }

}
