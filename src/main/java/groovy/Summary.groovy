package groovy

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 26/06/13
 * Time: 0.53
 * To change this template use File | Settings | File Templates.
 */
class Summary {

    ArrayList summary
    public Summary(){
       summary = new ArrayList()

    }

    public void putNation(Nation nation){
         summary.add(0,nation)
    }
    public void putArray(ArrayList arrayList){
        summary.add(1,arrayList)
    }
    public void putCountClaims(Integer countClaims){
        summary.add(2,countClaims)
    }
    public void putCountTei(Integer countTei){
        summary.add(3,countTei)
    }
    public void putIdFamily(Integer idFamily){
        summary.add(4,idFamily)
    }
    public void putNationPlus(String nationPlus){
        summary.add(5,nationPlus)
    }
    public void putCount(Integer count){
        summary.add(6,count)
    }
    public Nation getNation(Nation nation){
        summary.get(0)
    }
    public ArrayList getArray(ArrayList arrayList){
        summary.get(1)
    }
    public Integer getCountClaims(Integer countClaims){
        summary.get(2)
    }
    public Integer getCountTei(Integer countTei){
        summary.get(3)
    }
    public Integer getIdFamily(Integer idFamily){
        summary.get(4)
    }
    public String getNationPlus(String nationPlus){
        summary.get(5)
    }
    public Integer getCount(Integer count){
        summary.get(6)
    }

}
