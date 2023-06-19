package com.example.picturepublishingservice.controller;

import com.example.picturepublishingservice.service.PictureService;
import com.example.picturepublishingservice.utils.dto.OffsetLimitDTO;
import com.example.picturepublishingservice.utils.dto.PictureInfoDTO;
import com.example.picturepublishingservice.utils.dto.PictureInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/picture")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(@Autowired PictureService pictureService) {
        this.pictureService = pictureService;
    }


    @PostMapping("/upload")
    @Operation(
            summary = "Uploading User Photo With Info",
            description = "upload the photo with the description and category",
            tags = "photo-files")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = String.class), mediaType = "application/json", examples = @ExampleObject(name = "ok", summary = "the response when the endpoint success"))}),
            @ApiResponse(responseCode = "404", description = "Un Authorized", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content ={@Content()})})

    public ResponseEntity<String> upload(
            @RequestParam("file")MultipartFile multipartFile,
            @ModelAttribute PictureInfoDTO pictureInfoDTO
    ){

        pictureService.upload(multipartFile, pictureInfoDTO);

     return ResponseEntity.status(HttpStatus.OK).body("ok");

    }


    @GetMapping(value = "/list", produces = "application/json", consumes = "application/json")
    @Operation(
            summary = "Get all Photos Info",
            description = "getting all photos info and display them",
            tags = "photo-files")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = PictureInfoResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Un Authorized", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content ={@Content()})})

    public ResponseEntity<PictureInfoResponse> list(@Valid  @RequestBody OffsetLimitDTO offsetLimitDTO){

        return ResponseEntity.status(HttpStatus.OK).body(pictureService.list(offsetLimitDTO));

    }

}
