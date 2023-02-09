package thursday.week13.hagyoung;

import java.io.*;
import java.util.*;
public class Q24445 {
    static int[] visit;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //정점의 수
        int M = Integer.parseInt(st.nextToken());   //간선의 수
        int R = Integer.parseInt(st.nextToken());   //시작 정점

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        visit = new int[N+1];

        for(int i = 0;i<N+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){   //간선별 노드 저장
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            list.get(to).add(from);
            list.get(from).add(to);
        }

        for(int i=1;i<list.size();i++){  //정렬
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        DFS(R, list);

        for(int i=1;i<=N;i++){
            System.out.println(visit[i]);
        }
    }

    static void DFS(int R, ArrayList<ArrayList<Integer>> list){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(R);
        visit[R] = cnt++;

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0;i<list.get(x).size();i++){
                int newNode = list.get(x).get(i);
                if(visit[newNode]==0){
                    q.offer(newNode);
                    visit[newNode] = cnt++;
                }
            }
        }
    }
}
