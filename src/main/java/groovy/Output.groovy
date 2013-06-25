package groovy

import groovy.xml.XmlUtil

class Output {

    private void WriteSummary(Nation n, ArrayList arrayList, countClaims, countTei, idFamily, nationPlus, count) {
        def fw = new FileWriter('src/main/resources/outputSummary.xml')
        def xml = new groovy.xml.MarkupBuilder(fw)

        ArrayList arrayNation = n.getNations(arrayList)
        xml.summary() {
            idfamily(idFamily)
            numberPatent(countClaims + countTei + count)
            xml.Nations() {
                for (int t = 0; t < arrayNation.size(); t++)
                    nat(arrayNation.get(t))
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

