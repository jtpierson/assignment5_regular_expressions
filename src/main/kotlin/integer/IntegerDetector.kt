package integer

import Detector
import InvalidState
import State

class IntegerDetector : Detector {
    private var state: State = FirstValueState()
    override fun isValid(string: String): Boolean {
        for (letter in string) {
            when (state) {
                is InvalidState -> return false
                else -> state = state.nextLetter(letter.toString())
            }
        }
        return state is ValidState
    }
}