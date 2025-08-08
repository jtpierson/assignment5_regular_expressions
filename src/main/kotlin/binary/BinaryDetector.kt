package binary

import Detector
import InvalidState
import State

class BinaryDetector : Detector {
    override fun isValid(string: String): Boolean {
        var state: State = FirstValueState()
        if (string.lastOrNull().toString() != "1") return false

        for (letter in string) {
            when (state) {
                InvalidState -> return false
                else -> state = state.nextLetter(letter.toString())
            }
        }
        return state is ValidState


    }
}