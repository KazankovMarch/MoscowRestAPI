package ru.adkazankov.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@ToString

@Entity
@Table(name = "client")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "login")
    private String login;

//    @JsonIgnore
    @Column(name = "password")
    private String password;


    public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public Client(){

    }
}
