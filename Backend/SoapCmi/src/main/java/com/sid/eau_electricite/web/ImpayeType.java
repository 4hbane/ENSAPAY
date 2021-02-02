
package com.sid.eau_electricite.web;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour impayeType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="impayeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ImpayeSimple"/>
 *     &lt;enumeration value="Penalite"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "impayeType")
@XmlEnum
public enum ImpayeType {

    @XmlEnumValue("ImpayeSimple")
    IMPAYE_SIMPLE("ImpayeSimple"),
    @XmlEnumValue("Penalite")
    PENALITE("Penalite");
    private final String value;

    ImpayeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImpayeType fromValue(String v) {
        for (ImpayeType c: ImpayeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
