package commessenger_app.clone_messenger.DTO;


import commessenger_app.clone_messenger.feel.model.Feel;
import commessenger_app.clone_messenger.statemessage.model.StateMessage;
import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;

import java.util.List;

public class MessageDetail {

  private String idUser;

  private String firstName;

  private String lastName;

  private String idGroupMessage;

  private String idMessage;

  private String dateCreated;

  private String iconChat;

  private String nameGroupMessage;

  private String colorChat;

  private String avatar;

  private String stateMessage;

  private String content;

  private String nickName;

  private String typeMessage;

  private String typeGroupMessage;

  private List<Feel> feelList;

  private String imageGroup;

  private List<StateMessage> stateMessageList;

  private List<ViewMessage> viewMessageList;

  public MessageDetail(String idUser, String firstName, String lastName, String idGroupMessage, String idMessage,
  String dateCreated, String iconChat, String nameGroupMessage, String colorChat, String avatar, String stateMessage,
  String content, String nickName, String typeMessage, String typeGroupMessage, List<Feel> feelList, String imageGroup,
  List<StateMessage> stateMessageList, List<ViewMessage> viewMessageList) {
    this.idUser = idUser;
    this.firstName = firstName;
    this.lastName = lastName;
    this.idGroupMessage = idGroupMessage;
    this.idMessage = idMessage;
    this.dateCreated = dateCreated;
    this.iconChat = iconChat;
    this.nameGroupMessage = nameGroupMessage;
    this.colorChat = colorChat;
    this.avatar = avatar;
    this.stateMessage = stateMessage;
    this.content = content;
    this.nickName = nickName;
    this.typeMessage = typeMessage;
    this.typeGroupMessage = typeGroupMessage;
    this.feelList = feelList;
    this.imageGroup = imageGroup;
    this.stateMessageList = stateMessageList;
    this.viewMessageList = viewMessageList;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getIdGroupMessage() {
    return idGroupMessage;
  }

  public void setIdGroupMessage(String idGroupMessage) {
    this.idGroupMessage = idGroupMessage;
  }

  public String getIdMessage() {
    return idMessage;
  }

  public void setIdMessage(String idMessage) {
    this.idMessage = idMessage;
  }

  public String getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(String dateCreated) {
    this.dateCreated = dateCreated;
  }

  public String getIconChat() {
    return iconChat;
  }

  public void setIconChat(String iconChat) {
    this.iconChat = iconChat;
  }

  public String getNameGroupMessage() {
    return nameGroupMessage;
  }

  public void setNameGroupMessage(String nameGroupMessage) {
    this.nameGroupMessage = nameGroupMessage;
  }

  public String getColorChat() {
    return colorChat;
  }

  public void setColorChat(String colorChat) {
    this.colorChat = colorChat;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getStateMessage() {
    return stateMessage;
  }

  public void setStateMessage(String stateMessage) {
    this.stateMessage = stateMessage;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getTypeMessage() {
    return typeMessage;
  }

  public void setTypeMessage(String typeMessage) {
    this.typeMessage = typeMessage;
  }

  public String getTypeGroupMessage() {
    return typeGroupMessage;
  }

  public void setTypeGroupMessage(String typeGroupMessage) {
    this.typeGroupMessage = typeGroupMessage;
  }

  public List<Feel> getFeelList() {
    return feelList;
  }

  public void setFeelList(List<Feel> feelList) {
    this.feelList = feelList;
  }

  public String getImageGroup() {
    return imageGroup;
  }

  public void setImageGroup(String imageGroup) {
    this.imageGroup = imageGroup;
  }

  public List<StateMessage> getStateMessageList() {
    return stateMessageList;
  }

  public void setStateMessageList(List<StateMessage> stateMessageList) {
    this.stateMessageList = stateMessageList;
  }

  public List<ViewMessage> getViewMessageList() {
    return viewMessageList;
  }

  public void setViewMessageList(List<ViewMessage> viewMessageList) {
    this.viewMessageList = viewMessageList;
  }
}
