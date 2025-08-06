package _float
import InvalidState
import utils.CharSets.DIGIT_ZERO_INCLUDED
import State
class HasDigitState : State {
    override fun nextLetter(letter: String): State = when (letter) {
        in DIGIT_ZERO_INCLUDED -> this
        "." -> HasDotState()
        else -> InvalidState
    }
}