package dev.abhishek.BookMyShow.Controller;

import dev.abhishek.BookMyShow.DTO.CityRequestDTO;
import dev.abhishek.BookMyShow.Models.City;
import dev.abhishek.BookMyShow.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;
    private CityRequestDTO cityRequestDTO;

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName){
        City savedCity= cityService.getCityByName(cityName);
        return ResponseEntity.ok(savedCity);
    }
    @GetMapping("/city")
    public ResponseEntity getAllCities(){
        List<City> cities=cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }
    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){
        this.cityRequestDTO = cityRequestDTO;
        try{
            String cityName=cityRequestDTO.getName();
            if(cityName==null || cityName.isEmpty() || cityName.isBlank()){
                throw new Exception("City Name is invalid");
            }
            City savedCity= cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId){
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }

}
