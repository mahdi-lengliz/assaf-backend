package nst.assaf.assafbackend.service;

import nst.assaf.assafbackend.dto.ImageUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    ImageUploadResponse storeProductImage(MultipartFile file);
}
