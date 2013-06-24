package groovy

import groovy.util.slurpersupport.GPathResult

class Family {

    public void extract(String body){
        def teiCorpus = new XmlSlurper().parseText(body)
        def idFamily =teiCorpus.teiHeader.fileDesc.sourceDesc.bibl.idno
        def count =0
        def counts =0
        def countTei=0
        def countClaims=0
        def listTei = teiCorpus.teiCorpus
        def ArrayList arrayList= new ArrayList()
        def nationPlus

        // publication
        countPublication(listTei, arrayList, count)
       // application
        countApplication(teiCorpus, arrayList, countTei)
        // claims
        countPriorityClaims(listTei, arrayList, countClaims)
        Nation n= new Nation()
        nationPlus = n.getNationPlus(arrayList)

        Summary summary= new Summary()
        summary.WriteSummary(n, arrayList, countClaims, countTei, idFamily, nationPlus, count)
    }

    private void countPriorityClaims(listTei, arrayList, countClaims) {
        listTei.TEI.each { tei ->
            def listClaims = tei.teiHeader.fileDesc.sourceDesc.listBibl.biblStruct
            listClaims.each { claim ->
                if (claim.@subtype == "docdb") {
                    countClaims++
                    arrayList.add(claim.monogr.authority.orgName)
                }
            }
        }
    }

    private void countApplication(GPathResult teiCorpus, arrayList, countTei) {
        def listP = teiCorpus.teiCorpus.teiHeader.fileDesc.sourceDesc.biblStruct
        listP.each { application ->
            if (application.@subtype == "docdb") {
                countTei++
                arrayList.add(application.monogr.authority.orgName)
            }
        }
    }

    private void countPublication(listTei, arrayList, count) {
        listTei.TEI.each { tei ->
            def listP = tei.teiHeader.fileDesc.sourceDesc.biblStruct
            listP.each { publication ->
                if (publication.@subtype == "docdb") {
                    count++
                    arrayList.add(publication.monogr.authority.orgName)
                }
            }
        }
    }


}
