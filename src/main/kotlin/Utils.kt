import java.io.File

class Utils {
    /**
     * This Function parses CSV into Mutable List of App
     * @return a Mutable List of App
     */
    fun getListFromCsvFile(): MutableList<App> {
        val file = File(javaClass.getResource("google_play.csv")!!.path)
        val appsList = mutableListOf<App>()
        file.forEachLine {
            if(!it.startsWith("App_Name")){
                val lineList = it.split(',')
                val app = App(
                    appName = lineList[0],
                    company = lineList[1],
                    category = lineList[2],
                    updated = lineList[3],
                    size = lineList[4],
                    installs = lineList[5].toLong(),
                    currentVersion = lineList[6],
                    requiresAndroid = lineList[7]
                )
                appsList.add(app)
            }
        }
        return appsList
    }
}