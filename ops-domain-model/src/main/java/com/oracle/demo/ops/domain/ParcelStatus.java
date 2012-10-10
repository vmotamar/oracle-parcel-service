//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.10 at 12:10:49 PM PDT 
//


package com.oracle.demo.ops.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParcelStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParcelStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BILLING_INFO_RECEIVED"/>
 *     &lt;enumeration value="PARCEL_RECEIVED"/>
 *     &lt;enumeration value="IN_TRANSIT"/>
 *     &lt;enumeration value="OUT_FOR_DELIVERY"/>
 *     &lt;enumeration value="DELIVERED"/>
 *     &lt;enumeration value="DELIVERY_EXCEPTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParcelStatus", namespace = "http://demo.oracle.com/ops/domain/schema/shipping")
@XmlEnum
public enum ParcelStatus {

    BILLING_INFO_RECEIVED,
    PARCEL_RECEIVED,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    DELIVERED,
    DELIVERY_EXCEPTION;

    public String value() {
        return name();
    }

    public static ParcelStatus fromValue(String v) {
        return valueOf(v);
    }

}
