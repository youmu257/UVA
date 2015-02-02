import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
class soldier{
	int pt,et;
}
class uva_11729 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _case = 1;
		while(in.hasNext()){
			int N = in.nextInt();
			if(N==0)
				break;
			soldier s[]=new soldier[N];
			for(int i=0;i<N;i++){
				s[i] = new soldier();
				s[i].pt = in.nextInt();
				s[i].et = in.nextInt();
			}
			for(int i=0;i<s.length;i++)
				for(int j=i+1;j<s.length;j++){
					//double si = (double)s[i].et/s[i].pt,sj = (double)s[j].et/s[j].pt;
					//if(si<sj || (si==sj && s[i].et<s[j].et)){
					if(s[i].et<s[j].et){//直接比較執行任務的時間
						soldier tmp = s[i];
						s[i] = s[j];
						s[j] = tmp;
					}
				}
			LinkedList<Integer> time = new LinkedList<Integer>();
			
			int total = 0;
			for(int i=0;i<s.length;i++){
				int size = time.size();
				for(int j=0;j<size;j++){
					int tmp = time.poll()-s[i].pt;
					if(tmp>0)
						time.addLast(tmp);
				}
				time.add(s[i].et);
				total += s[i].pt;
			}
			System.out.println("Case "+_case+": "+(total+Collections.max(time)));
			_case++;
		}

	}
}
/*
6
2 5
3 2
2 1
3 3
4 4
5 5
0
*/
