package com.sap.tc.moin.repository.core.jmi.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.TypedElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AliasesInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttachesToInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.CanRaiseInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizesInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ImportInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.IsOfTypeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.OperationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.RefersToInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TagInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.TypedElementInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;

/**
 * This class provides an implementation of the MOF OCL helper functions [O-x]
 * and similar MOIN helper functions [MO-x].
 * <p>
 * See MOF Spec 3.9.6.
 */
public final class OclHelperFunctions {

    /**
     * [O-2] extendedNamespace.
     * <p>
     * See MOF Spec 3.9.6., corrected by SAP Labs, KA
     * <p>
     * The extendedNamespace of a Namespace is its contents, the contents of its
     * supertypes, and any Namespaces that it imports.
     * 
     * <pre>
     * context Namespace
     *     def: extendedNamespace() : Set(ModelElement) = self.contents
     * context GeneralizableElement
     *     def: extendedNamespace() : Set(ModelElement) = self.contents -> asSet() -> union(self.allSupertypes() -> collect(s | s.contents) -> asSet())
     * context Package
     *     def: extendedNamespace() : Set(ModelElement) =
     *         let ens = self.contents -> asSet() -> union(self.allSupertypes() -> collect(s | s.contents) -> asSet()) in
     *         let imports = ens -> select(e | e.oclIsKindOf(Import)) -> collect(i | i.oclAsType(Import).imported) -> asSet() in
     *         ens -> union(imports)
     * </pre>
     */
    public static Set<? extends ModelElement> extendedNamespaceO2( CoreConnection connection, Namespace self ) {

        if ( self instanceof MofPackage ) {
            return extendedNamespaceO2( connection, (MofPackage) self );
        } else if ( self instanceof GeneralizableElement ) {
            return extendedNamespaceO2( connection, (GeneralizableElement) self );
        }

        Set<ModelElement> result = new HashSet<ModelElement>( );
        addAll( connection.getSession( ), (JmiList) ( (NamespaceInternal) self ).getContents( connection ), result );
        return result;
    }

    private static Set<? extends ModelElement> extendedNamespaceO2( CoreConnection connection, MofPackage self ) {

        Set<ModelElement> result = new HashSet<ModelElement>( );
        // cast to GeneralizableElement is essential here in order to call the correct method
        Set<? extends ModelElement> ens = extendedNamespaceO2( connection, (GeneralizableElement) self );
        Set<Namespace> imports = new HashSet<Namespace>( );
        for ( ModelElement e : ens ) {
            if ( e instanceof Import ) {
                Import i = (Import) e;
                imports.add( i.getImportedNamespace( ) );
            }
        }
        result.addAll( ens );
        result.addAll( imports );
        return result;
    }

    private static Set<? extends ModelElement> extendedNamespaceO2( CoreConnection connection, GeneralizableElement self ) {

        Set<ModelElement> result = new HashSet<ModelElement>( );
        addAll( connection.getSession( ), (JmiList) ( (GeneralizableElementInternal) self ).getContents( connection ), result );
        for ( GeneralizableElement s : ( (GeneralizableElementInternal) self ).allSupertypes( connection ) ) {
            addAll( connection.getSession( ), (JmiList) ( (GeneralizableElementInternal) self ).getContents( connection ), result );
        }
        return result;
    }

    /**
     * [O-6] recursiveFindDeps.
     * <p>
     * See MOF Spec 3.9.6., corrected by SAP Labs, KA
     * <p>
     * The set of ModelElements that recursively depend on this one.
     * <p>
     * Correction by MOIN: The set of ModelElements that this one recursively
     * depends on with dependencies in <code>kinds</code>.
     * 
     * <pre>
     * context ModelElement
     *     def: recursiveFindDeps(kinds : Sequence(String), seen : Set(ModelElement)) : Set(ModelElement) =
     *         let seen2 = seen -> collect(m | kinds -> collect(k | m.findDepsOfKind(k)) -> asSet()) in
     *         if seen2 = seen then
     *             seen
     *         else
     *             self.recursiveFindDeps(kinds, seen2)
     *         endif
     * </pre>
     */
    // kinds is in my opinion a Set (MM)
    public static Set<? extends ModelElement> recursiveFindDepsO6( CoreConnection connection, ModelElement self, Set<String> kinds, Set<? extends ModelElement> seen ) {

        Set<ModelElement> seen2 = new HashSet<ModelElement>( seen );
        boolean seen2Changed = false;
        for ( String kind : kinds ) {
            seen2Changed = seen2Changed || seen2.addAll( findDepsOfKindO8( connection, self, kind ) );
        }
        for ( ModelElement m : seen ) {
            for ( String kind : kinds ) {
                seen2Changed = seen2Changed || seen2.addAll( findDepsOfKindO8( connection, m, kind ) );
            }
        }
        if ( !seen2Changed ) {
            // remove self from the result list because self can not depend on itself
            seen.remove( self );
            return seen;
        } else {
            return recursiveFindDepsO6( connection, self, kinds, seen2 );
        }
    }

