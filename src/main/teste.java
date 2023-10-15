package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teste {
    private JFrame mainFrame;
    private JFrame[] subFrames;
    private int currentFrameIndex;

    public teste() {
        mainFrame = new JFrame("JFrame com JFrames Internos");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);

        subFrames = new JFrame[3];
        currentFrameIndex = 0;

        for (int i = 0; i < subFrames.length; i++) {
            subFrames[i] = new JFrame("JFrame Interno " + (i + 1));
            subFrames[i].setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            subFrames[i].setSize(400, 300);
        }

        // Botões de navegação entre os JFrames internos
        JButton prevButton = new JButton("Anterior");
        JButton nextButton = new JButton("Próximo");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPreviousFrame();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToNextFrame();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        mainFrame.add(buttonPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    private void switchToPreviousFrame() {
        subFrames[currentFrameIndex].setVisible(false);
        currentFrameIndex = (currentFrameIndex - 1 + subFrames.length) % subFrames.length;
        subFrames[currentFrameIndex].setVisible(true);
    }

    private void switchToNextFrame() {
        subFrames[currentFrameIndex].setVisible(false);
        currentFrameIndex = (currentFrameIndex + 1) % subFrames.length;
        subFrames[currentFrameIndex].setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new teste();
            }
        });
    }
}
