class Analyzer {

    fun getLargest10App(list: List<App>):List<String>{
        val newMap = mutableMapOf<String,Double>()

        list.forEach {
            if (it.size.contains('G')){
                newMap[it.appName] = it.size.substringBefore('G').toDouble() * 1024
            }else if (it.size.contains('M')){
                newMap[it.appName] = it.size.substringBefore('M').toDouble()
            }
        }
        var counter = 0
        val result = mutableListOf<String>()
        val map = newMap.toList().sortedByDescending { (_, value) -> value}.toMap()
        run breaking@ {
            map.forEach {
                result.add(it.key)
                counter++
                if (counter == 10) return@breaking
            }
        }
        return result
    }
}