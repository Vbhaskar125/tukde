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


class INTEST{

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
        int count=0;
        int cases=in.nextInt();
        int k=in.nextInt();
        while(cases >0){

            if(in.nextInt()%k ==0)
                count++;

            cases--;
        }
       out.print(count);


        //solution logic ends here
    }

    private void arrayInput(int size, int[] a) {
        for (int i = 0; i <size ; i++) {
            a[i]=in.nextInt();
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

