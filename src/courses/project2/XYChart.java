package courses.project2;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class XYChart extends JFrame {
    private List<Point> dataPoints;

    public XYChart() {
        setTitle("XY坐标图");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        dataPoints = new ArrayList<>();
        dataPoints.add(new Point(1, 2));
        dataPoints.add(new Point(2, 4));
        dataPoints.add(new Point(3, 1));
        dataPoints.add(new Point(4, 5));
        dataPoints.add(new Point(5, 3));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawXYChart(g);
    }

    private void drawXYChart(Graphics g) {
        int padding = 20;
        int width = getWidth();
        int height = getHeight();
        int xScale = (width - 2 * padding) / (dataPoints.size());
        int yScale = (height - 2 * padding) / (getMaxY() - getMinY());

        // 绘制X坐标轴
        g.drawLine(padding, height - padding, width - padding, height - padding);
        // 绘制Y坐标轴
        g.drawLine(padding, height - padding, padding, padding);

        // 绘制数据点和连接线
        g.setColor(Color.BLUE);
        for (int i = 0; i < dataPoints.size(); i++) {
            int x1 = padding + i * xScale;
            int y1 = height - padding - (dataPoints.get(i).y - getMinY()) * yScale;
            g.fillOval(x1 - 5, y1 - 5, 10, 10);
            if (i > 0) {
                int x2 = padding + (i - 1) * xScale;
                int y2 = height - padding - (dataPoints.get(i - 1).y - getMinY()) * yScale;
                g.drawLine(x1, y1, x2, y2);
            }
        }
    }

    private int getMaxY() {
        int maxY = Integer.MIN_VALUE;
        for (Point point : dataPoints) {
            if (point.y > maxY) {
                maxY = point.y;
            }
        }
        return maxY;
    }

    private int getMinY() {
        int minY = Integer.MAX_VALUE;
        for (Point point : dataPoints) {
            if (point.y < minY) {
                minY = point.y;
            }
        }
        return minY;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            XYChart xyChart = new XYChart();
            xyChart.setVisible(true);
        });
    }
}

