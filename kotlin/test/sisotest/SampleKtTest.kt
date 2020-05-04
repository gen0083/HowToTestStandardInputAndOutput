package sisotest

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SampleKtTest {
    @ParameterizedTest
    @MethodSource("testDataSource")
    fun `テストケース1`(data: TestData) {
        System.setIn(ByteArrayInputStream(data.input.toByteArray()))
        val stream = ByteArrayOutputStream()
        val testOut = PrintStream(stream)
        System.setOut(testOut)
        
        main()
        stream.toString() shouldBe data.expected
    }
    
    data class TestData(val input: String, val expected: String)
    
    companion object {
        @JvmStatic
        fun testDataSource() = listOf(
            TestData("abc", "abb"),
            TestData("""azd
            |hoge
            |jjj
            |abc
        """.trimMargin(), """aaa
            |aaa
        """.trimMargin())
        ).stream()
    }
}