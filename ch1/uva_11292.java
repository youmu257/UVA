import java.util.Arrays;
import java.util.Scanner;

public class uva_11292 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			
			if(n==0 && m==0)
				break;
			
			int head[] = new int[n];
			int knight[] = new int[m];
			int sum_of_head=0;
			for(int i=0;i<n;i++){
				head[i] = in.nextInt();
				sum_of_head+=head[i];
			}
			for(int i=0;i<m;i++)
				knight[i]=in.nextInt();
			
			Arrays.sort(head);
			Arrays.sort(knight);
			
			if(m<n)
				System.out.println("Loowater is doomed!");
			else{
				int sum=0;
				for(int i=0,j=0;i<knight.length && j<head.length;i++){
					if(knight[i]>=head[j]){
						sum+=knight[i];
						j++;
					}
				}
				if(sum_of_head>sum)
					System.out.println("Loowater is doomed!");
				else
					System.out.println(sum);
			}
		}
	}
}
