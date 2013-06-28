package process

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 26/06/13
 * Time: 0.53
 * To change this template use File | Settings | File Templates.
 */
public class Summary {

    ArrayList summary

    public Summary() {
        summary = new ArrayList()

    }

    public void putNationsMap(HashMap nationsMap) {
        summary.add(0, nationsMap)
    }

    public void putCountClaims(Integer countClaims) {
        summary.add(1, countClaims)
    }

    public void putCountTei(Integer countTei) {
        summary.add(2, countTei)
    }

    public void putIdFamily(String idFamily) {
        summary.add(3, idFamily)
    }

    public void putNationPlus(String nationPlus) {
        summary.add(4, nationPlus)
    }

    public void putCount(Integer count) {
        summary.add(5, count)
    }

    public HashMap getNationsMap(HashMap nationsMap) {
        summary.get(0)
    }

    public Integer getCountClaims(Integer countClaims) {
        summary.get(1)
    }

    public Integer getCountTei(Integer countTei) {
        summary.get(2)
    }

    public String getIdFamily(Integer idFamily) {
        summary.get(3)
    }

    public String getNationPlus(String nationPlus) {
        summary.get(4)
    }

    public Integer getCount(Integer count) {
        summary.get(5)
    }

}
