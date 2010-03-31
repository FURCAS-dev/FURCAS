package com.sap.tc.moin.facility.primary.test.configuration;


import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.easymock.EasyMock;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.facility.primary.AbstractPrimaryFacility;
import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiOperationService;
import com.sap.tc.moin.repository.spi.core.SpiPartitionService;
import com.sap.tc.moin.repository.spi.core.SpiStageService;
import com.sap.tc.moin.repository.spi.core.cps.SpiMetamodelService;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionReader;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiTransactionManager;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Base test class for facility component dependency injection correctness
 * sanity checks.
 * 
 * @author D047015
 */
public abstract class AbstractTestFacilityComponentConfiguration extends MoinTestCase {

    private static int mockCounter = 0;

//    /*
//     * preparation for adaption of binding mechanism (one bind method per
//     * facility component)
//     */
//    @Ignore
//    protected void testDependencyInjectionCorrectnessNew( AbstractPrimaryFacility facilityUnderTest ) throws IllegalArgumentException, IllegalAccessException {
//
//        System.out.println( "Validating dependency injection correctness of facility: " + facilityUnderTest.getClass( ).getName( ) );
//
//        // collect data for result record
//        boolean failed = false;
//        List<String> messages = new ArrayList<String>( );
//
//        // get all facility components
//        List<IpiFacilityComponent> facilityComponents = this.extractFacilityComponents( facilityUnderTest );
//        if ( facilityComponents == null || facilityComponents.size( ) <= 0 ) {
//            System.out.println( "Found no facility copmonents to check." );
//            return;
//        }
//
//        // detect bindings
//
//
//    }

