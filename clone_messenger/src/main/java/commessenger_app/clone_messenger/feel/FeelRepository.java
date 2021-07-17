package commessenger_app.clone_messenger.feel;

import commessenger_app.clone_messenger.feel.model.Feel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FeelRepository extends JpaRepository<Feel,Long> {
  @Query(value = "SELECT * FROM feel WHERE id_message = ?1 ",nativeQuery = true)
  public List<Feel> getAllFeels(String id);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM feel WHERE id_message = ?1 AND id_user = ?2 ",nativeQuery = true)
  public int deleteFeel(String idMessage,String idUser);

  @Query(value = "SELECT * FROM feel WHERE id_message = ?1 AND id_user = ?2 ",nativeQuery = true)
  public Feel checkIsFeel(String idMessage,String idUser);
}
