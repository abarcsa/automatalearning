package hu.bme.mit.automatalearning.adapter

import hu.bme.mit.mealymodel.MealyMachine

class MealyMachineToGSCAdapter {
	String INTERFACE_PACKAGE_NAME = "MealyMachineInterfaces"
	String INPUT_INTERFACE_NAME = "InputInterface"
	String OUTPUT_INTERFACE_NAME = "OutputInterface"
	String STATECHART_PACKAGE_NAME = "MealyMachine"
	String STATECHART_NAME = "MealyMachineStatechart"
	String INPUT_PORT_NAME = "Input"
	String OUTPUT_PORT_NAME = "Output"
	
	def String getInterfaces(MealyMachine mealyMachine) {
		return '''
		package «INTERFACE_PACKAGE_NAME»
		
		interface «INPUT_INTERFACE_NAME» {
			«FOR input : mealyMachine.inputAlphabet.characters»
			out event «input»
			«ENDFOR»
		}
		
		interface «OUTPUT_INTERFACE_NAME» {
			«FOR output : mealyMachine.outputAlphabet.characters»
			out event «output»
			«ENDFOR»
		}
			
		'''
	}
	
	def String getStatechart(MealyMachine mealyMachine) {
		return '''
		package «STATECHART_PACKAGE_NAME»
		
		import "«INTERFACE_PACKAGE_NAME»"
		
		statechart «STATECHART_NAME» [
			port «INPUT_PORT_NAME» : requires «INPUT_INTERFACE_NAME»
			port «OUTPUT_PORT_NAME» : provides «OUTPUT_INTERFACE_NAME»
		] {
			
			transition from _initialState to «mealyMachine.initialState.name»
			«FOR transition : mealyMachine.transitions»
			transition from «transition.sourceState.name» to «transition.targetState.name» when «INPUT_PORT_NAME».«transition.input» / «OUTPUT_PORT_NAME».«transition.output»
			«ENDFOR»
			
			region mainRegion {
				initial _initialState
				«FOR state : mealyMachine.states»
				state «state.name»
				«ENDFOR»
			}
		}
		'''
	}
	
}