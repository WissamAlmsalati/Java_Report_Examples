// Multithreading Example
public class MultithreadingExample {
    
    // Example Runnable task
    static class Task implements Runnable {
        private String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println("Task '" + taskName + "' is running on thread: " + Thread.currentThread().getName());
            // Simulate some task execution
            try {
                Thread.sleep(2000); // Simulating work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task '" + taskName + "' completed.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Main thread started.");
        
        // Create and start threads
        Thread thread1 = new Thread(new Task("Task 1"));
        Thread thread2 = new Thread(new Task("Task 2"));

        thread1.start();
        thread2.start();

        // Main thread continues execution
        System.out.println("Main thread completed.");
    }
}