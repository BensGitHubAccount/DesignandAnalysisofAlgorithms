import java.util.Scanner;

public class dp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String val;
        val = sc.nextLine();
        int size = Integer.parseInt(val);
        long[] sizes =new long[size+1];
        long[][] cost = new long[size][size];
        int j = 0;
        while (sc.hasNextLine()) {
            val = sc.nextLine();
            String[] split = val.split("\\s+");
            for (String s : split) {
                sizes[j] = Integer.parseInt(s);
                j += 1;
            }
        }
        for (int i=0;i<size;i++){
            cost[i][i] = 0;
        }
        long num, minNum;
        for (int len=2; len<=size; len++){
            for (int start = 0;start<1+size-len;start++){
                int end = start + len - 1;
                int k = start;
                minNum = cost[start][k] + cost[k+1][end] + (sizes[start] * sizes[k+1] * sizes[end+1]);
                for(k=start;k<=end-1;k++){
                    num = cost[start][k] + cost[k+1][end] + (sizes[start] * sizes[k+1] * sizes[end+1]);
                    if (num < minNum){
                        minNum = num;
                    }
                    cost[start][end] = minNum;
                }
            }
        }
        System.out.println(cost[0][size-1]);
    }
}
