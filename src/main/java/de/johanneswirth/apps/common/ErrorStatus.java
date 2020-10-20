package de.johanneswirth.apps.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonSerialize(using=ErrorSerializer.class)
public enum ErrorStatus implements IStatus {
    AUTHENTICATION_ERROR("AUTHENTICATION_ERROR", false),
    UNAUTHORIZED("UNAUTHORIZED", false),
    TOKEN_EXPIRED("TOKEN_EXPIRED", false),
    USER_EXISTS("USER_EXISTS"),
    NO_ACCESS("STATUS_NO_ACCESS"),
    ILLEGAL_PARAMETERS("STATUS_ILLEGAL_PARAMETERS"),
    UNKOWN_GAME("UNKOWN_GAME"),
    MOVE_NOT_ALLOWED("MOVE_NOT_ALLOWED"),
    INCORRECT_INVITATION("INCORRECT_INVITATION");

    @NotEmpty
    private String errorMessage;

    @NotNull
    private boolean critical;

    ErrorStatus(String errorMessage, boolean critical) {
        this.errorMessage = errorMessage;
        this.critical = critical;
    }

    ErrorStatus(String errorMessage) {
        this.errorMessage = errorMessage;
        this.critical = true;
    }

    @Override
    @JsonProperty("error")
    public boolean isError() {
        return true;
    }

    @JsonProperty("critical")
    public boolean isCritical() {
        return critical;
    }

    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }
}