    /**
     * Checks if all component dependencies of the passed facility were resolved
     * correctly in the given primary facility.
     * 
     * @param facilityUnderTest The facility to test.
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    protected void testDependencyInjectionCorrectness( AbstractPrimaryFacility facilityUnderTest ) throws IllegalArgumentException, IllegalAccessException {

        System.out.println( "Validating dependency injection correctness of facility: " + facilityUnderTest.getClass( ).getName( ) );

        // collect data for result record
        boolean failed = false;
        List<String> messages = new ArrayList<String>( );

        // get all facility components
        List<IpiFacilityComponent> facilityComponents = this.extractFacilityComponents( facilityUnderTest );
        if ( facilityComponents == null || facilityComponents.size( ) <= 0 ) {
            System.out.println( "Found no facility copmonents to check." );
            return;
        }

        // bindings per declaring type
        Map<Class<?>, List<Binding>> declaringTypeToBindings = new HashMap<Class<?>, List<Binding>>( );

        // TEST PHASE 1:
        // Find and validate all defined bindings
        failed = this.detectBindings( facilityComponents, declaringTypeToBindings, messages );

        // Test will fail here if phase 1 found illegal bindings
        if ( failed ) {
            this.failWithMessage( "Binding validation", messages );
        }

        // TEST PHASE 2:
        // - check if there are fields defined for each found binding
        // - check that the dependencies were resolved properly (field values must not be null)
        failed = validateBindings( declaringTypeToBindings, messages );

        if ( failed ) {
            this.failWithMessage( "Dependency injection check", messages );
        }
    }

    private boolean detectBindings( List<IpiFacilityComponent> facilityComponents, Map<Class<?>, List<Binding>> declaringTypeToBindings, List<String> messages ) {

        boolean failed = false;

        for ( IpiFacilityComponent facilityComponent : facilityComponents ) {
            if ( facilityComponent == null ) {
                failed = true;
                messages.add( "Registered facility component must not be null." );
            } else {
                Class<?> componentClass = facilityComponent.getClass( );

                // loop over all methods and collect the parameter types of the bind methods
                for ( Method method : componentClass.getMethods( ) ) {
                    if ( method.getName( ).equals( "bind" ) ) {
                        Class<?> declaringType = method.getDeclaringClass( );

                        // determine the parameter types
                        Class<?> bindMethodParameterTypes[] = method.getParameterTypes( );

                        // assert: there is at least one parameter to bind
                        if ( bindMethodParameterTypes.length == 0 ) {
                            failed = true;
                            StringBuilder message = new StringBuilder( );
                            message.append( "Error in facility component '" + facilityComponent.getClass( ).getName( ) + "':\n" );
                            message.append( "Bind method '" + method + "' does not define any parameters.\n" );
                            message.append( "Define type a to bind or remove the method." );
                            messages.add( message.toString( ) );

                            // ignore binding
                            continue;
                        }

                        // assert: all parameters have the same type if there is more than one
                        //         (mixed bindings are not allowed)
                        boolean allParametersHaveSameType = true;
                        for ( int i = 1; i < bindMethodParameterTypes.length; i++ ) {
                            if ( !bindMethodParameterTypes[i - 1].equals( bindMethodParameterTypes[i] ) ) {
                                allParametersHaveSameType = false;
                                break;
                            }
                        }
                        if ( !allParametersHaveSameType ) {
                            failed = true;
                            StringBuilder message = new StringBuilder( );
                            message.append( "Error in facility component '" + facilityComponent.getClass( ).getName( ) + "':\n" );
                            message.append( "Bind method '" + method + "' has parameters with different types.\n" );
                            message.append( "Use two separate bind methods instead." );
                            messages.add( message.toString( ) );

                            // ignore binding
                            continue;
                        }

                        // assert: we found a legal type to bind a) we bind interfaces only
                        if ( !bindMethodParameterTypes[0].isInterface( ) ) {
                            failed = true;
                            StringBuilder message = new StringBuilder( );
                            message.append( "Error in facility component '" + facilityComponent.getClass( ).getName( ) + "':" );
                            message.append( "\nBind method '" + method + "' defines the illegal parameter type '" + bindMethodParameterTypes[0] + "'\n" );
                            message.append( "The bound type is not an interface." );
                            messages.add( message.toString( ) );

                            // ignore binding
                            continue;
                        }

                        // assert: we found a legal type to bind b) we bind interfaces from allowed packages only
                        if ( !this.isAllowedBindInterface( bindMethodParameterTypes[0] ) ) {
                            failed = true;
                            StringBuilder message = new StringBuilder( );
                            message.append( "Error in facility component '" + facilityComponent.getClass( ).getName( ) + "':" );
                            message.append( "\nBind method '" + method + "' defines the illegal parameter type '" + bindMethodParameterTypes[0] + "'\n" );
                            message.append( "Use a type from an allowed MOIN package instead (API, SPI, and IPI interfaces or a non MOIN interface respectively)." );
                            messages.add( message.toString( ) );

                            // ignore binding
                            continue;
                        }

                        // register binding
                        Binding newBinding = new Binding( facilityComponent, declaringType, bindMethodParameterTypes[0], method, bindMethodParameterTypes.length );

                        // cross check with other bindings of declaring type
                        List<Binding> bindingsOfCurrentDeclaringType = declaringTypeToBindings.get( declaringType );
                        if ( bindingsOfCurrentDeclaringType == null ) {
                            bindingsOfCurrentDeclaringType = new ArrayList<Binding>( 3 );
                            declaringTypeToBindings.put( declaringType, bindingsOfCurrentDeclaringType );
                            // no conflicts, we add the binding
                            bindingsOfCurrentDeclaringType.add( newBinding );
                        } else {
                            int indexOfExistingBinding = bindingsOfCurrentDeclaringType.indexOf( newBinding );
                            if ( indexOfExistingBinding >= 0 ) {
                                throw new IllegalStateException( "There must not exist any conflicting binding for the current declaring type" );

                            } else {
                                // no conflicting bindings
                                bindingsOfCurrentDeclaringType.add( newBinding );
                            }
                        }
                    }
                }
            }
        }
        return failed;
    }

    private List<IpiFacilityComponent> extractFacilityComponents( AbstractPrimaryFacility facilityUnderTest ) {

        List<IpiFacilityComponent> facilityComponents = null;
        try {
            Field facilityComponentsField = AbstractPrimaryFacility.class.getDeclaredField( "facilityComponents" );
            facilityComponentsField.setAccessible( true );
            facilityComponents = (List<IpiFacilityComponent>) facilityComponentsField.get( facilityUnderTest );
        } catch ( Exception e ) {
            throw new RuntimeException( "Error while trying to inspect the facility under test reflectively: Expected field '" + AbstractPrimaryFacility.class.getName( ) + ".facilityComponents' not found in facility " + facilityUnderTest.getClass( ).getName( ), e );
        }
        return facilityComponents;
    }

    private void failWithMessage( String testPhase, List<String> messages ) {

        StringBuilder completeMessage = new StringBuilder( );
        completeMessage.append( testPhase + " failed with the following errors:\n" );
        for ( int i = 0; i < messages.size( ); i++ ) {
            completeMessage.append( ( i + 1 ) + ") " + messages.get( i ) + "\n" );
        }
        // cause the test to fail with the collected messages
        fail( completeMessage.substring( 0, completeMessage.length( ) - 1 ) );
    }

    private boolean validateBindings( Map<Class<?>, List<Binding>> declaringTypeToBindings, List<String> messages ) throws IllegalAccessException {

        boolean failed = false;

        for ( Map.Entry<Class<?>, List<Binding>> mapEntry : declaringTypeToBindings.entrySet( ) ) {
            Class<?> declaringType = mapEntry.getKey( );
            List<Binding> bindingsOfCurrentType = mapEntry.getValue( );

            // get fields of declaring type
            Field declaringTypeFieldCandidates[] = declaringType.getDeclaredFields( );

            // check fields in declaring type for each binding
            for ( Binding binding : bindingsOfCurrentType ) {

                // find all types assignable from the bound type
                List<Field> assignableFields = new ArrayList<Field>( 1 );
                for ( Field fieldCandidate : declaringTypeFieldCandidates ) {
                    if ( fieldCandidate.getType( ).isAssignableFrom( binding.getBoundType( ) ) ) {
                        assignableFields.add( fieldCandidate );
                    }
                }

                // check number of fields
                if ( assignableFields.size( ) < binding.getMultiplicity( ) ) {
                    // case 1: fields are missing
                    failed = true;
                    StringBuilder message = new StringBuilder( );
                    message.append( "Error in facility component '" + binding.getRuntimeFacilityComponent( ).getClass( ).getName( ) + "':\n" );
                    message.append( "Missing field(s) detected for bind method '" + binding.getBindMethod( ) + "'. " );
                    message.append( "Expected " + binding.getMultiplicity( ) + " but found " + assignableFields.size( ) + " fields assignable from type '" + binding.getBoundType( ) + "'." );
                    messages.add( message.toString( ) );
                } else if ( assignableFields.size( ) == binding.getMultiplicity( ) ) {
                    // case 2: found as many fields as expected
                    // -> check field values (no field value must be null):
                    for ( Field field : assignableFields ) {
                        // check if it actually was bound during facility construction:
                        field.setAccessible( true );
                        if ( field.get( binding.getRuntimeFacilityComponent( ) ) == null ) {
                            // field was not bound
                            failed = true;
                            StringBuilder message = new StringBuilder( );
                            message.append( "Error in facility component '" + binding.getRuntimeFacilityComponent( ).getClass( ).getName( ) + "':\n" );
                            message.append( "Field '" + field + "' was not bound (is null)." );
                            messages.add( message.toString( ) );
                        }
                    }
                } else {
                    // case 3: found more fields than expected
                    failed = true;
                    StringBuilder message = new StringBuilder( );
                    message.append( "Error in facility component '" + binding.getRuntimeFacilityComponent( ).getClass( ).getName( ) + "':\n" );
                    message.append( "Field(s) without defined binding detected in '" + binding.getDeclaringType( ) + "'. " );
                    message.append( "Expected " + binding.getMultiplicity( ) + " but found " + assignableFields.size( ) + " fields assignable from type '" + binding.getBoundType( ) + "'.\n" );
                    message.append( "Add a bind method for the extra field(s)." );
                    messages.add( message.toString( ) );
                }
            }
        }
        return failed;
    }

    /**
     * Types which are bound to facility components must be interfaces which are
     * located in the one of the following packages:
     * <ul>
     * <li>MOIN API root package</li>
     * <li>MOIN SPI package and subpackages</li>
     * <li>MOIN Primary Facility IPI package and subpackages</li>
     * </ul>
     */
    private boolean isAllowedBindInterface( Class<?> type ) {

        Package p = type.getPackage( );
        return !isMoinPackage( p ) ? true : ( this.isRepositoryApiPackage( p ) || this.isSpiPackage( p ) || this.isIpiPackage( p ) );
    }

