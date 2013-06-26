import groovy.Family
import junit.framework.Assert
import org.junit.Test
/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 26/06/13
 * Time: 0.31
 * To change this template use File | Settings | File Templates.
 */
class TestFamily {

    @Test
    public void testCountPublication() throws InterruptedException {

        String body = new File("src/main/resources/file3.xml").text
        def teiCorpus = new XmlSlurper().parseText(body)
        Family family =new Family()
        def nationsMap = new HashMap<String,Integer>()

        def listTei = teiCorpus.teiCorpus
        def count = family.countPublication(listTei, nationsMap)
        def count1 = family.countApplication(listTei, nationsMap)

        Assert.assertEquals(count, 2);

    }

    @Test
    public void testCountApplication() throws InterruptedException {

        String body = new File("src/main/resources/file3.xml").text
        def teiCorpus = new XmlSlurper().parseText(body)
        Family family =new Family()
        def nationsMap = new HashMap<String,Integer>()

        def listTei = teiCorpus.teiCorpus
        def count = family.countApplication(listTei, nationsMap)

        Assert.assertEquals(count, 0);

    }

    @Test
    public void testCountPriorityClaims() throws InterruptedException {

        String body = new File("src/main/resources/file3.xml").text
        def teiCorpus = new XmlSlurper().parseText(body)
        Family family =new Family()
        def nationsMap = new HashMap<String,Integer>()

        def listTei = teiCorpus.teiCorpus
        def count = family.countPriorityClaims(listTei,nationsMap)

        Assert.assertEquals(count, 4);

    }
}
