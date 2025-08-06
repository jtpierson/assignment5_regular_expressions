package password
import InvalidState
import State
import utils.CharSets.UPPER_CASE
import utils.CharSets.SPECIAL_CHARS
import utils.CharSets.LOWER_CASE
import utils.CharSets.DIGIT_ZERO_INCLUDED

class HasCapitalState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        UPPER_CASE -> this
        LOWER_CASE -> this
        DIGIT_ZERO_INCLUDED -> this
        SPECIAL_CHARS -> ValidState()
        else -> InvalidState
    }
}