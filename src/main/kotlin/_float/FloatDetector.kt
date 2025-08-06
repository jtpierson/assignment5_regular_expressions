package _float

import Detector
import InvalidState
import State

class FloatDetector : Detector {
    private var state : State = FirstValueState()

    override fun isValid(string: String): Boolean {
        for (letter in string) {
            when(state) {
                InvalidState -> return false
                else -> state = state.nextLetter(letter.toString())
            }
        }
        return state is ValidState
    }
}