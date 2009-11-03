package com.sap.tc.moin.js.query.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>
 * Java class for executeQuery complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="executeQuery">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="query" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="scope" type="{http://sap.com/tc/moin/js/query/service/}wsQueryScope" minOccurs="1"/>
 *         &lt;element name="numberOfResults" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "executeQuery", propOrder = { "query", "scope", "numberOfResults" } )
public class ExecuteQuery {

    @XmlElement( required = true )
    protected String query;

    protected WsQueryScope scope;

    protected Integer numberOfResults;

    /**
     * Gets the value of the query property.
     * 
     * @return possible object is {@link String }
     */
    public String getQuery( ) {

        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value allowed object is {@link String }
     */
    public void setQuery( String value ) {

        this.query = value;
    }

    /**
     * Gets the value of the scope property.
     * 
     * @return possible object is {@link WsQueryScope }
     */
    public WsQueryScope getScope( ) {

        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value allowed object is {@link WsQueryScope }
     */
    public void setScope( WsQueryScope value ) {

        this.scope = value;
    }

    /**
     * Gets the value of the numberOfResults property.
     * 
     * @return possible object is {@link Integer }
     */
    public Integer getNumberOfResults( ) {

        return numberOfResults;
    }

    /**
     * Sets the value of the numberOfResults property.
     * 
     * @param value allowed object is {@link Integer }
     */
    public void setNumberOfResults( Integer value ) {

        this.numberOfResults = value;
    }

}
