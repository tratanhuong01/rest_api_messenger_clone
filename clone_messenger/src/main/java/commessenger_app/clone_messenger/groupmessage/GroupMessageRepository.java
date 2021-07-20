package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GroupMessageRepository extends JpaRepository<GroupMessage, String> {
  @Query(value = "SELECT * from group_message ORDER BY id DESC LIMIT 1 ", nativeQuery = true)
  GroupMessage getIdBestNew();

  @Modifying
  @Transactional
  @Query(value = " UPDATE group_message SET color_chat = ?1 WHERE id = ?2 ", nativeQuery = true)
  int updateColorChatGroupMessage(String name, String id);

  @Modifying
  @Transactional
  @Query(value = " UPDATE group_message SET name_group_message = ?1 WHERE id = ?2 ", nativeQuery = true)
  int updateNameGroupMessage(String name, String id);

  @Modifying
  @Transactional
  @Query(value = "UPDATE group_message SET icon_chat = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateIconChatMessage(String iconChat,String id);

  @Modifying
  @Transactional
  @Query(value = "UPDATE group_message SET type_group_message = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateTypeGroupMessage(int typeGroupMessage,String idGroupMessage);

  @Modifying
  @Transactional
  @Query(value = "UPDATE group_message SET image_group = ?1 WHERE id = ?2 ",nativeQuery = true)
  int updateImageGroupMessage(String imageGroup,String idGroupMessage);

}
