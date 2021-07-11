package commessenger_app.clone_messenger.message;

import commessenger_app.clone_messenger.DTO.MessageGroupUser;
import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
  @Autowired
  MessageRepository messageRepository;

  public List<Message> getAllMessages() {
    return messageRepository.findAll();
  }

  public Optional<Message> getMessageById(String id) {
    return messageRepository.findById(id);
  }

  public Message addMessages(Message message) {
    Message message1 = messageRepository.getIdBestNew();
    message.setId(StringUtil.gereralID("messages", message1 == null ? null : message1.getId()));
    message.setDateCreated(new Timestamp(new Date().getTime()));
    return messageRepository.save(message);
  }

  public Message addMessagesGroup(List<Message> messageList) {
    for (Message message : messageList) {
      message.setDateCreated(new Timestamp(new Date().getTime()));
      messageRepository.save(message);
    }
    return null;
  }

  public List<MessageGroupUser> getMessagesByGroupMessage(String id) {
    return messageRepository.getMessagesByGroupMessage(id);
  }

  public List<String> getDistinctGroupMessageById(String id) {
    return messageRepository.getDistinctGroupMessageById(id);
  }

  public List<List<MessageGroupUser>> createAllMessagesUser(String id) {
    List<List<MessageGroupUser>> newListMessageGroupUsers = new ArrayList<>();
    List<String> listIdGroupMessage = messageRepository.getDistinctGroupMessageById(id);
    for (String item : listIdGroupMessage) {
      newListMessageGroupUsers.add(messageRepository.getMessagesByGroupMessage(item));
    }
    return newListMessageGroupUsers;
  }

  public List<List<MessageGroupUser>> getListGroupMessage(String id) {
    List<List<MessageGroupUser>> messageGroupUserList = new ArrayList<>();
    List<String> listIdGroupMessage = messageRepository.getDistinctGroupMessageMain(id);
    for (String item : listIdGroupMessage) {
      messageGroupUserList.add(messageRepository.getListGroupMessages(item));
    }
    return messageGroupUserList;
  }

  public Message getIDBestNew() {
    return messageRepository.getIdBestNew();
  }

  public int updateNickNameByUser(String nickName, String idGroupMessage, String idUser) {
    return messageRepository.updateNickNameByUser(nickName, idGroupMessage, idUser);
  }

  public Message getGroupMessageByUserIdAndIdGroupMessage(String idMain,String idView) {
    List<String> stringList = messageRepository.getDistinctGroupMessageById(idMain);
    Message message = null;
    for (String item: stringList) {
      message = messageRepository.getGroupMessageByUserIdAndIdGroupMessage(item,idView);
      if (message != null && message.getGroupMessage().getTypeGroupMessage() == 0)
        return message;
    }
    return message;
  }

  public int deleteMemberOutGroup(String idGroupMessage,String idUser) {
    return messageRepository.deleteMemberOutGroup(idGroupMessage, idUser);
  }

}
