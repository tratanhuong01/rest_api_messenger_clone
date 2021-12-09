package commessenger_app.clone_messenger.feel.model;

import commessenger_app.clone_messenger.message.model.Message;
import commessenger_app.clone_messenger.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "feel")
public class Feel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "idUser")
  User feelUser;

  @ManyToOne
  @JoinColumn(name = "idMessage")
  Message feelMessage;

  @Column
  int typeFeel;

  @Column
  String iconFeel;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getFeelUser() {
    return feelUser;
  }

  public void setFeelUser(User feelUser) {
    this.feelUser = feelUser;
  }

  public Message getFeelMessage() {
    return feelMessage;
  }

  public void setFeelMessage(Message feelMessage) {
    this.feelMessage = feelMessage;
  }

  public int getTypeFeel() {
    return typeFeel;
  }

  public void setTypeFeel(int typeFeel) {
    this.typeFeel = typeFeel;
  }

  public String getIconFeel() {
    return iconFeel;
  }

  public void setIconFeel(String iconFeel) {
    this.iconFeel = iconFeel;
  }
}
