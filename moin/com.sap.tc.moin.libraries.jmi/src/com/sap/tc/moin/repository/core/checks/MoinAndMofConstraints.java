package com.sap.tc.moin.repository.core.checks;

import static com.sap.tc.moin.repository.core.jmi.util.JmiHelperImpl.JMI_TAG_ID_PACKAGE_PREFIX;
import static com.sap.tc.moin.repository.core.jmi.util.JmiHelperImpl.JMI_TAG_ID_SUBSTITUTE_NAME;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TagInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.checks.JavaCodedConstraintRegistration.Constraints;
import com.sap.tc.moin.repository.core.jmi.reflect.RefBaseObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

/**
 * The hard-coded MOIN and MOF constraints
 */
public class MoinAndMofConstraints {

    private final CoreConnection myConnection;

    final static OclDebuggerNode UNSUPPORTEDNODE;

    static {
        UNSUPPORTEDNODE = new OclDebuggerNode( ) {

            public Object getResultValue( ) throws InvalidValueException {

                return "Can not return the debugger tree as the constraint is not an OCL constraint"; //$NON-NLS-1$
            }

            public String getOclExpression( ) {

                return ""; //$NON-NLS-1$
            }

            public NodeValueTypes getNodeValueType( ) {

                return NodeValueTypes.String;
            }

            public NodeRoleTypes getNodeRole( ) {

                return NodeRoleTypes.Unknown;
            }

            public String getNodeName( ) {

                return "<No name>"; //$NON-NLS-1$
            }

            public OclDebuggerNode[] getChildren( ) {

                return new OclDebuggerNode[0];
            }
        };
    }

    final static class ViolationStatusImpl implements DeferredConstraintViolationStatusItem {

        private final JavaCodedConstraintRegistration myRegistration;

        private final String myMessage;

        private final MRI myMri;

        private MoinLocalizedString myPattern;

        private Object[] myArgs;

        ViolationStatusImpl( MRI actMri, final JavaCodedConstraintRegistration.Constraints constraint, MoinLocalizedString actMessage, Object... args ) {

            this.myMessage = actMessage.format( args );
            this.myMri = actMri;
            this.myPattern = actMessage;
            this.myArgs = args;

            this.myRegistration = new JavaCodedConstraintRegistration( ) {

                public OclRegistrationType getType( ) {

                    return OclRegistrationType.JavaConstraint;
                }

                public OclRegistrationSeverity getSeverity( ) {

                    return OclRegistrationSeverity.Error;
                }

                public String getOclExpression( ) {

                    // TODO devise a proper interface hierarchy
                    throw new MoinUnsupportedOperationException( "getOclExpression" ); //$NON-NLS-1$
                }

                public String getName( ) {

                    return constraint.name( );
                }

                public Set<String> getCategories( ) {

                    Set<String> result = new HashSet<String>( );
                    result.add( OclRegistrationCategory.deferred.name( ) );
                    result.add( OclRegistrationCategory.virtual.name( ) );
                    return result;
                }

            };
        }

        public OclRegistration getConstraintRegistration( ) {

            return this.myRegistration;
        }

        public String getConstraintViolationMessage( ) {

            return this.myMessage;
        }

        public String getLocalizedConstraintViolationMessage( ) {

            return getConstraintViolationMessage( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );
        }

        public String getConstraintViolationMessage( Locale locale ) {

            try {
                String pattern = this.myPattern.getLocalizedMessage( locale );
                if ( this.myArgs != null && this.myArgs.length > 0 ) {
                    MessageFormat format = new MessageFormat( pattern, locale );
                    return format.format( this.myArgs );
                }
                return pattern;
            } catch ( Exception e ) {
                return this.myMessage;
            }
        }

        public OclDebuggerNode getDebuggerTree( ) throws OclManagerException {

            return UNSUPPORTEDNODE;
        }

        public OclManagerException getOclManagerException( ) {

            return null;
        }

        public MRI getOffendingMRI( ) {

            return this.myMri;
        }

        public boolean oclExceptionOccurred( ) {

            return false;
        }
    }

    /**
     * @param connection the current connection
     */
    public MoinAndMofConstraints( CoreConnection connection ) {

        this.myConnection = connection;
    }

