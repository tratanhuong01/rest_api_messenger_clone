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
    public RelationshipUser checkStatusBetweenTwoUser(@PathVariable String idMain,@PathVariable String idView) {
        return relationshipUserService.checkStatusBetweenTwoUser(idMain,idView);
    }

    @CrossOrigin
    @GetMapping("getInviteRequest/{idRecivice}/{status}")
    public List<RelationshipUser> getInviteRequest(@PathVariable String idRecivice, @PathVariable String status) {
        return relationshipUserService.getInviteRequest(idRecivice,status);
    }
}
