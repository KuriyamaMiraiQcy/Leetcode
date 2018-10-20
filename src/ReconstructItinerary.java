import java.util.*;

public class ReconstructItinerary {
    HashMap<String, Graph> map = new HashMap<>();
    //solution
    private HashMap<String, List<String>> adjList = new HashMap<>();
    private LinkedList<String> route = new LinkedList<>();
    private int numTickets = 0;
    private int numTicketsUsed = 0;

    public List<String> FindItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return route;
        // build graph
        numTickets = tickets.length;
        for (int i = 0; i < tickets.length; ++i) {
            if (!adjList.containsKey(tickets[i][0])) {
                // create a new list
                List<String> list = new ArrayList<>();
                list.add(tickets[i][1]);
                adjList.put(tickets[i][0], list);
            } else {
                // add to existing list
                adjList.get(tickets[i][0]).add(tickets[i][1]);
            }
        }
        // sort vertices in the adjacency list so they appear in lexical order
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // start DFS
        route.add("JFK");
        dfsRoute("JFK");
        return route;
    }

    private void dfsRoute(String v) {
        // base case: vertex v is not in adjacency list
        // v is not a starting point in any itinerary, or we would have stored it
        // thus we have reached end point in our DFS
        if (!adjList.containsKey(v)) return;
        List<String> list = adjList.get(v);
        for (int i = 0; i < list.size(); ++i) {
            String neighbor = list.get(i);
            // remove ticket(route) from graph
            list.remove(i);
            route.add(neighbor);
            numTicketsUsed++;
            dfsRoute(neighbor);
            // we only return when we have used all tickets
            if (numTickets == numTicketsUsed) return;
            // otherwise we need to revert the changes and try other tickets
            list.add(i, neighbor);
            // This line took me a long time to debug
            // we must remove the last airport, since in an itinerary, the same airport can appear many times!!
            route.removeLast();
            numTicketsUsed--;
        }
    }
    //end solution

    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, Integer> visited = new HashMap<>();
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
            int num = visited.getOrDefault(pair[0] + "--" + pair[1], 0);
            visited.put(pair[0] + "--" + pair[1], num + 1);
        }

        for (Graph g:map.values()) {
            Collections.sort(g.airlines);
        }

        return DFS(map.get("JFK"), visited, new LinkedList<String>());
    }

    private List<String> DFS(Graph start, HashMap<String, Integer> visited, List<String> result) {
        result.add(start.name);
        if (result.size() == visited.keySet().size() + 1) {
            return result;
        }
        for (Graph neighbor:start.airlines) {
            String airline = start.name + "--" + neighbor.name;
            if (visited.get(airline) > 0) {
                visited.put(airline, visited.get(airline) - 1);
                result = DFS(neighbor, visited, result);
                if (result.size() == visited.keySet().size() + 1) {
                    return result;
                }
                visited.put(airline, visited.get(airline) + 1);
            }
        }
        result.remove(start.name);
        return result;
    }

    class Graph implements Comparable {
        String name;
        ArrayList<Graph> airlines;

        public Graph(String str) {
            name = str;
            airlines = new ArrayList<>();
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
        System.out.print(test.findItinerary(new String[][]{
                {"EZE","TIA"},{"EZE","AXA"},{"AUA","EZE"},
                {"EZE","JFK"},{"JFK","ANU"},{"JFK","ANU"},
                {"AXA","TIA"},{"JFK","AUA"},{"TIA","JFK"},
                {"ANU","EZE"},{"ANU","EZE"},{"TIA","AUA"}
        }));
        System.out.println("TIA".compareTo("JFK"));
    }
}
