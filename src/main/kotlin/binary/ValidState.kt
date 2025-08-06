package binary
import InvalidState
import State
import utils.CharSets.BINARY_VALUES

class ValidState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        in BINARY_VALUES -> this
        else -> InvalidState
    }
}