package com.sap.tc.moin.repository.core.jmi.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.DependsOn;
import com.sap.tc.moin.repository.mmi.model.Exposes;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.NameNotResolvedException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.DependsOnInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ExposesInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.RefersToInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.extension.RefAssociationExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectWrapperImpl;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * This class contains the code for the modeled operations of MOF.
 * <p>
 * It contains always 2 flavors of the code. One is called from the internal
 * implementations (*Impl classes) and one from the wrappers (*Wrapper classes).
 * The wrapper code calls the ones for the Impls and unwraps only the this
 * pointers. Note that the operation arguments are unwrapped in the wrapper
 * itself just before the methods here are called.
 */

public class MoinMetamodelCode {

    private static Set<String> allDependencyKinds = new HashSet<String>( 10 );
    static {
        allDependencyKinds.add( ModelElement.CONSTRAINTDEP );
        allDependencyKinds.add( ModelElement.CONTAINERDEP );
        allDependencyKinds.add( ModelElement.CONSTRAINEDELEMENTSDEP );
        allDependencyKinds.add( ModelElement.SPECIALIZATIONDEP );
        allDependencyKinds.add( ModelElement.IMPORTDEP );
        allDependencyKinds.add( ModelElement.CONTENTSDEP );
        allDependencyKinds.add( ModelElement.SIGNATUREDEP );
        allDependencyKinds.add( ModelElement.TAGGEDELEMENTSDEP );
        allDependencyKinds.add( ModelElement.TYPEDEFINITIONDEP );
        allDependencyKinds.add( ModelElement.REFERENCEDENDSDEP );
    }

    //--------------- ModelElement----------------------

    public static List<String> getQualifiedName( CoreConnection connection, ModelElement element, RefObjectImpl elementImpl ) throws JmiException {

        //ATTENTION: we cannot use refImmediateComposite instead of getContainer as this might
        //lead to an endless recursion in some MTI use cases.
        //TODO generate the qualified name during build instead of calculating it every time
        //during runtime

        DeploymentExtension deploymentExtension = elementImpl.get___DeploymentExtension( );
        if ( deploymentExtension != null ) {
            Map<String, List<String>> mofIdQualifiedNameMapping = deploymentExtension.getMofIdQualifiedNameMapping( );
            return mofIdQualifiedNameMapping.get( elementImpl.refMofId( ) );
        }

        ArrayList<String> result = new ArrayList<String>( 4 ); // should be enough for most qualified names
        ModelElementInternal el = (ModelElementInternal) element;
        while ( el != null ) {
            result.add( 0, el.getName( ) );
            el = (ModelElementInternal) el.getContainer( connection );
        }
        result.trimToSize( );
        return result;
    }

