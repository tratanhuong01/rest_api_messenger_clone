package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMessageRepository extends JpaRepository<GroupMessage,String>{
    @Query(value = "SELECT * from groupmessage ORDER BY id DESC LIMIT 1 ",nativeQuery = true)
    GroupMessage getIdBestNew();

}
