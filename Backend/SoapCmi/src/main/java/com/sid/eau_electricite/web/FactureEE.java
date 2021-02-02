
package com.sid.eau_electricite.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour factureEE complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="factureEE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateCreation" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="echeance" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="frais" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="impayeType" type="{http://web.eau_electricite.sid.com/}impayeType" minOccurs="0"/>
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="nomClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numContrat" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="paid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="penalite" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="periode" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="type" type="{http://web.eau_electricite.sid.com/}contratType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "factureEE", propOrder = {
    "adresse",
    "dateCreation",
    "echeance",
    "frais",
    "id",
    "impayeType",
    "montant",
    "nomClient",
    "numContrat",
    "paid",
    "penalite",
    "periode",
    "type"
})
public class FactureEE {

    protected String adresse;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreation;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar echeance;
    protected double frais;
    protected Long id;
    @XmlSchemaType(name = "string")
    protected ImpayeType impayeType;
    protected double montant;
    protected String nomClient;
    protected Long numContrat;
    protected boolean paid;
    protected double penalite;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar periode;
    @XmlSchemaType(name = "string")
    protected ContratType type;

    /**
     * Obtient la valeur de la propri�t� adresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * D�finit la valeur de la propri�t� adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateCreation.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreation() {
        return dateCreation;
    }

    /**
     * D�finit la valeur de la propri�t� dateCreation.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreation(XMLGregorianCalendar value) {
        this.dateCreation = value;
    }

    /**
     * Obtient la valeur de la propri�t� echeance.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEcheance() {
        return echeance;
    }

    /**
     * D�finit la valeur de la propri�t� echeance.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEcheance(XMLGregorianCalendar value) {
        this.echeance = value;
    }

    /**
     * Obtient la valeur de la propri�t� frais.
     * 
     */
    public double getFrais() {
        return frais;
    }

    /**
     * D�finit la valeur de la propri�t� frais.
     * 
     */
    public void setFrais(double value) {
        this.frais = value;
    }

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� impayeType.
     * 
     * @return
     *     possible object is
     *     {@link ImpayeType }
     *     
     */
    public ImpayeType getImpayeType() {
        return impayeType;
    }

    /**
     * D�finit la valeur de la propri�t� impayeType.
     * 
     * @param value
     *     allowed object is
     *     {@link ImpayeType }
     *     
     */
    public void setImpayeType(ImpayeType value) {
        this.impayeType = value;
    }

    /**
     * Obtient la valeur de la propri�t� montant.
     * 
     */
    public double getMontant() {
        return montant;
    }

    /**
     * D�finit la valeur de la propri�t� montant.
     * 
     */
    public void setMontant(double value) {
        this.montant = value;
    }

    /**
     * Obtient la valeur de la propri�t� nomClient.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomClient() {
        return nomClient;
    }

    /**
     * D�finit la valeur de la propri�t� nomClient.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomClient(String value) {
        this.nomClient = value;
    }

    /**
     * Obtient la valeur de la propri�t� numContrat.
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
     * D�finit la valeur de la propri�t� numContrat.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumContrat(Long value) {
        this.numContrat = value;
    }

    /**
     * Obtient la valeur de la propri�t� paid.
     * 
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * D�finit la valeur de la propri�t� paid.
     * 
     */
    public void setPaid(boolean value) {
        this.paid = value;
    }

    /**
     * Obtient la valeur de la propri�t� penalite.
     * 
     */
    public double getPenalite() {
        return penalite;
    }

    /**
     * D�finit la valeur de la propri�t� penalite.
     * 
     */
    public void setPenalite(double value) {
        this.penalite = value;
    }

    /**
     * Obtient la valeur de la propri�t� periode.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPeriode() {
        return periode;
    }

    /**
     * D�finit la valeur de la propri�t� periode.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPeriode(XMLGregorianCalendar value) {
        this.periode = value;
    }

    /**
     * Obtient la valeur de la propri�t� type.
     * 
     * @return
     *     possible object is
     *     {@link ContratType }
     *     
     */
    public ContratType getType() {
        return type;
    }

    /**
     * D�finit la valeur de la propri�t� type.
     * 
     * @param value
     *     allowed object is
     *     {@link ContratType }
     *     
     */
    public void setType(ContratType value) {
        this.type = value;
    }

}
