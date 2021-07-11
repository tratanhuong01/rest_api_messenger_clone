package commessenger_app.clone_messenger.relationshipuser;

import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RelationshipUserController {
  @Autowired
  private RelationshipUserService relationshipUserService;

  @GetMapping("relationshipuser")
  public List<RelationshipUser> getRelationshipUser() {
    return relationshipUserService.getRelationshipUser();
  }

  @CrossOrigin
  @PostMapping("relationshipuser")
  public RelationshipUser addRelationshipUser(@RequestBody RelationshipUser relationshipUser) {
    return relationshipUserService.addRelationshipUser((relationshipUser));
  }

  @CrossOrigin
  @GetMapping("checkStatusBetweenTwoUser/{idMain}/{idView}")
  public RelationshipUser checkStatusBetweenTwoUser(@PathVariable String idMain, @PathVariable String idView) {
    return relationshipUserService.checkStatusBetweenTwoUser(idMain, idView);
  }

  @CrossOrigin
  @GetMapping("getInviteRequest/{idRecivice}/{status}")
  public List<RelationshipUser> getInviteRequest(@PathVariable String idRecivice, @PathVariable String status) {
    return relationshipUserService.getInviteRequest(idRecivice, status);
  }

  @CrossOrigin
  @GetMapping("updateStatusRelationShip/{idSend}/{idRecivice}")
  public int updateStatusRelationShip(@PathVariable String idSend, @PathVariable String idRecivice) {
    return relationshipUserService.updateStatusRelationShip(3, idSend, idRecivice);
  }

  @CrossOrigin
  @GetMapping("relationshipuser/{idSend}/{idRecivice}")
  public int deleteRelationShip(@PathVariable String idSend, @PathVariable String idRecivice) {
    return relationshipUserService.deleteRelationShip(idSend, idRecivice);
  }

  @CrossOrigin
  @GetMapping("getFriendProposal/{idSend}")
  public List<RelationshipUser> getFriendProposal(@PathVariable String idSend) {
    return relationshipUserService.getFriendProposal(idSend, 1, 2, 3);
  }

  @CrossOrigin
  @GetMapping("relationshipuser/{id}")
  public List<RelationshipUser> getFriendById(@PathVariable String id) {
    return relationshipUserService.getFriendById(id);
  }
}
