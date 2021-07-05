package commessenger_app.clone_messenger.user;

import commessenger_app.clone_messenger.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = "SELECT * from users WHERE (email = ?1 OR phone = ?1 ) AND password = ?2 ",nativeQuery = true)
    User checkLogin(String emailOrPhone, String password);

    @Query(value = "SELECT * from users WHERE (email = ?1 OR phone = ?1 )",nativeQuery = true)
    User checkEmailOrPhoneIsset(String emailOrPhone);

    @Query(value = "SELECT * from users ORDER BY id DESC LIMIT 1 ",nativeQuery = true)
    User getIdBestNew();

    @Query(value = "SELECT * from users WHERE email = ?1 OR phone = ?1 ",nativeQuery = true)
    User searchUserByEmailOrPhone(String emailOrPhone);

}
