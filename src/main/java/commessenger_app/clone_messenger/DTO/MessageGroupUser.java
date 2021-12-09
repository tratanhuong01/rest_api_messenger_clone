package commessenger_app.clone_messenger.DTO;

import commessenger_app.clone_messenger.feel.model.Feel;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import java.util.List;


@SqlResultSetMapping(name = "customDataMapping",
    classes = @ConstructorResult(
        targetClass = MessageGroupUser.class,
        columns = {
            @ColumnResult(name = "idUser", type = String.class),
            @ColumnResult(name = "firstName", type = String.class),
            @ColumnResult(name = "lastName", type = String.class),
            @ColumnResult(name = "idGroupMessage", type = String.class),
            @ColumnResult(name = "idMessage", type = String.class),
            @ColumnResult(name = "dateCreated", type = String.class),
            @ColumnResult(name = "iconChat", type = String.class),
            @ColumnResult(name = "nameGroupMessage", type = String.class),
            @ColumnResult(name = "colorChat", type = String.class),
            @ColumnResult(name = "avatar"),
            @ColumnResult(name = "stateMessage"),
            @ColumnResult(name = "content"),
            @ColumnResult(name = "nickName"),
            @ColumnResult(name = "typeMessage"),
            @ColumnResult(name = "imageGroup"),
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

  String getImageGroup();
}
