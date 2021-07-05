package commessenger_app.clone_messenger.relationshipuser;

import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelationshipUserRepository extends JpaRepository<RelationshipUser,Long> {
    @Query(value = "SELECT * FROM relationshipuser WHERE id_send = ?1 AND id_recivice = ?2 ",nativeQuery = true)
    RelationshipUser checkStatusBetweenTwoUser(String idUserMain,String idUserView);

    @Query(value = "SELECT * FROM relationshipuser WHERE id_recivice = ?1 AND status = ?2 ",nativeQuery = true)
    List<RelationshipUser> getInviteRequest(String idRevice, String status);
}
