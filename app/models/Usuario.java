package models;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by USUARIO on 28/09/2016.
 */
@Entity
@Table(name="usuarioEntity")
public class Usuario extends Model {

    public static Finder<Long, Usuario> FINDER = new Finder<>(Usuario.class);

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Usuario")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva > reservas;

    @OneToOne(mappedBy = "usuario")
    private Lugar lugar;

    private String email;
    private String nickName;
    private String password;
    private Long numContacto;

    public Usuario()
    {
        this.id=null;
        this.name ="NO NAME";
        this.email = "NO MAIL";
        this.nickName = "NO NICKNAME";
        this.password = "1234";
        this.numContacto = 0L;
        this.reservas = new ArrayList<Reserva>();

    }
    public Usuario(Long id) {
        this();
        this.id = id;
    }

    public Usuario(String name,String email,String nickName, String password,Long numContacto)
    {
        this();
        this.name = name;
        this.email=email;
        this.nickName=nickName;
        this.password=password;
        this.numContacto=numContacto;
        this.reservas = new ArrayList<Reserva>();

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
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email + '\'' +
                ", nickName=" + nickName + '\'' +
                ", numContacto=" + numContacto + '\'' +
                ", cantidad reservas=" + reservas.size() + '\'' +
                '}';
    }

    public static Usuario bind(JsonNode j) {
        String nombre = j.findPath("name").asText();
        String email = j.findPath("email").asText();
        String password = j.findPath("password").asText();
        String nickname = j.findPath("nickname").asText();
        Long numero = j.findPath("numero").asLong();
        Usuario cali = new Usuario(nombre, email, password, nickname, numero);
        return cali;
    }

    public void update(Usuario nuevaCali) {
        this.setNumContacto(nuevaCali.getNumContacto());
    }
}
