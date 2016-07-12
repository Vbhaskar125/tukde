import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    public static void main (String[] args) throws java.lang.Exception , IOException, Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cases= Integer.parseInt(br.readLine());
        int count=0;
        int k=Integer.parseInt(br.readLine());
        while(cases>0){
            if(Integer.parseInt(br.readLine()) % k ==0)
                count++;

            cases--;
        }
        System.out.println(count);


    }
}
