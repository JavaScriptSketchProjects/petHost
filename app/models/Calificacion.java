package models;

import javax.persistence.Entity;
import akka.io.TcpConnection;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Table;
/**
 * Created by USUARIO on 28/09/2016.
 */
@Entity
@Table(name="calificacionEntity")
public class Calificacion extends Model {

    public static Finder<Long, Calificacion> FINDER = new Finder<>(Calificacion.class);

    public Calificacion()
    {

    }

}
