package hu.bme.mit.automatalearning.adapter

class HelloXtend {
	
	protected final static extension MealyMachineToGSCAdapter = new MealyMachineToGSCAdapter;
		
	def static void main(String[] args) {
		println("Interfaces: ")
		println(hu.bme.mit.automatalearning.Main.alternatingbitDHC().getInterfaces);
		println("Gamma Statechart: ")
		println(hu.bme.mit.automatalearning.Main.alternatingbitDHC().getStatechart);
	}
		
}