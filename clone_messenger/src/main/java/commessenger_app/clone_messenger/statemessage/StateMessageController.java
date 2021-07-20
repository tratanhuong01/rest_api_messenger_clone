package commessenger_app.clone_messenger.statemessage;

import commessenger_app.clone_messenger.statemessage.model.StateMessage;
import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.State;
import java.util.List;

@RestController
public class StateMessageController {

  @Autowired
  StateMessageService stateMessageService;

  @CrossOrigin
  @GetMapping("stateMessage")
  public List<StateMessage> getAllStateMessage() {
    return stateMessageService.getAllStateMessage();
  }

  @CrossOrigin
  @GetMapping("stateMessage/{id}")
  public List<StateMessage> getStateMessageByIdMessage(@PathVariable String id) {
    return stateMessageService.getStateMessageByIdMessage(id);
  }

  @CrossOrigin
  @PostMapping("stateMessage")
  public StateMessage addStateMessage(@RequestBody StateMessage stateMessage) {
    return stateMessageService.addStateMessage(stateMessage);
  }

  @CrossOrigin
  @PutMapping("stateMessage")
  public StateMessage updateStateMessage(@RequestBody StateMessage stateMessage) {
    return stateMessageService.updateStateMessage(stateMessage);
  }

}
