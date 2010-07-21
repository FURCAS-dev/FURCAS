package de.hpi.sam.bp2009.eventManagerEvaluation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.utilities.ExpressionInOCL;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import company.CompanyPackage;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLTestExpressionContainer.OclExpressionWithPackage;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;

/**
 * @author Philipp
 */
public class EventManagerRuntimeTest {
    private  class MyAdapter extends AdapterImpl {
        @Override
        public void notifyChanged(Notification msg) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            super.notifyChanged(msg);

        }
    }

     long getDepth(EventFilter f, long l) {

        if (f instanceof LogicalOperationFilter) {
            l++;
            long max = 0l;
            for (EventFilter o : ((LogicalOperationFilter) f).getOperands()) {
                max = Math.max(max, getDepth(o, l));
            }
            return max;
        }
        return l;
    }

     long getLeafCount(EventFilter f) {
        if (f instanceof LogicalOperationFilter) {
            long count = 0l;
            for (EventFilter o : ((LogicalOperationFilter) f).getOperands()) {
                count += getLeafCount(o);
            }
            return count;
        }
        return 1l;
    }

    private  class ExpressionWithContext {
        public OCLExpression expr;
        public EClass classifier;

        public ExpressionWithContext(OCLExpression e, EClass c) {
            classifier = c;
            expr = e;
        }

        @Override
	public String toString() {
            return "context " + classifier.getName() + " : " + expr.toString();
        }
    }

    private  void addConstraintToConstraintList(EAnnotation a, Map<String, ExpressionWithContext> allConstraints,
            EClassifier c) {
        if (a == null)
            return;
        int index = 0;
        for (Entry<String, String> detail : a.getDetails()) {
            String e = detail.getValue();
            if (e == null) {
                break;
            } else {
                allConstraints.put(e, new ExpressionWithContext((OCLExpression) a.getContents().get(index), (EClass) c));
            }
            index++;
        }
    }

    public  void execute(EPackage... initPackages) throws IOException {
        /*
         * create resource
         */
        /*
         * Get expressions from meta model
         */
        Map<String, EventFilter> filters;
        if(initPackages!=null && initPackages.length>0){
            filters= getAllExprFilterOfModel(initPackages);

        }else{
            filters= getAllExprFilterOfModel(CompanyPackage.eINSTANCE);
        }
        File fileObject = new File("bob1.csv");
        System.out.println(fileObject.getAbsolutePath());
        Writer fw = new FileWriter(fileObject);
        // firstTestScenario(set, r, fw);

        ArrayList<EventFilter> list = new ArrayList<EventFilter>(filters.values());

        ArrayList<OclExpressionWithPackage> adds = de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLTestExpressionContainer.getExpressionList();
        for(OclExpressionWithPackage entry : adds){
            list.add(ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(parse(entry.getOcl(), entry.getPackage())).createFilterForExpression(true));

        }
//        ArrayList<EventFilter> list2 = new ArrayList<EventFilter>(filters.values());
//        for(int index=0; index<1000; index++){
//            for(EventFilter f1: list2){
//                list.add(new OrFilter(f1));
//            }
//        }
        fw.write("Leaf Count, Depth"+"\n");
        for(EventFilter f: list){
            fw.write(getLeafCount(f) +","+getDepth(f, 0)+"\n");
        }
        fw.write("Filter Count, Naive Registrations, TimeToSubscribe" + "Event Handling naive, " + "Event Handling Table");

        System.out.println("Filter count: "+list.size());
        for (int index =0;index<list.size(); index+=10) {
            ResourceSet set = new ResourceSetImpl();
            set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
            set.getPackageRegistry().put(CompanyPackage.eNS_URI, CompanyPackage.eINSTANCE);
            Resource r = set.createResource(URI.createFileURI("C:\\Users\\Philipp\\bob.xmi"));
            r.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getDepartment()));
            ResourceSet set1 = new ResourceSetImpl();
            set1.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
            set1.getPackageRegistry().put(CompanyPackage.eNS_URI, CompanyPackage.eINSTANCE);
            Resource r1 = set1.createResource(URI.createFileURI("C:\\Users\\Philipp\\bob.xmi"));
            r1.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getDepartment()));

            /*
             * number of adapter per manager
             */
            //int limit = 1000;

            System.out.print(".");
            fw.flush();
            fw.write("\n");
            fw.write(index + ",");

            List<EventFilter> filter = list.subList(0, index);
//            fw.write(getDepth(filter, 0) + ",");
//            fw.write(getLeafCount(filter) + ",");
            ModifiedNaiveEM naive = new ModifiedNaiveEM(set, fw);
            ModifiedTableEM table = new ModifiedTableEM(set1, fw);
