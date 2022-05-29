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