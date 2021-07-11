package commessenger_app.clone_messenger.message.model;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import commessenger_app.clone_messenger.user.model.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")

public class Message {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name = "idGroupMessage")
  private GroupMessage groupMessage;

  @OneToOne
  @JoinColumn(name = "idUser")
  private User userMesages;

  @Column
  private String content;

  @Column
  private String nickName;

  @Column
  private int stateMessage;

  @Column
  private int typeMessage;

  @Column
  private Timestamp dateCreated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GroupMessage getGroupMessage() {
    return groupMessage;
  }

  public void setGroupMessage(GroupMessage groupMessage) {
    this.groupMessage = groupMessage;
  }

  public User getUserMesages() {
    return userMesages;
  }

  public void setUserMesages(User userMesages) {
    this.userMesages = userMesages;
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

  public int getStateMessage() {
    return stateMessage;
  }

  public void setStateMessage(int stateMessage) {
    this.stateMessage = stateMessage;
  }

  public int getTypeMessage() {
    return typeMessage;
  }

  public void setTypeMessage(int typeMessage) {
    this.typeMessage = typeMessage;
  }

  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }
}
