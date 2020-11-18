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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MD5Hash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SMSMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MSISDNList" type="{http://tempuri.org/}ArrayOfMSISDNDetails" minOccurs="0"/&gt;
 *         &lt;element name="UserMsgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ScheduleFor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "username",
    "md5Hash",
    "smsMessage",
    "msisdnList",
    "userMsgID",
    "userTag",
    "scheduleFor"
})
@XmlRootElement(name = "SendMessage")
public class SendMessage {

    @XmlElement(name = "Username")
    protected String username;
    @XmlElement(name = "MD5Hash")
    protected String md5Hash;
    @XmlElement(name = "SMSMessage")
    protected String smsMessage;
    @XmlElement(name = "MSISDNList")
    protected ArrayOfMSISDNDetails msisdnList;
    @XmlElement(name = "UserMsgID")
    protected String userMsgID;
    @XmlElement(name = "UserTag")
    protected String userTag;
    @XmlElement(name = "ScheduleFor")
    protected String scheduleFor;

    /**
     * Obtiene el valor de la propiedad username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define el valor de la propiedad username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Obtiene el valor de la propiedad md5Hash.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMD5Hash() {
        return md5Hash;
    }

    /**
     * Define el valor de la propiedad md5Hash.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMD5Hash(String value) {
        this.md5Hash = value;
    }

    /**
     * Obtiene el valor de la propiedad smsMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMSMessage() {
        return smsMessage;
    }

    /**
     * Define el valor de la propiedad smsMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMSMessage(String value) {
        this.smsMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad msisdnList.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMSISDNDetails }
     *     
     */
    public ArrayOfMSISDNDetails getMSISDNList() {
        return msisdnList;
    }

    /**
     * Define el valor de la propiedad msisdnList.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMSISDNDetails }
     *     
     */
    public void setMSISDNList(ArrayOfMSISDNDetails value) {
        this.msisdnList = value;
    }

    /**
     * Obtiene el valor de la propiedad userMsgID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMsgID() {
        return userMsgID;
    }

    /**
     * Define el valor de la propiedad userMsgID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMsgID(String value) {
        this.userMsgID = value;
    }

    /**
     * Obtiene el valor de la propiedad userTag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTag() {
        return userTag;
    }

    /**
     * Define el valor de la propiedad userTag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTag(String value) {
        this.userTag = value;
    }

    /**
     * Obtiene el valor de la propiedad scheduleFor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleFor() {
        return scheduleFor;
    }

    /**
     * Define el valor de la propiedad scheduleFor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleFor(String value) {
        this.scheduleFor = value;
    }

}
