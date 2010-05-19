package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.ocl.expressions.OCLExpression;

import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

@SuppressWarnings("restriction")
public class Query2 {
    public static Object buildMqlQuery(Set<EObject> allO,  URI uri, OCLExpression<?> body){
        //TODO other query for each predefinded type
        Object result = null;
        
        String selBody =body.toString();
        //delete all disruptive signs
        // TODO find a better/correct way with regex
        selBody = selBody.replaceAll("[()]", "");
        selBody = selBody.replaceFirst("[.]", "*");
        selBody = selBody.replaceAll("[.]", "");
        selBody = selBody.replaceAll("[*]", ".");
        System.out.println(selBody);
        
        ScopeProvider pro = new ProjectBasedScopeProviderImpl(allO.toArray(new EObject[allO.size()]));
        QueryContext queryContext = pro.getForwardScopeAsQueryContext();

        Index DEFAULT_INDEX = null;
        DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
        QueryProcessor queryProcessor = new QueryProcessorImpl(DEFAULT_INDEX);
        ResultSet resultSet = queryProcessor.execute("select p from  [" + uri + //$NON-NLS-1$
                "] as p where " + selBody, queryContext); //$NON-NLS-1$
        if(!resultSet.isEmpty()){
            Collection<EObject> col= new HashSet<EObject>();
            for(int i=0; i<resultSet.getSize();i++){
                col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i,"p"), /* loadOnDemand */true)); //$NON-NLS-1$

            }
            result = col;
        }
        else {
            // TODO add handling of empty result set
            result= null;
        }
        return result;
        
    }
    
}
