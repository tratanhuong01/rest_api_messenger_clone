package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import commessenger_app.clone_messenger.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupMessageService {

  @Autowired
  private GroupMessageRepository groupMessageRepository;

  public List<GroupMessage> getGroupMessages() {
    return groupMessageRepository.findAll();
  }

  public GroupMessage addGroupMessage(GroupMessage groupMessage) {
    GroupMessage groupMessage1 = groupMessageRepository.getIdBestNew();
    groupMessage.setId(StringUtil.gereralID("groupmessage", groupMessage1 == null ? null : groupMessage1.getId()));
    groupMessage.setDateCreated(new Timestamp(new Date().getTime()));
    return groupMessageRepository.save(groupMessage);
  }

  public int updateColorChatGroupMessage(String name, String id) {
    return groupMessageRepository.updateColorChatGroupMessage("#" + name, id);
  }

  public int updateNameGroupMessage(String id, String name) {
    return groupMessageRepository.updateNameGroupMessage(name, id);
  }

  public Optional<GroupMessage> getGroupMessageById(String id) {
    return groupMessageRepository.findById(id);
  }

}
