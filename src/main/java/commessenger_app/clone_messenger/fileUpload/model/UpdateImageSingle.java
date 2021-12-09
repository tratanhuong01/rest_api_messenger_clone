package commessenger_app.clone_messenger.fileUpload.model;

import org.springframework.web.multipart.MultipartFile;

public class UpdateImageSingle {
  private String id;
  private MultipartFile multipartFile;
  private String publicId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MultipartFile getMultipartFile() {
    return multipartFile;
  }

  public void setMultipartFile(MultipartFile multipartFile) {
    this.multipartFile = multipartFile;
  }

  public String getPublicId() {
    return publicId;
  }

  public void setPublicId(String publicId) {
    this.publicId = publicId;
  }
}
