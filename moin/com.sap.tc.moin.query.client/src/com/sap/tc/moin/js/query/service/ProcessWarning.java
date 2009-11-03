
package com.sap.tc.moin.js.query.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processWarning complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processWarning">
 *   &lt;complexContent>
 *     &lt;extension base="{http://sap.com/tc/moin/js/query/service/}processMessage">
 *       &lt;sequence>
 *         &lt;element name="stackTrace" type="{http://sap.com/tc/moin/js/query/service/}wsStackTraceElement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processWarning", propOrder = {
    "stackTrace"
})
public class ProcessWarning
    extends ProcessMessage
{

    @XmlElement(nillable = true)
    protected List<WsStackTraceElement> stackTrace;

    /**
     * Gets the value of the stackTrace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stackTrace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStackTrace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsStackTraceElement }
     * 
     * 
     */
    public List<WsStackTraceElement> getStackTrace() {
        if (stackTrace == null) {
            stackTrace = new ArrayList<WsStackTraceElement>();
        }
        return this.stackTrace;
    }

}
