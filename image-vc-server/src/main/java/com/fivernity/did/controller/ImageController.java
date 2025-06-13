package com.fivernity.did.controller;

import com.fivernity.did.service.DIDService;
import com.fivernity.did.service.ImageService;
import com.fivernity.did.service.VCService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;
    private final DIDService didService;
    private final VCService vcService;

    public ImageController(ImageService imageService, DIDService didService, VCService vcService) {
        this.imageService = imageService;
        this.didService = didService;
        this.vcService = vcService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        // 1. 이미지 저장
        String imageUrl = imageService.save(file);

        // 2. DID 생성
        String did = didService.createDid();

        // 3. VC 생성 + 서명
        String vc = vcService.createAndSignVc(did, imageUrl);

        // 4. 저장 또는 반환
        return ResponseEntity.ok(vc);
    }
}
