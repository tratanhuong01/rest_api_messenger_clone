package commessenger_app.clone_messenger.DTO;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;


@SqlResultSetMapping(name = "customDataMapping",
    classes = @ConstructorResult(
        targetClass = MessageGroupUser.class,
        columns = {
            @ColumnResult(name = "id_user", type = String.class),
            @ColumnResult(name = "first_name", type = String.class),
            @ColumnResult(name = "last_name", type = String.class),
            @ColumnResult(name = "id_group_message", type = String.class),
            @ColumnResult(name = "id_message", type = String.class),
            @ColumnResult(name = "date_created", type = String.class),
            @ColumnResult(name = "icon_chat", type = String.class),
            @ColumnResult(name = "name_group_message", type = String.class),
            @ColumnResult(name = "color_chat", type = String.class),
            @ColumnResult(name = "avatar"),
            @ColumnResult(name = "stateMessage"),
            @ColumnResult(name = "content"),
            @ColumnResult(name = "nickName"),
            @ColumnResult(name = "typeMessage"),
        }
    )
)

@NamedNativeQuery(name = "getMessagesByGroupMessage", query = " select u.id as idUser , u.firstName , u.lastName , " +
    " gm.id as idGroupMessage , m.id as idMessage , " +
    "m.dateCreated ,gm.iconChat,gm.nameGroupMessage,gm.colorChat, u.avatar,m.stateMessage " +
    " , m.content,m.nickName, m.typeMessage from messages as m inner join " +
    "groupmessage gm on m.id_group_message = gm.id inner join users as u on u.id = m.id_user ",
    resultSetMapping = "customDataMapping")

public interface MessageGroupUser {

  String getIdUser();

  String getFirstName();

  String getLastName();

  String getIdGroupMessage();

  String getIdMessage();

  String getDateCreated();

  String getIconChat();

  String getNameGroupMessage();

  String getColorChat();

  String getAvatar();

  String getStateMessage();

  String getContent();

  String getNickName();

  String getTypeMessage();

  String getTypeGroupMessage();
}
