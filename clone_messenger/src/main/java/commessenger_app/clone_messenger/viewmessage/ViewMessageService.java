package commessenger_app.clone_messenger.viewmessage;

import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewMessageService {

  @Autowired
  ViewMessageRepository viewMessageRepository;

  public List<ViewMessage> getAllViewMessage() {
    return viewMessageRepository.findAll();
  }

  public ViewMessage addViewMessage(ViewMessage viewMessage) {
    return viewMessageRepository.save(viewMessage);
  }

  public ViewMessage updateViewMessage(ViewMessage viewMessage) {
    return viewMessageRepository.save(viewMessage);
  }

  public List<ViewMessage> getViewMessageByIdMessage(String idMessage) {
    return viewMessageRepository.getViewMessageByIdMessage(idMessage);
  }

}
