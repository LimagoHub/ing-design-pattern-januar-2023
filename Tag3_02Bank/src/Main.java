import de.composite.AbstractBankNode;
import de.composite.Konto;
import de.composite.KontoGruppe;
import de.composite.visitor.PrintVisitor;

public class Main {
    public static void main(String[] args) {

        KontoGruppe root = new KontoGruppe("Root");

        KontoGruppe e1 = new KontoGruppe("E1");
        root.append(e1);


        KontoGruppe e2 = new KontoGruppe("E2");
        root.append(e2);

        KontoGruppe e1_1 = new KontoGruppe("E1_1");
        e1.append(e1_1);

        Konto e1_2 = new Konto("E1_2", 1000);
        e1.append(e1_2);

        Konto e1_3 = new Konto("E1_3",2000);
        e1.append(e1_3);

        Konto e1_4 = new Konto("E1_4", 1000);
        e1.append(e1_4);

        Konto e1_5 = new Konto("E1_5",2000);
        e1.append(e1_5);


        //root.print();
        root.iterate(new PrintVisitor());
    }


}