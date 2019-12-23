# automatalearning
An automaton learning framework capable of handling arbitrary formalisms in a modular, easily extensible and integrable way. Currently, there are two active automaton learning algorithms implemented in the framework, the Direct Hypothesis Construction and the TTT algorithms, both capable of infering a system (component) using behavioral information.

The implementation relies on EMF and Xtext to in- and ouput the system under learning, and the final, learned hypothesis using different formalisms.

A practical example of setting up an algorithm can be seen below.

```
//Read input through Xtext and EMF
MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/coffeemachine.mealy");
		
Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());

//Create Teacher by wrapping the input in a Learnable (MealyLearnable).
Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
     new Teacher<>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
     
//Construct a learning algorithm using the teacher, the input alphabet provided, and a new, empty hypothesis
DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = new     DirectHypothesisConstructionMealy<>(teacher, m.getInputAlphabet().getCharacters(), new DHCHypothesisMealy(inputAlphabet));

//Run the learning
DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();

//Write output through Xtext and EMF
MealyModelReader.output(h.getHypothesis());

```

For more examples, please see [Main.java](src/hu/bme/mit/automatalearning/Main.java).
