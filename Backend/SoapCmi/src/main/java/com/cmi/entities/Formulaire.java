package com.cmi.entities;

import com.cmi.entities.Creancier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@XmlRootElement
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Formulaire {
    private String nomCreance;
    private String nomCreancier;
    private HashMap<String, String> attributs;

    public Formulaire(String nomCreance, String nomCreancier) {
        this.nomCreance = nomCreance;
        this.nomCreancier=nomCreancier;
    }
}
