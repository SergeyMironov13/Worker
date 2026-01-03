public class Worker {
    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
//        OnTaskDoneListener listener = result -> System.out.println(result);
        Worker worker = new Worker(listener);
        worker.start();
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
}
