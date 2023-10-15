package org.example.graphVisualiser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GraphUI {
    private JFrame frame;
    private Graph graph;
    private JPanel panel;

    private Image catImage;
    private Map<Main.Animal, Point> vertexLocations = new HashMap<>();

    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw vertices and edges
            drawGraph(g);
        }
    }
    private void drawGraph(Graphics g) {
        if (vertexLocations.isEmpty()) {
            Set<Main.Animal> vertices = graph.getVertices();
            for (Main.Animal vertex: vertices) {

                int x = (int)(Math.random()*(frame.getWidth()-15));
                int y = (int)(Math.random()*(frame.getHeight()-15));
                Point p = new Point(x, y);
                vertexLocations.put(vertex, p);

            }
        }
        // Draw
        for (Main.Animal vertex1: vertexLocations.keySet()) {
            for (Main.Animal vertex2: graph.getAdjacentVertices(vertex1)) {
                Point p1 = vertexLocations.get(vertex1);
                Point p2 = vertexLocations.get(vertex2);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        for (Map.Entry<Main.Animal, Point> pointEntry : vertexLocations.entrySet()) {
            Point p = pointEntry.getValue();
            if (pointEntry.getKey() instanceof Main.Cat) {
                g.drawImage(catImage, p.x-15, p.y-15, 30, 30, null);
            } else {
                g.fillOval(p.x - 5, p.y - 5, 10, 10);
            }
            g.drawString(pointEntry.getKey().name, p.x, p.y);
        }

    }
    public GraphUI(Graph graph) throws IOException {
        this.graph = graph;
        frame = new JFrame("Graph Visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            catImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/cat.png")));
        } catch (IOException e) {
            System.out.println(e);
        }
        frame.setSize(600, 400);
        panel = new DrawingPanel();
        frame.add(panel);
    }
    public void show() {
        frame.setVisible(true);
    }
}
