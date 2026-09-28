import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new LinkedHashMap<>();
    }

    // 1. Add campus location
    public boolean addLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            return false;
        }
        location = location.trim();

        if (adjList.containsKey(location)) {
            return false; // duplicate
        }

        adjList.put(location, new ArrayList<>());
        return true;
    }

    // 2. Remove campus location
    public boolean removeLocation(String location) {
        if (!adjList.containsKey(location)) {
            return false;
        }

        adjList.remove(location);

        // remove from all neighbour lists
        for (List<String> neighbours : adjList.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    // 3. Add connection / road (undirected)
    public boolean addConnection(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            return false;
        }

        if (from.equals(to)) {
            return false; // self connection not allowed
        }

        List<String> fromList = adjList.get(from);
        List<String> toList = adjList.get(to);

        if (fromList.contains(to)) {
            return false; // already connected
        }

        fromList.add(to);
        toList.add(from);

        return true;
    }

    // 4. Remove connection / road
    public boolean removeConnection(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) {
            return false;
        }

        List<String> fromList = adjList.get(from);
        List<String> toList = adjList.get(to);

        if (!fromList.contains(to)) {
            return false; // no connection
        }

        fromList.remove(to);
        toList.remove(from);

        return true;
    }

    // 5. Display all connections / neighbours
    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\n--- Campus Connections ---");
        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // 6. BFS traversal
    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbour : adjList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // 7. DFS traversal (optional)
    public void dfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (String neighbour : adjList.get(current)) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }

    // Helper methods
    public boolean hasLocation(String location) {
        return adjList.containsKey(location);
    }

    public List<String> getNeighbours(String location) {
        return adjList.getOrDefault(location, Collections.emptyList());
    }
}