import java.util.List;
import java.util.Scanner;

public class GraphMenu {

    public static void show(Scanner sc, Graph graph) {
        int choice;

        do {
            System.out.println("\nGRAPH OPERATIONS");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex name: ");
                    graph.addVertex(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter source vertex: ");
                    String source = sc.nextLine();

                    System.out.print("Enter destination vertex: ");
                    String destination = sc.nextLine();

                    graph.addEdge(source, destination);
                    break;

                case 3:
                    graph.displayGraph();
                    break;

                case 4:
                    System.out.print("Enter starting vertex for BFS: ");
                    List<String> bfsOrder = graph.bfs(sc.nextLine());

                    if (!bfsOrder.isEmpty()) {
                        System.out.println("BFS Traversal: " + String.join(" -> ", bfsOrder));
                        System.out.println("Vertices visited: " + bfsOrder.size());
                    }
                    break;

                case 5:
                    System.out.print("Enter starting vertex for DFS: ");
                    List<String> dfsOrder = graph.dfs(sc.nextLine());

                    if (!dfsOrder.isEmpty()) {
                        System.out.println("DFS Traversal: " + String.join(" -> ", dfsOrder));
                        System.out.println("Vertices visited: " + dfsOrder.size());
                    }
                    break;

                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-6.");
            }

        } while (choice != 6);
    }
}
