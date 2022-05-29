import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    private lateinit var analyzer: Analyzer

    @BeforeAll
    fun setUp() {
        analyzer = Analyzer()
    }

    @Test
    fun should_Return72_When_appsListIsFromCsvFileInResources() {
        // Given
        val list = Utils().getListFromCsvFile()
        // When
        val result = analyzer.getGoogleAppsCount(list)
        // Then
        assertEquals(72, result)
    }

    @Test
    fun should_Return0_When_appsListIsEmpty() {
        // Given
        val list = listOf<App>()
        // When
        val result = analyzer.getGoogleAppsCount(list)
        // Then
        assertEquals(0, result)
    }

    @Test
    fun should_Return0_When_noAppByGoogleFoundInAppsList() {
        // Given
        val list = listOf<App>(
            App("TeamsTask",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "10M", 10,
                "1.0.0",
                "10.0 and up")
        )
        // When
        val result = analyzer.getGoogleAppsCount(list)
        // Then
        assertEquals(0, result)
    }
}