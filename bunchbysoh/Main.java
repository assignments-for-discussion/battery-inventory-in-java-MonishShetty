package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    return counts;
  }

  static void testBucketingByHealth() {
    int h=0,e=0,f=0;
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    ArrayList<Integer> soh=new ArrayList<Integer>();
    for(int i:presentCapacities){
      int x=(100*i)/120;
      soh.add(x);
    }
    for(int i=0;i<soh.size();i++){
      if(soh.get(i)>80){
        h++;
        assert(counts.healthy==h)
          }
      else if(soh.get(i)<=80 || soh.get(i)>=62){
        e++;
        assert(counts.exchange==e)
          }
      else if(soh.get(i)<62){
        f++;
        assert(counts.failed==f)
          }
        
    // assert(counts.healthy == 2);
    // assert(counts.exchange == 3);
    // assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
