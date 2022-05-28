fun main() {
    val oldestApp = Analyzer().getOldestApp(Utils().getListFromCsvFile())
    print("Oldest app from list is $oldestApp")
}