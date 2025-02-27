package DataStructures;

import java.util.*;
import java.util.Arrays;

public class DijkstraAlgo {

    static class Pii {
        Integer first, second;
        Pii(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Edge {
        Integer u, v, w;
        Edge(Integer u, Integer v, Integer w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class PiiMaxComparator implements Comparator<Pii> {
        @Override
        public int compare(Pii x, Pii y) {
            if (x.first == y.first) return y.second - x.second;
            else return y.first - x.first;
        }
    }

    static void dijkstra(List<ArrayList<Pii>> adjList, int N, int S) {

        PriorityQueue<Pii> maxHeap = new PriorityQueue<>(new PiiMaxComparator());
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        maxHeap.add(new Pii(0, 0));

        while (!maxHeap.isEmpty()) {
            Pii curr = maxHeap.poll();
            int u = curr.first;
            for (Pii next: adjList.get(u)) {
                int v = next.first, w = next.second;
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    maxHeap.add(new Pii(v, dist[v]));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(dist[i] + " ");
        }
    }

    public static void main(String args[]) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(2, 3, 7));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(4, 5, 10));
        edges.add(new Edge(5, 6, 2));
        edges.add(new Edge(6, 7, 1));
        edges.add(new Edge(7, 0, 8));
        edges.add(new Edge(1, 7, 11));
        edges.add(new Edge(7, 8, 7));
        edges.add(new Edge(6, 8, 6));
        edges.add(new Edge(2, 8, 2));
        edges.add(new Edge(2, 5, 4));
        edges.add(new Edge(3, 5, 14));

        List<ArrayList<Pii>> adjList = new ArrayList<>();
        for (int i = 0; i < 9; i++) adjList.add(new ArrayList<>());

        for (Edge edge: edges) {
            adjList.get(edge.u).add(new Pii(edge.v, edge.w));
            adjList.get(edge.v).add(new Pii(edge.u, edge.w));
        }

        dijkstra(adjList, 9, 0);
    }
}
