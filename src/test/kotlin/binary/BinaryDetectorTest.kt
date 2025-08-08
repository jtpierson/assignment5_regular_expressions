package binary

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse

class BinaryDetectorTest : FunSpec({

    val d = BinaryDetector()

    // *** Valid binaries (from spec)
    test("1") { d.isValid("1").shouldBeTrue() }
    test("11") { d.isValid("11").shouldBeTrue() }
    test("101") { d.isValid("101").shouldBeTrue() }
    test("111111") { d.isValid("111111").shouldBeTrue() }
    test("10011010001") { d.isValid("10011010001").shouldBeTrue() }

    // *** Invalid binaries (from spec)
    test("doesn't start with 1: 01") { d.isValid("01").shouldBeFalse() }
    test("doesn't end with 1: 10") { d.isValid("10").shouldBeFalse() }
    test("doesn't end with 1: 1000010") { d.isValid("1000010").shouldBeFalse() }
    test("contains invalid char: 100a01") { d.isValid("100a01").shouldBeFalse() }

    // *** Additional invalid edge cases
    test("empty string") { d.isValid("").shouldBeFalse() }
    test("single 0") { d.isValid("0").shouldBeFalse() } // bad first char
    test("contains 2") { d.isValid("11211").shouldBeFalse() } // invalid char in middle
    test("space inside") { d.isValid("1 1").shouldBeFalse() }
    test("period inside") { d.isValid("1.1").shouldBeFalse() }

    // *** Branch coverage nudges
    test("invalid first char letter: a1") { d.isValid("a1").shouldBeFalse() }  // FirstValueState -> else
    test("valid prefix then invalid char: 11b1") { d.isValid("11b1").shouldBeFalse() } // InBinary -> else
    test("valid prefix then trailing 0: 1110") { d.isValid("1110").shouldBeFalse() } // ends with 0
})