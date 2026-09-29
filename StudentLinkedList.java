public class StudentLinkedList {

    private StudentNode head;

    // Constructor
    public StudentLinkedList() {
        head = null;
    }

    // Add Student
    public boolean addStudent(Student student) {

        // Check duplicate Student ID
        if (studentExists(student.getStudentId())) {
            return false;
        }

        StudentNode newNode = new StudentNode(student);

        // If list is empty
        if (head == null) {
            head = newNode;
            return true;
        }

        // Go to the last node
        StudentNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        // Add new student at the end
        current.next = newNode;

        return true;
    }

    // Check whether Student ID already exists
    public boolean studentExists(int studentId) {

        StudentNode current = head;

        while (current != null) {

            if (current.data.getStudentId() == studentId) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Update Student
    public boolean updateStudent(
            int studentId,
            String name,
            String programme,
            double marks) {

        StudentNode current = head;

        while (current != null) {

            if (current.data.getStudentId() == studentId) {

                current.data.setName(name);
                current.data.setProgramme(programme);
                current.data.setMarks(marks);

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Delete Student
    public boolean deleteStudent(int studentId) {

        // Empty list
        if (head == null) {
            return false;
        }

        // Delete first node
        if (head.data.getStudentId() == studentId) {
            head = head.next;
            return true;
        }

        StudentNode current = head;

        while (current.next != null) {

            if (current.next.data.getStudentId() == studentId) {

                current.next = current.next.next;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display All Students
    public void displayAllStudents() {

        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode current = head;

        System.out.println("\n========== ALL STUDENTS ==========");

        while (current != null) {

            System.out.println(current.data);

            current = current.next;
        }

        System.out.println("==================================");
    }

    // Search Student by ID
    public Student searchStudent(int studentId) {

        StudentNode current = head;

        while (current != null) {

            if (current.data.getStudentId() == studentId) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }
}