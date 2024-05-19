package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomateVerifier extends JFrame {
    private JPanel mainPanel;
    private JTextField alphabetField;
    private JTextField statesField;
    private JButton nextStateButton;
    private JComboBox<String> initialStateComboBox;
    private JTextArea finalStatesTextArea;
    private JComboBox<String>[][] transitionsComboBoxes;
    private int numStates;
    private String[] alphabet;
    private JFrame fifthFrame;

    public AutomateVerifier() {
        setTitle("Vérificateur d'Automate");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        initComponents();
        setContentPane(mainPanel);
        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Entrez l'alphabet (séparé par des espaces) :"));
        alphabetField = new JTextField();
        inputPanel.add(alphabetField);

        inputPanel.add(new JLabel("Entrez le nombre d'états :"));
        statesField = new JTextField();
        inputPanel.add(statesField);

        nextStateButton = new JButton("Suivant");
        inputPanel.add(new JLabel()); // Empty label for alignment
        inputPanel.add(nextStateButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        nextStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSecondFrame();
            }
        });
    }

    private void showSecondFrame() {
        numStates = Integer.parseInt(statesField.getText());
        String[] stateIndices = new String[numStates];
        for (int i = 0; i < numStates; i++) {
            stateIndices[i] = String.valueOf(i);
        }

        JFrame secondFrame = new JFrame("Sélection de l'État");
        secondFrame.setSize(400, 300);
        secondFrame.setLayout(new BorderLayout(10, 10));
        secondFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel initialStatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        initialStatePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        initialStatePanel.add(new JLabel("Sélectionnez l'État Initial :"));
        initialStateComboBox = new JComboBox<>(stateIndices);
        initialStatePanel.add(initialStateComboBox);

        JPanel finalStatesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        finalStatesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        finalStatesPanel.add(new JLabel("Entrez les États Finaux (séparés par des espaces) :"));
        finalStatesTextArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(finalStatesTextArea);
        finalStatesPanel.add(scrollPane);

        JButton finishButton = new JButton("Terminer");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(finishButton);

        secondFrame.add(initialStatePanel, BorderLayout.NORTH);
        secondFrame.add(finalStatesPanel, BorderLayout.CENTER);
        secondFrame.add(buttonPanel, BorderLayout.SOUTH);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String initialState = (String) initialStateComboBox.getSelectedItem();
                String finalStates = finalStatesTextArea.getText();
                System.out.println("État Initial : " + initialState);
                System.out.println("États Finaux : " + finalStates);
                secondFrame.dispose();
                initializeTransitionsComboBoxes(); 
                showThirdFrame();
            }
        });

        secondFrame.setVisible(true);
    }

    private void initializeTransitionsComboBoxes() {
        alphabet = alphabetField.getText().split("\\s+");
        transitionsComboBoxes = new JComboBox[numStates][alphabet.length];
        for (int i = 0; i < numStates; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                transitionsComboBoxes[i][j] = new JComboBox<>();
                transitionsComboBoxes[i][j].addItem("null");
                for (int k = 0; k < numStates; k++) {
                    transitionsComboBoxes[i][j].addItem(String.valueOf(k));
                }
            }
        }
    }

    private void showThirdFrame() {
        JFrame thirdFrame = new JFrame("Entrée des Transitions");
        thirdFrame.setSize(500, 400);
        thirdFrame.setLayout(new BorderLayout(10, 10));
        thirdFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel transitionsPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        transitionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < numStates; i++) {
            transitionsPanel.add(new JLabel("État " + i + " :"));
            transitionsPanel.add(new JLabel()); //for space

            for (int j = 0; j < alphabet.length; j++) {
                JComboBox<String> comboBox = transitionsComboBoxes[i][j];
                transitionsPanel.add(new JLabel(alphabet[j]));
                transitionsPanel.add(comboBox);
            }
        }

        JButton finishButton = new JButton("Terminer");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(finishButton);

        thirdFrame.add(transitionsPanel, BorderLayout.CENTER);
        thirdFrame.add(buttonPanel, BorderLayout.SOUTH);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFourthFrame();
                thirdFrame.dispose();
            }
        });

        thirdFrame.setVisible(true);
    }

    private void showFourthFrame() {
        JFrame fourthFrame = new JFrame("Matrice de l'Automate");
        fourthFrame.setSize(500, 400);
        fourthFrame.setLayout(new BorderLayout(10, 10));
        fourthFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel matrixPanel = new JPanel(new GridLayout(numStates + 1, alphabet.length + 1, 10, 10));
        matrixPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        matrixPanel.add(new JLabel("État/Alphabet"));
        for (String letter : alphabet) {
            matrixPanel.add(new JLabel(letter));
        }

        for (int i = 0; i < numStates; i++) {
            matrixPanel.add(new JLabel("État " + i));
            for (int j = 0; j < alphabet.length; j++) {
                String transitionState = (String) transitionsComboBoxes[i][j].getSelectedItem();
                matrixPanel.add(new JLabel(transitionState));
            }
        }

        fourthFrame.add(matrixPanel, BorderLayout.CENTER);
        fourthFrame.setVisible(true);

        showFifthFrame(); // directly shows the 5th interface
    }

    private void showFifthFrame() {
        fifthFrame = new JFrame("Vérification du Mot");
        fifthFrame.setSize(400, 200);
        fifthFrame.setLayout(new BorderLayout(10, 10));
        fifthFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea wordTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(wordTextArea);
        fifthFrame.add(scrollPane, BorderLayout.CENTER);

        JButton verifyButton = new JButton("Vérifier");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(verifyButton);

        fifthFrame.add(buttonPanel, BorderLayout.SOUTH);

        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = wordTextArea.getText();
                if (isWordAccepted(word)) {
                    JOptionPane.showMessageDialog(fifthFrame, "L'automate reconnaît le mot");
                } else {
                    JOptionPane.showMessageDialog(fifthFrame, "Le mot n'est pas reconnu par l'automate");
                }
            }
        });

        fifthFrame.setVisible(true);
    }

    private boolean isWordAccepted(String word) {
        String currentState = (String) initialStateComboBox.getSelectedItem();
        boolean validTransition = true;

        for (char symbol : word.toCharArray()) {
            String nextState = getTransition(currentState, symbol);
            if (nextState == null) {
                validTransition = false;
                JOptionPane.showMessageDialog(fifthFrame, "Blocage");
                break;
            }
            currentState = nextState;
        }

        if (validTransition && !finalStatesTextArea.getText().contains(currentState)) {
            JOptionPane.showMessageDialog(fifthFrame, "Le mot ne se termine pas par un etat finale");
            return false;
        }

        return validTransition;
    }

    private String getTransition(String currentState, char symbol) {
        int stateIndex = Integer.parseInt(currentState);
        String symbolString = String.valueOf(symbol);
        int symbolIndex = -1;

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(symbolString)) {
                symbolIndex = i;
                break;
            }
        }

        if (symbolIndex == -1) {
            return null;
            // letter does not exist in the alphabet
        }

        Object selectedItem = transitionsComboBoxes[stateIndex][symbolIndex].getSelectedItem();
        if (selectedItem == null || selectedItem.toString().equals("null")) {
            return null; // The transition= null
        }
        return selectedItem.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutomateVerifier();
            }
        });
    }
}
