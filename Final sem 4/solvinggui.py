import numpy as np
import tkinter as tk
from tkinter import font
from solving import Nash

class NashFinder:

    def __init__(self):
        self.root = tk.Tk()
        self.root.title("Nash Finder")
        self.root.geometry("450x600")
        self.root.resizable(False, False)
        self.root.configure(background='#27DBC0')

        self.matrix1_text = [[None]*3 for _ in range(3)]
        self.matrix2_text = [[None]*3 for _ in range(3)]
        self.result1_text = [[None]*3 for _ in range(3)]
        self.result2_text = [[None]*3 for _ in range(3)]

        self.setup_matrix1()
        self.setup_matrix2()
        self.setup_button()
        self.setup_result_matrix1()
        self.setup_result_matrix2()

        self.root.mainloop()

    def setup_button(self):
        self.solve_btn = tk.Button(self.root, text="Solve", font=("Arial", 20, "bold"), command=self.solve)
        self.solve_btn.place(x=70, y=250, width=300, height=45)

    def setup_matrix1(self):
        label = tk.Label(self.root, text="Player 1", font=("Arial", 15, "bold"), bg='#DB7FDB')
        label.place(x=50, y=40, width=150, height=25)

        for i in range(3):
            for j in range(3):
                self.matrix1_text[i][j] = tk.Entry(self.root, font=("Arial", 20), justify='center')
                self.matrix1_text[i][j].place(x=50 + j * 50, y=70 + i * 50, width=50, height=50)

    def setup_matrix2(self):
        label = tk.Label(self.root, text="Player 2", font=("Arial", 15, "bold"), bg='#DB7FDB')
        label.place(x=250, y=40, width=150, height=25)

        for i in range(3):
            for j in range(3):
                self.matrix2_text[i][j] = tk.Entry(self.root, font=("Arial", 20), justify='center')
                self.matrix2_text[i][j].place(x=250 + j * 50, y=70 + i * 50, width=50, height=50)

    def setup_result_matrix1(self):
        label = tk.Label(self.root, text="Result Player 1", font=("Arial", 15, "bold"), bg='#DB7FDB')
        label.place(x=50, y=325, width=150, height=25)

        for i in range(3):
            for j in range(3):
                self.result1_text[i][j] = tk.Entry(self.root, font=("Arial", 15, "bold"), justify='center', bd=1, bg='#7CFC00')
                self.result1_text[i][j].place(x=50 + j * 50, y=350 + i * 50, width=50, height=50)
                self.result1_text[i][j].config(state='readonly')

    def setup_result_matrix2(self):
        label = tk.Label(self.root, text="Result Player 2", font=("Arial", 15, "bold"), bg='#DB7FDB')
        label.place(x=250, y=325, width=150, height=25)

        for i in range(3):
            for j in range(3):
                self.result2_text[i][j] = tk.Entry(self.root, font=("Arial", 15, "bold"), justify='center', bd=1, bg='#7CFC00')
                self.result2_text[i][j].place(x=250 + j * 50, y=350 + i * 50, width=50, height=50)
                self.result2_text[i][j].config(state='readonly')

    def solve(self):
        matrixplayer1 = np.array([[float(self.matrix1_text[i][j].get()) for j in range(3)] for i in range(3)])
        matrixplayer2 = np.array([[float(self.matrix2_text[i][j].get()) for j in range(3)] for i in range(3)])
        nash =Nash()
        equilibrium = nash.solving_matrix(matrixplayer1,matrixplayer2)
        self.display_result(equilibrium[0], self.result1_text)
        self.display_result(equilibrium[1], self.result2_text)

    def display_result(self, result, resultField):
        for i in range(3):
            for j in range(3):
                resultField[i][j].config(state='normal')
                resultField[i][j].delete(0, tk.END)
                resultField[i][j].insert(0, "{:.2f}".format(result[i][j]))
                resultField[i][j].config(state='readonly')

if __name__ == "__main__":
    NashFinder()
