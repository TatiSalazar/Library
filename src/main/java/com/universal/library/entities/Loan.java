package com.universal.library.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue
    private Long id;
    private String document;
    private String isbn;
    private Date create_at;
    private String status;
}
