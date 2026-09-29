class TreeNode {
    String studentId;
    String name;
    String programme;
    double marks;
    TreeNode left, right;

    public TreeNode(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
        left = right = null;
    }
}

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    // Tree එකට Student Record එකක් ඇතුළත් කිරීම
    public void insert(String studentId, String name, String programme, double marks) {
        root = insertRec(root, studentId, name, programme, marks);
    }

    private TreeNode insertRec(TreeNode root, String studentId, String name, String programme, double marks) {
        if (root == null) {
            return new TreeNode(studentId, name, programme, marks);
        }
        // Student ID එක අනුව අකාරාදී පිළිවෙළට හෝ සංඛ්‍යාත්මකව සැසඳීම
        if (studentId.compareTo(root.studentId) < 0) {
            root.left = insertRec(root.left, studentId, name, programme, marks);
        } else if (studentId.compareTo(root.studentId) > 0) {
            root.right = insertRec(root.right, studentId, name, programme, marks);
        }
        return root;
    }

    // In-order traversal මඟින් Students ලව පෙන්වීම (Sorted order)
    public void inorder() {
        System.out.println("\n--- Students Sorted by ID (BST) ---");
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("ID: " + root.studentId + " | Name: " + root.name + " | Programme: " + root.programme + " | Marks: " + root.marks);
            inorderRec(root.right);
        }
    }
}