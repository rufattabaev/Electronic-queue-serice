package ru.itpark;

public class QueueService {



    private void writeNext(QueueElement next, Person person) {

        if (next.getPerson() == null) {
            next.setPerson(person);
        } else {
            QueueElement next1 = next.getNext();
            writeNext(next1, person);
        }

    }


    public void addNext(Person person, Queue queue) {
        if (queue.getFirst() == null) {
            queue.setFirst(new QueueElement(person));
        } else {
            writeNext(queue.getFirst().getNext(), person);
        }
    }


    public void deleteFirst(Queue queue) {

        QueueElement first = queue.getFirst();
        queue.setFirst(first.getNext());

    }



    public static int checkQueueSize(Queue queue) {
        QueueElement element = queue.getFirst();
        int queueSize = 0;
        while (element.getPerson() != null) {
            queueSize++;
            element = element.getNext();

        }
        return queueSize;
    }
}

