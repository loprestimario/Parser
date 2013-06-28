
import groovy.util.slurpersupport.GPathResult
import junit.framework.Assert
import org.junit.Test
import patent.*;
/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 25/06/13
 * Time: 23.28
 * To change this template use File | Settings | File Templates.
 */
class TestClaims {

    @Test
    public void extractPriorityClaims() throws InterruptedException {

        def priorityClaim
        String body = new File("src/main/resources/file9.xml").text
        Claims claims = new Claims()
        Map claim = claims.extractClaims(body)

        GPathResult teiCorpus = new XmlSlurper().parseText(body)
        def listTei = teiCorpus.teiCorpus.TEI
        listTei.each { tei ->
            def application = tei.teiHeader.fileDesc.sourceDesc.biblStruct.monogr.idno[0]
        }

        for (name in claim.keySet()) {
            def c = claim.get(name)
            priorityClaim = c.get(0).toString()
        }
       // println priorityClaim
        Assert.assertEquals(priorityClaim,"US2340089911A19990119Y");

    }
}
