class Abc165aKtTest : BaseTest() {
    override val testData: List<TestData> = listOf(
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
    
    override fun callTestTarget() {
        abc165a()
    }
}