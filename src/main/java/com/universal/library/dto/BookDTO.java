package com.universal.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private int volume;
    private String location_library;
    private String description;
    private String image;
}
