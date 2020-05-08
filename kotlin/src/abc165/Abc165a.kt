import java.util.*

fun main() {
    abc165a()
}

fun abc165a() {
    Scanner(System.`in`).use { sc ->
        val k = sc.nextInt()
        val a = sc.nextInt()
        val b = sc.nextInt()
        for (i in a..b) {
            if (i % k == 0) {
                println("OK")
                return
            }
        }
        println("NG")
    }
}
