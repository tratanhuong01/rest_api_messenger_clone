package commessenger_app.clone_messenger.relationshipuser;

import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RelationshipUserRepository extends JpaRepository<RelationshipUser,Long> {
    @Query(value = "SELECT * FROM relationshipuser WHERE id_send = ?1 AND id_recivice = ?2 ",nativeQuery = true)
    RelationshipUser checkStatusBetweenTwoUser(String idUserMain,String idUserView);

    @Query(value = "SELECT * FROM relationshipuser WHERE id_recivice = ?1 AND status = ?2 ",nativeQuery = true)
    List<RelationshipUser> getInviteRequest(String idRevice, String status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE relationshipuser SET status = ?1 WHERE id_send = ?2 AND id_recivice = ?3 ",nativeQuery = true)
    int updateStatusRelationShip(int status,String id_send,String id_recivice);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM relationshipuser WHERE id_send = ?1 AND id_recivice = ?2 ",nativeQuery = true)
    int deleteRelationShip(String id_send,String id_recivice);

    @Query(value = "SELECT * FROM relationshipuser WHERE id_recivice = ?1 AND ( status = ?2 OR status = ?3  OR " +
            " status = ?4 ) ",nativeQuery = true)
    List<RelationshipUser> getFriendProposal(String idRecivice,int statusOne,int statusTwo,int statusThree);

    @Query(value = "SELECT * FROM relationshipuser WHERE id_recivice = ?1 AND status = 3 ",nativeQuery = true)
    List<RelationshipUser> getFriendById(String idRevice);
}
