package com.losserbar.backend.model.response;



import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenApiResponseStatus implements Serializable {
    private int code;
    private String header;
    private String message;
    private String description;

    public static OpenApiResponseStatus getInstance(OpenApiResponseCode openApiResponseCode) {
        return (new OpenApiResponseStatus()).setCode(openApiResponseCode.value()).setDescription(openApiResponseCode.getDescription());
    }

    public OpenApiResponseStatus() {
    }

    public int getCode() {
        return this.code;
    }

    public String getHeader() {
        return this.header;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDescription() {
        return this.description;
    }

    public OpenApiResponseStatus setCode(final int code) {
        this.code = code;
        return this;
    }

    public OpenApiResponseStatus setHeader(final String header) {
        this.header = header;
        return this;
    }

    public OpenApiResponseStatus setMessage(final String message) {
        this.message = message;
        return this;
    }

    public OpenApiResponseStatus setDescription(final String description) {
        this.description = description;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OpenApiResponseStatus)) {
            return false;
        } else {
            OpenApiResponseStatus other = (OpenApiResponseStatus)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label49: {
                    Object this$header = this.getHeader();
                    Object other$header = other.getHeader();
                    if (this$header == null) {
                        if (other$header == null) {
                            break label49;
                        }
                    } else if (this$header.equals(other$header)) {
                        break label49;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OpenApiResponseStatus;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getCode();
        Object $header = this.getHeader();
        result = result * 59 + ($header == null ? 43 : $header.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        int var10000 = this.getCode();
        return "OpenApiResponseStatus(code=" + var10000 + ", header=" + this.getHeader() + ", message=" + this.getMessage() + ", description=" + this.getDescription() + ")";
    }
}
