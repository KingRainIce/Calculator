package Cal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


//借鉴自   https://blog.csdn.net/qq_36659438/article/details/83629120
public class HandDraw extends JPanel
{
    // 当鼠标按下时，记 pressed为 true
    private boolean pressed = false;

    // 存储所有的曲线
    private List<Curve> curveList = new ArrayList<>();

    public HandDraw()
    {
        MyMouseListener l = new MyMouseListener();
        this.addMouseListener(l);
        this.addMouseMotionListener(l);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        //
        int width = this.getWidth();
        int height = this.getHeight();

        g.setColor( new Color(0xFFFFF0));
        g.fillRect(0, 0, width, height);

        g.setColor( new Color(0x555555));
        g.drawRect(0, 0, width-1, height-1);

        //
        for( Curve curve : curveList )
        {
            List<Point> points = curve.points;

            if ( points.size() >= 2 )
            {
                // 设置线条的颜色
                g.setColor( Color.RED );

                // 开始绘制，每个点连接在一起，形成曲线
                Point p1 = points.get(0);

                // for循环从1开始
                for(int i=1; i< points.size(); i++)
                {
                    Point p2 = points.get(i);
                    g.drawLine(p1.x, p1.y , p2.x, p2.y);

                    p1 = p2;
                }
            }
        }

    }


    //
    private class MyMouseListener extends MouseAdapter
    {

        @Override
        public void mousePressed(MouseEvent e)
        {
            // 鼠标按下，记 pressed为true
            pressed = true;

            // 创建一条新的曲线（笔划)
            Curve curve = new Curve();
            curveList.add( curve);

            curve.points.add( e.getPoint() ); // 记录鼠标的坐标
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            // 鼠标松开，记 pressed为false
            pressed = false;
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            if( pressed )
            {
                // 当前的笔划
                Curve curve = curveList.get( curveList.size()-1);
                // 记录鼠标的坐标
                curve.points.add( e.getPoint() );
                // 重新绘制一次
                repaint();
            }
        }

    }

    // Curve代表一条曲线
    private static class Curve
    {
        // 曲线中的所有的轨迹点
        public List<Point> points = new ArrayList<>();
    }
}

