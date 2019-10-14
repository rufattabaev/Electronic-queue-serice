package ru.itpark;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueServiceTest {

    private static QueueService queueService;

    @BeforeAll
    static void initQueue() {
        queueService = new QueueService();

        addElements(5);
    }

    private static void addElements(int amountOfElements) {
        for (int i = 0; i < amountOfElements; i++) {
            queueService.addNext(new Person("Клиент № " + i));
        }
    }

    @Test
    @DisplayName("Should add next client in queue and increase queue length")
    void addNext() {
        int startQueueSize = queueService.checkQueueSize();
        queueService.addNext(new Person("Клиент №"));
        int endQueueSize = queueService.checkQueueSize();
        assertEquals(startQueueSize, endQueueSize - 1);

    }


    @Test
    @DisplayName("Should delete first client from queue and decrease queue length")
    void deleteFirst() {
        int startQueueSize = queueService.checkQueueSize();
        queueService.deleteFirst();
        int endQueueSize = queueService.checkQueueSize();
        assertEquals(startQueueSize - 1, endQueueSize);

    }


    @Test
    void findQueueSize() {
        int expectedQueueSize = 5;
        int actualQueueSize = queueService.checkQueueSize();
        assertEquals(expectedQueueSize, actualQueueSize);

    }
}