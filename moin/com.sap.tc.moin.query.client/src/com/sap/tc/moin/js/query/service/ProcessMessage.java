
package com.sap.tc.moin.js.query.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="endColumn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endLine" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endPosition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startColumn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startLine" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startPosition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processMessage", propOrder = {
    "endColumn",
    "endLine",
    "endPosition",
    "message",
    "startColumn",
    "startLine",
    "startPosition"
})
public class ProcessMessage {

    protected int endColumn;
    protected int endLine;
    protected int endPosition;
    protected String message;
    protected int startColumn;
    protected int startLine;
    protected int startPosition;

    /**
     * Gets the value of the endColumn property.
     * 
     */
    public int getEndColumn() {
        return endColumn;
    }

    /**
     * Sets the value of the endColumn property.
     * 
     */
    public void setEndColumn(int value) {
        this.endColumn = value;
    }

    /**
     * Gets the value of the endLine property.
     * 
     */
    public int getEndLine() {
        return endLine;
    }

    /**
     * Sets the value of the endLine property.
     * 
     */
    public void setEndLine(int value) {
        this.endLine = value;
    }

    /**
     * Gets the value of the endPosition property.
     * 
     */
    public int getEndPosition() {
        return endPosition;
    }

    /**
     * Sets the value of the endPosition property.
     * 
     */
    public void setEndPosition(int value) {
        this.endPosition = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the startColumn property.
     * 
     */
    public int getStartColumn() {
        return startColumn;
    }

    /**
     * Sets the value of the startColumn property.
     * 
     */
    public void setStartColumn(int value) {
        this.startColumn = value;
    }

    /**
     * Gets the value of the startLine property.
     * 
     */
    public int getStartLine() {
        return startLine;
    }

    /**
     * Sets the value of the startLine property.
     * 
     */
    public void setStartLine(int value) {
        this.startLine = value;
    }

    /**
     * Gets the value of the startPosition property.
     * 
     */
    public int getStartPosition() {
        return startPosition;
    }

    /**
     * Sets the value of the startPosition property.
     * 
     */
    public void setStartPosition(int value) {
        this.startPosition = value;
    }

}
