package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;

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

    private Pais latitud;
    private Ciudad longitud;

    public Lugar()
    {
        this.id=null;
        this.name ="NO NAME";
        latitud=null;
        longitud=null;
    }
    public Lugar(Long id) {
        this();
        this.id = id;
    }

    public Lugar(String name, Pais latitud, Ciudad longitud)
    {
        this();
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
    public Pais getPais() {
        return latitud;
    }

    public void setPais(Pais latitud) {
        this.latitud = latitud;
    }
    public Ciudad getCiudad() {
        return longitud;
    }

    public void setCiudad(Ciudad longitud) {
        this.longitud = longitud;
    }

    public void setHost(Host id) {
        this.host = id;
    }
    public Host getHost(){return host;}
    public void setUsuario(Usuario id) {
        this.usuario = id;
    }
    public Usuario getUsuario(){return usuario;}

    public static Lugar bind(JsonNode j, Calificacion ca) {
        String name = j.findPath("direccion").asText();
        String pais = j.findPath("Pais").asText();
        String ciudad = j.findPath("Ciudad").asText();
        Lugar cali = new Lugar(name, Pais.valueOf(pais), Ciudad.valueOf(ciudad));
        return cali;
    }

    public void update(Lugar nuevoCom) {
        this.setName(nuevoCom.getName());
        this.setCiudad(nuevoCom.getCiudad());
        this.setPais(nuevoCom.getPais());
    }

}
