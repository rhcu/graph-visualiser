package org.example.graphVisualiser;

import java.io.IOException;

public class Main {
    public static class Animal {
        public String name;
        public Animal(String name) {
            this.name = name;
        }
    }
    public static class Human extends Animal {

        public Human(String name) {
            super(name);
        }
    }
    public static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }
    }
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        Human asya = new Main.Human("Asya");
        Human aidoka = new Main.Human("Aidoka");
        Cat tigrenok = new Cat("Tigrenok");
        Cat chernysh = new Cat("Chernysh");
        Cat tommy = new Cat("Tommy");
        Cat hermione = new Cat("Hermione");
        graph.addVertex(asya);
        graph.addVertex(aidoka);
        graph.addVertex(tigrenok);
        graph.addEdge(asya, tigrenok);
        graph.addEdge(asya, aidoka);
        graph.addEdge(tigrenok, aidoka);
        graph.addVertex(chernysh);
        graph.addEdge(asya, chernysh);

        graph.addVertex(tommy);
        graph.addEdge(aidoka, tommy);
        graph.addVertex(hermione);
        graph.addEdge(aidoka, hermione);

        GraphUI ui = new GraphUI(graph);
        ui.show();
    }
}
