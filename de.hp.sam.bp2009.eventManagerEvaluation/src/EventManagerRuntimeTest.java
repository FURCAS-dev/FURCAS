import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import company.CompanyPackage;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.LogicalOperationFilter;
import de.hpi.sam.bp2009.solution.eventManager.filters.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.util.EventFilterFactory;

/**
 * @author Philipp
 */
public class EventManagerRuntimeTest {
    private static class MyAdapter extends AdapterImpl {
        @Override
        public void notifyChanged(Notification msg) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            super.notifyChanged(msg);

        }
    }

    static long getDepth(EventFilter f, long l) {

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

    static long getLeafCount(EventFilter f) {
        if (f instanceof LogicalOperationFilter) {
            long count = 0l;
            for (EventFilter o : ((LogicalOperationFilter) f).getOperands()) {
                count += getLeafCount(o);
            }
            return count;
        }
        return 1l;
    }

    public static void main(String[] args) throws IOException {

        ResourceSet set = new ResourceSetImpl();
        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
        set.getPackageRegistry().put(CompanyPackage.eNS_URI, CompanyPackage.eINSTANCE);
        Resource r = set.createResource(URI.createFileURI("C:\\Users\\Philipp\\bob.xmi"));
        for (int i = 0; i < 100; i++) {
            RandomGeneratorFactory.eINSTANCE.createRandomGenerator().generateRandomModel(null, r, CompanyPackage.eINSTANCE);
        }

        int filterMaximum = 200;
        int adapterMaximum = 1000;
        int filterStepWidth = 10;
        int adapterStepWidth = 50;
        File f = new File("bob2.csv");
        Writer fw = new FileWriter(f);

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
            EventFilter finalF = createFilterWith8Depth();
            for (int i = 0; i < x; i++) {
                finalF = new AndFilter(finalF, createFilterWith8Depth(), new OrFilter(createFilterWith8Depth(),
                        createFilterWith8Depth(), createFilterWith8Depth()), createFilterWith8Depth());
            }
            fw.write(getDepth(finalF, 0l) + ",");
            fw.write(getLeafCount(finalF) + ",");
            System.out.println("FilterLimit "+x);

            for (int y = 1; y < adapterMaximum; y += adapterStepWidth) {
                System.out.print(".");
                fw.flush();
                testRun(set, r, finalF, y, fw);
            }
            fw.write("\n");
        }
        System.out.println("\n");
        
        for (int x = 1; x < filterMaximum; x += filterStepWidth) {
            System.out.println("FilterLimit "+x);

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
                testRun2(set, r, finalF, y, fw);
            }
            fw.write("\n");
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

    private static void testRun(ResourceSet set, Resource r, EventFilter finalF, int limit2, Writer writer) {

        // System.out.println("Complex Filter Table based");

        testElementAdd(set, r, new ModifiedTableEM(set, writer), finalF, limit2,writer);
    }

    private static void testRun2(ResourceSet set, Resource r, EventFilter finalF, int limit2, Writer writer) {

        // System.out.println("Complex Filter Table based");

        testElementAdd(set, r, new ModifiedNaiveEM(set, writer), finalF, limit2, writer);
    }

    private static void testElementAdd(ResourceSet set, Resource r, EventManager em, EventFilter f, int limit, Writer fw) {
        Set<Adapter> adapters = new HashSet<Adapter>();
        long totalSubTime=0l;
        for (int i = 0; i < limit; i++) {
            MyAdapter a = new MyAdapter();
            long start = System.nanoTime();
            em.subscribe(f.clone(), a);
            long duration = System.nanoTime()-start;
            totalSubTime +=duration;
            adapters.add(a);
        }
        try {
            fw.write((totalSubTime/limit)+",");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        
        r.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getEmployee()));
        r.getContents().add(new DynamicEObjectImpl(CompanyPackage.eINSTANCE.getEmployee()));
        for (Adapter a : adapters) {
            em.unsubscribe(a);
        }
    }

    static EventFilter createFilterWith8Depth() {
        OrFilter result = new OrFilter();
        AndFilter level1 = new AndFilter();
        OrFilter level2 = new OrFilter();
        AndFilter level3 = new AndFilter();
        OrFilter level4 = new OrFilter();
        AndFilter level5 = new AndFilter();
        OrFilter level6 = new OrFilter();
        AndFilter level7 = new AndFilter();
        OrFilter level8 = new OrFilter();
        AndFilter level9 = new AndFilter();

        level9.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level9.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level8.getOperands().add(level9);
        level8.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level8.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level7.getOperands().add(level8);
        level7.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level7.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level6.getOperands().add(level7);
        level6.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level6.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level5.getOperands().add(level6);
        level5.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level5.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level4.getOperands().add(level5);
        level4.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level4.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level3.getOperands().add(level4);
        level3.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level3.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level2.getOperands().add(level3);
        level2.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level2.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        level1.getOperands().add(level2);
        level1.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));
        level1.getOperands().add(
                EventFilterFactory.getInstance()
                        .createFilterForElementInsertionOrDeletion(CompanyPackage.eINSTANCE.getEmployee()));

        result.getOperands().add(level1);

        return result;
    }

}
