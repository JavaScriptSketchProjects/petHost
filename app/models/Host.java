package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
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

    private String email;
    private String nickName;
    private String password;
    private Long numContacto;


    public Host()
    {
        this.id=null;
        this.name ="NO NAME";
        this.email = "NO MAIL";
        this.nickName = "NO NICKNAME";
        this.password = "1234";
        this.numContacto = 0L;
        this.calificaciones = new ArrayList<Calificacion>();
        this.espacios = new ArrayList<Espacio>();
    }
    public Host(Long id) {
        this();
        this.id = id;
    }

    public Host(Long id, String name,String email,String nickName, String password,Long numContacto)
    {
        this();
        this.id = id;
        this.name = name;
        this.email=email;
        this.nickName=nickName;
        this.password=password;
        this.numContacto=numContacto;

    }
    public List<Espacio> getEspacios() {
        return espacios;
    }

    public void setEspacios(List<Espacio> espacios) {
        this.espacios = espacios;
    }

    public void addEspacio(Espacio nuevo){ espacios.add(nuevo);}

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void addCalificacion(Calificacion nuevo){ calificaciones.add(nuevo);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(Long numContacto) {
        this.numContacto = numContacto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Host{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email + '\'' +
                ", nickName=" + nickName + '\'' +
                ", numContacto=" + numContacto + '\'' +
                ", cantidad espacios=" + espacios.size() + '\'' +
                ", cantidad calificaciones=" + calificaciones.size() + '\'' +
                '}';
    }
}
