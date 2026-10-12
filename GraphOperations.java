import java.util.*;

public class Graph {
    private final Map<String, List<String>> adjList;
    private final boolean directed;

    // Default undirected graph
    public Graph() {
        this(false);
    }

    public Graph(boolean directed) {
        this.directed = directed;
        this.adjList = new LinkedHashMap<>(); // insertion order preserve karanna
    }

    // Add vertex
    public void addVertex(String vertex) {
        if (vertex == null || vertex.trim().isEmpty()) {
            System.out.println("Error: Vertex name cannot be empty.");
            return;
        }

        vertex = vertex.trim();

        if (adjList.containsKey(vertex)) {
            System.out.println("Vertex already exists: " + vertex);
            return;
        }

        adjList.put(vertex, new ArrayList<>());
        System.out.println("Vertex added: " + vertex);
    }

    // Add edge
    public void addEdge(String source, String destination) {
        if (source == null || destination == null ||
            source.trim().isEmpty() || destination.trim().isEmpty()) {
            System.out.println("Error: Source and destination cannot be empty.");
            return;
        }

        source = source.trim();
        destination = destination.trim();

        if (!adjList.containsKey(source)) {
            System.out.println("Error: Source vertex not found: " + source);
            return;
        }

        if (!adjList.containsKey(destination)) {
            System.out.println("Error: Destination vertex not found: " + destination);
            return;
        }

        if (source.equals(destination)) {
            System.out.println("Error: Self-loop is not allowed in this simple graph.");
            return;
        }

        if (adjList.get(source).contains(destination)) {
            System.out.println("Edge already exists.");
            return;
        }

        adjList.get(source).add(destination);

        if (!directed) {
            adjList.get(destination).add(source);
        }

        if (directed) {
            System.out.println("Edge added: " + source + " -> " + destination);
        } else {
            System.out.println("Edge added: " + source + " <-> " + destination);
        }
    }

    // Display graph
    public void displayGraph() {
        if (adjList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\nGraph Adjacency List:");
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");

            if (entry.getValue().isEmpty()) {
                System.out.print("(no edges)");
            } else {
                System.out.print(String.join(", ", entry.getValue()));
            }

            System.out.println();
        }
    }

    // BFS traversal
    public List<String> bfs(String start) {
        List<String> order = new ArrayList<>();

        if (adjList.isEmpty()) {
            System.out.println("Graph is empty. Add vertices and edges first.");
            return order;
        }

        if (start == null || !adjList.containsKey(start.trim())) {
            System.out.println("Start vertex not found: " + start);
            return order;
        }

        start = start.trim();

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return order;
    }

    // DFS traversal
    public List<String> dfs(String start) {
        List<String> order = new ArrayList<>();

        if (adjList.isEmpty()) {
            System.out.println("Graph is empty. Add vertices and edges first.");
            return order;
        }

        if (start == null || !adjList.containsKey(start.trim())) {
            System.out.println("Start vertex not found: " + start);
            return order;
        }

        start = start.trim();

        Set<String> visited = new HashSet<>();
        dfsRecursive(start, visited, order);

        return order;
    }

    private void dfsRecursive(String vertex, Set<String> visited, List<String> order) {
        visited.add(vertex);
        order.add(vertex);

        for (String neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited, order);
            }
        }
    }

    public boolean hasVertex(String vertex) {
        return vertex != null && adjList.containsKey(vertex.trim());
    }

    public boolean isEmpty() {
        return adjList.isEmpty();
    }
}
