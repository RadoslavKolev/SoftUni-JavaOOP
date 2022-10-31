package lection.p02_OpenClosedPrinciple.p02_DrawingShape;

import lection.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import lection.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {
    @Override
    public void draw(Shape shape) {
        shape.drawFigure();
    }
}
