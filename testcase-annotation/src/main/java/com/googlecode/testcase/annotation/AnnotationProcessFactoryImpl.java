package com.googlecode.testcase.annotation;

import static java.util.Collections.emptySet;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

/**
 * cd C:\testcase-annotation\src\main\java\com\googlecode\testcase\annotation
set CLASSPATH=C:\testcase-annotation\target\classes
apt -nocompile -factory com.googlecode.testcase.annotation.AnnotationProcessFactoryImpl  ./*.java

 * @author jiafu
 *
 */
public class AnnotationProcessFactoryImpl implements AnnotationProcessorFactory {

	public Collection<String> supportedOptions() {
		return Arrays.asList("Apath","apath","path");
 	}

	public Collection<String> supportedAnnotationTypes() {
/*		return Collections
				.singleton("com.googlecode.testcase.annotation.TestCase");*/

		return  Collections.unmodifiableCollection(Arrays.asList("*"));
	}

	public AnnotationProcessor getProcessorFor(
			Set<AnnotationTypeDeclaration> annotationTypeDeclarationSet,
			AnnotationProcessorEnvironment annotationProcessorEnvironment) {
		return new TestCaseAnnotationProcessorImpl(
				annotationProcessorEnvironment);
	}
}