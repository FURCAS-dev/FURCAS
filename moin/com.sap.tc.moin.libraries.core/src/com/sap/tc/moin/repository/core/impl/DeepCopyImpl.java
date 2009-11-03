package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.DeepCopyError;
import com.sap.tc.moin.repository.DeepCopyMappingEntry;
import com.sap.tc.moin.repository.DeepCopyPolicy;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PartitionChangingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.DeepCopyError.DeepCopyErrorType;
import com.sap.tc.moin.repository.DeepCopyPolicy.DeepCopyPolicyOption;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.DeepCopyPolicyHandlerWrapper;
import com.sap.tc.moin.repository.core.DeepCopyResultSetImpl;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldDescriptor;
import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

public final class DeepCopyImpl {

    private final CoreConnection myConn;

    private Collection<DeepCopyError> copyErrors;

    private static MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE, DeepCopyImpl.class );

    private Map<MRI, CoreConnection> elementsToBeCopied;

    /**
     * Constructor for a connection-aware DeepCopier.
     * 
     * @param conn The connection in which the copied elements are to be created
     */
    public DeepCopyImpl( CoreConnection conn ) {

        myConn = conn;
    }

    /**
     * Delegation method for the standard method name
     */
    public DeepCopyResultSet deepCopy( Map<MRI, CoreConnection> elementsToBeCopied, DeepCopyPolicyHandlerWrapper policyHandler, boolean includeExternalCompositeParents ) {

        this.elementsToBeCopied = elementsToBeCopied;
        DeepCopyResultSet ret = deepCopy( policyHandler, null, includeExternalCompositeParents );
        this.elementsToBeCopied = null;
        return ret;
    }

    /**
     * Internal method for deep copying with a pre-existing mapping table.
     * 
     * @param elementsToBeCopied The elements to be copied (seed set)
     * @param policyHandler The handler that supplies the copying policies for
     * each element. If it is null, the default policy handler is used.
     * @param copyMap Mapping of original elements to copied elements. If it is
     * null, an empty mapping table is created.
     * @return a copy of the elements and the adjacent elements, depending on
     * the policy used
     */
    private DeepCopyResultSet deepCopy( DeepCopyPolicyHandlerWrapper policyHandler, DeepCopyMapImpl copyMap, boolean includeExternalCompositeParents ) {

        int _NOECopied = 0;
        int _NOEReferenced = 0;
        int _NOEIgnored = 0;
        int _NOECustom = 0;

        copyErrors = new ArrayList<DeepCopyError>( );

        // Should never happen because the ConnectionWrapper already checks this!
        if ( policyHandler == null ) {
            throw new IllegalStateException( );
        }

        if ( copyMap == null ) {
            copyMap = new DeepCopyMapImpl( );
        }

        Collection<RefObject> copiedElements = new ArrayList<RefObject>( elementsToBeCopied.size( ) );

        // build the mapping table

        calculateMappingTable( getRefObjects( elementsToBeCopied ), new DeepCopyPolicy( DeepCopyPolicyOption.FULL_COPY, null ), policyHandler, copyMap );

        // create links

        createLinksForCopiedElements( copyMap, includeExternalCompositeParents );

        // lookup MRIs for source and target elements

        Map<MRI, MRI> mriCopyMap = new HashMap<MRI, MRI>( );
        Map<MRI, MRI> inverseMriCopyMap = new HashMap<MRI, MRI>( );

        DeepCopyMappingEntry entry;
        RefObject targetElement = null;

        MRI sourceMri;
        MRI targetMri;

        // create the MRI mapping table, the inverse MRI mapping table and the
        // result set
        Set<Entry<MRI, DeepCopyMappingEntry>> entrySet = copyMap.entrySet( );
        for ( Entry<MRI, DeepCopyMappingEntry> mapEntry : entrySet ) {
            entry = mapEntry.getValue( );
            RefObject mappingTarget = entry.getMappingTarget( );
            if ( mappingTarget != null ) {
                targetMri = mappingTarget.get___Mri( );
            } else {
                targetMri = null;
            }
            sourceMri = mapEntry.getKey( );
            mriCopyMap.put( sourceMri, targetMri );

            DeepCopyPolicyOption opt = entry.getModifiedPolicy( ).getDeepCopyPolicyOption( );
            if ( targetMri != null ) {
                targetElement = (RefObject) myConn.getElement( targetMri );
            }

            if ( ( targetElement != null ) && ( opt == DeepCopyPolicyOption.FULL_COPY || opt == DeepCopyPolicyOption.CUSTOM ) ) {
                copiedElements.add( targetElement );
                inverseMriCopyMap.put( targetMri, sourceMri );
            }
            // Some statistics for Tracing
            switch ( opt ) {
                case FULL_COPY:
                    _NOECopied++;
                    break;
                case REF_COPY:
                    _NOEReferenced++;
                    break;
                case CUSTOM:
                    _NOECustom++;
                    break;
                case STOP:
                    _NOEIgnored++;
                    break;
            }
        }

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Deep Copy performed with following results: \n" + "     Copied Elements:     " + _NOECopied + "\n" + "     Referenced Elements: " + _NOEReferenced + "\n" + "     Custom Elements:     " + _NOECustom + "\n" + "     Ignored Elements:    " + _NOEIgnored ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
        }
        return new DeepCopyResultSetImpl( copiedElements, copyMap, mriCopyMap, inverseMriCopyMap, copyErrors );
    }

    private Collection<RefObject> getRefObjects( Map<MRI, CoreConnection> elements ) {

        Set<Entry<MRI, CoreConnection>> entrySet = elements.entrySet( );
        ArrayList<RefObject> result = new ArrayList<RefObject>( elements.size( ) );
        for ( Entry<MRI, CoreConnection> entry : entrySet ) {
            result.add( (RefObject) entry.getValue( ).getElement( entry.getKey( ) ) );
        }
        return result;
    }

    /**
     * Recursively creates the mapping table for the seed set; calculates
     * composite children and directly linked elements
     * 
     * @param seedSet The elements that are to be copied
     * @param defaultPolicy The default policy for all elements in the seed set
     * @param policyHandler The custom policy handler
     * @param copyMap The mapping table
     */

    private void calculateMappingTable( Collection<RefObject> seedSet, DeepCopyPolicy defaultPolicy, DeepCopyPolicyHandlerWrapper policyHandler, DeepCopyMapImpl copyMap ) {

        Set<RefObject> directlyLinkedElements = new HashSet<RefObject>( );

        calculateMappingTableForCompositeChildren( seedSet, defaultPolicy, policyHandler, copyMap, directlyLinkedElements );

        if ( !directlyLinkedElements.isEmpty( ) ) {
            calculateMappingTable( directlyLinkedElements, new DeepCopyPolicy( DeepCopyPolicyOption.REF_COPY, null ), policyHandler, copyMap );
        }

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "calculateMappingTable: seedSet contained " + seedSet.size( ) + " elements" ); //$NON-NLS-1$//$NON-NLS-2$
        }

    }

    /**
     * The inner loop of the mapping table creation. For the seed set, composite
     * children and directly linked elements are determined. For these elements,
     * the method is called recursively with default policy FULL_COPY for the
     * composite children, and REF_COPY for the directly linked elements.
     * 
     * @param seedSet The elements that are to be copied
     * @param defaultPolicy The default policy for all elements in the seed set
     * @param policyHandler The custom policy handler
     * @param copyMap The mapping table
     * @param directlyLinkedElements The collection where directly linked
     * elements are stored for later evaluation, after the composition hierarchy
     * has been created
     */
    private void calculateMappingTableForCompositeChildren( Collection<RefObject> seedSet, DeepCopyPolicy defaultPolicy, DeepCopyPolicyHandlerWrapper policyHandler, DeepCopyMapImpl copyMap, Collection<RefObject> directlyLinkedElements ) {

        DeepCopyPolicy modifiedPolicy;

        for ( RefObject copyElem : seedSet ) {

            //DRA: We have to check for null, because dangling links in ..* associations are 
            // returned as null
            if ( copyElem != null ) {
                /*
                 * check if mapping policy for element has already been
                 * determined, else, ask policy handler ask only for possible
                 * modifications (Stop->, Ref->{FULL|CUSTOM}, FULL->{},
                 * CUSTOM->{})
                 */

                boolean doMapping = true;
                CoreConnection sourceConnection = elementsToBeCopied.get( copyElem.get___Mri( ) );

                if ( copyMap.containsKey( copyElem ) ) {
                    // If already mapped
                    DeepCopyPolicy existingPolicy = copyMap.get( copyElem ).getModifiedPolicy( );

                    if ( existingPolicy.getDeepCopyPolicyOption( ) == DeepCopyPolicyOption.STOP || existingPolicy.getDeepCopyPolicyOption( ) == DeepCopyPolicyOption.REF_COPY ) {
                        // If already mapped to STOP or to REF, then ask again... who knows
                        // The point is that maybe the default policy can be different because the
                        // first time the element was found as linked, but afterwards as composite
                        // Note: This code calls "tool code" via callback interface. Might throw exceptions in tool code that are by intention NOT handled!
                        modifiedPolicy = policyHandler.getDeepCopyingPolicy( sourceConnection, copyElem, defaultPolicy, copyMap );
                        if ( !( overridesPolicy( existingPolicy.getDeepCopyPolicyOption( ), modifiedPolicy.getDeepCopyPolicyOption( ) ) ) ) {
                            doMapping = false;
                        }
                    } else {
                        doMapping = false;
                        modifiedPolicy = null;
                    }
                } else {
                    // if still not mapped, ask the Handler
                    // Note: This code calls "tool code" via callback interface. Might throw exceptions in tool code that are by intention NOT handled!
                    modifiedPolicy = policyHandler.getDeepCopyingPolicy( sourceConnection, copyElem, defaultPolicy, copyMap );
                }

                if ( doMapping ) {
                    if ( !( checkPolicyModification( copyElem, defaultPolicy, modifiedPolicy ) ) ) {
                        // If the modification is not legal, then use the default
                        modifiedPolicy = defaultPolicy;
                    }

                    if ( modifiedPolicy.getDeepCopyPolicyOption( ) == null ) {
                        copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_002, ( (Partitionable) copyElem ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                        modifiedPolicy = defaultPolicy;
                    }

                    switch ( modifiedPolicy.getDeepCopyPolicyOption( ) ) {
                        case REF_COPY:
                        case STOP:
                        case CUSTOM:
                            mapElement( copyMap, copyElem, defaultPolicy, modifiedPolicy );
                            break;
                        case FULL_COPY:
                            // If COPY then add the element to the map, add the linked elements and process composed elements (as COPY)
                            mapElement( copyMap, copyElem, defaultPolicy, modifiedPolicy );
                            directlyLinkedElements.addAll( getAllLinkedElements( copyElem ) );
                            calculateMappingTableForCompositeChildren( getCompositeChildrenImmediate( copyElem ), new DeepCopyPolicy( DeepCopyPolicyOption.FULL_COPY, null ), policyHandler, copyMap, directlyLinkedElements );
                            break;
                    }
                }
            }
        }
    }

    /**
     * Checks if the modification of a policy by the policy handler is legal.
     * Policy follows the rules defined in the specification of Deep Copy. Also,
     * for custom elements, type conformance is checked.
     * 
     * @param elementToBeCopied The original element
     * @param originalPolicy The original policy
     * @param modifiedPolicy The modified policy
     * @return True if the modification is legal
     */
    private boolean checkPolicyModification( RefObject elementToBeCopied, DeepCopyPolicy originalPolicy, DeepCopyPolicy modifiedPolicy ) {

        if ( originalPolicy.equals( modifiedPolicy ) ) {
            return true;
        } else {

            switch ( originalPolicy.getDeepCopyPolicyOption( ) ) {
                case FULL_COPY:
                    // FULL_COPY -> REF_COPY
                    if ( modifiedPolicy.getDeepCopyPolicyOption( ) == DeepCopyPolicyOption.REF_COPY ) {
                        copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_005, ( (Partitionable) elementToBeCopied ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                        return false;

                        // FULL_COPY -> CUSTOM
                    } else if ( modifiedPolicy.getDeepCopyPolicyOption( ) == DeepCopyPolicyOption.CUSTOM ) {
                        RefObject customElement = modifiedPolicy.getCustomElement( );
                        if ( customElement == null ) {
                            copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_003, ( (Partitionable) elementToBeCopied ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                            return false;
                        } else if ( conformsToJmiType( (RefObject) this.inLocalConnection( customElement ), elementToBeCopied ) ) {
                            return true;
                        } else {
                            copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_006, ( (Partitionable) customElement ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                            return false;
                        }

                        // FULL_COPY -> STOP
                    } else {
                        return true;
                    }

                case REF_COPY:
                    if ( modifiedPolicy.getDeepCopyPolicyOption( ) == DeepCopyPolicyOption.CUSTOM ) {
                        RefObject customElement = modifiedPolicy.getCustomElement( );
                        if ( elementToBeCopied.getClass( ).isInstance( customElement ) ) {
                            return true;
                        } else {
                            copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_006, ( (Partitionable) customElement ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                            return false;
                        }
                    } else {
                        return true;
                    }

                case STOP:
                case CUSTOM:
                    copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_004, ( (Partitionable) elementToBeCopied ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                    return false;
            }
        }

        return false;
    }

    /**
     * If an element has already been mapped, but it is accessed a second time,
     * possibly because it is in some kind of composition, it has to be decided
     * whether to keep the mapping or insert a new mapping entry. The following
     * policies override other policies: CUSTOM overrides REF_COPY and STOP;
     * FULL_COPY overrides REF_COPY and STOP; REF_COPY overrides STOP; STOP does
     * not override any policy.
     * 
     * @param originalPolicy The modified policy stored in the mapping table
     * @param newPolicy The modified policy returned by the policy handler for
     * the current
     * @return If the new policy overrides the originalPolicy
     */
    private boolean overridesPolicy( DeepCopyPolicyOption originalPolicy, DeepCopyPolicyOption newPolicy ) {

        switch ( newPolicy ) {
            case STOP:
                return false;
            case REF_COPY:
                return originalPolicy == DeepCopyPolicyOption.STOP;
            case FULL_COPY:
                return originalPolicy == DeepCopyPolicyOption.REF_COPY || originalPolicy == DeepCopyPolicyOption.STOP;
            case CUSTOM:
                return newPolicy != DeepCopyPolicyOption.FULL_COPY;
        }
        return false;
    }

    /**
     * Copies an element, depending on the policy provided, and creates an entry
     * in the mapping table. If an entry already exists, it is overwritten in
     * order to avoid duplicate elements in the copied set and the linked set.
     * 
     * @param copyMap The mapping table which is altered during copying
     * @param elementToBeCopied The element which is to be copied
     * @param policyForElement The standard policy for copying (after altered by
     * the PolicyHandler)
     * @param originalPolicy The original policy for copying (before altered by
     * the PolicyHandler)
     */
    private void mapElement( DeepCopyMapImpl copyMap, RefObject elementToBeCopied, DeepCopyPolicy originalPolicy, DeepCopyPolicy policyForElement ) {

        DeepCopyPolicyOption policyOptionForElement = policyForElement.getDeepCopyPolicyOption( );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "mapElement() : elementToBeCopied=" + elementToBeCopied + " policyOptionForElement=" + policyOptionForElement ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        switch ( policyOptionForElement ) {
            case STOP:
                // STOP: add to map with null as target
                copyMap.put( elementToBeCopied, new DeepCopyMappingEntry( originalPolicy, policyForElement, null ) );
                break;
            case REF_COPY:
                // REF: add to map with element in the actual connection. 
                RefObject mappingTarget = (RefObject) inLocalConnection( elementToBeCopied );
                if ( mappingTarget == null ) {
                    // If the element is not visible from the actual connection, log error
                    copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_009, ( (Partitionable) elementToBeCopied ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                }
                copyMap.put( elementToBeCopied, new DeepCopyMappingEntry( originalPolicy, policyForElement, mappingTarget ) );
                break;
            case FULL_COPY:
                // COPY: add to map with a copy of the element
                copyMap.put( elementToBeCopied, new DeepCopyMappingEntry( originalPolicy, policyForElement, copySingleObject( elementToBeCopied ) ) );
                break;
            case CUSTOM:
                // COPY: add to map with the provided custom element
                RefObject customElement = policyForElement.getCustomElement( );
                RefObject customElementInCurrentConnection = (RefObject) this.inLocalConnection( customElement );
                if ( customElementInCurrentConnection != null ) {
                    // As the customElement is to be used as target, it MUST be accessible in the currentConnection!
                    if ( conformsToJmiType( customElementInCurrentConnection, elementToBeCopied ) ) {
                        copyMap.put( elementToBeCopied, new DeepCopyMappingEntry( originalPolicy, policyForElement, customElementInCurrentConnection ) );
                    } else {
                        copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_006, ( (Partitionable) customElement ).get___Mri( ), null, null, "" ) ); //$NON-NLS-1$
                    }
                } else {
                    copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_010, null, null, null, "" ) ); //$NON-NLS-1$
                }
                break;
        }
    }

    /**
     * For the Set of copied elements, create links. The copied elements are
     * determined from the key set of the mapping table.
     * 
     * @param elementsToBeCopied
     * @param copyMap
     * @throws JmiException
     */

    private void createLinksForCopiedElements( DeepCopyMapImpl copyMap, boolean includeExternalCompositeParents ) {

        DeepCopyMappingEntry entry;

        Set<Entry<MRI, DeepCopyMappingEntry>> entrySet = copyMap.entrySet( );
        for ( Entry<MRI, DeepCopyMappingEntry> mapEntry : entrySet ) {
            MRI originalElementMri = mapEntry.getKey( );
            CoreConnection connectionOfOriginalElement = this.elementsToBeCopied.get( originalElementMri );
            RefObject originalElement = (RefObject) connectionOfOriginalElement.getElement( originalElementMri );
            entry = mapEntry.getValue( );
            RefObject mappedOriginalElement = entry.getMappingTarget( );
            // only create links for fully copied elements
            if ( entry.getModifiedPolicy( ).getDeepCopyPolicyOption( ) == DeepCopyPolicyOption.FULL_COPY ) {

                // get all association ends
                for ( AssociationEnd elemAssocEnd : getAssociationEnds( originalElement ) ) {

                    // check if composite parents are copied; if not, check if
                    // association is composite
                    if ( includeExternalCompositeParents || !( ( (AssociationEndImpl) elemAssocEnd ).otherEnd( myConn ).getAggregation( ).equals( AggregationKindEnum.COMPOSITE ) ) ) {

                        // get associated elements
                        RefAssociation origAssoc = getRefAssociationForEnd( elemAssocEnd, originalElement );
                        if ( origAssoc != null ) {
                            // TODO: It seems like this is not really necessary!
                            RefAssociationImpl actualAssoc = (RefAssociationImpl) inLocalConnection( origAssoc );                            
                        	
                            // If the association is supposed to be ordered: delete
                            // existing links of the COPY because those might have been created in the wrong order	
                            if (elemAssocEnd.otherEnd().getMultiplicity().isOrdered()) {
                                Collection<RefObject> newlyCreatedElements = getElementsForRefAssociation( myConn, actualAssoc, elemAssocEnd, mappedOriginalElement );
                                if ( newlyCreatedElements != null ) {
                                    for (RefObject otherElement : newlyCreatedElements) {
                                        if ( myConn.getCoreJmiHelper( ).isFirstAssociationEnd( myConn, (Association) ( (AssociationEndImpl) elemAssocEnd ).getContainer( myConn ), elemAssocEnd ) &&
                                        	actualAssoc.refLinkExists( myConn, mappedOriginalElement, otherElement)) {
                                            actualAssoc.refRemoveLink( myConn, mappedOriginalElement, otherElement );
                                        } else if (actualAssoc.refLinkExists( myConn, otherElement, mappedOriginalElement)){
                                            actualAssoc.refRemoveLink( myConn, otherElement, mappedOriginalElement );
                                        }
                                    }
                                }  
                            }
                            
                            Collection<RefObject> elements = getElementsForRefAssociation( origAssoc, elemAssocEnd, originalElement );
                            if ( elements != null ) {
                                Iterator<RefObject> it = null;
                                it = elements.iterator( );

                                while ( it.hasNext( ) ) {
                                    RefObject associatedElement = it.next( );
                                    //DRA: We have to check for null, because dangling links 2n
                                    // return a null
                                    if ( associatedElement != null && copyMap.containsKey( associatedElement ) ) {

                                        RefObject mappedAssociatedElement = copyMap.get( associatedElement ).getMappingTarget( );
                                        if ( mappedAssociatedElement != null ) {

                                            // create association
                                            try {
                                                // find the direction in which the
                                                // association has to be created

                                                if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                                                    logger.trace( MoinSeverity.DEBUG, "link created : origAssoc=" + origAssoc + " mappedOriginalElement=" + mappedOriginalElement + " mappedAssociatedElement=" + mappedAssociatedElement ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                                }

                                                if ( myConn.getCoreJmiHelper( ).isFirstAssociationEnd( myConn, (Association) ( (AssociationEndImpl) elemAssocEnd ).getContainer( myConn ), elemAssocEnd ) ) {
                                                    actualAssoc.refAddLink( myConn, mappedOriginalElement, mappedAssociatedElement );
                                                } else {
                                                    actualAssoc.refAddLink( myConn, mappedAssociatedElement, mappedOriginalElement );
                                                }
                                                // error handling
                                            } catch ( WrongSizeException e ) {
                                                copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_007, ( (Partitionable) mappedOriginalElement ).get___Mri( ), ( (Partitionable) mappedAssociatedElement ).get___Mri( ).getLri( ), null, e.getMessage( ) ) );
                                            } catch ( PartitionChangingNotPossibleException e ) {
                                                copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_008, ( (Partitionable) mappedOriginalElement ).get___Mri( ), ( (Partitionable) mappedAssociatedElement ).get___Mri( ).getLri( ), e.getPri( ), e.getMessage( ) ) );
                                            } catch ( RuntimeException e ) {
                                                copyErrors.add( new DeepCopyError( DeepCopyErrorType.ERR_001, ( (Partitionable) mappedOriginalElement ).get___Mri( ), ( (Partitionable) mappedAssociatedElement ).get___Mri( ).getLri( ), null, e.getMessage( ) ) );
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for ( Attribute attr : getObjectValuedAttributes( originalElement ) ) {
                    Object value = ( (RefFeaturedImpl) originalElement ).refGetValue( connectionOfOriginalElement, attr );
                    if ( value instanceof Collection ) {
                        JmiList<RefObject> values = (JmiList<RefObject>) value;
                        if ( !values.isEmpty( connectionOfOriginalElement.getSession( ) ) ) {
                            JmiList<RefObject> newCollection = (JmiList<RefObject>) ( (RefFeaturedImpl) mappedOriginalElement ).refGetValue( myConn, attr );
                            for ( Iterator<RefObject> it = values.iteratorReadOnly( connectionOfOriginalElement.getSession( ) ); it.hasNext( ); ) {
                                RefObject val = it.next( );
                                RefObject mappedAssociatedElement = copyMap.get( val ).getMappingTarget( );
                                if ( mappedAssociatedElement != null ) {
                                    newCollection.add( myConn, mappedAssociatedElement );
                                }
                            }
                        }
                    } else if ( value != null ) {
                        RefObject mappedAssociatedElement = copyMap.get( (RefObject) value ).getMappingTarget( );
                        if ( mappedAssociatedElement != null ) {
                            ( (RefFeaturedImpl) mappedOriginalElement ).refSetValue( myConn, attr, mappedAssociatedElement );
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns a copy of a single RefObject that is not identical to the
     * original object, so that {@link java.lang.Object.equals()} will evaluate
     * to false, but all primitive attribute values will be identical. If the
     * RefObject has object-valued attributes, the copy will contain copies of
     * the original objects.
     */
    private RefObject copySingleObject( RefObject elementToBeCopied ) {

        // Calculate constructor arguments
        List<Object> args = new ArrayList<Object>( );
        List<Attribute> attrs = myConn.getCoreJmiHelper( ).getAttributes( myConn.getSession( ), elementToBeCopied.refClass( ).refMetaObject( ), true );
        for ( Attribute attr : attrs ) {
            if ( !attr.isDerived( ) ) {
                Classifier type = myConn.getCoreJmiHelper( ).getNonAliasType( myConn.getSession( ), attr );
                if ( type instanceof MofClass ) {
                    args.add( null );
                } else {
                    args.add( copyAttribute( elementToBeCopied, attr ) );
                }
            }
        }

        // get the class factory for the actual connection
        RefClassImpl metaFact = (RefClassImpl) ( myConn.getElement( elementToBeCopied.refClass( ).get___Mri( ) ) );

        // Create the copy
        RefObject newObject = metaFact.refCreateInstance( myConn, args );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "copySingleObject() : elementToBeCopied=" + elementToBeCopied + " newObject=" + newObject ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        return newObject;
    }

    /**
     * Returns a copy of a single translatable text fragment.
     * <p>
     * The copy has the field transUnitId set newly.
     */
    private RefStructImpl copySingleTranslatableText( RefStructImpl elementToBeCopied, CoreConnection conn ) {

        // create a new container and put all field content into it
        StructureFieldContainer<RefStructImpl> cont = new StructureFieldContainer<RefStructImpl>( ).put( elementToBeCopied );
        // overwrite the content of the field "transUnitId" with a new GUID
        cont.put( StructureFieldDescriptor.getDescriptor( elementToBeCopied, "transUnitId" ), MoinMetamodelCode.createGUID( ) ); //$NON-NLS-1$
        // create the translatable text copy
        RefStructImpl newStruct = conn.getCoreJmiHelper( ).cloneStruct( conn, elementToBeCopied, cont );
        // log a bit
        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            logger.trace( MoinSeverity.DEBUG, "copySingleTranslatableText() : elementToBeCopied=" + elementToBeCopied + " newStruct=" + newStruct ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        // return the copy
        return newStruct;
    }

    /**
     * Returns a copy of an Attribute. In case of primitive, enumeration and
     * structure type attributes, the attribute value is returned. In case of
     * object valued attributes, a copy of the object is returned. In case of
     * translatable text fragment attributes, the field transUnitId is set
     * newly.
     */
    private Object copyAttribute( RefObject elementToBeCopied, Attribute attribute ) {

        AttributeInternal attr = (AttributeInternal) attribute;
        Classifier type = attr.getType( null );
        CoreConnection conn = elementsToBeCopied.get( elementToBeCopied.get___Mri( ) );
        if ( type instanceof PrimitiveType ) {
            return ( (RefFeaturedImpl) elementToBeCopied ).refGetValue( conn, attr );
        } else if ( type instanceof EnumerationType ) {
            return ( (RefFeaturedImpl) elementToBeCopied ).refGetValue( conn, attr );
        } else if ( type instanceof StructureType ) {
            // structure valued attribute
            Object etbc = ( (RefObjectImpl) elementToBeCopied ).refGetValue( conn, attr );
            if ( etbc != null ) {
                if ( conn.getCoreJmiHelper( ).isTranslatableTextFragment( conn.getSession( ), (StructureType) type ) ) {
                    // we have a translateble text fragment here
                    if ( attr.getMultiplicity( ).getUpper( ) >= 0 && attr.getMultiplicity( ).getUpper( ) <= 1 ) {
                        // single-valued attribute
                        return copySingleTranslatableText( (RefStructImpl) etbc, conn );
                    } else {
                        // multi-valued attribute
                        MultiValuedAttributesList<?> mvAttrEtbc = (MultiValuedAttributesList<?>) etbc;
                        Collection<RefStructImpl> mvAttr = new ArrayList<RefStructImpl>( mvAttrEtbc.size( ) );
                        Iterator<?> iterator = mvAttrEtbc.iterator( conn );
                        while ( iterator.hasNext( ) ) {
                            mvAttr.add( copySingleTranslatableText( (RefStructImpl) iterator.next( ), conn ) );
                        }
                        return mvAttr;
                    }
                } else {
                    return etbc;
                }
            }
        } else {
            // object valued attribute
            Object etbc = ( (RefObjectImpl) elementToBeCopied ).refGetValue( conn, attr );
            if ( etbc != null ) {
                if ( attr.getMultiplicity( ).getUpper( ) >= 0 && attr.getMultiplicity( ).getUpper( ) <= 1 ) {
                    // single-valued attribute
                    return copySingleObject( (RefObjectImpl) etbc );
                } else {
                    // multi-valued attribute
                    JmiList<?> jmiListEtbc = (JmiList<?>) etbc;
                    Collection<RefObject> mvAttr = new ArrayList<RefObject>( jmiListEtbc.size( conn.getSession( ) ) );
                    Iterator<?> iteratorReadOnly = jmiListEtbc.iteratorReadOnly( conn.getSession( ) );
                    while ( iteratorReadOnly.hasNext( ) ) {
                        mvAttr.add( copySingleObject( (RefObjectImpl) iteratorReadOnly.next( ) ) );
                    }
                    return mvAttr;
                }
            }
        }
        return null;
    }

    /**
     * Find all AssociationEnds that have as type the element's type or a
     * supertype
     * 
     * @param element
     * @return the AssociationEnds whose type is equal or a supertype of the
     * element's type
     */

    private Collection<AssociationEnd> getAssociationEnds( RefObject element ) {

        return myConn.getCoreJmiHelper( ).getAssociationEnds( myConn.getSession( ), (MofClass) ( element.refMetaObject( ) ), true );
    }

    private Collection<Attribute> getObjectValuedAttributes( RefObject element ) {

        return myConn.getCoreJmiHelper( ).getAllObjectValuedAttributes( myConn.getSession( ), (MofClass) element.refMetaObject( ) );
    }

    /**
     * Find the non-derived association element for an AssociationEnd and a
     * certain element
     * 
     * @param element
     * @return the JMI proxies of all associations that point to the element
     */

    private RefAssociation getRefAssociationForEnd( AssociationEnd associationEnd, RefObject element ) {

        RefAssociation associationForElement = null;
        if ( !( associationEnd == null ) ) {
            Association ass = (Association) ( ( (AssociationEndImpl) associationEnd ).getContainer( myConn ) );
            if ( !( ass.isDerived( ) ) ) {
                associationForElement = myConn.getCoreJmiHelper( ).getRefAssociationForAssociation( myConn.getSession( ), ass );
            }
        }
        return associationForElement;
    }

    /**
     * Returns all immediate composite children of a RefObject. In case the
     * element does not have composite children, an empty set is returned. Note
     * that dangling children are returned as null!
     * 
     * @param element The parent element
     * @return All immediate composite children of a RefObject
     */

    private Set<RefObject> getCompositeChildrenImmediate( RefObject element ) {

        // TODO: Check if this method returns the children as seen from the element connection or from the actual connection! 
        Set<RefObject> immediateChildren = new HashSet<RefObject>( );

        RefAssociation actualAssoc;

        for ( AssociationEnd elemAssocEnd : getAssociationEnds( element ) ) {
            if ( elemAssocEnd.getAggregation( ).equals( AggregationKindEnum.COMPOSITE ) ) {
                actualAssoc = getRefAssociationForEnd( elemAssocEnd, element );
                // actualAssoc can be null when derived!
                if ( actualAssoc != null ) {
                    Collection<RefObject> children = getElementsForRefAssociation( actualAssoc, elemAssocEnd, element );
                    if ( children != null ) {
                        immediateChildren.addAll( children );
                    }
                }
            }
        }

        CoreConnection originalConnection = elementsToBeCopied.get( element.get___Mri( ) );
        assert originalConnection != null : "Connection is null"; //$NON-NLS-1$

        List<Attribute> attrs = originalConnection.getCoreJmiHelper( ).getAllObjectValuedAttributes( originalConnection.getSession( ), element.refClass( ).refMetaObject( ) );
        for ( int i = 0, n = attrs.size( ); i < n; i++ ) {
            Attribute attr = attrs.get( i );
            Object value = ( (RefFeaturedImpl) element ).refGetValue( originalConnection, attr );
            if ( value instanceof Collection ) {
                JmiList<RefObject> values = (JmiList<RefObject>) value;
                for ( Iterator<RefObject> it = values.iteratorReadOnly( originalConnection.getSession( ) ); it.hasNext( ); ) {
                    RefObject val = it.next( );
                    if ( val != null ) { // filter out dangling links
                        elementsToBeCopied.put( val.get___Mri( ), originalConnection );
                        immediateChildren.add( val );
                    }
                }
            } else if ( value != null ) {
                elementsToBeCopied.put( ( (RefObject) value ).get___Mri( ), originalConnection );
                immediateChildren.add( (RefObject) value );
            }
        }
        return immediateChildren;
    }

    /**
     * Returns all elements that are linked to a RefObject via a RefAssociation
     * at an AssociationEnd
     * 
     * @param actualAssoc
     * @param elemAssocEnd
     * @param originalElement
     * @return
     */
    private Collection<RefObject> getElementsForRefAssociation( RefAssociation actualAssoc, AssociationEnd elemAssocEnd, RefObject originalElement ) {
        CoreConnection originalConnection = elementsToBeCopied.get( originalElement.get___Mri( ) );
        assert originalConnection != null : "Connection is null"; //$NON-NLS-1$
        return getElementsForRefAssociation(originalConnection, actualAssoc, elemAssocEnd, originalElement);
           
    }
    
    /**
     * Returns all elements that are linked to a RefObject via a RefAssociation
     * at an AssociationEnd
     * 
     * @param originalConnection
     * @param actualAssoc
     * @param elemAssocEnd
     * @param originalElement
     * @return
     */
    private Collection<RefObject> getElementsForRefAssociation( CoreConnection originalConnection, RefAssociation actualAssoc, AssociationEnd elemAssocEnd, RefObject originalElement ) {
        try {
            assert originalConnection != null : "Connection is null"; //$NON-NLS-1$
            JmiListImpl<RefObject> links = (JmiListImpl<RefObject>) ( (RefAssociationImpl) actualAssoc ).refQuery( originalConnection, elemAssocEnd.getName( ), originalElement );
            Collection<RefObject> result = new ArrayList<RefObject>( links.size( originalConnection.getSession( ) ) );
            for ( Iterator<RefObject> it = links.iterator( originalConnection ); it.hasNext( ); ) {
                RefObject element = it.next( );
                if ( element != null ) {//only consider non-dangling links
                    result.add( element );
                    elementsToBeCopied.put( element.get___Mri( ), originalConnection );
                }
            }
            return result;
        } catch ( UnresolvableException e ) {
            //can happen if we mix unwrapped elements from different connections!!!
            return null;
        }
    }

    /**
     * Returns all elements that are linked to a RefObject, but not composite
     * children. Note that dangling links return a null!
     * 
     * @param element The original element
     * @return All linked elements
     */

    private Set<RefObject> getAllLinkedElements( RefObject element ) {

        Set<RefObject> linkedElements = new HashSet<RefObject>( );
        RefAssociation actualAssoc;
        for ( AssociationEnd elemAssocEnd : getAssociationEnds( element ) ) {
            if ( !( elemAssocEnd.getAggregation( ).equals( AggregationKindEnum.COMPOSITE ) ) ) {
                actualAssoc = getRefAssociationForEnd( elemAssocEnd, element );
                // actualAssoc can be null when derived!
                if ( actualAssoc != null ) {
                    Collection<RefObject> elements = getElementsForRefAssociation( actualAssoc, elemAssocEnd, element );
                    if ( elements != null ) {
                        linkedElements.addAll( elements );
                    }
                }
            }
        }
        return linkedElements;
    }

    private boolean conformsToJmiType( RefObject conformingObject, RefObject toObject ) {

        return ( (RefObjectImpl) conformingObject ).refIsInstanceOf( myConn.getSession( ), toObject.refMetaObject( ), true );
    }

    private RefBaseObject inLocalConnection( Partitionable o ) {

        if ( o == null ) {
            return null;
        }

        return myConn.getElement( o.get___Mri( ) );
    }
}
