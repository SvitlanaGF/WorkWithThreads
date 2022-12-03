
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        PictureThread pictureThread = new PictureThread();
        RunningStringThread runningStringThread = new RunningStringThread();

        pictureThread.run();

        runningStringThread.run();

    }
}

class PictureThread extends Thread{
    @Override
    public void run() {
        BallFrame ballFrame = new BallFrame(200,200,0);
        ballFrame.setSize(400,400);
        ballFrame.setVisible(true);
        ballFrame.setTitle("Ball");
    }
}

class CalculationThread extends Thread{
    @Override
    public void run() {
        System.out.println("2");

    }
}

class RunningStringThread extends Thread{
    @Override
    public void run() {
        pause(5000);
        JFrame frame = new JFrame("Text");
        frame.setSize(300, 300);
        JLabel label = new JLabel("The original name for Java was Oak. Java legend has it that a big oak tree that grew outside the developer James Gosling’s window.");
        frame.add(label);
        frame.setVisible(true);
        final int labelWidth = 300;
        final AtomicInteger labelPadding = new AtomicInteger();
        Timer timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setBorder(new EmptyBorder(0, labelPadding.getAndIncrement() % labelWidth, 0, 0));
            }
        });
        timer.start();
    }
    public void pause(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
