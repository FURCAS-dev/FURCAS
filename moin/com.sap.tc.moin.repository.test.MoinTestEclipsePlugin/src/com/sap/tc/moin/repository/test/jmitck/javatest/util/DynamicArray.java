// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name: DynamicArray.java

package com.sap.tc.moin.repository.test.jmitck.javatest.util;

import java.lang.reflect.Array;

@SuppressWarnings( "nls" )
public final class DynamicArray {

    public DynamicArray( ) {
    }

    public static Object[] append( Object[] aobj, Object obj ) {

        Object aobj1[];
        if ( aobj == null ) {
            if ( obj != null ) {
                aobj1 = (Object[]) Array.newInstance( obj.getClass( ), 1 );
                aobj1[0] = obj;
            } else {
                throw new IllegalArgumentException( "Cannot add null item to null array." );
            }
        } else {
            aobj1 = (Object[]) Array.newInstance( getArrayClass( aobj ), aobj.length + 1 );
            System.arraycopy( aobj, 0, aobj1, 0, aobj.length );
            aobj1[aobj1.length - 1] = obj;
        }
        return aobj1;
    }

    public static Object[] append( Object aobj[], Object obj, Class<?> class1 ) {

        Object aobj1[];
        if ( aobj == null && class1 != null ) {
            aobj1 = (Object[]) Array.newInstance( class1, 0 );
        } else {
            aobj1 = aobj;
        }
        return append( aobj1, obj );
    }

    public static Object[] insert( Object[] aobj, Object obj, int i ) {

        Object aobj1[];
        if ( aobj == null ) {
            if ( obj != null ) {
                aobj1 = (Object[]) Array.newInstance( obj.getClass( ), 1 );
                aobj1[0] = obj;
            } else {
                throw new IllegalArgumentException( "Cannot add null item to null array." );
            }
        } else {
            if ( i > aobj.length ) {
                throw new IllegalArgumentException( "Index location too large (" + i + ")." );
            }
            aobj1 = (Object[]) Array.newInstance( getArrayClass( aobj ), aobj.length + 1 );
            if ( i == 0 ) {
                aobj1[0] = obj;
                System.arraycopy( aobj, 0, aobj1, 1, aobj.length );
            } else {
                System.arraycopy( aobj, 0, aobj1, 0, i );
                aobj1[i] = obj;
                System.arraycopy( aobj, i, aobj1, i + 1, aobj.length - i );
            }
        }
        return aobj1;
    }

    public static Object[] remove( Object[] aobj, int i ) {

        if ( aobj == null ) {
            throw new IllegalArgumentException( "Cannot remove from null array." );
        }
        if ( i > aobj.length - 1 || i < 0 ) {
            throw new IllegalArgumentException( "Index to remove from array is invalid (too small/large)." );
        }
        Object aobj1[];
        if ( i == 0 ) {
            aobj1 = (Object[]) Array.newInstance( getArrayClass( aobj ), aobj.length - 1 );
            System.arraycopy( aobj, 1, aobj1, 0, aobj.length - 1 );
        } else if ( i == aobj.length - 1 ) {
            aobj1 = (Object[]) Array.newInstance( getArrayClass( aobj ), aobj.length - 1 );
            System.arraycopy( aobj, 0, aobj1, 0, aobj.length - 1 );
        } else {
            aobj1 = (Object[]) Array.newInstance( getArrayClass( aobj ), aobj.length - 1 );
            System.arraycopy( aobj, 0, aobj1, 0, i );
            System.arraycopy( aobj, i + 1, aobj1, i, aobj.length - i - 1 );
        }
        return aobj1;
    }

    public static Object[] remove( Object aobj[], Object obj ) {

        Object aobj1[];
        if ( aobj == null ) {
            aobj1 = aobj;
        } else {
            int i = find( aobj, obj );
            if ( i != -1 ) {
                aobj1 = remove( aobj, i );
            } else {
                aobj1 = aobj;
            }
        }
        return aobj1;
    }

    public static int find( Object aobj[], Object obj ) {

        int i = -1;
        for ( int j = 0; j < aobj.length; j++ ) {
            if ( aobj[j] != obj ) {
                continue;
            }
            i = j;
            break;
        }

        return i;
    }

    protected static Class<?> getArrayClass( Object aobj[] ) {

        if ( aobj != null ) {
            return ( (Object) ( aobj ) ).getClass( ).getComponentType( );
        } else {
            return null;
        }
    }
}
