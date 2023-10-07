package com.losserbar.backend.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenApiResponse implements Serializable {
    private static final String ERROR_CODE_NOT_ERROR_PATTERN = "The errorCode: %s is not error code";
    private OpenApiResponseStatus status;
    private transient Object data;

    public static OpenApiResponse generateErrorResponse(final OpenApiResponseCode errorCode) {
        if (!errorCode.getHttpStatusCode().isError()) {
            throw new IllegalArgumentException(String.format("The errorCode: %s is not error code", errorCode));
        } else {
            return (new OpenApiResponse()).setStatus(OpenApiResponseStatus.getInstance(errorCode)).setData((Object)null);
        }
    }

    public static OpenApiResponse generateErrorResponseWithData(final OpenApiResponseCode errorCode, Object data) {
        if (!errorCode.getHttpStatusCode().isError()) {
            throw new IllegalArgumentException(String.format("The errorCode: %s is not error code", errorCode));
        } else {
            return (new OpenApiResponse()).setStatus(OpenApiResponseStatus.getInstance(errorCode)).setData(data);
        }
    }

    public static OpenApiResponse generateResponse(final OpenApiResponseCode code, String message) {
        return (new OpenApiResponse()).setStatus(OpenApiResponseStatus.getInstance(code).setMessage(message)).setData((Object)null);
    }

    public static OpenApiResponse generateCustomResponse(Integer code, String description, String message) {
        return (new OpenApiResponse()).setStatus((new OpenApiResponseStatus()).setCode(code).setDescription(description).setMessage(message)).setData((Object)null);
    }

    public OpenApiResponse() {
    }

    public OpenApiResponseStatus getStatus() {
        return this.status;
    }

    public Object getData() {
        return this.data;
    }

    public OpenApiResponse setStatus(final OpenApiResponseStatus status) {
        this.status = status;
        return this;
    }

    public OpenApiResponse setData(final Object data) {
        this.data = data;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OpenApiResponse)) {
            return false;
        } else {
            OpenApiResponse other = (OpenApiResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OpenApiResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        OpenApiResponseStatus var10000 = this.getStatus();
        return "OpenApiResponse(status=" + var10000 + ", data=" + this.getData() + ")";
    }
}

