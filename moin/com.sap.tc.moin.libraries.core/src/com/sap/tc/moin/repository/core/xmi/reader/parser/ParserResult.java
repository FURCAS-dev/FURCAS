package com.sap.tc.moin.repository.core.xmi.reader.parser;

import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;

import com.sap.tc.moin.repository.core.xmi.reader.InstanceInfo;
import com.sap.tc.moin.repository.core.xmi.reader.LinkInfo;

/**
 * Instances of this class represent the findings (i.e. model elements and
 * links) of a complete parsing run of one or more XMI documents.
 */
public class ParserResult {

    /**
     * Contains the URIs of all parsed documents.
     */
    private Set<String /* uri */> parsedDocuments;

    /**
     * Contains all model elements found during parsing.
     */
    private Set<InstanceInfo> modelElements;

    /**
     * Contains all links grouped by their association found during parsing.
     */
    private Map<AssociationInternal, Set<LinkInfo>> links;

    /**
     * Contains all values of classifier-level attributes found during parsing.
     */
    private Map<AttributeInternal, Object /* value */> staticAttributes;

    /**
     * Constructs a new ParserResult with the given information. This class is
     * constructed by instances of {@link XmiContext} only.
     */
    public ParserResult( Set<String> parsedDocuments, Set<InstanceInfo> modelElements, Map<AssociationInternal, Set<LinkInfo>> links, Map<AttributeInternal, Object> staticAttributes ) {

        this.parsedDocuments = parsedDocuments;
        this.modelElements = modelElements;
        this.links = links;
        this.staticAttributes = staticAttributes;
    }

    /**
     * Returns the list of URIs of all parsed documents.
     */
    public Set<String> getParsedDocuments( ) {

        return parsedDocuments;
    }

    /**
     * Returns all model elements found during parsing.
     */
    public Set<InstanceInfo> getModelElements( ) {

        return modelElements;
    }

    /**
     * Returns all links grouped by their association found during parsing.
     */
    public Map<AssociationInternal, Set<LinkInfo>> getLinks( ) {

        return links;
    };

    /**
     * Returns all values of classifier-level attributes found during parsing.
     */
    public Map<AttributeInternal, Object> getStaticAttributes( ) {

        return staticAttributes;
    }
}