package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="hostEntity")
public class Host extends Model {
    public static Model.Finder<Long, Host> FINDER = new Finder<>(Host.class);

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Host")
    private Long id;
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private PetHost pethost;

    @OneToMany(mappedBy = "host")
    private List<Calificacion > calificaciones;

    @OneToMany(mappedBy = "host")
    private List<Espacio > espacios;

    @OneToOne(mappedBy = "host")
    private Lugar lugar;
    public Host()
    {
        this.id=null;
        this.name ="NO NAME";
    }
}
