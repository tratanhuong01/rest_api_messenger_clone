package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupMessageController {

  @Autowired
  GroupMessageService groupMessageService;

  @Autowired
  @GetMapping("groupmessage")
  public List<GroupMessage> getGroupMessages() {
    return groupMessageService.getGroupMessages();
  }

  @CrossOrigin
  @PostMapping("groupmessage")
  public GroupMessage addGroupMessage(@RequestBody GroupMessage groupMessage) {
    return groupMessageService.addGroupMessage(groupMessage);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("updateGroupMessage/colorChat/{id}/{name}")
  public int updateColorChatGroupMessage(@PathVariable String id, @PathVariable String name) {
    return groupMessageService.updateColorChatGroupMessage(name, id);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("updateGroupMessage/nameGroupMessage/{id}/{name}")
  public int updateNameGroupMessage(@PathVariable String id, @PathVariable String name) {
    return groupMessageService.updateNameGroupMessage(id, name);
  }

  @CrossOrigin
  @GetMapping("groupmessage/{id}")
  public Optional<GroupMessage> getGroupMessageById(@PathVariable String id) {
    return groupMessageService.getGroupMessageById(id);
  }
}
