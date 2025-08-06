package password
import InvalidState
import State
import utils.CharSets.UPPER_CASE
import utils.CharSets.SPECIAL_CHARS
import utils.CharSets.LOWER_CASE
import utils.CharSets.DIGIT_ZERO_INCLUDED

class HasSpecialState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        SPECIAL_CHARS -> this
        LOWER_CASE -> this
        DIGIT_ZERO_INCLUDED -> this
        UPPER_CASE -> ValidState()
        else -> InvalidState
    }
}