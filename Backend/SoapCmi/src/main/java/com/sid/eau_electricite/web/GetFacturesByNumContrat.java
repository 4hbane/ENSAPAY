
package com.sid.eau_electricite.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour getFacturesByNumContrat complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="getFacturesByNumContrat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numContrat" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFacturesByNumContrat", propOrder = {
    "numContrat"
})
public class GetFacturesByNumContrat {

    protected Long numContrat;

    /**
     * Obtient la valeur de la propriété numContrat.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumContrat() {
        return numContrat;
    }

    /**
     * Définit la valeur de la propriété numContrat.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumContrat(Long value) {
        this.numContrat = value;
    }

}
