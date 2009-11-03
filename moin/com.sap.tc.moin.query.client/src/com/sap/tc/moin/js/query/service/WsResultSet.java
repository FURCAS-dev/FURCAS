
package com.sap.tc.moin.js.query.service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsResultSet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsResultSet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="columnType" type="{http://sap.com/tc/moin/js/query/service/}wsColumnType" maxOccurs="unbounded"/>
 *         &lt;element name="resultRow" type="{http://sap.com/tc/moin/js/query/service/}wsResultRow" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsResultSet", propOrder = {
    "columnType",
    "resultRow"
})
public class WsResultSet {

    @XmlElement(required = true)
    protected List<WsColumnType> columnType;
    @XmlElement(nillable = true)
    protected List<WsResultRow> resultRow;

    /**
     * Gets the value of the columnType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsColumnType }
     * 
     * 
     */
    public List<WsColumnType> getColumnType() {
        if (columnType == null) {
            columnType = new ArrayList<WsColumnType>();
        }
        return this.columnType;
    }

    /**
     * Gets the value of the resultRow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultRow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WsResultRow }
     * 
     * 
     */
    public List<WsResultRow> getResultRow() {
        if (resultRow == null) {
            resultRow = new ArrayList<WsResultRow>();
        }
        return this.resultRow;
    }

}
