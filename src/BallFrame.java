import java.awt.*;

class BallFrame extends Frame implements Runnable {
    int xOrigin;
    int yOrigin;
    int radius = 100;
    int ballRadius = 20;
    double currentAngle;
    Thread thread;

    public BallFrame(int xOrigin, int yOrigin, double initialAngle) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.currentAngle = initialAngle;
        this.setBackground(Color.BLACK);

        thread = new Thread(this, "Rotating Ball");
        thread.start();
    }

    @Override
    public void run() {
        while(true){

            currentAngle+=2;
            this.repaint();
            try {
                Thread.sleep(100);
            }catch (InterruptedException ie){
                System.out.println(ie.getMessage());
            }
        }
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.drawOval(xOrigin-radius,yOrigin-radius,radius*2,radius*2);
        int ballOriginX;
        int ballOriginY;
        ballOriginX=(int)(radius* Math.cos(currentAngle* Math.PI/180));
        ballOriginY=(int)(radius* Math.sin(currentAngle* Math.PI/180));
        g.setColor(Color.ORANGE);
        g.fillOval(xOrigin+ballOriginX-ballRadius, yOrigin+ballOriginY-ballRadius,ballRadius*2,ballRadius*2);
    }

}