package com.sap.tc.moin.repository.core.eviction;

import java.util.Hashtable;
import java.lang.reflect.Field;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;


/**
 * @author Robert Heidasch <a
 * href="mailto:robert.heidasch@sap.com?subject=Memory%20Profiler%20Request">Robert
 * Heidasch</a>
 */
public class MemoryProfiler {

    // Instrumentation for 32-bits machines
    private static final int OBJECT = 8, OBJECT_REF = 4, LONG = 8, INTEGER = 4, SHORT = 2, CHAR = 2, BYTE = 1, BOOLEAN = 1, DOUBLE = 8, FLOAT = 4;


    private int size = 0;

    private Hashtable visitedObjects;

    public MemoryProfiler( ) {

        visitedObjects = new Hashtable( );
    }


    /**
     * Returns the size of the object in bytes. The size contains the size of
     * all private and public member variables, inner classes, etc.
     * 
     * @param The object which will be checked
     * @return The object size in bytes
     */
    public synchronized int sizeof( Object obj ) {

        this.size = 0;
        this.visitedObjects.clear( );

        this.computeSize( obj, null );

        this.visitedObjects.clear( );
        return this.size;
    }



    private void computeSize( Object currObject, Object origObject ) {

        if ( currObject != null ) {
            Class currClass = currObject.getClass( );

            if ( currClass.isPrimitive( ) ) {
                this.size += this.sizeofPrimitiveType( currClass );

            } else if ( currClass.isArray( ) ) {
                if ( this.visitedObjects.get( currObject ) == null ) {
                    this.computeArray( currObject, currClass );
                    this.visitedObjects.put( currObject, currClass );
                }

            } else if ( currObject instanceof Field ) {
                try {
                    if ( ( (Field) currObject ).isAccessible( ) ) {
                        this.computeSize( ( (Field) currObject ).get( origObject ), origObject );
                    } else {
                        //try {
                        //    ( (Field) currObject ).setAccessible( true );
                        //} catch ( SecurityException e ) {
                        //    e.printStackTrace( System.out );
                        //}
                        //if ( ( (Field) currObject ).isAccessible( ) ) {
                        //    this.computeSize( ( (Field) currObject ).get( origObject ), origObject );
                        //    try {
                        //        ( (Field) currObject ).setAccessible( false );
                        //    } catch ( SecurityException e ) {
                        //        e.printStackTrace( System.out );
                        //    }
                        //} else {
                        //    this.computeSize( ( (Field) currObject ).getType( ) );
                        //}
                    }
                } catch ( Exception e ) {
                    e.printStackTrace( System.out );
                }

            } else if ( currObject instanceof Long || currObject instanceof Integer || currObject instanceof Short || currObject instanceof Character || currObject instanceof Byte || currObject instanceof Boolean || currObject instanceof Double || currObject instanceof Float ) {
                if ( this.visitedObjects.get( currObject ) == null ) {
                    this.computePrimitiveObjects( currClass );
                    this.visitedObjects.put( currObject, currClass );
                }

            } else if ( currObject instanceof Object ) {
                if ( this.visitedObjects.get( currObject ) == null ) {

                    this.visitedObjects.put( currObject, currClass );

                    if ( currObject != Object.class ) {
                        this.size += OBJECT;

                        this.inspectDeclaredFields( currClass, currObject );

                        if ( currClass.getSuperclass( ) != null ) {
                            this.computeSize( currClass.getSuperclass( ), currObject );
                        }
                    }
                }
            }
        } else {
            this.size += OBJECT_REF;
        }
    }


    private void computeSize( Class currClass ) {

        if ( currClass.isPrimitive( ) ) {
            this.size += this.sizeofPrimitiveType( currClass );

        } else if ( currClass == long.class || currClass == int.class || currClass == short.class || currClass == char.class || currClass == byte.class || currClass == boolean.class || currClass == double.class || currClass == float.class ) {
            if ( this.visitedObjects.get( currClass ) == null ) {
                this.computePrimitiveObjects( currClass );
                this.visitedObjects.put( currClass, currClass );
            }

        } else {
            if ( this.visitedObjects.get( currClass ) == null ) {

                this.visitedObjects.put( currClass, currClass );

                this.inspectDeclaredFields( currClass, null );

                if ( currClass.getSuperclass( ) != null ) {
                    this.computeSize( currClass.getSuperclass( ) );
                }
            }
        }

    }


    private void inspectDeclaredFields( Class currClass, Object origObject ) {

        Field[] declaredFields = currClass.getDeclaredFields( );

        for ( int i = 0; i < declaredFields.length; i++ ) {
            if ( ( Modifier.STATIC & declaredFields[i].getModifiers( ) ) != 0 ) {
                continue;
            }

            if ( declaredFields[i].getName( ).startsWith( "this$" ) ) { //$NON-NLS-1$
                // ignore this pointer for inner classes - check this functionality
                continue;
            }

            if ( declaredFields[i].getType( ).isPrimitive( ) ) {
                this.size += this.sizeofPrimitiveType( declaredFields[i].getType( ) );
            } else {
                this.size += OBJECT_REF;
                this.computeSize( declaredFields[i], origObject );
            }

        }
    }


    private void computeArray( Object currObject, Class currClass ) {

        int arrayLength = Array.getLength( currObject );
        Class compType = currClass.getComponentType( );

        this.size += this.sizeofArrayShell( arrayLength, compType );

        if ( compType.isPrimitive( ) == false ) {
            for ( int i = 0; i < arrayLength; i++ ) {
                Object obj = (Object) Array.get( currObject, i );
                this.computeSize( obj, null );
            }
        }
    }


    private int sizeofArrayShell( int length, Class compType ) {

        int slotSize = compType.isPrimitive( ) ? sizeofPrimitiveType( compType ) : OBJECT_REF;

        return OBJECT + INTEGER + OBJECT_REF + ( length * slotSize );
    }


    private void computePrimitiveObjects( Class currClass ) {

        this.size += OBJECT;
        this.size += this.sizeofPrimitiveType( currClass );
    }


    private int sizeofPrimitiveType( Class currClass ) {

        if ( currClass == long.class || currClass == Long.class ) {
            return LONG;
        } else if ( currClass == int.class || currClass == Integer.class ) {
            return INTEGER;
        } else if ( currClass == short.class || currClass == Short.class ) {
            return SHORT;
        } else if ( currClass == char.class || currClass == Character.class ) {
            return CHAR;
        } else if ( currClass == byte.class || currClass == Byte.class ) {
            return BYTE;
        } else if ( currClass == boolean.class || currClass == Boolean.class ) {
            return BOOLEAN;
        } else if ( currClass == double.class || currClass == Double.class ) {
            return DOUBLE;
        } else if ( currClass == float.class || currClass == Float.class ) {
            return FLOAT;
        } else {
            return 0;
        }
    }
}
