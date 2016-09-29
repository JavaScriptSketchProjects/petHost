package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;
/**
 * Created by USUARIO on 28/09/2016.
 */
@Entity
@Table(name="calificacionEntity")
public class Calificacion extends Model {

    public static Finder<Long, Calificacion> FINDER = new Finder<>(Calificacion.class);

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Calificacion")
    private Long id;
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Host host;

    @OneToMany(mappedBy = "calificacion")
    private List<Comentario > comentarios;

    public Calificacion()
    {
        this.id=null;
        this.name ="NO NAME";
    }

}
