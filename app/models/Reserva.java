package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public Reserva(String name, Double precio,Integer numMascotas, Date fecha1, Date fecha2)
    {
        this();
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
                ", numMascotas=" + numMascotas+ '\'' +
                ", Estado =" + estado + '\'' +
                '}';
    }


    public static Reserva bind(JsonNode j) {
        String nombre = j.findPath("name").asText();
        Double precio = j.findPath("precio").asDouble();
        int num = j.findPath("numMascotas").asInt();
        String fecha1 = j.findPath("fecha1").asText();
        String fecha2 = j.findPath("fecha2").asText();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date entrada = null;
        Date salida = null;
        try{
            entrada = formatter.parse(fecha1);
            salida = formatter.parse(fecha2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Reserva cali = new Reserva(nombre, precio, num, entrada, salida);
        return cali;
    }

    public void update(Reserva nuevaCali) {
        this.setFecha1(nuevaCali.getFecha1());
        this.setFecha2(nuevaCali.getFecha2());
    }
}
