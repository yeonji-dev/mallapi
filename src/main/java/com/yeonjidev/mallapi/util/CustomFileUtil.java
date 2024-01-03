package com.yeonjidev.mallapi.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomFileUtil {

    @Value("${com.yeonjidev.upload.path}")
    private String uploadPath;

    @PostConstruct
    public void init(){
        File tempFolder = new File(uploadPath);
        if(tempFolder.exists() == false){
            tempFolder.mkdir();
        }

        uploadPath = tempFolder.getAbsolutePath();

        log.info("================================");
        log.info(uploadPath);
    }

    public List<String> saveFiles(List<MultipartFile> files) throws RuntimeException{
        if(files == null || files.size() == 0){
            return List.of();
        }

        List<String> uploadNames = new ArrayList<>();

        for(MultipartFile multipartFile : files){
            String savedName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();

            Path savePath = Paths.get(uploadPath, savedName);

            try{
                Files.copy(multipartFile.getInputStream(), savePath);
                uploadNames.add(savedName);
            }catch (IOException e){
                throw new RuntimeException(e.getMessage());
            }
        }

        return uploadNames;
    }
}
