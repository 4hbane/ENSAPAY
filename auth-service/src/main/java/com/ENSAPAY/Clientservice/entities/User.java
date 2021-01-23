package com.ENSAPAY.Clientservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userName; //phoneNumber
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean activated;
    @OneToOne(fetch = FetchType.EAGER)
    private Role role;

    public User( String userName, String password, boolean activated ) {
        this.id = null;
        this.userName = userName;
        this.password = password;
        this.activated = activated;
    }
}
