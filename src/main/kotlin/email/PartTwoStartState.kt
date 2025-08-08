package email
import State
import InvalidState

// ensures that we have at least one char in the part
class PartTwoStartState : State {
    override fun nextLetter(letter: String): State = when (letter) {
        " " -> InvalidState
        "@" -> InvalidState
        "." -> InvalidState
        else -> PartTwoState()
    }

}