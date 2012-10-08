//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.02 at 08:14:42 AM PDT 
//


package com.oracle.demo.ops.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetParcelByIdResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetParcelByIdResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseHeader" type="{http://demo.oracle.com/ops/domain/services/common}WebServiceResponseHeaderType"/>
 *         &lt;element name="Parcel" type="{http://demo.oracle.com/ops/domain/schema/shipping}ParcelType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetParcelByIdResponseType", namespace = "http://demo.oracle.com/ops/domain/services/parcel", propOrder = {
    "responseHeader",
    "parcel"
})
@XmlRootElement(name = "GetParcelByIdResponse", namespace = "http://demo.oracle.com/ops/domain/services/parcel")
public class GetParcelByIdResponse
    implements Serializable
{

    private final static long serialVersionUID = 678L;
    @XmlElement(name = "ResponseHeader", required = true)
    protected WebServiceResponseHeader responseHeader;
    @XmlElement(name = "Parcel", required = true)
    protected Parcel parcel;

    /**
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link WebServiceResponseHeader }
     *     
     */
    public WebServiceResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebServiceResponseHeader }
     *     
     */
    public void setResponseHeader(WebServiceResponseHeader value) {
        this.responseHeader = value;
    }

    /**
     * Gets the value of the parcel property.
     * 
     * @return
     *     possible object is
     *     {@link Parcel }
     *     
     */
    public Parcel getParcel() {
        return parcel;
    }

    /**
     * Sets the value of the parcel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parcel }
     *     
     */
    public void setParcel(Parcel value) {
        this.parcel = value;
    }

}