package com.example.picturepublishingservice.utils;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.util.UUID;

public class FileUploadUtils {

    public static String upload(String fileName, MultipartFile multipartFile)  {

        Path uploadPath = Paths.get("file-uploads");

       try(var inputStream = multipartFile.getInputStream()){

           if(!Files.exists(uploadPath))
               Files.createDirectories(uploadPath);

           var resolvedFileName = UUID.randomUUID() + "-" + fileName;
           var filePath = uploadPath.resolve(resolvedFileName);
           Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
           return resolvedFileName;
       }catch (Exception ex){
           System.out.println(ex.getMessage() + ex);
       }

        return null;
    }
}
