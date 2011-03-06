package org.eclipse.ocl.examples.impactanalyzer.benchmark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.Tuple.Pair;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;

/**
 * For a given set of MOIN XMI file, counts the number of elements and references. Instead of
 * actually parsing the XMI, only regular expressions are applied, looking for non-textblocks
 * model element tags as well as link tags of which no end identifies a textblock element.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public class ApproximateModelSizeMetrics {
    private static final String linkPattern = "^<L f=\'([^\']*)\' s=\'([^\']*)\'/>$";
    private static final String textblockElementPattern = "^<textblocks\\..*m:i=\'([^\']*)\'";
    private static final String elementPattern = "(/>)|(</)"; // count *ends* of elements; includes links and textblocks and M tags
    private static final String metamodelPattern = "^<M ";
    private static final String compartmentPattern = "^<C ";
    
    private final Pattern linkPatternRegexp;
    private final Pattern textblockElementPatternRegexp;
    private final Pattern elementPatternRegexp;
    private final Pattern metamodelPatternRegexp;
    private final Pattern compartmentPatternRegexp;
    
    private final Bag<Pair<String, String>> links;
    private final Set<String> textblocksElementsIDs;
    private int elements;
    
    public ApproximateModelSizeMetrics() {
        linkPatternRegexp = Pattern.compile(linkPattern);
        textblockElementPatternRegexp = Pattern.compile(textblockElementPattern);
        elementPatternRegexp = Pattern.compile(elementPattern);
        metamodelPatternRegexp = Pattern.compile(metamodelPattern);
        compartmentPatternRegexp = Pattern.compile(compartmentPattern);
        links = CollectionUtil.createNewBag();
        textblocksElementsIDs = new HashSet<String>();
    }
    
    /**
     * @param args names of the XMI / .types files to analyze
     */
    public static void main(String[] args) {
        try {
            ApproximateModelSizeMetrics metrics = new ApproximateModelSizeMetrics();
            metrics.run(args);
            System.out.println("Elements: " + metrics.getElements());
            System.out.println("Links:    " + metrics.getLinks());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getLinks() {
        int result = 0;
        for (Pair<String, String> link : links) {
            if (!textblocksElementsIDs.contains(link.getA()) && !textblocksElementsIDs.contains(link.getB())) {
                result++;
            }
        }
        return result;
    }

    private int getElements() {
        return elements;
    }

    private void run(String[] args) throws IOException {
        for (String filename : args) {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            count(br);
            br.close();
        }
    }

    private void count(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null) {
            Matcher textblocksElementMatcher = textblockElementPatternRegexp.matcher(line);
            if (textblocksElementMatcher.find()) {
                String textblocksElementID = textblocksElementMatcher.group(1);
                textblocksElementsIDs.add(textblocksElementID);
            } else {
                Matcher linkMatcher = linkPatternRegexp.matcher(line);
                if (linkMatcher.find()) {
                    links.add(new Pair<String, String>(linkMatcher.group(1), linkMatcher.group(2)));
                } else {
                    Matcher elementMatcher = elementPatternRegexp.matcher(line);
                    if (elementMatcher.find()) {
                        Matcher metamodelMatcher = metamodelPatternRegexp.matcher(line);
                        Matcher compartmentMatcher = compartmentPatternRegexp.matcher(line);
                        if (!metamodelMatcher.find() && !compartmentMatcher.find()) {
                            elements++;
                        }
                    }
                }
            }
            line = br.readLine();
        }
    }

}