    /**
     * Checks the manual (hard-coded) constraints
     * 
     * @param objectToCheck object
     * @param alreadyChecked already checked (to avoid duplicate messages)
     * @param category categories
     * @return a List of JmiExceptions, may be empty but never null
     */
    public List<DeferredConstraintViolationStatusItem> checkManualConstraints( RefBaseObject objectToCheck, Map<StructuralFeature, Set<RefBaseObject>> alreadyChecked, OclRegistrationCategory... category ) {

        List<DeferredConstraintViolationStatusItem> result = new ArrayList<DeferredConstraintViolationStatusItem>( );

        boolean checkImmediate = false;
        boolean checkDeferred = false;

        for ( int i = 0; i < category.length; i++ ) {
            switch ( category[i] ) {
                case immediate:
                    checkImmediate = true;
                    break;
                case deferred:
                    checkDeferred = true;
                    break;
                default:
                    break;
            }
        }

        ModelElement metaObject = (ModelElement) objectToCheck.refMetaObject( );

        if ( checkDeferred ) {

            SpiJmiHelper jmiHelper = this.myConnection.getCoreJmiHelper( );

            // underflow / overflow of attributes and references
            // we don't need to check parameter multiplicity here (this
            // is just used for JMI generation)

            for ( Object o : jmiHelper.getAllContent( this.myConnection, metaObject ) ) {
                if ( o instanceof StructuralFeature ) {
                    Set<RefBaseObject> objects = alreadyChecked.get( o );
                    if ( objects == null ) {
                        objects = new HashSet<RefBaseObject>( );
                        alreadyChecked.put( (StructuralFeature) o, objects );
                    }
                    if ( objectToCheck instanceof RefFeatured && !objects.contains( objectToCheck ) ) {
                        checkMultiplicity( (StructuralFeature) o, (RefFeatured) objectToCheck, result );
                        objects.add( objectToCheck );
                    }
                }
            }

            // Check if at least one end has storage
            if ( objectToCheck instanceof Association ) {
                Association assoc = (Association) objectToCheck;
                List<AssociationEnd> ends = jmiHelper.getAssociationEnds( this.myConnection.getSession( ), assoc );
                boolean storage = false;
                for ( AssociationEnd end : ends ) {
                    storage = storage || jmiHelper.isEndStored( this.myConnection.getSession( ), end );
                }
                if ( !storage ) {
                    result.add( new ViolationStatusImpl( ( (Partitionable) assoc ).get___Mri( ), Constraints.MustHaveStorageOnOneEnd, CoreChecks.NOSTORAGEONEITHEREND ) );
                }
            }

            // Check if double storage has been used
            if ( objectToCheck instanceof Association ) {
                Association assoc = (Association) objectToCheck;
                List<AssociationEnd> ends = jmiHelper.getAssociationEnds( this.myConnection.getSession( ), assoc );
                int storageCount = 0;
                for ( AssociationEnd end : ends ) {
                    if ( jmiHelper.isEndStored( this.myConnection.getSession( ), end ) ) {
                        storageCount++;
                    }
                }
                if ( storageCount > 1 ) {
                    result.add( new ViolationStatusImpl( ( (Partitionable) assoc ).get___Mri( ), Constraints.NoDoubleStorage, CoreChecks.STORAGEONONEENDMAX ) );
                }
            }

            // Check if we have a cross-metamodel association where the MofClass at the storage end is in a different
            // metamodel than the association.
            if ( objectToCheck instanceof Association ) {
                Association assoc = (Association) objectToCheck;
                List<AssociationEnd> ends = jmiHelper.getAssociationEnds( this.myConnection.getSession( ), assoc );
                CRI criOfAssociation = ( (Partitionable) assoc ).get___Mri( ).getCri( );
                for ( AssociationEnd end : ends ) {
                    if ( jmiHelper.isEndStored( this.myConnection.getSession( ), end ) ) {
                        CRI criOfMofClass = ( (Partitionable) ( (MofClass) ( (AssociationEndInternal) end ).getType( this.myConnection ) ) ).get___Mri( ).getCri( );
                        if ( !criOfAssociation.equals( criOfMofClass ) ) {
                            result.add( new ViolationStatusImpl( ( (Partitionable) assoc ).get___Mri( ), Constraints.NoStorageInOtherMetamodel, CoreChecks.ASSOCMUSTSTOREINITSMETAMODEL ) );
                        }
                    }
                }
            }

            // Check if a substitute name is used
            if ( objectToCheck instanceof TagInternal && ( (TagInternal) objectToCheck ).getTagId( ).equals( JMI_TAG_ID_SUBSTITUTE_NAME ) ) {
                TagInternal substituteNameTag = (TagInternal) objectToCheck;
                result.add( new ViolationStatusImpl( ( (Partitionable) objectToCheck ).get___Mri( ), Constraints.NoSubstituteNames, CoreChecks.NOSUBSTITUTENAMETAGS, substituteNameTag.getQualifiedName( this.myConnection ) ) );
            }

            // Check if a package prefix is used for non-toplevel packages
            if ( objectToCheck instanceof MofPackageInternal && ( (MofPackageInternal) objectToCheck ).getContainer( this.myConnection ) != null && jmiHelper.getTag( this.myConnection.getSession( ), ( (MofPackage) objectToCheck ), JMI_TAG_ID_PACKAGE_PREFIX ) != null ) {
                MofPackage nonToplevelPackage = (MofPackage) objectToCheck;
                result.add( new ViolationStatusImpl( ( (Partitionable) objectToCheck ).get___Mri( ), Constraints.PackagePrefixOnlyForToplevelPackage, CoreChecks.PACKAGEPREFIXONLYFORTOPLEVELPACKAGES, nonToplevelPackage.getQualifiedName( ) ) );
            }
        }

        if ( checkImmediate ) {
            // TODO move the MMC-09 to an OCL constraint
            if ( objectToCheck instanceof ModelElement ) {
                ModelElement me = (ModelElement) objectToCheck;
                result.addAll( this.mmc08( me ) );
            }

            RefBaseObjectImpl rbo = (RefBaseObjectImpl) objectToCheck;
            if ( rbo.get___Workspace( ) == null ) {
                result.add( new ViolationStatusImpl( ( (Partitionable) rbo ).get___Mri( ), Constraints.WorkspaceNotNull, CoreChecks.WORKSPACENOTNULL ) );
            }
            if ( rbo.refMofId( ) == null ) {
                result.add( new ViolationStatusImpl( ( (Partitionable) rbo ).get___Mri( ), Constraints.WorkspaceNotNull, CoreChecks.MOFIDNOTNULL ) );
            }
            if ( rbo.refImmediatePackage( ) == null ) {
                // ConstraintViolationException expected by JmiTCK Test
                result.add( new ViolationStatusImpl( ( (Partitionable) rbo ).get___Mri( ), Constraints.WorkspaceNotNull, CoreChecks.IMMEDIATEPACKAGENOTNULL ) );
            }
            RefObject roMetaObject = rbo.refMetaObject( );
            if ( roMetaObject == null ) {
                result.add( new ViolationStatusImpl( ( (Partitionable) rbo ).get___Mri( ), Constraints.WorkspaceNotNull, CoreChecks.METAOBJECTNOTNULL ) );
            }
        }

        return result;
    }

