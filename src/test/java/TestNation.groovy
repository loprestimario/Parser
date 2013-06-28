import patent.*;
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
         def nationsMap = new HashMap<String,Integer>()
        def count = family.countPublication(listTei, nationsMap)
        def countTei = family.countApplication(teiCorpus, nationsMap)
        def countClaims = family.countPriorityClaims(listTei, nationsMap)
        Nation n = new Nation()
        n.getNationPlus(nationsMap)
        def nationPlus = n.getNationPlus(nationsMap)
        //println nationPlus

        Assert.assertEquals(nationPlus,'US');

    }
}
