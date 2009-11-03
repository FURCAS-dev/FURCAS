package com.sap.tc.moin.xm.adapter.cps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiLink;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.xm.kernel.XmSerializerCallback;


final class XmCpsSerializerCallback implements XmSerializerCallback<SpiElement, SpiClass, SpiAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmCpsSerializer.class );

    private final SpiSerializerCallback cpsCallback;

    private final Map<String, Map<String, SpiClass>> container2ClassMap = new HashMap<String, Map<String, SpiClass>>( );

    private final Map<String, Map<String, SpiAssociation>> container2AssociationMap = new HashMap<String, Map<String, SpiAssociation>>( );


    private boolean classMapsInitialized = false;

    private boolean associationMapsInitialized = false;

    /**
     * Constructor.
     * 
     * @param aCpsCallback callback
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    XmCpsSerializerCallback( final SpiSerializerCallback aCpsCallback ) {

        if ( aCpsCallback == null ) {
            throw new MoinNullPointerException( "aCpsCallback" ); //$NON-NLS-1$
        }
        this.cpsCallback = aCpsCallback;
    }


    public PRI getPri( ) {

        return this.cpsCallback.getPri( );
    }

    public String calculateElementMofId( final SpiClass mofClass, final String[] logicalKey ) {

        return ( (RefClassCalculatedMofId) mofClass ).calculateMofId( logicalKey );
    }


    public SpiClass getClass( final String metamodelContainer, final String dotSeparatedQualifiedName ) {

        if ( !this.classMapsInitialized ) {
            this.initializeClassMaps( );
            this.classMapsInitialized = true;
        }
        final Map<String, SpiClass> m = this.container2ClassMap.get( metamodelContainer );
        if ( m == null ) {
            return null;
        } else {
            return m.get( dotSeparatedQualifiedName );
        }
    }


    public SpiAssociation getAssociation( final String metamodelContainer, final String dotSeparatedQualifiedName ) {

        if ( !this.associationMapsInitialized ) {
            this.initializeAssociationMaps( );
            this.associationMapsInitialized = true;
        }
        final Map<String, SpiAssociation> m = this.container2AssociationMap.get( metamodelContainer );
        if ( m == null ) {
            return null;
        } else {
            return m.get( dotSeparatedQualifiedName );
        }

    }

    private void initializeClassMaps( ) {

        for ( final SpiClass clazz : this.cpsCallback.getUsedClasses( ) ) {
            Map<String, SpiClass> m = this.container2ClassMap.get( clazz.get___MetamodelContainer( ) );
            if ( m == null ) {
                m = new HashMap<String, SpiClass>( );
                this.container2ClassMap.put( clazz.get___MetamodelContainer( ), m );
            }
            m.put( clazz.get___QualifiedName( ), clazz );
        }
    }


    private void initializeAssociationMaps( ) {

        for ( final SpiAssociation ass : this.cpsCallback.getUsedAssociations( ) ) {
            Map<String, SpiAssociation> m = this.container2AssociationMap.get( ass.get___MetamodelContainer( ) );
            if ( m == null ) {
                m = new HashMap<String, SpiAssociation>( );
                this.container2AssociationMap.put( ass.get___MetamodelContainer( ), m );
            }
            m.put( ass.get___QualifiedName( ), ass );
        }
    }

    public String getInstanceMofId( final SpiElement classInstance ) {

        return classInstance.get___MofId( );
    }

//    public String getMetamodelContainerName( final SpiClass clazz ) {
//
//        return clazz.get___MetamodelContainer( );
//    }

    public Collection<SpiElement> getInstances( final SpiClass mofClass ) {

        return this.getClassToElements( ).get( mofClass );
    }


    public SpiElement getClassInstance( final SpiClass mofClass, final String... logicalKey ) {

        return this.cpsCallback.getElement( this.getPri( ).createMri( this.calculateElementMofId( mofClass, logicalKey ) ) );
    }

    public SpiElement getClassInstance( final MRI mri ) {

        if ( mri == null ) {
            throw new MoinNullPointerException( "mri" ); //$NON-NLS-1$
        }
        return this.cpsCallback.getElement( mri );
    }

    public SpiElement getClassInstance( final LRI lri ) {

        if ( lri == null ) {
            throw new MoinNullPointerException( "lri" ); //$NON-NLS-1$
        }
        return this.cpsCallback.getElement( lri );
    }



//    public String getQualifiedName( final SpiElement instance ) {
//
//        return instance.get___Type( ).get___QualifiedName( );
//    }


//    public String getMetamodelContainer( final SpiElement instance ) {
//
//        return instance.get___Type( ).get___MetamodelContainer( );
//    }

    public MRI getMri( final SpiElement instance ) {

        return instance.get___Mri( );
    }

    public Object getAttributeValue( final SpiElement instance, final String attributeName ) {

        return instance.get___AttributeValue( attributeName );
    }


    private final Map<SpiAssociation, Map<SpiElement, Map<Integer, List<SpiElement>>>> associationToElementToIntegerToElements = new HashMap<SpiAssociation, Map<SpiElement, Map<Integer, List<SpiElement>>>>( );

    public Collection<SpiElement> getLinkedInstances( final SpiElement endAinstance, final SpiAssociation association, final String endBName ) {

        final int endBNumber = association.get___EndNumber( endBName );
        if ( endBNumber < 0 ) {
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endBName } );
            throw new MoinIllegalArgumentException( XmCpsMessages.ASSOCIATIONHASNOENDNAME, new Object[] { association.get___QualifiedName( ), endBName } );
        }
        final int endANumber;
        if ( endBNumber == 0 ) {
            endANumber = 1;
        } else if ( endBNumber == 1 ) {
            endANumber = 0;
        } else {
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.ASSOCIATIONHASNOENDNAME, endBNumber );
            throw new MoinIllegalStateException( XmCpsMessages.ASSOCIATIONHASNOENDNAME, endBNumber );
        }

        // check that end A instance has the correct end A type
        final SpiClass endAClass = association.get___EndType( endANumber );
        final SpiClass providedEndAClass = endAinstance.get___Type( );
        if ( endAClass.equals( providedEndAClass ) ) {
            // o.k. 
        } else {
            boolean found = false;
            for ( final SpiType superType : providedEndAClass.get___AllSuperTypes( ) ) {
                if ( superType.equals( endAClass ) ) {
                    found = true;
                    break;
                }
            }
            if ( !found ) { // endAInstance is not an instance object with the same type as end A
                LOGGER.logAndTrace( MoinSeverity.ERROR, XmCpsMessages.TYPENOTFITTINGTOASSOCIATIONEND, new Object[] { providedEndAClass.get___QualifiedName( ), endBName, association.get___QualifiedName( ) } );
                throw new MoinIllegalArgumentException( XmCpsMessages.TYPENOTFITTINGTOASSOCIATIONEND, new Object[] { providedEndAClass.get___QualifiedName( ), endBName, association.get___QualifiedName( ) } );
            }
        }
        final List<SpiElement> result;
        Map<SpiElement, Map<Integer, List<SpiElement>>> elementToIntegerToElements = this.associationToElementToIntegerToElements.get( association );
        if ( elementToIntegerToElements == null ) {
            elementToIntegerToElements = this.getElementToEndNumberToElements( association );
            this.associationToElementToIntegerToElements.put( association, elementToIntegerToElements );
        }
        final Map<Integer, List<SpiElement>> integerToElements = elementToIntegerToElements.get( endAinstance );
        if ( integerToElements == null ) {
            // no links for element
            result = Collections.emptyList( );
        } else {
            final List<SpiElement> elements = integerToElements.get( endANumber );
            if ( elements == null ) {
                result = Collections.emptyList( );
            } else {
                result = elements;
            }
        }
        return result;
    }

    public ClassDescriptor<? extends RefClass, ? extends RefObject> getType( final SpiElement modelElement ) {

        return XmCpsParserCallback.getTypeInternal( modelElement );
    }

    public Collection<SpiElement> getStoredElements( ) {

        return this.cpsCallback.getElements( );
    }


    // remark: we must not reset this map after a serialization call because a XmCpsSerializerCallback instance is created
    // for each serialization call; after the call there is no longer a reference to the instance.
    private Map<SpiAssociation, List<SpiLink>> associationToLinks;

    private Map<SpiAssociation, List<SpiLink>> getAssociationToLinks( ) {

        if ( this.associationToLinks == null ) {
            this.associationToLinks = this.cpsCallback.getLinksByAssociation( );
        }
        return this.associationToLinks;
    }

    // remark: we must not reset this map after a serialization call because a XmCpsSerializerCallback instance is created
    // for each serialization call; after the call there is no longer a reference to the instance.
    private Map<SpiClass, Collection<SpiElement>> classToElements;

    private Map<SpiClass, Collection<SpiElement>> getClassToElements( ) {

        if ( this.classToElements == null ) {
            this.classToElements = this.cpsCallback.getElementsByClass( );
        }
        return this.classToElements;
    }



    private Map<SpiElement, Map<Integer, List<SpiElement>>> getElementToEndNumberToElements( final SpiAssociation association ) {

        final List<SpiLink> links = this.getAssociationToLinks( ).get( association );
        if ( links != null && !links.isEmpty( ) ) {
            final Map<SpiElement, Map<Integer, List<SpiElement>>> result = new HashMap<SpiElement, Map<Integer, List<SpiElement>>>( );
            for ( final SpiLink link : links ) {
                final Object end0Ob = this.cpsCallback.getElementAtLinkEnd( link, 0 );
                final Object end1Ob = this.cpsCallback.getElementAtLinkEnd( link, 1 );
                // endA instance must be located in the model partition, therefore it must be of type MRI
                this.treatEndAAndEndBObject( end0Ob, 0, end1Ob, result );
                this.treatEndAAndEndBObject( end1Ob, 1, end0Ob, result );
            }
            return result;
        } else {
            return Collections.emptyMap( );
        }
    }

    private void treatEndAAndEndBObject( final Object endAOb, final int endA, final Object endBOb, final Map<SpiElement, Map<Integer, List<SpiElement>>> result ) {

        // endA instance must be located in the model partition, therefore it must be of type SpiElement!
        if ( endAOb instanceof SpiElement ) {
            final SpiElement elementAtEndA = (SpiElement) endAOb;
            Map<Integer, List<SpiElement>> integerToElements = result.get( elementAtEndA );
            if ( integerToElements == null ) {
                integerToElements = new HashMap<Integer, List<SpiElement>>( );
                result.put( elementAtEndA, integerToElements );
            }
            List<SpiElement> elements = integerToElements.get( endA );
            if ( elements == null ) {
                elements = new ArrayList<SpiElement>( );
                integerToElements.put( endA, elements );
            }
            if ( endBOb instanceof SpiElement ) {
                elements.add( (SpiElement) endBOb );
            } else {
                // LRI; attention null can be added, if the link is broken!
                elements.add( this.cpsCallback.getElement( (LRI) endBOb ) );
            }
        }
    }


}
