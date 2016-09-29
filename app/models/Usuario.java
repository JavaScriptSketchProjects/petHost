package models;
import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;
/**
 * Created by USUARIO on 28/09/2016.
 */
@Entity
@Table(name="usuarioEntity")
public class Usuario extends Model {
    public static Finder<Long, Usuario> FINDER = new Finder<>(Usuario.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Usuario")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva > reservas;

    @OneToOne(mappedBy = "usuario")
    private Lugar lugar;

    public Usuario()
    {
        this.id=null;
        this.name ="NO NAME";
    }
}
