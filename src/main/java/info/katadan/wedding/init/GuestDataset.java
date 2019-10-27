package info.katadan.wedding.init;

import info.katadan.wedding.dao.GuestDao;
import info.katadan.wedding.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestDataset implements DataSet{

    private GuestDao guestDao;

    @Autowired
    public GuestDataset(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Override
    public void load(){
        createGuest("Luboš", "Jílek", "ekazavo");
        createGuest("Celina ", "Jílková", "ekazavo");
        createGuest("Tomáš", "Jílek", "ekazavo");
        createGuest("Milada", "Jílková", "cekuveb");
        createGuest("Jana ", "Bláhová", "cekuveb");
        createGuest("Josef ", "Jílek", "cekuveb");
        createGuest("Wiesiek", "Majewski", "imukigu");
        createGuest("Agnieszka", "Majewska", "imukigu");
        createGuest("Maja", "Majewska", "imukigu");
        createGuest("Kuba", "Majewski", "imukigu");
        createGuest("Iwona", "Nytko", "pexezab");
        createGuest("David ", "Nytko", "pexezab");
        createGuest("Bartek", "Nytko", "pexezab");
        createGuest("Adriana", "Nytko", "pexezab");
        createGuest("Halina", "Bednarz", "ufuquza");
        createGuest("Zbysiek", "Bednarz", "ufuquza");
        createGuest("Mateusz", "Bednarz", "daxumus");
        createGuest("Kamil", "Bednarz", "equyeve");
        createGuest("Sabina", "Majewska", "suyepuv");
        createGuest("Stasziek", "Majeswki", "aqifayo");
        createGuest("Zoska", "Majeska", "aqifayo");
        createGuest("Konrad ", "Majewski", "benehin");
        createGuest("Mariusz", "Majewski", "adaraka");
        createGuest("Marzena", "Majewska", "adaraka");
        createGuest("Krzysiek", "Majewski", "cewefit");
        createGuest("Pavel ", "Šulák", "orudevo");
        createGuest("Tereza", " Šuláková", "orudevo");
        createGuest("Vojtěch", "Boukal", "ruqicoy");
        createGuest("Alena", "Boukalová", "ruqicoy");
        createGuest("Jitka", "Kuličková", "asitebe");
        createGuest("Petr ", "Kulička", "asitebe");
        createGuest("Petra ", "Kuličková", "sigejan");
        createGuest("Libuše", "Kuličková", "ohoxese");
        createGuest("Miloslava ", "Hamplová", "pipemiv");
        createGuest("Miroslav ", "Hampl", "pipemiv");
        createGuest("Miroslava ", "Nerudová", "idageku");
        createGuest("Michal", "Neruda", "idageku");
        createGuest("Michaela", "Nerudová", "vejoyej");
        createGuest("Monika", "Nerudová", "iqeyaxa");
        createGuest("Kateřina", "Trávničková", "qapazoy");
        createGuest("Šimon", "Branda", "qapazoy");
        createGuest("Nikola", "Seifreidová", "uvuvome");
        createGuest("Jan", "Dostál", "uvuvome");
        createGuest("Dagmar", "Weiserová", "bozicuk");
        createGuest("Anastazia ", "Mykolajčuk", "unafopu");
        createGuest("Kuba", "Havránek", "unafopu");
        createGuest("Tereza", "Burešová", "yisokur");
        createGuest("Nikola", "Kopecká", "enesimo");
        createGuest("Veronika", "Lapková", "huquzoh");
    }

    private void createGuest(String name, String surname, String code){
        Guest guest = new Guest();
        guest.setName(name);
        guest.setSurname(surname);
        guest.setCode(code);
        guest.setParticipationConfirmed(false);
        guestDao.save(guest);
    }
}
