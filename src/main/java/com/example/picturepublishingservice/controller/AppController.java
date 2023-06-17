package com.example.picturepublishingservice.controller;


import com.example.picturepublishingservice.model.dto.ApplicationInfoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "app-settings", description = "Getting the Metadata Of the Application")
public class AppController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.author}")
    private String appAuthor;

    @Value("${app.mentor}")
    private String appMentor;

    @GetMapping("/info")
    @Operation(
            summary = "Getting Application Info",
            description = "Getting Application Info With Json Format and return it as map of key value pairs",
            tags = "app-settings")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ApplicationInfoDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Un Authorized", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content ={@Content()})})

    public ResponseEntity<ApplicationInfoDTO> getAppInfo() {

        System.out.println("getting App Info " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

        var appInfo = new ApplicationInfoDTO();
        appInfo.setAppAuthor(this.appAuthor);
        appInfo.setAppName(this.appName);
        appInfo.setAppVersion(this.appVersion);
        appInfo.setAppMentor(this.appMentor);

        return ResponseEntity.status(HttpStatus.OK).body(appInfo);

    }
}
