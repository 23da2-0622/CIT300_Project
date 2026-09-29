import java.util.LinkedList;

public class Queue {
    private LinkedList<String> requests;

    public Queue() {
        requests = new LinkedList<>();
    }

    // Enqueue - add service request
    public boolean enqueue(String request) {
        if (request == null || request.trim().isEmpty()) {
            return false;
        }
        requests.add(request);
        return true;
    }

    // Dequeue - process next request
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        return requests.removeFirst();
    }

    // Peek - see next request without removing
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return requests.getFirst();
    }

    // Check if empty
    public boolean isEmpty() {
        return requests.isEmpty();
    }

    // Size
    public int size() {
        return requests.size();
    }

    // Display all requests (in order)
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No service requests in queue.");
            return;
        }

        System.out.println("\n--- Service Requests Queue ---");
        int count = 1;
        for (String request : requests) {
            System.out.println(count + ". " + request);
            count++;
        }
    }

    // Clear queue
    public void clear() {
        requests.clear();
    }
}