    /**
     * [S-4] findRequiredElements.
     * <p>
     * See MOF Spec 3.4.1.
     * <p>
     * This operation selects a subset of the ModelElements that this one
     * depends on, based on their dependency categories. The "kinds" argument
     * gives the kinds of dependency of interest to the caller. String constants
     * for the standard dependency categories are given in Section 3.8, "MOF
     * Model Constants", on page 3-82 and their meanings are defined in Section
     * 3.5.9, "DependsOn", on page 3-75. In this context, the AllDep
     * pseudocategory (i.e., "all") is equivalent to passing all of the standard
     * categories, and the IndirectDep pseudo-category (i.e., "indirect") is
     * ignored. If the "recursive" argument is "false", the operation return the
     * direct dependents only. If it is "true", all dependents in the transitive
     * closure of DependsOn for the specified "kinds" are returned.
     * <p>
     * See MOF Spec 3.9.5., corrected by SAP Labs, KA, corrected again by MOIN
     * <p>
     * Selects a subset of a ModelElementâ€™s immediate or recursive dependents.
     * 
     * <pre>
     * context ModelElement::findRequiredElements(kinds : Set(String), recursive : Boolean) : Set(ModelElement)
     *     post: result =
     *         if kinds -> includes('all')  then
     *             self.findRequiredElements(
     *               Set{'constraint', 'container', 'constrained elements', 'specialization',  'import',
     *                   'contents',   'signature', 'tagged elements',      'type definition', 'referenced ends'}, recursive)
     *         else
     *             if recursive then
     *                 self.recursiveFindDeps(kinds, Set{self})
     *             else
     *                 kinds -> collect(k | self.findDepsOfKind(k)) -> asSet()
     *             endif
     *         endif
     * </pre>
     */
    public static Collection<ModelElement> findRequiredElements( CoreConnection connection, ModelElement element, RefObjectImpl elementImpl, Collection<? extends String> kinds, boolean recursive ) throws JmiException {

        // according to the JMI spec we have a Collection as input parameter for kinds (note that multi-valued, unordered and unique parameters map to a Java Collection),
        // so we have to transform it here to a set in order to be conform to the OCL spec
        Set<String> kindsSet = new HashSet<String>( kinds );
        if ( kindsSet.contains( ModelElement.ALLDEP ) ) {
            return findRequiredElements( connection, element, elementImpl, allDependencyKinds, recursive );
        } else {
            if ( recursive ) {
                Set<ModelElement> seen = new HashSet<ModelElement>( 1 );
                seen.add( element );
                return new HashSet<ModelElement>( OclHelperFunctions.recursiveFindDepsO6( connection, element, kindsSet, seen ) );
            } else {
                Set<ModelElement> result = new HashSet<ModelElement>( );
                for ( String kind : kindsSet ) {
                    result.addAll( OclHelperFunctions.findDepsOfKindO8( connection, element, kind ) );
                }
                return result;
            }
        }
    }

