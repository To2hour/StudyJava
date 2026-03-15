import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class jvmtest {
    class test {
        static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    }

    // 这个ArrayList本身就很危险，初始容量太大
    // ArrayList<jvmtest> list = new ArrayList<>(1024 * 1024 * 1024);
    byte[] data = new byte[1024 * 1024]; // 每个对象占1MB

    public static void main(String[] args) throws InterruptedException {
        int a=100;

    }
}

class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>((a, b) -> b.length() - a.length()));
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }
}
