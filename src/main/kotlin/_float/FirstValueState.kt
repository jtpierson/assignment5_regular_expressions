package _float
import InvalidState
import utils.CharSets.NON_ZERO_DIGIT
import State
class FirstValueState : State {
    override fun nextLetter(letter: String): State = when (letter) {
        in NON_ZERO_DIGIT -> HasDigitState()
        "0" -> ZeroFirstDigitState()
        "." -> HasDotState()
        else -> InvalidState
    }
}