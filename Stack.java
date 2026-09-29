import java.util.ArrayList;

public class Stack {
    private ArrayList<String> actions;

    public Stack() {
        actions = new ArrayList<>();
    }

    // Push - add new action
    public void push(String action) {
        if (action == null || action.trim().isEmpty()) {
            return;
        }
        actions.add(action);
    }

    // Pop - remove top action
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return actions.remove(actions.size() - 1);
    }

    // Peek - see top action without removing
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return actions.get(actions.size() - 1);
    }

    // Check if empty
    public boolean isEmpty() {
        return actions.isEmpty();
    }

    // Size
    public int size() {
        return actions.size();
    }

    // Display all actions (most recent first)
    public void displayRecentActions() {
        if (isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("\n--- Recent Actions (most recent first) ---");
        for (int i = actions.size() - 1; i >= 0; i--) {
            System.out.println((actions.size() - i) + ". " + actions.get(i));
        }
    }

    // Clear stack
    public void clear() {
        actions.clear();
    }
}