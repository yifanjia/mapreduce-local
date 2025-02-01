package com.yifan.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class NetworkAddr {
    @NonNull
    private String host;
    private int port;
}
