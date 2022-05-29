fun main() {
    val objectOfAnalyzer=Analyzer()
    val cloneOfFileCsv=Utils().getListFromCsvFile()
    println(objectOfAnalyzer.medicalAppsPercentage(cloneOfFileCsv))
}