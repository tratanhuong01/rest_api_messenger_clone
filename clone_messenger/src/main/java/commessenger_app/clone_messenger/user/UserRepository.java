package commessenger_app.clone_messenger.user;

import commessenger_app.clone_messenger.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
  @Query(value = "SELECT * from users WHERE (email = ?1 OR phone = ?1 ) AND password = ?2 ", nativeQuery = true)
  User checkLogin(String emailOrPhone, String password);

  @Query(value = "SELECT * from users WHERE (email = ?1 OR phone = ?1 )", nativeQuery = true)
  User checkEmailOrPhoneIsset(String emailOrPhone);

  @Query(value = "SELECT * from users ORDER BY id DESC LIMIT 1 ", nativeQuery = true)
  User getIdBestNew();

  @Query(value = "SELECT * from users WHERE email = ?1 OR phone = ?1 ", nativeQuery = true)
  User searchUserByEmailOrPhone(String emailOrPhone);

  @Modifying
  @Transactional
  @Query(value = "UPDATE users SET dark_mode = ?1 WHERE id = ?2 ", nativeQuery = true)
  int updateDarkModeUser(int type, String id);
}
