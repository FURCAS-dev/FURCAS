package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.utilities.PredefinedType;

import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;

@SuppressWarnings("restriction")
public class MqlMapperImpl implements org.eclipse.ocl.OclToMql {

    private Map<EClassifier,Set<EObject>> extentMap;

    public MqlMapperImpl() {
        super();

    }
    public Map<EClassifier,Set<EObject>> getExtentMap() {
        return extentMap;
    }
    @Override
    public void setExtendMap(Map<EClassifier, Set<EObject>> map) {
        extentMap = map;

    }
    @Override
    public boolean checkForExpression (OCLExpression<EClassifier> expression){
        return expression instanceof IteratorExp<?, ?>;        
    }

    public  Object oclToMqlMapping(Object context, OCLExpression<EClassifier> expression) {
        System.out.println("Ich bin drin");
        Object sourceValue = null;

        if (expression instanceof IteratorExp<?, ?>){
            IteratorExp<?, ?> ie = (IteratorExp<?, ?>)expression;
            Object sourceType = ie.getSource().getType();

            if (sourceType instanceof PredefinedType<?>) {
                if (ie.getSource() instanceof OperationCallExp<?, ?>){
                    OperationCallExp<?, ?> opCall = (OperationCallExp<?, ?>)ie.getSource();
                    int opCode = opCall.getOperationCode();

                    if(opCode==PredefinedType.ALL_INSTANCES){
                        Set<EObject> allO = new HashSet<EObject>();

                        if(!getExtentMap().values().isEmpty()){
                            /*
                             * TODO  why only take the first EClassifier as COntext
                             */
                            Iterator<EObject> list = getExtentMap().values().iterator().next().iterator();
                            while(list.hasNext())
                                allO.add((EObject)list.next());
                        }

                        OCLExpression<?> test = opCall.getSource();
                        URI uri = null;
                        if (test instanceof TypeExp<?>){
                            Object x = ((TypeExp<?>) test).getReferredType();
                            EClassifier y = (EClassifier) x;
                            uri = EcoreUtil.getURI(y);
                        }
                        OCLExpression<?> b = ie.getBody();
                        String body = null;
                        String arg = null;
                        String bool = null;
                        if (b instanceof OperationCallExp<?, ?>){
                            Object u = ((OperationCallExp<?, ?>) b).getSource();
                            EList<?> v = ((OperationCallExp<?, ?>)b).getArgument();
                            Object w = ((OperationCallExp<?, ?>)b).getReferredOperation();
                            if (w instanceof EOperation){
                                String x = ((EOperation)w).getName();
                                bool = x;
                            }
                            if (u instanceof PropertyCallExp<?, ?>){

                                String srcName = ((PropertyCallExp<?, ?>)u).getSource().getName();
                                Object op = ((PropertyCallExp<?, ?>)u).getReferredProperty();
                                if (op instanceof EAttribute){
                                    String optName = ((EAttribute)op).getName();
                                    body = srcName + "." + optName; //$NON-NLS-1$
                                }

                            }
                            Object saveV = v.get(0);
                            if (saveV instanceof IntegerLiteralExp<?>){
                                arg = ((IntegerLiteralExp<?>) saveV).getIntegerSymbol().toString();
                            }
                        }
                        ScopeProvider pro = new ProjectBasedScopeProviderImpl(allO.toArray(new EObject[allO.size()]));
                        QueryContext queryContext = pro.getForwardScopeAsQueryContext();

                        Index DEFAULT_INDEX = null;
                        DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
                        QueryProcessor queryProcessor = new QueryProcessorImpl(DEFAULT_INDEX);
                        ResultSet resultSet = queryProcessor.execute("select p from  [" + uri + //$NON-NLS-1$
                                "] as p where "+ body+ bool +arg, queryContext); //$NON-NLS-1$
                        if(!resultSet.isEmpty()){
                            Collection<EObject> col= new HashSet<EObject>();
                            for(int i=0; i<resultSet.getSize();i++){
                                col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i,"p"), /* loadOnDemand */true)); //$NON-NLS-1$

                            }
                            sourceValue = col;
                        }
                        else {
                            // TODO add handling of empty result set
                            sourceValue= null;
                        }
                    }else{
                        sourceValue= null;
                    }}else{
                        sourceValue= null;
                    }}
        }


        return sourceValue;}
}
