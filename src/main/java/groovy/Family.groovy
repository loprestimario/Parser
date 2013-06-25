package groovy

import groovy.util.slurpersupport.GPathResult

class Family {

    public void extract(String body) {
        def teiCorpus = new XmlSlurper().parseText(body)
        def idFamily = teiCorpus.teiHeader.fileDesc.sourceDesc.bibl.idno
        def listTei = teiCorpus.teiCorpus
        def ArrayList arrayList = new ArrayList()
        def nationPlus

        // publication
        def count = countPublication(listTei, arrayList)
        // application
        def countTei = countApplication(teiCorpus, arrayList)
        // claims
        def countClaims = countPriorityClaims(listTei, arrayList)
        Nation n = new Nation()
        nationPlus = n.getNationPlus(arrayList)

        Output summary = new Output()
        summary.WriteSummary(n, arrayList, countClaims, countTei, idFamily, nationPlus, count)
    }

    private int countPriorityClaims(listTei, arrayList) {
        def countClaims = 0
        listTei.TEI.each { tei ->
            def listClaims = tei.teiHeader.fileDesc.sourceDesc.listBibl.biblStruct
            listClaims.each { claim ->
                if (claim.@subtype == "docdb") {
                    countClaims++
                    arrayList.add(claim.monogr.authority.orgName)
                }
            }
        }
        return countClaims++
    }

    private int countApplication(GPathResult teiCorpus, arrayList) {
        def countTei = 0
        def listP = teiCorpus.teiCorpus.teiHeader.fileDesc.sourceDesc.biblStruct
        listP.each { application ->
            if (application.@subtype == "docdb") {
                countTei++
                arrayList.add(application.monogr.authority.orgName)
            }
        }
        return countTei++
    }

    private int countPublication(listTei, arrayList) {
        def count = 0;
        listTei.TEI.each { tei ->
            def listP = tei.teiHeader.fileDesc.sourceDesc.biblStruct
            listP.each { publication ->
                if (publication.@subtype == "docdb") {
                    count++
                    arrayList.add(publication.monogr.authority.orgName)
                }
            }
        }
        return count
    }
}
