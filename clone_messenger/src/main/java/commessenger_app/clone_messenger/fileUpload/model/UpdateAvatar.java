package commessenger_app.clone_messenger.fileUpload.model;

import org.springframework.web.multipart.MultipartFile;

public class UpdateAvatar {
  private String idUser;
  private MultipartFile multipartFile;

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }

  public MultipartFile getMultipartFile() {
    return multipartFile;
  }

  public void setMultipartFile(MultipartFile multipartFile) {
    this.multipartFile = multipartFile;
  }
}
