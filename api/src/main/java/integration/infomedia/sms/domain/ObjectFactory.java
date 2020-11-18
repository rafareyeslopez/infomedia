//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.22 a las 03:43:00 PM CEST 
//


package integration.infomedia.sms.domain;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the integration.infomedia.sms package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: integration.infomedia.sms
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMessage }
     * 
     */
    public SendMessage createSendMessage() {
        return new SendMessage();
    }

    /**
     * Create an instance of {@link ArrayOfMSISDNDetails }
     * 
     */
    public ArrayOfMSISDNDetails createArrayOfMSISDNDetails() {
        return new ArrayOfMSISDNDetails();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link SendResult }
     * 
     */
    public SendResult createSendResult() {
        return new SendResult();
    }

    /**
     * Create an instance of {@link SendMessageWithCampaign }
     * 
     */
    public SendMessageWithCampaign createSendMessageWithCampaign() {
        return new SendMessageWithCampaign();
    }

    /**
     * Create an instance of {@link SendMessageWithCampaignResponse }
     * 
     */
    public SendMessageWithCampaignResponse createSendMessageWithCampaignResponse() {
        return new SendMessageWithCampaignResponse();
    }

    /**
     * Create an instance of {@link MSISDNDetails }
     * 
     */
    public MSISDNDetails createMSISDNDetails() {
        return new MSISDNDetails();
    }

    /**
     * Create an instance of {@link ErrorDetails }
     * 
     */
    public ErrorDetails createErrorDetails() {
        return new ErrorDetails();
    }

}
