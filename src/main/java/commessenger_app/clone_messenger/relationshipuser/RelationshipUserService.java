package commessenger_app.clone_messenger.relationshipuser;

import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipUserService {

  @Autowired
  RelationshipUserRepository relationshipUserRepository;

  public List<RelationshipUser> getAllRelationShip() {
    return relationshipUserRepository.findAll();
  }

  public RelationshipUser addRelationshipUser(RelationshipUser relationshipUser) {
    return relationshipUserRepository.save(relationshipUser);
  }

  public List<RelationshipUser> getRelationshipUser() {
    return relationshipUserRepository.findAll();
  }

  public RelationshipUser checkStatusBetweenTwoUser(String idUserMain, String idUserView) {
    RelationshipUser relationshipUser = relationshipUserRepository.checkStatusBetweenTwoUser(idUserMain, idUserView);
    return relationshipUser == null ? null : relationshipUser;
  }

  public List<RelationshipUser> getInviteRequest(String idReceive, String status) {
    return relationshipUserRepository.getInviteRequest(idReceive, status);
  }

  public int updateStatusRelationShip(int status, String id_send, String id_receive) {
    return relationshipUserRepository.updateStatusRelationShip(status, id_send, id_receive);
  }

  public int deleteRelationShip(String id_send, String id_receive) {
    return relationshipUserRepository.deleteRelationShip(id_send, id_receive);
  }

  public List<RelationshipUser> getFriendProposal(String idSend, int statusOne, int statusTwo, int statusThree) {
    return relationshipUserRepository.getFriendProposal(idSend, statusOne, statusTwo, statusThree);
  }

  public List<RelationshipUser> getFriendById(String id) {
    return relationshipUserRepository.getFriendById(id);
  }
}
