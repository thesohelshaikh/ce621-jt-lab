/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp1calculator;

/**
 *
 * @author sohel
 */

import java.util.Stack;
import java.lang.Math;

public class calculator extends javax.swing.JFrame {
    
    double num,ans;

    /**
     * Creates new form calculator
     */
    public calculator() {
        initComponents();
        
        rb_on.setEnabled(false); // ON button will be disabled by default
    }
    
    // A utility function to return precedence of a given operator 
    // Higher returned value means higher precedence 
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
       
    // The main method that converts given infix expression 
    // to postfix expression.  
    static String infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = new String(""); 
          
        // initializing empty stack 
        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) 
                    result += stack.pop(); 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()) 
            result += stack.pop(); 
       
        return result; 
    }
    
    // Method to evaluate value of a postfix expression 
    static int evaluatePostfix(String exp) 
    { 
        //create a stack 
        Stack<Integer> stack=new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    } 
    
    public void performAritmeticOperation(){
        
        String exp = infixToPostfix(tf_display.getText());
        jLabel1.setText(exp);
        ans = evaluatePostfix(exp);
        tf_display.setText(Double.toString(ans));      
    }
    
    public void turnOn(){
        rb_on.setEnabled(false);
        rb_off.setEnabled(true);
        
        tf_display.setEnabled(true);
        btn_abs.setEnabled(true);
        btn_del.setEnabled(true);
        btn_divide.setEnabled(true);
        btn_sub.setEnabled(true);
        btn_multiply.setEnabled(true);
        btn_ac.setEnabled(true);
        btn_add.setEnabled(true);
        btn_ans.setEnabled(true);
        btn_seven.setEnabled(true);
        btn_eight.setEnabled(true);
        btn_nine.setEnabled(true);
        btn_leftParen.setEnabled(true);
        btn_rightParen.setEnabled(true);
        btn_square.setEnabled(true);
        btn_four.setEnabled(true);
        btn_five.setEnabled(true);
        btn_six.setEnabled(true);
        btn_one.setEnabled(true);
        btn_two.setEnabled(true);
        btn_three.setEnabled(true);
        btn_zero.setEnabled(true);
        btn_doubleZero.setEnabled(true);
        btn_decimal.setEnabled(true);
        btn_cube.setEnabled(true);
        btn_sqrt.setEnabled(true);
        btn_cbrt.setEnabled(true);
        btn_sin.setEnabled(true);
        btn_cos.setEnabled(true);
        btn_tan.setEnabled(true);
        btn_log.setEnabled(true);
        btn_ln.setEnabled(true);
        btn_doubleZero.setEnabled(true);
        btn_decimal.setEnabled(true);     
    }
    
    public void turnOff(){
        rb_on.setEnabled(true);
        rb_off.setEnabled(false);

        
        tf_display.setEnabled(false);        
        btn_abs.setEnabled(false);
        btn_del.setEnabled(false);
        btn_divide.setEnabled(false);
        btn_sub.setEnabled(false);
        btn_multiply.setEnabled(false);
        btn_ac.setEnabled(false);
        btn_add.setEnabled(false);
        btn_ans.setEnabled(false);
        btn_seven.setEnabled(false);
        btn_eight.setEnabled(false);
        btn_nine.setEnabled(false);
        btn_leftParen.setEnabled(false);
        btn_rightParen.setEnabled(false);
        btn_square.setEnabled(false);
        btn_four.setEnabled(false);
        btn_five.setEnabled(false);
        btn_six.setEnabled(false);
        btn_one.setEnabled(false);
        btn_two.setEnabled(false);
        btn_three.setEnabled(false);
        btn_zero.setEnabled(false);
        btn_doubleZero.setEnabled(false);
        btn_decimal.setEnabled(false);
        btn_cube.setEnabled(false);
        btn_sqrt.setEnabled(false);
        btn_cbrt.setEnabled(false);
        btn_sin.setEnabled(false);
        btn_cos.setEnabled(false);
        btn_tan.setEnabled(false);
        btn_log.setEnabled(false);
        btn_ln.setEnabled(false);
        btn_doubleZero.setEnabled(false);
        btn_decimal.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgp_power = new javax.swing.ButtonGroup();
        tf_display = new javax.swing.JTextField();
        rb_on = new javax.swing.JRadioButton();
        rb_off = new javax.swing.JRadioButton();
        btn_del = new javax.swing.JButton();
        btn_multiply = new javax.swing.JButton();
        btn_ac = new javax.swing.JButton();
        btn_divide = new javax.swing.JButton();
        btn_sub = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_ans = new javax.swing.JButton();
        btn_seven = new javax.swing.JButton();
        btn_eight = new javax.swing.JButton();
        btn_nine = new javax.swing.JButton();
        btn_four = new javax.swing.JButton();
        btn_five = new javax.swing.JButton();
        btn_six = new javax.swing.JButton();
        btn_one = new javax.swing.JButton();
        btn_two = new javax.swing.JButton();
        btn_three = new javax.swing.JButton();
        btn_zero = new javax.swing.JButton();
        btn_doubleZero = new javax.swing.JButton();
        btn_decimal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_leftParen = new javax.swing.JButton();
        btn_rightParen = new javax.swing.JButton();
        lbl_casio = new javax.swing.JLabel();
        lbl_model = new javax.swing.JLabel();
        btn_square = new javax.swing.JButton();
        btn_cube = new javax.swing.JButton();
        btn_sqrt = new javax.swing.JButton();
        btn_cbrt = new javax.swing.JButton();
        btn_sin = new javax.swing.JButton();
        btn_cos = new javax.swing.JButton();
        btn_tan = new javax.swing.JButton();
        btn_log = new javax.swing.JButton();
        btn_ln = new javax.swing.JButton();
        btn_abs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator by Sohel");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLocation(new java.awt.Point(500, 250));
        setResizable(false);

        tf_display.setEditable(false);
        tf_display.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        tf_display.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_displayActionPerformed(evt);
            }
        });

        bgp_power.add(rb_on);
        rb_on.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rb_on.setForeground(new java.awt.Color(0, 153, 0));
        rb_on.setText("ON");
        rb_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_onActionPerformed(evt);
            }
        });

        bgp_power.add(rb_off);
        rb_off.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rb_off.setForeground(java.awt.Color.red);
        rb_off.setText("OFF");
        rb_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_offActionPerformed(evt);
            }
        });

        btn_del.setBackground(java.awt.Color.pink);
        btn_del.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_del.setText("DEL");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_multiply.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_multiply.setText("X");
        btn_multiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_multiplyActionPerformed(evt);
            }
        });

        btn_ac.setBackground(java.awt.Color.pink);
        btn_ac.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_ac.setText("AC");
        btn_ac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acActionPerformed(evt);
            }
        });

        btn_divide.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_divide.setText("/");
        btn_divide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_divideActionPerformed(evt);
            }
        });

        btn_sub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_sub.setText("-");
        btn_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_subActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setText("+");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_ans.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_ans.setText("=");
        btn_ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ansActionPerformed(evt);
            }
        });

        btn_seven.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_seven.setText("7");
        btn_seven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sevenActionPerformed(evt);
            }
        });

        btn_eight.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_eight.setText("8");
        btn_eight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eightActionPerformed(evt);
            }
        });

        btn_nine.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_nine.setText("9");
        btn_nine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nineActionPerformed(evt);
            }
        });

        btn_four.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_four.setText("4");
        btn_four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fourActionPerformed(evt);
            }
        });

        btn_five.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_five.setText("5");
        btn_five.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fiveActionPerformed(evt);
            }
        });

        btn_six.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_six.setText("6");
        btn_six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sixActionPerformed(evt);
            }
        });

        btn_one.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_one.setText("1");
        btn_one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_oneActionPerformed(evt);
            }
        });

        btn_two.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_two.setText("2");
        btn_two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_twoActionPerformed(evt);
            }
        });

        btn_three.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_three.setText("3");
        btn_three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_threeActionPerformed(evt);
            }
        });

        btn_zero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_zero.setText("0");
        btn_zero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_zeroActionPerformed(evt);
            }
        });

        btn_doubleZero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_doubleZero.setText("00");
        btn_doubleZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doubleZeroActionPerformed(evt);
            }
        });

        btn_decimal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_decimal.setText(".");
        btn_decimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_decimalActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btn_leftParen.setBackground(java.awt.Color.darkGray);
        btn_leftParen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_leftParen.setForeground(new java.awt.Color(255, 255, 255));
        btn_leftParen.setText("(");
        btn_leftParen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_leftParen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_leftParenActionPerformed(evt);
            }
        });

        btn_rightParen.setBackground(java.awt.Color.darkGray);
        btn_rightParen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_rightParen.setForeground(new java.awt.Color(255, 255, 255));
        btn_rightParen.setText(")");
        btn_rightParen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_rightParen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rightParenActionPerformed(evt);
            }
        });

        lbl_casio.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lbl_casio.setText("CASIO");

        lbl_model.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        lbl_model.setText("fx-007");

        btn_square.setBackground(java.awt.Color.darkGray);
        btn_square.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_square.setForeground(new java.awt.Color(255, 255, 255));
        btn_square.setText("^2");
        btn_square.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_square.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_squareActionPerformed(evt);
            }
        });

        btn_cube.setBackground(java.awt.Color.darkGray);
        btn_cube.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_cube.setForeground(new java.awt.Color(255, 255, 255));
        btn_cube.setText("^3");
        btn_cube.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cubeActionPerformed(evt);
            }
        });

        btn_sqrt.setBackground(java.awt.Color.darkGray);
        btn_sqrt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_sqrt.setForeground(new java.awt.Color(255, 255, 255));
        btn_sqrt.setText("sqrt");
        btn_sqrt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sqrtActionPerformed(evt);
            }
        });

        btn_cbrt.setBackground(java.awt.Color.darkGray);
        btn_cbrt.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        btn_cbrt.setForeground(new java.awt.Color(255, 255, 255));
        btn_cbrt.setText("cbrt");
        btn_cbrt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cbrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cbrtActionPerformed(evt);
            }
        });

        btn_sin.setBackground(java.awt.Color.darkGray);
        btn_sin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_sin.setForeground(new java.awt.Color(255, 255, 255));
        btn_sin.setText("sin");
        btn_sin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sinActionPerformed(evt);
            }
        });

        btn_cos.setBackground(java.awt.Color.darkGray);
        btn_cos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_cos.setForeground(new java.awt.Color(255, 255, 255));
        btn_cos.setText("cos");
        btn_cos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cosActionPerformed(evt);
            }
        });

        btn_tan.setBackground(java.awt.Color.darkGray);
        btn_tan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_tan.setForeground(new java.awt.Color(255, 255, 255));
        btn_tan.setText("tan");
        btn_tan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tanActionPerformed(evt);
            }
        });

        btn_log.setBackground(java.awt.Color.darkGray);
        btn_log.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_log.setForeground(new java.awt.Color(255, 255, 255));
        btn_log.setText("log");
        btn_log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logActionPerformed(evt);
            }
        });

        btn_ln.setBackground(java.awt.Color.darkGray);
        btn_ln.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_ln.setForeground(new java.awt.Color(255, 255, 255));
        btn_ln.setText("ln");
        btn_ln.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lnActionPerformed(evt);
            }
        });

        btn_abs.setBackground(java.awt.Color.darkGray);
        btn_abs.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_abs.setForeground(new java.awt.Color(255, 255, 255));
        btn_abs.setText("abs");
        btn_abs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_abs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_absActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_display, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_casio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(lbl_model))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_zero, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_four, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_seven, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_one, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btn_sqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_log, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_abs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_two, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_three, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_eight, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_nine, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_del))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_five, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_six, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_ac, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(btn_divide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_sub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_doubleZero, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ans, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_square, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_cube, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_cbrt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_leftParen, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_rightParen, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_ln, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_sin, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_cos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_tan, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb_on)
                                    .addComponent(rb_off))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_casio)
                        .addComponent(lbl_model))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_display, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sin)
                            .addComponent(btn_cos)
                            .addComponent(btn_tan)
                            .addComponent(btn_abs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_square)
                            .addComponent(btn_cube)
                            .addComponent(btn_sqrt)
                            .addComponent(btn_cbrt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_leftParen)
                            .addComponent(btn_rightParen)
                            .addComponent(btn_log)
                            .addComponent(btn_ln))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_on)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_off)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_del)
                    .addComponent(btn_eight)
                    .addComponent(btn_seven)
                    .addComponent(btn_nine)
                    .addComponent(btn_ac, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_multiply)
                    .addComponent(btn_divide)
                    .addComponent(btn_four)
                    .addComponent(btn_five)
                    .addComponent(btn_six))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sub)
                    .addComponent(btn_add)
                    .addComponent(btn_one)
                    .addComponent(btn_two)
                    .addComponent(btn_three))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ans)
                    .addComponent(btn_zero)
                    .addComponent(btn_doubleZero)
                    .addComponent(btn_decimal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb_onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_onActionPerformed
        turnOn();
    }//GEN-LAST:event_rb_onActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        int length = tf_display.getText().length() - 1;
        String newText;
        
        if(length >= 0){
            StringBuilder oldText = new StringBuilder(tf_display.getText());
            oldText.deleteCharAt(length);
            newText = oldText.toString();
            tf_display.setText(newText);
        }         
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_acActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acActionPerformed
        tf_display.setText("");
    }//GEN-LAST:event_btn_acActionPerformed

    private void btn_divideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_divideActionPerformed
        tf_display.setText(tf_display.getText() + "/");
    }//GEN-LAST:event_btn_divideActionPerformed

    private void btn_multiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_multiplyActionPerformed
          tf_display.setText(tf_display.getText() + "*");
    }//GEN-LAST:event_btn_multiplyActionPerformed

    private void btn_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_subActionPerformed
        tf_display.setText(tf_display.getText() + "-"); 
    }//GEN-LAST:event_btn_subActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        tf_display.setText(tf_display.getText() + "+");    
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ansActionPerformed
        performAritmeticOperation();
        jLabel1.setText("");
    }//GEN-LAST:event_btn_ansActionPerformed

    private void btn_sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sevenActionPerformed
        tf_display.setText(tf_display.getText() + "7");
    }//GEN-LAST:event_btn_sevenActionPerformed

    private void btn_eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eightActionPerformed
        tf_display.setText(tf_display.getText() + "8");
    }//GEN-LAST:event_btn_eightActionPerformed

    private void btn_nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nineActionPerformed
        tf_display.setText(tf_display.getText() + "9");
    }//GEN-LAST:event_btn_nineActionPerformed

    private void btn_fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fourActionPerformed
        tf_display.setText(tf_display.getText() + "4");
    }//GEN-LAST:event_btn_fourActionPerformed

    private void btn_fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fiveActionPerformed
        tf_display.setText(tf_display.getText() + "5");
    }//GEN-LAST:event_btn_fiveActionPerformed

    private void btn_sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sixActionPerformed
        tf_display.setText(tf_display.getText() + "6");
    }//GEN-LAST:event_btn_sixActionPerformed

    private void btn_oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oneActionPerformed
        tf_display.setText(tf_display.getText() + "1");
    }//GEN-LAST:event_btn_oneActionPerformed

    private void btn_twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_twoActionPerformed
        tf_display.setText(tf_display.getText() + "2");
    }//GEN-LAST:event_btn_twoActionPerformed

    private void btn_threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_threeActionPerformed
        tf_display.setText(tf_display.getText() + "3");
    }//GEN-LAST:event_btn_threeActionPerformed

    private void btn_zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_zeroActionPerformed
        tf_display.setText(tf_display.getText() + "0");
    }//GEN-LAST:event_btn_zeroActionPerformed

    private void btn_doubleZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doubleZeroActionPerformed
        tf_display.setText(tf_display.getText() + "00");
    }//GEN-LAST:event_btn_doubleZeroActionPerformed

    private void btn_decimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_decimalActionPerformed
        tf_display.setText(tf_display.getText() + ".");
    }//GEN-LAST:event_btn_decimalActionPerformed

    private void rb_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_offActionPerformed
        turnOff();
    }//GEN-LAST:event_rb_offActionPerformed

    private void btn_leftParenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_leftParenActionPerformed
        tf_display.setText(tf_display.getText() + "(");
    }//GEN-LAST:event_btn_leftParenActionPerformed

    private void btn_rightParenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rightParenActionPerformed
        tf_display.setText(tf_display.getText() + ")");
    }//GEN-LAST:event_btn_rightParenActionPerformed

    private void btn_squareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_squareActionPerformed
        num = Double.parseDouble(tf_display.getText() );
        double two = 2.0;
        ans = Math.pow(num, two);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_squareActionPerformed

    private void btn_cubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cubeActionPerformed
        num = Double.parseDouble(tf_display.getText() );
        double three = 3.0;
        ans = Math.pow(num, three);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_cubeActionPerformed

    private void btn_sqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sqrtActionPerformed
        num = Double.parseDouble(tf_display.getText());
        ans = Math.sqrt(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_sqrtActionPerformed

    private void btn_cbrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cbrtActionPerformed
        num = Double.parseDouble(tf_display.getText());
        ans = Math.cbrt(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_cbrtActionPerformed

    private void btn_sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sinActionPerformed
        num = Double.parseDouble(tf_display.getText());
        num = Math.toRadians(num);
        ans = Math.sin(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_sinActionPerformed

    private void btn_cosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cosActionPerformed
        num = Double.parseDouble(tf_display.getText());
        num = Math.toRadians(num);
        ans = Math.cos(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_cosActionPerformed

    private void btn_tanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tanActionPerformed
        num = Double.parseDouble(tf_display.getText());
        num = Math.toRadians(num);
        ans = Math.tan(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_tanActionPerformed

    private void btn_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logActionPerformed
        num = Double.parseDouble(tf_display.getText());
        ans = Math.log10(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_logActionPerformed

    private void btn_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lnActionPerformed
        num = Double.parseDouble(tf_display.getText());
        ans = Math.log(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_lnActionPerformed

    private void tf_displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_displayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_displayActionPerformed

    private void btn_absActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_absActionPerformed
        num = Double.parseDouble(tf_display.getText());
        ans = Math.abs(num);
        tf_display.setText(Double.toString(ans));
    }//GEN-LAST:event_btn_absActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgp_power;
    private javax.swing.JButton btn_abs;
    private javax.swing.JButton btn_ac;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_ans;
    private javax.swing.JButton btn_cbrt;
    private javax.swing.JButton btn_cos;
    private javax.swing.JButton btn_cube;
    private javax.swing.JButton btn_decimal;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_divide;
    private javax.swing.JButton btn_doubleZero;
    private javax.swing.JButton btn_eight;
    private javax.swing.JButton btn_five;
    private javax.swing.JButton btn_four;
    private javax.swing.JButton btn_leftParen;
    private javax.swing.JButton btn_ln;
    private javax.swing.JButton btn_log;
    private javax.swing.JButton btn_multiply;
    private javax.swing.JButton btn_nine;
    private javax.swing.JButton btn_one;
    private javax.swing.JButton btn_rightParen;
    private javax.swing.JButton btn_seven;
    private javax.swing.JButton btn_sin;
    private javax.swing.JButton btn_six;
    private javax.swing.JButton btn_sqrt;
    private javax.swing.JButton btn_square;
    private javax.swing.JButton btn_sub;
    private javax.swing.JButton btn_tan;
    private javax.swing.JButton btn_three;
    private javax.swing.JButton btn_two;
    private javax.swing.JButton btn_zero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_casio;
    private javax.swing.JLabel lbl_model;
    private javax.swing.JRadioButton rb_off;
    private javax.swing.JRadioButton rb_on;
    private javax.swing.JTextField tf_display;
    // End of variables declaration//GEN-END:variables
}
