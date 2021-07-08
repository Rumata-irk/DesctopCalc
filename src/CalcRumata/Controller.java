package CalcRumata;


import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javafx.animation.PauseTransition;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.AnchorPane;

import javafx.util.Duration;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Controller {

    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label main_text;

    @FXML
    private Label memory_text;

    @FXML
    private Label summ_text;

    @FXML
    private Button btn_bracket_left;

    @FXML
    private Button btn_bracket_right;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_backspace;

    @FXML
    private Button btn_percent;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_division;

    @FXML
    private Button btn_memory_minus;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_multiply;

    @FXML
    private Button btn_memory_plus;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_subtraction;

    @FXML
    private Button btn_memory_return;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_point;

    @FXML
    private Button btn_equally;

    @FXML
    private Button btn_addition;

    @FXML
    private Button btn_memory_clear;

    private String str_num = "";
    private Double memory = 0.0;
    private String str_sum = "";

    private static Expression expression;

    Pattern patternPoint = Pattern.compile("[^\\d()]$");
    Pattern patternPoint2 = Pattern.compile(",\\d+[^\\d()]$");
    Pattern patternEqually = Pattern.compile("\\u0000$");
    Pattern patternLeftBracket = Pattern.compile("\\d$");

    DecimalFormat decimalFormat = new DecimalFormat("#.########");


    @FXML
    void initialize() {

        anchor_pane.setOnKeyPressed(event -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
            if (event.getCode() == KeyCode.DIGIT0 && !event.isShiftDown() || event.getCode() == KeyCode.NUMPAD0) {
                btn_0.arm();
                pause.setOnFinished(e -> {
                    btn_0.disarm();
                    btn_0.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT1 || event.getCode() == KeyCode.NUMPAD1) {
                btn_1.arm();
                pause.setOnFinished(e -> {
                    btn_1.disarm();
                    btn_1.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT2 || event.getCode() == KeyCode.NUMPAD2) {
                btn_2.arm();
                pause.setOnFinished(e -> {
                    btn_2.disarm();
                    btn_2.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT3 || event.getCode() == KeyCode.NUMPAD3) {
                btn_3.arm();
                pause.setOnFinished(e -> {
                    btn_3.disarm();
                    btn_3.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT4 || event.getCode() == KeyCode.NUMPAD4) {
                btn_4.arm();
                pause.setOnFinished(e -> {
                    btn_4.disarm();
                    btn_4.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT5 && !event.isShiftDown() || event.getCode() == KeyCode.NUMPAD5) {
                btn_5.arm();
                pause.setOnFinished(e -> {
                    btn_5.disarm();
                    btn_5.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT6 || event.getCode() == KeyCode.NUMPAD6) {
                btn_6.arm();
                pause.setOnFinished(e -> {
                    btn_6.disarm();
                    btn_6.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT7 || event.getCode() == KeyCode.NUMPAD7) {
                btn_7.arm();
                pause.setOnFinished(e -> {
                    btn_7.disarm();
                    btn_7.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT8 && !event.isShiftDown() || event.getCode() == KeyCode.NUMPAD8) {
                btn_8.arm();
                pause.setOnFinished(e -> {
                    btn_8.disarm();
                    btn_8.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT9 && !event.isShiftDown() || event.getCode() == KeyCode.NUMPAD9) {
                btn_9.arm();
                pause.setOnFinished(e -> {
                    btn_9.disarm();
                    btn_9.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                btn_clear.arm();
                pause.setOnFinished(e -> {
                    btn_clear.disarm();
                    btn_clear.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.ADD || event.getCode() == KeyCode.EQUALS && event.isShiftDown()) {
                btn_addition.arm();
                pause.setOnFinished(e -> {
                    btn_addition.disarm();
                    btn_addition.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.SUBTRACT || event.getCode() == KeyCode.MINUS) {
                btn_subtraction.arm();
                pause.setOnFinished(e -> {
                    btn_subtraction.disarm();
                    btn_subtraction.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.MULTIPLY || event.getCode() == KeyCode.DIGIT8 && event.isShiftDown()) {
                btn_multiply.arm();
                pause.setOnFinished(e -> {
                    btn_multiply.disarm();
                    btn_multiply.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIVIDE || event.getCode() == KeyCode.SLASH) {
                btn_division.arm();
                pause.setOnFinished(e -> {
                    btn_division.disarm();
                    btn_division.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.EQUALS && !event.isShiftDown() || event.getCode() == KeyCode.ENTER) {
                btn_equally.arm();
                pause.setOnFinished(e -> {
                    btn_equally.disarm();
                    btn_equally.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT5 && event.isShiftDown()) {
                btn_percent.arm();
                pause.setOnFinished(e -> {
                    btn_percent.disarm();
                    btn_percent.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.BACK_SPACE) {
                btn_backspace.arm();
                pause.setOnFinished(e -> {
                    btn_backspace.disarm();
                    btn_backspace.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT9 && event.isShiftDown()) {
                btn_bracket_left.arm();
                pause.setOnFinished(e -> {
                    btn_bracket_left.disarm();
                    btn_bracket_left.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DIGIT0 && event.isShiftDown()) {
                btn_bracket_right.arm();
                pause.setOnFinished(e -> {
                    btn_bracket_right.disarm();
                    btn_bracket_right.fire();
                });
                pause.play();
            }
            if (event.getCode() == KeyCode.DECIMAL || event.getCode() == KeyCode.PERIOD || event.getCode() == KeyCode.COMMA) {
                btn_point.arm();
                pause.setOnFinished(e -> {
                    btn_point.disarm();
                    btn_point.fire();
                });
                pause.play();
            }
        });


        //--number button--//
        btn_0.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("0");
            try {
                expression(this.str_num);
            } catch (Exception e) {
                summ_text.setText("Error");
            }
        });
        btn_1.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("1");
            expression(this.str_num);
        });
        btn_2.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("2");
            expression(this.str_num);
        });
        btn_3.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("3");
            expression(this.str_num);
        });
        btn_4.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("4");
            expression(this.str_num);
        });
        btn_5.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("5");
            expression(this.str_num);
        });
        btn_6.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("6");
            expression(this.str_num);
        });
        btn_7.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("7");
            expression(this.str_num);
        });
        btn_8.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("8");
            expression(this.str_num);
        });
        btn_9.setOnAction(event -> {
            checkEqually(this.str_num);
            addNumber("9");
            expression(this.str_num);
        });
        btn_point.setOnAction(event -> {
            String[] strings = this.str_num.split("(?!,)[+-/*]");
            Matcher matcher = patternPoint.matcher(this.str_num);
            Matcher matcher2 = patternPoint2.matcher(this.str_num);

            if (strings[strings.length - 1].contains(",") && !matcher2.find()) {
                return;
            } else {
                if (this.str_num.equals("") || matcher.find()) {
                    this.str_num += "0,";
                    main_text.setText(this.str_num);
                } else {
                    this.str_num += ",";
                    main_text.setText(this.str_num);
                }
            }
        });

        //--operation button--//
        btn_clear.setOnAction(event -> {
            this.str_num = "";
            main_text.setText(this.str_num);
            this.str_sum = "";
            summ_text.setText(this.str_sum);
        });
        btn_backspace.setOnAction(event -> {
            if (this.str_num.length() > 1) {
                this.str_num = this.str_num.substring(0, this.str_num.length() - 1);
                main_text.setText(this.str_num);
                String tempStr = this.str_num;
                if (tempStr.substring(tempStr.length() - 1).matches("[+-/*]")) {
                    expression(tempStr.substring(0, tempStr.length() - 1));
                } else {
                    expression(this.str_num);
                }
            } else {
                main_text.setText("");
            }
        });
        btn_addition.setOnAction(event -> {
            checkCharacter(this.str_num);
            addNumber("+");
        });
        btn_subtraction.setOnAction(event -> {
            checkCharacter(this.str_num);
            addNumber("-");
        });
        btn_multiply.setOnAction(event -> {
            checkCharacter(this.str_num);
            addNumber("*");
        });
        btn_division.setOnAction(event -> {
            checkCharacter(this.str_num);
            addNumber("/");
        });
        btn_equally.setOnAction(event -> {
            checkCharacter(this.str_num);
            expression(this.str_num);
            this.str_num = this.str_sum + "\u0000";
            main_text.setText(this.str_num);
        });

        //--memory button--//
        btn_memory_clear.setOnAction(event -> {
            if (this.memory != 0) {
                this.memory = 0.0;
                memory_text.setText("");
            }
        });
        btn_memory_plus.setOnAction(event -> {
            String memoryTemp = this.str_sum;
            memoryTemp = memoryTemp.replaceAll(",", "\\.");
            if (Double.parseDouble(memoryTemp) != 0) {
                this.memory = this.memory + Double.parseDouble(memoryTemp);
                if (this.memory % 1 == 0) {
                    memory_text.setText(String.format("%.0f", this.memory));
                } else {
                    String memoryTemp2 = String.valueOf(this.memory);
                    memoryTemp2 = memoryTemp2.replaceAll("\\.", ",");
                    memory_text.setText(memoryTemp2);
                }
            }
        });
        btn_memory_minus.setOnAction(event -> {
            String memoryTemp = this.str_sum;
            memoryTemp = memoryTemp.replaceAll(",", "\\.");
            if (Double.parseDouble(memoryTemp) != 0) {
                this.memory = this.memory - Double.parseDouble(memoryTemp);
                if (this.memory % 1 == 0) {
                    memory_text.setText(String.format("%.0f", this.memory));
                } else {
                    String memoryTemp2 = String.valueOf(this.memory);
                    memoryTemp2 = memoryTemp2.replaceAll("\\.", ",");
                    memory_text.setText(memoryTemp2);
                }
            }
        });
        btn_memory_return.setOnAction(event -> {
            if (this.memory != 0) {
                if (this.memory % 1 == 0) {
                    this.str_num = String.format("%.0f", this.memory);
                    main_text.setText(this.str_num);
                } else {
                    this.str_num = this.memory.toString();
                    String memoryTemp = this.str_num;
                    memoryTemp = memoryTemp.replaceAll("\\.", ",");
                    main_text.setText(memoryTemp);
                }
            }
        });
        //--bracket button--//
        btn_bracket_left.setOnAction(event -> {
            Matcher matcherBracket = patternLeftBracket.matcher(this.str_num);
            if (matcherBracket.find()) {
                this.str_num += "*(";
                main_text.setText(this.str_num);
            } else {
                this.str_num += "(";
                main_text.setText(this.str_num);
            }
        });

        btn_bracket_right.setOnAction(event -> {
            if (!checkBracket(this.str_num)) {
                this.str_num += ")";
                main_text.setText(this.str_num);
            } else {
                this.str_num = "(" + this.str_num + ")";
                main_text.setText(this.str_num);
            }
        });
    }

    void addNumber(String number) {
        this.str_num += number;
        main_text.setText(str_num);
    }


    void checkCharacter(String character) {
        if (character.substring(character.length() - 1).matches("[+-/*]")) {
            this.str_num = character.substring(0, character.length() - 1);
        }
    }

    void checkEqually(String strEqual) {
        Matcher matcherEqually = patternEqually.matcher(strEqual);
        if (matcherEqually.find()) {
            this.str_num = "";
            main_text.setText(this.str_num);
        } else {
            this.str_num = strEqual.replace("\u0000", "");
            main_text.setText(this.str_num);
        }
    }

    void expression(String strFunc) {
        strFunc = strFunc.replaceAll(",", "\\.");
        if (checkBracket(strFunc)) {
            expression = new ExpressionBuilder(strFunc).build();
        } else {
            expression = new ExpressionBuilder(deleteBracket(strFunc)).build();
        }

        this.str_sum = decimalFormat.format(expression.evaluate());
        summ_text.setText(this.str_sum);
    }

    static boolean checkBracket(String string) {
        List<Character> listChar = string.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        for (int i = 0; i < listChar.size(); i++) {
            if (listChar.get(i).toString().contains("(")) {
                for (int j = i; j < listChar.size(); j++) {
                    if (listChar.get(j).toString().contains(")")) {
                        listChar.remove(listChar.get(j));
                        listChar.remove(listChar.get(i));
                    }
                }
            }
        }
        String s = listChar.toString();
        return !s.contains("(");
    }

    static String deleteBracket(String string) {
        List<Character> listChar = string.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        for (int i = 0; i < listChar.size(); i++) {
            if (listChar.get(i).toString().contains("(")) {
                listChar.remove(listChar.get(i));
            }
        }
        string = "";
        for (Character s : listChar) {
            string += s;
        }
        return string;
    }
}

