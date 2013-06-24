package groovy

class Summary {

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
}
