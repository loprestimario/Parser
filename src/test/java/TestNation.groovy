import groovy.Family
import groovy.Nation
import junit.framework.Assert
import org.junit.Test
/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 26/06/13
 * Time: 1.25
 * To change this template use File | Settings | File Templates.
 */
class TestNation {

    @Test
    public void testNationPlus() throws InterruptedException {

        Family family =new Family()

        String body = new File("src/main/resources/file3.xml").text
        def teiCorpus = new XmlSlurper().parseText(body)
        def listTei = teiCorpus.teiCorpus
         ArrayList arrayList = new ArrayList()
        def count = family.countPublication(listTei, arrayList)
        def countTei = family.countApplication(teiCorpus, arrayList)
        def countClaims = family.countPriorityClaims(listTei, arrayList)
        Nation n = new Nation()
        def nationPlus = n.getNationPlus(arrayList)
        println nationPlus



        Assert.assertEquals(nationPlus,'US');

    }
}
