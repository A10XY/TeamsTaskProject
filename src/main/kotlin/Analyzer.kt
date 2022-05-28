class Analyzer {

    fun getGoogleAppsCount(list: List<App>) = list.filter { it.company.contains("Google") }.size
}