import java.util.*;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2026-01-06 13:58
 **/
public class kruskal {
    public static ArrayList<Integer> father;

    static void init(int n) {
        father = new ArrayList<>(Collections.nCopies(n,0));
        for (int i = 0; i < n; i++) {
            father.set(i, i);
        }
    }

    static int find(int u) {
        if (u == father.get(u)) {
            return u;
        }
        int i = find(father.get(u));
        father.set(u,i);
        return i;
    }

    static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            father.set(u, v);
        }
    }

    static boolean same(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    static class graph {
        int cost;
        int u;
        int v;
    }

    public static void main(String[] args) {
        ArrayList<graph> graphs = new ArrayList<>();
        int n = 10;

        LinkedList<List<Integer>> path = new LinkedList<>();
        graphs.sort(Comparator.comparing(a -> a.cost));
        while (true) {
            if (graphs.isEmpty()) {
                break;
            }
            graph graph = graphs.removeFirst();
            if (!same(graph.u, graph.v)) {
                path.add(List.of(graph.u, graph.v));
                join(graph.u, graph.v);
            }
        }
    }
}
