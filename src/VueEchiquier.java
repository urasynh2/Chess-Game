import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class VueEchiquier extends JPanel{
    private Echiquier echiquier;

    private int tailleCase = 75;

    private JFrame frame;

    Image brick;

    private JPanel panel;
    private final int width = 640,height = 640;


    public VueEchiquier(Echiquier echiquier){
        this.echiquier = echiquier;

        JFrame frame = new JFrame("Echec");
        this.frame = frame;

        setPreferredSize(new Dimension(width,height));

        setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int x= 0; x<8; x++ ) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, x * tailleCase+20, 20, tailleCase);
            g.fillRect(620, x * tailleCase+20, 20, tailleCase);

            g.fillRect(x*tailleCase+20 ,0, tailleCase, 20);
            g.fillRect(x*tailleCase+20 ,620, tailleCase, 20);

            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(8-x), 10, (x * tailleCase)+57);
            g.drawString(Integer.toString(8-x), 630, (x * tailleCase)+57);

            g.drawString(String.valueOf((char)((int)'A'+x )),(x*tailleCase)+57, 10);
            g.drawString(String.valueOf((char)((int)'A'+x )),(x*tailleCase)+57, 630);
        }
        for(int i= 0; i<8; i++ ) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i*tailleCase+20,j*tailleCase+20,tailleCase,tailleCase);
            }
        }

        try {
            brick = ImageIO.read(new File("chess.png"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        g.drawImage(brick, 1 * tailleCase, 0 * tailleCase, tailleCase, tailleCase, this);


    }

}
