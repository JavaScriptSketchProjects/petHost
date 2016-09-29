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

    private double latitud;
    private double longitud;

    public Lugar()
    {
        this.id=null;
        this.name ="NO NAME";
        latitud=0.0;
        longitud=0.0;
    }
    public Lugar(Long id) {
        this();
        this.id = id;
    }

    public Lugar(Long id, String name, Double latitud, Double longitud)
    {
        this();
        this.id = id;
        this.name = name;
        this.latitud=latitud;
        this.longitud = longitud;
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
    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    @Override
    public String toString() {
        return "Lugar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitud=" + latitud + '\'' +
                ", longitud=" + longitud + '\'' +
                '}';
    }
}
