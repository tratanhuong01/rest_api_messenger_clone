package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import commessenger_app.clone_messenger.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class GroupMessageService {

    @Autowired
    private GroupMessageRepository groupMessageRepository;

    public List<GroupMessage> getGroupMessages() {
        return groupMessageRepository.findAll();
    }

    public GroupMessage addGroupMessage(GroupMessage groupMessage) {
        GroupMessage groupMessage1 = groupMessageRepository.getIdBestNew();
        groupMessage.setId(StringUtil.gereralID("groupmessage",groupMessage1 == null ? null :groupMessage1.getId()));
        groupMessage.setDateCreated(new Timestamp(new Date().getTime()));
        groupMessage.setTypeGroupMessage(0);
        return groupMessageRepository.save(groupMessage);
    }
}
