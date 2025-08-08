package integer

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldBeFalse

class IntegerDetectorTest : FunSpec({

    val detector = IntegerDetector()

    // *** Valid integers
    test("1") {
        detector.isValid("1").shouldBeTrue()
    }

    test("123") {
        detector.isValid("123").shouldBeTrue()
    }

    test("3452342352434534524346") {
        detector.isValid("3452342352434534524346").shouldBeTrue()
    }

    // *** Invalid integers
    test("empty string") {
        detector.isValid("").shouldBeFalse()
    }

    test("starts with 0") {
        detector.isValid("0").shouldBeFalse()
    }

    test("starts with 0 followed by digits") {
        detector.isValid("0123").shouldBeFalse()
    }

    test("contains non-digit") {
        detector.isValid("132a").shouldBeFalse()
    }
})