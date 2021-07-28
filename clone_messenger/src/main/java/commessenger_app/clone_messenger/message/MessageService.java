package commessenger_app.clone_messenger.message;

import commessenger_app.clone_messenger.DTO.MessageDetail;
import commessenger_app.clone_messenger.DTO.MessageGroupUser;
import commessenger_app.clone_messenger.feel.FeelRepository;
import commessenger_app.clone_messenger.feel.model.Feel;
import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.message.model.MessageGroup;
import commessenger_app.clone_messenger.statemessage.StateMessageRepository;
import commessenger_app.clone_messenger.statemessage.model.StateMessage;
import commessenger_app.clone_messenger.user.UserRepository;
import commessenger_app.clone_messenger.user.model.User;
import commessenger_app.clone_messenger.utils.StringUtil;
import commessenger_app.clone_messenger.viewmessage.ViewMessageRepository;
import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MessageService {
  @Autowired
  MessageRepository messageRepository;

  @Autowired
  FeelRepository feelRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  StateMessageRepository stateMessageRepository;

  @Autowired
  ViewMessageRepository viewMessageRepository;

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
      List<StateMessage> stateMessageList = stateMessageRepository.getStateMessageByIdMessage(messageGroupUser.getIdMessage());
      List<ViewMessage> viewMessageList = viewMessageRepository.getViewMessageByIdMessage(messageGroupUser.getIdMessage());
      List<Feel> feelList = feelRepository.getAllFeels(messageGroupUser.getIdMessage());
      MessageDetail messageDetail = new MessageDetail(messageGroupUser.getIdUser(),messageGroupUser.getFirstName(),
          messageGroupUser.getLastName(),messageGroupUser.getIdGroupMessage(),messageGroupUser.getIdMessage(),
          messageGroupUser.getDateCreated(),messageGroupUser.getIconChat(),messageGroupUser.getNameGroupMessage(),
          messageGroupUser.getColorChat(),messageGroupUser.getAvatar(),messageGroupUser.getStateMessage(),
          messageGroupUser.getContent(),messageGroupUser.getNickName(),messageGroupUser.getTypeMessage(),
          messageGroupUser.getTypeGroupMessage(),feelList,messageGroupUser.getImageGroup(),
          stateMessageList,viewMessageList);
      messageDetailList.add(messageDetail);
    }
    return  messageDetailList;
  }

  public List<String> getDistinctGroupMessageById(String id) throws ParseException {
    List<String> stringListNew = new ArrayList<>();
    List<String> stringListGet = messageRepository.getDistinctGroupMessageById(id);
    List<MessageGroup> listDateNew = new ArrayList<>();

    for (String idGroupMessage : stringListGet) {
      String dateNew = messageRepository.getDateCreatedByGroupMessageLimit(idGroupMessage);
      MessageGroup messageGroup = new MessageGroup();
      messageGroup.setIdGroupMessage((idGroupMessage));
      messageGroup.setDateCreated(dateNew);
      listDateNew.add(messageGroup);
    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Collections.sort(listDateNew, new Comparator<MessageGroup>() {

      public int compare(MessageGroup o1, MessageGroup o2) {
        int result = -1;
        try {
          result =  simpleDateFormat.parse(o2.getDateCreated()).compareTo(simpleDateFormat.parse(o1.getDateCreated()));
        } catch (ParseException e) {
          e.printStackTrace();
        }
        return result;
      }
    });
    for (MessageGroup messageGroup : listDateNew)
      stringListNew.add(messageGroup.getIdGroupMessage());
    return stringListNew;
  }

  public List<List<MessageDetail>> createAllMessagesUser(String id) throws ParseException {
    List<List<MessageDetail>> newListMessageGroupUsers = new ArrayList<>();
    List<String> listIdGroupMessage = this.getDistinctGroupMessageById(id);
    for (String item : listIdGroupMessage) {
      List<MessageGroupUser> messageGroupUserList = messageRepository.getMessagesByGroupMessage(item);
      List<MessageDetail> messageDetailLists = new ArrayList<>();
      for (MessageGroupUser messageGroupUser: messageGroupUserList) {
        List<StateMessage> stateMessageList = stateMessageRepository.getStateMessageByIdMessage(messageGroupUser.getIdMessage());
        List<ViewMessage> viewMessageList = viewMessageRepository.getViewMessageByIdMessage(messageGroupUser.getIdMessage());
        List<Feel> feelList = feelRepository.getAllFeels(messageGroupUser.getIdMessage());
        MessageDetail messageDetail = new MessageDetail(messageGroupUser.getIdUser(),messageGroupUser.getFirstName(),
            messageGroupUser.getLastName(),messageGroupUser.getIdGroupMessage(),messageGroupUser.getIdMessage(),
            messageGroupUser.getDateCreated(),messageGroupUser.getIconChat(),messageGroupUser.getNameGroupMessage(),
            messageGroupUser.getColorChat(),messageGroupUser.getAvatar(),messageGroupUser.getStateMessage(),
            messageGroupUser.getContent(),messageGroupUser.getNickName(),messageGroupUser.getTypeMessage(),
            messageGroupUser.getTypeGroupMessage(),feelList,messageGroupUser.getImageGroup(),
            stateMessageList,viewMessageList);
        messageDetailLists.add(messageDetail);
      }
      newListMessageGroupUsers.add(messageDetailLists);
    }
    return newListMessageGroupUsers;
  }

  public List<List<MessageDetail>> createAllMessagesUserWait(String id) throws ParseException {
    List<List<MessageDetail>> newListMessageGroupUsers = new ArrayList<>();
    List<String> listIdGroupMessage = this.getDistinctGroupMessageByIdWait(id);
    for (String item : listIdGroupMessage) {
      List<MessageGroupUser> messageGroupUserList = messageRepository.getMessagesByGroupMessage(item);
      List<MessageDetail> messageDetailLists = new ArrayList<>();
      for (MessageGroupUser messageGroupUser: messageGroupUserList) {
        List<StateMessage> stateMessageList = stateMessageRepository.getStateMessageByIdMessage(messageGroupUser.getIdMessage());
        List<ViewMessage> viewMessageList = viewMessageRepository.getViewMessageByIdMessage(messageGroupUser.getIdMessage());
        List<Feel> feelList = feelRepository.getAllFeels(messageGroupUser.getIdMessage());
        MessageDetail messageDetail = new MessageDetail(messageGroupUser.getIdUser(),messageGroupUser.getFirstName(),
            messageGroupUser.getLastName(),messageGroupUser.getIdGroupMessage(),messageGroupUser.getIdMessage(),
            messageGroupUser.getDateCreated(),messageGroupUser.getIconChat(),messageGroupUser.getNameGroupMessage(),
            messageGroupUser.getColorChat(),messageGroupUser.getAvatar(),messageGroupUser.getStateMessage(),
            messageGroupUser.getContent(),messageGroupUser.getNickName(),messageGroupUser.getTypeMessage(),
            messageGroupUser.getTypeGroupMessage(),feelList,messageGroupUser.getImageGroup(),
            stateMessageList,viewMessageList);
        messageDetailLists.add(messageDetail);
      }
      newListMessageGroupUsers.add(messageDetailLists);
    }
    return newListMessageGroupUsers;
  }

  public List<String> getDistinctGroupMessageByIdWait(String id) throws ParseException {
    List<String> stringListNew = new ArrayList<>();
    List<String> stringListGet = messageRepository.getDistinctGroupMessageByIdWait(id);
    List<MessageGroup> listDateNew = new ArrayList<>();

    for (String idGroupMessage : stringListGet) {
      String dateNew = messageRepository.getDateCreatedByGroupMessageLimit(idGroupMessage);
      MessageGroup messageGroup = new MessageGroup();
      messageGroup.setIdGroupMessage((idGroupMessage));
      messageGroup.setDateCreated(dateNew);
      listDateNew.add(messageGroup);
    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Collections.sort(listDateNew, new Comparator<MessageGroup>() {

      public int compare(MessageGroup o1, MessageGroup o2) {
        int result = -1;
        try {
          result =  simpleDateFormat.parse(o2.getDateCreated()).compareTo(simpleDateFormat.parse(o1.getDateCreated()));
        } catch (ParseException e) {
          e.printStackTrace();
        }
        return result;
      }
    });
    for (MessageGroup messageGroup : listDateNew)
      stringListNew.add(messageGroup.getIdGroupMessage());
    return stringListNew;
  }

  public List<List<MessageDetail>> getListGroupMessage(String id) {
    List<List<MessageDetail>> messageGroupUserList = new ArrayList<>();
    List<String> listIdGroupMessage = messageRepository.getDistinctGroupMessageMain(id);
    for (String item : listIdGroupMessage) {
      List<MessageGroupUser> messageGroupUserLists = messageRepository.getListGroupMessages(item);
      List<MessageDetail> messageDetailLists = new ArrayList<>();
      for (MessageGroupUser messageGroupUser: messageGroupUserLists) {
        List<StateMessage> stateMessageList = stateMessageRepository.getStateMessageByIdMessage(messageGroupUser.getIdMessage());
        List<ViewMessage> viewMessageList = viewMessageRepository.getViewMessageByIdMessage(messageGroupUser.getIdMessage());
        List<Feel> feelList = feelRepository.getAllFeels(messageGroupUser.getIdMessage());
        MessageDetail messageDetail = new MessageDetail(messageGroupUser.getIdUser(),messageGroupUser.getFirstName(),
            messageGroupUser.getLastName(),messageGroupUser.getIdGroupMessage(),messageGroupUser.getIdMessage(),
            messageGroupUser.getDateCreated(),messageGroupUser.getIconChat(),messageGroupUser.getNameGroupMessage(),
            messageGroupUser.getColorChat(),messageGroupUser.getAvatar(),messageGroupUser.getStateMessage(),
            messageGroupUser.getContent(),messageGroupUser.getNickName(),messageGroupUser.getTypeMessage(),
            messageGroupUser.getTypeGroupMessage(),feelList,messageGroupUser.getImageGroup(),
            stateMessageList,viewMessageList);
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

  public List<Optional<User>> listMemberGroupChat(String idGroupMessage) {
    List<Optional<User>> userList = new ArrayList<>();
    List<String> stringList = messageRepository.listMemberGroupChat(idGroupMessage);
    for (String string: stringList ) {
      userList.add(userRepository.findById(string));
    }
    return userList;
  }

  public List<Optional<User>> listMemberGroupChatSpliceIdUser(String idGroupMessage,String idUser) {
    List<Optional<User>> userList = new ArrayList<>();
    List<String> stringList = messageRepository.listMemberGroupChatSpliceIdUser(idGroupMessage,idUser);
    for (String string: stringList ) {
      userList.add(userRepository.findById(string));
    }
    return userList;
  }

  public int updateAdminGroup(String idUser,String idMessage) {
    return messageRepository.updateAdminGroup(idUser, idMessage);
  }

}