    @SuppressWarnings( "unchecked" )
    private void checkMultiplicity( StructuralFeature sf, RefFeatured ro, List<DeferredConstraintViolationStatusItem> resultList ) {

        int lower = sf.getMultiplicity( ).getLower( );
        int upper = sf.getMultiplicity( ).getUpper( );
        if ( lower == 0 && upper == -1 ) {
            // multiplicity = 0..infinity
            // no check necessary, the number of elements is always between 0 and infinity
            return;
        }
        ScopeKindEnum expectedScope;
        if ( ro instanceof RefObject ) {
            expectedScope = ScopeKindEnum.INSTANCE_LEVEL;
        } else {
            expectedScope = ScopeKindEnum.CLASSIFIER_LEVEL;
        }
        if ( sf.getVisibility( ) != VisibilityKindEnum.PUBLIC_VIS || sf.getScope( ) != expectedScope ) {
            return;
        }
        Object value = ( (RefFeaturedImpl) ro ).refGetValue( this.myConnection, sf.getName( ) );
        if ( lower == 1 && upper == 1 && value == null ) {
            resultList.add( new ViolationStatusImpl( ( (Partitionable) ro ).get___Mri( ), Constraints.Underflow, CoreChecks.NOVALUEFORMANDATORYFEATURE, sf.getName( ) ) );
            return;
        }
        int size = 0;
        if ( value != null ) {
            if ( value instanceof Collection ) {
                if ( value instanceof JmiList ) {
                    size = ( (JmiList) value ).size( this.myConnection.getSession( ) );
                } else {
                    size = ( (Collection) value ).size( );
                }
            } else {
                size = 1;
            }
        }
        if ( upper > 0 && size > upper ) {
            resultList.add( new ViolationStatusImpl( ( (Partitionable) ro ).get___Mri( ), Constraints.Overflow, CoreChecks.OVERFLOW, sf.getName( ), Integer.valueOf( upper ), Integer.valueOf( size ) ) );
        }
        if ( lower > 0 && size < lower ) {
            resultList.add( new ViolationStatusImpl( ( (Partitionable) ro ).get___Mri( ), Constraints.Underflow, CoreChecks.UNDERFLOW, sf.getName( ), Integer.valueOf( lower ), Integer.valueOf( size ) ) );
        }
    }

    /**
     * Checks the MMC-08 constraint (valid chars for name)
     */
    private List<DeferredConstraintViolationStatusItem> mmc08( ModelElement modelElement ) {

        List<DeferredConstraintViolationStatusItem> result = new ArrayList<DeferredConstraintViolationStatusItem>( );
        if ( !ModelElementNameAnalyzer.isValidModelElementName( this.myConnection, modelElement ) ) {
            result.add( new ViolationStatusImpl( ( (Partitionable) modelElement ).get___Mri( ), Constraints.ValidName, CoreChecks.INVALIDNAME, modelElement.getName( ) ) );
        }
        return result;
    }
}
