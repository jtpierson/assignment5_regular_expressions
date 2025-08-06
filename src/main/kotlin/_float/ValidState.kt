package _float
import InvalidState
import State
import utils.CharSets.DIGIT_ZERO_INCLUDED

class ValidState : State{
    override fun nextLetter(letter: String): State = when(letter) {
        in DIGIT_ZERO_INCLUDED -> this
        else -> InvalidState
    }
}