package info.katadan.wedding.rest;

import info.katadan.wedding.entity.Guest;
import info.katadan.wedding.service.GuestCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class GuestController {

    private final GuestCrudService guestCrudService;

    @Autowired
    public GuestController(GuestCrudService guestCrudService) {
        this.guestCrudService = guestCrudService;
    }

    @GetMapping("/api/all")
    public List<Guest> getAllGuests(){
        return guestCrudService.getAllGuests();
    }

    @GetMapping("/api/registration/{code}")
    public List<Guest> getAllGuestsByCode(@PathVariable String code){
        return guestCrudService.getGuestsByCode(code);
    }

    @PostMapping("/api/registration/{code}")
    public void setParticipation(@PathVariable String code, @RequestParam Boolean participationAccepted){
        List<Guest> guests = guestCrudService.getGuestsByCode(code);
        guestCrudService.setParticipation(guests, participationAccepted);
    }
}
