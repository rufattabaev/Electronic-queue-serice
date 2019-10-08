package ru.itpark;

public class QueueElement {
    private Person person;
    private QueueElement next;

    public QueueElement(Person person) {
        this.person = person;
        next = new QueueElement();
    }

    public QueueElement() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public QueueElement getNext() {
        if (next == null) {
            next = new QueueElement();
            return next;
        }
        return next;
    }
}
