package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMessageService {

    @Autowired
    private GroupMessageRepository groupMessageRepository;

    public List<GroupMessage> getGroupMessages() {
        return groupMessageRepository.findAll();
    }

    public GroupMessage addGroupMessage(GroupMessage groupMessage) {
        return groupMessageRepository.save(groupMessage);
    }
}
