package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.junit.Test;

import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;

public class TestEventFrameworkOrderingIndex extends CoreMoinTest {

    private int numberOfEvents = 0;

    @Test
    public void testRemoveAllOrderedObjectAttribute( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof AttributeValueRemoveEvent );
                AttributeValueRemoveEvent avre = (AttributeValueRemoveEvent) event;
                assertEquals( 0, avre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyBsOrdered( ).clear( );

        assertEquals( 4, numberOfEvents );
    }

    @Test
    public void testRemoveSomeElementsOfOrderedObjectAttribute( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        a4.getManyBsOrdered( ).add( getMOINConnection( ).createElement( B4.class ) );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof AttributeValueRemoveEvent );
                AttributeValueRemoveEvent avre = (AttributeValueRemoveEvent) event;
                assertEquals( 1, avre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyBsOrdered( ).subList( 1, 4 ).clear( );

        assertEquals( 3, numberOfEvents );
    }

    @Test
    public void testAddSomeElementsOfOrderedObjectAttribute( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        List<B4> b4s = new ArrayList<B4>( );
        b4s.add( getMOINConnection( ).createElement( B4.class ) );
        b4s.add( getMOINConnection( ).createElement( B4.class ) );
        b4s.add( getMOINConnection( ).createElement( B4.class ) );
        b4s.add( getMOINConnection( ).createElement( B4.class ) );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                assertTrue( event instanceof AttributeValueAddEvent );
                AttributeValueAddEvent avae = (AttributeValueAddEvent) event;
                assertEquals( numberOfEvents, avae.getPosition( ) );
                numberOfEvents++;
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyBsOrdered( ).addAll( b4s );

        assertEquals( 4, numberOfEvents );
    }

    @Test
    public void testRemoveAllOrderedLinks( ) {

        MofClass mofClass = getMOINConnection( ).createElement( MofClass.class );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof LinkRemoveEvent );
                LinkRemoveEvent lre = (LinkRemoveEvent) event;
                assertEquals( 0, lre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        mofClass.getContents( ).clear( );

        assertEquals( 4, numberOfEvents );
    }

    @Test
    public void testRemoveSomeOrderedLinks( ) {

        MofClass mofClass = getMOINConnection( ).createElement( MofClass.class );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        mofClass.getContents( ).add( getMOINConnection( ).createElement( Attribute.class ) );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof LinkRemoveEvent );
                LinkRemoveEvent lre = (LinkRemoveEvent) event;
                assertEquals( 1, lre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        mofClass.getContents( ).subList( 1, 4 ).clear( );

        assertEquals( 3, numberOfEvents );
    }

    @Test
    public void testAddSomeOrderedLinks( ) {

        MofClass mofClass = getMOINConnection( ).createElement( MofClass.class );
        List<Attribute> attrs = new ArrayList<Attribute>( );
        attrs.add( getMOINConnection( ).createElement( Attribute.class ) );
        attrs.add( getMOINConnection( ).createElement( Attribute.class ) );
        attrs.add( getMOINConnection( ).createElement( Attribute.class ) );
        attrs.add( getMOINConnection( ).createElement( Attribute.class ) );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                assertTrue( event instanceof LinkAddEvent );
                LinkAddEvent lae = (LinkAddEvent) event;
                assertEquals( numberOfEvents, lae.getPosition( ) );
                numberOfEvents++;
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        mofClass.getContents( ).addAll( attrs );

        assertEquals( 4, numberOfEvents );
    }

    @Test
    public void testRemoveAllOrderedPrimitiveAttribute( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String1" );
        a4.getManyPrimitiveOrdered( ).add( "String2" );
        a4.getManyPrimitiveOrdered( ).add( "String3" );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof AttributeValueRemoveEvent );
                AttributeValueRemoveEvent avre = (AttributeValueRemoveEvent) event;
                assertEquals( 0, avre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyPrimitiveOrdered( ).clear( );

        assertEquals( 4, numberOfEvents );
    }

    @Test
    public void testRemoveAllOrderedPrimitiveAttributeSameValue( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof AttributeValueRemoveEvent );
                AttributeValueRemoveEvent avre = (AttributeValueRemoveEvent) event;
                assertEquals( 0, avre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyPrimitiveOrdered( ).clear( );

        assertEquals( 4, numberOfEvents );
    }

    @Test
    public void testRemoveSomeElementsOfOrderedPrimitiveAttribute( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String1" );
        a4.getManyPrimitiveOrdered( ).add( "String2" );
        a4.getManyPrimitiveOrdered( ).add( "String3" );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof AttributeValueRemoveEvent );
                AttributeValueRemoveEvent avre = (AttributeValueRemoveEvent) event;
                assertEquals( 1, avre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyPrimitiveOrdered( ).subList( 1, 4 ).clear( );

        assertEquals( 3, numberOfEvents );
    }

    @Test
    public void testRemoveSomeElementsOfOrderedPrimitiveAttributeSameValue( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        a4.getManyPrimitiveOrdered( ).add( "String0" );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                numberOfEvents++;
                assertTrue( event instanceof AttributeValueRemoveEvent );
                AttributeValueRemoveEvent avre = (AttributeValueRemoveEvent) event;
                assertEquals( 1, avre.getPosition( ) );
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyPrimitiveOrdered( ).subList( 1, 4 ).clear( );

        assertEquals( 3, numberOfEvents );
    }

    @Test
    public void testAddSomeElementsOfOrderedPrimitiveAttribute( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        List<String> strings = new ArrayList<String>( );
        strings.add( "String0" );
        strings.add( "String1" );
        strings.add( "String2" );
        strings.add( "String3" );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                assertTrue( event instanceof AttributeValueAddEvent );
                AttributeValueAddEvent avae = (AttributeValueAddEvent) event;
                assertEquals( numberOfEvents, avae.getPosition( ) );
                numberOfEvents++;
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyPrimitiveOrdered( ).addAll( strings );

        assertEquals( 4, numberOfEvents );
    }

    @Test
    public void testAddSomeElementsOfOrderedPrimitiveAttributeSameValue( ) {

        A4 a4 = getMOINConnection( ).createElement( A4.class );
        List<String> strings = new ArrayList<String>( );
        strings.add( "String0" );
        strings.add( "String0" );
        strings.add( "String0" );
        strings.add( "String0" );
        numberOfEvents = 0;

        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                assertTrue( event instanceof AttributeValueAddEvent );
                AttributeValueAddEvent avae = (AttributeValueAddEvent) event;
                assertEquals( numberOfEvents, avae.getPosition( ) );
                numberOfEvents++;
            }
        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.getManyPrimitiveOrdered( ).addAll( strings );

        assertEquals( 4, numberOfEvents );
    }
}
