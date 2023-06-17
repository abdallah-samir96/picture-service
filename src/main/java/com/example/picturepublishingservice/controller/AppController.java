package com.example.picturepublishingservice.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

 @RestController
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
    public ResponseEntity<Map<String, String>> getAppInfo(){

        System.out.println("getting App Info " + Thread.currentThread().getName());
        var appInfo = Map
                .of(
                        "name", this.appName,
                        "version", this.appVersion,
                        "author", this.appAuthor,
                        "mentor", this.appMentor
                );

       return ResponseEntity.status(HttpStatus.OK).body(appInfo);

    }
}
