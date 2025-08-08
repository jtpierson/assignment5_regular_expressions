package email

import State
import InvalidState

class PartTwoState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        "." -> PartThreeStartState()
        "@" -> InvalidState
        " " -> InvalidState
        else -> this
    }

}