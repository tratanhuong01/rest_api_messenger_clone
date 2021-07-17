package commessenger_app.clone_messenger.message;

import commessenger_app.clone_messenger.DTO.MessageDetail;
import commessenger_app.clone_messenger.DTO.MessageGroupUser;
import commessenger_app.clone_messenger.feel.FeelRepository;
import commessenger_app.clone_messenger.feel.model.Feel;
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

  @Autowired
  FeelRepository feelRepository;

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

  public List<MessageDetail> getMessagesByGroupMessage(String id) {
    List<MessageDetail> messageDetailList = new ArrayList<>();
    List<MessageGroupUser> getList =  messageRepository.getMessagesByGroupMessage(id);
    for (MessageGroupUser messageGroupUser: getList) {
      List<Feel> feelList = feelRepository.getAllFeels(messageGroupUser.getIdMessage());
      MessageDetail messageDetail = new MessageDetail(messageGroupUser.getIdUser(),messageGroupUser.getFirstName(),
          messageGroupUser.getLastName(),messageGroupUser.getIdGroupMessage(),messageGroupUser.getIdMessage(),
          messageGroupUser.getDateCreated(),messageGroupUser.getIconChat(),messageGroupUser.getNameGroupMessage(),
          messageGroupUser.getColorChat(),messageGroupUser.getAvatar(),messageGroupUser.getStateMessage(),
          messageGroupUser.getContent(),messageGroupUser.getNickName(),messageGroupUser.getTypeMessage(),
          messageGroupUser.getTypeGroupMessage(),feelList);
      messageDetailList.add(messageDetail);
    }
    return  messageDetailList;
  }

  public List<String> getDistinctGroupMessageById(String id) {
    return messageRepository.getDistinctGroupMessageById(id);
  }

  public List<List<MessageDetail>> createAllMessagesUser(String id) {
    List<List<MessageDetail>> newListMessageGroupUsers = new ArrayList<>();
    List<String> listIdGroupMessage = messageRepository.getDistinctGroupMessageById(id);
    for (String item : listIdGroupMessage) {
      List<MessageGroupUser> messageGroupUserList = messageRepository.getMessagesByGroupMessage(item);
      List<MessageDetail> messageDetailLists = new ArrayList<>();
      for (MessageGroupUser messageGroupUser: messageGroupUserList) {
        List<Feel> feelList = feelRepository.getAllFeels(messageGroupUser.getIdMessage());
        MessageDetail messageDetail = new MessageDetail(messageGroupUser.getIdUser(),messageGroupUser.getFirstName(),
            messageGroupUser.getLastName(),messageGroupUser.getIdGroupMessage(),messageGroupUser.getIdMessage(),
            messageGroupUser.getDateCreated(),messageGroupUser.getIconChat(),messageGroupUser.getNameGroupMessage(),
            messageGroupUser.getColorChat(),messageGroupUser.getAvatar(),messageGroupUser.getStateMessage(),
            messageGroupUser.getContent(),messageGroupUser.getNickName(),messageGroupUser.getTypeMessage(),
            messageGroupUser.getTypeGroupMessage(),feelList);
        messageDetailLists.add(messageDetail);
      }
      newListMessageGroupUsers.add(messageDetailLists);
    }
    return newListMessageGroupUsers;
  }

  public List<List<MessageDetail>> getListGroupMessage(String id) {
    List<List<MessageDetail>> messageGroupUserList = new ArrayList<>();
    List<String> listIdGroupMessage = messageRepository.getDistinctGroupMessageMain(id);
    for (String item : listIdGroupMessage) {
      List<MessageGroupUser> messageGroupUserLists = messageRepository.getListGroupMessages(item);
      List<MessageDetail> messageDetailLists = new ArrayList<>();
      for (MessageGroupUser messageGroupUser: messageGroupUserLists) {
        List<Feel> feelList = feelRepository.getAllFeels(messageGroupUser.getIdMessage());
        MessageDetail messageDetail = new MessageDetail(messageGroupUser.getIdUser(),messageGroupUser.getFirstName(),
            messageGroupUser.getLastName(),messageGroupUser.getIdGroupMessage(),messageGroupUser.getIdMessage(),
            messageGroupUser.getDateCreated(),messageGroupUser.getIconChat(),messageGroupUser.getNameGroupMessage(),
            messageGroupUser.getColorChat(),messageGroupUser.getAvatar(),messageGroupUser.getStateMessage(),
            messageGroupUser.getContent(),messageGroupUser.getNickName(),messageGroupUser.getTypeMessage(),
            messageGroupUser.getTypeGroupMessage(),feelList);
        messageDetailLists.add(messageDetail);
      }
      messageGroupUserList.add(messageDetailLists);
    }
    return messageGroupUserList;
  }

  public Message getIDBestNew() {
    Message message = messageRepository.getIdBestNew();
    if (message == null) {
      Message messageFirst = new Message();
      messageFirst.setId("300000000");
      return messageFirst;
    }
    return message;
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
