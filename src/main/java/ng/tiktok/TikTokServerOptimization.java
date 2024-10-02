package ng.tiktok;

import java.io.*;
import java.util.*;

public class TikTokServerOptimization {
    public static void main(String[] args) throws IOException {
        // Fast input reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numServers = Integer.parseInt(st.nextToken());
        int numDisconnectedPairs = Integer.parseInt(st.nextToken());

        // Initialize lastDisconnect array
        int[] lastDisconnect = new int[numServers + 2];

        // Process disconnected pairs
        for (int i = 0; i < numDisconnectedPairs; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u > v) {
                int temp = u;
                u = v;
                v = temp;
            }
            lastDisconnect[v] = Math.max(lastDisconnect[v], u);
        }

        long total = 0;
        int[] L = new int[numServers + 2];
        L[0] = 1;

        // Compute L[i] and total
        for (int i = 1; i <= numServers; i++) {
            L[i] = Math.max(L[i - 1], lastDisconnect[i] + 1);
            total += i - L[i] + 1;
        }

        System.out.println(total);
    }
}
