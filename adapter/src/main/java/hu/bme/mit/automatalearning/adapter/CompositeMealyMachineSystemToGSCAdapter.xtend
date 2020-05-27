package hu.bme.mit.automatalearning.adapter

import java.util.Collection
import hu.bme.mit.mealymodel.MealyMachine
import java.util.Map
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.Set
import java.util.ArrayList

class CompositeMealyMachineSystemToGSCAdapter {
	
	// Output parameters
	String interfacePackageName = "Interfaces"
	String systemName = "CompositeSystem"								
	Map<MealyMachine, String> componentNames = new	HashMap<MealyMachine, String>
	final String statechartPostfix = "Statechart"
	
	// The transformed system
	var Set<String> interfaces = null
	var Map<String, Collection<String>> events = null	//interface -> messages
	var Map<MealyMachine, Set<String>> inputPorts = null
	var Map<MealyMachine, Set<String>> outputPorts = null
	var Collection<PortBinding> portBindings = null	
	
	//the components to transform
	Collection<MealyMachine> systemComponents										
	
	new(Collection<MealyMachine> compositeMealyMachineSystem) {
		systemComponents = compositeMealyMachineSystem
		createDefaultComponentNames
	}
	//TODO c'tor with system & component names
	
	private def createDefaultComponentNames() {
		var int i = 0
		for(var iterator = systemComponents.iterator(); iterator.hasNext(); i++){
			componentNames.put(iterator.next(), "Component" + i)
		}
	}
	
	def String getCompositeSystem() {
		return '''
		package «systemName»Package
		
		import "«interfacePackageName».gcd"
		«FOR comp : systemComponents»
		import "«componentNames.get(comp)».gcd"
		«ENDFOR»
		
		sync «systemName» [ «««FIXME ','s
			«FOR binding : portBindings SEPARATOR ','»
			«IF binding.providingComponent === null»
			port «binding.requiredPort» : requires «binding.requiredPort»
			«ENDIF» 
			«IF binding.requiringComponent === null»
				port «binding.providedPort» : provides «binding.providedPort»
			«ENDIF» 
			«ENDFOR»
		] {
			// Components:
			«FOR comp : systemComponents»
			component «getComponentInstanceName(comp)» : «componentNames.get(comp) + statechartPostfix»
			«ENDFOR»
			
			// Binding system ports:
			«FOR binding : portBindings»
			«IF binding.providedPort === null»
			bind «binding.requiredPort» -> «binding.requiringComponent».«binding.requiredPort»
			«ENDIF» 
			«IF binding.requiredPort === null»
			bind «binding.providedPort» -> «binding.providingComponent».«binding.providedPort»
			«ENDIF» 
			«ENDFOR»
			
			// Connecting component ports:
			«FOR binding : portBindings»
			«IF binding.requiredPort !== null»
			«IF binding.providedPort !== null»
			channel [«binding.providingComponent».«binding.providedPort»] -o)- [«binding.requiringComponent».«binding.requiredPort»]
			«ENDIF»
			«ENDIF» 
			«ENDFOR»
		}
		
		'''
	}
	
	def transformPortBindings() { 
		if(portBindings === null) {
			portBindings = new HashSet<PortBinding>
		}
		//Bind inputs to outputs
		for(inMm : inputPorts.keySet) {
			for(ip : inputPorts.get(inMm)){
				var bound = false
				for(outMm : outputPorts.keySet) {
					for(op : outputPorts.get(outMm)) {
						if(ip == op) {
							portBindings.add(
								new PortBinding(getComponentInstanceName(outMm), op, 
												getComponentInstanceName(inMm), ip)
							)
							bound = true
						}
					}
				}
				if(!bound) {
					portBindings.add(
						new PortBinding(null, null, getComponentInstanceName(inMm), ip)
					)
				}
			}
		}
		
		//Bind the rest of the output ports
		for(outMm : outputPorts.keySet) {
			for(op : outputPorts.get(outMm)) {
				var bound = false
				for(pb : portBindings) {
					if(pb.providedPort == op) {
						bound = true
					}
				}
				if(!bound) {
					portBindings.add(
						new PortBinding(getComponentInstanceName(outMm), op, null, null)
					)
				}
			}
		}
	}
	
