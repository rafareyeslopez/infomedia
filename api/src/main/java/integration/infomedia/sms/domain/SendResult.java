//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.22 a las 03:43:00 PM CEST 
//


package integration.infomedia.sms.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SendResult complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SendResult"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsError" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="DetailsOfError" type="{http://tempuri.org/}ErrorDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendResult", propOrder = {
    "status",
    "isError",
    "detailsOfError"
})
public class SendResult {

    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "IsError")
    protected boolean isError;
    @XmlElement(name = "DetailsOfError", required = true)
    protected ErrorDetails detailsOfError;

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad isError.
     * 
     */
    public boolean isIsError() {
        return isError;
    }

    /**
     * Define el valor de la propiedad isError.
     * 
     */
    public void setIsError(boolean value) {
        this.isError = value;
    }

    /**
     * Obtiene el valor de la propiedad detailsOfError.
     * 
     * @return
     *     possible object is
     *     {@link ErrorDetails }
     *     
     */
    public ErrorDetails getDetailsOfError() {
        return detailsOfError;
    }

    /**
     * Define el valor de la propiedad detailsOfError.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorDetails }
     *     
     */
    public void setDetailsOfError(ErrorDetails value) {
        this.detailsOfError = value;
    }

}
