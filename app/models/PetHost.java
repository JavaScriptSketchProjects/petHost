package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
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

    private String adminUser;
    private String password;

    public PetHost()
    {
        this.id=null;
        this.name ="NO NAME";
        this.adminUser="NO ADMIN";
        this.password = "1234";
        this.personasHost = new ArrayList<Host>();
        this.personas = new ArrayList<Usuario>();
    }
    public PetHost(Long id) {
        this();
        this.id = id;
    }

    public PetHost(Long id, String name, String adminUser, String password)
    {
        this();
        this.id = id;
        this.name = name;
        this.adminUser=adminUser;
        this.password=password;
    }

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

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Host> getPersonasHost() {
        return personasHost;
    }

    public void setPersonasHost(List<Host> personasHost) {
        this.personasHost = personasHost;
    }

    public void addPersonaHost(Host nuevo){ personasHost.add(nuevo);}

    public List<Usuario> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Usuario> personas) {
        this.personas = personas;
    }

    public void addPersona(Usuario nuevo){ personas.add(nuevo);}

    @Override
    public String toString() {
        return "PetHost{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", admin=" + adminUser + '\'' +
                ", num Personas Host=" + personasHost.size() + '\'' +
                ", num Personas =" + personas.size() + '\'' +
                '}';
    }
}
