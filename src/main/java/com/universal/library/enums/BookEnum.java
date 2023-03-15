package com.universal.library.enums;

public enum BookEnum {
    AVAILABLE("Available"),
    UNAVAILABLE("Unavailable"),
    ON_LOAN("On_loan");
    private String status;
    private BookEnum(String status) {
        this.status = status;
    }
    public static BookEnum getStatus(String status){
        switch (status){
            case "Available":
                return BookEnum.AVAILABLE;
            case "Unavailable":
                return BookEnum.UNAVAILABLE;
            case "On_loan":
                return BookEnum.ON_LOAN;

            default:

        }

        return null;
    }
}
