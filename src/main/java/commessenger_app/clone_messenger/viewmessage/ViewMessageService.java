package commessenger_app.clone_messenger.viewmessage;

import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
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

  public int updateViewMessageHandle(String idGroupMessage,String idUser) {
    return viewMessageRepository.updateViewMessageHandle(idGroupMessage,idUser);
  }

  public List<ViewMessage> checkViewMessageHandle(String idGroupMessage, String idUser) {
    return viewMessageRepository.checkViewMessageHandle(idGroupMessage,idUser);
  }

}
