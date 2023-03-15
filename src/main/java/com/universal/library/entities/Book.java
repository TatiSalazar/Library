package com.universal.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    private String isbn;
    private String title;
    private String author;
    private int volume;
    private String location_library;
    private String description;
    private String image;
    private String available;
}
