package patent


public class Nation {

    public String getNationPlus(Map nationsMap) {
        def nationPlus
        int k
        def comparator = 0

        for (String name : nationsMap.keySet()) {
            if ((nationsMap.get(name)) > comparator) {
                comparator = nationsMap.get(name)
                nationPlus = name
            }
        }
        nationPlus
    }
}
