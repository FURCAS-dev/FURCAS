package org.eclipse.imp.preferences.fields;


/**
 * An interface for classes that provide a set of enum label/value pairs.
 * Possible sources include a static set of label/value pairs,
 * or a class that dynamically computes them at run-time.
 * @author rfuhrer@watson.ibm.com
 */
public interface IEnumValueProvider {
    String[] getLabels();

    String[] getValues();

    String getDefaultLabel();
}
