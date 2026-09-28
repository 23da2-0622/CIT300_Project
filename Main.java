import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        int choice;

        do {
            System.out.println("\n===== Campus Graph Menu =====");
            System.out.println("1. Add Campus Location");
            System.out.println("2. Remove Campus Location");
            System.out.println("3. Add Campus Connection/Road");
            System.out.println("4. Remove Campus Connection/Road");
            System.out.println("5. Display Campus Connections");
            System.out.println("6. BFS Traversal");
            System.out.println("7. DFS Traversal");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter campus location: ");
                    String loc = sc.nextLine().trim();
                    if (graph.addLocation(loc)) {
                        System.out.println("Location added successfully.");
                    } else {
                        System.out.println("Invalid or duplicate location.");
                    }
                    break;

                case 2:
                    System.out.print("Enter location to remove: ");
                    String removeLoc = sc.nextLine().trim();
                    if (graph.removeLocation(removeLoc)) {
                        System.out.println("Location removed successfully.");
                    } else {
                        System.out.println("Location not found.");
                    }
                    break;

                case 3:
                    System.out.print("From location: ");
                    String from = sc.nextLine().trim();
                    System.out.print("To location: ");
                    String to = sc.nextLine().trim();
                    if (graph.addConnection(from, to)) {
                        System.out.println("Connection added successfully.");
                    } else {
                        System.out.println("Invalid or duplicate connection.");
                    }
                    break;

                case 4:
                    System.out.print("From location: ");
                    String rFrom = sc.nextLine().trim();
                    System.out.print("To location: ");
                    String rTo = sc.nextLine().trim();
                    if (graph.removeConnection(rFrom, rTo)) {
                        System.out.println("Connection removed successfully.");
                    } else {
                        System.out.println("Connection not found.");
                    }
                    break;

                case 5:
                    graph.displayConnections();
                    break;

                case 6:
                    System.out.print("Start location for BFS: ");
                    String bfsStart = sc.nextLine().trim();
                    graph.bfs(bfsStart);
                    break;

                case 7:
                    System.out.print("Start location for DFS: ");
                    String dfsStart = sc.nextLine().trim();
                    graph.dfs(dfsStart);
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}