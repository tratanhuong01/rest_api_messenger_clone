package commessenger_app.clone_messenger.feel;

import commessenger_app.clone_messenger.feel.model.Feel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeelService {

  @Autowired
  FeelRepository feelRepository;

  public List<Feel> getAllFeels(String id) {
    return feelRepository.getAllFeels(id);
  }

  public Feel addFeel(Feel feel) {
    return feelRepository.save(feel);
  }

  public int deleteFeel(String idMessage,String idUser) {
    return feelRepository.deleteFeel(idMessage, idUser);
  }

  public Feel updateFeel(Feel feel) {
    return feelRepository.save(feel);
  }

  public Feel checkIsFeel(String idMessage,String idUser) {
    return feelRepository.checkIsFeel(idMessage, idUser);
  }

}