    private boolean isMoinPackage( Package p ) {

        String moinBasePackage = MoinPackage.class.getPackage( ).getName( );
        return p.getName( ).startsWith( moinBasePackage );
    }

    private boolean isSpiPackage( Package p ) {

        String spiFacilityPackage = SpiFacility.class.getPackage( ).getName( );
        String spiBasePackage = spiFacilityPackage.substring( 0, spiFacilityPackage.lastIndexOf( '.' ) );

        return p.getName( ).startsWith( spiBasePackage );
    }

    private boolean isIpiPackage( Package p ) {

        return p.getName( ).startsWith( IpiFacilityComponent.class.getPackage( ).getName( ) );
    }

    private boolean isRepositoryApiPackage( Package p ) {

        return p.getName( ).equals( Facility.class.getPackage( ).getName( ) );
    }

    /**
     * Creates a core mock.
     */
    protected SpiCore constructCoreMock( ) {

        // create SpiCore mock
        SpiCore spiCoreMock = EasyMock.createMock( SpiCore.class );

        // create mocks for SpiCore services
        SpiPartitionService spiPartitionServiceMock = EasyMock.createMock( SpiPartitionService.class );
        SpiOperationService spiOperationServiceMock = EasyMock.createMock( SpiOperationService.class );
        SpiStageService spiStageServiceMock = EasyMock.createMock( SpiStageService.class );
        SpiPartitionReader spiPartitionReaderMock = EasyMock.createMock( SpiPartitionReader.class );
        SpiJmiHelper spiJmiHelperMock = EasyMock.createMock( SpiJmiHelper.class );
        SpiMetamodelService spiMetamodelService = EasyMock.createMock( SpiMetamodelService.class );

        ReferenceQueue<Object> referenceQueueMock = new ReferenceQueue<Object>( ); // non easy mock because ReferenceQueue is not an interface

        // define core mock expectations
        EasyMock.expect( spiCoreMock.getJmiHelper( ) ).andReturn( spiJmiHelperMock ).anyTimes( );
        EasyMock.expect( spiCoreMock.getMetamodelService( ) ).andReturn( spiMetamodelService ).anyTimes( );
        EasyMock.expect( spiCoreMock.getMoinId( ) ).andReturn( "mockID" + mockCounter++ ).anyTimes( );
        EasyMock.expect( spiCoreMock.getOperationService( ) ).andReturn( spiOperationServiceMock ).anyTimes( );
        EasyMock.expect( spiCoreMock.getPartitionService( ) ).andReturn( spiPartitionServiceMock ).anyTimes( );
        EasyMock.expect( spiCoreMock.getReferenceQueue( ) ).andReturn( referenceQueueMock ).anyTimes( );
        EasyMock.expect( spiCoreMock.getStageFactory( ) ).andReturn( spiStageServiceMock ).anyTimes( );

        // define partition service expectations
        EasyMock.expect( spiPartitionServiceMock.createPartitionReader( ) ).andReturn( spiPartitionReaderMock ).anyTimes( );

        // start replay mode (must not be called during the test)
        EasyMock.replay( spiCoreMock );
        EasyMock.replay( spiPartitionServiceMock, spiOperationServiceMock, spiStageServiceMock );
        EasyMock.replay( spiPartitionReaderMock );

        return spiCoreMock;
    }

