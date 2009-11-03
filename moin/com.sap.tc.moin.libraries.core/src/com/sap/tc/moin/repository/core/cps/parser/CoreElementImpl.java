package com.sap.tc.moin.repository.core.cps.parser;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructuredValueBase;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;

public final class CoreElementImpl implements SpiElement {

    private final RefFeaturedExtension refObject;

    private final SpiClass typeOfElement;

    private final CoreParserCallbackImpl callback;

    public CoreElementImpl( CoreParserCallbackImpl callback, SpiClass type, RefObject refObject ) {

        this.callback = callback;
        this.typeOfElement = type;
        this.refObject = (RefFeaturedExtension) refObject;
    }

    public SpiClass get___Type( ) {

        return typeOfElement;
    }

    public String get___MofId( ) {

        return refObject.refMofId( );
    }

    public void add___PrimitiveOrEnumerationValue( String attributeName, String primitiveOrEnumValue ) {

        if ( attributeName == null ) {
            throw new MoinIllegalNullArgumentException( "attributeName" ); //$NON-NLS-1$
        }
        if ( primitiveOrEnumValue == null ) {
            throw new MoinIllegalNullArgumentException( "primitiveOrEnumValue" ); //$NON-NLS-1$
        }
        callback.addAttributeValue( this, attributeName, primitiveOrEnumValue );
    }

    public void add___StructuredValue( String attributeName, SpiStructuredValueBase structuredValue ) {

        if ( attributeName == null ) {
            throw new MoinIllegalNullArgumentException( "attributeName" ); //$NON-NLS-1$
        }
        if ( structuredValue == null ) {
            throw new MoinIllegalNullArgumentException( "structuredValue" ); //$NON-NLS-1$
        }
        callback.addAttributeValue( this, attributeName, structuredValue );
    }

    public void add___ElementValue( String attributeName, SpiElement element ) {

        if ( attributeName == null ) {
            throw new MoinIllegalNullArgumentException( "attributeName" ); //$NON-NLS-1$
        }
        if ( element == null ) {
            throw new MoinIllegalNullArgumentException( "element" ); //$NON-NLS-1$
        }
        callback.addAttributeValue( this, attributeName, element );
    }

    public void add___ExternalElementValue( String attributeName, LRI lriOfExternalElement ) {

        if ( attributeName == null ) {
            throw new MoinIllegalNullArgumentException( "attributeName" ); //$NON-NLS-1$
        }
        if ( lriOfExternalElement == null ) {
            throw new MoinIllegalNullArgumentException( "lriOfExternalElement" ); //$NON-NLS-1$
        }
        callback.addAttributeValue( this, attributeName, lriOfExternalElement );
    }

    public Object get___AttributeValue( String attributeName ) {

        if ( attributeName == null ) {
            throw new MoinIllegalNullArgumentException( "attributeName" ); //$NON-NLS-1$
        }
        return ( (RefObjectImpl) refObject ).get___AttributeValue( attributeName );
    }

    public RefFeaturedExtension getRefObject( ) {

        return refObject;
    }

    @Override
    public String toString( ) {

        return ( (Partitionable) getRefObject( ) ).get___Mri( ).toString( ) + " (Class: " + QualifiedName.toDotSeparatedString( ( (ModelElement) getRefObject( ).refMetaObject( ) ).getQualifiedName( ) ) + ")"; //$NON-NLS-1$//$NON-NLS-2$
    }
}
