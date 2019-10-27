package info.katadan.wedding.service;

import info.katadan.wedding.dao.GuestDao;
import info.katadan.wedding.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class GuestCrudServiceImpl implements GuestCrudService {

    private GuestDao guestDao;

    @Autowired
    public GuestCrudServiceImpl(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Override
    public List<Guest> getGuestsByCode(String code) {
        Optional<List<Guest>> guestsOpt = guestDao.findByCode(code);
        if (guestsOpt.isPresent()){
            return guestsOpt.get();
        }
        throw new EntityNotFoundException("No guest was found by given code");
    }

    @Override
    public void setParticipation(List<Guest> guests, Boolean participation) {
        for (Guest guest: guests) {
            guest.setParticipationConfirmed(participation);
            guestDao.saveAndFlush(guest);
        }
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestDao.findAll();
    }
}
