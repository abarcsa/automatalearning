package hu.bme.mit.automatalearning.Learnable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import hu.bme.mit.ltl.LTLExpression;
import hu.bme.mit.ltl.LtlPackage;
import hu.bme.mit.ltl.LtlRuntimeModule;
import hu.bme.mit.ltl.LtlStandaloneSetup;
import hu.bme.mit.mealymodel.MealyDslStandaloneSetup;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelPackage;
import jhoafparser.parser.generated.ParseException;

public class LTLExpressionParser {
	
	public LTLExpressionParser() {
		setupParser();
	}
	
	private void setupParser() {
		//TODO
	}
	
	public LTLExpression parse(InputStream in) throws IOException
    {
		Injector injector = new LtlStandaloneSetup().createInjectorAndDoEMFRegistration();
		LtlPackage.eINSTANCE.eClass();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.ltl"));		resource.load(in, resourceSet.getLoadOptions());
		LTLExpression model = (LTLExpression) resource.getContents().get(0);
		return model;
    }
	
}
