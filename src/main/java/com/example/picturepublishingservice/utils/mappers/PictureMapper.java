package com.example.picturepublishingservice.utils.mappers;

import com.example.picturepublishingservice.model.Picture;
import com.example.picturepublishingservice.utils.dto.PictureInfoDTO;

public class PictureMapper {

    public static Picture toEntity(PictureInfoDTO pictureInfoDTO){

        var picture = new Picture();
        picture.setCategory(pictureInfoDTO.getCategory());
        picture.setDescription(pictureInfoDTO.getDescription());
        picture.setName(pictureInfoDTO.getName());
        picture.setSize(pictureInfoDTO.getSize());
        return picture;
    }
    public static PictureInfoDTO toDTO(Picture picture){

        var pictureInfoDTO = new PictureInfoDTO();
        pictureInfoDTO.setCategory(picture.getCategory());
        pictureInfoDTO.setSize(picture.getSize());
        pictureInfoDTO.setName(picture.getName());
        pictureInfoDTO.setDescription(picture.getDescription());
        return pictureInfoDTO;
    }

}
