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
    fun should_Return10LargestApps_When_appsListIsFromCsvFileInResources() {
        // Given
        val appsList = Utils().getListFromCsvFile()
        // When
        val result = analyzer.getLargest10App(appsList).toTypedArray()
        // Then
        val largestAppsArray = mutableListOf(
            "MARVEL Future Revolution",
            "Bloodstained: Ritual of the Night",
            "Marvel Contest of Champions",
            "Titan Quest",
            "Human: Fall Flat",
            "El Hijo - A Wild West Tale",
            "Demon Hunter: Shadow World",
            "NEW STATE Mobile",
            "Sky: Children of the Light",
            "Summoners War"
        ).toTypedArray()
        assertArrayEquals(largestAppsArray, result)
    }

    @Test
    fun should_ReturnEmptyList_When_appsListIsEmpty() {
        // Given
        val appsList = listOf<App>()
        // When
        val result = analyzer.getLargest10App(appsList).toTypedArray()
        // Then
        val largestAppsArray = mutableListOf<App>().toTypedArray()
        assertArrayEquals(largestAppsArray, result)
    }

    @Test
    fun should_ReturnEmptyList_When_appsListElementsAreLessThan10() {
        // Given
        val appsList = listOf<App>(
            App("A",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "10M", 10,
                "1.0.0",
                "10.0 and up"),
            App("B",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "9M", 10,
                "1.0.0",
                "10.0 and up"),
            App("C",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "8M", 10,
                "1.0.0",
                "10.0 and up"),
            App("D",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "7M", 10,
                "1.0.0",
                "10.0 and up"),
            App("E",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "6M", 10,
                "1.0.0",
                "10.0 and up"),
            App("F",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "5M", 10,
                "1.0.0",
                "10.0 and up"),
            App("G",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "4M", 10,
                "1.0.0",
                "10.0 and up"),
            App("H",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "3M", 10,
                "1.0.0",
                "10.0 and up"),
            App("I",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "2M", 10,
                "1.0.0",
                "10.0 and up"),
//            App("J",
//                "Fried Chicken Clan, Inc",
//                "Entertainment",
//                "May 25 2022",
//                "1M", 10,
//                "1.0.0",
//                "10.0 and up"),
        )
        // When
        val result = analyzer.getLargest10App(appsList).toTypedArray().size
        // Then
//        val largestAppsArray = mutableListOf<App>().toTypedArray().size
        assertEquals(9, result)
    }

    @Test
    fun should_ReturnAListWithSizeOf10_When_appsListElementsAreEqualTo10() {
        // Given
        val appsList = listOf<App>(
            App("A",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "10M", 10,
                "1.0.0",
                "10.0 and up"),
            App("B",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "9M", 10,
                "1.0.0",
                "10.0 and up"),
            App("C",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "8M", 10,
                "1.0.0",
                "10.0 and up"),
            App("D",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "7M", 10,
                "1.0.0",
                "10.0 and up"),
            App("E",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "6M", 10,
                "1.0.0",
                "10.0 and up"),
            App("F",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "5M", 10,
                "1.0.0",
                "10.0 and up"),
            App("G",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "4M", 10,
                "1.0.0",
                "10.0 and up"),
            App("H",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "3M", 10,
                "1.0.0",
                "10.0 and up"),
            App("I",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "2M", 10,
                "1.0.0",
                "10.0 and up"),
            App("J",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "1M", 10,
                "1.0.0",
                "10.0 and up"),
        )
        // When
        val result = analyzer.getLargest10App(appsList).toTypedArray().size
        // Then
        assertEquals(10, result)
    }

    @Test
    fun should_ReturnAListWithSizeOf10_When_appsListElementsAreMoreThan10() {
        // Given
        val appsList = listOf<App>(
            App("A",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "10M", 10,
                "1.0.0",
                "10.0 and up"),
            App("B",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "9M", 10,
                "1.0.0",
                "10.0 and up"),
            App("C",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "8M", 10,
                "1.0.0",
                "10.0 and up"),
            App("D",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "7M", 10,
                "1.0.0",
                "10.0 and up"),
            App("E",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "6M", 10,
                "1.0.0",
                "10.0 and up"),
            App("F",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "5M", 10,
                "1.0.0",
                "10.0 and up"),
            App("G",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "4M", 10,
                "1.0.0",
                "10.0 and up"),
            App("H",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "3M", 10,
                "1.0.0",
                "10.0 and up"),
            App("I",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "2M", 10,
                "1.0.0",
                "10.0 and up"),
            App("J",
                "Fried Chicken Clan, Inc",
                "Entertainment",
                "May 25 2022",
                "1M", 10,
                "1.0.0",
                "10.0 and up"),
        )
        // When
        val result = analyzer.getLargest10App(appsList).toTypedArray().size
        // Then
        assertEquals(10, result)
    }

}