    /**
     * [O-7] isDepOfKind.
     * <p>
     * See MOF Spec 3.9.6., corrected by SAP Labs, KA
     * <p>
     * Returns true if this element depends on "other" with a dependency of
     * "kind".
     * 
     * <pre>
     * context ModelElement
     *     def: isDepOfKind(kind : String, other : ModelElement) : Boolean =
     *         self.findDepsOfKind(kind) -> includes(other)
     * </pre>
     */
    public static boolean isDepOfKindO7( CoreConnection connection, ModelElement self, String kind, ModelElement other ) {

        return findDepsOfKindO8( connection, self, kind ).contains( other );
    }

    /**
     * [O-8] findDepsOfKind.
     * <p>
     * See MOF Spec 3.9.6., corrected by SAP Labs, KA
     * <p>
     * The set of ModelElements that this one Depends on with <code>kind</code>
     * dependency.
     * 
     * <pre>
     * context ModelElement
     *     def: findDepsOfKind(kind : String) : Sequence(ModelElement) =
     *         if kind = 'constraint' then
     *             self.constraints -> asSequence()
     *         else if kind = 'container' then
     *             Sequence{self.container}
     *         else if kind = 'constrained elements' and self.oclIsTypeOf(Constraint) then
     *             self.oclAsType(Constraint).constrainedElements -> asSequence()
     *         else if kind = 'specialization' and self.oclIsKindOf(GeneralizableElement) then
     *             self.oclAsType(GeneralizableElement).supertypes -> asSequence()
     *         else if kind = 'import' and self.oclIsTypeOf(Import) then
     *             self.oclAsType(Import).importedNamespace -> asSequence()
     *         else if kind = 'contents' and self.oclIsKindOf(Namespace) then
     *             self.oclAsType(Namespace).contents -> asSequence()
     *         else if kind = 'signature' and self.oclIsTypeOf(Operation) then
     *             self.oclAsType(Operation).exceptions -> asSequence()
     *         else if kind = 'tagged elements' and self.oclIsTypeOf(Tag) then
     *             self.oclAsType(Tag).elements -> asSequence()
     *         else if kind = 'type definition' and self.oclIsTypeOf(TypedElement) then
     *             Sequence{self.oclAsType(TypedElement).type}
     *         else if kind = 'referenced ends' and self.oclIsKindOf(Reference) then
     *             let ref = self.oclAsType(Reference) in
     *             Sequence{ref.referencedEnd, ref.exposedEnd}
     *         else
     *             Sequence{}
     *         endif endif endif endif endif endif endif endif endif endif
     * </pre>
     */
    public static List<? extends ModelElement> findDepsOfKindO8( CoreConnection connection, ModelElement self, String kind ) {

        CoreSession session = connection.getSession( );
        ArrayList<ModelElement> result = new ArrayList<ModelElement>( );
        if ( kind.equals( ModelElement.CONSTRAINTDEP ) ) {
            addAll( session, (JmiList) ( (ModelElementInternal) self ).getConstraints( connection ), result );
        } else if ( kind.equals( ModelElement.CONTAINERDEP ) ) {
            Namespace container = ( (ModelElementInternal) self ).getContainer( connection );
            // note that container == null means that we have a top level package here
            if ( container != null ) {
                result.add( container );
            }
        } else if ( kind.equals( ModelElement.CONSTRAINEDELEMENTSDEP ) && self instanceof Constraint ) {
            addAll( session, (JmiList) ( (ConstraintInternal) self ).getConstrainedElements( connection ), result );
        } else if ( kind.equals( ModelElement.SPECIALIZATIONDEP ) && self instanceof GeneralizableElement ) {
            addAll( session, (JmiList) ( (GeneralizableElementInternal) self ).getSupertypes( connection ), result );
        } else if ( kind.equals( ModelElement.IMPORTDEP ) && self instanceof Import ) {
            result.add( ( (ImportInternal) self ).getImportedNamespace( connection ) );
        } else if ( kind.equals( ModelElement.CONTENTSDEP ) && self instanceof Namespace ) {
            addAll( session, (JmiList) ( (NamespaceInternal) self ).getContents( connection ), result );
        } else if ( kind.equals( ModelElement.SIGNATUREDEP ) && self instanceof Operation ) {
            addAll( session, (JmiList) ( (OperationInternal) self ).getExceptions( connection ), result );
        } else if ( kind.equals( ModelElement.TAGGEDELEMENTSDEP ) && self instanceof Tag ) {
            addAll( session, (JmiList) ( (TagInternal) self ).getElements( connection ), result );
        } else if ( kind.equals( ModelElement.TYPEDEFINITIONDEP ) && self instanceof TypedElement ) {
            result.add( ( (TypedElementInternal) self ).getType( connection ) );
        } else if ( kind.equals( ModelElement.REFERENCEDENDSDEP ) && self instanceof Reference ) {
            ReferenceInternal ref = (ReferenceInternal) self;
            result.add( (Reference) ref );
            result.add( ref.getExposedEnd( connection ) );
        }
        return result;
    }



