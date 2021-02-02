
package com.sid.eau_electricite.web;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour contratType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="contratType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EAU"/>
 *     &lt;enumeration value="ELECTRICITE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "contratType")
@XmlEnum
public enum ContratType {

    EAU,
    ELECTRICITE;

    public String value() {
        return name();
    }

    public static ContratType fromValue(String v) {
        return valueOf(v);
    }

}
