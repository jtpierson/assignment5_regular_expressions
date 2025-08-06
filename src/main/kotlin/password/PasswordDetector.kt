package password

import Detector
import State
import InvalidState
import utils.CharSets.SPECIAL_CHARS

class PasswordDetector : Detector {
    private var state : State = FirstValueState()
    override fun isValid(string: String): Boolean {
        if (string.length < 8 || string.last().toString() in SPECIAL_CHARS) {
            return false
        }

        for (letter in string) {
            when (state) {
                InvalidState -> return false
                else -> state = state.nextLetter(letter.toString())
            }
        }


        return state is ValidState
    }
}