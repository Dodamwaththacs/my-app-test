package io.test_group.my_app_test.controller;

import io.test_group.my_app_test.service.IPFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class IPFSController {

    @Autowired
    private IPFSService ipfsService;

    @GetMapping("/save")
    public String saveText(@RequestParam("filepath") String filepath) {
        return ipfsService.saveFile(filepath);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println("Received request for file upload");
        return ipfsService.saveFile(file);
    }

    @GetMapping("/file/{hash}")
    public ResponseEntity<byte[]> getFile(@PathVariable("hash") String hash) {
        byte[] bytes = ipfsService.loadFile(hash);
        // Assuming the media type is application/octet-stream (generic binary)
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bytes);
    }
}
