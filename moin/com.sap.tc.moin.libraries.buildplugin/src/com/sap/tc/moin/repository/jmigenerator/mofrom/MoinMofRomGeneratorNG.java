package com.sap.tc.moin.repository.jmigenerator.mofrom;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.USER_NAME;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Extent;
import com.sap.tc.moin.repository.core.ExtentManager;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.jmi.extension.RefStructExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorRuntimeException;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorTraces;
import com.sap.tc.moin.repository.shared.util.ListMap;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Phased MOF ROM generator NG.
 * 
 * @author D046220
 */
public class MoinMofRomGeneratorNG {

    final CoreConnection myConnection;

    private final Collection<CoreModelPartition> myPartitions;

    private final JmiClassNameResolverImpl classNameResolver;

    private final SpiJmiHelper jmiHelper;

    private static final String[] QUALIFIED_NAME = new String[0];

    private final ExtentManager extentManager;

    private static final String MOFROM_FILENAME = "MoinMofRom"; //$NON-NLS-1$

    private static final String MOFROM_INFO_FILENAME = "MoinMofRom.java.out.txt"; //$NON-NLS-1$

    private static final String VERSION = "MOIN-based:2.0"; //$NON-NLS-1$

    private static final int INSTANCE_SIZE = 100;

    private static final int METHOD_SIZE = 100;

    private static final String packageName = "com.sap.tc.moin.repository.core.mofrom"; //$NON-NLS-1$

    private Map<String, Integer> partitionNameToPhaseNumber;

    private Phase[] phases;

    private Map<String, RefBaseObject> globalInstances = new LinkedHashMap<String, RefBaseObject>( );

    private Map<RefBaseObject, Integer> globalInstanceIndexes = new LinkedHashMap<RefBaseObject, Integer>( );

    private Map<RefBaseObject, Phase> instanceToPhase = new LinkedHashMap<RefBaseObject, Phase>( );

    private final Map<AssociationEnd, Boolean> endToQuery = new LinkedHashMap<AssociationEnd, Boolean>( );

    private final Utilities utilities = Utilities.getUtilities( );

    private static final ListMap<String, String> javaClassNameMapping;

    private WriterProvider writerProvider;

