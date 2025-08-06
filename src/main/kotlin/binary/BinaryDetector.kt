package binary

import Detector
import InvalidState
import State

class BinaryDetector : Detector {
    private var state: State = FirstValueState()
    override fun isValid(string: String): Boolean {
        for (letter in string) {
            when (state) {
                InvalidState -> return false
                else -> state = state.nextLetter(letter.toString())
            }
        }
        if (string.last().toString() != "1") {
            return state is ValidState
        }
        return false


    }
}