package ru.itpark;

public class QueueService {

    private QueueElement first;

    private void writeNext(QueueElement next, Person person) {

        if (next.getPerson() == null) {
            next.setPerson(person);
        } else {
            QueueElement next1 = next.getNext();
            writeNext(next1, person);
        }

    }


    public void addNext(Person person) {
        if (first == null) {
            first = new QueueElement(person);
        } else {
            writeNext(first.getNext(), person);
        }
    }


    public void deleteFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }


    public int checkQueueSize() {
        QueueElement element = first;
        int queueSize = 0;
        while (element.getPerson() != null) {
            queueSize++;
            element = element.getNext();

        }
        return queueSize;
    }
}

