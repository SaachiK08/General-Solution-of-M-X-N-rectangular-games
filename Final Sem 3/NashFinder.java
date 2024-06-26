import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NashFinder extends JFrame implements ActionListener {
    private JTextField[][] matrix1_text;
    private JTextField[][] matrix2_text;
    private JTextField[][] result1_text;
    private JTextField[][] result2_text;
    private JButton solve_btn;
    private JLabel result1, result2, matrix1, matrix2;

    NashFinder() {
        setTitle("Nash Finder");
        setLayout(null);
        setSize(450, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupMatrix1();
        setupMatrix2();
        setupButton();
        setupResultMatrix1();
        setupResultMatrix2();
        solve_btn.addActionListener(this);
        setResizable(false);
    }

    private void setupButton() {
        solve_btn = new JButton("Solve");
        solve_btn.setFont(new Font("Arial", Font.PLAIN, 20));
        solve_btn.setBounds(70, 250, 300, 45);
        add(solve_btn);
    }

    private void setupMatrix1() {
        matrix1_text = new JTextField[3][3];
        matrix1 = new JLabel("Player 1");
        matrix1.setBounds(50, 40, 150, 25);
        matrix1.setFont(new Font("Arial", Font.PLAIN, 15));
        add(matrix1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1_text[i][j] = new JTextField();
                matrix1_text[i][j].setBounds(50 + j * 50, 70 + i * 50, 50, 50);
                matrix1_text[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                add(matrix1_text[i][j]);
            }
        }
    }

    private void setupMatrix2() {
        matrix2_text = new JTextField[3][3];
        matrix2 = new JLabel("Player 2");
        matrix2.setBounds(250, 40, 150, 25);
        matrix2.setFont(new Font("Arial", Font.PLAIN, 15));
        add(matrix2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2_text[i][j] = new JTextField();
                matrix2_text[i][j].setBounds(250 + j * 50, 70 + i * 50, 50, 50);
                matrix2_text[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                add(matrix2_text[i][j]);
            }
        }
    }

    private void setupResultMatrix1() {
        result1_text = new JTextField[3][3];
        result1 = new JLabel("Result Player 1");
        result1.setBounds(50, 325, 150, 25);
        result1.setFont(new Font("Arial", Font.PLAIN, 15));
        add(result1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result1_text[i][j] = new JTextField();
                result1_text[i][j].setBounds(50 + j * 50, 350 + i * 50, 50, 50);
                result1_text[i][j].setFont(new Font("Arial", Font.PLAIN, 15));
                result1_text[i][j].setEditable(false);
                add(result1_text[i][j]);
            }
        }
    }

    private void setupResultMatrix2() {
        result2_text = new JTextField[3][3];
        result2 = new JLabel("Result Player 2");
        result2.setBounds(250, 325, 150, 25);
        result2.setFont(new Font("Arial", Font.PLAIN, 15));
        add(result2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result2_text[i][j] = new JTextField();
                result2_text[i][j].setBounds(250 + j * 50, 350 + i * 50, 50, 50);
                result2_text[i][j].setFont(new Font("Arial", Font.PLAIN, 15));
                result2_text[i][j].setEditable(false);
                add(result2_text[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == solve_btn) {
            Nash nash = new Nash();
            float[][] matrixplayer1 = new float[3][3];
            float[][] matrixplayer2 = new float[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrixplayer1[i][j] = Float.parseFloat(matrix1_text[i][j].getText());
                    matrixplayer2[i][j] = Float.parseFloat(matrix2_text[i][j].getText());
                }
            }

            float[][][] equilibrium = nash.solvingMatrix(matrixplayer1, matrixplayer2);
            displayResult(equilibrium[0], result1_text);
            displayResult(equilibrium[1], result2_text);
        }
    }

    private void displayResult(float[][] result, JTextField[][] resultField) {
        if (result.length == 3 && result[0].length == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    resultField[i][j].setText(String.format("%.3f", result[i][j]));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NashFinder nash = new NashFinder();
        });
    }

    public JTextField[][] getMatrix1_text() {
        return matrix1_text;
    }

    public void setMatrix1_text(JTextField[][] matrix1_text) {
        this.matrix1_text = matrix1_text;
    }

    public JTextField[][] getMatrix2_text() {
        return matrix2_text;
    }

    public void setMatrix2_text(JTextField[][] matrix2_text) {
        this.matrix2_text = matrix2_text;
    }

    public JTextField[][] getResult1_text() {
        return result1_text;
    }

    public void setResult1_text(JTextField[][] result1_text) {
        this.result1_text = result1_text;
    }

    public JTextField[][] getResult2_text() {
        return result2_text;
    }

    public void setResult2_text(JTextField[][] result2_text) {
        this.result2_text = result2_text;
    }

    public JButton getSolve_btn() {
        return solve_btn;
    }

    public void setSolve_btn(JButton solve_btn) {
        this.solve_btn = solve_btn;
    }

    public JLabel getResult1() {
        return result1;
    }

    public void setResult1(JLabel result1) {
        this.result1 = result1;
    }

    public JLabel getResult2() {
        return result2;
    }

    public void setResult2(JLabel result2) {
        this.result2 = result2;
    }

    public JLabel getMatrix1() {
        return matrix1;
    }

    public void setMatrix1(JLabel matrix1) {
        this.matrix1 = matrix1;
    }

    public JLabel getMatrix2() {
        return matrix2;
    }

    public void setMatrix2(JLabel matrix2) {
        this.matrix2 = matrix2;
    }
}