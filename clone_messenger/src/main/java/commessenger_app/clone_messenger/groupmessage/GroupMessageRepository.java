package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMessageRepository extends JpaRepository<GroupMessage,String>{
    @Query(value = "SELECT * from groupmessage ORDER BY id DESC LIMIT 1 ",nativeQuery = true)
    GroupMessage getIdBestNew();

    @Modifying
    @Query(value = " UPDATE groupmessage SET color_chat = ?1 WHERE id = ?2 ",nativeQuery = true)
    int updateColorChatGroupMessage(String name,String id);

    @Modifying
    @Query(value = " UPDATE groupmessage SET name_group_message = ?1 WHERE id = ?2 ",nativeQuery = true)
    int updateNameGroupMessage(String name,String id);

}
