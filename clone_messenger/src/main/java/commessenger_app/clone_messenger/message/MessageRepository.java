package commessenger_app.clone_messenger.message;

import commessenger_app.clone_messenger.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,String>{
}
