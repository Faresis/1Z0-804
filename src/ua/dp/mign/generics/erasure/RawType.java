package ua.dp.mign.generics.erasure;

class Node <T> {
    T entity;
    public Node(T entity) { this.entity = entity; }
    public void setEntity(T entity) {
        System.out.println("Node.setEntity");
        this.entity = entity;
    }
    public void printEntity() {
        System.out.println("Entity is: " + entity);
    }
}

class IntNode extends Node<Integer> {
    public IntNode(Integer data) { super(data); }
    public void setEntity(Integer entity) {
        System.out.println("IntNode.setEntity");
        super.setEntity(entity);
    }
}

class RawType {
    public static void main(String[] args) {

        IntNode in = new IntNode(8);
        in.printEntity(); // entity is 8

        Node n = in;
        n.entity = "Hello";
        n.printEntity(); // entity is able to store "Hello" because of type erasure

        // Will cause ClassCastException because IntNode link is used
        Integer data = in.entity; 

        /*
         * This one will cause a ClassCastException because of Bridge Methods
         * functionality. It seems that Node.setEntity(Object entity) should
         * be called in this line. But compiler generates appropriate
         * IntNode.setEntity(Object entity) method to preserve polymorphic
         * behavior which in turn will call IntNode.setEntity(Integer entity)
         * which will cause a ClassCastException.
         */
        //n.setEntity("World");
    }
}
