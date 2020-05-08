package abc165

import BaseTest
import TestData
import abc165b

class Abc165bKtTest : BaseTest() {
    override val testData = listOf(
        TestData("103", """3
"""),
        TestData("1000000000000000000", """3760
"""),
        TestData("1333333333", """1706
""")
    )
    
    override fun callTestTarget() {
        abc165b()
    }
}
