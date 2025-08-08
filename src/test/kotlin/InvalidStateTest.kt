import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class InvalidStateTest : FunSpec({
    test("nextLetter returns itself") {
        InvalidState.nextLetter("anything") shouldBe InvalidState
    }
})