//            Adapter a = new AdapterImpl();
//            long startTIme = System.nanoTime();
//            naive.subscribe(filter, a);
//            fw.write((System.nanoTime() - startTIme) + ",");
//            startTIme = System.nanoTime();
//            table.subscribe(filter, a);
//            fw.write((System.nanoTime() - startTIme) + ",");

            ArrayList<Adapter> adapters = new ArrayList<Adapter>();
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            long overall=0;
            for(EventFilter f1: filter){
                Adapter a1 = new AdapterImpl();
                Adapter a2 = new AdapterImpl();
                adapters.add(a1);
                adapters.add(a2);

                naive.subscribe(f1, a1);
                long time = System.nanoTime();
                table.subscribe(f1, a2);
                time = System.nanoTime()-time;
                max = Math.max(max, time);
                min = Math.min(min, time);
                overall+=time;
            }
            System.out.println("MaxTime: " +max);
            System.out.println("MinTime:" + min);
//            System.out.println("Average:" +(overall/filter.size()));
            fw.write(naive.getRegisteredCount()+",");
            fw.write(overall +",");
            r.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getDepartment()));
            naive.setEnabled(false);
            r1.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getDepartment()));
            table.setEnabled(false);
            adapters.clear();

        }
        fw.close();

        // System.out.println("Complex Filter naive");
        //
        // testElementAdd(set, r, new ModifiedNaiveEM(set), finalF, limit2);
        //
        // String secretaryOlderThanBoss = "context Employee \n" + "inv secretaryOlderThanBoss: \n"
        // + "if self.directed->notEmpty() and \n" + "  not self.secretary.oclIsUndefined() then \n"
        // + "    self.age < self.secretary.age \n" + "else true \n" + "endif";
        //
        // OCLExpression secretaryOlderThanBossAST = (OCLExpression) BaseDepartmentTest.parse(secretaryOlderThanBoss,
        // CompanyPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();
        //
        // finalF = new ImpactAnalyzerImpl().createFilterForExpression(secretaryOlderThanBossAST, true);
        // System.out.println("secretaryOlderThanBossAST Filter Table based");
        //
        // testElementAdd(set, r, new ModifiedTableEM(set), finalF, limit2);
        // System.out.println("secretaryOlderThanBossAST Filter naive");
        // testElementAdd(set, r, new ModifiedNaiveEM(set), finalF, limit2);

    }
