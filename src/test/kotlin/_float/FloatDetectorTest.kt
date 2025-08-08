package _float

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse

class FloatDetectorTest : FunSpec({

    val d = FloatDetector()

    // *** Valid floats (from spec)
    test("1.0") { d.isValid("1.0").shouldBeTrue() }
    test("123.34") { d.isValid("123.34").shouldBeTrue() }
    test("0.20000") { d.isValid("0.20000").shouldBeTrue() }
    test("12349871234.12340981234098") { d.isValid("12349871234.12340981234098").shouldBeTrue() }
    test(".123") { d.isValid(".123").shouldBeTrue() }

    // *** Additional valid edge cases
    test("0.0") { d.isValid("0.0").shouldBeTrue() }
    test(".0") { d.isValid(".0").shouldBeTrue() }
    test("9.9") { d.isValid("9.9").shouldBeTrue() }

    // *** Invalid floats (from spec)
    test("no period: 123") { d.isValid("123").shouldBeFalse() }
    test("too many periods: 123.123.") { d.isValid("123.123.").shouldBeFalse() }
    test("invalid char: 123.02a") { d.isValid("123.02a").shouldBeFalse() }
    test("nothing follows period: 123.") { d.isValid("123.").shouldBeFalse() }
    test("leading 0 not followed by period: 012.4") { d.isValid("012.4").shouldBeFalse() }

    // *** Additional invalid edge cases
    test("empty string") { d.isValid("").shouldBeFalse() }
    test("single period") { d.isValid(".").shouldBeFalse() }
    test("starts with 0 and ends right away: 0") { d.isValid("0").shouldBeFalse() } // no dot
    test("dot then non-digit: .a") { d.isValid(".a").shouldBeFalse() }
    test("spaces not allowed") { d.isValid("1.0 ").shouldBeFalse() }

    // *** Invalid while in HasDigitState (pre-dot)
    test("digit then invalid char before dot: 1a") {
        d.isValid("1a").shouldBeFalse()
    }

    test("digit then space before dot: '1 '") {
        d.isValid("1 ").shouldBeFalse()
    }

    // *** Invalid in FirstValueState (immediate else branch)
    test("starts with invalid char: a123") {
        d.isValid("a123").shouldBeFalse()
    }
})