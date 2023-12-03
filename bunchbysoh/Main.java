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
    ArrayList<Integer> healthylist=new ArrayList<Integer>();
    ArrayList<Integer> exchangelist=new ArrayList<Integer>();
    ArrayList<Integer> failedlist=new ArrayList<Integer>();
    for(int i:presentCapacities){
      int x=(100*i)/120;
      if(x>80 && x<=100){
        healthylist.add(x);
      }
      else if(x<=80 && x>=62){
        exchangelist.add(x);
      }
      else {
        failedlist.add(x);
      }
        soh.add(x);
    }
    counts.healthy=healthylist.size();
    counts.exchange=exchangelist.size();
    counts.failed=failedlist.size();
        
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
