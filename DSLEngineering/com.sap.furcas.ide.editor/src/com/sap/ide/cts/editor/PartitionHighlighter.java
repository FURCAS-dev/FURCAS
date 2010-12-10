package com.sap.ide.cts.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;

import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbUtil;

public class PartitionHighlighter {
	public static final String OTHER_PARTITION_ANNOTATION_TYPE = "com.sap.ide.cts.editor.partition_highlight";
	private final IAnnotationModel fModel;
	private final Map<DocumentNode, Annotation> fMatchesToAnnotations;
	
	public PartitionHighlighter(IAnnotationModel model) {
		fModel= model;
		fMatchesToAnnotations= new WeakHashMap<DocumentNode, Annotation>();
	}

	public void addHighlights(Collection<DocumentNode> matches) {
		HashMap<Annotation, Position> map= new HashMap<Annotation, Position>(matches.size());
		for (DocumentNode match : matches) {
			if(match instanceof TextBlock) {
				TextBlock tb = (TextBlock)match;
				int offset= TbUtil.getAbsoluteOffsetWithoutBlanks(tb);
				int length= TbUtil.getLengthWithoutStartingBlanks(tb);
				if (offset >= 0 && length >= 0) {
					Position position= createPosition(tb);
					if (position != null) {
					    for (EObject element : tb.getCorrespondingModelElements()) {
							EObject partitionable  = element;
							if (element.eResource().equals(tb.eResource())) {
								continue; // show errors only for the broken elements
							}
							String elementName = (element.eClass()).getName();
							String partitionName = partitionable.eResource().getURI().toString();
							String text = elementName + " from partition: " + partitionName;
							if(text.indexOf("/_comp/") >= 0) {
								//The annotation text is quite long, so split it in two lines
								text = text.replaceFirst("\\/\\_comp\\/", "/_comp/\n\t\t\t\t\t\t");
							}
							Annotation annotation=  
								 new Annotation(PartitionHighlighter.OTHER_PARTITION_ANNOTATION_TYPE, true, 
										 text);
							fMatchesToAnnotations.put(match, annotation);
							map.put(annotation, position);
						}
					}
				}
			}
		}
		addAnnotations(map);
		
	}
	
	private Position createPosition(TextBlock tb) {
		int offset= TbUtil.getAbsoluteOffsetWithoutBlanks(tb);
		int length= TbUtil.getLengthWithoutStartingBlanks(tb);
		Position position= new Position(offset, length);
		return position;
	}

	public void removeHighlights(DocumentNode[] matches) {
		HashSet<Annotation> annotations= new HashSet<Annotation>(matches.length);
		for (int i= 0; i < matches.length; i++) {
			Annotation annotation= fMatchesToAnnotations.remove(matches[i]);
			if (annotation != null) {
				annotations.add(annotation);
			}
		}
		removeAnnotations(annotations);
	}
	
	public  void removeAll() {
		Collection<Annotation> matchSet= fMatchesToAnnotations.values();
		removeAnnotations(matchSet);
		fMatchesToAnnotations.clear();
	}
	
	private void addAnnotations(Map<Annotation, Position> annotationToPositionMap) {
		if (fModel instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension ame= (IAnnotationModelExtension) fModel;
			ame.replaceAnnotations(new Annotation[0], annotationToPositionMap);
		} else {
			for (Iterator<Annotation> elements= annotationToPositionMap.keySet().iterator(); elements.hasNext();) {
				Annotation element= elements.next();
				Position p= annotationToPositionMap.get(element);
				fModel.addAnnotation(element, p);
			}
		}
	}
	
	/**
	 * Removes annotations from the given annotation model. The default implementation works for editors that
	 * implement <code>ITextEditor</code>.
	 * Subclasses may override this method. 
	 * @param annotations A set containing the annotations to be removed.
	 * 			 @see Annotation
	 */
	private void removeAnnotations(Collection<Annotation> annotations) {
		if (fModel instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension ame= (IAnnotationModelExtension) fModel;
			Annotation[] annotationArray= new Annotation[annotations.size()];
			ame.replaceAnnotations(annotations.toArray(annotationArray), Collections.EMPTY_MAP);
		} else {
			for (Iterator<Annotation> iter= annotations.iterator(); iter.hasNext();) {
				Annotation element= iter.next();
				fModel.removeAnnotation(element);
			}
		}
	}

}
