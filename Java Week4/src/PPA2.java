import java.util.Scanner;

class Voter {
    private static Voter new_voter;
    public static int total_no_of_voters;
    private static int current_voter_count = 0;

    private Voter() {
        current_voter_count++;
    }

    public static Voter getVoter() {
        // if (new_voter == null && current_voter_count < total_no_of_voters) {
        if (new_voter == null){
            new_voter = new Voter();
            return new_voter;
        }
        else
            return null;
        // return new_voter;
    }

    public void firstVoter() {
        if (new_voter != null) {
            EVM new_machine = EVM.getEVM(new_voter);
            new_machine.startVoting();
        }
    }

    public void callNewVoter() {
        new_voter = getVoter();
        if (new_voter != null) {
            EVM new_machine = EVM.getEVM(new_voter);
            new_machine.startVoting();
        }
    }
}

class EVM {
    private static EVM machine;
    private static int evm_count = 0;
    private Voter current_voter;

    private EVM(Voter v) {
        current_voter = v;
        evm_count++;
    }

    public static EVM getEVM(Voter v) {
        if (machine == null) {
            machine = new EVM(v);
            return machine;
        }
        else
            return null;
    }

    public void startVoting() {
        System.out.println("voting under process on EVM number " + evm_count);
        System.out.println("Voting completed for voter " + evm_count);
        machine = null;  // Reset the machine
        current_voter.callNewVoter();  // Call the next voter
    }
}

public class PPA2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Voter.total_no_of_voters = s.nextInt();

        Voter v = Voter.getVoter();

        try {
            Voter x = Voter.getVoter();
            x.callNewVoter();
        } catch (NullPointerException e) {
            System.out.println("Voter is Singleton");
        }

        v.firstVoter();
    }
}
