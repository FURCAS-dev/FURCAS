package com.sap.tc.moin.repository.test.performance;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

public class JmiHandler {

    /**
     * member for singleton pattern
     */
    private static JmiHandler jmiHandler = null;

    /**
     * This private no-arg constructor avoids that a default public constructor
     * is generated.
     */
    private JmiHandler( ) {

        // intentionally does nothing
    }

    /**
     * This methods returns the singleton instance for the JmiHandler
     * 
     * @return the singleton instance of the JmiHandler
     */
    public static JmiHandler getInstance( ) {

        if ( jmiHandler == null ) {
            jmiHandler = new JmiHandler( );
        }
        return jmiHandler;
    }

    public Collection<MofClass> createMultipleMofClasses( int count, ModelPackage modelPackage, Collection<OperationStatistics> statistics ) {

        Collection<MofClass> result = new ArrayList<MofClass>( );
        long time = System.currentTimeMillis( );
        long memory = Runtime.getRuntime( ).freeMemory( );
        for ( int i = 0; i < count; i++ ) {
            result.add( createMofClass( "Anonymous MofClass", modelPackage ) );
        }
        time = System.currentTimeMillis( ) - time;
        memory -= Runtime.getRuntime( ).freeMemory( );
        if ( statistics != null ) {
            statistics.add( new OperationStatistics( "create MofClass", count, time, memory ) );
        }
        return result;
    }

    public MofPackage createMofPackage( String name, ModelPackage modelPackage ) {

        MofPackage result = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        result.setName( name );
        result.setAnnotation( "AnAnnotation" );
        result.setRoot( true );
        result.setLeaf( false );
        result.setAbstract( false );
        result.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        return result;
    }

    public MofClass createMofClass( String name, ModelPackage modelPackage ) {

        MofClass result = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        result.setName( name );
        result.setAnnotation( "AnAnnotation" );
        result.setRoot( true );
        result.setLeaf( false );
        result.setAbstract( false );
        result.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        result.setSingleton( false );
        return result;
    }

    public static void main( String[] args ) {

        JmiHandler.getInstance( );
    }
}
