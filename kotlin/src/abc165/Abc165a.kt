import java.util.*

class Abc165a {
    companion object {
        
        @JvmStatic
        fun main() {
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
    }
}
