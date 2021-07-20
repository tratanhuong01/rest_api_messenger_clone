package commessenger_app.clone_messenger.statemessage;

import commessenger_app.clone_messenger.statemessage.model.StateMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateMessageRepository extends JpaRepository<StateMessage,Long> {

  @Query(value = "SELECT * FROM state_message WHERE id_message = ? ",nativeQuery = true)
  List<StateMessage> getStateMessageByIdMessage(String idMessage);

}
