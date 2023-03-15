package com.universal.library.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LoanResponseDTO  extends LoanDTO{
    private Date create_At;
    private String status;
}
