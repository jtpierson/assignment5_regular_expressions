package _float
import InvalidState
import State
class ZeroFirstDigitState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        "." -> HasDotState()
        else -> InvalidState
    }
}