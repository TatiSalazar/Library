package com.universal.library.dto;

import lombok.Data;

@Data
public abstract class LoanDTO {
    protected String document;
    protected String isbn;

}
