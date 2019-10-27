package info.katadan.wedding.service;

import info.katadan.wedding.entity.Guest;

import java.util.List;

public interface GuestCrudService {

    List<Guest> getGuestsByCode(String code);

    void setParticipation(List<Guest> guests, Boolean participation);

    List<Guest> getAllGuests();
}
