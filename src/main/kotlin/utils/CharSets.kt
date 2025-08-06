package utils

object CharSets {
    const val NON_ZERO_DIGIT = "123456789"
    const val DIGIT_ZERO_INCLUDED = "1234567890"
    const val BINARY_VALUES = "01"
    const val SPECIAL_CHARS = "(!@#\$%&*)"
    val LOWER_CASE = ('a'..'z').joinToString("")
    val UPPER_CASE = ('A'..'Z').joinToString("")
}
