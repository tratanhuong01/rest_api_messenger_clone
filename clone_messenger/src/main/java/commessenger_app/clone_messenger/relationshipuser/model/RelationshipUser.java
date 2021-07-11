package commessenger_app.clone_messenger.relationshipuser.model;

import commessenger_app.clone_messenger.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "relationshipuser")
public class RelationshipUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "idSend")
  private User userRelationshipUser;

  @Column
  private String idRecivice;

  @Column
  private int status;

  @Column
  private int block;


  public void setId(long id) {
    this.id = id;
  }

  public User getUserRelationshipUser() {
    return userRelationshipUser;
  }

  public void setUserRelationshipUser(User userRelationshipUser) {
    this.userRelationshipUser = userRelationshipUser;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIdRecivice() {
    return idRecivice;
  }

  public void setIdRecivice(String idRecivice) {
    this.idRecivice = idRecivice;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getBlock() {
    return block;
  }

  public void setBlock(int block) {
    this.block = block;
  }
}