    /**
     * Creates a serialization manager mock.
     */
    protected SpiPartitionSerializationManager constructPartitionSerializationManagerMock( ) {

        // create strict SpiCore mock
        SpiPartitionSerializationManager spiPartitionSerializationManager = EasyMock.createMock( SpiPartitionSerializationManager.class );

        // start replay mode (must not be called during the test)
        EasyMock.replay( spiPartitionSerializationManager );

        return spiPartitionSerializationManager;
    }

    /**
     * Creates a runtime context mock.
     */
    protected SpiRuntimeContext constructRuntimeContextMock( ) {

        // create SpiRuntimeContext mock
        SpiRuntimeContext spiRuntimeContext = EasyMock.createMock( SpiRuntimeContext.class );
        DataSource dataSourceMock = EasyMock.createMock( DataSource.class );
        SpiTransactionManager transactionManagerMock = EasyMock.createMock( SpiTransactionManager.class );

        // define runtime context mock expectations
        EasyMock.expect( spiRuntimeContext.getJdbcDataSource( ) ).andReturn( dataSourceMock ).anyTimes( );
        EasyMock.expect( spiRuntimeContext.getTransactionManager( ) ).andReturn( transactionManagerMock ).anyTimes( );

        // start replay mode
        EasyMock.replay( dataSourceMock, transactionManagerMock, spiRuntimeContext );

        return spiRuntimeContext;
    }
}
