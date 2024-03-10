 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

    // Data model
    class Survey {
        private String title;
        private List<Question> questions;

        public Survey(String title) {
            this.title = title;
            this.questions = new ArrayList<>();
        }

        public void addQuestion(Question question) {
            questions.add(question);
        }

        public List<Question> getQuestions() {
            return questions;
        }
    }

    class Question {
        private String text;
        private QuestionType type;

        public Question(String text, QuestionType type) {
            this.text = text;
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public QuestionType getType() {
            return type;
        }
    }

    enum QuestionType {
        MULTIPLE_CHOICE,
        TEXT_INPUT,
        RATING_SCALE
    }

    // GUI for survey creation
    class SurveyCreationUI extends JFrame {
        private JTextField titleField;
        private JTextArea questionArea;
        private JComboBox<QuestionType> typeComboBox;
        private JButton addQuestionButton;
        private JButton createSurveyButton;
        private Survey survey;

        public SurveyCreationUI() {
            setTitle("Survey Creation");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setLayout(new GridLayout(4, 2));

            titleField = new JTextField();
            questionArea = new JTextArea();
            typeComboBox = new JComboBox<>(QuestionType.values());
            addQuestionButton = new JButton("Add Question");
            createSurveyButton = new JButton("Create Survey");

            add(new JLabel("Survey Title:"));
            add(titleField);
            add(new JLabel("Question:"));
            add(new JScrollPane(questionArea));
            add(new JLabel("Question Type:"));
            add(typeComboBox);
            add(addQuestionButton);
            add(createSurveyButton);

            addQuestionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addQuestion();
                }
            });

            createSurveyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createSurvey();
                }
            });
        }

        private void addQuestion() {
            String questionText = questionArea.getText();
            QuestionType type = (QuestionType) typeComboBox.getSelectedItem();
            Question question = new Question(questionText, type);
            if (survey == null) {
                survey = new Survey(titleField.getText());
            }
            survey.addQuestion(question);
            JOptionPane.showMessageDialog(this, "Question added successfully.");
            questionArea.setText("");
        }

        private void createSurvey() {
            if (survey != null && !survey.getQuestions().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Survey created successfully.");
                // Code for distributing the survey or saving it to a database can be added here
            } else {
                JOptionPane.showMessageDialog(this, "Please add at least one question to create the survey.");
            }
        }
    }