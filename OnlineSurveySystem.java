import javax.swing.*;
    public class OnlineSurveySystem {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    SurveyCreationUI surveyCreationUI = new SurveyCreationUI();
                    surveyCreationUI.setVisible(true);
                }
            });
        }
    }