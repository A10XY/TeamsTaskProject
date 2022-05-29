import java.text.SimpleDateFormat

class Analyzer {
    fun medicalAppsPercentage(list:List<App>): Double {
        if (list.isEmpty())return 0.0
        var counter=0.0
        list.forEach {
            if (it.category=="Medical" )counter++
        }
        return String.format("%.2f",counter/list.size*100).toDouble()
    }

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