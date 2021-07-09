package commessenger_app.clone_messenger.user;

import commessenger_app.clone_messenger.DTO.RelationUser;
import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import commessenger_app.clone_messenger.user.model.FormLogin;
import commessenger_app.clone_messenger.user.model.FormRegister;
import commessenger_app.clone_messenger.user.model.User;
import commessenger_app.clone_messenger.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User checkLogin(FormLogin formLogin){
        User user = userRepository.checkLogin(formLogin.getEmailOrPhone(),formLogin.getPassword());
        if (user == null)
            return null;
        else
            return user;
    }

    public List<User> updateUserById(User user,String id) {
        userRepository.findById(id).map(
                userData -> {
                    userData = user;
                    return userRepository.save(userData);
                }
        );
        return userRepository.findAll();
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public Boolean addUser(User user) {
        if (StringUtil.regexEmail(user.getEmail()))
            user.setPhone(null);
        else if (StringUtil.regexPhone(user.getPhone()))
            user.setEmail(null);
        else
        {
            user.setEmail(null);
            user.setPhone(null);
        }
        if (user.getPhone() == null && user.getEmail() == null)
            return false;
        else
        {
            User userGet = userRepository.getIdBestNew();
            user.setId(StringUtil.gereralID("users",userGet == null ? null : userGet.getId()));
            user.setAvatar("/images/" + (
                    user.getSex().equals("Nam") ? "male/" + String.valueOf(StringUtil.ramdomNumber(1,10))  + ".jpg"
                            : user.getSex().equals("Nữ") ? "female/" +
                            String.valueOf(StringUtil.ramdomNumber(1,10))  +
                            ".jpg": "other/1.jpg")
            );
            user.setDateCreated(new Timestamp(new Date().getTime()));
            user.setTypeAccoount(1);
            userRepository.save(user);
            return true;
        }
    }

    public FormRegister checkEmailOrPhoneIsset(FormRegister formRegister) {
        User user = userRepository.checkEmailOrPhoneIsset(formRegister.getEmailOrPhone());
        if (user == null)
            return formRegister;
        else
            return null;
    }

    public List<User> deleteUserById(String id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

    public User searchUserByEmailOrPhone(String emailOrPhone) {
        return userRepository.searchUserByEmailOrPhone(emailOrPhone);
    }
    public List<User> processUserTint(RelationUser relationUser) {
        List<User> newList = new ArrayList<>();
        List<User> userNewList = relationUser.getUserList();
        List<RelationshipUser> relationshipUserList = relationUser.getRelationshipUserList();
        for (int i = 0; i < userNewList.size() ; i++) {
            int check = 0;
            for (int j = 0; j < relationshipUserList.size() ; j++) {
                if (userNewList.get(i).getId().equals(relationshipUserList.get(j).getUserRelationshipUser().getId()))
                    check++;
            }
            if (check == 0 && !userNewList.get(i).getId().equals(relationUser.getIdMain()))
                newList.add(userNewList.get(i));
        }
        return newList;
    }
}
