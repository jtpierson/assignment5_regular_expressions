package binary
import InvalidState
import State

class FirstValueState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        "1" -> ValidState()
        else -> InvalidState
    }
}