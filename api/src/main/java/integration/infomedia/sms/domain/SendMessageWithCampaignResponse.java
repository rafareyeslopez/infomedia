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
 *         &lt;element name="SendMessageWithCampaignResult" type="{http://tempuri.org/}SendResult"/&gt;
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
    "sendMessageWithCampaignResult"
})
@XmlRootElement(name = "SendMessageWithCampaignResponse")
public class SendMessageWithCampaignResponse {

    @XmlElement(name = "SendMessageWithCampaignResult", required = true)
    protected SendResult sendMessageWithCampaignResult;

    /**
     * Obtiene el valor de la propiedad sendMessageWithCampaignResult.
     * 
     * @return
     *     possible object is
     *     {@link SendResult }
     *     
     */
    public SendResult getSendMessageWithCampaignResult() {
        return sendMessageWithCampaignResult;
    }

    /**
     * Define el valor de la propiedad sendMessageWithCampaignResult.
     * 
     * @param value
     *     allowed object is
     *     {@link SendResult }
     *     
     */
    public void setSendMessageWithCampaignResult(SendResult value) {
        this.sendMessageWithCampaignResult = value;
    }

}
