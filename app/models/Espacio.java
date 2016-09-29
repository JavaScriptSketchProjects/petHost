package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
/**
 * Created by USUARIO on 28/09/2016.
 */

@Entity
@Table(name="espacioEntity")
public class Espacio extends Model {
    public static Model.Finder<Long, Espacio> FINDER = new Finder<>(Espacio.class);
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Espacio")
    private Long id;
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    @JsonBackReference
    private Host host;

    @OneToMany(mappedBy = "espacio")
    private List<Reserva > reservas;

    private int capacidad;
    private double precio;
    private Calendar calendario;

    public Espacio()
    {
        this.id=null;
        this.name ="NO NAME";
        capacidad=0;
        precio=0.0;
        calendario=null;
    }
    public Espacio(Long id) {
        this();
        this.id = id;
    }

    public Espacio(String name, Integer capacidad, Double precio, Calendar calendario)
    {
        this();
        this.name = name;
        this.capacidad=capacidad;
        this.precio = precio;
        this.calendario=calendario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva nuevo){ reservas.add(nuevo);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }
    @Override
    public String toString() {
        return "Espacio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacidad=" + capacidad + '\'' +
                ", precio=" + precio + '\'' +
                ", cant Reservas=" + reservas.size() + '\'' +
                '}';
    }
}
