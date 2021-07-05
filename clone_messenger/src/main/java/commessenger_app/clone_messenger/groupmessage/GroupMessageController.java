package commessenger_app.clone_messenger.groupmessage;

import commessenger_app.clone_messenger.groupmessage.model.GroupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
