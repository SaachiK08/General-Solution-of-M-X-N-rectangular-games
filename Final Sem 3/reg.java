import java.awt.*;
public class reg {
public static void main(String[] args) {
Frame frame = new Frame("Student Registration Form");
frame.setLayout(new GridLayout(0, 2));
Label nameLabel = new Label("Name:");
TextField nameField = new TextField(30);
Label emailLabel = new Label("Email:");
TextField emailField = new TextField(30);
Label passwordLabel = new Label("Password:");
TextField passwordField = new TextField(30);
passwordField.setEchoChar('*'); // Hides the entered characters
Label reenterPasswordLabel = new Label("Reenter Password:");
TextField reenterPasswordField = new TextField(30);
reenterPasswordField.setEchoChar('*'); // Hides the entered characters
Label courseLabel = new Label("Course");
Choice courseChoice=new Choice();
courseChoice.add("ME/Mtech");
courseChoice.add("BE/Btech");
Label branchLabel = new Label("Branch:");
Choice branchChoice = new Choice();
branchChoice.add("Computer Science");
branchChoice.add("Mathematics");
branchChoice.add("Physics");
Label genderLabel = new Label("Gender:");
CheckboxGroup genderGroup = new CheckboxGroup();
Checkbox maleCheckbox = new Checkbox("Male", genderGroup, false);
Checkbox femaleCheckbox = new Checkbox("Female", genderGroup, false);
Button submitButton = new Button("Submit");
frame.add(nameLabel);
frame.add(nameField);
frame.add(emailLabel);
frame.add(emailField);
frame.add(passwordLabel);
frame.add(passwordField);
frame.add(reenterPasswordLabel);
frame.add(reenterPasswordField);
frame.add(branchLabel);
frame.add(branchChoice);
frame.add(courseLabel);
frame.add(courseChoice);
frame.add(genderLabel);
frame.add(maleCheckbox);
frame.add(new Label(""));
frame.add(femaleCheckbox);
frame.add(submitButton);
frame.pack();
frame.setVisible(true);
}
}