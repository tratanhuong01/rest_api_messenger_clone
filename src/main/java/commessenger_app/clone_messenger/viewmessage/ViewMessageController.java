package commessenger_app.clone_messenger.viewmessage;

import commessenger_app.clone_messenger.viewmessage.model.ViewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ViewMessageController {

  @Autowired
  ViewMessageService viewMessageService;

  @CrossOrigin
  @GetMapping("viewMessage")
  public List<ViewMessage> getAllViewMessage() {
    return viewMessageService.getAllViewMessage();
  }

  @CrossOrigin
  @PostMapping("viewMessage")
  public ViewMessage addViewMessage(@RequestBody ViewMessage viewMessage) {
    return viewMessageService.addViewMessage(viewMessage);
  }

  @CrossOrigin
  @PutMapping("viewMessage")
  public ViewMessage updateViewMessage(@RequestBody ViewMessage viewMessage) {
    return viewMessageService.addViewMessage(viewMessage);
  }

  @CrossOrigin
  @GetMapping("viewMessage/{idMessage}")
  public List<ViewMessage> getViewMessageByIdMessage(@PathVariable String idMessage) {
    return viewMessageService.getViewMessageByIdMessage(idMessage);
  }

  @CrossOrigin
  @PutMapping("updateViewMessage/{idGroupMessage}/{idUser}")
  public int updateViewMessageHandle(@PathVariable String idGroupMessage,@PathVariable String idUser) {
    return viewMessageService.updateViewMessageHandle(idGroupMessage, idUser);
  }

  @CrossOrigin
  @PutMapping("checkViewMessage/{idGroupMessage}/{idUser}")
  public List<ViewMessage> checkViewMessageHandle(@PathVariable String idGroupMessage,@PathVariable String idUser) {
    return viewMessageService.checkViewMessageHandle(idGroupMessage, idUser);
  }

}
