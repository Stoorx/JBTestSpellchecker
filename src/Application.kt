import java.io.File
import kotlin.system.exitProcess

fun main(args: Array<String>): Unit =
    (if (args.size != 1) exitProcess(1)
    else File(args.first()).let {
        if (it.exists()) it
        else null
    } ?: exitProcess(0))
        .readLines().also { println("${it.size} words found") }.toSet().let { work(it) }

tailrec fun work(dictionary: Set<String>): Unit =
    if (print("> ").let {
            readLine()?.let {
                if (dictionary.contains(it)) println("\'$it\' is correct word")
                else dictionary.map { eWord ->
                    Pair(
                        eWord,
                        DamerauLevensteinDistance.getDistance(it, eWord)
                    )
                }.sortedBy { pair -> pair.second }.let { candidates ->
                    candidates.takeWhile { pair ->
                        pair.second == candidates.first().second
                    }
                }.also { println("Did you mean one of these words? Distance: ${it.first().second}") }.forEach { word ->
                    print("${word.first} ")
                }.also { println() }
            }
        } != null) work(dictionary) else Unit