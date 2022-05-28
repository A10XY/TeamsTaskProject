class Analyzer {
    fun getTop10App(list: List<App>):List<String>{
        var counter = 0
        val topTen = mutableListOf<String>()

        run breaking@ {
            list.sortedByDescending { it.installs }.forEach {
                topTen.add(it.appName)
                counter++
                if (counter == 10) return@breaking
            }
        }
        return topTen
    }
}