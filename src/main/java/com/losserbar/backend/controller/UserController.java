package com.losserbar.backend.controller;

import com.losserbar.backend.model.login.LoginRequest;
import com.losserbar.backend.model.response.OpenApiResponse;
import com.losserbar.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static com.losserbar.backend.utils.CommonUtils.setHttpHeaders;


@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
@Validated
@PostMapping("/login")
    public ResponseEntity<OpenApiResponse> login(@RequestHeader(name = "Content-Type") String contentType,
                                                 @RequestHeader(name = "requestUID") String requestUid,
                                                 @RequestHeader(name = "correlationId") String correlationId,
                                                 @RequestHeader(name = "channels")  String channels,
                                                 @RequestHeader(name = "channelsTool")  String channelsTool,
                                                 @RequestBody LoginRequest loginRequest) {

log.info(">>>>>> {}",loginRequest);
        return userService.login(setHttpHeaders(contentType, requestUid, correlationId, channels, channelsTool),loginRequest);

//        return null;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Create a dashboard HTML template
    }
}
