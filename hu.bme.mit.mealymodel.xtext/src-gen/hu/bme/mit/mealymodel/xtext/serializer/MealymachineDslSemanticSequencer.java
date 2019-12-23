/*
 * generated by Xtext 2.20.0
 */
package hu.bme.mit.mealymodel.xtext.serializer;

import com.google.inject.Inject;
import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelPackage;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
import hu.bme.mit.mealymodel.xtext.services.MealymachineDslGrammarAccess;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MealymachineDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MealymachineDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MealymodelPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MealymodelPackage.ALPHABET:
				sequence_Alphabet(context, (Alphabet) semanticObject); 
				return; 
			case MealymodelPackage.MEALY_MACHINE:
				sequence_MealyMachine(context, (MealyMachine) semanticObject); 
				return; 
			case MealymodelPackage.STATE:
				sequence_State(context, (State) semanticObject); 
				return; 
			case MealymodelPackage.TRANSITION:
				sequence_Transition(context, (Transition) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Alphabet returns Alphabet
	 *
	 * Constraint:
	 *     (characters+=EString characters+=EString*)
	 */
	protected void sequence_Alphabet(ISerializationContext context, Alphabet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MealyMachine returns MealyMachine
	 *
	 * Constraint:
	 *     (
	 *         initialState=State 
	 *         states+=State 
	 *         states+=State* 
	 *         inputAlphabet=Alphabet 
	 *         outputAlphabet=Alphabet 
	 *         transitions+=Transition 
	 *         transitions+=Transition*
	 *     )
	 */
	protected void sequence_MealyMachine(ISerializationContext context, MealyMachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     State returns State
	 *
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_State(ISerializationContext context, State semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MealymodelPackage.Literals.STATE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MealymodelPackage.Literals.STATE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStateAccess().getNameEStringParserRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Transition returns Transition
	 *
	 * Constraint:
	 *     (input=EString output=EString sourceState=[State|EString] targetState=[State|EString])
	 */
	protected void sequence_Transition(ISerializationContext context, Transition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MealymodelPackage.Literals.TRANSITION__INPUT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MealymodelPackage.Literals.TRANSITION__INPUT));
			if (transientValues.isValueTransient(semanticObject, MealymodelPackage.Literals.TRANSITION__OUTPUT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MealymodelPackage.Literals.TRANSITION__OUTPUT));
			if (transientValues.isValueTransient(semanticObject, MealymodelPackage.Literals.TRANSITION__SOURCE_STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MealymodelPackage.Literals.TRANSITION__SOURCE_STATE));
			if (transientValues.isValueTransient(semanticObject, MealymodelPackage.Literals.TRANSITION__TARGET_STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MealymodelPackage.Literals.TRANSITION__TARGET_STATE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTransitionAccess().getInputEStringParserRuleCall_3_0(), semanticObject.getInput());
		feeder.accept(grammarAccess.getTransitionAccess().getOutputEStringParserRuleCall_5_0(), semanticObject.getOutput());
		feeder.accept(grammarAccess.getTransitionAccess().getSourceStateStateEStringParserRuleCall_7_0_1(), semanticObject.eGet(MealymodelPackage.Literals.TRANSITION__SOURCE_STATE, false));
		feeder.accept(grammarAccess.getTransitionAccess().getTargetStateStateEStringParserRuleCall_9_0_1(), semanticObject.eGet(MealymodelPackage.Literals.TRANSITION__TARGET_STATE, false));
		feeder.finish();
	}
	
	
}
