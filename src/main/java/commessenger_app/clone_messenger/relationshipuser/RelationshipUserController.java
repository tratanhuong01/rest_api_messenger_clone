package commessenger_app.clone_messenger.relationshipuser;

import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RelationshipUserController {
  @Autowired
  private RelationshipUserService relationshipUserService;

  @GetMapping("relationshipUser")
  public List<RelationshipUser> getRelationshipUser() {
    return relationshipUserService.getRelationshipUser();
  }

  @CrossOrigin
  @PostMapping("relationshipUser")
  public RelationshipUser addRelationshipUser(@RequestBody RelationshipUser relationshipUser) {
    return relationshipUserService.addRelationshipUser((relationshipUser));
  }

  @CrossOrigin
  @GetMapping("checkStatusBetweenTwoUser/{idMain}/{idView}")
  public RelationshipUser checkStatusBetweenTwoUser(@PathVariable String idMain, @PathVariable String idView) {
    return relationshipUserService.checkStatusBetweenTwoUser(idMain, idView);
  }

  @CrossOrigin
  @GetMapping("getInviteRequest/{idReceive}/{status}")
  public List<RelationshipUser> getInviteRequest(@PathVariable String idReceive, @PathVariable String status) {
    return relationshipUserService.getInviteRequest(idReceive, status);
  }

  @CrossOrigin
  @GetMapping("updateStatusRelationShip/{idSend}/{idReceive}")
  public int updateStatusRelationShip(@PathVariable String idSend, @PathVariable String idReceive) {
    return relationshipUserService.updateStatusRelationShip(3, idSend, idReceive);
  }

  @CrossOrigin
  @GetMapping("relationshipUser/{idSend}/{idReceive}")
  public int deleteRelationShip(@PathVariable String idSend, @PathVariable String idReceive) {
    return relationshipUserService.deleteRelationShip(idSend, idReceive);
  }

  @CrossOrigin
  @GetMapping("getFriendProposal/{idSend}")
  public List<RelationshipUser> getFriendProposal(@PathVariable String idSend) {
    return relationshipUserService.getFriendProposal(idSend, 1, 2, 3);
  }

  @CrossOrigin
  @GetMapping("relationshipUser/{id}")
  public List<RelationshipUser> getFriendById(@PathVariable String id) {
    return relationshipUserService.getFriendById(id);
  }
}
