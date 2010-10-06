/**
 * 
 */
package com.sap.furcas.textual.textblocks;

/**
 *
 */
public class CoverageBean {

    private boolean isCovered;
    private boolean nodeStartsLater;
    private boolean nodeEndsLater;
    
    /**
     * factory method
     * @param nodeStart
     * @param nodeEnd
     * @param regionStart
     * @param regionEnd
     * @return
     */
    public static CoverageBean getCoverageBean( int nodeStart,  int nodeEnd, int regionStart, int regionEnd) {
        CoverageBean coverage = new CoverageBean();
        
//        if (regionStart < regionEnd) {
            if (nodeEnd <= regionStart) {
                coverage.setCovered(false);
                coverage.setNodeStartsLater(false);
                coverage.setNodeEndsLater(false);
            } else if (regionEnd < nodeStart) {
                coverage.setCovered(false);
                coverage.setNodeStartsLater(true);
                coverage.setNodeEndsLater(true);
            } else { // coverage cases
                coverage.setCovered(true);
                coverage.setNodeStartsLater(nodeStart > regionStart);
                coverage.setNodeEndsLater(nodeEnd > regionEnd);
            }
//        } else { // regionstart == regionEnd
//            int position = regionStart;
//            if (position >= nodeEnd) {
//                coverage.setCovered(false);
//                coverage.setNodeStartsLater(false);
//                coverage.setNodeEndsLater(false);
//            } else if (position < nodeStart) {
//                coverage.setCovered(false);
//                coverage.setNodeStartsLater(true);
//                coverage.setNodeEndsLater(true);
//            } else {
//                coverage.setCovered(true);
//                coverage.setNodeStartsLater(nodeStart > regionStart);
//                coverage.setNodeEndsLater(nodeEnd > regionEnd);
//            }
//        }
            return coverage;
    }
    
    
    /**
     * @param isCovered the isCovered to set
     */
    public void setCovered(boolean isCovered) {
        this.isCovered = isCovered;
    }
    /**
     * @param nodeStartsLater the nodeStartsLater to set
     */
    public void setNodeStartsLater(boolean nodeStartsLater) {
        this.nodeStartsLater = nodeStartsLater;
    }
    /**
     * @return the isCovered
     */
    public boolean isCovered() {
        return isCovered;
    }
    /**
     * @return the nodeStartsLater
     */
    public boolean isNodeStartsLater() {
        return nodeStartsLater;
    }
    /**
     * @return the nodeEndsLater
     */
    public boolean isNodeEndsLater() {
        return nodeEndsLater;
    }
    /**
     * @param nodeEndsLater the nodeEndsLater to set
     */
    public void setNodeEndsLater(boolean nodeEndsLater) {
        this.nodeEndsLater = nodeEndsLater;
    }
    
    /**
     * true if node is covered && nodestart > regionstart && nodeEnd <= regionEnd 
     * @return
     */
    public boolean isNodeRealInside() {
        return this.isCovered() && this.isNodeStartsLater() && ! this.isNodeEndsLater();
    }
    
}
