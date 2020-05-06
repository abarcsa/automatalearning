package hu.bme.mit.automatalearning.adapter

import hu.bme.mit.mealymodel.MealyMachine

class MealyMachineToGSCAdapter {
	/* TODO: extract the following symbols into variables:
	 * 	interface package name
	 * 	input interface name
	 * 	output interface name
	 * 	statechart package name
	 *  statechart name
	 * 	statechart input port name
	 * 	statechart output port name
	 *  statechart initial state name (?)
	 *  (region name?)
	 */
	
	def String getInterfaces(MealyMachine mealyMachine) {
		return '''
		package MealyMachineInterfaces
		
		interface InputInterface {
			«FOR input : mealyMachine.inputAlphabet.characters»
			out event «input»
			«ENDFOR»
		}
		
		interface OutputInterface {
			«FOR output : mealyMachine.outputAlphabet.characters»
			out event «output»
			«ENDFOR»
		}
			
		'''
	}
	
	def String getStatechart(MealyMachine mealyMachine) {
		return '''
		package MealyMachine
		
		import "MealyMachineInterfaces"
		
		statechart MealyMachineStatechart [
			port Input : requires InputInteface
			port Output : provides OutputInterface
		] {
			
			transition from _initialState to «mealyMachine.initialState.name»
			«FOR transition : mealyMachine.transitions»
			transition from «transition.sourceState.name» to «transition.targetState.name» when Input.«transition.input» / Output.«transition.output»
			«ENDFOR»
			
			region mainRegion {
				initial _initialState
				state «mealyMachine.initialState.name»
				«FOR state : mealyMachine.states»
				state «state.name»
				«ENDFOR»
			}
		}
		'''
	}
	
}