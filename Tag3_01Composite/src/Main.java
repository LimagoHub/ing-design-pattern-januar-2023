import de.composite.AbstractNode;
import de.composite.Leaf;
import de.composite.Node;

public class Main {
    public static void main(String[] args) {

        Node root = new Node("Root");

        Node e1 = new Node("E1");
        root.append(e1);

        Node e2 = new Node("E2");
        root.append(e2);

        Node e1_1 = new Node("E1_1");
        e1.append(e1_1);

        Leaf e1_2 = new Leaf("E1_2");
        e1.append(e1_2);

        travers(root);
    }

    static void travers(AbstractNode node) {
        System.out.println(node);
        for (AbstractNode child: node.getChildren()) {
            travers(child);
        }
    }
}