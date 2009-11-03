package com.sap.tc.moin.xm.kernel.impl.parser.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import javax.xml.validation.Schema;
import javax.xml.validation.TypeInfoProvider;
import javax.xml.validation.ValidatorHandler;

import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.parser.PModelElementHandle;
import com.sap.tc.moin.repository.xm.parser.ParserErrorHandler;
import com.sap.tc.moin.repository.xm.parser.ParserHelper;
import com.sap.tc.moin.repository.xm.parser.PathStack;
import com.sap.tc.moin.xm.kernel.XmParserCallback;
import com.sap.tc.moin.xm.kernel.impl.XmExceptionMessages;
import com.sap.tc.moin.xm.kernel.impl.parser.sax.PathStackImpl;
import com.sap.tc.moin.xm.kernel.impl.util.Helper;

/** Helper methods for the XM Parser. */
public final class ParserHelperImpl<TElement, TMofClass, TMofAssociation> extends Helper<TElement, TMofClass, TMofAssociation> implements ParserHelper {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, ParserHelperImpl.class );

    private final PathStackImpl stack = new PathStackImpl( );

    private final ValidatorHandler validatorHandler;

    private final ParserErrorHandler errorHandler;

    /**
     * Unmodifiable map containing as keys the prefixes and as values the
     * namespaces defined in the mapping XML.
     */
    private Map<String, String> prefix2Ns;

    /**
     * Unmodifiable map containing as keys the namespaces and as values the
     * prefixes defined in the mapping XML.
     */
    private Map<String, String> ns2Prefix;

    /**
     * List of the links which cannot be executed immediately, because it is not
     * clear whether they are inner- or inter-partition links. They are executed
     * at the end of the mapping because then one can determine whether a link
     * is an inner- or inter-partition link.
     */
    private final List<RetardedLink<TElement, TMofClass, TMofAssociation>> retardedLinks = new ArrayList<RetardedLink<TElement, TMofClass, TMofAssociation>>( );


    /**
     * Constructor.
     * 
     * @param aXmlSchema XML schema for the source XML documents, can be
     * <code>null</code>
     * @param aErrorHandler error handler, can be <code>null</code>
     * @throws IllegalArgumentException if <tt>aXmlSchema</tt> is not
     * <code>null</code> and <tt>aErrorHandler</tt> is <code>null</code>
     */
    public ParserHelperImpl( final Schema aXmlSchema, final ParserErrorHandler aErrorHandler ) {

        super( );
        if ( aXmlSchema != null ) {
            validatorHandler = aXmlSchema.newValidatorHandler( );
            if ( aErrorHandler == null ) {
                throw new MoinIllegalStateException( XmExceptionMessages.ERROR_HANDLER_IS_NULL_ALTHOUGH_XML_SCHEMA_IS_NOT_NULL );
            }
            this.errorHandler = aErrorHandler;
        } else {
            this.validatorHandler = null;
            this.errorHandler = null;
        }
    }


    /**
     * Returns the path stack.
     * 
     * @return path stack
     */
    public PathStack getStack( ) {

        return this.stack;
    }


    /**
     * Sets the namespace maps. These properties must be set before the parsing
     * or serializing is executed.
     * 
     * @param prefix2Namespaces
     * @param namespaces2Prefixes
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public void setNamespaceMaps( final Map<String, String> prefix2Namespaces, final Map<String, String> namespaces2Prefixes ) {

        if ( prefix2Namespaces == null ) {
            throw new MoinNullPointerException( "prefix2Namespaces" ); //$NON-NLS-1$
        }
        if ( namespaces2Prefixes == null ) {
            throw new MoinNullPointerException( "namespaces2Prefixes" ); //$NON-NLS-1$
        }
        this.ns2Prefix = Collections.unmodifiableMap( namespaces2Prefixes );
        this.prefix2Ns = Collections.unmodifiableMap( prefix2Namespaces );
    }


    /**
     * Returns the prefix to namespace map.
     * 
     * @return map
     */
    public Map<String, String> getPrefix2NamespaceMap( ) {

        return this.prefix2Ns;
    }

    /**
     * Returns the namespace to prefix map.
     * 
     * @return map
     */
    public Map<String, String> getNamespace2PrefixMap( ) {

        return this.ns2Prefix;
    }


    public PModelElementHandle getOrCreateModelElement( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String... logicalKey ) {

        return new PModelElementHandleImpl<TElement, TMofClass, TMofAssociation>( this.getOrCreateInstance( this.getClass( classDescriptor ), logicalKey ), classDescriptor, this );
    }

    public PModelElementHandle getOrCreateModelElement( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor ) {

        return this.getOrCreateModelElement( classDescriptor, this.getDefaultLogicalKey( ) );
    }

    public void createLink( final AssociationDescriptor<? extends RefAssociation> descriptor, final String endBName, final PModelElementHandle endAmodelElement, final PModelElementHandle endBmodelElement ) {

        if ( endBName == null ) {
            throw new MoinNullPointerException( "endBName" ); //$NON-NLS-1$
        }
        if ( endAmodelElement.getClass( ) != PModelElementHandleImpl.class ) {
            throw new MoinIllegalArgumentException( XmExceptionMessages.NOTFETCHED, "endAmodelElement", "getOrCreateModelElement" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        if ( endBmodelElement.getClass( ) != PModelElementHandleImpl.class ) {
            throw new MoinIllegalArgumentException( XmExceptionMessages.NOTFETCHED, "endBmodelElement", "getOrCreateModelElement" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        this.createLink( this.getAssociation( descriptor ), descriptor.getQualifiedName( )[descriptor.getQualifiedName( ).length - 1], endAmodelElement.getMofid( ), endBmodelElement.getMofid( ), endBName );
    }

    public void createLink( final AssociationDescriptor<? extends RefAssociation> descriptor, final String endBName, final PModelElementHandle endAmodelElement, final ClassDescriptor<? extends RefClass, ? extends RefObject> endBClassDescriptor, final String... endBLogicalKey ) {

        final String endBMofid = this.calculateElementMofid( this.getClass( endBClassDescriptor ), endBLogicalKey );
        this.createLink( descriptor, endBName, endAmodelElement, endBMofid );
    }

    public void createLink( final AssociationDescriptor<? extends RefAssociation> descriptor, final String endBName, final PModelElementHandle endAmodelElement, final String endBMofid ) {

        if ( endBName == null ) {
            throw new MoinNullPointerException( "endBName" ); //$NON-NLS-1$
        }
        if ( endBMofid == null ) {
            throw new MoinNullPointerException( "endBMofid" ); //$NON-NLS-1$
        }
        if ( endBMofid.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "endBMofid" ); //$NON-NLS-1$
        }
        if ( endAmodelElement.getClass( ) != PModelElementHandleImpl.class ) {
            throw new MoinIllegalArgumentException( XmExceptionMessages.NOTFETCHED, "endAmodelElement", "getOrCreateModelElement" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        final TElement endBInstance = this.get( endBMofid );
        final String dotSeparatedAssocaitionQName = Helper.getDotSeparatedQualifiedName( descriptor.getQualifiedName( ) );
        if ( endBInstance != null ) {
            // inner partition link
            this.createLink( this.getAssociation( descriptor ), dotSeparatedAssocaitionQName, endAmodelElement.getMofid( ), endBInstance, endBName );
        } else {
            this.retardedLinks.add( new RetardedLink<TElement, TMofClass, TMofAssociation>( endAmodelElement, this.getAssociation( descriptor ), dotSeparatedAssocaitionQName, this, endBName, endBMofid ) );
        }
    }

    /**
     * Returns the type info provider.
     * 
     * @return type info provider, can be <code>null</code> if a schema has not
     * been provided
     */
    public TypeInfoProvider getTypeInfoProvider( ) {

        if ( this.validatorHandler != null ) {
            return this.validatorHandler.getTypeInfoProvider( );
        } else {
            return null;
        }
    }

    /**
     * Creates an inner partition link between two class instances for a given
     * association name and end name.
     * 
     * @param association association
     * @param endA MOFID of the end A class instance
     * @param associationName name of the association
     * @param endB MOFID of the referred class instance
     * @param endBName name of the end B
     * @throws IllegalArgumentException if the qualified name for the
     * association is not correct or the end B name is not an end name of the
     * association or if the model elements are not compatible with the end
     * types of the association
     */
    private void createLink( final TMofAssociation association, final String associationName, final String endA, final String endB, final String endBName ) {

        this.createLink( this.get( endA ), association, associationName, this.get( endB ), endBName );
    }

    /**
     * Creates an inner partition link between two class instances for a given
     * association name and end name.
     * 
     * @param endAMofid MOFID of the end A class instance
     * @param association association
     * @param associationQName qualified name of the association
     * @param endBObj instance of end B
     * @param endBName name of the end B
     * @throws IllegalArgumentException if the qualified name for the
     * association is not correct or the end B name is not an end name of the
     * association or if the model elements are not compatible with the end
     * types of the association
     */
    private void createLink( final TMofAssociation association, final String associationQName, final String endAMofId, final TElement endBObj, final String endBName ) {

        this.createLink( this.get( endAMofId ), association, associationQName, endBObj, endBName );
    }



    /**
     * Executes the retarded links. At the end of the mapping the retarded links
     * are executed, because here one can decide whether a retarded link is a
     * inner- or inter-partition link.
     */
    public void executeRetardedLinks( ) throws XmException {

        for ( final RetardedLink<TElement, TMofClass, TMofAssociation> rLink : this.retardedLinks ) {
            rLink.execute( );
        }
    }


    /**
     * Frees resources after the execution of a mapping.
     */
    @Override
    public void reset( ) {

        super.reset( );
        this.retardedLinks.clear( );
        this.stack.reset( );
    }

    /**
     * Returns the validator handler.
     * 
     * @return validator handler, can be <code>null</code>, if a schema was not
     * provided
     */
    public ValidatorHandler getValidatorHandler( ) {

        return this.validatorHandler;
    }

    /**
     * Returns the error handler.
     * 
     * @return error handler, can be <code>null</code>; is not <code>null</code>
     * if the validator is not <code>null</code>
     */
    public ParserErrorHandler getErrorHandler( ) {

        return this.errorHandler;
    }

    /**
     * Returns the MOFID of a certain class instance specified by the logical
     * keys. If the class instance does not exist it is created.
     * 
     * @param clazz MOF class object
     * @param logicalKey logical key for the calculation of the MOFID
     * @return MOFID, cannot be <tt>null</tt>
     */
    private String getOrCreateInstance( final TMofClass clazz, final String... logicalKey ) {

        String result = this.getCachedInstance( clazz, logicalKey );
        if ( result == null ) {
            // not yet existing --> create
            final TElement element = this.getParserCallback( ).createClassInstance( clazz, logicalKey );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, "Model element {0} with type {1} and logical key {2} created", new Object[] { element, clazz, Arrays.toString( logicalKey ) } ); //$NON-NLS-1$
            }
            // add to cache
            result = this.getParserCallback( ).getInstanceMofId( element );
            this.put( result, element );
        }
        return result;
    }

    private String getCachedInstance( final TMofClass clazz, final String... logicalKey ) {

        // assumption: use MofId of RefClass as locality scope
        final String mofId = this.calculateElementMofid( clazz, logicalKey );
        final TElement element = this.get( mofId );
        if ( element != null ) {
            return mofId;
        } else {
            return null;
        }
    }

    /**
     * Sets or adds an attribute of primitive type to a class instance. The
     * <code>attributeName</code> can denote a single- or multi-valued
     * attribute.
     * <p>
     * If the attribute is of type Boolean then the attribute value is set to
     * <code>true</code> if the string argument is not <code>null</code> and is
     * equal, ignoring case, to the string <code>"true"</code>.
     * <p>
     * Example: <tt>Boolean.valueOf("True")</tt> leads to <tt>true</tt>.<br>
     * Example: <tt>Boolean.valueOf("yes")</tt> leads to <tt>false</tt>.
     * 
     * @param classInstance class instance
     * @param attributeName name of the attribute
     * @param value value
     * @throws InvalidNameException if <code>attributeName</code> does not
     * denote a valid feature name; this exception is only thrown in the
     * Import/Export integration strategy; in the CP/S integration strategy this
     * situation can be handled by the SpiParserErrorHandler
     * @exception NumberFormatException if the attribute is a number primitive
     * type and <tt>value</tt> does not contain a parse-able number; this
     * exception is only thrown in the Import/Export integration strategy; in
     * the CP/S integration strategy this situation can be handled by the
     * SpiParserErrorHandler
     * @throws IllegalArgumentException if <code>value</code> is
     * <code>null</code>
     */
    void setOrAddAttribute( final TElement classInstance, final String attributeName, final String value ) {

        this.getParserCallback( ).setOrAddAttribute( classInstance, attributeName, value );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Value {0} added to attribute {1} of model element {2}", new Object[] { value, attributeName, classInstance } ); //$NON-NLS-1$
        }
    }

    /**
     * Creates a link between two model elements for a given association name
     * and end name.
     * 
     * @param endAModelElement end A model element
     * @param refAss the association
     * @param associationQName qualified name of the association; necessary for
     * providing a good error message
     * @param endBModelElement end B model element
     * @param endBName name of the end B
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if the qualified name for the
     * association is not correct or the end B name is not an end name of the
     * association or if the model elements are not compatible with the end
     * types of the association
     */
    void createLink( final TElement endAModelElement, final TMofAssociation refAss, final String associationQName, final TElement endBModelElement, final String endBName ) {

        this.getParserCallback( ).addLink( refAss, endAModelElement, endBModelElement, endBName );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Intra partition link created for association {0} and end B {1} with end A model element {2} and end B model element {3}", new Object[] { associationQName, endBName, endAModelElement, endBModelElement } ); //$NON-NLS-1$
        }
    }

    /**
     * Creates an inter-partition link or dangling link between two class
     * instances for a given association name and end name.
     * 
     * @param endARefObject end A class instance
     * @param refAss the association
     * @param associationQName qualified name of the association; necessary for
     * providing a good error message
     * @param endBMofId MOFID of the end B class instance
     * @param endBName name of the end B
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException is thrown in the following cases
     * <ul>
     * <li>if endBName is not a correct end name of the association,</li>
     * <li>if the model element <tt>elementAtEndA</tt> has a type which is not
     * compatible with the end A of the association,
     * <li>if the model element of the MOFID <tt>mofIdOfElementAtEndB</tt> is
     * existing and does not have the correct type which is compatible to the
     * end B in the Import/Export strategy (not thrown in the CP/S strategy!)</li>
     * </ul>
     */
    void createLink( final TElement endARefObject, final TMofAssociation refAss, final String associationQName, final String endBMofId, final String endBName ) {

        this.getParserCallback( ).addLink( refAss, endARefObject, endBMofId, endBName );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Inter partition link or dangling link created for association {0} and end B {1} with end A model element {2} and end B MOFID {3}", new Object[] { associationQName, endBName, endARefObject, endBMofId } ); //$NON-NLS-1$
        }
    }


    private XmParserCallback<TElement, TMofClass, TMofAssociation> getParserCallback( ) {

        return (XmParserCallback<TElement, TMofClass, TMofAssociation>) this.getCallBack( );
    }

    private String[] getDefaultLogicalKey( ) {

        final String[] result = new String[3];
        result[0] = this.getPri( ).getContainerName( );
        result[1] = this.getPri( ).getPartitionName( );
        result[2] = this.getStack( ).getUniquePath( );
        return result;
    }
}
