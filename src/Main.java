class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            checkInput("");  // Створення виняткової ситуації
        } catch (InvalidInputException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        try {
            Thread thread = new Thread(new Task());
            thread.start();
            thread.interrupt(); // Перериваємо потік
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void checkInput(String input) throws InvalidInputException {
        if (input.isEmpty()) {
            throw new InvalidInputException("Input cannot be empty!");
        }
        System.out.println("Input is valid: " + input);
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    static class Task implements Runnable {
        public void run() {
            try {
                Thread.sleep(5000); // Потік засинає на 5 секунд
            } catch (InterruptedException e) {
                System.out.println("Caught InterruptedException: " + e.getMessage());
            }
        }
    }
}
