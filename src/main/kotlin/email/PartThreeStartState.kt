package email
import State
import InvalidState

// ensures we get at least one char for part 3
class PartThreeStartState : State {
    override fun nextLetter(letter: String): State = when (letter) {
        " " -> InvalidState
        "@" -> InvalidState
        "." -> InvalidState
        else -> ValidState()
    }
}
