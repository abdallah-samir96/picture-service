package com.example.picturepublishingservice.service;

import com.example.picturepublishingservice.utils.FileUploadUtils;
import com.example.picturepublishingservice.utils.dto.OffsetLimitDTO;
import com.example.picturepublishingservice.utils.dto.PictureInfoDTO;
import com.example.picturepublishingservice.utils.dto.PictureInfoResponse;
import com.example.picturepublishingservice.utils.mappers.PictureMapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {
     void upload(MultipartFile multipartFile, PictureInfoDTO pictureInfoDTO);
     PictureInfoResponse list(OffsetLimitDTO offsetLimitDTO);
}