    public static Collection<ModelElement> findRequiredElements( CoreConnection connection, Wrapper<? extends ModelElement> element, RefObjectWrapperImpl<? extends RefObject> elementImpl, Collection<? extends String> kinds, boolean recursive ) throws JmiException {

        Collection<ModelElement> requiredElements = findRequiredElements( connection, element.unwrap( ), (RefObjectImpl) elementImpl.unwrap( ), kinds, recursive );
        return (Collection<ModelElement>) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, requiredElements );
    }

    /**
     * [S-5] isRequiredBecause.
     * <p>
     * See MOF Spec 3.4.1.
     * <p>
     * This operation performs two functions:
     * <ul>
     * <li>It checks whether this ModelElement directly or indirectly depends on
     * the ModelElement given by "otherElement". If it does, the operations
     * result is "true", otherwise, it is "false".
     * <li>If a dependency exists, that is, the result is "true", the operation
     * returns a String in "reason" that categorizes the dependency. String
     * constants for the dependency kind categories are given in Section 3.8,
     * "MOF Model Constants", on page 3-82 and their meanings are defined in
     * Section 3.5.9, "DependsOn", on page 3-75. If the dependency is indirect,
     * IndirectDep is returned. If there are multiple dependencies, any category
     * that applies may be returned in "reason". If no dependencies exist, an
     * empty string is returned in "reason".
     * </ul>
     * <p>
     * See MOF Spec 3.9.5., corrected by SAP Labs, KA, corrected again by MOIN
     * <p>
     * Returns the DependencyKind that describes the dependency between this
     * element and "other".
     * 
     * <pre>
     * context ModelElement::isRequiredBecause(other : ModelElement, reason : out String) : Boolean
     *     -- NB, if there is more than one dependency between self
     *     -- and 'other', the selection of the 'reason' is defined
     *     -- to be non-deterministic ... not deterministic as a
     *     -- left to right evaluation of the OCL implies.
     *     post: reason = (
     *         if self -> isDepOfKind('constraint', other) then
     *             'constraint'
     *         else if self -> isDepOfKind('container', other) then
     *             'container'
     *         else if self -> isDepOfKind('constrained elements', other) then
     *             'constrained elements'
     *         else if self -> isDepOfKind('specialization', other) then
     *             'specialization'
     *         else if self -> isDepOfKind('import', other) then
     *             'import'
     *         else if self -> isDepOfKind('contents', other) then
     *             'contents'
     *         else if self -> isDepOfKind('signature', other) then
     *             'signature'
     *         else if self -> isDepOfKind('tagged elements', other) then
     *             'tagged elements'
     *         else if self -> isDepOfKind('type definition', other) then
     *             'type definition' 
     *         else if self -> isDepOfKind('referenced ends', other) then
     *             'referenced ends'
     *         else 
     *             if self.provider->notEmpty() then
     *                 'indirect'
     *             else 
     *                 ''
     *             endif
     *         endif endif endif endif endif endif endif endif endif endif)
     *         and
     *         result = (reason <> '')
     * </pre>
     */
    public static boolean isRequiredBecause( CoreConnection connection, ModelElement element, RefObjectImpl elementImpl, ModelElement otherElement, String[] reason ) throws JmiException {

        if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.CONSTRAINTDEP, otherElement ) ) {
            reason[0] = ModelElement.CONSTRAINTDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.CONTAINERDEP, otherElement ) ) {
            reason[0] = ModelElement.CONTAINERDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.CONSTRAINEDELEMENTSDEP, otherElement ) ) {
            reason[0] = ModelElement.CONSTRAINEDELEMENTSDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.SPECIALIZATIONDEP, otherElement ) ) {
            reason[0] = ModelElement.SPECIALIZATIONDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.IMPORTDEP, otherElement ) ) {
            reason[0] = ModelElement.IMPORTDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.CONTENTSDEP, otherElement ) ) {
            reason[0] = ModelElement.CONTENTSDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.SIGNATUREDEP, otherElement ) ) {
            reason[0] = ModelElement.SIGNATUREDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.TAGGEDELEMENTSDEP, otherElement ) ) {
            reason[0] = ModelElement.TAGGEDELEMENTSDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.TYPEDEFINITIONDEP, otherElement ) ) {
            reason[0] = ModelElement.TYPEDEFINITIONDEP;
        } else if ( OclHelperFunctions.isDepOfKindO7( connection, element, ModelElement.REFERENCEDENDSDEP, otherElement ) ) {
            reason[0] = ModelElement.REFERENCEDENDSDEP;
        } else {
            if ( !( (ModelElementInternal) element ).getRequiredElements( connection ).isEmpty( ) ) {
                reason[0] = ModelElement.INDIRECTDEP;
            } else {
                reason[0] = ""; //$NON-NLS-1$
            }
        }
        return !reason[0].equals( "" ); //$NON-NLS-1$
    }

    public static boolean isRequiredBecause( CoreConnection connection, Wrapper<? extends ModelElement> element, RefObjectWrapperImpl<? extends RefObject> elementImpl, ModelElement otherElement, String[] reason ) throws JmiException {

        return isRequiredBecause( connection, element.unwrap( ), (RefObjectImpl) elementImpl.unwrap( ), ( (Wrapper<? extends ModelElement>) otherElement ).unwrap( ), reason );
    }

    public static boolean isFrozen( CoreConnection connection, ModelElement element, RefObjectImpl elementImpl ) throws JmiException {

        return elementImpl.get___Workspace( ).isMetamodelWorkspace( ) ? true : false;
    }

    public static boolean isFrozen( CoreConnection connection, Wrapper<? extends ModelElement> element, RefObjectWrapperImpl<? extends RefObject> elementImpl ) throws JmiException {

        return isFrozen( connection, element.unwrap( ), (RefObjectImpl) elementImpl.unwrap( ) );
    }

    /**
     * [S-3] isVisible.
     * <p>
     * See MOF Spec 3.4.1.
     * <p>
     * Returns true. This operation is reserved for future use when the MOF
     * visibility rules have stabilized. Then it will determine whether the
     * supplied otherElement is visible to this ModelElement.
     * <p>
     * See MOF Spec 3.9.5., corrected by SAP Labs, KA
     * <p>
     * Determines whether or not "otherElement" is visible for the definition of
     * this element. (Note: As an interim measure, the OCL states that
     * everything is visible!)
     * 
     * <pre>
     * context ModelElement::isVisible(otherElement : ModelElement): Boolean
     *     post: result = true
     * </pre>
     */
    public static boolean isVisible( CoreConnection connection, ModelElement element, RefObjectImpl elementImpl, ModelElement otherElement ) throws JmiException {

        return true;
    }

    public static boolean isVisible( CoreConnection connection, Wrapper<? extends ModelElement> element, RefObjectWrapperImpl<? extends RefObject> elementImpl, ModelElement otherElement ) throws JmiException {

        return true;
//        return isVisible( connection, element.unwrap( ), (RefObjectImpl) elementImpl.unwrap( ), ( (Wrapper<? extends ModelElement>) otherElement ).unwrap( ) );
    }

    //--------------- Namespace ----------------------

    public static ModelElement lookupElement( com.sap.tc.moin.repository.core.CoreConnection connection, Namespace namespace, RefObjectImpl namespaceImpl, String name ) throws JmiException, NameNotFoundException, JmiException {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        JmiList contents = (JmiList) ( (NamespaceInternal) namespace ).getContents( connection );
        ModelElement meFound = null;
        for ( int i = 0, n = contents.size( session ); i < n; i++ ) {
            ModelElement me = (ModelElement) contents.get( session, i );
            if ( me.getName( ).equals( name ) ) {
                meFound = me;
                break;
            }
        }

        if ( WorkspaceSet.OCL_PACKAGE_NAME.equals( name ) ) {
            WorkspaceSet ws = namespaceImpl.get___Workspace( ).getWorkspaceSet( );

            if ( !ws.getMoin( ).isSecondStageInjected( ) ) {

                ws.getMoin( ).injectSecondMofRomStage( );

            }

            if ( meFound == null ) {

                contents = (JmiList) ( (NamespaceInternal) namespace ).getContents( connection );

                for ( int i = 0, n = contents.size( connection.getSession( ) ); i < n; i++ ) {
                    ModelElement me = (ModelElement) contents.get( connection.getSession( ), i );
                    if ( me.getName( ).equals( name ) ) {
                        meFound = me;
                        break;
                    }
                }
            }
        }

        if ( meFound == null ) {
            throw new NameNotFoundException( name );
        }

        return meFound;
    }

    public static ModelElement lookupElement( com.sap.tc.moin.repository.core.CoreConnection connection, Wrapper<? extends Namespace> namespace, RefObjectWrapperImpl<? extends RefObject> namespaceImpl, String name ) throws JmiException, NameNotFoundException, JmiException {

        ModelElement element = lookupElement( connection, namespace.unwrap( ), (RefObjectImpl) namespaceImpl.unwrap( ), name );
        return (ModelElement) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, element );
    }

    /**
     * [S-8] nameIsValid.
     * <p>
     * See MOF Spec 3.4.2.
     * <p>
     * Determines whether the proposedName can be used as the name for a new
     * member ModelElement in this Namespace. Specifically, it checks that the
     * Namespace uniqueness rules would still be satisfied after adding such a
     * name.
     * <p>
     * See MOF Spec 3.9.5., corrected by SAP Labs, KA
     * <p>
     * Returns true if "proposedName" is a valid name that could be used for a
     * new containedElement of this Namespace.
     * 
     * <pre>
     * context Namespace::nameIsValid(proposedName : String) : Boolean
     *     post: result = self.extendedNamespace() -> forAll(e | not e.name = proposedName)
     * </pre>
     */
    public static boolean nameIsValid( CoreConnection connection, Namespace self, RefObjectImpl namespaceImpl, String proposedName ) throws JmiException {

        for ( ModelElement e : OclHelperFunctions.extendedNamespaceO2( connection, self ) ) {
            if ( e.getName( ).equals( proposedName ) ) {
                return false;
            }
        }
        return true;
    }

    public static boolean nameIsValid( CoreConnection connection, Wrapper<? extends Namespace> self, RefObjectWrapperImpl<? extends RefObject> namespaceImpl, String proposedName ) throws JmiException {

        return nameIsValid( connection, self.unwrap( ), (RefObjectImpl) namespaceImpl.unwrap( ), proposedName );
    }

    public static List<ModelElement> findElementsByType( CoreConnection connection, Namespace namespace, RefObjectImpl namespaceImpl, MofClass ofType, boolean includeSubtypes ) throws JmiException {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        Set<GeneralizableElement> types = new HashSet<GeneralizableElement>( );
        types.add( ofType );
        if ( includeSubtypes ) {
            types.addAll( namespaceImpl.get___Workspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAllSubtypes( connection, ofType ) );
        }
        List<ModelElement> listFound = new ArrayList<ModelElement>( );
        JmiList contents = (JmiList) ( (NamespaceInternal) namespace ).getContents( connection );
        for ( int i = 0, n = contents.size( session ); i < n; i++ ) {
            ModelElement me = (ModelElement) contents.get( session, i );
            if ( types.contains( me.refMetaObject( ) ) ) {
                listFound.add( me );
            }
        }
        return listFound;
    }

    public static List<ModelElement> findElementsByType( CoreConnection connection, Wrapper<? extends Namespace> namespace, RefObjectWrapperImpl<? extends RefObject> namespaceImpl, MofClass ofType, boolean includeSubtypes ) throws JmiException {

        List<ModelElement> elementsByType = findElementsByType( connection, namespace.unwrap( ), (RefObjectImpl) namespaceImpl.unwrap( ), ( (Wrapper<MofClass>) ofType ).unwrap( ), includeSubtypes );
        return (List<ModelElement>) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, elementsByType );
    }

    public static ModelElement resolveQualifiedName( CoreConnection connection, Namespace namespace, RefObjectImpl namespaceImpl, List<? extends String> qualifiedName ) throws JmiException, NameNotResolvedException {

        if ( qualifiedName == null || qualifiedName.size( ) < 1 ) {
            return null;
        }
        // According to the MOF and JMI sepcifications this method has to deal
        // with a search within its content only
        ModelElement me = null;
        // loopup of first name in qualified name
        try {
            me = lookupElement( connection, namespace, namespaceImpl, qualifiedName.get( 0 ) );
        } catch ( NameNotFoundException e1 ) {
            throw new NameNotResolvedException( namespace.getName( ), qualifiedName );
        }
        if ( me == null ) {
            throw new NameNotResolvedException( namespace.getName( ), qualifiedName );
        }
        if ( qualifiedName.size( ) == 1 ) {
            return me;
        } else if ( !( me instanceof Namespace ) ) {
            throw new NameNotResolvedException( namespace.getName( ), qualifiedName );
        } else {
            return ( (NamespaceInternal) me ).resolveQualifiedName( connection, qualifiedName.subList( 1, qualifiedName.size( ) ) );
        }
    }

    public static ModelElement resolveQualifiedName( CoreConnection connection, Wrapper<? extends Namespace> namespace, RefObjectWrapperImpl<? extends RefObject> namespaceImpl, List<? extends String> qualifiedName ) throws JmiException, NameNotResolvedException {

        ModelElement resolved = resolveQualifiedName( connection, namespace.unwrap( ), (RefObjectImpl) namespaceImpl.unwrap( ), qualifiedName );
        return (ModelElement) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, resolved );
    }

    //--------------- GeneralizableElement ----------------------

    public static List<GeneralizableElement> allSupertypes( CoreConnection connection, GeneralizableElement element, RefObjectImpl elementImpl ) throws JmiException {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        return elementImpl.get___Workspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( ).getAllSupertypes( session, element );
    }

    public static List<GeneralizableElement> allSupertypes( CoreConnection connection, Wrapper<? extends GeneralizableElement> element, RefObjectWrapperImpl<? extends RefObject> elementImpl ) throws JmiException {

        List<GeneralizableElement> allSupertypes = allSupertypes( connection, element.unwrap( ), (RefObjectImpl) elementImpl.unwrap( ) );
        return (List<GeneralizableElement>) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, allSupertypes );
    }

    public static ModelElement lookupElementExtended( CoreConnection connection, GeneralizableElement element, RefObjectImpl elementImpl, String name ) throws JmiException, NameNotFoundException {

        return connection.getCoreJmiHelper( ).lookupElementExtended( connection, element, name );
    }

    public static ModelElement lookupElementExtended( CoreConnection connection, Wrapper<? extends GeneralizableElement> element, RefObjectWrapperImpl<? extends RefObject> elementImpl, String name ) throws JmiException, NameNotFoundException {

        ModelElement elementExtended = lookupElementExtended( connection, element.unwrap( ), (RefObjectImpl) elementImpl.unwrap( ), name );
        return (ModelElement) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, elementExtended );
    }

    /**
     * [S-11] findElementsByTypeExtended.
     * <p>
     * See MOF Spec 3.4.3.
     * <p>
     * Provides an extension of the findElementsByType defined for Namespace so
     * that contained elements of all superclasses (direct and indirect) of the
     * GeneralizableElement are included in the search. The order of the
     * returned elements is determined by the order of the elements contained in
     * the GeneralizableElements and a depth-first traversal of the
     * superclasses.
     * <p>
     * Subclasses can include a larger overall area for the lookup. Package, a
     * subclass of GeneralizableElement, also considers the elements brought
     * into this Namespace through the use of Import.
     * <p>
     * See MOF Spec 3.9.5., corrected by SAP Labs, KA
     * <p>
     * Returns a subset of the contained, inherited, or imported elements. If
     * "includeSubtypes" is false, the result consists of instances of "ofType".
     * If it is true, instances of subClasses are included.
     * 
     * <pre>
     * context GeneralizeableElement::findElementsByTypeExtended(ofType : Class, includeSubtypes : Boolean) : Sequence(ModelElement)
     *     post: result =
     *         if includeSubtypes then
     *             self.extendedNamespace() -> select(m | m.oclIsOfKind(ofType))
     *         else
     *             self.extendedNamespace() -> select(m | m.oclIsOfType(ofType))
     *         endif
     * </pre>
     */
    public static List<ModelElement> findElementsByTypeExtended( CoreConnection connection, GeneralizableElement self, RefObjectImpl elementImpl, MofClass ofType, boolean includeSubtypes ) throws JmiException {

        Set<GeneralizableElement> types = new HashSet<GeneralizableElement>( );
        types.add( ofType );
        if ( includeSubtypes ) {
            types.addAll( connection.getCoreJmiHelper( ).getAllSubtypes( connection, ofType ) );
        }
        List<ModelElement> listFound = new ArrayList<ModelElement>( );
        for ( ModelElement m : OclHelperFunctions.extendedNamespaceO2( connection, self ) ) {
            if ( types.contains( m.refMetaObject( ) ) ) {
                listFound.add( m );
            }
        }
        return listFound;
    }

    public static List<ModelElement> findElementsByTypeExtended( CoreConnection connection, Wrapper<? extends GeneralizableElement> self, RefObjectWrapperImpl<? extends RefObject> elementImpl, MofClass ofType, boolean includeSubtypes ) throws JmiException {

        List<ModelElement> elementsByTypeExtended = findElementsByTypeExtended( connection, self.unwrap( ), (RefObjectImpl) elementImpl.unwrap( ), ( (Wrapper<MofClass>) ofType ).unwrap( ), includeSubtypes );
        return (List<ModelElement>) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, elementsByTypeExtended );
    }

    //--------------- DependsOn ----------------------

    /**
     * See MOF Spec 3.5.9.
     * <p>
     * DependsOn is a derived Association that allows a client to identify the
     * collection of ModelElements on which a given ModelElement structurally
     * depends. The Association is derived from a number of other Associations
     * in the MOF Model, as described below.
     * <p>
     * This End is occupied by ModelElements that structurally depend on the
     * ModelElement at the other End.
     * <p>
     * The implementation is the opposite of ModelElement.findRequiredElements
     */
    public static Collection<ModelElement> getDependent( CoreConnection connection, DependsOn association, ModelElement provider ) throws JmiException {

        Set<ModelElement> seen = new HashSet<ModelElement>( 1 );
        seen.add( provider );
        return new HashSet<ModelElement>( OclHelperFunctions.recursiveFindProvs( connection, provider, seen ) );
    }

    public static Collection<ModelElement> getDependent( CoreConnection connection, Wrapper<? extends DependsOn> association, ModelElement provider ) throws JmiException {

        Collection<ModelElement> dependent = getDependent( connection, association.unwrap( ), ( (Wrapper<? extends ModelElement>) provider ).unwrap( ) );
        return (List<ModelElement>) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, dependent );
    }

    /**
     * See MOF Spec 3.5.9.
     * <p>
     * DependsOn is a derived Association that allows a client to identify the
     * collection of ModelElements on which a given ModelElement structurally
     * depends. The Association is derived from a number of other Associations
     * in the MOF Model, as described below.
     * <p>
     * This End is occupied by ModelElements that have other ModelElements that
     * structurally depend on them.
     */
    public static Collection<ModelElement> getProvider( CoreConnection connection, DependsOn association, ModelElement dependent ) throws JmiException {

        return findRequiredElements( connection, dependent, (RefObjectImpl) dependent, allDependencyKinds, true );
    }

    public static Collection<ModelElement> getProvider( CoreConnection connection, Wrapper<? extends DependsOn> association, ModelElement dependent ) throws JmiException {

        Collection<ModelElement> provider = getProvider( connection, association.unwrap( ), ( (Wrapper<? extends ModelElement>) dependent ).unwrap( ) );
        return (List<ModelElement>) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, provider );
    }

    public static boolean exists( CoreConnection connection, DependsOn association, ModelElement dependent, ModelElement provider ) throws JmiException {

        boolean result = false;
        // calculate the existence based on the accessor for end dependent
        for ( Iterator<ModelElement> iter = ( (DependsOnInternal) association ).getDependent( connection, provider ).iterator( ); iter.hasNext( ); ) {
            if ( iter.next( ).equals( dependent ) ) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean exists( CoreConnection connection, Wrapper<? extends DependsOn> association, ModelElement dependent, ModelElement provider ) throws JmiException {

        return exists( connection, association.unwrap( ), ( (Wrapper<? extends ModelElement>) dependent ).unwrap( ), ( (Wrapper<? extends ModelElement>) provider ).unwrap( ) );
    }

    //--------------- AssociationEnd ----------------------

    public static AssociationEnd otherEnd( CoreConnection connection, RefObjectImpl endImpl ) throws JmiException {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        SpiJmiHelper jmiHelper = endImpl.get___JmiHelper( );
        Association assoc = (Association) ( (AssociationEndInternal) endImpl ).getContainer( connection );
        List<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( session, assoc );
        for ( int i = 0; i < 2; i++ ) {
            AssociationEnd associationEnd = associationEnds.get( i );
            if ( !associationEnd.equals( endImpl ) ) {
                return associationEnd;
            }
        }
        return null;
    }

    public static AssociationEnd otherEnd( CoreConnection connection, RefObjectWrapperImpl<? extends RefObject> endImpl ) throws JmiException {

        AssociationEnd otherEnd = otherEnd( connection, (RefObjectImpl) endImpl.unwrap( ) );
        return (AssociationEnd) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, otherEnd );
    }

    //--------------- Exposes ----------------------

    public static Collection<Reference> getReferrer( CoreConnection connection, Exposes association, AssociationEnd exposedEnd ) throws JmiException {

        ModelPackageInternal modelPackage = (ModelPackageInternal) exposedEnd.refImmediatePackage( );
        RefersToInternal refersTo = (RefersToInternal) modelPackage.getRefersTo( connection );
        AssociationEnd referencedEnd = ( (AssociationEndInternal) exposedEnd ).otherEnd( connection );
        return refersTo.getReferent( connection, referencedEnd );
    }

    public static Collection<Reference> getReferrer( CoreConnection connection, Wrapper<? extends Exposes> association, AssociationEnd exposedEnd ) throws JmiException {

        Collection<Reference> referrer = getReferrer( connection, association.unwrap( ), ( (Wrapper<AssociationEnd>) exposedEnd ).unwrap( ) );
        return (Collection<Reference>) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, referrer );
    }

    public static AssociationEnd getExposedEnd( CoreConnection connection, Exposes association, Reference referrer ) throws JmiException {

        AssociationEnd referencedEnd = ( (ReferenceInternal) referrer ).getReferencedEnd( connection );
        if ( referencedEnd != null ) {
            AssociationEnd exposedEnd = ( (AssociationEndInternal) referencedEnd ).otherEnd( connection );
            return exposedEnd;
        }
        return null;
    }

    public static AssociationEnd getExposedEnd( CoreConnection connection, Wrapper<? extends Exposes> association, Reference referrer ) throws JmiException {

        AssociationEnd exposedEnd = getExposedEnd( connection, association.unwrap( ), ( (Wrapper<Reference>) referrer ).unwrap( ) );
        return (AssociationEnd) connection.getSession( ).getWorkspaceSet( ).getWrapperManager( ).wrapObject( connection, exposedEnd );
    }

    public static boolean remove( CoreConnection connection, Exposes association, Reference referrer, AssociationEnd exposedEnd ) throws JmiException {

        ModelPackageInternal modelPackage = (ModelPackageInternal) exposedEnd.refImmediatePackage( );
        RefersToInternal refersTo = (RefersToInternal) modelPackage.getRefersTo( connection );
        AssociationEnd referencedEnd = ( (AssociationEndInternal) exposedEnd ).otherEnd( connection );
        return refersTo.remove( connection, referrer, referencedEnd );
    }

    public static boolean remove( CoreConnection connection, Wrapper<? extends Exposes> association, Reference referrer, AssociationEnd exposedEnd ) throws JmiException {

        return remove( connection, association.unwrap( ), ( (Wrapper<Reference>) referrer ).unwrap( ), ( (Wrapper<AssociationEnd>) exposedEnd ).unwrap( ) );
    }

    public static boolean add( CoreConnection connection, Exposes association, Reference referrer, AssociationEnd exposedEnd, Reference addedViaReference ) throws JmiException {

        ModelPackageInternal modelPackage = (ModelPackageInternal) exposedEnd.refImmediatePackage( );
        RefersToInternal refersTo = (RefersToInternal) modelPackage.getRefersTo( connection );
        AssociationEnd referencedEnd = ( (AssociationEndInternal) exposedEnd ).otherEnd( connection );
        if ( addedViaReference == null ) {
            return refersTo.add( connection, referrer, referencedEnd );
        }
        return ( (RefAssociationExtension) refersTo ).add___AssociationEnds( referrer, referencedEnd, addedViaReference );
    }

    public static boolean add( CoreConnection connection, Wrapper<? extends Exposes> association, Reference referrer, AssociationEnd exposedEnd, Reference addedViaReference ) throws JmiException {

        return add( connection, association.unwrap( ), ( (Wrapper<Reference>) referrer ).unwrap( ), ( (Wrapper<AssociationEnd>) exposedEnd ).unwrap( ), ( (Wrapper<Reference>) addedViaReference ).unwrap( ) );
    }

    public static boolean exists( CoreConnection connection, Exposes association, Reference referrer, AssociationEnd exposedEnd ) throws JmiException {

        boolean result = false;
        // calculate the existence based on the accessor for end referrer
        for ( Iterator<Reference> iter = ( (ExposesInternal) association ).getReferrer( connection, exposedEnd ).iterator( ); iter.hasNext( ); ) {
            if ( iter.next( ).equals( referrer ) ) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean exists( CoreConnection connection, Wrapper<? extends Exposes> association, Reference referrer, AssociationEnd exposedEnd ) throws JmiException {

        return exists( connection, association.unwrap( ), ( (Wrapper<Reference>) referrer ).unwrap( ), ( (Wrapper<AssociationEnd>) exposedEnd ).unwrap( ) );
    }

    public static String createGUID( ) {

        return Utilities.getUtilities( ).createGUID( );
    }
}