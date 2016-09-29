package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="reservaEntity")
public class Reserva extends Model{
    public static Finder<Long, Reserva> FINDER = new Finder<>(Reserva.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Reserva")
    private Long id;
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Espacio espacio;

    public Reserva()
    {
        this.id=null;
        this.name ="NO NAME";
    }
}
