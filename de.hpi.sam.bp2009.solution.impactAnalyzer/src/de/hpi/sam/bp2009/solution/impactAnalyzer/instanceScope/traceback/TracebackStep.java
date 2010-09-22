package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.traceback;

import java.util.Set;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.TracebackCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public interface TracebackStep {
    public Set<AnnotatedEObject> traceback(AnnotatedEObject s, TracebackCache cache);

}
