
import kotlinx.coroutines.*

suspend fun main2() =
    coroutineScope {
        val job = launch {
            for(i in 0..5) {
                delay(500)
                println(i)
            }
        }
        println("Start")
        job.join() // ожидаем завершение корутины
        println("Finished")
    }

suspend fun main3() =
    coroutineScope {
        val job = launch(start = CoroutineStart.LAZY) {
            delay(500)
            println("Coroutine started!")
        }
        delay(1000)
        job.start()
        println("Smth else")
    }

suspend fun main4() =
    coroutineScope {
        async { printMessage() }
        println("Started!")
    }
suspend fun printMessage() {
    delay(1000)
    println("Working!")
}

suspend fun main() =
    coroutineScope {
        val result: Deferred<String> = async { getResult() }
        println("result ${result.await()}")
        println("Finished!")
    }
suspend fun getResult() : String  {
    delay(1000)
    return "Result!"
}