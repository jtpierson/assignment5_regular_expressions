package email
import InvalidState
import State

class PartOneState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        " " -> InvalidState
        "@" -> PartTwoState()
        else -> this
    }
}