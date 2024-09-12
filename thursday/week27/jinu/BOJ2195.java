package thursday.week27.jinu;

import java.io.*;

public class BOJ2195 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (s.indexOf(p.substring(idx, i + 1)) != -1)
                continue;
            cnt++;
            idx = i;
        }
        System.out.println(cnt + 1);
    }
}