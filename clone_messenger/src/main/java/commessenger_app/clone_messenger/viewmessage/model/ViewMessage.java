package commessenger_app.clone_messenger.viewmessage.model;

import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "viewMessage")
public class ViewMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "idMessage")
  private Message viewMessage;

  @ManyToOne
  @JoinColumn(name = "idUser")
  private User userViewMessage;

  @Column
  private int view;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Message getViewMessage() {
    return viewMessage;
  }

  public void setViewMessage(Message viewMessage) {
    this.viewMessage = viewMessage;
  }

  public User getUserViewMessage() {
    return userViewMessage;
  }

  public void setUserViewMessage(User userViewMessage) {
    this.userViewMessage = userViewMessage;
  }

  public int getView() {
    return view;
  }

  public void setView(int view) {
    this.view = view;
  }
}
