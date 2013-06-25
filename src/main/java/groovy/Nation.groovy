package groovy


class Nation {

    public String getNationPlus(ArrayList arrayList) {
        int count4
        def nation
        Map<String, Integer> nations
        def nationPlus
        int k
        def comparator = 0

        ArrayList arrayNation = getNations(arrayList)
        nations = new HashMap<String, Integer>()
        for (int s = 0; s < arrayNation.size(); s++) {
            count4 = 0;
            nation = arrayNation.get(s)
            for (k = 0; k < arrayList.size(); k++) {
                if (arrayList.get(k) == nation)
                    count4++
            }
            nations.put((String) nation, count4)
        }

        for (String name : nations.keySet()) {
            if ((nations.get(name)) > comparator) {
                comparator = nations.get(name)
                nationPlus = name
            }
        }
        nationPlus
    }

    public ArrayList getNations(ArrayList arrayList) {

        ArrayList arrayNation = new ArrayList()
        for (int j = 0; j < arrayList.size(); j++) {
            if (!arrayNation.contains(arrayList.get(j)))
                arrayNation.add(arrayList.get(j))
        }
        arrayNation
    }
}
