package org.example._3_design_patterns.src.main.java.code._2_challenge.hard._1_decorations;

public class DecorationBulb extends Decoration {
    public DecorationBulb(int positionInTree, DecorableTree christmasTree) {
        super(positionInTree, christmasTree);
    }

    @Override
    public String getDecoration() {
        return "B";
    }
}