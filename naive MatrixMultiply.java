import java.util.Scanner;

public class naive {
    public static void main(String[] args){
        long totalCost = 0;
        Scanner sc = new Scanner(System.in);
        String val;
        val = sc.nextLine();
        int size = Integer.parseInt(val);
        long[] sizes =new long[size+1];
        int j = 0;
        while (sc.hasNextLine()) {
            val = sc.nextLine();
            String[] split = val.split("\\s+");
            for (int i=0;i<split.length;i++){
                //System.out.println(split[i]);
                sizes[j] = Integer.parseInt(split[i]);
                j+=1;
            }
        }
        totalCost += sizes[0] * sizes[1] * sizes[2];
        long L = sizes[0];
        long R =  sizes[2];
        for(int i=3;i<sizes.length;i++) {
            totalCost += L * R * sizes[i];
            R = sizes[i];
        }
        System.out.println(totalCost);
    }
}
