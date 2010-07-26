package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl.Options;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.moinql.controller.QueryProcessorImpl;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextScopeProvider;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectBasedQueryContextScopeProviderImpl;

@SuppressWarnings("restriction")
public class Query2  {

/**
 * buildMqlQuery prepares for each Predefined type of the Iterator Expression a matching Query 2
 * after mapping all parts of the Expression, the query 2 will be executed
 * @param allO a Set<EObject> for Setting the Query Context
 * @param ocType an Object for building the scope for Query 2
 * @param body is the OCLExpression, this must be the body of the IteratorExp for mapping all parts of the Expression to Query 2
 * @param ie is the IteratorExp, needed to defined the different mapping for each Predefined Type 
 * @param mapev is the Mapping Evaluation Visitor, needed to instantiate a second Visitor to map the expression
 * @return result
 */
    public static Object buildMqlQuery(Set<EObject> allO,  Object ocType, OCLExpression<EClassifier> body, IteratorExp<EClassifier, EParameter> ie, MappingEvaluationVisitor mapev){
        Object result = null;
        MqlMapperToString mmts ;
        mmts = new MqlMapperToString(mapev.getEnvironment(), mapev.getEvaluationEnvironment(), mapev.getExtentMap());
        EClassifier eclass1 = (EClassifier) ocType;
        URI uri1 = EcoreUtil.getURI(eclass1);
        String stringBody =null;
        stringBody = (String) mmts.visitExpression(body);
        if (mmts.wasErrorful()){
            return result;
        }
        int itExp = OCLStandardLibraryUtil.getOperationCode(ie.getName());
        switch (itExp){
        case 201:{
            //exists
        }
        case 202:{
            //forAll
        }
        case 209:{
            //            select
            QueryContext queryContext = setQueryContext(allO);
            QueryProcessor queryProcessor = setQueryProcessor();
            ResultSet resultSet=null;
            String regex="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)\\*\\*\\*([0-9A-Za-z]+)\\=([0-9A-Za-z]+)";
            String regex2="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)\\=([0-9A-Za-z]+)\\.([0-9A-Za-z]+)\\*\\*\\*([0-9A-Za-z]+)";
            String regex3="([0-9A-Za-z]+)\\.([0-9A-Za-z]+)=([0-9A-Za-z]+)\\.([0-9A-Za-z]+)";
            String stars = "\\*\\*\\*";
            String alias = "([0-9A-Za-z]\\.)";
            String comp ="([0-9A-Za-z]{1}\\.)([0-9A-Za-z]+)([\\=\\<\\>]+)";
            Pattern pattern=Pattern.compile(regex);
            Pattern pattern2=Pattern.compile(regex2);
            Pattern pattern3=Pattern.compile(regex3);
            Pattern pattern_stars=Pattern.compile(stars);
            Pattern pattern_alias = Pattern.compile(alias);
            Pattern pattern_comp=Pattern.compile(comp);
            Matcher match=pattern.matcher(stringBody);
            Matcher match2=pattern_stars.matcher(stringBody);
            Matcher match3=pattern_alias.matcher(stringBody);
            Matcher match4=pattern2.matcher(stringBody);
            Matcher match5=pattern_comp.matcher(stringBody);
            Matcher match6=pattern3.matcher(stringBody);
            boolean test = match.find();
            boolean test2 = match2.find();
            boolean test3 =match3.find();
            boolean test4 =match4.find();
            boolean test5 =match5.find();
            boolean test6 =match6.find();
            if(test && test2 && test3){

                String nav = stringBody.substring(match.start(1), stringBody.indexOf("***"));
                String cond = stringBody.substring(stringBody.indexOf("***")+3);
                String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                if (body instanceof OperationCallExp){

                    Object prop = ((PropertyCallExp) ((PropertyCallExp) ((OperationCallExp) body).getSource()).getSource()).getReferredProperty();
                    if(prop instanceof EReference){
                        Object propType = ((EReference) prop).getEType();
                        EClassifier eclass2 = (EClassifier) propType;
                        URI uri2=EcoreUtil.getURI(eclass2);

                        try{
                            //select over body with navigation
                            resultSet = queryProcessor.execute("select "+ali+" from  [" + uri1 + //$NON-NLS-1$
                                    "] as "+ali+" where "+nav+" in ( select p2 from [" + uri2+"] as p2 where p2." + cond+")", queryContext); //$NON-NLS-1$
                        }
                        catch (EvaluationHaltedException e) {
                            // evaluation stopped on demand, propagate further
                            throw e;
                        } catch (RuntimeException e) {
                            result=null;
                        }
                        finally{
                            result = buildResult(resultSet, queryContext, ali);
                        }

                    }}}
            else if(test3 &&!test2 &&!test6){

                String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                try{
                    //select over body with condition
                    resultSet = queryProcessor.execute("select "+ ali+" from  [" + uri1 + //$NON-NLS-1$
                            "] as "+ali+" where " + stringBody, queryContext); //$NON-NLS-1$
                }
                catch (EvaluationHaltedException e) {
                    // evaluation stopped on demand, propagate further
                    throw e;
                } catch (RuntimeException e) {
                    result=null;
                }
                finally{
                    result = buildResult(resultSet, queryContext, ali);
                }
            }
            else if(test4 && test5 ){

                String ali = stringBody.substring(match4.start(1), stringBody.indexOf("."));
                String nav = stringBody.substring(match5.end(), stringBody.indexOf("***"));
                String cond = stringBody.substring(stringBody.indexOf("."),match5.end());
                String cond2=stringBody.substring(stringBody.indexOf("***")+3);

                if (body instanceof OperationCallExp){
                    List<OCLExpression<EClassifier>> args = ((OperationCallExp) body).getArgument();
                    OCLExpression<EClassifier> arg = args.get(0);
                    PropertyCallExp src = (PropertyCallExp) ((PropertyCallExp) arg).getSource();
                    Object prop = src.getReferredProperty();
                    if(prop instanceof EReference){
                        Object propType = ((EReference) prop).getEType();
                        EClassifier eclass2 = (EClassifier) propType;
                        URI uri2=EcoreUtil.getURI(eclass2);

                        try{
                            //select over body with a comparison with navigation
                            resultSet = queryProcessor.execute("select "+ ali+" from  [" + uri1 + //$NON-NLS-1$
                                    "] as "+ali+" ,["+uri2+"] as p3 where " +nav+"=p3 where "+ali+ cond+ "p3."+ cond2, queryContext); //$NON-NLS-1$
                        }
                        catch (EvaluationHaltedException e) {
                            // evaluation stopped on demand, propagate further
                            throw e;
                        } catch (RuntimeException e) {
                            result=null;
                        }
                        finally{
                            result = buildResult(resultSet, queryContext, ali);
                        }
                    }}

            }
            else if(test6 && test3){
                String ali = stringBody.substring(match6.start(1), stringBody.indexOf("."));
                String cond= stringBody.replaceFirst(alias,"p.");
                //                cond= cond.replaceFirst("e2", ali);

                try{

                    //select over body with a comparison without navigation 
                    resultSet = queryProcessor.execute("select "+ ali+" from [" + uri1 + //$NON-NLS-1$
                            "] as p , ["+uri1+"] as "+ali+" where "+ali+"=p where "+cond, queryContext); //$NON-NLS-1$
                }
                catch (EvaluationHaltedException e) {
                    // evaluation stopped on demand, propagate further
                    throw e;
                } catch (RuntimeException e) {
                    result=null;
                }
                finally{
                    result = buildResult(resultSet, queryContext, ali);
                }}
            return result;
        }

        case 205:{
            //any
        }
        case 210:{
            //reject
        }
        case 206:{
            //collect
            QueryContext queryContext = setQueryContext(allO);
            ResultSet resultSet=null;
            QueryProcessor queryProcessor = setQueryProcessor();

            String alias = "([0-9A-Za-z]{1}\\.)";


            Pattern pattern3 = Pattern.compile(alias);

            Matcher match3=pattern3.matcher(stringBody);
            match3.find();
            if (body instanceof PropertyCallExp){

                Object prop = ((PropertyCallExp) body).getReferredProperty();
                if(prop instanceof EReference){
                    //collect over an association
                    Object propType = ((EReference) prop).getEType();
                    EClassifier eclass2 = (EClassifier) propType;
                    URI uri2=EcoreUtil.getURI(eclass2);
                    String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                    String alia= "a2";

                    try{
                        resultSet = queryProcessor.execute("select "+alia+" from  [" + uri1 + //$NON-NLS-1$
                                "] as "+ali+" , [" +uri2+ "] as a2 where "+stringBody +" in (select p2 from ["+uri2+"] as p2)", queryContext);
                    }
                    catch (EvaluationHaltedException e) {
                        // evaluation stopped on demand, propagate further
                        throw e;
                    } catch (RuntimeException e) {
                        result=null;
                    }
                    finally{
                        if(!resultSet.isEmpty()){
                            Map<EObject,Integer> col= new HashMap<EObject, Integer>();
                            int count = 1;
                            for(int i=0; i<resultSet.getSize();i++){
                                EObject value = queryContext.getResourceSet().getEObject(resultSet.getUri(i, alia), /* loadOnDemand */true); //$NON-NLS-1$
                                if(col.containsValue(value)){
                                    count++;
                                    col.put(value, count);   
                                }
                                else{
                                    count=1;
                                    col.put(value, count);
                                }
                            }
                            result = col;
                            System.out.println("successfull");
                        }
                        else {
                            Collection<EObject> col= new HashSet<EObject>();

                            result = col;
                        }

                    }

                }else if(prop instanceof EAttribute){
                    String ali = stringBody.substring(match3.start(1), stringBody.indexOf("."));
                    try{
                        //collect over  an attribute
                        resultSet = queryProcessor.execute("select "+ stringBody+" from  [" + uri1 + //$NON-NLS-1$
                                "] as "+ali, queryContext); //$NON-NLS-1$
                    }
                    catch (EvaluationHaltedException e) {
                        // evaluation stopped on demand, propagate further
                        throw e;
                    } catch (RuntimeException e) {
                        result=null;
                    }
                    finally{

                        if(!resultSet.isEmpty()){
                            int count = 1;
                            Map<Object, Integer> col= new HashMap<Object,Integer>();
                            for(int i = 0;i<resultSet.getSize();i++){
                                Object value=null;
                                Object[] attribute = resultSet.getAttributes(i, ali);
                                for (int j=0; j<attribute.length;j++){
                                    value =attribute[j];
                                }
                                if(col.containsKey(value)){
                                    count++;  
                                    col.put(value,count);}
                                else{
                                    count=1;
                                    col.put(value,count);
                                }
                            }
                            result=col;
                            System.out.println("successfull");
                        }
                        else {
                            Map<Object, Integer> col= new HashMap<Object,Integer>();

                            result = col;
                        }
                    } 
                }
                return result;
            }
            else{
                //if body is of type OperationCallExpression the expression can not be mapped
                return result;
            }

        }
        case 207:{
            //collectNested
        }case 204:{
            //one
        }
        case 211:{
            //sortedBy
        }
        case 203:{
            //isUnique
        }
        case 208:{
            //closure
        }
        default: return result;
        }


    }

    private static Object buildResult(ResultSet resultSet, QueryContext queryContext, String ali){
        Object result;
        if(!resultSet.isEmpty()){
            Collection<EObject> col= new HashSet<EObject>();
            for(int i=0; i<resultSet.getSize();i++){
                col.add(queryContext.getResourceSet().getEObject(resultSet.getUri(i, ali), /* loadOnDemand */true)); //$NON-NLS-1$

            }
            result = col;
            System.out.println("successfull");
        }
        else {
            Collection<EObject> col= new HashSet<EObject>();

            result = col;
        }
        return result;
    }

    private static QueryContext setQueryContext(Set<EObject> allO){
        QueryContextScopeProvider pro = new ProjectBasedQueryContextScopeProviderImpl(allO.toArray(new EObject[allO.size()]));
        QueryContext queryContext = pro.getForwardScopeAsQueryContext();
        return queryContext;
    }
    private static QueryProcessor setQueryProcessor(){
        Index DEFAULT_INDEX = null;
        DEFAULT_INDEX = new PageableIndexImpl(Options.PAGING_AND_DUMPING_DISABLED);
        QueryProcessor queryProcessor = new QueryProcessorImpl(DEFAULT_INDEX);
        return queryProcessor;
    }
}
