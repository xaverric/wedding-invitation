package info.katadan.wedding.entity;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity(name = "guest")
@Data
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String code;

    @Column(name = "participation_confirmed")
    private Boolean participationConfirmed;

}
