package commessenger_app.clone_messenger.statemessage.model;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "stateMessage")
public class StateMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_message")
  private Message stateMessage;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User userStateMessage;

  @ManyToOne
  @JoinColumn(name = "idGroupMessage")
  private GroupMessage groupMessageStateMessage;

  @Column
  private int state;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Message getStateMessage() {
    return stateMessage;
  }

  public void setStateMessage(Message stateMessage) {
    this.stateMessage = stateMessage;
  }

  public User getUserStateMessage() {
    return userStateMessage;
  }

  public void setUserStateMessage(User userStateMessage) {
    this.userStateMessage = userStateMessage;
  }

  public GroupMessage getGroupMessageStateMessage() {
    return groupMessageStateMessage;
  }

  public void setGroupMessageStateMessage(GroupMessage groupMessageStateMessage) {
    this.groupMessageStateMessage = groupMessageStateMessage;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }
}
