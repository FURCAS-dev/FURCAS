
package com.sap.tc.moin.js.query.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errors" type="{http://sap.com/tc/moin/js/query/service/}processError" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="processStatus" type="{http://sap.com/tc/moin/js/query/service/}processStatusType"/>
 *         &lt;element name="warnings" type="{http://sap.com/tc/moin/js/query/service/}processWarning" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processReport", propOrder = {
    "errors",
    "processStatus",
    "warnings"
})
public class ProcessReport {

    @XmlElement(nillable = true)
    protected List<ProcessError> errors;
    protected int processStatus;
    @XmlElement(nillable = true)
    protected List<ProcessWarning> warnings;

    /**
     * Gets the value of the errors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessError }
     * 
     * 
     */
    public List<ProcessError> getErrors() {
        if (errors == null) {
            errors = new ArrayList<ProcessError>();
        }
        return this.errors;
    }

    /**
     * Gets the value of the processStatus property.
     * 
     */
    public int getProcessStatus() {
        return processStatus;
    }

    /**
     * Sets the value of the processStatus property.
     * 
     */
    public void setProcessStatus(int value) {
        this.processStatus = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warnings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarnings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessWarning }
     * 
     * 
     */
    public List<ProcessWarning> getWarnings() {
        if (warnings == null) {
            warnings = new ArrayList<ProcessWarning>();
        }
        return this.warnings;
    }

}
