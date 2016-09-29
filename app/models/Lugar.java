package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="lugarEntity")
public class Lugar extends Model {
    public static Finder<Long, Lugar> FINDER = new Finder<>(Lugar.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Espacio")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "lugar")
    private Host host;
    @OneToOne(mappedBy = "lugar")
    private Usuario usuario;
    public Lugar()
    {
        this.id=null;
        this.name ="NO NAME";
    }
}
