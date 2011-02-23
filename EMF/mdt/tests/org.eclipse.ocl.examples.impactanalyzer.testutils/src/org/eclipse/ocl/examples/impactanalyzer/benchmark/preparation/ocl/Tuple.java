/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl;

public class Tuple {

    public static class Pair<A, B> {

        private A a;

        private B b;

        private int hashCode;

        public Pair( A a, B b ) {

            this.a = a;
            this.b = b;
            hashCode = 0;
        }

        public void setA( A a ) {

            this.a = a;
            hashCode = 0;
        }

        public A getA( ) {

            return a;
        }

        public void setB( B b ) {

            this.b = b;
            hashCode = 0;
        }

        public B getB( ) {

            return b;
        }

        @Override
        public int hashCode( ) {

            if ( hashCode == 0 ) {
                hashCode = 17;
                hashCode = 37 * hashCode + ( a != null ? a.hashCode( ) : 0 );
                hashCode = 37 * hashCode + ( b != null ? b.hashCode( ) : 0 );
            }
            return hashCode;
        }

        @Override
        public boolean equals( Object obj ) {

            boolean result;
            if ( this == obj ) {
                result = true;
            } else if ( obj instanceof Pair<?, ?> ) {
                Pair<?, ?> pair = (Pair<?, ?>) obj;
                result = ( this.a != null && this.a.equals( pair.a ) || this.a == null && pair.a == null ) && ( this.b != null && this.b.equals( pair.b ) || this.b == null && pair.b == null );
            } else {
                result = false;
            }
            return result;
        }

        @Override
        public String toString( ) {

            return "[" + (a==null?"null":a.toString( )) + ", " +
            	(b==null?"null":b.toString( )) + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
    }

    public static class Triple<A, B, C> {

        private A a;

        private B b;

        private C c;

        private int hashCode;

        public Triple( A a, B b, C c ) {

            this.a = a;
            this.b = b;
            this.c = c;
            hashCode = 0;
        }

        public void setA( A a ) {

            this.a = a;
            hashCode = 0;
        }

        public A getA( ) {

            return a;
        }

        public void setB( B b ) {

            this.b = b;
            hashCode = 0;
        }

        public B getB( ) {

            return b;
        }

        public void setC( C c ) {

            this.c = c;
            hashCode = 0;
        }

        public C getC( ) {

            return c;
        }

        @Override
        public int hashCode( ) {

            if ( hashCode == 0 ) {
                hashCode = 17;
                hashCode = 37 * hashCode + ( a != null ? a.hashCode( ) : 0 );
                hashCode = 37 * hashCode + ( b != null ? b.hashCode( ) : 0 );
                hashCode = 37 * hashCode + ( c != null ? c.hashCode( ) : 0 );
            }
            return hashCode;
        }

        @Override
        public boolean equals( Object obj ) {

            boolean result;
            if ( this == obj ) {
                result = true;
            } else if ( obj instanceof Triple<?, ?, ?> ) {
                Triple<?, ?, ?> thrice = (Triple<?, ?, ?>) obj;
                result = ( this.a != null && this.a.equals( thrice.a ) || this.a == null && thrice.a == null ) && ( this.b != null && this.b.equals( thrice.b ) || this.b == null && thrice.b == null ) && ( this.c != null && this.c.equals( thrice.c ) || this.c == null && thrice.c == null );
            } else {
                result = false;
            }
            return result;
        }

        @Override
        public String toString( ) {

            return "[" + a.toString( ) + ", " + b.toString( ) + ", " + c.toString( ) + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }
    }
}
