package com.example.picturepublishingservice.service.impl;

import com.example.picturepublishingservice.repository.PictureRepository;
import com.example.picturepublishingservice.service.PictureService;
import com.example.picturepublishingservice.utils.FileUploadUtils;
import com.example.picturepublishingservice.utils.dto.OffsetLimitDTO;
import com.example.picturepublishingservice.utils.dto.PictureInfoDTO;
import com.example.picturepublishingservice.utils.dto.PictureInfoResponse;
import com.example.picturepublishingservice.utils.mappers.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(@Autowired PictureRepository pictureRepository){
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void upload(MultipartFile multipartFile, PictureInfoDTO pictureInfoDTO){

        var fileName = FileUploadUtils.upload(multipartFile.getOriginalFilename(), multipartFile);
        pictureInfoDTO.setName(fileName);
        pictureInfoDTO.setSize(multipartFile.getSize());
        pictureRepository.save(PictureMapper.toEntity(pictureInfoDTO));

    }


    @Override
    public PictureInfoResponse list(OffsetLimitDTO offsetLimitDTO) {
        var pictureInfoResponse = new PictureInfoResponse();
        int pageSize = offsetLimitDTO.offset / offsetLimitDTO.limit;
        var page = pictureRepository.list(PageRequest.of(pageSize, offsetLimitDTO.limit));
        pictureInfoResponse.setTotalCount(page.getTotalElements());
        pictureInfoResponse.setData(page.stream().map(PictureMapper::toDTO).collect(Collectors.toList()));

        return pictureInfoResponse;
    }
}
