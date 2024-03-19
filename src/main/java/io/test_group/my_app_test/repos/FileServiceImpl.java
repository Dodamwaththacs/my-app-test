package io.test_group.my_app_test.repos;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImpl {

    String saveFile(String filePath);
    String saveFile(MultipartFile file);

    byte[] loadFile(String hash);
}
