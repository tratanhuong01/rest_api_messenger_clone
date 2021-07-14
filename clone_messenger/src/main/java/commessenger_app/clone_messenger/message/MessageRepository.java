package commessenger_app.clone_messenger.message;

import commessenger_app.clone_messenger.DTO.MessageGroupUser;
import commessenger_app.clone_messenger.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
  @Query(value = "SELECT * from messages ORDER BY id DESC LIMIT 1 ", nativeQuery = true)
  Message getIdBestNew();

  @Query(value = " select u.id as idUser , u.first_name as firstName , u.last_name as lastName , gm.id as idGroupMessage ," +
      " m.id as id_message , m.date_created as dateCreated ,gm.icon_chat as iconChat ,gm.name_group_message as nameGroupMessage " +
      ",gm.color_chat as colorChat, u.avatar as avatar ,m.state_message as stateMessage , m.content as content ,m.nick_name " +
      " as nickName , m.type_message as typeMessage , gm.type_group_message as typeGroupMessage from messages as m inner join " +
      " groupmessage gm on m.id_group_message = gm.id " +
      " inner join users as u on u.id = m.id_user WHERE m.id_group_message = ?1  ORDER BY m.date_created ASC", nativeQuery = true)
  List<MessageGroupUser> getMessagesByGroupMessage(String id);

  @Query(value = "SELECT * FROM messages WHERE id_user = ?1 ORDER BY date_created DESC ", nativeQuery = true)
  List<Message> getAll(String id);

  @Query(value = "SELECT DISTINCT id_group_message FROM messages WHERE id_user = ?1 " +
      "GROUP BY id_group_message ORDER BY MAX(date_created) DESC, id_group_message", nativeQuery = true)
  List<String> getDistinctGroupMessageById(String id);

  @Query(value = "SELECT DISTINCT id_group_message FROM messages INNER JOIN groupmessage ON " +
      "messages.id_group_message = groupmessage.id WHERE id_user = ?1 AND groupmessage.type_group_message = 1 " +
      " ORDER BY messages.date_created DESC ", nativeQuery = true)
  List<String> getDistinctGroupMessageMain(String id);

  @Query(value = " select u.id as idUser , u.first_name as firstName , u.last_name as lastName , gm.id as idGroupMessage ," +
      " m.id as id_message , m.date_created as dateCreated ,gm.icon_chat as iconChat ,gm.name_group_message as nameGroupMessage " +
      ",gm.color_chat as colorChat, u.avatar as avatar ,m.state_message as stateMessage , m.content as content ,m.nick_name " +
      " as nickName , m.type_message as typeMessage , gm.type_group_message as typeGroupMessage from messages as m inner join " +
      " groupmessage gm on m.id_group_message = gm.id inner join users as u on u.id = m.id_user WHERE " +
      " m.id_group_message = ?1 GROUP BY id_user ORDER BY m.date_created DESC ", nativeQuery = true)
  List<MessageGroupUser> getListGroupMessages(String id);

  @Modifying
  @Transactional
  @Query(value = "UPDATE messages SET nick_name = ?1 WHERE id_group_message = ?2 AND id_user = ?3 AND type_message = -1 ", nativeQuery = true)
  int updateNickNameByUser(String nickName, String idGroupMessage, String idUser);

  @Query(value = "SELECT * FROM messages WHERE id_group_message = ?1 AND id_user = ?2 AND type_message = -1 ",nativeQuery = true)
  Message getGroupMessageByUserIdAndIdGroupMessage(String idGroupMessage,String idUser);

  @Query(value = "SELECT DISTINCT id_group_message FROM messages WHERE id_group_message = ?1 AND type_message = -1 ",nativeQuery = true)
  Message getDistinctGroupMessageId(String idGroupMessage);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM messages WHERE id_group_message = ?1 AND id_user = ?2 AND type_message = -1 ",nativeQuery = true)
  int deleteMemberOutGroup(String idGroupMessage,String idUser);

}
