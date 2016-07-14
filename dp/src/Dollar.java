import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigDecimal;


class Dollar{

    public static void main(String[] args) throws IOException{
        solver sol=new solver();
        sol.run();
    }
}

class solver{
    FastScanner in;
    PrintWriter out;
    public void solve() throws IOException {
        // solution logic goes here


        double[] denominations={0.05,0.1,0.2,0.5,1,2,5,10,20,50,100};
       int[][] dp=new int[denominations.length][6001];
        dpinit(denominations, dp);

        for (int i = 0; i <denominations.length ; i++) {
            for (int j = 0; j <6001 ; j++) {
                if(j==0){
                    dp[i][j]=1;
                }
                if(i==0 ){
                    dp[i][j]=1;
                }

                if(i !=0 && j !=0){
                   double value= (j)*0.05;

                    BigDecimal bd = new BigDecimal(value);
                    bd = bd.setScale(3, RoundingMode.HALF_UP);
                    value=bd.doubleValue();
                    double den=denominations[i];
                    if(den>value){
                        dp[i][j]=dp[i-1][j];
                    }else if (den<=value) {
                     if(value==den){
                         dp[i][j] = dp[i - 1][j] +1;
                     }else {

                         dp[i][j] = dp[i - 1][j] + dp[i][(int) ((value - den) / 0.05)];
                     }
                     }

                }
            }
        }

        double reading=in.nextDouble();
        String result="";
        while(0.00 != reading){
           result+=reading +"      "+dp[denominations.length-1][(int)(reading/0.05)-1] +"\n";



            reading=in.nextDouble();
        }
        out.print(result);

    }

    private void dpinit(double[] denominations, int[][] dp) {
        for (int i = 0; i < denominations.length ; i++) {
            for (int j = 0; j <6001; j++) {
                dp[i][j]=0;
            }
        }
    }


    public void runf(){
        try {
            in = new FastScanner(new File(".in"));
            out = new PrintWriter(new File(".out"));
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;
    public FastScanner(){
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public FastScanner(File f) {
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String next(){
        while(st ==null || !st.hasMoreElements()){
            try{
                st=new StringTokenizer(br.readLine());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt(){
        return Integer.parseInt(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }

    String nextLine(){
        String str="";
        try{
            str=br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}

