package abc165

import TestData
import abc165b
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Abc165bKtTest {
    companion object {
        @JvmStatic
        fun generateTestData() = listOf(
            TestData("103", """3
"""),
            TestData("1000000000000000000", """3760
"""),
            TestData("1333333333", """1706
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
        
        abc165b()
        stream.toString() shouldBe data.expected
    }
}
