package com.yifan.utils;

import java.util.UUID;

public class UUIDGenerator {
    public static String generateUniqueID() {
        return UUID.randomUUID().toString();
    }
}
