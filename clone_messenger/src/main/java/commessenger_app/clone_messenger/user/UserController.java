package commessenger_app.clone_messenger.user;

import commessenger_app.clone_messenger.DTO.RelationUser;
import commessenger_app.clone_messenger.relationshipuser.model.RelationshipUser;
import commessenger_app.clone_messenger.user.model.FormLogin;
import commessenger_app.clone_messenger.user.model.FormRegister;
import commessenger_app.clone_messenger.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getUser() {
        return userService.getUser();
    }

    @CrossOrigin
    @PostMapping("/users")
    public Boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @CrossOrigin
    @PostMapping("/checkEmailOrPhoneIsset")
    public FormRegister checkEmailOrPhoneIsset(@RequestBody FormRegister formRegister) {
        return userService.checkEmailOrPhoneIsset(formRegister);
    }

    @CrossOrigin
    @PostMapping("/checkLogin")
    public User checkLogin(@RequestBody FormLogin formLogin) {
        return userService.checkLogin(formLogin);
    }

    @PutMapping("/users/{id}")
    public List<User> updateUserById(@RequestBody User user, @PathVariable String id) {
        return userService.updateUserById(user,id);
    }

    @DeleteMapping("/users/{id}")
    public List<User> deleteUserById(@PathVariable String id) {
        return userService.deleteUserById(id);
    }

    @CrossOrigin
    @GetMapping("searchUserByEmailOrPhone/{data}")
    public User searchUserByEmailOrPhone(@PathVariable String data) {
        return userService.searchUserByEmailOrPhone(data);
    }

    @CrossOrigin
    @PostMapping("processUserTint")
    public List<User> processUserTint(@RequestBody RelationUser relationUser) {
        return userService.processUserTint(relationUser);
    }

    @CrossOrigin
    @GetMapping("updateUser/darkMode/{type}/{id}")
    public User updateDarkModeUser(@PathVariable int type,@PathVariable String id) {
        return userService.updateDarkModeUser(type,id);
    }
}
