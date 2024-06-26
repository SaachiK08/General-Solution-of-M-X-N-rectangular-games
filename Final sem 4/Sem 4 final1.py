import tkinter as tk
from tkinter import ttk
import numpy as np

class NashEquilibrium:
    def __init__(self, root):
        self.root = root
        self.root.title("Rock Paper Scissors")
        self.root.configure(background="#f0f0f0")
        
        # Initialize payoff matrices for player 1 and player 2
        self.payoff_matrix_player1 = np.array([[0, -1, 1], [1, 0, -1], [-1, 1, 0]])
        self.payoff_matrix_player2 = np.array([[0, 1, -1], [-1, 0, 1], [1, -1, 0]])
        
        # Initialize variables for storing choices
        self.player1_choice = None
        self.player2_choice = None
    
        # Initialize GUI elements
        self.create_gui()
        
    def create_gui(self):
        # Create frame
        self.frame = tk.Frame(self.root, bg="#f0f0f0")
        self.frame.pack(expand=True)
        
        # Create canvas
        self.canvas = tk.Canvas(self.frame, width=300, height=300, bg="#FFE5B4", bd=0, highlightthickness=0)
        self.canvas.pack()
        
        # Create buttons for player 1
        self.player1_buttons = []
        for i, choice in enumerate(["Rock", "Paper", "Scissors"]):
            button = tk.Button(self.canvas, text=choice, command=lambda choice=choice: self.play(1, choice), bg="#4CAF50", fg="white", activebackground="#45a049", bd=0, font=("Helvetica", 10))
            button.place(x=i*100 + 25, y=50)
            self.player1_buttons.append(button)
        
        # Create buttons for player 2
        self.player2_buttons = []
        for i, choice in enumerate(["Rock", "Paper", "Scissors"]):
            button = tk.Button(self.canvas, text=choice, command=lambda choice=choice: self.play(2, choice), bg="#2196F3", fg="white", activebackground="#1e87db", bd=0, font=("Helvetica", 10))
            button.place(x=i*100 + 25, y=200)
            self.player2_buttons.append(button)
        
        # Display Nash equilibrium for player 1
        self.player1_label = tk.Label(self.canvas, text="Nash Equilibrium for Player 1:", bg="#f0f0f0")
        self.player1_label.place(x=25, y=100)
        self.player1_result = tk.Label(self.canvas, text="", bg="white", width=10, font=("Helvetica", 12))
        self.player1_result.place(x=25, y=125)
        
        # Display Nash equilibrium for player 2
        self.player2_label = tk.Label(self.canvas, text="Nash Equilibrium for Player 2:", bg="#f0f0f0")
        self.player2_label.place(x=25, y=250)
        self.player2_result = tk.Label(self.canvas, text="", bg="white", width=10, font=("Helvetica", 12))
        self.player2_result.place(x=25, y=275)
        
    def play(self, player, choice):
        # Update player's choice
        if player == 1:
            self.player1_choice = ["Rock", "Paper", "Scissors"].index(choice)
            self.player1_buttons[self.player1_choice].config(state="disabled", bg="#9E9E9E", activebackground="#9E9E9E")
        else:
            self.player2_choice = ["Rock", "Paper", "Scissors"].index(choice)
            self.player2_buttons[self.player2_choice].config(state="disabled", bg="#9E9E9E", activebackground="#9E9E9E")
        
        # Calculate Nash equilibria
        player1_nash, player2_nash = self.find_nash_equilibrium()
        self.player1_result.config(text=str(player1_nash))
        self.player2_result.config(text=str(player2_nash))
        
    def find_nash_equilibrium(self):
        player1_probabilities = np.zeros(3)
        player2_probabilities = np.zeros(3)
        
        # Calculate probabilities based on player choices
        if self.player1_choice is not None:
            player1_probabilities[self.player1_choice] = 1
        if self.player2_choice is not None:
            player2_probabilities[self.player2_choice] = 1
        
        # Calculate Nash equilibrium for both players
        player1_nash = np.dot(player1_probabilities, self.payoff_matrix_player1)
        player2_nash = np.dot(player2_probabilities, self.payoff_matrix_player2)
        
        return player1_nash, player2_nash

# Create Tkinter window
root = tk.Tk()

# Create an instance of NashEquilibrium class
nash_solver = NashEquilibrium(root)

# Run the Tkinter event loop
root.mainloop()
