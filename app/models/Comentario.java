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

    private  String comentario;

    public Comentario()
    {
        this.id=null;
        this.comentario = "NO COMMENT";
    }
    public Comentario(Long id) {
        this();
        this.id = id;
    }

    public Comentario(Long id, String comentario)
    {
        this();
        this.id = id;
        this.comentario=comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
