package com.losserbar.backend.utils;

import org.springframework.http.HttpHeaders;

import java.util.UUID;

import static com.losserbar.backend.config.CommonConstant.CHANNELS;
import static com.losserbar.backend.config.CommonConstant.CHANNELS_TOOL;
import static com.losserbar.backend.config.CommonConstant.CORRELATION_ID;
import static com.losserbar.backend.config.CommonConstant.REQUEST_UID;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.util.StringUtils.replace;

public class CommonUtils {
    public static String generateUUID() {
        return replace(UUID.randomUUID().toString(), "-", "");
    }

    public static HttpHeaders setHttpHeaders(
            String contentType,
            String requestUid,
            String correlationId,
            String channels,
            String channelsTool) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(CONTENT_TYPE, contentType);
        httpHeaders.set(REQUEST_UID, requestUid);
        httpHeaders.set(CORRELATION_ID, correlationId);
        httpHeaders.set(CHANNELS, channels);
        httpHeaders.set(CHANNELS_TOOL, channelsTool);
        return httpHeaders;
    }
}
