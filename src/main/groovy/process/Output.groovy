package process

import groovy.xml.XmlUtil

class Output {

    public void WriteSummary(Summary summary) {
        HashMap nationsMap = summary.getNationsMap()
        def countClaims = summary.getCountClaims()
        def countTei = summary.getCountTei()
        def idFamily = summary.getIdFamily()
        def nationPlus = summary.getNationPlus()
        def count = summary.getCount()
        def fw = new FileWriter('src/main/resources/outputSummary.xml')
        def xml = new groovy.xml.MarkupBuilder(fw)

        xml.summary() {
            idfamily(idFamily)
            numberPatent(1)
            xml.Nations() {
                for (nation in nationsMap.keySet()) {
                    nat(nation)
                }
            }
            biggestPatentNation(nationPlus)
            numberApplication(countTei)
            numberPublication(count)
        }
    }

    public void writePriorityClaims(Map claims) {
        def fw = new FileWriter('src/main/resources/outputClaims1.xml')
        def xml = new groovy.xml.MarkupBuilder(fw)
        def count = 0

        xml.priorities() {
            for (name in claims.keySet()) {
                def c = claims.get(name)
                for (int i = 0; i < c.size(); i++) {
                    xml.priority(n: count, type: c.get(i).@subtype, source: name) {
                        mkp.yieldUnescaped XmlUtil.serialize(c.get(i))
                    }
                    count++
                }
            }
        }
    }
}

