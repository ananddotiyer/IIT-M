class AgeLimitException extends Exception {
    public AgeLimitException() {
        System.out.println("Age should be atleast 18");
    }
}

public class Quiz2_157 {
    public static void castVote(int age) throws AgeLimitException {
        if (age < 18)
            throw new AgeLimitException();

        System.out.println("Voted successfully");
    }

    public static void main(String[] args) {
        try {
            castVote(10);
            castVote(20);
        } catch (AgeLimitException ae) {
            System.out.println("Cannot vote");
        } catch (Exception e) {
        }
    }
}
