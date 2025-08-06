package integer
import InvalidState
import State
import utils.CharSets.NON_ZERO_DIGIT

class FirstValueState : State {
    override fun nextLetter(letter: String): State = when(letter){
        in NON_ZERO_DIGIT -> ValidState()
        else -> InvalidState
    }
}