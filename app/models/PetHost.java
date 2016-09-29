package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;
/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="pethostEntity")
public class PetHost extends Model {
    public static Finder<Long, PetHost> FINDER = new Finder<>(PetHost.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "PetHost")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "pethost")
    private List<Host > personasHost;

    @OneToMany(mappedBy = "pethost")
    private List<Usuario > personas;

    public PetHost()
    {
        this.id=null;
        this.name ="NO NAME";
    }
}
