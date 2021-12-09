package commessenger_app.clone_messenger.statemessage;

import commessenger_app.clone_messenger.statemessage.model.StateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StateMessageService {

  @Autowired
  StateMessageRepository stateMessageRepository;

  public List<StateMessage> getAllStateMessage() {
    return stateMessageRepository.findAll();
  }

  public List<StateMessage> getStateMessageByIdMessage(String idMessage) {
    return stateMessageRepository.getStateMessageByIdMessage(idMessage);
  }

  public StateMessage addStateMessage(StateMessage stateMessage) {
    return stateMessageRepository.save(stateMessage);
  }

  public StateMessage updateStateMessage(StateMessage stateMessage) {
    return stateMessageRepository.save(stateMessage);
  }


}
