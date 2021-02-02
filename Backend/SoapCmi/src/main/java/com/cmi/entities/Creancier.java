package com.cmi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creancier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long codeCreancier;
    @NotNull
    private String nomCreancier;
    @NotNull
    private Categorie categorie;
    @OneToMany(mappedBy = "creancier",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @XmlElementWrapper(name="creanceList")
    @XmlElement(name="creance")
    private Collection<Creance> creanceList;

}
