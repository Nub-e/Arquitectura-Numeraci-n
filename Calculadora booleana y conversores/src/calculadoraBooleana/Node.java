package calculadoraBooleana;

/**
 * @author Marck Hernández
 */
class Node {
    String value;
    Node left, right;

    Node(String value) {
        this.value = value;
    }

    Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    
    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }
    
    
}

