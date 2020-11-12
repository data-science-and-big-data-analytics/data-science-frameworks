# Colibri

## In this folder you will find: 
- `colibri/` folder: For convienence, the entire source code of Colibri is already included in this Git-Repository 
- `doc/` folder: You will find the documentation of this source code, provided together with the source code in this folder
- `ColibriExample.java`: A provided example file, which you can execute and inspect

For this framework you don't have to download anything. But you can find all the ressources online, too. 



# A. General Information
- Authors
  - Daniel Götzmann
- Paper: 
  - ./doc/lindig-paper.pdf
  - ./doc/goetzmann-thesis.pdf
  - ./doc/goetzmann-fca-final.pdf
- Code: 
  - ./colibri/
  - https://storage.googleapis.com/google-code-archive-source/v2/code.google.com/colibri-java/source-archive.zip 
- Wiki: 
  - https://code.google.com/archive/p/colibri-java/wikis/HowTo.wiki



# B. Requirements
 - Java



# C. and D. Installation and Data
For this framework you don't have to install anything. 

Instead of provided example data, it is only explained how to use this framework 
There is an example Java file given in the repository: `ColibriExample.java`



# E. Usage 
Import library: 
```java
import colibri.lib.*;
```

Create an empty Relation `rel` and add pairs of `(some_object, some_attribute)` to the Relation `rel`:
```java
Relation rel = new TreeRelation();
rel.add(some_object, some_attribute);
...
```

When the Relation `rel` is complete, generate Lattice `lattice`:
```java
Lattice lattice = new HybridLattice(rel);
```

## Methods on the lattice:
```java
// Get the top concept
Concept top = lattice.top();
// Get the bottom concept
Concept bottom = lattice.bottom();

// Get the concept of an object list
Concept fromObjects = lattice.conceptFromObjects(Collection objects);
// Get the concept of an attribute list
Concept fromAttributes = lattice.conceptFromAttributes(Collection attributes);

// Iterate through the lower concepts of on concept
Iterator<Concept> lowerIt = lattice.lowerNeighbors(Concept c);
// Iterate through the upper concepts of on concept
Iterator<Concept> upperIt = lattice.upperNeighbors(Concept c);

// Iterate through all concepts of the lattice in traversal order trav
Iterator<Concept> it = lattice.conceptIterator(Traversal trav);
```

## Methods on a Concept:
```java
// Get the objects of a concept
ComparableSet objects = concept.getObjects();
// Get the attributes of a concept
ComparableSet attributes = concept.getAttributes();
```




# E. Run Example
```bash
# Compile the java file
$ javac ColibriExample.java

# Run the java class
$ java ColibriExample
```

You can view the `ColibriExample.java` file to better understand how the library can be used. 
