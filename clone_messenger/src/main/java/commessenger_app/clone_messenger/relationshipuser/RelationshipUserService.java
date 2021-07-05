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

    public RelationshipUser checkStatusBetweenTwoUser(String idUserMain,String idUserView) {
        RelationshipUser relationshipUser = relationshipUserRepository.checkStatusBetweenTwoUser(idUserMain,idUserView);
        return relationshipUser == null ? null : relationshipUser;
    }

    public List<RelationshipUser> getInviteRequest(String idRecivice, String status) {
        return relationshipUserRepository.getInviteRequest(idRecivice,status);
    }
}
