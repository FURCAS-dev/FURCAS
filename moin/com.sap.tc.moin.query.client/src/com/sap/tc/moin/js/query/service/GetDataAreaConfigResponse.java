
package com.sap.tc.moin.js.query.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataAreaConfig" type="{http://sap.com/tc/moin/js/query/service/}KVList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataAreaConfig"
})
@XmlRootElement(name = "getDataAreaConfigResponse")
public class GetDataAreaConfigResponse {

    @XmlElement(required = true)
    protected KVList dataAreaConfig;

    /**
     * Gets the value of the dataAreaConfig property.
     * 
     * @return
     *     possible object is
     *     {@link KVList }
     *     
     */
    public KVList getDataAreaConfig() {
        return dataAreaConfig;
    }

    /**
     * Sets the value of the dataAreaConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link KVList }
     *     
     */
    public void setDataAreaConfig(KVList value) {
        this.dataAreaConfig = value;
    }

}
