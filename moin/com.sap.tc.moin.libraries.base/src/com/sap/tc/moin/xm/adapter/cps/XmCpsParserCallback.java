package com.sap.tc.moin.xm.adapter.cps;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiElementBase;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;
import com.sap.tc.moin.xm.kernel.XmParserCallback;

/**
 * Delegates the call-back calls of the XM Parser to the CPS callback.
 */
final class XmCpsParserCallback implements XmParserCallback<SpiElement, SpiClass, SpiAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmCpsSerializer.class );

    private final SpiParserCallback cpsCallback;

    /**
     * Constructor.
     * 
     * @param aCpsCallback callback
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    XmCpsParserCallback( final SpiParserCallback aCpsCallback ) {

        if ( aCpsCallback == null ) {
            throw new MoinNullPointerException( "aCpsCallback" ); //$NON-NLS-1$
        }
        this.cpsCallback = aCpsCallback;
    }


    public PRI getPri( ) {

        return this.cpsCallback.getPri( );
    }

    public String getInstanceMofId( final SpiElement classInstance ) {

        return classInstance.get___MofId( );
    }


    public String calculateElementMofId( final SpiClass mofClass, final String[] logicalKey ) {

        return this.cpsCallback.calculateElementMofId( mofClass, logicalKey );
    }


    public SpiClass getClass( final String metamodelContainer, final String dotSeparatedQualifiedName ) {

        return this.cpsCallback.getClass( null, metamodelContainer, dotSeparatedQualifiedName );
    }


    public SpiAssociation getAssociation( final String metamodelContainer, final String dotSeparatedQualifiedName ) {

        return this.cpsCallback.getAssociation( null, metamodelContainer, dotSeparatedQualifiedName );
    }



//    public String getMetamodelContainerName( final SpiClass clazz ) {
//
//        return clazz.get___MetamodelContainer( );
//    }

    public SpiElement createClassInstance( final SpiClass mofClass, final String... logicalKey ) {

        return this.cpsCallback.addElement( mofClass, this.cpsCallback.calculateElementMofId( mofClass, logicalKey ) );
    }


    public void setOrAddAttribute( final SpiElement classInstance, final String attributeName, final String value ) {

        classInstance.add___PrimitiveOrEnumerationValue( attributeName, value );
    }



    public void addLink( final SpiAssociation association, final SpiElement elementAtEndA, final SpiElement elementAtEndB, final String endBName ) {

        final int endBNumber = association.get___EndNumber( endBName );
        if ( endBNumber < 0 ) {
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endBName } );
            throw new MoinIllegalArgumentException( XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endBName } );
        }
        if ( endBNumber == 0 ) {
            this.cpsCallback.addLink( association, elementAtEndB, elementAtEndA );
        } else if ( endBNumber == 1 ) {
            this.cpsCallback.addLink( association, elementAtEndA, elementAtEndB );
        } else {
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.ASSOCIATIONENDNUMBERILLEGAL, endBNumber );
            throw new MoinIllegalStateException( XmCpsMessages.ASSOCIATIONENDNUMBERILLEGAL, endBNumber );
        }
    }

    public void addLink( final SpiAssociation association, final SpiElement elementAtEndA, final String mofIdOfElementAtEndB, final String endBName ) {

        final int endBNumber = association.get___EndNumber( endBName );

        if ( endBNumber < 0 ) {
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endBName } );
            throw new MoinIllegalArgumentException( XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endBName } );
        }

        if ( endBNumber == 0 ) {
            this.cpsCallback.addLink( association, getPri( ).createMri( mofIdOfElementAtEndB ).getLri( ), elementAtEndA );
        } else if ( endBNumber == 1 ) {
            this.cpsCallback.addLink( association, elementAtEndA, getPri( ).createMri( mofIdOfElementAtEndB ).getLri( ) );
        } else {
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.ASSOCIATIONENDNUMBERILLEGAL, endBNumber );
            throw new MoinIllegalStateException( XmCpsMessages.ASSOCIATIONENDNUMBERILLEGAL, endBNumber );
        }
    }

//    public SpiClass getTypeOfAssociationEnd( final SpiAssociation association, final String endName ) {
//
//        final int endNumber = association.get___EndNumber( endName );
//        if ( endNumber < 0 ) {
//            LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endName } );
//            throw new MoinIllegalArgumentException( XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endName } );
//        }
//        return association.get___EndType( endNumber );
//    }


//    public ClassDescriptor<? extends RefClass, ? extends RefObject> getType( final SpiElement modelElement ) {
//
//        return getTypeInternal( modelElement );
//    }

    static ClassDescriptor<? extends RefClass, ? extends RefObject> getTypeInternal( final SpiElementBase modelElement ) {

        if ( modelElement == null ) {
            throw new MoinNullPointerException( "modelElement" ); //$NON-NLS-1$
        }
        return new ClassDescriptor<RefClass, RefObject>( modelElement.get___Type( ).get___MofId( ), modelElement.get___Type( ).get___MetamodelContainer( ), modelElement.get___Type( ).get___QualifiedName( ).split( "\\." ) ); //$NON-NLS-1$
    }

}
