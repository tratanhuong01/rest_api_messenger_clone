package commessenger_app.clone_messenger.viewmessage;

import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ViewMessageRepository extends JpaRepository<ViewMessage,Long> {

  @Query(value = "SELECT * FROM view_message WHERE id_message = ? ",nativeQuery = true)
  List<ViewMessage> getViewMessageByIdMessage(String idMessage);

  @Modifying
  @Transactional
  @Query(value = "UPDATE view_message SET view = 2 WHERE id_group_message = ?1 AND " +
      "id_user = ?2 AND view != 2 ",nativeQuery = true)
  int updateViewMessageHandle(String idGroupMessage,String idUser);

  @Query(value = "SELECT * FROM view_message WHERE id_group_message = ?1 AND " +
      "id_user = ?2 AND view != 2 ",nativeQuery = true)
  List<ViewMessage> checkViewMessageHandle(String idGroupMessage,String idUser);

}
