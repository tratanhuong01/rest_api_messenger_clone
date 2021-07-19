package commessenger_app.clone_messenger.fileUpload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import commessenger_app.clone_messenger.fileUpload.model.UpdateAvatar;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

  Cloudinary cloudinary;

  private Map<String, String> valuesMap = new HashMap<>();

  public CloudinaryService() {
    valuesMap.put("cloud_name", "tratahuong01");
    valuesMap.put("api_key", "766394141822312");
    valuesMap.put("api_secret", "PNHwV43RnKYNC3MnK1ebW2dplqA");
    cloudinary = new Cloudinary(valuesMap);
  }

  public Map upload(UpdateAvatar updateAvatar) throws IOException {
    File file = convert(updateAvatar.getMultipartFile());
    Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
        "public_id", "Messenger/AvatarUpdate/"+ updateAvatar.getIdUser(),
        "overwrite", true,
        "resource_type", "image"
    ));
    file.delete();
    return result;
  }

  public Map delete(String id) throws IOException {
    Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    return result;
  }

  private File convert(MultipartFile multipartFile) throws IOException {
    File file = new File(multipartFile.getOriginalFilename());
    FileOutputStream fo = new FileOutputStream(file);
    fo.write(multipartFile.getBytes());
    fo.close();
    return file;
  }
}
