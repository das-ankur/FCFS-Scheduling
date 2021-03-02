import java.text.ParseException; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
public class FCFS { 
    static void findWaitingTime(int processes[], int n, 
            int bt[], int wt[]) { 
        wt[0] = 0; 
        for (int i = 1; i < n; i++) { 
            wt[i] = bt[i - 1] + wt[i - 1]; 
        } 
    } 
    static void findTurnAroundTime(int processes[], int n, 
            int bt[], int wt[], int tat[]) { 
        for (int i = 0; i < n; i++) { 
            tat[i] = bt[i] + wt[i]; 
        } 
    } 
    static void findavgTime(int processes[], int n, int bt[]) { 
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0; 
        findWaitingTime(processes, n, bt, wt); 
        findTurnAroundTime(processes, n, bt, wt, tat); 
        System.out.printf("Processes Burst time Waiting"+" time Turn around time\n"); 
        for (int i = 0; i < n; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i];
            System.out.printf(" %d ", (i + 1)); 
            System.out.printf(" \t\t%d ", bt[i]); 
            System.out.printf(" \t%d", wt[i]); 
            System.out.printf(" \t\t%d\n", tat[i]); 
        } 
        float s = (float)total_wt /(float) n; 
        int t = total_tat / n; 
        System.out.printf("Average waiting time = %f", s); 
        System.out.printf("\n"); 
        System.out.printf("Average turn around time = %d ", t); 
    } 
    public static void main(String[] args) throws ParseException {
        int n=0;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            n=Integer.parseInt(myReader.nextLine());
            myReader.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int processes[]=new int[n];
        int burst_time[]=new int[n];
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            n=Integer.parseInt(myReader.nextLine());
            int i=0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String temp[]=data.split(" ");
                processes[i]=Integer.parseInt(temp[0]);
                burst_time[i]=Integer.parseInt(temp[1]);
                i++;
        }
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int time=0, count=0;
        for(int i=0;i<processes.length;) {
            System.out.println("<system time\t"+time+"> process\t"+processes[i]+" is running");
            time++;
            count++;
            if(burst_time[i]<count) {
                i++;
                count=1;
            }
        }
        findavgTime(processes, n, burst_time); 
    } 
} 
