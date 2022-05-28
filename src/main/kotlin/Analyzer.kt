import java.text.SimpleDateFormat

class Analyzer {

    fun getOldestApp(list: List<App>): String {
        val newMap = mutableMapOf<String,Long>()

        list.forEach {
            val text = it.updated
            val formatter = SimpleDateFormat("MMMM dd yyyy")
            val date = formatter.parse(text).time
            newMap[it.appName] = date
        }
        val map = newMap.toList().sortedBy { (_, value) -> value}.toMap()
        return map.keys.toList()[0]
    }
}