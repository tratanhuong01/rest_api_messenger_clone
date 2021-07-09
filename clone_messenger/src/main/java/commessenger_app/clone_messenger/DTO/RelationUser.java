package commessenger_app.clone_messenger.DTO;

import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import commessenger_app.clone_messenger.user.model.User;

import java.util.List;

public class RelationUser {
    private List<User> userList;
    private List<RelationshipUser> relationshipUserList;
    private String idMain;

    public String getIdMain() {
        return idMain;
    }

    public void setIdMain(String idMain) {
        this.idMain = idMain;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<RelationshipUser> getRelationshipUserList() {
        return relationshipUserList;
    }

    public void setRelationshipUserList(List<RelationshipUser> relationshipUserList) {
        this.relationshipUserList = relationshipUserList;
    }
}