/*
 * szenario not i use
 */
    @SuppressWarnings("unused")
    private  void firstTestScenario(ResourceSet set, Resource r, Writer fw) throws IOException {
        int filterMaximum = 500;
        int adapterMaximum = 1000;
        int filterStepWidth = 100;
        int adapterStepWidth = 100;

        fw.write("Filtersize,,");
        for (int x = 1; x < adapterMaximum; x += adapterStepWidth) {
            fw.write("Adapter, " + x + ",,");
        }
        fw.write("\n");
        fw.write("Depth,Leafcount,");
        for (int x = 1; x < adapterMaximum; x += adapterStepWidth) {
            fw.write("Time for subscription,First EventHandling,Second EventHandling,");
        }
        fw.write("\n");
        for (int x = 1; x < filterMaximum; x += filterStepWidth) {
            // EventFilter finalF = createFilterWith8Depth();
            // for (int i = 0; i < x; i++) {
            // finalF = new AndFilter(finalF, createFilterWith8Depth(), new OrFilter(createFilterWith8Depth(),
            // createFilterWith8Depth(), createFilterWith8Depth()), createFilterWith8Depth());
            // }
            OrFilter finalF = new OrFilter();
            for (int i = 0; i < x; i++) {
                finalF.getOperands().add(new NewValueClassFilter(CompanyPackage.eINSTANCE.getEmployee(), true, false));
            }

            fw.write(getDepth(finalF, 0l) + ",");
            fw.write(getLeafCount(finalF) + ",");
            System.out.println("FilterLimit " + x);

            for (int y = 1; y < adapterMaximum; y += adapterStepWidth) {
                System.out.print(".");
                fw.flush();

                testRun2(set, r, finalF, y, fw);

            }
            fw.write("\n");
        }
        System.out.println("\n");

        for (int x = 1; x < filterMaximum; x += filterStepWidth) {
            System.out.println("FilterLimit " + x);

            EventFilter finalF = createFilterWith8Depth();
            for (int i = 0; i < x; i++) {
                finalF = new AndFilter(finalF, createFilterWith8Depth(), new OrFilter(createFilterWith8Depth(),
                        createFilterWith8Depth(), createFilterWith8Depth()), createFilterWith8Depth());
            }
            fw.write(getDepth(finalF, 0l) + ",");
            fw.write(getLeafCount(finalF) + ",");

            for (int y = 1; y < adapterMaximum; y += adapterStepWidth) {
                System.out.print(".");
                fw.flush();
                testRun(set, r, finalF, y, fw);
            }
            fw.write("\n");
        }
    }

    private  Map<String, EventFilter> getAllExprFilterOfModel(EPackage... ps) {
        Map<String, ExpressionWithContext> allConstraints = new HashMap<String, ExpressionWithContext>();
        EAnnotationOCLParser oclParser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
        for (EPackage pkg : ps) {
            oclParser.traversalConvertOclAnnotations(pkg);
        }
        for (EPackage p : ps) {
            for (EClassifier c : p.getEClassifiers()) {
                EAnnotation a = c.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
                addConstraintToConstraintList(a, allConstraints, c);
                if (c instanceof EClass) {
                    for (EOperation op : ((EClass) c).getEOperations()) {
                        a = op.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
                        addConstraintToConstraintList(a, allConstraints, c);
                    }
                    for (EAttribute at : ((EClass) c).getEAttributes()) {
                        a = at.getEAnnotation("http://de.hpi.sam.bp2009.OCL");
                        addConstraintToConstraintList(a, allConstraints, c);
                    }
                }
            }
        }

        System.out.println("Number of constraints: " +allConstraints.size());
        Map<String, EventFilter> filters = new HashMap<String, EventFilter>();
        for (Entry<String, ExpressionWithContext> entry : allConstraints.entrySet()) {
            filters.put(entry.getKey(), ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(entry.getValue().expr, entry.getValue().classifier).createFilterForExpression(true));
        }
        return filters;
    }

    private  void testRun(ResourceSet set, Resource r, EventFilter finalF, int limit2, Writer writer) {

        // System.out.println("Complex Filter Table based");

        testElementAdd(set, r, new ModifiedTableEM(set, writer), finalF, limit2, writer);
    }

    private  void testRun2(ResourceSet set, Resource r, EventFilter finalF, int limit2, Writer writer) {

        // System.out.println("Complex Filter Table based");

        testElementAdd(set, r, new ModifiedNaiveEM(set, writer), finalF, limit2, writer);
    }

    private  void testElementAdd(ResourceSet set, Resource r, EventManager em, EventFilter f, int limit, Writer fw) {
        Set<Adapter> adapters = new HashSet<Adapter>();
        long totalSubTime = 0l;
        for (int i = 0; i < limit; i++) {
            MyAdapter a = new MyAdapter();
            long start = System.nanoTime();
            em.subscribe(f.clone(), a);
            long duration = System.nanoTime() - start;
            totalSubTime += duration;
            adapters.add(a);
        }
        try {
            fw.write((totalSubTime / limit) + ",");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int x = 0; x < 1000; x++) {
            r.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getDepartment()));
            r.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getDepartment()));
        }
        for (Adapter a : adapters) {
            em.unsubscribe(a);
        }
    }

     EventFilter createFilterWith8Depth() {
        OrFilter result = new OrFilter();
        OrFilter level1 = new OrFilter();
        OrFilter level2 = new OrFilter();
        OrFilter level3 = new OrFilter();
        OrFilter level4 = new OrFilter();
        OrFilter level5 = new OrFilter();
        OrFilter level6 = new OrFilter();
        OrFilter level7 = new OrFilter();
        OrFilter level8 = new OrFilter();
        OrFilter level9 = new OrFilter();

        level9.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level9.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level8.getOperands().add(level9);
        level8.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level8.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level7.getOperands().add(level8);
        level7.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level7.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level6.getOperands().add(level7);
        level6.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level6.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level5.getOperands().add(level6);
        level5.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level5.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level4.getOperands().add(level5);
        level4.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level4.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level3.getOperands().add(level4);
        level3.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level3.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level2.getOperands().add(level3);
        level2.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level2.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level1.getOperands().add(level2);
        level1.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level1.getOperands().add(
                EventManagerFactory.eINSTANCE
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        result.getOperands().add(level1);

        return result;
    }
     OCLExpression parse(String expression, EPackage basePackage) {
         OCLInput exp = new OCLInput(expression);
       String nsPrefix = basePackage.getNsPrefix();
       EPackage.Registry.INSTANCE.put(nsPrefix, basePackage);
       ArrayList<String> path = new ArrayList<String>();
       path.add(nsPrefix);
       OCL ocl = OCLWithHiddenOpposites.newInstance();
       ocl = OCLWithHiddenOpposites.newInstance(ocl.getEnvironment().getFactory().createPackageContext(ocl.getEnvironment(), path));
       OCLExpression result = null;
       try {
           ExpressionInOCL<EClassifier, EParameter> specification = ocl.parse(exp).iterator().next().getSpecification();
           result = (OCLExpression)specification.getBodyExpression();


       } catch (ParserException e) {
           System.err.println("Error while parsing Expression:" + exp);
           e.printStackTrace();
           System.exit(0);
       }
       return result;
   }


}
