package com.losserbar.backend.utils;

import com.losserbar.backend.model.response.OpenApiResponse;
import com.losserbar.backend.model.response.OpenApiResponseCode;
import com.losserbar.backend.model.response.OpenApiResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OpenApiUtilService {
    private static final Logger log = LoggerFactory.getLogger(OpenApiUtilService.class);

    public OpenApiUtilService() {
    }

    public ResponseEntity<OpenApiResponse> generateSuccessOpenApiResponse(Object data) {
        log.info("Open API response: {} with {}", OpenApiResponseCode.SUCCESS, HttpStatus.OK);
        OpenApiResponse openApiResponse = new OpenApiResponse();
        OpenApiResponseStatus openApiResponseStatus = new OpenApiResponseStatus();
        openApiResponseStatus.setCode(1000);
        openApiResponseStatus.setDescription("Success");
        openApiResponse.setStatus(openApiResponseStatus);
        openApiResponse.setData(data);
        return ResponseEntity.ok().body(openApiResponse);
    }

    public ResponseEntity<OpenApiResponse> generateSuccessOpenApiResponse(Object data, HttpStatus httpStatus) {
        log.info("Open API response: {} with {}", OpenApiResponseCode.SUCCESS, httpStatus);
        OpenApiResponse openApiResponse = new OpenApiResponse();
        OpenApiResponseStatus openApiResponseStatus = new OpenApiResponseStatus();
        openApiResponseStatus.setCode(1000);
        openApiResponseStatus.setDescription("Success");
        openApiResponse.setStatus(openApiResponseStatus);
        openApiResponse.setData(data);
        return new ResponseEntity(openApiResponse, httpStatus);
    }

    public ResponseEntity<OpenApiResponse> generateResponseEntityWithStandardError(final HttpHeaders responseHttpHeaders, final OpenApiResponseCode errorResponseCode) {
        log.error("Open API error response: {}", errorResponseCode);
        return new ResponseEntity(OpenApiResponse.generateErrorResponse(errorResponseCode), responseHttpHeaders, errorResponseCode.getHttpStatusCode());
    }

    public ResponseEntity<OpenApiResponse> generateResponseEntityWithStandardUnableToUpdateError(final HttpHeaders responseHttpHeaders) {
        log.error("Open API error response: {}", responseHttpHeaders);
        return new ResponseEntity((new OpenApiResponse()).setStatus((new OpenApiResponseStatus()).setCode(2101).setDescription("Unable to update processed loan application")), responseHttpHeaders, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<OpenApiResponse> generateResponseEntityWithStandardCMError(final HttpHeaders responseHttpHeaders, String fieldName) {
        String var10000 = OpenApiResponseCode.MISSING_REQUIRED_PARAMETERS.getDescription();
        String errorMessage = var10000 + " [" + fieldName + "]";
        log.error("Open API error response: {}", errorMessage);
        return new ResponseEntity((new OpenApiResponse()).setStatus((new OpenApiResponseStatus()).setDescription(errorMessage).setCode(OpenApiResponseCode.MISSING_REQUIRED_PARAMETERS.value())), responseHttpHeaders, OpenApiResponseCode.MISSING_REQUIRED_PARAMETERS.getHttpStatusCode());
    }

    public ResponseEntity<OpenApiResponse> generateResponseEntityWithCustomError(final HttpHeaders responseHttpHeaders, final OpenApiResponseCode errorResponseCode, Object data) {
        log.error("Open API error response: {}", errorResponseCode);
        return new ResponseEntity(OpenApiResponse.generateErrorResponseWithData(errorResponseCode, data), responseHttpHeaders, errorResponseCode.getHttpStatusCode());
    }

    public ResponseEntity<OpenApiResponse> generateResponseEntityWithCustomSuccess(final HttpHeaders responseHttpHeaders, final OpenApiResponseCode responseCode, final String message) {
        log.error("Open API error response: {}", responseCode);
        return new ResponseEntity(OpenApiResponse.generateResponse(responseCode, message), responseHttpHeaders, responseCode.getHttpStatusCode());
    }

    public ResponseEntity<OpenApiResponse> generateResponseEntityWithCustomFieldSuccess(final HttpHeaders responseHttpHeaders, final Integer code, final String description, final String message) {
        log.error("Open API error response: HttpStatus: {} with code {}", HttpStatus.OK, code);
        return new ResponseEntity(OpenApiResponse.generateCustomResponse(code, description, message), responseHttpHeaders, HttpStatus.OK);
    }


}