package password

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse

class PasswordDetectorTest : FunSpec({

    val d = PasswordDetector()

    // *** Valid passwords (from spec)
    test("aaaaH!aa") { d.isValid("aaaaH!aa").shouldBeTrue() }
    test("1234567*9J") { d.isValid("1234567*9J").shouldBeTrue() }
    test("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH") {
        d.isValid("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH").shouldBeTrue()
    }

    // *** Additional valid edges
    test("exactly 8 chars, upper + special not at end: A!aaaaaa") {
        d.isValid("A!aaaaaa").shouldBeTrue()
    }
    test("special in middle, ends non-special: 12345A*6") {
        d.isValid("12345A*6").shouldBeTrue()
    }
    test("multiple specials allowed, ends safe") {
        d.isValid("AA!!##${'$'}${'$'}x").shouldBeTrue()
    }

// was: "Aa!@#$%&*x"
    test("covers all allowed specials, ends safe") {
        d.isValid("Aa!@#${'$'}%&*x").shouldBeTrue()
    }
    test("covers all allowed specials present, ends safe: Aa!@#$%&*x") {
        d.isValid("Aa!@#$%&*x").shouldBeTrue()
    }

    // *** Invalid passwords (from spec)
    test("too short: a") { d.isValid("a").shouldBeFalse() }
    test("no capital letter and ends with special: aaaaaaa!") {
        d.isValid("aaaaaaa!").shouldBeFalse()
    }
    test("no special char: aaaHaaaaa") { d.isValid("aaaHaaaaa").shouldBeFalse() }
    test("ends with special: Abbbbbbb!") { d.isValid("Abbbbbbb!").shouldBeFalse() }

    // *** Additional invalid edges
    test("empty string") { d.isValid("").shouldBeFalse() }
    test("exactly 8 but ends with special: Aaaaaaa!") {
        d.isValid("Aaaaaaa!").shouldBeFalse()
    }
    test("exactly 8 but missing uppercase: aaaaa!aa") {
        d.isValid("aaaaa!aa").shouldBeFalse()
    }
    test("missing special: ABCDEFGH") { d.isValid("ABCDEFGH").shouldBeFalse() }
    test("has upper and special but too short: A!a") { d.isValid("A!a").shouldBeFalse() }
})