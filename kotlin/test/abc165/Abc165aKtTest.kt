import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Abc165aKtTest {
    companion object {
        @JvmStatic
        fun generateTestData() = listOf(
            TestData("""7
500 600""", """OK
"""),
            TestData("""4
5 7""", """NG
"""),
            TestData("""1
11 11""", """OK
""")
        )
    }
    
    @ParameterizedTest
    @MethodSource("generateTestData")
    fun `test`(data: TestData) {
        System.setIn(ByteArrayInputStream(data.input.toByteArray()))
        val stream = ByteArrayOutputStream()
        val testOut = PrintStream(stream)
        System.setOut(testOut)
        
        Abc165a.main()
        stream.toString() shouldBe data.expected
    }
}