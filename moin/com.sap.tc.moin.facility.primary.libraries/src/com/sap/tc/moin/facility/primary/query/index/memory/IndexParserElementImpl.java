package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructuredValueBase;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;

public class IndexParserElementImpl implements SpiElement {

    protected final IndexParserCallbackImpl callback;

    private final SpiClass mofClass;

    private IndexModelElement indexModelElement = null;

    private final String mofId;

    public IndexParserElementImpl( IndexParserCallbackImpl callback, SpiClass mofClass, String mofId ) {

        this.callback = callback;
        this.mofClass = mofClass;
        this.mofId = mofId;
    }

    public void set___IndexModelElement( IndexModelElement value ) {

        if ( this.indexModelElement != null ) {
            throw new MoinLocalizedBaseRuntimeException( IndexMessages.UNABLE_TO_RESET_MODEL_ELEMENT );
        }
        this.indexModelElement = value;
    }

    public SpiClass get___Type( ) {

        return mofClass;
    }

    public String get___MofId( ) {

        return mofId;
    }

    public IndexModelElement get___IndexModelElement( ) {

        return indexModelElement;
    }

    public void add___PrimitiveOrEnumerationValue( String attributeName, String primitiveOrEnumValue ) {

        if ( attributeName == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "attributeName" ); //$NON-NLS-1$
        }
        if ( primitiveOrEnumValue == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "primitiveOrEnumValue" ); //$NON-NLS-1$
        }
        if ( callback.isMetamodelPartition ) {
            if ( indexModelElement instanceof IndexNamedModelElement && attributeName.equals( "name" ) ) { //$NON-NLS-1$
                // We need the 'name' attribute of MofPackages, but nothing else.
                ( (IndexNamedModelElement) indexModelElement ).setName( primitiveOrEnumValue );
            }
        }
    }

    public void add___StructuredValue( String attributeName, SpiStructuredValueBase structuredValue ) {

        if ( attributeName == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "attributeName" ); //$NON-NLS-1$
        }
        if ( structuredValue == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "structuredValue" ); //$NON-NLS-1$
        }
    }

    public void add___ElementValue( String attributeName, SpiElement element ) {

        if ( attributeName == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "attributeName" ); //$NON-NLS-1$
        }
        if ( element == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "element" ); //$NON-NLS-1$
        }
    }

    public void add___ExternalElementValue( String attributeName, LRI lriOfExternalElement ) {

        if ( attributeName == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "attributeName" ); //$NON-NLS-1$
        }
        if ( lriOfExternalElement == null ) {
            throw new MoinIllegalArgumentException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL, "mofIdOfExternalElement" ); //$NON-NLS-1$
        }
        callback.addAttributeValue( this, attributeName, lriOfExternalElement );
    }

    public Object get___AttributeValue( String attributeName ) {

        // TODO Auto-generated method stub
        return null;
    }

    public IndexModelElement getIndexModelElement( ) {

        return indexModelElement;
    }
}
