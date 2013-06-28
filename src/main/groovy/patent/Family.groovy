package patent

import groovy.util.slurpersupport.GPathResult
import process.Summary

public class Family {
    HashMap<String, Integer> nationsMap = new HashMap<String, Integer>()


    public Summary extract(String body) {
        def teiCorpus = new XmlSlurper().parseText(body)
        def idFamily = teiCorpus.teiHeader.fileDesc.sourceDesc.bibl.idno
        def listTei = teiCorpus.teiCorpus
        def arrayList = new ArrayList()
        def nationPlus

        // publication
        def count = countPublication(listTei, nationsMap)
        // application
        def countTei = countApplication(teiCorpus, nationsMap)
        // claims
        def countClaims = countPriorityClaims(listTei, nationsMap)
        Nation n = new Nation()
        nationPlus = n.getNationPlus(nationsMap)

        Summary summary = new Summary()
        summary.putNationsMap(nationsMap)
        summary.putCountClaims(countClaims)
        summary.putCountTei(countTei)
        summary.putIdFamily((String)(idFamily))
        summary.putNationPlus(nationPlus)
        summary.putCount(count)

        return summary
    }


    public int countPriorityClaims(listTei, HashMap nationsMap) {
        def nat
        def countClaims = 0
        listTei.TEI.each { tei ->
            def listClaims = tei.teiHeader.fileDesc.sourceDesc.listBibl.biblStruct
            listClaims.each { claim ->
                if (claim.@subtype == "docdb") {
                    countClaims++
                    nat = (String) (claim.monogr.authority.orgName)
                    if (nationsMap.containsKey(nat)) {
                        nationsMap[nat] = nationsMap.get(nat) + 1
                    } else {
                        nationsMap[nat] = 1
                    }
                }
            }
        }
        return countClaims++
    }

    public int countApplication(GPathResult teiCorpus, nationsMap) {
        def countTei = 0
        def nat
        def listP = teiCorpus.teiCorpus.teiHeader.fileDesc.sourceDesc.biblStruct
        listP.each { application ->
            if (application.@subtype == "docdb") {
                countTei++
                nat = (String) (application.monogr.authority.orgName)
                if (nationsMap.containsKey(nat))
                    nationsMap[nat] = nationsMap.get(nat) + 1
                else
                    nationsMap[nat] = 1
            }
        }
        return countTei++
    }

    public int countPublication(listTei, nationsMap) {

        def count = 0;
        def nat
        listTei.TEI.each { tei ->
            def listP = tei.teiHeader.fileDesc.sourceDesc.biblStruct
            listP.each { publication ->
                if (publication.@subtype == "docdb") {
                    count++
                    nat = (String) (publication.monogr.authority.orgName)
                    if (nationsMap.containsKey(nat))
                        nationsMap[nat] = nationsMap.get(nat) + 1
                    else
                        nationsMap[nat] = 1
                }
            }
        }
        return count
    }
}