	def getComponentInstanceName(MealyMachine mm) {
		return "_" + componentNames.get(mm).toLowerCase
	}
	
	def Collection<String> getComponents() {
		var transformedComponents = new ArrayList<String>
		for(mm : systemComponents) {
			transformedComponents.add(getComponent(mm))
		}
		return transformedComponents
	}
	
	def String getComponent(MealyMachine mm) {
		return '''
		package «componentNames.get(mm)»
		
		import "«interfacePackageName»"
				
		statechart «componentNames.get(mm) + statechartPostfix» [
			«FOR _inInterf : inputPorts.get(mm)»
				port «_inInterf» : requires «_inInterf»
			«ENDFOR»
			«FOR _outInterf : outputPorts.get(mm)»
				port «_outInterf» : provides «_outInterf»
			«ENDFOR»
		] {
			transition from _initialState to «mm.initialState.name»
			«FOR transition : mm.transitions»
			transition from «transition.sourceState.name» to «transition.targetState.name» when «transition.input» / raise «transition.output»;
			«ENDFOR»
			
			region mainRegion {
				initial _initialState
				«FOR state : mm.states»
				state «state.name»
				«ENDFOR»
			}
		
		}
		'''
	}
	
	def String getInterfaces() {
		return '''
		package «interfacePackageName»
		
		«FOR _interface : interfaces»
		interface «_interface» {
			«FOR _event : events.get(_interface)»
			out event «_event»
			«ENDFOR»
		}
		«ENDFOR»
		'''
	}

	def void transformInterfaces() {
		if(interfaces === null) {
			interfaces = new HashSet<String>
		}
		if(inputPorts === null) {
			inputPorts = new HashMap<MealyMachine, Set<String>>
		}
		if(outputPorts === null) {
			outputPorts = new HashMap<MealyMachine, Set<String>>
		}
		if(events === null) {
			events = new HashMap<String, Collection<String>>
		}
		
		for(mm : systemComponents) {
			transformMealyMachineToGammaInterface(mm, interfaces, events)
		}
	}
	
	private def void transformMealyMachineToGammaInterface(MealyMachine mm, Set<String> interfaces, Map<String, Collection<String>> events) {
		for(character : mm.inputAlphabet.characters) {
			var inInterf = transformMealyCharacterToGamma(character, interfaces, events)
			if(!inputPorts.containsKey(mm)) {
				inputPorts.put(mm, new HashSet<String>)
			}
			inputPorts.get(mm).add(inInterf)
		}

		for(character : mm.outputAlphabet.characters) {
			var outPort = transformMealyCharacterToGamma(character, interfaces, events)
			if(!outputPorts.containsKey(mm)) {
				outputPorts.put(mm, new HashSet<String>)
			}
			outputPorts.get(mm).add(outPort)
		}
	}
	
	private def String transformMealyCharacterToGamma(String character, Set<String> interfaces, Map<String, Collection<String>> events) {
		//Split and check
		var String[] qualifiedChar = character.split("\\.");
		if(qualifiedChar.length != 2) {
			throw new RuntimeException("Message names are not Gamma-compatible!")
		}
		
		//Add to the corresponding collections
		interfaces.add(qualifiedChar.get(0));
		if(!events.containsKey(qualifiedChar.get(0))) {
			events.put(qualifiedChar.get(0), new ArrayList<String>)
		}
		events.get(qualifiedChar.get(0)).add(qualifiedChar.get(1))
		
		//Return the port(/interface)
		return qualifiedChar.get(0);
	}


	static class PortBinding {
		String providingComponent
		String providedPort
		String requiringComponent
		String requiredPort
		
		
		new(String providingComponent, String providedPort, String requiringComponent, String requiredPort) {
			this.providingComponent = providingComponent
			this.providedPort = providedPort
			this.requiringComponent = requiringComponent
			this.requiredPort = requiredPort
		}
		
		def getProvidingComponent() {
			return providingComponent
		}
	
		def getProvidedPort(){
			return this.providedPort
		}
		
		def getRequiringComponent(){
			return this.requiringComponent
		}
		
		def getRequiredPort(){
			return this.requiredPort
		}

	}
	
}