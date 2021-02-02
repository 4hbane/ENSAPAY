
package com.sid.eau_electricite.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sid.eau_electricite.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FactureEE_QNAME = new QName("http://web.eau_electricite.sid.com/", "factureEE");
    private final static QName _GetFactureResponse_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFactureResponse");
    private final static QName _GetFactures_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFactures");
    private final static QName _GetFacturesImpayesResponse_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFacturesImpayesResponse");
    private final static QName _GetFacture_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFacture");
    private final static QName _GetFacturesByNumContratResponse_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFacturesByNumContratResponse");
    private final static QName _GetFacturesResponse_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFacturesResponse");
    private final static QName _GetFacturesByNumContrat_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFacturesByNumContrat");
    private final static QName _PayerFactureResponse_QNAME = new QName("http://web.eau_electricite.sid.com/", "payerFactureResponse");
    private final static QName _GetFacturesImpayes_QNAME = new QName("http://web.eau_electricite.sid.com/", "getFacturesImpayes");
    private final static QName _PayerFacture_QNAME = new QName("http://web.eau_electricite.sid.com/", "payerFacture");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sid.eau_electricite.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFacturesByNumContrat }
     * 
     */
    public GetFacturesByNumContrat createGetFacturesByNumContrat() {
        return new GetFacturesByNumContrat();
    }

    /**
     * Create an instance of {@link PayerFactureResponse }
     * 
     */
    public PayerFactureResponse createPayerFactureResponse() {
        return new PayerFactureResponse();
    }

    /**
     * Create an instance of {@link GetFacturesByNumContratResponse }
     * 
     */
    public GetFacturesByNumContratResponse createGetFacturesByNumContratResponse() {
        return new GetFacturesByNumContratResponse();
    }

    /**
     * Create an instance of {@link GetFacturesResponse }
     * 
     */
    public GetFacturesResponse createGetFacturesResponse() {
        return new GetFacturesResponse();
    }

    /**
     * Create an instance of {@link GetFacturesImpayes }
     * 
     */
    public GetFacturesImpayes createGetFacturesImpayes() {
        return new GetFacturesImpayes();
    }

    /**
     * Create an instance of {@link PayerFacture }
     * 
     */
    public PayerFacture createPayerFacture() {
        return new PayerFacture();
    }

    /**
     * Create an instance of {@link GetFacturesImpayesResponse }
     * 
     */
    public GetFacturesImpayesResponse createGetFacturesImpayesResponse() {
        return new GetFacturesImpayesResponse();
    }

    /**
     * Create an instance of {@link GetFactureResponse }
     * 
     */
    public GetFactureResponse createGetFactureResponse() {
        return new GetFactureResponse();
    }

    /**
     * Create an instance of {@link GetFactures }
     * 
     */
    public GetFactures createGetFactures() {
        return new GetFactures();
    }

    /**
     * Create an instance of {@link FactureEE }
     * 
     */
    public FactureEE createFactureEE() {
        return new FactureEE();
    }

    /**
     * Create an instance of {@link GetFacture }
     * 
     */
    public GetFacture createGetFacture() {
        return new GetFacture();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FactureEE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "factureEE")
    public JAXBElement<FactureEE> createFactureEE(FactureEE value) {
        return new JAXBElement<FactureEE>(_FactureEE_QNAME, FactureEE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFactureResponse")
    public JAXBElement<GetFactureResponse> createGetFactureResponse(GetFactureResponse value) {
        return new JAXBElement<GetFactureResponse>(_GetFactureResponse_QNAME, GetFactureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactures }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFactures")
    public JAXBElement<GetFactures> createGetFactures(GetFactures value) {
        return new JAXBElement<GetFactures>(_GetFactures_QNAME, GetFactures.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturesImpayesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFacturesImpayesResponse")
    public JAXBElement<GetFacturesImpayesResponse> createGetFacturesImpayesResponse(GetFacturesImpayesResponse value) {
        return new JAXBElement<GetFacturesImpayesResponse>(_GetFacturesImpayesResponse_QNAME, GetFacturesImpayesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFacture")
    public JAXBElement<GetFacture> createGetFacture(GetFacture value) {
        return new JAXBElement<GetFacture>(_GetFacture_QNAME, GetFacture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturesByNumContratResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFacturesByNumContratResponse")
    public JAXBElement<GetFacturesByNumContratResponse> createGetFacturesByNumContratResponse(GetFacturesByNumContratResponse value) {
        return new JAXBElement<GetFacturesByNumContratResponse>(_GetFacturesByNumContratResponse_QNAME, GetFacturesByNumContratResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFacturesResponse")
    public JAXBElement<GetFacturesResponse> createGetFacturesResponse(GetFacturesResponse value) {
        return new JAXBElement<GetFacturesResponse>(_GetFacturesResponse_QNAME, GetFacturesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturesByNumContrat }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFacturesByNumContrat")
    public JAXBElement<GetFacturesByNumContrat> createGetFacturesByNumContrat(GetFacturesByNumContrat value) {
        return new JAXBElement<GetFacturesByNumContrat>(_GetFacturesByNumContrat_QNAME, GetFacturesByNumContrat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayerFactureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "payerFactureResponse")
    public JAXBElement<PayerFactureResponse> createPayerFactureResponse(PayerFactureResponse value) {
        return new JAXBElement<PayerFactureResponse>(_PayerFactureResponse_QNAME, PayerFactureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFacturesImpayes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "getFacturesImpayes")
    public JAXBElement<GetFacturesImpayes> createGetFacturesImpayes(GetFacturesImpayes value) {
        return new JAXBElement<GetFacturesImpayes>(_GetFacturesImpayes_QNAME, GetFacturesImpayes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayerFacture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.eau_electricite.sid.com/", name = "payerFacture")
    public JAXBElement<PayerFacture> createPayerFacture(PayerFacture value) {
        return new JAXBElement<PayerFacture>(_PayerFacture_QNAME, PayerFacture.class, null, value);
    }

}
