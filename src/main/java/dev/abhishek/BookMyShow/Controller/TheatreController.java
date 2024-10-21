package dev.abhishek.BookMyShow.Controller;

import dev.abhishek.BookMyShow.DTO.TheatreRequestDTO;
import dev.abhishek.BookMyShow.Models.Theatre;
import dev.abhishek.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {
@Autowired
    private TheatreService theatreService;

@PostMapping("/theatre")
    public ResponseEntity createTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO){
    return  ResponseEntity.ok(
            theatreService.saveTheatre(
                    theatreRequestDTO.getName(),
                    theatreRequestDTO.getAddress(),
                    theatreRequestDTO.getCityId()
            )
    );
}
}
