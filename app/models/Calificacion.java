package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;

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

    public Calificacion(String name, Integer numero, Host phost)
    {
        this();
        this.host = phost;
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

    public int getNum() {
        return numero;
    }

    public void setNum(int num) {
        this.numero = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //-----------------------------------------------------------
    // Métodos auxiliares
    //-----------------------------------------------------------


    public static Calificacion bind(JsonNode j, Host host) {
        String nombre = j.findPath("nombre").asText();
        int numero = j.findPath("numero").asInt();
        Calificacion cali = new Calificacion(nombre, numero, host);
        return cali;
    }

    public void update(Calificacion nuevaCali) {
        this.setName(nuevaCali.getName());
        this.setNum(nuevaCali.getNum());
        this.setComentarios(nuevaCali.getComentarios());
    }

}
