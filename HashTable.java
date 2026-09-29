import java.util.HashMap;

class StudentRecord {
    String studentId;
    String name;
    String programme;
    double marks;

    public StudentRecord(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name + " | Programme: " + programme + " | Marks: " + marks;
    }
}

public class HashTable {
    // Java HashMap එක භාවිතයෙන් Hashing ක්‍රියාත්මක කිරීම
    private HashMap<String, StudentRecord> studentTable;

    public HashTable() {
        studentTable = new HashMap<>();
    }

    // Hash table එකට student record එකක් එකතු කිරීම
    public void addStudent(String studentId, String name, String programme, double marks) {
        StudentRecord record = new StudentRecord(studentId, name, programme, marks);
        studentTable.put(studentId, record);
        System.out.println("Student added to Hash Table successfully.");
    }

    // Student ID එක මඟින් ඉක්මනින් search කිරීම
    public void searchStudent(String studentId) {
        if (studentTable.containsKey(studentId)) {
            System.out.println("Student Found: " + studentTable.get(studentId));
        } else {
            System.out.println("Student with ID " + studentId + " not found in Hash Table.");
        }
    }
}
