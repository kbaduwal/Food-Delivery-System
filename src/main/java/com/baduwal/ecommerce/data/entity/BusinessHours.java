package com.baduwal.ecommerce.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class BusinessHours {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
}
