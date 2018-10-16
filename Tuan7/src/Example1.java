public class Example1 {

    // In thông điệp kèm tên thread đã gọi hàm này
    static void printMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    // Static để không phải tạo đối tượng Example1 mới
    private static class MessageLoop implements Runnable {
        public void run() {
            String task[] = {"Việc 1", "Việc 2", "Việc 3", "Việc 4"};
            try {
                for (int i = 0; i < task.length; i++) {
                    // Dừng 1 giây
                    Thread.sleep(2000);
                    // Hiển thị việc đang làm
                    printMessage(task[i]);
                }
            } catch (InterruptedException e) {
                printMessage("Đang làm dở!");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        // Thời gian chờ tối đa
        long patience = 7000;

        printMessage("Bắt đầu làm việc");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        printMessage("Đang chờ đến khi làm xong");
        // Lặp đến khi dừng thread
        // t.isAlive(): Kiểm tra thread còn sống hay không?
        while (t.isAlive()) {
            printMessage("Đang tiếp tục chờ...");
            // Ngừng mọi hoạt động của hàm main trong 1 giây để chờ thread chạy xong
            t.join(1000);
			// Sau 1 giây, kiểm tra xem đã đạt đến thời gian chờ tối đa chưa và thread còn chạy không
			// Nếu cả 2 điều kiện đều đúng thì dừng thread
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                printMessage("Lâu quá không chờ nữa!");
                t.interrupt();
                // Chờ đến khi thread dừng hẳn
                t.join();
            }
        }
        printMessage("Cuối cùng cũng xong!");
    }
}