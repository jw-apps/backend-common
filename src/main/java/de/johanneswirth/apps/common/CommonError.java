package de.johanneswirth.apps.common;

public enum CommonError implements Error {
    AUTHENTICATION_ERROR("AUTHENTICATION_ERROR", false),
    UNAUTHORIZED("UNAUTHORIZED", false),
    TOKEN_EXPIRED("TOKEN_EXPIRED", false),
    NO_ACCESS("STATUS_NO_ACCESS"),
    ILLEGAL_PARAMETERS("STATUS_ILLEGAL_PARAMETERS");

    private String errorMessage;

    private boolean critical;

    CommonError(String errorMessage, boolean critical) {
        this.errorMessage = errorMessage;
        this.critical = critical;
    }

    CommonError(String errorMessage) {
        this.errorMessage = errorMessage;
        this.critical = true;
    }

    @Override
    public String getError() {
        return errorMessage;
    }

    @Override
    public boolean isCritical() {
        return critical;
    }
}
