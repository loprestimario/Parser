package groovy

class Claims {

    public void extractClaims(String body) {

        def teiCorpus = new XmlSlurper().parseText(body)
        def listClaims = teiCorpus.teiCorpus.TEI.teiHeader.fileDesc.sourceDesc.listBibl.biblStruct
        def count = 0
        def listTei = teiCorpus.teiCorpus.TEI
        HashMap<Integer, ArrayList> priorityClaims
        priorityClaims = new HashMap<Integer, ArrayList>()
        ArrayList claimsArray

        listTei.each { tei ->
            def application = tei.teiHeader.fileDesc.sourceDesc.biblStruct.monogr.idno[0]
            def listP = tei.teiHeader.fileDesc.sourceDesc.listBibl.biblStruct
            claimsArray = new ArrayList()
            listP.each { claim ->
                claimsArray.add(claim)
                count++
            }
            for (int i = 0; i < claimsArray.size(); i++) {
            }
            (priorityClaims[application] = claimsArray)
        }
        Output output = new Output()
        output.writePriorityClaims(priorityClaims)
    }
}