    /**
     * [MO-1] recursiveFindProvs.
     * <p>
     * The set of ModelElements from which this one recursively depends on.
     */
    public static Set<? extends ModelElement> recursiveFindProvs( CoreConnection connection, ModelElement self, Set<? extends ModelElement> seen ) {

        Set<ModelElement> seen2 = new HashSet<ModelElement>( seen );
        boolean seen2Changed = false;
        for ( ModelElement m : seen ) {
            seen2Changed = seen2.addAll( findProvs( connection, m ) );
        }
        if ( !seen2Changed ) {
            return seen;
        } else {
            return recursiveFindProvs( connection, self, seen2 );
        }
    }

    /**
     * [MO-2] findProvs.
     * <p>
     * The set of ModelElements from which this one depends on.
     */
    private static Set<? extends ModelElement> findProvs( CoreConnection connection, ModelElement self ) {

        CoreSession session = connection.getSession( );
        Set<ModelElement> result = new HashSet<ModelElement>( );
        ModelPackage modelPackage = (ModelPackage) self.refMetaObject( ).refImmediatePackage( );
        // add container, dependency = 'contents'
        Namespace container = ( (ModelElementInternal) self ).getContainer( connection );
        // note that container == null means that we have a top level package here
        if ( container != null ) {
            result.add( container );
        }
        // add all tags, dependency = 'tagged elements'
        addAll( session, (JmiList) ( ( (AttachesToInternal) ( (ModelPackageInternal) modelPackage ).getAttachesTo( connection ) ).getTag( connection, self ) ), result );
        // add all constraints, dependency = 'constrained elements'
        addAll( session, (JmiList) ( (ModelElementInternal) self ).getConstraints( connection ), result );
        // add all contained elements, dependency = 'container'
        if ( self instanceof Namespace ) {
            addAll( session, (JmiList) ( (NamespaceInternal) self ).getContents( connection ), result );
        }
        // add all constrained elements, dependency = 'constraint'
        if ( self instanceof Constraint ) {
            addAll( session, (JmiList) ( (ConstraintInternal) self ).getConstrainedElements( connection ), result );
        }
        // add all sub types, dependency = 'specialization'
        if ( self instanceof GeneralizableElement ) {
            addAll( session, (JmiList) ( (GeneralizesInternal) ( (ModelPackageInternal) modelPackage ).getGeneralizes( connection ) ).getSubtype( connection, (GeneralizableElement) self ), result );
        }
        // add all imports, dependency = 'import'
        if ( self instanceof Namespace ) {
            addAll( session, (JmiList) ( (AliasesInternal) ( (ModelPackageInternal) modelPackage ).getAliases( connection ) ).getImporter( connection, (Namespace) self ), result );
        }
        // add all operations, dependency = 'signature'
        if ( self instanceof MofException ) {
            addAll( session, (JmiList) ( (CanRaiseInternal) ( (ModelPackageInternal) modelPackage ).getCanRaise( connection ) ).getOperation( connection, (MofException) self ), result );
        }
        // add all typed elements, dependency = 'type definition'
        if ( self instanceof Classifier ) {
            addAll( session, (JmiList) ( (IsOfTypeInternal) ( (ModelPackageInternal) modelPackage ).getIsOfType( connection ) ).getTypedElements( connection, (Classifier) self ), result );
        }
        // add all references, dependency = 'referenced ends'
        if ( self instanceof AssociationEnd ) {
            addAll( session, (JmiList) ( (RefersToInternal) ( (ModelPackageInternal) modelPackage ).getRefersTo( connection ) ).getReferent( connection, (AssociationEnd) self ), result );
        }
        if ( self instanceof Reference ) {
            result.add( self );
        }
        return result;
    }

    public static void addAll( CoreSession session, JmiList source, Collection target ) {

        Iterator sourceIterator = source.iteratorReadOnly( session );
        for ( ; sourceIterator.hasNext( ); ) {
            target.add( sourceIterator.next( ) );
        }
    }
}
