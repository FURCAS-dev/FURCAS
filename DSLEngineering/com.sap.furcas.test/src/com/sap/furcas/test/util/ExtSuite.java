package com.sap.furcas.test.util;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/**
 * Test runner class extending org.junit.runners.Suite. In addition to the
 * SuiteClasses annotation of Suite, a new annotation called SuitePackages was
 * added. Both annotations are mandatory, but can be empty.
 * 
 * @author C5126871
 * 
 */
public class ExtSuite extends Suite {

    /**
     * This test runner will (recursively) gather all classes with at least one @Test
     * method from each of the listed packages. It is assumed, that classes are
     * compiled to the 'bin' folder and that the classes are deployed in folders
     * (not jar).
     * 
     * Note: As the class loader of the annotated suite class is used, any
     * visible class is added, disregarding for example it's source folder.
     * 
     * @author C5126871
     * 
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface SuitePackages {
	public String[] value();
    }

    public ExtSuite(Class<?> klass) throws Exception {
	super(klass, getAllClasses(klass));
    }

    private static Class<?>[] getAllClasses(Class<?> klass) throws InitializationError {
	HashSet<Class<?>> result = new HashSet<Class<?>>();
	result.addAll(getClassesInPackages(klass.getClassLoader(), getAnnotatedPackages(klass)));
	result.addAll(Arrays.asList(getAnnotatedClasses(klass)));

	ArrayList<Class<?>> sortedResult = new ArrayList<Class<?>>(result);
	Collections.sort(sortedResult, new Comparator<Class<?>>() {

	    @Override
	    public int compare(Class<?> a, Class<?> b) {
		return a.getName().compareTo(b.getName());
	    }

	});

	return sortedResult.toArray(new Class<?>[0]);
    }

    private static List<Class<?>> getClassesInPackages(ClassLoader classLoader, String[] pckes) {
	ArrayList<Class<?>> result = new ArrayList<Class<?>>();
	for (String pck : pckes) {
	    try {
		result.addAll(getClassesInPackage(classLoader, pck));
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	return result;
    }

    private static Class<?>[] getAnnotatedClasses(Class<?> klass) throws InitializationError {
	SuiteClasses annotation = klass.getAnnotation(SuiteClasses.class);
	if (annotation == null) {
	    throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", klass.getName()));
	}
	return annotation.value();
    }

    private static String[] getAnnotatedPackages(Class<?> klass) throws InitializationError {
	SuitePackages annotation = klass.getAnnotation(SuitePackages.class);
	if (annotation == null) {
	    throw new InitializationError(String.format("class '%s' must have a SuitePackages annotation", klass.getName()));
	}
	return annotation.value();
    }

    /**
     * Scans all classes accessible from the context class loader which belong
     * to the given package and subpackages.
     * 
     * @param packageName
     *            The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static List<Class<?>> getClassesInPackage(ClassLoader classLoader, String packageName) throws ClassNotFoundException,
	    IOException {
	assert classLoader != null;
	String path = packageName.replace('.', '/');
	Enumeration<URL> resources = classLoader.getResources(path);
	List<File> dirs = new ArrayList<File>();
	while (resources.hasMoreElements()) {
	    URL resource = resources.nextElement();

	    String fullPath = "";
	    if (resource.getProtocol().equals("bundleresource")) {
		// relative platform path
		fullPath = "bin" + resource.getPath();
	    } else if (resource.getProtocol().equals("file")) {
		// absolute platform path
		fullPath = resource.getPath();
	    } else {
		System.out.println("ExtSuite is missing support for resource of protocol " + resource.getProtocol() + " ("
			+ resource.getPath() + ")");
		continue;
	    }

	    // ignore folder starting with '.' (i.e '.svn')
	    if (fullPath.endsWith("/") || !(fullPath.charAt(fullPath.lastIndexOf("/") + 1) == '.')) {
		dirs.add(new File(fullPath.replace("%20", " ")));
	    }
	}
	ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
	for (File directory : dirs) {
	    classes.addAll(findClasses(directory, packageName));
	}
	return classes;
    }

    /**
     * Recursive method used to find all classes in a given directory and
     * subdirs.
     * 
     * @param directory
     *            The base directory
     * @param packageName
     *            The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
	List<Class<?>> classes = new ArrayList<Class<?>>();
	if (!directory.exists()) {
	    return classes;
	}
	File[] files = directory.listFiles();
	for (File file : files) {
	    if (file.isDirectory()) {
		assert !file.getName().contains(".");
		classes.addAll(findClasses(file, packageName + "." + file.getName()));
	    } else if (file.getName().endsWith(".class")) {
		Class<?> candidate = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
		// find at least one @Test method
		for (Method method : candidate.getMethods()) {
		    if (method.getAnnotation(Test.class) != null) {
			classes.add(candidate);
			break;
		    }
		}
	    }
	}
	return classes;
    }

}
