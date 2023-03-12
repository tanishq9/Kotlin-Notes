import kotlinx.coroutines.*

suspend fun main() {
/*    val number = 5

    Thread {
        Thread.sleep(5000)
        println("Thread Finished")
    }.start()

    println(number)*/

    println(coroutinesDemo())

    // CoroutineScope(//default thread).coroutineContext.cancelChildren() -> best way to cancel all coroutines launched instances of a CoroutineScope
}

suspend fun coroutinesDemo(): Job {
    // Job is the output of a coroutine function
    return coroutineScope {
        launch {
            val number = 5
            threadCounter()
            threadCounter()
            println(number)
        }
    }
}

/*suspend fun coroutinesDemo2() = coroutineScope {
    launch {
        val number = 5
        threadCounter()
        threadCounter()
        println(number)
    }
}*/

suspend fun threadCounter() {
    withContext(Dispatchers.Default) {
        val time = System.currentTimeMillis()
        val endTime = time + 5000
        var iteration = 0
        while (System.currentTimeMillis() < endTime) {
            iteration++
        }
        println("Basic - Thread Finished in 5 seconds")
        anotherThreadCounter()
    }
}

suspend fun anotherThreadCounter() {
    withContext(Dispatchers.Default) {
        val time = System.currentTimeMillis()
        val endTime = time + 10000
        var iteration = 0
        while (System.currentTimeMillis() < endTime) {
            iteration++
        }
        println("Another - Thread Finished in 10 seconds")
    }
}