import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {
    
    abstract val testData: List<TestData>
    
    abstract fun callTestTarget()
    
    private fun generateTestData() = testData
    
    @ParameterizedTest
    @MethodSource("generateTestData")
    fun `テストケース`(data: TestData) {
        ByteArrayInputStream(data.input.toByteArray()).use { input ->
            ByteArrayOutputStream().use { out ->
                System.setIn(input)
                System.setOut(PrintStream(out))
                
                callTestTarget()
                out.toString() shouldBe data.expected
            }
        }
    }
}