package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMessageRepository extends JpaRepository<GroupMessage,String>{
}
