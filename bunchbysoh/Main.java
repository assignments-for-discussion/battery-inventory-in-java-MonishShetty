package bunchbysoh;
import java.util.ArrayList;

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
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    ArrayList<Integer> soh=new ArrayList<Integer>();    //List to store converted SoH values of batteries
    ArrayList<Integer> healthylist=new ArrayList<Integer>();  //List to store batteries falling under healthy condition
    ArrayList<Integer> exchangelist=new ArrayList<Integer>(); //List to store batteries falling under exchange condition
    ArrayList<Integer> failedlist=new ArrayList<Integer>();   //List to store batteries falling under failed condition
    for(int i:presentCapacities){
      int x=(100*i)/120;
      if(x>80 && x<=100){        //Condition for a healthy battery
        healthylist.add(x);
      }
      else if(x<=80 && x>=62){   //Condition for a exchange battery
        exchangelist.add(x);   
      }
      else {                     
        failedlist.add(x);      
      }
        soh.add(x);             //Add all converted SoH values to soh list
    }
    counts.healthy=healthylist.size();  //update healthy count to the number of entries in healthylist
    counts.exchange=exchangelist.size();//update exchange count to the number of entries in exchangelist
    counts.failed=failedlist.size();    //update failed count to the number of entries in failedlist
        
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
