package dev.abhishek.BookMyShow.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreRequestDTO {
    private String name;
    private String address;
    private int cityId;
}