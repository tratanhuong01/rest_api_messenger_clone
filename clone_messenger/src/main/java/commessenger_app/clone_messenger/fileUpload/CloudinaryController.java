package commessenger_app.clone_messenger.fileUpload;

import commessenger_app.clone_messenger.DTO.ImageMulti;
import commessenger_app.clone_messenger.fileUpload.model.UpdateImageSingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    Map result = cloudinaryService.uploadSingle(updateImageSingle);
    return new ResponseEntity(result, HttpStatus.OK);
  }

  @CrossOrigin
  @PostMapping("updateImageSingleChild")
  public ResponseEntity<Map> updateImageSingleChild(@RequestParam MultipartFile multipartFile,
                                               @RequestParam String publicId) throws IOException {
    UpdateImageSingle updateImageSingle = new UpdateImageSingle();
    updateImageSingle.setMultipartFile(multipartFile);
    updateImageSingle.setPublicId(publicId);
    Map result = cloudinaryService.uploadSingleChild(updateImageSingle);
    return new ResponseEntity(result, HttpStatus.OK);
  }

  @CrossOrigin
  @PostMapping("updateImageMulti")
  public List<ResponseEntity<Map>> updateImageMulti(@RequestParam("multipartFiles") MultipartFile[] multipartFiles,
                                                    @RequestParam String publicId) throws IOException {
    List<ResponseEntity<Map>> responseEntityList = new ArrayList<>();
    List<UpdateImageSingle> updateImageSingleList = new ArrayList<>();
    for (MultipartFile multipartFile: multipartFiles) {
      UpdateImageSingle updateImageSingle = new UpdateImageSingle();
      updateImageSingle.setMultipartFile(multipartFile);
      updateImageSingle.setPublicId(publicId);
      updateImageSingle.setId("");
      updateImageSingleList.add(updateImageSingle);
      Map result = cloudinaryService.uploadMulti(updateImageSingle);
      responseEntityList.add(new ResponseEntity(result,HttpStatus.OK));
    }
    return responseEntityList;
  }

}
