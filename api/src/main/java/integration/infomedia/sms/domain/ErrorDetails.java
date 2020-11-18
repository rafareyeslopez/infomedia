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
 * <p>Clase Java para ErrorDetails complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ErrorDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserFriendlyMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SystemMessage" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="StackTrace" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorDetails", propOrder = {
    "userFriendlyMessage",
    "systemMessage",
    "stackTrace"
})
public class ErrorDetails {

    @XmlElement(name = "UserFriendlyMessage")
    protected String userFriendlyMessage;
    @XmlElement(name = "SystemMessage")
    protected Object systemMessage;
    @XmlElement(name = "StackTrace")
    protected Object stackTrace;

    /**
     * Obtiene el valor de la propiedad userFriendlyMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserFriendlyMessage() {
        return userFriendlyMessage;
    }

    /**
     * Define el valor de la propiedad userFriendlyMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserFriendlyMessage(String value) {
        this.userFriendlyMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad systemMessage.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSystemMessage() {
        return systemMessage;
    }

    /**
     * Define el valor de la propiedad systemMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSystemMessage(Object value) {
        this.systemMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad stackTrace.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getStackTrace() {
        return stackTrace;
    }

    /**
     * Define el valor de la propiedad stackTrace.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setStackTrace(Object value) {
        this.stackTrace = value;
    }

}
