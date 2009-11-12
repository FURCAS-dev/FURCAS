package com.sap.ide.moftool.editor.fwk;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofException;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

public abstract class ConverterUtil {

	public static abstract class Ui {
		
		public static final IConverter ModelElement2QualifiedName = new ModelElement2QualifiedName();

		private static final class ModelElement2QualifiedName extends Converter {
			private ModelElement2QualifiedName() {
				super(Object.class, String.class.getName());
			}

			public Object convert(Object o) {
				if (o instanceof ModelElement) {
					return MofService.getQualifiedNameAsString(((ModelElement) o).getQualifiedName());
				}
				else return o.toString();
			}
		}
	}

	public static abstract class Model {		


		public static final class Qn2Classifier extends Converter {

			private Connection connection;

			public Qn2Classifier(Connection connection) {
				super(String.class, Classifier.class.getName());
				this.connection = connection;
			}

			public Object convert(Object classifierAsString) {
				Classifier classifier = MofService.getClassifierByQualifiedName(connection, (String) classifierAsString);
				if (classifier == null) {
					// <pg081208> convert package names because this converter is also used for package selection 
					return MofService.getPackageByQualifiedName(connection, (String) classifierAsString);
				} else {
					return classifier;
				}
				
			}
		}

		public static class Qn2Constraint extends Converter {
			
			private Connection connection;
			
			public Qn2Constraint(Connection connection) {
				super(String.class, Constraint.class.getName());
				this.connection = connection;
			}
			
			public Object convert(Object fromObject) {
				Connection connection = ((Partitionable)fromObject).get___Connection();
				String concatVal = null;
				Collection<Constraint> constraints = MofService.getAvailableConstraints(connection);
				for (Constraint constraint : constraints) {
		            	List<String> qualifiedName = constraint.getQualifiedName();
		            	concatVal = MofService.getQualifiedNameAsString(qualifiedName);
						if (fromObject.equals(concatVal) ) {                    
							return constraint;
						}
				}
				return null;
			}
			
		}
		
		public static class Qn2Exception extends Converter {
			
			private Connection connection;
			
			public Qn2Exception(Connection connection) {
				super(String.class, Exception.class.getName());
				this.connection = connection;
			}
			
			public Object convert(Object fromObject) {
				Connection connection = ((Partitionable)fromObject).get___Connection();
				String concatVal = null;
				Collection<MofException> mofExceptions = MofService.getAvailableMofExceptions(connection);
				for (MofException mofException : mofExceptions) {
		            	List<String> qualifiedName = mofException.getQualifiedName();
		            	concatVal = MofService.getQualifiedNameAsString(qualifiedName);
						if (fromObject.equals(concatVal) ) {                    
							return mofException;
						}
				}
				return null;
			}
			
		}
		
		public static class Qn2ModelElement extends Converter {
			
			private Connection connection;
			
			public Qn2ModelElement(Connection connection) {
				super(String.class, ModelElement.class.getName());
				this.connection = connection;
			}
			
			public Object convert(Object fromObject) {
				Connection connection = ((Partitionable)fromObject).get___Connection();
				String concatVal = null;
				Collection<ModelElement> mes = MofService.getAvailableModelElements(connection);
				for (ModelElement me : mes) {
		            	List<String> qualifiedName = me.getQualifiedName();
		            	concatVal = MofService.getQualifiedNameAsString(qualifiedName);
						if (fromObject.equals(concatVal) ) {                    
							return me;
						}
				}
				return null;
			}
			
		}
	}
}
