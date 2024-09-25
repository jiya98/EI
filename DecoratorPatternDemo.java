interface Task {
    void execute();
}

class BasicTask implements Task {
    @Override
    public void execute() {
        System.out.println("Executing basic task.");
    }
}

class TaskDecorator implements Task {
    protected Task decoratedTask;

    public TaskDecorator(Task decoratedTask) {
        this.decoratedTask = decoratedTask;
    }

    @Override
    public void execute() {
        decoratedTask.execute();
    }
}

class LoggingTaskDecorator extends TaskDecorator {
    public LoggingTaskDecorator(Task decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public void execute() {
        System.out.println("Logging task execution.");
        super.execute();
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Task basicTask = new BasicTask();
        Task loggingTask = new LoggingTaskDecorator(basicTask);
        loggingTask.execute();
    }
}
