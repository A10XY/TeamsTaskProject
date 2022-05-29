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
    lateinit var objectOfAnalyzer: Analyzer
    @BeforeAll
    fun setup(){
        objectOfAnalyzer = Analyzer()
    }
    @org.junit.jupiter.api.Test
    fun getOldestApp_sendListCorret_ReturnOldestAppFromList() {
        //given
        val listUtils=Utils().getListFromCsvFile()
        //when
        val checkgetOldestApp=objectOfAnalyzer.getOldestApp(listUtils)
        //then
        assertEquals("Medical Mnemonics",checkgetOldestApp)
    }
    @org.junit.jupiter.api.Test
    fun getOldestApp_sendListNull_ReturnNull() {
        //given
        val listNull= mutableListOf<App>()
        //when
        val checkgetOldestApp=objectOfAnalyzer.getOldestApp(listNull)
        //then
        assertEquals("",checkgetOldestApp)
    }
    @org.junit.jupiter.api.Test
    fun getOldestApp_sendListAppNameNull_ReturnNull() {
        //given
        val app=App("","MissalDaily.com","Libraries & Demo","November 7 2019","11M",500,"8","5.4 and up")
        val listAppNameNull= mutableListOf<App>()
        listAppNameNull.add(app)
        //when
        val checkgetOldestApp=objectOfAnalyzer.getOldestApp(listAppNameNull)
        //then
        assertEquals("",checkgetOldestApp)
    }

        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendCloneOfFileCsv_ReturnResultCorrect() {
            //given
            val cloneOfFileCsv=Utils().getListFromCsvFile()
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(cloneOfFileCsv)
            //then
            assertEquals(3.42,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListNull_ReturnResultZeroo() {
            //given
            val listOfAppNull= mutableListOf<App>()
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppNull)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppDoesNotContainMdicalApp_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","Libraries & Demo","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppDoesNotContainMdical= mutableListOf<App>()
            listOfAppDoesNotContainMdical.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppDoesNotContainMdical)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppContainMdicalOneApp_ReturnResultOneHundred() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","Medical","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppContainMdicalOneAppl= mutableListOf<App>()
            listOfAppContainMdicalOneAppl.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppContainMdicalOneAppl)
            //then
            assertEquals(100.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppTheFirstLetterIsLowercase_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","medical","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppTheFirstLetterIsLowercase= mutableListOf<App>()
            listOfAppTheFirstLetterIsLowercase.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppTheFirstLetterIsLowercase)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainNumbeer_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","1235","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainNumbeer= mutableListOf<App>()
            listOfAppCategoryContainNumbeer.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainNumbeer)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainLogicalOperations_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","+=-)(*/$%<>&&||{}","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainLogicalOperations= mutableListOf<App>()
            listOfAppCategoryContainLogicalOperations.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainLogicalOperations)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainAppName_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","Catholic Teachings Vol I (With Audio - No Ads)","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainAppName= mutableListOf<App>()
            listOfAppCategoryContainAppName.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainAppName)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainCompany_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","MissalDaily.com","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainCompany= mutableListOf<App>()
            listOfAppCategoryContainCompany.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainCompany)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainUpdated_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","November 7 2019","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainUpdated= mutableListOf<App>()
            listOfAppCategoryContainUpdated.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainUpdated)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainSize_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","11M","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainSize= mutableListOf<App>()
            listOfAppCategoryContainSize.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainSize)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainInstalls_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","1000","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainInstalls= mutableListOf<App>()
            listOfAppCategoryContainInstalls.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainInstalls)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainCurrentVersion_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","3","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainCurrentVersion= mutableListOf<App>()
            listOfAppCategoryContainCurrentVersion.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainCurrentVersion)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }
        @org.junit.jupiter.api.Test
        fun medicalAppsPercentage_sendListOfAppCategoryContainRequiresAndroid_ReturnResultZeroo() {
            //given
            val app=App("Catholic Teachings Vol I (With Audio - No Ads)","MissalDaily.com","4.4 and up","November 7 2019","11M",1,"3","4.4 and up")
            val listOfAppCategoryContainRequiresAndroid= mutableListOf<App>()
            listOfAppCategoryContainRequiresAndroid.add(app)
            //when
            val checkMedicalAppsPercentage=objectOfAnalyzer.medicalAppsPercentage(listOfAppCategoryContainRequiresAndroid)
            //then
            assertEquals(0.0,checkMedicalAppsPercentage)
        }

