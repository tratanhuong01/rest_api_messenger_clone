package commessenger_app.clone_messenger.groupmessage.model;

import commessenger_app.clone_messenger.message.model.Message;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "groupmessage")
public class GroupMessage {

  @Id
  private String id;

  @OneToMany(mappedBy = "groupMessage")
  private Set<Message> messages;

  @Column(length = 100)
  private String nameGroupMessage;

  @Column(length = 7)
  private String colorChat;

  @Column
  private String iconChat;

  @Column
  private int typeGroupMessage;

  @Column
  private Timestamp dateCreated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getIconChat() {
    return iconChat;
  }

  public void setIconChat(String iconChat) {
    this.iconChat = iconChat;
  }

  public int getTypeGroupMessage() {
    return typeGroupMessage;
  }

  public void setTypeGroupMessage(int typeGroupMessage) {
    this.typeGroupMessage = typeGroupMessage;
  }

  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }
}
