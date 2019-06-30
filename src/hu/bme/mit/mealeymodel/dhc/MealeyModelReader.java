package hu.bme.mit.mealeymodel.dhc;

import com.google.inject.Injector;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelPackage;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.Transition;
import hu.bme.mit.mealeymodel.text.MealeymodelDslStandaloneSetup;

import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

public class MealeyModelReader {
	public static MealeyMachine getMealeyModelFromXtext() {
		new MealeymodelDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		MealeymodelPackage.eINSTANCE.eClass();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createURI("./src/coffeemachine.mealey"), true);
		MealeyMachine model = (MealeyMachine) resource.getContents().get(0);
		return model;
	}
	public static void output(MealeyMachine m) {
		try(PrintWriter writer = new PrintWriter("learnedmachine.mealey", "UTF-8");){
			writer.println("MealeyMachine{");
			writer.print("initialState ");
			writer.println("State " + m.getInitialState().getName());
			writer.print("states {");
			for(State s : m.getStates()) {
				writer.print("State " + s.getName() + ",");
			}
			writer.println("}");
			writer.println("transitions {");
			for(Transition t : m.getTransitions()) {
				writer.println("Transition { input " + t.getInput() + " output " + t.getOutput() + " sourceState " + t.getSourceState().getName() + " targetState " + t.getTargetState().getName() + "},");
			}
			writer.print("}");
		}catch(Exception e) {
			
		}
	}
	
}