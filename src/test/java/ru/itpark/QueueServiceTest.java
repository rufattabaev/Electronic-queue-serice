package ru.itpark;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueServiceTest {

    private static Queue queue;
    private static QueueService queueService;

    @BeforeAll
    static void initQueue() {
        queueService = new QueueService();

        queue = new Queue();
        addElements(queue, 5);
        int i = 0;
    }

    private static void addElements(Queue queue, int amountOfElements) {
        for (int i = 0; i < amountOfElements; i++) {
            queueService.addNext(new Person("Клиент № " + i), queue);
        }
    }

    @Test
    @DisplayName("Should add next client in queue and increase queue length")
    void addNext() {
        int startQueueSize = QueueService.checkQueueSize(queue);
        queueService.addNext(new Person("Клиент №"), queue);
        int endQueueSize = QueueService.checkQueueSize(queue);
       assertEquals(startQueueSize, endQueueSize-1);

    }


    @Test
    @DisplayName("Should delete first client from queue and decrease queue length")
    void deleteFirst() {
        int startQueueSize = QueueService.checkQueueSize(queue);
        queueService.deleteFirst(queue);
        int endQueueSize = QueueService.checkQueueSize(queue);
        assertEquals(startQueueSize-1, endQueueSize);

    }


    @Test
    void findQueueSize() {
        Queue queue = new Queue();
        int expectedQueueSize = 4;
        addElements(queue, expectedQueueSize);
        int actualQueueSize = QueueService.checkQueueSize(queue);
        assertEquals(expectedQueueSize, actualQueueSize);

    }
}