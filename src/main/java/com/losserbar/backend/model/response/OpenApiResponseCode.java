package com.losserbar.backend.model.response;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum OpenApiResponseCode {
    SUCCESS(HttpStatus.OK, 1000, "Success"),
    DATA_SUCCESSFULLY_UPDATED(HttpStatus.OK, 1000, "Data successfully updated"),
    INVALID_LOYALTY_POINT(HttpStatus.OK, 1001, "Invalid loyalty Point"),
    SUCCESS_WITH_NO_CONTENT(HttpStatus.OK, 1001, "Success with condition (No content to return)"),
    RECORD_NOT_FOUND(HttpStatus.OK, 1001, "Record not found"),
    INVALID_USERNAME_OR_PASSWORD(HttpStatus.BAD_REQUEST, 1001, "Invalid username or password"),
    CREATION_SUCCESSFUL(HttpStatus.CREATED, 1000, "Creation successful"),
    THE_REQUEST_RUN_IN_THE_BACKGROUND(HttpStatus.ACCEPTED, 1000, "The request has been received and presumed to run in the background"),
    DATA_SUCCESSFULLY_DELETED(HttpStatus.NO_CONTENT, 1000, "Data successfully deleted"),
    MISSING_REQUIRED_PARAMETERS(HttpStatus.BAD_REQUEST, 1101, "Missing required parameters"),
    INVALID_PARAMETERS_ENTERED(HttpStatus.BAD_REQUEST, 1102, "Invalid parameters entered"),
    EMPTY_STRING_INPUT_NOT_SUPPORTED(HttpStatus.BAD_REQUEST, 1103, "Empty string input not supported"),
    REQUESTED_ENTITY_RECORD_DOES_NOT_EXIST(HttpStatus.NOT_FOUND, 1104, "Requested entity record does not exist"),
    INVALID_ACCOUNT_NUMBER(HttpStatus.CONFLICT, 1104, "Invalid account number entered / invalid destination bank entered"),
    UNRECOGNIZED_FIELD_NAME(HttpStatus.BAD_REQUEST, 1105, "Unrecognized field name was entered - Please check spelling and/or refer to the API docs for correct name"),
    API_ENDPOINT_IS_INVALID(HttpStatus.NOT_FOUND, 1106, "API endpoint is invalid"),
    DATA_ENTRY_DUPLICATED_WITH_EXISTING(HttpStatus.BAD_REQUEST, 1111, "Data entry duplicated with existing"),
    INVALID_ACCOUNT_NUMBER_INQUIRY(HttpStatus.BAD_REQUEST, 1112, "Invalid Account Number"),
    INVALID_ACCOUNT_STATUS(HttpStatus.BAD_REQUEST, 1113, "Invalid Account Status"),
    INVALID_ACCOUNT_TYPE(HttpStatus.BAD_REQUEST, 1114, "Invalid Account Type"),
    UNABLE_TO_UPDATE_PROCESSED_LOAD_APPLICATION(HttpStatus.BAD_REQUEST, 2101, "Unable to update processed loan application"),
    PENDING_APPLICATION_EXISTED(HttpStatus.BAD_REQUEST, 2102, "Pending Application existed in the system"),
    PREVIOUS_APPLICATION_REJECTED_WITHIN_DESIGNED_PPP(HttpStatus.BAD_REQUEST, 2103, "Previous Application was rejected within designated product policy period"),
    FAILED_ELIGIBILITY_CHECK(HttpStatus.BAD_REQUEST, 2104, "Failed Eligibility Check"),
    NUMBER_OF_DOCUMENTS_EXCEEDS_LIMIT(HttpStatus.BAD_REQUEST, 2201, "Number of documents exceeds limit"),
    INVALID_FILE_TYPE(HttpStatus.BAD_REQUEST, 2202, "Invalid file type"),
    SIZE_OF_DOCUMENT_EXCEEDS_LIMIT(HttpStatus.BAD_REQUEST, 2203, "Size of document exceeds limit"),
    NO_PASSWORD_PROVIDED(HttpStatus.BAD_REQUEST, 2204, "No password provided"),
    INCORRECT_PASSWORD(HttpStatus.BAD_REQUEST, 2205, "Incorrect password"),
    DUPLICATED_IDENTIFICATION(HttpStatus.CONFLICT, 3000, "Identification have duplicated with other customer"),
    DUPLICATED_CONTACT(HttpStatus.CONFLICT, 3001, "Contact have duplicated primary with other customer"),
    INACTIVE_CONTACT(HttpStatus.CONFLICT, 4005, "Inactive contact"),
    INCORRECT_CONTACT_TYPE(HttpStatus.CONFLICT, 4006, "Incorrect contact type"),
    INVALID_CVP_OPTION(HttpStatus.CONFLICT, 4007, "Invalid CVP option"),
    CURRENT_CHANNEL_IS_NOT_SUPPORTED(HttpStatus.NOT_IMPLEMENTED, 4101, "Current channel is not supported"),
    INVALID_RESPONSE_FROM_DOWNSTREAM_SERVICE_400(HttpStatus.BAD_REQUEST, 8101, "Invalid response from downstream service"),
    INVALID_RESPONSE_FROM_DOWNSTREAM_SERVICE_500(HttpStatus.INTERNAL_SERVER_ERROR, 8101, "Invalid response from downstream service"),
    PAYMENT_API_ERROR_CODE(HttpStatus.BAD_REQUEST, 8102, "Payment API error code"),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 8901, "Database error"),
    ERROR_GETTING_MYSQL_POOL_CONNECTION(HttpStatus.INTERNAL_SERVER_ERROR, 8902, "Error getting mysql_pool connection"),
    REQUIRED_STANDARD_HEADERS_NOT_FOUND(HttpStatus.BAD_REQUEST, 9100, "Required standard headers (FIELD_NAME) not found"),
    MISSING_REQUIRED_AUTHORIZATION_CREDENTIALS(HttpStatus.UNAUTHORIZED, 9100, "Missing required authorization credentials"),
    AUTHORIZATION_CREDENTIALS_REQUIRED(HttpStatus.UNAUTHORIZED, 9100, "Authorization credentials required"),
    INVALID_EXPIRED_TEMPORARY_TOKEN(HttpStatus.UNAUTHORIZED, 9300, "Invalid/expired temporary token"),
    INVALID_APIKEY_PROVIDED(HttpStatus.UNAUTHORIZED, 9500, "Invalid apikey provided"),
    INVALID_AUTHORIZATION_CREDENTIALS(HttpStatus.UNAUTHORIZED, 9500, "Invalid authorization credentials"),
    INVALID_ACCESS_RIGHTS(HttpStatus.FORBIDDEN, 9503, "Invalid access rights"),
    GENERIC_SERVER_SIDE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 9700, "Generic server side error"),
    WRONG_HTTP_METHOD_REQUESTED_ON_ENDPOINT(HttpStatus.METHOD_NOT_ALLOWED, 9900, "Wrong http method requested on endpoint"),
    UNSUPPORTED_CONTENT_TYPE_DEFINED(HttpStatus.UNSUPPORTED_MEDIA_TYPE, 9900, "Unsupported content type defined"),
    THREAT_HAS_BEEN_DETECTED(HttpStatus.INTERNAL_SERVER_ERROR, 9900, "Threat has been detected"),
    INVALID_RESPONSE_FROM_UPSTREAM_SERVER(HttpStatus.BAD_GATEWAY, 9900, "Invalid response from upstream server"),
    SERVER_IS_CURRENTLY_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, 9900, "Server is currently unavailable because traffic overload or it is down for maintenance"),
    SYSTEM_MAINTENANCE_IN_PROGRESS(HttpStatus.SERVICE_UNAVAILABLE, 9900, "System maintenance in progress. We will be back shortly."),
    API_REQUEST_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT, 9900, "API Request Timeout"),
    COMMON_VALIDATION_ERROR(HttpStatus.OK, 2000, "Common Validation Error"),
    INVALID_REQUEST(HttpStatus.OK, 2001, "Invalid request"),
    INVALID_QUERY_KEY(HttpStatus.OK, 2002, "Data Not Found, request value for inquiry must be valid in mobius"),
    IDENTIFICATION_NUMBER_DUPLICATE(HttpStatus.OK, 3000, "Identification Number duplicate"),
    PRIMARY_CONTACT_DUPLICATE(HttpStatus.OK, 3001, "Primary contact duplicate");

    private static final String ERROR_NO_MATCHING_BUSINESS_CODE_FORMAT = "No matching constant for [%s]";
    private static final String JSON_KEY_BUSINESS_CODE = "code";
    private static final String JSON_KEY_DESCRIPTION = "description";
    private final HttpStatus httpStatusCode;
    private final int businessCode;
    private final String description;
    private Map<String, Object> jsonMap;

    private OpenApiResponseCode(HttpStatus httpStatusCode, int businessCode, String description) {
        this.httpStatusCode = httpStatusCode;
        this.businessCode = businessCode;
        this.description = description;
        this.jsonMap = null;
    }

    public static OpenApiResponseCode[] valueOf(int businessCode) {
        OpenApiResponseCode[] values = (OpenApiResponseCode[]) Arrays.stream(values()).filter((openApiResponseCode) -> {
            return openApiResponseCode.value() == businessCode;
        }).toArray((x$0) -> {
            return new OpenApiResponseCode[x$0];
        });
        if (values.length == 0) {
            throw new IllegalArgumentException(String.format("No matching constant for [%s]", businessCode));
        } else {
            return values;
        }
    }

    public boolean isError() {
        return this.httpStatusCode.isError();
    }

    public int value() {
        return this.businessCode;
    }

    public HttpStatus getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, Object> toJsonMap() {
        if (this.jsonMap == null) {
            this.jsonMap = new HashMap();
            this.jsonMap.put("code", this.businessCode);
            this.jsonMap.put("description", this.description);
        }

        return this.jsonMap;
    }

    public String toString() {
        String var10000 = this.name();
        return "OpenApiResponseCode." + var10000 + "(httpStatusCode=" + this.getHttpStatusCode() + ", businessCode=" + this.businessCode + ", description=" + this.getDescription() + ", jsonMap=" + this.jsonMap + ")";
    }
}