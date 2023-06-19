package com.example.picturepublishingservice.utils.dto;

import java.util.List;

public class PictureInfoResponse {
     private List<PictureInfoDTO> data;
     private long totalCount;


    public void setData(List<PictureInfoDTO> data) {
        this.data = data;
    }


    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<PictureInfoDTO> getData() {
        return data;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
