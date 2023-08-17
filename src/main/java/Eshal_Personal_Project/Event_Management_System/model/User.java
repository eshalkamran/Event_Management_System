package Eshal_Personal_Project.Event_Management_System.model;
import javax.persistence.*;

@Entity //Indicates that a class is a JPA entity, which will be mapped to a database table
@Table(name = "users") //Specifies the table name in the database. name = "users"
public class User {

    @Id //Marks a field as a primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Specifies how primary key values are generated. GenerationType.IDENTITY means the database will generate it (e.g., auto-increment)
    private Long id;

    @Column(nullable = false, unique = true) //Provides column-specific settings. nullable and unique are constraints.
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    //Constructor
    public User(){
    }

    // Getters
    public Long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    //Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }
}