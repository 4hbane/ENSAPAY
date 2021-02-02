package com.cmi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Creance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long codeCreance;
    @NotNull
    private String nomCreance;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "creancierId")
    @XmlTransient
    private Creancier creancier;
}
