import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
    lateinit var objectOfAnalyzer:Analyzer
    @BeforeAll
    fun setup(){
        objectOfAnalyzer =Analyzer()
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
}
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class AnalyzerTest {
        lateinit var objectOfAnalyzer:Analyzer
        @BeforeAll
        fun setup(){
            objectOfAnalyzer =Analyzer()
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

    }