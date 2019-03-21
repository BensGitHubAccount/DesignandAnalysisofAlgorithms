import java.util.Scanner;

public class greedy {
    public static long totalCost;
        public static void main(String[] args){
            totalCost = 0;
            Scanner sc = new Scanner(System.in);
            String val;
            val = sc.nextLine();
            int size = Integer.parseInt(val);
            long[] sizes =new long[size+1];
            int j = 0;
            while (sc.hasNextLine()) {
                val = sc.nextLine();
                String[] split = val.split("\\s+");
                for (String s : split) {
                    sizes[j] = Integer.parseInt(s);
                    j += 1;
                }
            }
            //Start Greedy Approach
            int start = 0;
            greedy(sizes, start, size);
            System.out.println(totalCost); //672
        }
        public static Integer greedy(long[] s, int l, int r){
            int k;
            long min;
            k=l;
            //System.out.println(l + "  " + r);
            if(r-l<1){
                //System.out.println("error");
                return k;
            }
            if (r-l==1){
                return k;
            }
            if(r-l == 2){
                totalCost += s[l]*s[l+1]*s[r];
                return k;
            }
            min = s[l]*s[l+1]*s[r];
            k = l+1;
            for (int i=l+1; i<r;i++){
                if (s[l]*s[i]*s[r]<min){
                    min = s[l]*s[i]*s[r];
                    k= i;
                }
            }
            totalCost += min;
            greedy(s, l, k);
            greedy(s, k, r);
            return k;
        }


}
