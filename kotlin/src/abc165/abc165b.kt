import kotlin.math.floor

fun main() {
    abc165b()
}

fun abc165b() {
    val x = readLine()!!.toLong()
    var n = 0
    var current = 100L
    while (current < x) {
        val r = floor(current * 0.01).toLong()
        current += r
        n++
    }
    println(n)
}