package integer

import Detector
import InvalidState
import State

class IntegerDetector : Detector {
    override fun isValid(string: String): Boolean {
        var state: State = FirstValueState()
        for (letter in string) {
            when (state) {
                InvalidState -> return false
                else -> state = state.nextLetter(letter.toString())
            }
        }
        return state is ValidState
    }
}