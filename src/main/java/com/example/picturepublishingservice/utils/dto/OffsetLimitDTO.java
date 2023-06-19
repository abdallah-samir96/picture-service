package com.example.picturepublishingservice.utils.dto;

import jakarta.validation.constraints.Min;

public class OffsetLimitDTO {

    @Min(value = 0, message = "offset must be >= 0")
    public int offset = 0;
    @Min(value = 0, message = "limit must be >= 0")
    public int limit = 20;
}
