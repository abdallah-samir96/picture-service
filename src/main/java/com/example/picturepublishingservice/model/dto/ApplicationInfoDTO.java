package com.example.picturepublishingservice.model.dto;

public class ApplicationInfoDTO {

    private String appName;

    private String appVersion;

    private String appAuthor;

    private String appMentor;

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setAppAuthor(String appAuthor) {
        this.appAuthor = appAuthor;
    }

    public void setAppMentor(String appMentor) {
        this.appMentor = appMentor;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getAppAuthor() {
        return appAuthor;
    }

    public String getAppMentor() {
        return appMentor;
    }
}
