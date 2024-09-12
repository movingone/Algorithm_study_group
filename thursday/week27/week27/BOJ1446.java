import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        //[���� ����, ��ǥ ����, ���]
        int[][] shortcuts=new int[n][3];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            shortcuts[i][0]=Integer.parseInt(st.nextToken());
            shortcuts[i][1]=Integer.parseInt(st.nextToken());
            shortcuts[i][2]=Integer.parseInt(st.nextToken());
        }

        //���� ������ �������� ������ ����
        Arrays.sort(shortcuts, Comparator.comparingInt(o->o[0]));
        //[���� ��ġ, ���]�� ���·� �켱����ť ����, ���� ����:���
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] ptr=pq.poll();
            int location=ptr[0];
            int cost=ptr[1];

            if(location==d){
                System.out.println(cost);
                return;
            }

            //���� ��ġ�� �������� ���� ������ ����, �������� ��ǥ ������ D�� ���ų� �� ª��, �������� Ÿ�� ���� �� �̵��� �� �켱����ť�� ����
            int next=d;
            for(int[] i:shortcuts){
                if(i[0]>location) {     //�������� ���� ������ ���� ��ġ���� ũ�� ���� ��ǥ ��ġ�� �����ϰ� break
                    next = i[0];
                    break;
                }
                else if(i[0]==location){
                    if(i[1]<=d && i[1]-location>i[2])
                        pq.add(new int[]{i[1], cost+i[2]});
                }
            }
            //���� ��ǥ����, D �� ����� ��ġ�� �켱����ť�� ����
            pq.add(new int[]{Math.min(next, d), Math.min(next, d)-location+cost});
        }
    }
}