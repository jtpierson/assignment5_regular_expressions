package password

import Detector
import State
import InvalidState
import utils.CharSets.SPECIAL_CHARS

class PasswordDetector : Detector {
    override fun isValid(string: String): Boolean {
        var state : State = FirstValueState()
        if (string.length < 8 || string.last().toString() in SPECIAL_CHARS) {
            return false
        }

        for (letter in string) {
            state = state.nextLetter(letter.toString())
        }


        return state is ValidState
    }
}