    static {

        javaClassNameMapping = new ListMap<String, String>( );
        javaClassNameMapping.put( "com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl", "com.sap.tc.moin.repository.core.mofrom.model.MofRomAssociationImpl" ); //$NON-NLS-1$ //$NON-NLS-2$
        javaClassNameMapping.put( "com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl", "com.sap.tc.moin.repository.core.mofrom.model.MofRomAssociationEndImpl" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * @param actConnection
     * @param outPutFolder
     * @param actPartitions
     */
    public MoinMofRomGeneratorNG( CoreConnection actConnection, String outPutFolder, Collection<CoreModelPartition> actPartitions ) {

        this( actConnection, actPartitions, new DefaultWriterProvider( outPutFolder ) );
    }

    /**
     * @param theConnection
     * @param actPartitions
     * @param actWriterProvider
     */
    public MoinMofRomGeneratorNG( CoreConnection theConnection, Collection<CoreModelPartition> actPartitions, WriterProvider actWriterProvider ) {

        this.myConnection = theConnection;
        this.myPartitions = new TreeSet<CoreModelPartition>( new Comparator<CoreModelPartition>( ) {

            public int compare( CoreModelPartition o1, CoreModelPartition o2 ) {

                return o1.getPri( ).toString( ).compareTo( o2.getPri( ).toString( ) );
            }
        } );
        this.myPartitions.addAll( actPartitions );
        this.classNameResolver = new JmiClassNameResolverImpl( );
        this.jmiHelper = this.myConnection.getCoreJmiHelper( );
        this.extentManager = this.myConnection.getSession( ).getWorkspaceSet( ).getMoin( ).getExtentManager( );
        this.writerProvider = actWriterProvider;

    }

    /**
     * @return the phases
     */
    public Phase[] execute( ) {

        WorkspaceSet workspaceSet = this.myConnection.getSession( ).getWorkspaceSet( );
        if ( !workspaceSet.getMoin( ).isSecondStageInjected( ) ) {
            workspaceSet.getMoin( ).injectSecondMofRomStage( );
        }

        for ( CoreModelPartition partition : this.myPartitions ) {
            System.out.println( partition.getPri( ) );
        }

        initPhases( );

        initInstances( );

        initExtents( );

        initLinks( );

        initGlobalIndex( );

        printDiagnostics( );

        for ( int i = 0; i < this.phases.length; i++ ) {
            ClassicalGeneratorInput gi = new ClassicalGeneratorInput( );

            mergePhase( gi, this.phases[i] );

            Collections.sort( gi.keys, new KeysComparator( gi, this.myConnection ) );

            try {
                writeMofRom( gi, this.writerProvider.getWriterForMofRomPhase( i ), MOFROM_FILENAME + i );
            } catch ( IOException e ) {
                e.printStackTrace( );
            }

        }

        ClassicalGeneratorInput gi = new ClassicalGeneratorInput( );

        for ( int i = 0; i < this.phases.length; i++ ) {
            mergePhase( gi, this.phases[i] );
        }

        Collections.sort( gi.keys, new KeysComparator( gi, this.myConnection ) );

        try {
            export( gi );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }

        return this.phases;
    }

    /**
     * Merges information from MOF ROM pahse into the given generator input.
     */
    private void mergePhase( ClassicalGeneratorInput gi, Phase p ) {

        //keys
        for ( String key : p.instances.keySet( ) ) {
            gi.keys.add( key );
        }

        //instances
        for ( Entry<String, RefBaseObject> e : p.instances.entrySet( ) ) {
            gi.instances.put( e.getKey( ), e.getValue( ) );
        }

        //links        
        for ( Entry<Association, List<SetLink>> e : p.links.entrySet( ) ) {

            List<SetLink> l = gi.links.get( e.getKey( ) );

            if ( l == null ) {
                l = new LinkedList<SetLink>( );

                gi.links.put( e.getKey( ), l );
            }

            l.addAll( e.getValue( ) );
        }

    }

    private void initGlobalIndex( ) {

        for ( Phase p : this.phases ) {
            for ( RefBaseObject o : p.instances.values( ) ) {
                this.globalInstanceIndexes.put( o, this.globalInstanceIndexes.size( ) );
            }
        }

    }

    private void initLinks( ) {

        Set<RefPackage> packagesToCheck = new LinkedHashSet<RefPackage>( );
        packagesToCheck.add( this.myConnection.getPackage( null, "Model" ) ); //$NON-NLS-1$
        packagesToCheck.add( this.myConnection.getPackage( null, "OCL", "Attaching" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        packagesToCheck.add( this.myConnection.getPackage( null, "OCL", "Expressions" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        packagesToCheck.add( this.myConnection.getPackage( null, "OCL", "Types" ) ); //$NON-NLS-1$ //$NON-NLS-2$

        Set<Partitionable> associations = new TreeSet<Partitionable>( this.myConnection.getSession( ).getMoin( ).getByMofIdComparator( ) );
        // collect all associations that are not derived
        for ( RefPackage refPackage : packagesToCheck ) {
            for ( Iterator<RefAssociation> it = refPackage.refAllAssociations( ).iterator( ); it.hasNext( ); ) {
                RefAssociation ra = it.next( );
                Association ass = ra.refMetaObject( );
                if ( ass.isDerived( ) ) {
                    continue;
                }
                associations.add( ra );
            }
        }

        for ( Partitionable refAssoc : associations ) {
            RefAssociationImpl ra = (RefAssociationImpl) refAssoc;
            Association a = ra.refMetaObject( );

            List<AssociationEnd> aes = this.jmiHelper.getAssociationEnds( this.myConnection.getSession( ), a );

            for ( RefBaseObject rbo : this.globalInstances.values( ) ) {
                if ( rbo instanceof RefObject ) {
                    RefObject ro = (RefObject) rbo;

                    for ( AssociationEnd ae : aes ) {

                        if ( isEndToQuery( ae ) ) {
                            int aen = this.jmiHelper.getAssociationEndNumber( null /* connection */, ae );
                            if ( ( (RefObjectImpl) ro ).refIsInstanceOf( this.myConnection.getSession( ), ( (AssociationEndInternal) ae ).getType( this.myConnection ), true ) ) {
                                JmiList<RefObject> elements = ra.refQuery( this.myConnection, ae, ro );
                                Iterator<RefObject> elementsIterator = elements.iteratorReadOnly( this.myConnection.getSession( ) );
                                for ( ; elementsIterator.hasNext( ); ) {
                                    RefObject element = elementsIterator.next( );
                                    String[] mofIds = new String[2];
                                    mofIds[aen] = ro.refMofId( );
                                    mofIds[1 - aen] = element.refMofId( );
                                    SetLink setLink = new SetLink( aen == 0 ? ro : element, aen == 0 ? element : ro );

                                    int phaseNr = Math.max( this.instanceToPhase.get( ro ).number, this.instanceToPhase.get( element ).number );

                                    List<SetLink> phaseLinks = this.phases[phaseNr].links.get( a );

                                    if ( phaseLinks == null ) {
                                        phaseLinks = new LinkedList<SetLink>( );
                                        this.phases[phaseNr].links.put( a, phaseLinks );
                                    }

                                    phaseLinks.add( setLink );
                                }
                            }

                        }
                    }
                }
            }
        }

    }

    private void initExtents( ) {

        for ( CoreModelPartition partition : this.myPartitions ) {
            for ( Partitionable p : partition.getElements( ) ) {
                ModelElement element = (ModelElement) p;
                // also handle the extents
                if ( element instanceof MofPackage || element instanceof MofClass || element instanceof Association ) {
                    Extent[] extents = this.extentManager.selectExtents( ( (ModelElementInternal) element ).getQualifiedName( this.myConnection ).toArray( QUALIFIED_NAME ) );
                    if ( extents.length == 1 ) {
                        String extentMofId = this.extentManager.convertToExtentMofId( element.refMofId( ) );
                        addExtent( extentMofId, element, extents[0] );
                    } else if ( extents.length != 0 ) {
                        // error situation
                        QualifiedName qn = QualifiedName.createQualifiedName( element.getQualifiedName( ) );
                        throw new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.MULTIPLEEXTENTSFOUND, qn.toDotSeparatedString( ) );
                    }
                }
            }
        }
    }

    private void initInstances( ) {

        for ( CoreModelPartition partition : this.myPartitions ) {
            for ( Partitionable p : partition.getElements( ) ) {
                ModelElement element = (ModelElement) p;
                // TODO this is the workaround to avoid having the OCL Helper
                // operations persisted in the MOF ROM
                if ( !( element instanceof MofPackage ) && ( (RefObjectImpl) element ).refImmediateComposite( this.myConnection.getSession( ) ) == null ) {
                    continue;
                }
                addInstance( element.refMofId( ), element );
            }
        }
    }

    private void initPhases( ) {

        this.partitionNameToPhaseNumber = new LinkedHashMap<String, Integer>( );
        this.phases = new Phase[2];

        // phase 0, MOF ROM without OCL
        this.partitionNameToPhaseNumber.put( "moin/meta/PrimitiveTypes.moinmm", 0 ); //$NON-NLS-1$
        this.partitionNameToPhaseNumber.put( "moin/meta/Reflect.moinmm", 0 ); //$NON-NLS-1$
        this.partitionNameToPhaseNumber.put( "moin/meta/CorbaIdlTypes.moinmm", 0 ); //$NON-NLS-1$
        this.partitionNameToPhaseNumber.put( "moin/meta/MOIN.moinmm", 0 ); //$NON-NLS-1$
        this.partitionNameToPhaseNumber.put( "moin/meta/Model.moinmm", 0 ); //$NON-NLS-1$

        this.phases[0] = new Phase( );
        this.phases[0].number = 0;

        // phase 1: OCL
        this.partitionNameToPhaseNumber.put( "moin/meta/OCL.moinmm", 1 ); //$NON-NLS-1$

        this.phases[1] = new Phase( );
        this.phases[1].number = 1;
    }

    private void addInstance( String mofid, RefBaseObject modelElement ) {

        Phase phase = getPhase( modelElement );

        addInstanceToPhase( phase, mofid, modelElement );
    }

    private void addExtent( String extentMofid, RefBaseObject ownedObject, Extent extent ) {

        Phase phase = getPhase( ownedObject );

        addInstanceToPhase( phase, extentMofid, extent );
    }

    private void addInstanceToPhase( Phase phase, String mofid, RefBaseObject rbo ) {

        phase.instances.put( mofid, rbo );
        this.globalInstances.put( mofid, rbo );
        this.instanceToPhase.put( rbo, phase );

    }

    private void printDiagnostics( ) {

        System.out.println( "------ BEGIN DIAGNOSTICS -----------" ); //$NON-NLS-1$

        System.out.println( "Number of phases: " + this.phases.length ); //$NON-NLS-1$

        for ( int i = 0; i < this.phases.length; i++ ) {
            System.out.println( "------ BEGIN PHASE " + i + " -------------" ); //$NON-NLS-1$ //$NON-NLS-2$
            System.out.println( "Number of instances: " + this.phases[i].instances.size( ) ); //$NON-NLS-1$
            System.out.println( "Number of associations bearing links: " + this.phases[i].links.size( ) ); //$NON-NLS-1$

            int count = 0;

            for ( List<SetLink> links : this.phases[i].links.values( ) ) {
                count += links.size( );
            }

            System.out.println( "Number of links: " + count ); //$NON-NLS-1$

            System.out.println( "------ END PHASE " + i + " -------------" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        System.out.println( "------ END DIAGNOSTICS -----------" ); //$NON-NLS-1$
    }

    private Phase getPhase( RefBaseObject modelElement ) {

        return this.phases[this.partitionNameToPhaseNumber.get( ( (Partitionable) modelElement ).get___Partition( ).getPri( ).getPartitionName( ).toString( ) )];
    }

    /**
     * Phase
     */
    public static final class Phase {

        /** number */
        public int number;

        /** instances */
        public Map<String, RefBaseObject> instances = new LinkedHashMap<String, RefBaseObject>( );

        /** links */
        public Map<Association, List<SetLink>> links = new LinkedHashMap<Association, List<SetLink>>( );

        /** the number of links */
        public int getNumberOfLinks( ) {

            int result = 0;
            Collection<List<SetLink>> allLinks = this.links.values( );
            for ( List<SetLink> actLinks : allLinks ) {
                result += actLinks.size( );
            }
            return result;
        }

        /** the number of associations */
        public int getNumberOfAssociations( ) {

            return this.links.keySet( ).size( );
        }

        /** the number of instances */
        public int getNumberOfInstances( ) {

            return this.instances.values( ).size( );
        }
    }

    static class ClassicalGeneratorInput {

        Map<String, RefBaseObject> instances = new LinkedHashMap<String, RefBaseObject>( );

        List<String> keys = new LinkedList<String>( );

        Map<Association, List<SetLink>> links = new LinkedHashMap<Association, List<SetLink>>( );
    }

    private static final class KeysComparator implements Comparator<String> {

        private Collator collator = Collator.getInstance( );

        private final ClassicalGeneratorInput gi;

        private final CoreConnection connection;

        /**
         * The constructor
         * 
         * @param actGi
         */
        public KeysComparator( ClassicalGeneratorInput actGi, CoreConnection connection ) {

            this.gi = actGi;
            this.connection = connection;
        }

        private int getType( RefBaseObject rbo ) {

            int typeCode = -1;
            if ( rbo instanceof RefPackage ) {
                typeCode = 0;
            } else if ( rbo instanceof RefClass ) {
                typeCode = 1;
            } else if ( rbo instanceof RefAssociation ) {
                typeCode = 2;
            } else if ( rbo instanceof RefObject ) {
                typeCode = 3;
            }
            return typeCode;
        }

        public int compare( String o0, String o1 ) {

            int result;
            RefBaseObject rbo0 = this.gi.instances.get( o0 );
            RefBaseObject rbo1 = this.gi.instances.get( o1 );
            ModelElementInternal m0 = (ModelElementInternal) rbo0.refMetaObject( );
            ModelElementInternal m1 = (ModelElementInternal) rbo1.refMetaObject( );
            String dsn0 = QualifiedName.toDotSeparatedString( m0.getQualifiedName( this.connection ) );
            String dsn1 = QualifiedName.toDotSeparatedString( m1.getQualifiedName( this.connection ) );

            result = this.collator.compare( dsn0, dsn1 );
            if ( result == 0 ) {
                int typeCode0 = getType( rbo0 );
                int typeCode1 = getType( rbo1 );
                if ( typeCode0 < typeCode1 ) {
                    result = -1;
                } else if ( typeCode0 > typeCode1 ) {
                    result = 1;
                } else if ( rbo0 instanceof RefObject && rbo1 instanceof RefObject ) {
                    // otherwise at least one is an extent
                    String n0 = QualifiedName.toDotSeparatedString( ( (ModelElementInternal) rbo0 ).getQualifiedName( this.connection ) );
                    String n1 = QualifiedName.toDotSeparatedString( ( (ModelElementInternal) rbo1 ).getQualifiedName( this.connection ) );
                    result = this.collator.compare( n0, n1 );
                } else {
                    result = this.collator.compare( rbo0.refMofId( ), rbo1.refMofId( ) );
                }
            }
            return result;
        }
    }

    private class SetLink {

        final RefObject o1;

        final RefObject o2;

        SetLink( RefObject actO1, RefObject actO2 ) {

            this.o1 = actO1;
            this.o2 = actO2;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( obj != null && obj instanceof SetLink ) {
                SetLink other = (SetLink) obj;

                return this.o1.equals( other.o1 ) && this.o2.equals( other.o2 );
            }
            return false;
        }

        @Override
        public int hashCode( ) {

            return this.o1.hashCode( ) ^ this.o2.hashCode( );
        }

        @Override
        public String toString( ) {

            String out0 = "[" + this.o1.refMofId( ) + " -> " + this.o2.refMofId( ) + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            String label0 = getLabel( this.o1 );
            String label1 = getLabel( this.o2 );
            String out1 = "[" + label0 + " -> " + label1 + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return out0 + " OR " + out1; //$NON-NLS-1$
        }
    }

    private final class JmiClassNameResolverImpl {

        private final Object myResolver;

        private final Method myGenericMethod;

        private final Method myClassMethod;

        /**
         * Create a class name resolver instance
         */
        @SuppressWarnings( "unchecked" )
        public JmiClassNameResolverImpl( ) {

            try {
                Class resolverImpl = Class.forName( "com.sap.tc.moin.repository.jmigenerator.JmiClassNameResolverCoreImpl" ); //$NON-NLS-1$
                Constructor resolverConstructor = resolverImpl.getConstructor( CoreConnection.class );
                this.myResolver = resolverConstructor.newInstance( MoinMofRomGeneratorNG.this.myConnection );
                this.myGenericMethod = resolverImpl.getMethod( "getJavaClassName", ModelElement.class ); //$NON-NLS-1$
                this.myClassMethod = resolverImpl.getMethod( "getJavaClassName", MofClass.class, boolean.class ); //$NON-NLS-1$
            } catch ( SecurityException e ) {
                throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGCLASSNAMERESOLVER );
            } catch ( ClassNotFoundException e ) {
                throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGCLASSNAMERESOLVER );
            } catch ( InstantiationException e ) {
                throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGCLASSNAMERESOLVER );
            } catch ( IllegalAccessException e ) {
                throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGCLASSNAMERESOLVER );
            } catch ( NoSuchMethodException e ) {
                throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGCLASSNAMERESOLVER );
            } catch ( InvocationTargetException e ) {
                throw new JmiGeneratorRuntimeException( e, JmiGeneratorTraces.EXCEPTIONGETTINGCLASSNAMERESOLVER );
            }
        }

        /**
         * @param mofClass
         * @param getClassProxy
         * @return the class name
         */
        public String getJavaClassName( MofClass mofClass, boolean getClassProxy ) {

            try {
                return (String) this.myClassMethod.invoke( this.myResolver, mofClass, Boolean.valueOf( getClassProxy ) );
            } catch ( IllegalArgumentException e ) {
                throw new RuntimeException( e );
            } catch ( IllegalAccessException e ) {
                throw new RuntimeException( e );
            } catch ( InvocationTargetException e ) {
                throw new RuntimeException( e );
            }
        }

        /**
         * @param element
         * @return the class name
         */
        public String getJavaClassName( ModelElement element ) {

            return callMethodInternal( element );
        }

        private String callMethodInternal( ModelElement me ) {

            try {
                return (String) this.myGenericMethod.invoke( this.myResolver, me );
            } catch ( IllegalArgumentException e ) {
                throw new RuntimeException( e );
            } catch ( IllegalAccessException e ) {
                throw new RuntimeException( e );
            } catch ( InvocationTargetException e ) {
                throw new RuntimeException( e );
            }
        }

    }

    private void initEndToQueryInfo( Association a ) {

        List<AssociationEnd> aes = this.jmiHelper.getAssociationEnds( this.myConnection.getSession( ), a );
        AssociationEnd ae0 = aes.get( 0 );
        AssociationEnd ae1 = aes.get( 1 );
        int ae0Upper = ae0.getMultiplicity( ).getUpper( ) == -1 ? Integer.MAX_VALUE : ae0.getMultiplicity( ).getUpper( );
        int ae1Upper = ae1.getMultiplicity( ).getUpper( ) == -1 ? Integer.MAX_VALUE : ae1.getMultiplicity( ).getUpper( );

        if ( ae0Upper == 1 && ae1Upper == 1 ) {
            if ( this.jmiHelper.isEndStored( this.myConnection.getSession( ), ae0 ) ) {
                this.endToQuery.put( ae0, Boolean.TRUE );
                this.endToQuery.put( ae1, Boolean.FALSE );
            } else {
                this.endToQuery.put( ae0, Boolean.FALSE );
                this.endToQuery.put( ae1, Boolean.TRUE );
            }
        } else {
            if ( ae0.getMultiplicity( ).isOrdered( ) == true ) {
                this.endToQuery.put( ae0, Boolean.FALSE );
                this.endToQuery.put( ae1, Boolean.TRUE );
            } else if ( ae1.getMultiplicity( ).isOrdered( ) == true ) {
                this.endToQuery.put( ae0, Boolean.TRUE );
                this.endToQuery.put( ae1, Boolean.FALSE );
            } else {
                if ( this.jmiHelper.isEndStored( this.myConnection.getSession( ), ae0 ) ) {
                    this.endToQuery.put( ae0, Boolean.TRUE );
                    this.endToQuery.put( ae1, Boolean.FALSE );
                } else {
                    this.endToQuery.put( ae0, Boolean.FALSE );
                    this.endToQuery.put( ae1, Boolean.TRUE );
                }
            }
        }
    }

    private boolean isEndToQuery( AssociationEnd ae ) {

        boolean result;
        Boolean isEndToQuery = this.endToQuery.get( ae );
        if ( isEndToQuery == null ) {
            initEndToQueryInfo( (Association) ae.getContainer( ) );
            isEndToQuery = this.endToQuery.get( ae );
        }
        result = isEndToQuery.booleanValue( );
        return result;
    }

    private void writeMofRom( ClassicalGeneratorInput gi, Writer out, String className ) throws IOException {

        /**
         * header
         */
        try {
            out.write( "/* \n" ); //$NON-NLS-1$
            out.write( " * MOF ROM generated by: \"" + this.getClass( ).getName( ) + "\"\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( " * version: " + VERSION + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( " * date: " + new Date( ).toString( ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( " * user: " + System.getProperty( USER_NAME ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( " */ \n" ); //$NON-NLS-1$
            if ( this.packageName != null && this.packageName.length( ) > 0 ) {
                out.write( "package " + this.packageName + "; \n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            out.write( "import java.util.Arrays;                                     \n" ); //$NON-NLS-1$
            out.write( "import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;                      \n" ); //$NON-NLS-1$
            out.write( "import com.sap.tc.moin.repository.core.jmi.extension.RefBaseObjectExtension; \n" ); //$NON-NLS-1$
            out.write( "/**\n" ); //$NON-NLS-1$
            out.write( " * Generated\n" ); //$NON-NLS-1$
            out.write( " */\n" ); //$NON-NLS-1$
            out.write( "@SuppressWarnings( \"nls\" )\n" ); //$NON-NLS-1$
            out.write( "public class " + className + " implements MofRomPhase {                               \n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( "                                                             \n" ); //$NON-NLS-1$

            out.write( "    private RefBaseObject[] instancesArray;            \n" ); //$NON-NLS-1$
            out.write( "    private MoinMofRomServicesImpl services;                 \n" ); //$NON-NLS-1$
            out.write( "    private RefBaseObjectExtension rboe;                     \n" ); //$NON-NLS-1$
            out.write( "                                                             \n" ); //$NON-NLS-1$
            out.write( "    /**                                                                       \n" ); //$NON-NLS-1$
            out.write( "     * Instantiates the MOF ROM and loads all instances                       \n" ); //$NON-NLS-1$
            out.write( "     * @param mofRomServices                                                        \n" ); //$NON-NLS-1$
            out.write( "     */                                                                       \n" ); //$NON-NLS-1$

            // constructor
//        out.write( "    public " + className + " (MoinMofRomServicesImpl mofRomServices) {    \n" );
//        out.write( "        this.services = mofRomServices;                                       \n" );
//        out.write( "        this.instances = this.services.getInstances();                        \n" );
//        out.write( "        this.rboe = null;                                             \n" );
//        out.write( "    }                                                                 \n" );
//        out.write( "                                                                      \n" );

            out.write( "    public " + className + " ()  {    \n" ); //$NON-NLS-1$ //$NON-NLS-2$        
            out.write( "    }                                                                 \n" ); //$NON-NLS-1$
            out.write( "                                                                      \n" ); //$NON-NLS-1$

            out.write( "    public void setMoinMofRomServicesImpl(MoinMofRomServicesImpl mofRomServices) {    \n" ); //$NON-NLS-1$
            out.write( "        this.services = mofRomServices;                                       \n" ); //$NON-NLS-1$
            out.write( "        this.instancesArray = this.services.getInstancesArray(" + gi.instances.size( ) + ");                        \n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( "        this.rboe = null;                                             \n" ); //$NON-NLS-1$
            out.write( "    }                                                                 \n" ); //$NON-NLS-1$

            /**
             * Create all instances
             */
            List<String> instanceMethods = new ArrayList<String>( );
            int numberOfInstances = 0;
            int instanceNumber = 0;
            for ( Iterator<String> i = gi.keys.iterator( ); i.hasNext( ); numberOfInstances++ ) {
                if ( numberOfInstances > INSTANCE_SIZE || instanceNumber == 0 ) {
                    numberOfInstances = 0;
                    String methodName = "createInstances" + instanceNumber; //$NON-NLS-1$
                    if ( instanceNumber > 0 ) {
                        out.write( "    } \n" ); //$NON-NLS-1$
                    }
                    out.write( "    private void " + methodName + "() { \n" ); //$NON-NLS-1$ //$NON-NLS-2$
                    instanceMethods.add( methodName );
                    instanceNumber++;
                }
                RefBaseObject rbo = gi.instances.get( i.next( ) );
                out.write( "// " + getLabel( rbo ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                if ( rbo instanceof RefClass && !isReflectElement( (RefClass) rbo ) && !isAbstract( (RefClass) rbo ) ) {

                    String implClassName = this.classNameResolver.getJavaClassName( (MofClass) rbo.refMetaObject( ), false/* getClassProxy */);
                    out.write( "        this.rboe = new " + getJavaClassName( rbo ) + "(\"" + implClassName + "\"); \n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

                } else {
                    out.write( "        this.rboe = new " + getJavaClassName( rbo ) + "(); \n" ); //$NON-NLS-1$ //$NON-NLS-2$
                }
                out.write( "        this.rboe.set___MofId(" + getMofIdLiteral( rbo ) + "); \n" ); //$NON-NLS-1$ //$NON-NLS-2$
                out.write( "        this.instancesArray[" + this.globalInstanceIndexes.get( rbo ) + "] = this.rboe; \n" ); //$NON-NLS-1$ //$NON-NLS-2$
//FIXME            out.write( "        this.instances.put(" + getMofIdAsLiteral( rbo ) + ", this.rboe); \n" );
            }
            out.write( "    }                                                      \n" ); //$NON-NLS-1$
            out.write( "                                                           \n" ); //$NON-NLS-1$
            out.write( "                                                       \n" ); //$NON-NLS-1$
            out.write( "    /**                                                \n" ); //$NON-NLS-1$
            out.write( "     * Create all instances                            \n" ); //$NON-NLS-1$
            out.write( "     */                                                \n" ); //$NON-NLS-1$
            out.write( "    public void createInstances() {                     \n" ); //$NON-NLS-1$
            for ( String methodName : instanceMethods ) {
                out.write( "        " + methodName + "(); \n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            out.write( "    }                                                  \n" ); //$NON-NLS-1$

            /**
             * Set the properties
             */
            List<String> attributesMethods = new ArrayList<String>( );
            int numberOfMethods = 0;
            int methodNumber = 0;
            for ( Iterator<String> i = gi.keys.iterator( ); i.hasNext( ); numberOfMethods++ ) {
                if ( numberOfMethods > METHOD_SIZE || methodNumber == 0 ) {
                    numberOfMethods = 0;
                    String methodName = "setAttributes" + methodNumber; //$NON-NLS-1$
                    if ( methodNumber > 0 ) {
                        out.write( "    } \n" ); //$NON-NLS-1$
                    }
                    out.write( "    private void " + methodName + "() { \n" ); //$NON-NLS-1$ //$NON-NLS-2$
                    attributesMethods.add( methodName );
                    methodNumber++;
                }
                String refBaseObjectMofId = i.next( );
                RefBaseObject rbo = gi.instances.get( refBaseObjectMofId );
                refBaseObjectMofId = getInstanceIndex( rbo );
                String refMetaObjectMofId = getInstanceIndex( rbo.refMetaObject( ) );
                String refImmediatePackageMofId = rbo.refImmediatePackage( ) != null ? getInstanceIndex( rbo.refImmediatePackage( ) ) : "null"; //$NON-NLS-1$
                out.write( "// " + getLabel( rbo ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                if ( rbo instanceof RefObject ) {
                    RefObject ro = (RefObject) rbo;
                    String refClassMofId = getInstanceIndex( ro.refClass( ) );
                    List<String> qn = ( (ModelElementInternal) ro ).getQualifiedName( this.myConnection );
                    StringBuffer qns = new StringBuffer( );
                    qns.append( "new String[]{" ); //$NON-NLS-1$
                    for ( Iterator<String> j = qn.iterator( ); j.hasNext( ); ) {
                        String np = j.next( );
                        qns.append( "\"" + np + ( j.hasNext( ) ? "\"," : "\"" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    }
                    qns.append( "}" ); //$NON-NLS-1$
                    out.write( "        this.services.initRefObjectExtension(" + refBaseObjectMofId + "," + refMetaObjectMofId + "/*meta*/," + refImmediatePackageMofId + "/*impack*/," + refClassMofId + "/*refclass*/," + qns.toString( ) + "); \n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                    String code = getCodeToSetValues( ro );
                    out.write( "        " + code + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                    if ( ro instanceof Association ) {
                        out.write( "        " + getCodeForAssociationInfo( (Association) ro ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                    } else if ( ro instanceof AssociationEnd ) {
                        out.write( "        " + getCodeForAssociationEndInfo( (AssociationEnd) ro ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                } else if ( rbo instanceof RefPackage ) {
                    // RefPackage rp = (RefPackage) rbo;
                    out.write( "        this.services.initRefPackageExtension(" + refBaseObjectMofId + "," + refMetaObjectMofId + "/*meta*/," + refImmediatePackageMofId + "/*impack*/," + "null" + "); \n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                } else if ( rbo instanceof RefAssociation ) {
                    // RefAssociation ra = (RefAssociation) rbo;
                    out.write( "        this.services.initRefAssociationExtension(" + refBaseObjectMofId + "," + refMetaObjectMofId + "/*meta*/," + refImmediatePackageMofId + "/*impack*/," + "null" + "); \n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                } else if ( rbo instanceof RefClass ) {
                    // RefClass rc = (RefClass) rbo;
                    out.write( "        this.services.initRefClassExtension(" + refBaseObjectMofId + "," + refMetaObjectMofId + "/*meta*/," + refImmediatePackageMofId + "/*impack*/," + "null" + "); \n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                } else if ( rbo instanceof RefStruct ) {
                    RefStructExtension rs = (RefStructExtension) rbo;
                    throw new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.REFSTRUCTURENOTHANDLEDYET, rs.refTypeName( ) );
                } else {
                    throw new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.UNKNOWNTYPE );
                }
                if ( !i.hasNext( ) ) {
                    out.write( "    } \n" ); //$NON-NLS-1$
                }
            }
            out.write( "                                                       \n" ); //$NON-NLS-1$
            out.write( "    /**                                                \n" ); //$NON-NLS-1$
            out.write( "     * Set the attributes                              \n" ); //$NON-NLS-1$
            out.write( "     */                                                \n" ); //$NON-NLS-1$
            out.write( "    public void setAttributes() {                     \n" ); //$NON-NLS-1$
            for ( Iterator<String> i = attributesMethods.iterator( ); i.hasNext( ); ) {
                String methodName = i.next( );
                out.write( "        " + methodName + "(); \n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            out.write( "    }                                                  \n" ); //$NON-NLS-1$

            // the links
            Set<String> assocNames = new TreeSet<String>( );
            Map<String, Association> assocNamesToAssocs = new LinkedHashMap<String, Association>( );

            for ( Association a : gi.links.keySet( ) ) {
                String name = a.getName( );
                assocNames.add( name );
                assocNamesToAssocs.put( name, a );
            }

            List<String> linkMethods = new ArrayList<String>( );
            methodNumber = 0;
            int numberOfLinks = 0;

            for ( String assocName : assocNames ) {
                Association assoc = assocNamesToAssocs.get( assocName );
                out.write( "// " + getLabel( assoc ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                for ( SetLink setLink : gi.links.get( assoc ) ) {
                    if ( numberOfLinks > INSTANCE_SIZE || methodNumber == 0 ) {
                        numberOfLinks = 0;
                        String methodName = "loadLinks" + methodNumber; //$NON-NLS-1$
                        if ( methodNumber > 0 ) {
                            out.write( "    } \n" ); //$NON-NLS-1$
                        }
                        out.write( "    private void " + methodName + "() { \n" ); //$NON-NLS-1$ //$NON-NLS-2$
                        linkMethods.add( methodName );
                        methodNumber++;
                    }
                    out.write( "        this.services.loadLink(" + getInstanceIndex( assoc ) + ", " + getInstanceIndex( setLink.o1 ) + ", " + getInstanceIndex( setLink.o2 ) + ");" + "// " + "1.end " + getShortLabel( setLink.o1 ) + " | " + "2.end " + getShortLabel( setLink.o2 ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
                    numberOfLinks++;
                }
            }
            out.write( "    }\n" ); //$NON-NLS-1$

            /**
             * Load the links
             */
            out.write( "    /**                                                \n" ); //$NON-NLS-1$
            out.write( "     * Load the links                                  \n" ); //$NON-NLS-1$
            out.write( "     */                                                \n" ); //$NON-NLS-1$
            out.write( "    public void loadLinks() {                         \n" ); //$NON-NLS-1$

            for ( String linkMethod : linkMethods ) {
                out.write( "        " + linkMethod + "();\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            out.write( "    }\n" ); //$NON-NLS-1$

            //sanity info
            out.write( "    public int getNumberOfInstances(){                         \n" ); //$NON-NLS-1$
            out.write( "        return " + gi.instances.size( ) + ";\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( "    }\n" ); //$NON-NLS-1$

            out.write( "    public int getNumberOfAssociations(){                         \n" ); //$NON-NLS-1$
            out.write( "        return " + gi.links.keySet( ).size( ) + ";\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( "    }\n" ); //$NON-NLS-1$

            int linkCount = 0;
            Collection<List<SetLink>> allLinks = gi.links.values( );
            for ( List<SetLink> links : allLinks ) {
                linkCount += links.size( );
            }
            out.write( "    public int getNumberOfLinks(){                         \n" ); //$NON-NLS-1$
            out.write( "        return " + linkCount + ";\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            out.write( "    }\n" ); //$NON-NLS-1$

            /**
             * tail
             */
            {
                out.write( "} // class MoinMofRom \n" ); //$NON-NLS-1$
            }
        } finally {
            if ( out != null ) {
                out.close( );
            }
        }
    }

    private void export( ClassicalGeneratorInput gi ) throws IOException {

        List<Class<? extends RefBaseObject>> refBaseObjects = new ArrayList<Class<? extends RefBaseObject>>( );
        Map<Class<? extends RefBaseObject>, Integer> refBaseObjectCount = new LinkedHashMap<Class<? extends RefBaseObject>, Integer>( );

        Writer writer = this.writerProvider.getWriterForTxtOutput( );
        try {
            for ( String mofid : gi.keys ) {
                RefBaseObject o = gi.instances.get( mofid );
                writer.write( getLabel( o ) + "\n" ); //$NON-NLS-1$

                Integer count = refBaseObjectCount.get( o.getClass( ) );
                if ( count == null ) {
                    refBaseObjectCount.put( o.getClass( ), Integer.valueOf( 1 ) );
                } else {
                    refBaseObjectCount.put( o.getClass( ), Integer.valueOf( count.intValue( ) + 1 ) );
                }
                if ( !refBaseObjects.contains( o.getClass( ) ) ) {
                    refBaseObjects.add( o.getClass( ) );
                }
            }
            writer.write( "\n" ); //$NON-NLS-1$
            writer.write( " * * * * * * * * * * * * * * * * * * * * * * \n" ); //$NON-NLS-1$
            writer.write( "\n" ); //$NON-NLS-1$

            List<Association> associations = new ArrayList<Association>( );
            Map<Association, Integer> associationCount = new LinkedHashMap<Association, Integer>( );

            for ( Association assoc : gi.links.keySet( ) ) {
                writer.write( ( (AssociationInternal) assoc ).getQualifiedName( this.myConnection ) + "::" + getInstanceIndex( assoc ) + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
                for ( SetLink link : gi.links.get( assoc ) ) {
                    writer.write( link + "\n" ); //$NON-NLS-1$
                    Integer count = associationCount.get( assoc );
                    if ( count == null ) {
                        associationCount.put( assoc, Integer.valueOf( 1 ) );
                    } else {
                        associationCount.put( assoc, Integer.valueOf( count.intValue( ) + 1 ) );
                    }
                    if ( !associations.contains( assoc ) ) {
                        associations.add( assoc );
                    }
                }
            }
            writer.write( "\n" ); //$NON-NLS-1$
            writer.write( " * * * * * * * * * * * * * * * * * * * * * * \n" ); //$NON-NLS-1$
            writer.write( "\n" ); //$NON-NLS-1$

            // sort the associations statistics by qualified name
            Collections.sort( associations, new Comparator<Association>( ) {

                public int compare( Association o1, Association o2 ) {

                    return ( (AssociationInternal) o1 ).getQualifiedName( MoinMofRomGeneratorNG.this.myConnection ).toString( ).compareTo( ( (AssociationInternal) o2 ).getQualifiedName( MoinMofRomGeneratorNG.this.myConnection ).toString( ) );
                }

            } );

            // sort the instance statistics by class name
            Collections.sort( refBaseObjects, new Comparator<Class<? extends RefBaseObject>>( ) {

                public int compare( Class<? extends RefBaseObject> o1, Class<? extends RefBaseObject> o2 ) {

                    return o1.getName( ).compareTo( o2.getName( ) );
                }

            } );

            for ( Class<? extends RefBaseObject> cls : refBaseObjects ) {
                Integer count = refBaseObjectCount.get( cls );
                writer.write( "Instance: " + cls.getName( ) + ": " + count + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }

            writer.write( "\n" ); //$NON-NLS-1$

            for ( Association assoc : associations ) {
                Integer count = associationCount.get( assoc );
                writer.write( "Association: " + ( (AssociationInternal) assoc ).getQualifiedName( this.myConnection ) + ": " + count + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        } finally {
            if ( writer != null ) {
                writer.flush( );
                writer.close( );
            }
        }

    }

    private String getCodeForAssociationEndInfo( AssociationEnd ae ) {

        StringBuffer code = new StringBuffer( );
        code.append( "this.services.initAssociationEndImplExtension(" ); //$NON-NLS-1$
        code.append( getInstanceIndex( ae ) + "," ); //$NON-NLS-1$
        Association a = (Association) ( (AssociationEndInternal) ae ).getContainer( this.myConnection );
        code.append( getInstanceIndex( a ) + "," ); //$NON-NLS-1$
        int endNumber = this.jmiHelper.getAssociationEndNumber( this.myConnection.getSession( ), ae );
        code.append( endNumber + "," ); //$NON-NLS-1$
        boolean composite = this.jmiHelper.getCompositeEnd( this.myConnection.getSession( ), a ) == endNumber;
        code.append( composite + "," ); //$NON-NLS-1$
        boolean ordered = ae.getMultiplicity( ).isOrdered( );
        code.append( ordered + "," ); //$NON-NLS-1$
        boolean stored = this.jmiHelper.isEndStored( this.myConnection.getSession( ), ae );
        code.append( stored + "" ); //$NON-NLS-1$
        code.append( ");" ); //$NON-NLS-1$
        return code.toString( );
    }

    private String getCodeForAssociationInfo( Association a ) {

        StringBuffer code = new StringBuffer( );
        code.append( "this.services.initAssociationImplExtension(" ); //$NON-NLS-1$
        code.append( getInstanceIndex( a ) + "," ); //$NON-NLS-1$
        code.append( "new int[]{" ); //$NON-NLS-1$
        for ( Iterator<AssociationEnd> i = this.jmiHelper.getAssociationEnds( this.myConnection.getSession( ), a ).iterator( ); i.hasNext( ); ) {
            AssociationEnd ae = i.next( );
            code.append( getInstanceIndex( ae ) );
            if ( i.hasNext( ) ) {
                code.append( "," ); //$NON-NLS-1$
            }
        }
        code.append( "}" ); //$NON-NLS-1$
        code.append( ");" ); //$NON-NLS-1$
        return code.toString( );
    }

    private String getCodeToSetValues( RefObject ro ) {

        StringBuffer code = new StringBuffer( "" ); //$NON-NLS-1$
        Map<Attribute, Object> values = this.jmiHelper.getAttributesWithValues( this.myConnection, ro, true );
        List<Attribute> filteredAttributes = new ArrayList<Attribute>( );
        for ( Attribute attribute : values.keySet( ) ) {
            if ( !attribute.isDerived( ) && attribute.getVisibility( ).equals( VisibilityKindEnum.PUBLIC_VIS ) ) {
                filteredAttributes.add( attribute );
            }
        }
        if ( filteredAttributes.size( ) > 0 ) {
            code.append( "this.services.setValues(" + getInstanceIndex( ro ) + ", new Object[][] {" ); //$NON-NLS-1$ //$NON-NLS-2$
            for ( Iterator<Attribute> i = filteredAttributes.iterator( ); i.hasNext( ); ) {
                Attribute attribute = i.next( );
                Object value = values.get( attribute );
                code.append( "\n            " ); //$NON-NLS-1$
                code.append( "{\"" + attribute.getName( ) + "\"," + getCodeForValue( ro, attribute, value ) + "}" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                if ( i.hasNext( ) ) {
                    code.append( "," ); //$NON-NLS-1$
                }
            }
            code.append( "});" ); //$NON-NLS-1$
        }
        return code.toString( );
    }

    @SuppressWarnings( "unchecked" )
    private String getCodeForValue( RefObject ro, Attribute attribute, Object value ) {

        String valueString;
        if ( value instanceof String ) {
            String typedValue = (String) value;
            // valueString = "\"" + utilities.encodeAsJavaLiteral(typedValue) +
            // "\""; // old version
            valueString = this.utilities.javaStringLiteral( typedValue );
        } else if ( value instanceof Boolean ) {
            Boolean typedValue = (Boolean) value;
            valueString = typedValue.booleanValue( ) == true ? "Boolean.TRUE" : "Boolean.FALSE"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( value instanceof Integer ) {
            int typedValue = ( (Integer) value ).intValue( );
            valueString = "new Integer(" + typedValue + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( value instanceof Long ) {
            long typedValue = ( (Long) value ).longValue( );
            valueString = "new Long(" + typedValue + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( value instanceof Float ) {
            float typedValue = ( (Float) value ).floatValue( );
            valueString = "new Float(" + typedValue + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( value instanceof Double ) {
            double typedValue = ( (Double) value ).doubleValue( );
            valueString = "new Double(" + typedValue + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( value instanceof MultiplicityType ) {
            MultiplicityType mt = (MultiplicityType) value;
            valueString = "this.services.createMultiplicityType(" + getInstanceIndex( ( (AttributeInternal) attribute ).getType( this.myConnection ) ) + ", " + mt.getLower( ) + "/*lower*/, " + mt.getUpper( ) + "/*upper*/, " + mt.isOrdered( ) + "/*ordered*/, " + mt.isUnique( ) + "/*unique*/)"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
        } else if ( value instanceof RefStruct ) {
            throw new RuntimeException( "unhandled type " + value.getClass( ) ); //$NON-NLS-1$
        } else if ( value instanceof RefEnum ) {
            RefEnum re = (RefEnum) value;
            valueString = getJavaClassName( value ) + ".forName(\"" + re.toString( ) + "\")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else if ( value instanceof Collection ) {
            StringBuffer buf = new StringBuffer( );
            Collection col = (Collection) value;
            buf.append( "Arrays.asList(new Object[]{" ); //$NON-NLS-1$
            for ( Iterator<Object> i = col.iterator( ); i.hasNext( ); ) {
                Object element = i.next( );
                buf.append( getCodeForValue( null, null, element ) );
                if ( i.hasNext( ) ) {
                    buf.append( ',' );
                }
            }
            buf.append( "})" ); //$NON-NLS-1$
            valueString = buf.toString( );
        } else if ( value == null ) {
            if ( attribute.getName( ).equals( "annotation" ) ) { //$NON-NLS-1$
                valueString = "\"\""; //$NON-NLS-1$
            } else if ( attribute.getMultiplicity( ).getLower( ) >= 1 ) {
                String id = ro instanceof ModelElement ? ( (ModelElement) ro ).getQualifiedName( ).toString( ) : ro.toString( );
                throw new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.NULLFORMANDATORYATTRIBUTE, attribute.getName( ), id );
            } else {
                valueString = "null"; //$NON-NLS-1$
            }
        } else {
            throw new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.UNHANDLEDVALUETYPE, value.getClass( ).getName( ) );
        }
        return valueString;
    }

    String getLabel( RefBaseObject rbo ) {

        String result;

        String qualifiedName = null;
        if ( rbo instanceof ModelElementInternal ) {
            qualifiedName = ( (ModelElementInternal) rbo ).getQualifiedName( this.myConnection ).toString( );
        } else if ( rbo instanceof RefPackage ) {
            qualifiedName = "<Package Extent>"; //$NON-NLS-1$
        } else if ( rbo instanceof RefClass ) {
            qualifiedName = "<Class Extent>"; //$NON-NLS-1$
        } else if ( rbo instanceof RefAssociation ) {
            qualifiedName = "<Association Extent>"; //$NON-NLS-1$
        }
        result = rbo.getClass( ).getName( ) + "::" + ( (ModelElementInternal) rbo.refMetaObject( ) ).getQualifiedName( this.myConnection ) + "::" + qualifiedName + "::" + getInstanceIndex( rbo ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        return result;
    }

    private String getShortLabel( Object o ) {

        String result;
        if ( o instanceof RefBaseObject ) {
            RefBaseObject rbo = (RefBaseObject) o;
            String qualifiedName = null;
            if ( rbo instanceof ModelElement ) {
                qualifiedName = ( (ModelElementInternal) rbo ).getQualifiedName( this.myConnection ).toString( );
            } else if ( rbo instanceof RefPackage ) {
                qualifiedName = "<Package Extent>"; //$NON-NLS-1$
            } else if ( rbo instanceof RefClass ) {
                qualifiedName = "<Class Extent>"; //$NON-NLS-1$
            } else if ( rbo instanceof RefAssociation ) {
                qualifiedName = "<Association Extent>"; //$NON-NLS-1$
            }
            String qualifiedNameMetaObject = ( (ModelElementInternal) rbo.refMetaObject( ) ).getQualifiedName( this.myConnection ).toString( );
            result = qualifiedNameMetaObject + "::" + qualifiedName; //$NON-NLS-1$
        } else {
            result = o.getClass( ).getName( ) + " ?"; //$NON-NLS-1$
        }
        return result;
    }

    private String getMofIdLiteral( RefBaseObject rbo ) {

        String mofId;
        mofId = "\"" + rbo.refMofId( ) + "\""; //$NON-NLS-1$ //$NON-NLS-2$
        return mofId;
    }

    private String getInstanceIndex( RefBaseObject rbo ) {

        return this.globalInstanceIndexes.get( rbo ) + ""; //$NON-NLS-1$
    }

    private boolean isReflectElement( RefClass refClass ) {

        MofClassInternal mofClass = (MofClassInternal) refClass.refMetaObject( );
        List<String> qn = mofClass.getQualifiedName( this.myConnection );
        if ( qn.size( ) == 2 && mofClass.getContainer( this.myConnection ).getName( ).equals( "Reflect" ) && mofClass.getName( ).equals( "Element" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
            return true;
        }
        return false;
    }

    private boolean isAbstract( RefClass refClass ) {

        MofClassInternal mofClass = (MofClassInternal) refClass.refMetaObject( );
        return mofClass.isAbstract( );
    }

    private String getJavaClassName( Object javaObject ) {

        if ( javaObject instanceof RefPackage ) {
            MofPackageInternal mofPackage = (MofPackageInternal) ( (RefPackage) javaObject ).refMetaObject( );
            List<String> qn = mofPackage.getQualifiedName( this.myConnection );
            if ( qn.size( ) == 1 && mofPackage.getName( ).equals( "Reflect" ) ) { //$NON-NLS-1$
                return "com.sap.tc.moin.repository.core.jmi.reflect.RefPackageImplDynamic"; //$NON-NLS-1$
            }
        } else if ( javaObject instanceof RefClass ) {
            if ( isReflectElement( (RefClass) javaObject ) ) {
                return "com.sap.tc.moin.repository.core.jmi.reflect.RefClassImplDynamic"; //$NON-NLS-1$
            }
            return "com.sap.tc.moin.repository.core.jmi.reflect.RefClassImpl"; //$NON-NLS-1$
        }

        String result = null;

        String fqn = javaObject.getClass( ).getName( );
        if ( javaObject instanceof RefPackage ) {
            result = fqn; // TODO extend the JmiClassNameResolver
        } else if ( javaObject instanceof RefClass ) {
            MofClass mofClass = ( (RefClass) javaObject ).refMetaObject( );
            result = this.classNameResolver.getJavaClassName( mofClass, true/* getClassProxy */);
        } else if ( javaObject instanceof RefAssociation ) {
            result = fqn; // TODO extend the JmiClassNameResolver
        } else if ( javaObject instanceof RefObject ) {
            MofClass mofClass = (MofClass) ( (RefObject) javaObject ).refMetaObject( );
            result = this.classNameResolver.getJavaClassName( mofClass, false/* getClassProxy */);
        } else if ( javaObject instanceof RefStruct ) {
            StructureType structureType = (StructureType) ( (RefStructExtension) javaObject ).get___MetaObject( );
            result = this.classNameResolver.getJavaClassName( structureType );
        } else if ( javaObject instanceof RefEnum ) {
            result = fqn; // TODO extend the JmiClassNameResolver
        } else {
            throw new MoinLocalizedBaseRuntimeException( JmiGeneratorTraces.NOJAVACLASSNAME, javaObject );
        }
        for ( String prefix : javaClassNameMapping.keyList( ) ) {
            if ( fqn.startsWith( prefix ) ) {
                String replacement = javaClassNameMapping.get( prefix );
                result = replacement + fqn.substring( prefix.length( ) );
                break;
            }
        }

        return result;
    }

    private static final class DefaultWriterProvider implements WriterProvider {

        private String outputPath;

        private String mofRomTxtInfoFilePath;

        public DefaultWriterProvider( String outPutFolder ) {

            StringBuffer correctedOutPutFolder = new StringBuffer( );
            if ( outPutFolder.endsWith( "/" ) || outPutFolder.endsWith( "\\" ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                correctedOutPutFolder.append( outPutFolder.substring( 0, outPutFolder.length( ) - 2 ) );
            } else {
                correctedOutPutFolder.append( outPutFolder );
            }
            this.outputPath = correctedOutPutFolder.toString( );
            this.mofRomTxtInfoFilePath = this.outputPath + "\\" + MOFROM_INFO_FILENAME; //$NON-NLS-1$
        }

        public Writer getWriterForMofRomPhase( int phase ) {

            String path = this.outputPath + "\\" + MOFROM_FILENAME + phase + ".java"; //$NON-NLS-1$ //$NON-NLS-2$
            return createWriter( path );
        }

        private Writer createWriter( String path ) {

            File outputFile = new File( path );
            BufferedWriter result;
            try {
                outputFile.getParentFile( ).mkdirs( );
                result = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( outputFile ), "UTF-8" ) ); //$NON-NLS-1$
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }
            return result;
        }

        public Writer getWriterForTxtOutput( ) {

            return createWriter( this.mofRomTxtInfoFilePath );
        }

    }

    /**
     * Writer Provider
     */
    public interface WriterProvider {

        /**
         * @param phase
         * @return the writer
         */
        public Writer getWriterForMofRomPhase( int phase );

        /**
         * @return the writer
         */
        public Writer getWriterForTxtOutput( );
    }

}
