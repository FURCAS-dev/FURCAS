package com.sap.tc.moin.xm.kernel.impl;

import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.xm.kernel.XmFactory;
import com.sap.tc.moin.xm.kernel.XmParser;
import com.sap.tc.moin.xm.kernel.XmSerializer;
import com.sap.tc.moin.xm.kernel.impl.parser.XmParserImpl;
import com.sap.tc.moin.xm.kernel.impl.serializer.XmSerializerImpl;

/**
 * Factory for accessing instances of {@link XmParser} or {@link XmSerializer}.
 */
public final class XmFactoryImpl<TElement, TMofClass, TMofAssociation> extends XmFactory<TElement, TMofClass, TMofAssociation> {

    public XmFactoryImpl( ) {

    }

    @Override
    public XmParser<TElement, TMofClass, TMofAssociation> getParser( final XmParserConfiguration config ) {

        return new XmParserImpl<TElement, TMofClass, TMofAssociation>( config );
    }

    @Override
    public XmSerializer<TElement, TMofClass, TMofAssociation> getSerializer( final XmSerializerConfiguration config ) {

        return new XmSerializerImpl<TElement, TMofClass, TMofAssociation>( config );
    }
}
