package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="reservaEntity")
public class Reserva extends Model{
    public static Finder<Long, Reserva> FINDER = new Finder<>(Reserva.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Reserva")
    private Long id;
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Espacio espacio;

    private double precio;
    private int numMascotas;
    private Date fecha1;
    private Date fecha2;
    //no estoy muy seguro del estado
    private String estado ;

    public Reserva()
    {
        this.id=null;
        this.name ="NO NAME";
        this.precio=0.0;
        this.numMascotas=0;
        this.estado="NO STATE";
        this.fecha1=null;
        this.fecha2=null;

    }
    public Reserva(Long id) {
        this();
        this.id = id;
    }

    public Reserva(Long id, String name, Double precio,Integer numMascotas, Date fecha1, Date fecha2)
    {
        this();
        this.id = id;
        this.name = name;
        this.precio=precio;
        this.numMascotas=numMascotas;
        this.fecha1=fecha1;
        this.fecha2=fecha2;

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
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Integer getNumMascotas() {
        return numMascotas;
    }

    public void setNumMascotas(int numMascotas) {
        this.numMascotas = numMascotas;
    }
    public Date getFecha1() {
        return fecha1;
    }
    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }
    public Date getFecha2() {
        return fecha2;
    }
    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", precio=" + precio + '\'' +
                ", num mascotas=" + numMascotas+ '\'' +
                ", Estado =" + estado + '\'' +
                '}';
    }
}
