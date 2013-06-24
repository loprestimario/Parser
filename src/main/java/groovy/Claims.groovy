package groovy

import groovy.xml.XmlUtil

class Claims {

    public void extractClaims(String body){

        def teiCorpus = new XmlSlurper().parseText(body)
        def listClaims = teiCorpus.teiCorpus.TEI.teiHeader.fileDesc.sourceDesc.listBibl.biblStruct
        def fw = new FileWriter('src/main/resources/outputClaims.xml')
        def xml = new groovy.xml.MarkupBuilder(fw)
        def count=0
        def listTei= teiCorpus.teiCorpus.TEI

        xml.priorities(){
            listTei.each{ tei->
                def application = tei.teiHeader.fileDesc.sourceDesc.biblStruct.monogr.idno[0]
                def listP = tei.teiHeader.fileDesc.sourceDesc.listBibl.biblStruct
                listP.each{claim->
                    xml.priority(n:count, type:claim.@subtype, source:application  ){
                    mkp.yieldUnescaped XmlUtil.serialize( claim)
                    }
                    count++
                }
            }
        }
    }
}
