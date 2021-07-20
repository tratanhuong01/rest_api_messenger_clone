package commessenger_app.clone_messenger.viewmessage;

import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewMessageRepository extends JpaRepository<ViewMessage,Long> {

  @Query(value = "SELECT * FROM view_message WHERE id_message = ? ",nativeQuery = true)
  List<ViewMessage> getViewMessageByIdMessage(String idMessage);

}
