class Mock_Quiz1_15_Restaurant {
    String[] arr;

    Mock_Quiz1_15_Restaurant(String[] a) {
        arr = a;
    }

    public class Producer {
        String[] buffer;
        Consumer obj;

        Producer() {
            buffer = arr;
        }

        public void produce() {
            if (buffer[0] == null) {
                System.out.println("Consumer has finished consuming");
                return;
            }
            buffer = new String[5];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = "Item" + (i + 1);
            }
            System.out.println("Producer has finished producing");
            new Consumer().consume(buffer);
        }
    }

    public class Consumer {
        public void consume(String[] buffer) {
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = null;
            }
            new Producer().produce();
        }
    }
}

public class Mock_Quiz1_15 {
    public static void main(String args[]) {
        String[] buffer = { "Item 0" };
        Mock_Quiz1_15_Restaurant obj = new Mock_Quiz1_15_Restaurant(buffer);
        Mock_Quiz1_15_Restaurant.Producer p = obj.new Producer();
        p.produce();
    }
}