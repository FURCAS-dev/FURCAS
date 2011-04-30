/**
 * 
 */
package org.eclipse.imp.utils;

/**
 * @author rfuhrer@watson.ibm.com
 */
public class Pair<T1,T2> {
    public final T1 first;
    public final T2 second;

    public Pair(T1 v1, T2 v2) {
        first= v1;
        second= v2;
    }

    @Override
    public int hashCode() {
        return 6143 + 2399 * first.hashCode() + 7433 * second.hashCode();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) return false;
        Pair other= (Pair) obj;

        return other.first.equals(first) && other.second.equals(second);
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append('<');
        sb.append(first);
        sb.append(',');
        sb.append(second);
        sb.append('>');
        return sb.toString();
    }
}
