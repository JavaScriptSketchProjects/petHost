package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="espacioEntity")
public class Espacio extends Model {
    public static Model.Finder<Long, Espacio> FINDER = new Finder<>(Espacio.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Espacio")
    private Long id;
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Host host;

    @OneToMany(mappedBy = "espacio")
    private List<Reserva > reservas;

    public Espacio()
    {
        this.id=null;
        this.name ="NO NAME";
    }
}
