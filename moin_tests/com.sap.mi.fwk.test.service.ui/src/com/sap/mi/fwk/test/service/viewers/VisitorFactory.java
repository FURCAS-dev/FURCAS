package com.sap.mi.fwk.test.service.viewers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

import com.sap.mi.fwk.test.service.ui.internal.viewers.TreeNodeSerializer;

/**
 * Factory for creating visitor instances.
 * 
 * @author d022960
 * 
 */
public class VisitorFactory {

	private static VisitorFactory sInstance;

	/**
	 * Constant indicating that all levels of the tree should be expanded or
	 * collapsed.
	 */
	public static final int ALL_LEVELS = -1;

	/**
	 * Constant indicating that class names of tree nodes and corresponding node
	 * values should be serialized.
	 */
	public static final int SERIALIZE_CLASS_NAMES = 1;

	/**
	 * Constant indicating that the label information retrieved from the
	 * <code>LabelProvider</code> should be serialized.
	 */
	public static final int SERIALIZE_LABELS = 2;

	/**
	 * Constant indicating that class names of tree nodes, corresponding node
	 * values and the label information retrieved from the
	 * <code>LabelProvider</code> should be serialized.
	 */
	public static final int SERIALIZE_CLASS_NAMES_AND_LABELS = 3;

	/**
	 * Returns a singleton of this visitor factory.
	 * 
	 * @return the instance of this service
	 */
	public static synchronized VisitorFactory getInstance() {
		if (sInstance == null)
			sInstance = new VisitorFactory();
		return sInstance;
	}

	/**
	 * Creates a visitor instance that is capable for building a string
	 * representation of the entire tree content using the given content
	 * provider and label provider. First <code>getElements</code> on the
	 * given <code>ITreeContentProvider</code> is called in order to retrieve
	 * the root elements of the tree. For each root element
	 * <code>getChildren</code> is called recursively.
	 * <p>
	 * The implementation checks for recursions.
	 * </p>
	 * The method {@link IStructuredContentVisitor#getResult()} returns a copy
	 * of the internal <code>StringBuffer</code>. Users should call
	 * {@link IStructuredContentVisitor#getResultAsString()} in order to
	 * retrieve the result as a <code>String</code>.
	 * 
	 * @param contentProvider
	 *            the content provider used to traverse the tree hierarchy.
	 * @param labelProvider
	 *            the label provider used to retrieve the text and image
	 *            information. To include this information the value of
	 *            <code>serializeOptions</code> has to be either
	 *            {@link #SERIALIZE_LABELS} or
	 *            {@link #SERIALIZE_CLASS_NAMES_AND_LABELS}. It must not be
	 *            <code>null</code> in this case.
	 * @param serializeOptions
	 *            see {@link #SERIALIZE_CLASS_NAMES}, {@link #SERIALIZE_LABELS}
	 *            or {@link #SERIALIZE_CLASS_NAMES_AND_LABELS}
	 * @param depth
	 *            defines the depth of the traversal. In case the entire tree
	 *            hierarchy should be traversed pass the value
	 *            {@link #ALL_LEVELS}.
	 * @return a newly created visitor instance.
	 */
	public IStructuredContentVisitor createTreeContentSerializer(ITreeContentProvider contentProvider, ILabelProvider labelProvider,
			int serializeOptions, int depth) {
		return new TreeNodeSerializer(contentProvider, labelProvider, serializeOptions, depth);
	}
}
