fun main() {
    val oldestApp = Analyzer().getOldestApp(Utils().getListFromCsvFile())
    print("Oldest app from list is $oldestApp")
    val objectOfAnalyzer = Analyzer()
    val cloneOfFileCsv = Utils().getListFromCsvFile()
    println(objectOfAnalyzer.medicalAppsPercentage(cloneOfFileCsv))
}