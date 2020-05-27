package hu.bme.mit.automatalearning;

/*import com.google.inject.Injector;
import hu.bme.mit.mealymodel.xtext.MealymachineDslStandaloneSetup;*/
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelPackage;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
/*import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;*/

public class MealyModelReader {
	public static MealyMachine getMealyModelFromXtext(String input) {
		/*new MealymachineDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		MealymodelPackage.eINSTANCE.eClass();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createURI(input), true);
		MealyMachine model = (MealyMachine) resource.getContents().get(0);
		return model;*/
		return null;
	}
	public static void output(MealyMachine m) {
		try(PrintWriter writer = new PrintWriter("learnedmachine.mealy", "UTF-8");){
			writer.println("MealyMachine{");
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
	
	public static void output(MealyMachine m, String fileName) {
		try(PrintWriter writer = new PrintWriter(fileName, "UTF-8");){
			writer.println("MealyMachine{");
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