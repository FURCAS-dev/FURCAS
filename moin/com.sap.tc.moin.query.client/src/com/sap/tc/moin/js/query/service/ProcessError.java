
package com.sap.tc.moin.js.query.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processError">
 *   &lt;complexContent>
 *     &lt;extension base="{http://sap.com/tc/moin/js/query/service/}processMessage">
 *       &lt;sequence>
 *         &lt;element name="rootCause" type="{http://sap.com/tc/moin/js/query/service/}wsThrowable" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processError", propOrder = {
    "rootCause"
})
public class ProcessError
    extends ProcessMessage
{

    protected WsThrowable rootCause;

    /**
     * Gets the value of the rootCause property.
     * 
     * @return
     *     possible object is
     *     {@link WsThrowable }
     *     
     */
    public WsThrowable getRootCause() {
        return rootCause;
    }

    /**
     * Sets the value of the rootCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsThrowable }
     *     
     */
    public void setRootCause(WsThrowable value) {
        this.rootCause = value;
    }

}
