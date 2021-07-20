package commessenger_app.clone_messenger.fileUpload;

import commessenger_app.clone_messenger.fileUpload.model.UpdateImageSingle;
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
  @PostMapping("updateImageSingle")
  public ResponseEntity<Map> updateImageSingle(@RequestParam String id,@RequestParam MultipartFile multipartFile,
                                               @RequestParam String publicId) throws IOException {
    UpdateImageSingle updateImageSingle = new UpdateImageSingle();
    updateImageSingle.setMultipartFile(multipartFile);
    updateImageSingle.setId(id);
    updateImageSingle.setPublicId(publicId);
    Map result = cloudinaryService.upload(updateImageSingle);
    return new ResponseEntity(result, HttpStatus.OK);
  }

}
