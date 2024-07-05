package src;

import java.sql.*;

public class CRUDExample {

    // JDBC URL, username and password of SQLite database
    private static final String URL = "jdbc:sqlite:students.db";

    public static void main(String[] args) {
        try {
            // Explicitly load the SQLite JDBC driver to ensure it is available
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found: " + e.getMessage());
            return;
        }
    
        // Initialize database (create table if not exists)
        initializeDatabase();
    
        // Insert example data
        Student student1 = new Student(1, "John Doe", "john@example.com");
        insertStudent(student1);
    
        // Retrieve and print all students
        System.out.println("List of students:");
        getAllStudents();
    
        // Update example data
        Student studentToUpdate = new Student(1, "John Updated", "john.updated@example.com");
        updateStudent(studentToUpdate);
    
        // Retrieve and print all students after update
        System.out.println("List of students after update:");
        getAllStudents();
    
        // Delete example data
        deleteStudent(1);
    
        // Retrieve and print all students after delete
        System.out.println("List of students after delete:");
        getAllStudents();
    }

    private static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                     "    id INTEGER PRIMARY KEY," +
                     "    name TEXT NOT NULL," +
                     "    email TEXT NOT NULL" +
                     ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created (if not exists).");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    private static void insertStudent(Student student) {
        String sql = "INSERT INTO students(id, name, email) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }

    private static void getAllStudents() {
        String sql = "SELECT id, name, email FROM students";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }

    private static void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, student.getId());
            pstmt.executeUpdate();
            System.out.println("Student updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    private static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    // Student class representing the entity
    static class Student {
        private int id;
        private String name;
        private String email;

        public Student(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }
}