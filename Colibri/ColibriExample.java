import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import colibri.lib.*;

/**
 * This is an example class for the Colibri Framework.
 */
public class ColibriExample {

    public static void main(String... args) {

        // Create an initially empty Relation rel:
        Relation rel = new TreeRelation();

        // Add (object,attribute) pairs into the Relation rel
        rel.add("King Arthur", "human");
        rel.add("King Arthur", "knight");
        rel.add("King Arthur", "king");
        rel.add("Sir Robin", "human");
        rel.add("Sir Robin", "knight");
        rel.add("Holy Grail", "mysterious");

        // After rel is complete, generate Lattice lattice from the Relation rel
        Lattice lattice = new HybridLattice(rel);

        // Get the top Concept and their object and attribute from the lattice
        Concept top = lattice.top();
        ComparableSet topObjects = top.getObjects();
        ComparableSet topAttributes = top.getAttributes();
        System.out.println("Top Concept: ");
        System.out.println("objects: " + topObjects);
        System.out.println("attributes: " + topAttributes);
        // System.out.println(top);  // You can also print the concept itself


        System.out.println();


        // Get all Concepts, which are below the top Concept
        Iterator<Concept> lowerNeighborsIterator = lattice.lowerNeighbors(top);
        System.out.println("LowerNeighbors: ");
        while (lowerNeighborsIterator.hasNext()) {
            Concept c = lowerNeighborsIterator.next();
            System.out.println(c);
        }


        System.out.println();


        // Get the Concept from a list of objects
        Collection<Comparable> objects = Arrays.asList("Holy Grail");
        Concept conceptFromObjects = lattice.conceptFromObjects(objects);
        System.out.println("Concepts from the object list [\"Holy Grail\"]: ");
        System.out.println(conceptFromObjects);


        System.out.println();


        // Get the Concept from a list of attributes
        Collection<Comparable> attributes = Arrays.asList("knight", "king");
        System.out.println("Concepts from the attribute list [\"knight\", \"king\"]: ");
        Concept conceptFromAttributes = lattice.conceptFromAttributes(attributes); 
        System.out.println(conceptFromAttributes);


        System.out.println();


        // Iterate through all Concepts of the lattice
        // The traversal method is defined with Traversal.XXX
        Iterator<Concept> it = lattice.conceptIterator(Traversal.TOP_OBJSIZE);
        System.out.println("Concepts from Top to Down: ");
        while (it.hasNext()) {
            Concept c = it.next();
            System.out.println(c);
        }

    }

}
