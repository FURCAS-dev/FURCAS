package com.sap.tc.moin.repository.test.ocl.ia.evaluation.eventgen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.events.DeleteET;
import com.sap.tc.moin.ocl.ia.events.DeleteRT;
import com.sap.tc.moin.ocl.ia.events.InsertET;
import com.sap.tc.moin.ocl.ia.events.InsertRT;
import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.ia.events.UpdateAttribute;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.ElementCreateEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.ElementDeleteEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkAddEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.test.ocl.ia.mockobjects.MRIImpl;

/**
 * Creates for each InternalEvent relevant to a set of statements a concrete
 * ModelChangeEvent. This class uses the ImpactAnalyzer to determine the kind of
 * relevant events for a set of statements. A set of concrete events is then
 * created.
 * 
 * @author Thomas Hettel
 */
public class SelectedEventGenerator extends EventGenerator {

    private Set<OclStatement> stmts;

    private RefPackage instancePackage;

    private Set<String> nameSpaces;

    /**
     * @param mp the model package
     * @param stmts the set of statements to create ModelChangeEvents for.
     * @param nameSpaces namespaces of elements to include.
     * @param pkg the package in which to look for the class proxy.
     * @throws Exception
     */
    public SelectedEventGenerator( ModelPackage mp, Set<OclStatement> stmts, Set<String> nameSpaces, RefPackage pkg ) throws Exception {

        super( mp );
        this.stmts = stmts;
        this.instancePackage = pkg;
        this.nameSpaces = nameSpaces;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.rcbne.ocl20.ia.evaluation.eventgen.EventGenerator#generateEvents()
     */
    @Override
    protected List<ModelChangeEvent> generateEvents( CoreConnection connection ) throws Exception {

        ModelPartition transientPartition = connection.getOrCreateTransientPartitionNonTransactional( "OclTransientPartition" );
        ImpactAnalyzer ia = new ImpactAnalyzer( true );
        MoinJmiCreator jmiCreator = new JmiCreator( connection, false, transientPartition );
        ia.analyze( this.stmts, jmiCreator );
        Set<InternalEvent> intEvents = ia.testingGetInternalEvents( );
        List<ModelChangeEvent> events = new ArrayList<ModelChangeEvent>( );
        // for each internal event generate a Modelchange event
        for ( Iterator<InternalEvent> i = intEvents.iterator( ); i.hasNext( ); ) {
            InternalEvent ie = i.next( );

            try {
                if ( ie instanceof InsertET ) {
                    InsertET iet = (InsertET) ie;
                    Classifier c = iet.getMofClass( );
                    if ( c.getQualifiedName( ) == null || c.getQualifiedName( ).get( 0 ).equals( "OCL" ) ) {
                        continue;
                    }
                    RefObject o = getAnInstance( connection, c );
                    events.add( new ElementCreateEventImpl( connection, o ) );
                } else if ( ie instanceof DeleteET ) {
                    DeleteET det = (DeleteET) ie;
                    Classifier c = det.getMofClass( );
                    if ( c.getQualifiedName( ) == null || c.getQualifiedName( ).get( 0 ).equals( "OCL" ) ) {
                        continue;
                    }
                    RefObject o = getAnInstance( connection, c );
                    events.add( new ElementDeleteEventImpl( connection, o ) );
                } else if ( ie instanceof InsertRT ) {
                    InsertRT irt = (InsertRT) ie;
                    Association a = irt.getAssociation( );
                    if ( a.getQualifiedName( ) == null || a.getQualifiedName( ).get( 0 ).equals( "OCL" ) ) {
                        continue;
                    }
                    AssociationEnd[] ends = (AssociationEnd[]) irt.getAssociation( ).getContents( ).toArray( );
                    AssociationEnd end = ends[0];
                    AssociationEnd otherEnd = ends[1];
                    // Reference ref = getAReference(end);
                    List<MRI> link = new ArrayList<MRI>( );
                    link.add( new MRIImpl( getAnInstance( connection, end.getType( ) ) ) );
                    link.add( new MRIImpl( getAnInstance( connection, otherEnd.getType( ) ) ) );
                    events.add( new LinkAddEventImpl( connection, link, end ) );
                } else if ( ie instanceof DeleteRT ) {
                    DeleteRT drt = (DeleteRT) ie;
                    Association a = drt.getAssociation( );
                    if ( a.getQualifiedName( ) == null || a.getQualifiedName( ).get( 0 ).equals( "OCL" ) ) {
                        continue;
                    }
                    AssociationEnd[] ends = (AssociationEnd[]) drt.getAssociation( ).getContents( ).toArray( );
                    AssociationEnd end = ends[0];
                    AssociationEnd otherEnd = ends[1];

                    // Reference ref = getAReference(end);
                    List<MRI> link = new ArrayList<MRI>( );
                    link.add( new MRIImpl( getAnInstance( connection, end.getType( ) ) ) );
                    link.add( new MRIImpl( getAnInstance( connection, otherEnd.getType( ) ) ) );
                    events.add( new LinkRemoveEventImpl( connection, link, end ) );
                } else if ( ie instanceof UpdateAttribute ) {
                    UpdateAttribute uattr = (UpdateAttribute) ie;
                    Attribute a = uattr.getAttribute( );
                    Classifier c = (Classifier) a.refImmediateComposite( );
                    if ( a.getQualifiedName( ) == null || c.getQualifiedName( ).get( 0 ).equals( "OCL" ) ) {
                        continue;
                    }
                    RefObject o = getAnInstance( connection, c );
                    events.add( new AttributeValueChangeEventImpl( connection, o, a, o.refGetValue( a ), o.refGetValue( a ) ) );
                }
            } catch ( RuntimeException e1 ) {
                System.out.println( "Couldn't create a conrete event for " + ie + " because:\n" + e1 );
            }
            System.out.println( "#Events: " + events.size( ) );
        }

        return events;
    }

    /**
     * Returns an instance of c
     * 
     * @param c the classifier of the instance
     * @return an instance of c
     */
    private RefObject getAnInstance( CoreConnection conn, Classifier c ) {

        Collection<RefObject> instances;
        try {
            RefClassImpl rc = (RefClassImpl) conn.getCoreJmiHelper( ).getRefClassForMofClass( conn.getSession( ), (MofClass) c );
            instances = rc.refAllOfType( conn );
            // instances = EvaluationHelper.getAllInstances(c,
            // this.instancePackage);
        } catch ( RuntimeException e ) {
            throw new RuntimeException( "Couldn't find a suiteable instance." );
        }
        for ( Iterator<RefObject> i = instances.iterator( ); i.hasNext( ); ) {
            RefObject anInstance = i.next( );

            try {
                if ( anInstance instanceof ModelElement ) {
                    ModelElement me = (ModelElement) anInstance;
                    if ( this.nameSpaces.contains( me.getQualifiedName( ).get( 0 ) ) ) {
                        return anInstance;
                    }

                } else {
                    Classifier metaObject = (Classifier) anInstance.refMetaObject( );
                    if ( this.nameSpaces.contains( metaObject.getQualifiedName( ).get( 0 ) ) ) {
                        return anInstance;
                    }
                }
                continue;
                // List qName = metaObject.getQualifiedName();
                // if (qName == null)
                // continue;
                // if (nameSpaces.contains(qName.get(0))) {
                // return anInstance;
                // }
                // return anInstance;
            } catch ( RuntimeException e1 ) {
                continue;
            }
        }
        throw new RuntimeException( "Couldn't find a suiteable instance." );
    }
}