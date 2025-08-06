package email

import InvalidState
import State

class FirstValueState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        " " -> InvalidState
        "@" -> InvalidState
        else -> PartOneState()
    }
}