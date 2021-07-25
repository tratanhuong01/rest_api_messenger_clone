package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.DTO.IconChat;
import commessenger_app.clone_messenger.DTO.ImageSingle;
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
  @GetMapping("groupMessage")
  public List<GroupMessage> getGroupMessages() {
    return groupMessageService.getGroupMessages();
  }

  @CrossOrigin
  @PostMapping("groupMessage")
  public GroupMessage addGroupMessage(@RequestBody GroupMessage groupMessage) {
    return groupMessageService.addGroupMessage(groupMessage);
  }

  @CrossOrigin
  @GetMapping("updateGroupMessage/colorChat/{id}/{name}")
  public int updateColorChatGroupMessage(@PathVariable String id, @PathVariable String name) {
    return groupMessageService.updateColorChatGroupMessage(name, id);
  }

  @CrossOrigin
  @GetMapping("updateGroupMessage/nameGroupMessage/{id}/{name}")
  public int updateNameGroupMessage(@PathVariable String id, @PathVariable String name) {
    return groupMessageService.updateNameGroupMessage(id, name);
  }

  @CrossOrigin
  @GetMapping("groupMessage/{id}")
  public Optional<GroupMessage> getGroupMessageById(@PathVariable String id) {
    return groupMessageService.getGroupMessageById(id);
  }

  @CrossOrigin
  @PutMapping("updateGroupMessage/iconChat")
  public int updateIconChatMessage(@RequestBody  IconChat iconChat) {
    return groupMessageService.updateIconChatMessage(iconChat.getIcon(),iconChat.getId());
  }

  @CrossOrigin
  @PutMapping("updateGroupMessage/typeGroupMessage/{typeGroupMessage}/{idGroupMessage}")
  public int updateTypeGroupMessage(@PathVariable int typeGroupMessage,@PathVariable String idGroupMessage) {
    return groupMessageService.updateTypeGroupMessage(typeGroupMessage,idGroupMessage);
  }

  @CrossOrigin
  @PutMapping("updateGroupMessage/imageGroup")
  public int updateImageGroupMessage(@RequestBody ImageSingle imageSingle) {
    return groupMessageService.updateImageGroupMessage(imageSingle);
  }

}
