import java.awt.*;
import java.awt.event.*;

class NashAwtGui extends Frame implements ActionListener {
    TextField[][] matrix1_text;
    TextField[][] matrix2_text;
    TextField[][] result1_text;
    TextField[][] result2_text;
    Button solve_btn;
    Label result1, result2, matrix1, matrix2;

    NashAwtGui() {
        setTitle("Nash Finder");
        setLayout(null);
        setSize(450, 600);
        setVisible(true);
        setupMatrix1();
        setupMatrix2();
        setupButton();
        setupResultMatrix1();
        setupResultMatrix2();
        solve_btn.addActionListener(this);
    }

    void setupButton() {
        solve_btn = new Button("Solve");
        solve_btn.setFont(new Font("Arial", Font.PLAIN, 20));
        solve_btn.setBounds(70, 250, 300, 45);
        add(solve_btn);
    }

    void setupMatrix1() {
        matrix1_text = new TextField[3][3];
        matrix1 = new Label("Matrix 1");
        matrix1.setBounds(50, 40, 100, 25);
        matrix1.setFont(new Font("Arial", Font.PLAIN, 20));
        add(matrix1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1_text[i][j] = new TextField();
                matrix1_text[i][j].setBounds(50 + j * 50, 70 + i * 50, 50, 50);
                matrix1_text[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                add(matrix1_text[i][j]);
            }
        }
    }

    void setupMatrix2() {
        matrix2_text = new TextField[3][3];
        matrix2 = new Label("Matrix 2");
        matrix2.setBounds(250, 40, 100, 25);
        matrix2.setFont(new Font("Arial", Font.PLAIN, 20));
        add(matrix2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2_text[i][j] = new TextField();
                matrix2_text[i][j].setBounds(250 + j * 50, 70 + i * 50, 50, 50);
                matrix2_text[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                add(matrix2_text[i][j]);
            }
        }
    }

    void setupResultMatrix1() {
        result1_text = new TextField[3][3];
        result1 = new Label("Result Player 1");
        result1.setBounds(50, 325, 150, 25);
        result1.setFont(new Font("Arial", Font.PLAIN, 15));
        add(result1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result1_text[i][j] = new TextField();
                result1_text[i][j].setBounds(50 + j * 50, 350 + i * 50, 50, 50);
                result1_text[i][j].setFont(new Font("Arial", Font.PLAIN, 15));
                result1_text[i][j].setEditable(false);
                add(result1_text[i][j]);
            }
        }
    }

    void setupResultMatrix2() {
        result2_text = new TextField[3][3];
        result2 = new Label("Result Player 2");
        result2.setBounds(250, 325, 150, 25);
        result2.setFont(new Font("Arial", Font.PLAIN, 15));
        add(result2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result2_text[i][j] = new TextField();
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

    private void displayResult(float[][] result, TextField[][] resultField) {
        if (result.length == 3 && result[0].length == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    resultField[i][j].setText(String.format("%.3f", result[i][j]));
                }
            }
        }
    }

    public static void main(String[] args) {
        NashAwtGui nash = new NashAwtGui();
    }
}
