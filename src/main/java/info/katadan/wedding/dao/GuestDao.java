package info.katadan.wedding.dao;

import info.katadan.wedding.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestDao extends JpaRepository<Guest, Long> {

    Optional<List<Guest>> findByCode(@Param("code") String code);
}
