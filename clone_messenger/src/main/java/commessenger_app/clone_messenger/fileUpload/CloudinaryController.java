package commessenger_app.clone_messenger.fileUpload;

import commessenger_app.clone_messenger.DTO.Avatar;
import commessenger_app.clone_messenger.fileUpload.model.UpdateAvatar;
import commessenger_app.clone_messenger.user.UserService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class CloudinaryController {
  @Autowired
  CloudinaryService cloudinaryService;

  @CrossOrigin
  @PostMapping("updateAvatar")
  public ResponseEntity<Map> updateAvatar(@RequestParam MultipartFile multipartFile,@RequestParam String idUser) throws IOException {
    UpdateAvatar updateAvatar = new UpdateAvatar();
    updateAvatar.setMultipartFile(multipartFile);
    updateAvatar.setIdUser(idUser);
    Map result = cloudinaryService.upload(updateAvatar);
    return new ResponseEntity(result, HttpStatus.OK);
  }
}
