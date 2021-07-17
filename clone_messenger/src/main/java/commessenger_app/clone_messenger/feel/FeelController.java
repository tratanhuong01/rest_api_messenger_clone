package commessenger_app.clone_messenger.feel;

import commessenger_app.clone_messenger.feel.model.Feel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeelController {

  @Autowired
  FeelService feelService;

  @CrossOrigin
  @GetMapping("feel/{id}")
  public List<Feel> getAllFeels(@PathVariable String id) {
    return feelService.getAllFeels(id);
  }

  @CrossOrigin
  @PostMapping("feel")
  public Feel addFeel(@RequestBody Feel feel) {
    return feelService.addFeel(feel);
  }

  @CrossOrigin
  @DeleteMapping("deleteFeel/{idMessage}/{idUser}")
  public int deleteFeel(@PathVariable String idMessage,@PathVariable String idUser) {
    return feelService.deleteFeel(idMessage, idUser);
  }

  @CrossOrigin
  @PutMapping("feel")
  public Feel updateFeel(@RequestBody Feel feel) {
    return feelService.updateFeel(feel);
  }

  @CrossOrigin
  @GetMapping("checkIsFeel/{idMessage}/{idUser}")
  public Feel checkIsFeel(@PathVariable String idMessage,@PathVariable String idUser) {
    return feelService.checkIsFeel(idMessage, idUser);
  }
}
