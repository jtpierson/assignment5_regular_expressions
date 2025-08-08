package password
import InvalidState
import State
import utils.CharSets.UPPER_CASE
import utils.CharSets.SPECIAL_CHARS
import utils.CharSets.LOWER_CASE
import utils.CharSets.DIGIT_ZERO_INCLUDED

class FirstValueState : State {
    override fun nextLetter(letter: String): State = when(letter) {
        in SPECIAL_CHARS -> HasSpecialState()
        in UPPER_CASE -> HasCapitalState()
        else -> this
    }
}