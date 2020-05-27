package hu.bme.mit.automatalearning.adapter

import java.util.ArrayList
import hu.bme.mit.mealymodel.MealyMachine

class HelloXtend {
	
	protected final static extension MealyMachineToGSCAdapter = new MealyMachineToGSCAdapter;
		
	def static void main(String[] args) {
		var mmSystem = new ArrayList<MealyMachine>()
		mmSystem.add(hu.bme.mit.automatalearning.Main.alternatingBitLPTTT())
		var CompositeMealyMachineSystemToGSCAdapter ad = new CompositeMealyMachineSystemToGSCAdapter(mmSystem)
		ad.transformInterfaces
		
		println("Interfaces: ")
		println(ad.getInterfaces);
		println("Gamma Statecharts: ")
		for(comp : ad.getComponents) {
			println(comp);
		}
		
		ad.transformPortBindings
		println("System: ")
		println(ad.getCompositeSystem)
	}
		
}