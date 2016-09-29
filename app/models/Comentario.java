package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="comentarioEntity")
public class Comentario extends Model{
    public static Finder<Long, Comentario> FINDER = new Finder<>(Comentario.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Comentario")
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Calificacion calificacion;


    public Comentario()
    {
        this.id=null;
    }
}
