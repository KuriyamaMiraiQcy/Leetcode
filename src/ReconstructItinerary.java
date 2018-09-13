import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    HashMap<String, Graph> map = new HashMap<>();
    HashMap<String, Boolean> visited = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] pair:tickets) {
            Graph first;
            if (!map.containsKey(pair[0])) {
                first = new Graph(pair[0]);
                map.put(pair[0], first);
            } else {
                first = map.get(pair[0]);
            }

            Graph next;
            if (!map.containsKey(pair[1])) {
                next = new Graph(pair[1]);
                map.put(pair[1], next);
            } else {
                next = map.get(pair[1]);
            }
            first.addAirline(next);
            String airline = pair[0] + "--" + pair[1];
            visited.put(airline, false);
        }

        return DFS(map.get("JFK"), visited, new LinkedList<String>());
    }

    private List<String> DFS(Graph start, HashMap<String, Boolean> map, LinkedList<String> result) {
        result.add(start.name);
        String pair = start.name;
        for (Graph neighbor:start.airlines) {
            pair += "--" + neighbor.name;
            if (!visited.get(pair)) {
                visited.put(pair, true);
                DFS(neighbor, (HashMap<String, Boolean>)visited.clone(), (LinkedList<String>) result.clone());
                if (result.size() == visited.keySet().size()) {
                    return result;
                }
            }
        }
        return result;
    }

    class Graph implements Comparable {
        String name;
        PriorityQueue<Graph> airlines;

        public Graph(String str) {
            name = str;
            airlines = new PriorityQueue<>();
        }

        public void addAirline(Graph g) {
            airlines.add(g);
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) {
                return 0;
            }
            if (o == null || getClass() != o.getClass()) {
                throw new RuntimeException();
            }

            Graph temp = (Graph) o;
            return this.name.compareTo(temp.name);
        }
    }

    public static void main(String[] args) {
        ReconstructItinerary test = new ReconstructItinerary();
        System.out.print(test.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}));
    }
}
