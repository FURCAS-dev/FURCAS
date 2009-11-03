package com.sap.tc.moin.js.query.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for wsQueryScope complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="wsQueryScope">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="containerScope" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataAreaScope" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="1"/>
 *         &lt;element name="scopeOperation" type="{http://www.w3.org/2001/XMLSchema}int" default="0"/>
 *         &lt;element name="partitionScope" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "wsQueryScope", propOrder = { "containerScope", "dataAreaScope", "scopeOperation", "partitionScope" } )
public class WsQueryScope {

    @XmlElement( nillable = true )
    protected List<String> containerScope;

    @XmlElement( nillable = true )
    protected List<String> dataAreaScope;

    protected int scopeOperation;

    @XmlElement( nillable = true )
    protected List<String> partitionScope;

    /**
     * Gets the value of the containerScope property.
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the containerScope property.
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     *    getContainerScope().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    public List<String> getContainerScope( ) {

        if ( containerScope == null ) {
            containerScope = new ArrayList<String>( );
        }
        return this.containerScope;
    }

    /**
     * Gets the value of the dataAreaScope property.
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the dataAreaScope property.
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     *    getDataAreaScope().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    public List<String> getDataAreaScope( ) {

        if ( dataAreaScope == null ) {
            dataAreaScope = new ArrayList<String>( );
        }
        return this.dataAreaScope;
    }

    /**
     * Gets the value of the scopeOperation property.
     */
    public int getScopeOperation( ) {

        return scopeOperation;
    }

    /**
     * Sets the value of the scopeOperation property.
     */
    public void setScopeOperation( int value ) {

        this.scopeOperation = value;
    }

    /**
     * Gets the value of the partitionScope property.
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the partitionScope property.
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     *    getPartitionScope().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     */
    public List<String> getPartitionScope( ) {

        if ( partitionScope == null ) {
            partitionScope = new ArrayList<String>( );
        }
        return this.partitionScope;
    }

}
