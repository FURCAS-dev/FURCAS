/**
 * 
 */
package org.eclipse.imp.preferences.fields;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link IEnumValueProvider} that uses static sets of labels and values.
 * Currently unused (the code generator creates entirely different code for the static case).
 * @author rfuhrer@watson.ibm.com
 */
public class StaticEnumValueProvider implements IEnumValueProvider {
    /**
     * The default label associated with this field
     * (used to set the value of the concrete instance of
     * this field on the default level)
     */
    private final String fDefaultLabel;

    /**
     * The list of labels
     */
    private final List<String> fLabelList= new ArrayList<String>();

    /**
     * A list of values. If non-null and non-empty, indices correspond
     * to those in the field <code>labelList</code>.
     */
    private final List<String> fValueList= new ArrayList<String>();

    public StaticEnumValueProvider(List<String> keys, List<String> values, String defaultKey) {
        fLabelList.addAll(keys);
        fValueList.addAll(values);
        fDefaultLabel= defaultKey;
    }

    public String[] getLabels() {
        return fLabelList.toArray(new String[fLabelList.size()]);
    }

    public String[] getValues() {
        return fValueList.toArray(new String[fValueList.size()]);
    }

    public String getDefaultLabel() {
        return fDefaultLabel;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for(int i=0; i < fLabelList.size(); i++) {
            sb.append("slot[");
            sb.append(i);
            sb.append("] = ");
            sb.append(fLabelList.get(i));
            if (fValueList != null && fValueList.size() > 0) {
                sb.append(": ");
                sb.append(fValueList.get(i));
            }
            sb.append("\n");
        }
        sb.append("defaultLabel = ");
        sb.append(fDefaultLabel);
        return sb.toString();
    }
}
