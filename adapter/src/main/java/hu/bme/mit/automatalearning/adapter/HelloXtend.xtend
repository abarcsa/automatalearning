package hu.bme.mit.automatalearning.adapter

class HelloXtend {
	
	protected final static extension MealyMachineToGSCAdapter = new MealyMachineToGSCAdapter;
		
	def static void main(String[] args) {
		println("Interfaces: ")
		println(hu.bme.mit.automatalearning.Main.alternatingbit().getInterfaces);
		println("Gamma Statechart: ")
		println(hu.bme.mit.automatalearning.Main.alternatingbit().getStatechart);
	}
		
}