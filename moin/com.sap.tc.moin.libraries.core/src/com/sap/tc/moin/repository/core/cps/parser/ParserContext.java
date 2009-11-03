package com.sap.tc.moin.repository.core.cps.parser;

import org.xml.sax.Attributes;

import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiStructureType;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiStructuredValue;

public abstract class ParserContext {

    public abstract void addContainer( String containerName, String containerId, String version );

    public abstract void addMetaObject( String qName, Attributes attributes );

    public abstract SpiElement addElement( String containerId, String qualifiedName, String mofId );

    public abstract void addLink( SpiAssociation association, String firstEnd, String secondEnd );

    public abstract void parsingFinished( );

    public abstract void addAttributeValue( SpiElement element, String attributeName, Object attributeValue );

    public abstract SpiType getType( String containerId, String qualifiedName );

    public abstract SpiStructuredValue createStructuredValue( );

    public abstract SpiStructuredValue createStructuredValue( SpiStructureType type );

    public String intern( String string ) {

        return string.intern( );
    }
}
