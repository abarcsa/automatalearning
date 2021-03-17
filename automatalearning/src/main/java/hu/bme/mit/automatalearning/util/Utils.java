package hu.bme.mit.automatalearning.util;


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.inject.Injector;

import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.lpt.LPTRootNode;
import hu.bme.mit.lpt.LptPackage;
import hu.bme.mit.mealymodel.MealyDslStandaloneSetup;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelPackage;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class Utils {
	
	/*public static LPTRootNode getLPT(String path) {
		LptPackage.eINSTANCE.eClass();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
         m.put("lpt", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		 Resource resource = resSet.getResource(URI.createFileURI(path), true);
	        // Get the first model element and cast it to the right type, in my
	        // example everything is hierarchical included in this first node
		 LPTRootNode rootNode = (LPTRootNode) resource.getContents().get(0);
	        return rootNode;
	}*/
	
	public static MealyMachine getMealyModelFromXtext(String input) throws IOException {
		Injector injector = new MealyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		MealymodelPackage.eINSTANCE.eClass();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/example.mealy"));
		InputStream in = new FileInputStream(new File(input));
		resource.load(in, resourceSet.getLoadOptions());
		MealyMachine model = (MealyMachine) resource.getContents().get(0);
		return model;
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
	
	public static void visualizeEQ(Hypothesis<String, String, MealyMachine, State, Transition> hypo) {
		try(PrintWriter writer = new PrintWriter(".\\eqVisualization\\tmp_hypo.json", "UTF-8");){
			JSONObject hypoJSON = hypoToJSON(hypo);
			writer.write(hypoJSON.toString());
			writer.flush();
			writer.close();
			ProcessBuilder processBuilder = new ProcessBuilder("python", new File("").getAbsolutePath() + "\\eqVisualization\\eqVisualizer.py");
		    processBuilder.redirectErrorStream(true);
		    for(String str : processBuilder.command()) {
		    	System.out.println(str);
		    }
		    Process process = processBuilder.start();
		    Desktop desktop = Desktop.getDesktop();  
		    desktop.open(new File(new File("").getAbsolutePath() + "\\eqVisualization\\tmp_hypo.dot.svg"));
		}catch(Exception e) {
			e.printStackTrace();
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
	private static int hypoCount = 0;
	public static void logHypothesisToJSON(Hypothesis<String, String, MealyMachine, State, Transition> hypo, String prefix) {
		JSONObject obj = 
			new JSONObject()
				.put("alphabet", new JSONArray(hypo.getHypothesisTransitions().stream()
													.map(t -> t.getInput() + "/" + t.getOutput())
													.collect(Collectors.toList())))
			    .put("states", new JSONArray(hypo.getHypothesisStates().stream()
			    									.map(s -> s.getName())
			    									.collect(Collectors.toList())))
			    .put("initial_state", hypo.getHypothesisAutomaton().getInitialState().getName())
			    .put("accepting_states", new JSONArray())
			    .put("transitions", new JSONArray(hypo.getHypothesisTransitions().stream().map(t -> 
			    	new JSONArray().put(t.getSourceState().getName())
			    				   .put(t.getInput() + "/" + t.getOutput())
			    				   .put(t.getTargetState().getName())).collect(Collectors.toList())));
		
		try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("./logs/" + prefix + "hypo_" + hypoCount++ + ".json")))) {
			bW.write(obj.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private static JSONObject hypoToJSON(Hypothesis<String, String, MealyMachine, State, Transition> hypo) {
		JSONObject obj = 
				new JSONObject()
					.put("alphabet", new JSONArray(hypo.getHypothesisTransitions().stream()
														.map(t -> t.getInput() + "/" + t.getOutput())
														.collect(Collectors.toList())))
				    .put("states", new JSONArray(hypo.getHypothesisStates().stream()
				    									.map(s -> s.getName())
				    									.collect(Collectors.toList())))
				    .put("initial_state", hypo.getHypothesisAutomaton().getInitialState().getName())
				    .put("accepting_states", new JSONArray())
				    .put("transitions", new JSONArray(hypo.getHypothesisTransitions().stream().map(t -> 
				    	new JSONArray().put(t.getSourceState().getName())
				    				   .put(t.getInput() + "/" + t.getOutput())
				    				   .put(t.getTargetState().getName())).collect(Collectors.toList())));
		return obj;
	}
}
