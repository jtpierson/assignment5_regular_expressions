package email

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse

class EmailDetectorTest : FunSpec({

    val d = EmailDetector()

    // *** Valid emails (from spec)
    test("a@b.c") { d.isValid("a@b.c").shouldBeTrue() }
    test("joseph.ditton@usu.edu") { d.isValid("joseph.ditton@usu.edu").shouldBeTrue() }
    test("{}*$.&$*(@*$%&.*&*") { d.isValid("{}*$.&$*(@*$%&.*&*").shouldBeTrue() }

    // *** Additional valid edges (allowed chars before @, exactly one dot after @)
    test("a.b.c@d.e") { d.isValid("a.b.c@d.e").shouldBeTrue() }
    test("abc123@d1.234") { d.isValid("abc123@d1.234").shouldBeTrue() }

    // *** Invalid (from spec)
    test("part1 empty: @b.c") { d.isValid("@b.c").shouldBeFalse() }
    test("too many @: a@b@c.com") { d.isValid("a@b@c.com").shouldBeFalse() }
    test("too many periods after @: a.b@b.b.c") { d.isValid("a.b@b.b.c").shouldBeFalse() }
    test("space not allowed: 'joseph ditton@usu.edu'") { d.isValid("joseph ditton@usu.edu").shouldBeFalse() }

    // *** Additional invalid edges (rule coverage)
    test("no @ at all: abc") { d.isValid("abc").shouldBeFalse() }
    test("no dot after @: a@bc") { d.isValid("a@bc").shouldBeFalse() }
    test("empty part2: a@.c") { d.isValid("a@.c").shouldBeFalse() }
    test("empty part3: a@b.") { d.isValid("a@b.").shouldBeFalse() }
    test("two dots after @: a@b..c") { d.isValid("a@b..c").shouldBeFalse() }
    test("starts with space: ' a@b.c'") { d.isValid(" a@b.c").shouldBeFalse() }
    test("ends with space: 'a@b.c '") { d.isValid("a@b.c ").shouldBeFalse() }
    test("double @ adjacent: a@@b.c") { d.isValid("a@@b.c").shouldBeFalse() }
    test("extra dot after @: a@b.c.d") { d.isValid("a@b.c.d").shouldBeFalse() }

    // *** Empty string
    test("empty string") { d.isValid("").shouldBeFalse() }

    // *** Branch coverage: PartTwoStartState (" " -> InvalidState)
    test("space immediately after @: a@ b.c") {
        EmailDetector().isValid("a@ b.c").shouldBeFalse()
    }

    // *** Branch coverage: PartTwoState (" " -> InvalidState)
    test("space inside part2 before dot: a@b .c") {
        EmailDetector().isValid("a@b .c").shouldBeFalse()
    }

    // *** Branch coverage: PartThreeStartState (" " -> InvalidState)
    test("space immediately after dot: a@b. c") {
        EmailDetector().isValid("a@b. c").shouldBeFalse()
    }

    // *** Branch coverage: PartThreeStartState ("@" -> InvalidState)
    test("at-sign immediately after dot: a@b.@") {
        EmailDetector().isValid("a@b.@").shouldBeFalse()
    }

    // *** Branch coverage: PartThreeState/ValidState ("@" -> InvalidState)
    test("at-sign in part3 after at least one char: a@b.c@") {
        EmailDetector().isValid("a@b.c@").shouldBeFalse()
    }
})