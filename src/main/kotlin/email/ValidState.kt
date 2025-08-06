package email

import InvalidState
import State
class ValidState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        " " -> InvalidState
        "@" -> InvalidState
        "." -> InvalidState
        else -> this
    }
}