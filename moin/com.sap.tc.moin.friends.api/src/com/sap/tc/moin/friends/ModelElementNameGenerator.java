package com.sap.tc.moin.friends;

import java.util.List;

public interface ModelElementNameGenerator {

    /**
     * Builds a name according to the MOIN recommendation on model element names
     * from a list of words. The only deviation from MOF is, that white spaces
     * are not allowed.
     * <p>
     * The following operations are executed on each word:
     * <ul>
     * <li>If the word contains a character which is neither a digit nor a
     * letter nor an underscore, then the character is removed</li>
     * <li>Non 7-bit ASCII characters are removed</li>
     * <li>If the first character is a letter, the character is put to upper
     * case</li>
     * </ul>
     * Afterwards the words are concatenated. If this results in an empty name,
     * null is returned. If it results in a name that does not start with a
     * letter, the optional prefix <code>prefix</code> is set before the name.
     * <p>
     * The prefix has to be a valid MOIN name. Is it taken as it is, especially
     * its first character is not put to upper case.
     * <p>
     * Examples:
     * <table border = "1">
     * <tr>
     * <th><b>Word list</b></th>
     * <th><b>Prefix</b></th>
     * <th><b>Result</b></th>
     * <th><b>Comment</b></th>
     * </tr>
     * <tr>
     * <td>com, sap, test, class</td>
     * <td>null</td>
     * <td>ComSapTestClass</td>
     * <td>no</td>
     * </tr>
     * <tr>
     * <td>com, 42sap, test, class</td>
     * <td>null</td>
     * <td>Com42sapTestClass</td>
     * <td>no</td>
     * </tr>
     * <tr>
     * <td>42com, sap, test, class</td>
     * <td>null</td>
     * <td>null</td>
     * <td>result would start with a digit</td>
     * </tr>
     * <tr>
     * <td>42com, sap, test, class</td>
     * <td>myPrefix</td>
     * <td>myPrefix42comSapTestClass</td>
     * <td>result would start with a digit, but prefix added</td>
     * </tr>
     * <tr>
     * <td>42com, __1968, __/()§$_1234</td>
     * <td>null</td>
     * <td>null</td>
     * <td>result would start with a digit</td>
     * </tr>
     * <tr>
     * <td>&%$, ?#*+, /()§$</td>
     * <td>null</td>
     * <td>null</td>
     * <td>every word contains only non 7-bit ASCII characters</td>
     * </tr>
     * <tr>
     * <td>&%$, ?#*+, /()§$</td>
     * <td>myPrefix</td>
     * <td>null</td>
     * <td>every word contains only non 7-bit ASCII characters, prefix not
     * considered</td>
     * </tr>
     * <tr>
     * <td>com, sap, null, test</td>
     * <td>null</td>
     * <td>IllegalArgumentException</td>
     * <td>word list contains a null entry</td>
     * </tr>
     * </table>
     * <p>
     * 
     * @param words a list of words to concatenate
     * @param prefix an optional prefix that is used in the case where a name
     * would be generated that would not start with a letter. A null value for
     * the prefix indicates that it should not be considered. If it is not null
     * it has to be a valid MOIN name.
     * @return a MOIN compliant model element name or null if this is not
     * possible, e.g. if the resulting name would be empty as result of the
     * before mentioned word mangling rules or if it would not not start with a
     * letter and no prefix was given
     * @throws IllegalArgumentException if the parameter <code>words</code> is
     * null, empty or contains a null element
     * @throws IllegalArgumentException if the prefix is not null and is not a
     * valid MOIN name
     */
    public String buildMoinCompliantModelElementName( List<String> words, String prefix );
}
