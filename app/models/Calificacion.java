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
    private int numero;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Host host;

    @OneToMany(mappedBy = "calificacion")
    private List<Comentario > comentarios;

    public Calificacion()
    {
        this.id=null;
        this.name ="NO NAME";
        this.numero = 0;
    }
    public Calificacion(Long id) {
        this();
        this.id = id;
    }

    public Calificacion(Long id, String name, Integer numero)
    {
        this();
        this.id = id;
        this.name = name;
        this.numero=numero;
    }
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void addComentario(Comentario nuevo){ comentarios.add(nuevo);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Calificacion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numero=" + numero + '\'' +
                ", cantidad comentarios=" + comentarios.size() + '\'' +
                '}';
    }

}
