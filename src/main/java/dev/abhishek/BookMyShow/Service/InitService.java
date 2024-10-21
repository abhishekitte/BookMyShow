package dev.abhishek.BookMyShow.Service;

import dev.abhishek.BookMyShow.Models.*;
import dev.abhishek.BookMyShow.Models.Constant.AuditoriumFeature;
import dev.abhishek.BookMyShow.Models.Constant.SeatStatus;
import dev.abhishek.BookMyShow.Models.Constant.SeatType;
import dev.abhishek.BookMyShow.Models.Constant.ShowSeatStatus;
import dev.abhishek.BookMyShow.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;

    public boolean initialise(){
        City delhi = new City("Delhi");
        City banglore=new City("Banglore");
        City canbeera =new City("Canbeera");

        cityRepository.save(delhi);
        cityRepository.save(banglore);
        cityRepository.save(canbeera);

        City savedDelhi = cityRepository.findCityByName("Delhi");
        Theatre ashishTheatre=new Theatre("AshishMultiplex","CP,Delhi");
        Theatre nitinTheatre=new Theatre("NitinIMAX","Select City,Delhi");

        theatreRepository.save(ashishTheatre);
        theatreRepository.save(nitinTheatre);

        Theatre savedAshishTheatre=theatreRepository.findTheatreByName("AshishMultiplex");
        Theatre savedNitinTheatre=theatreRepository.findTheatreByName("NitinIMAX");

        List<Theatre> delhiTheatres= new ArrayList<>();
        delhiTheatres.add(savedAshishTheatre);
        delhiTheatres.add(savedNitinTheatre);
        savedDelhi.setTheatres(delhiTheatres);
        cityRepository.save(savedDelhi);

        for(int i=1;i<=5;i++){
            Seat s=new Seat(i,i,i+" ", SeatType.GOLD, SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }
        List<Seat> savedSeats=seatRepository.findAll();

        Auditorium auditorium =new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapacity(5);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY,AuditoriumFeature.IMAX));
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);


        Auditorium savedAudi=auditoriumRepository.findAuditoriumByName("Audi01");
        Theatre savedTheatre=theatreRepository.findTheatreByName("AshishMultiplex");
        List<Auditorium> auditoriums=new ArrayList<>();
        auditoriums.add(savedAudi);
        savedTheatre.setAuditoriums(auditoriums);
        theatreRepository.save(savedTheatre);

        Movie movie=new Movie("Titanic","Best movie ever");
        movieRepository.save(movie);


        Show show=new Show();
        show.setStartTime(LocalDateTime.now());
        show.setEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findMovieByName("Titanic"));
        show.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));

        showRepository.save(show);

        for (int i=1;i<=5;i++){
            ShowSeat s= new ShowSeat(1251,showRepository.findById(1).get(),seatRepository.findSeatBySeatNumber(i+" "+i), ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }
        return true;

    }
}
