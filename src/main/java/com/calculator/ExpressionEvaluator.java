package com.calculator;

import java.util.List;
import java.util.Stack;

public class ExpressionEvaluator {
    private final ExpressionParser parser;

    public ExpressionEvaluator(ExpressionParser parser) {
        this.parser = parser;
    }

    public int evaluate(List<Token> tokens) {
        // Convert infix to postfix (Shunting Yard Algorithm)
        List<Token> postfix = infixToPostfix(tokens);

        // Evaluate postfix expression
        return evaluatePostfix(postfix);
    }

    private List<Token> infixToPostfix(List<Token> tokens) {
        Stack<Token> operatorStack = new Stack<>();
        List<Token> output = new java.util.ArrayList<>();

        for (Token token : tokens) {
            if (token.getType() == TokenType.NUMBER) {
                output.add(token);
            } else if (token.getType() == TokenType.OPERATOR) {
                Operator currentOp = parser.getOperator(token.getValue().charAt(0));

                while (!operatorStack.isEmpty() &&
                        operatorStack.peek().getType() == TokenType.OPERATOR) {
                    Operator topOp = parser.getOperator(operatorStack.peek().getValue().charAt(0));
                    if (topOp.getPrecedence() >= currentOp.getPrecedence()) {
                        output.add(operatorStack.pop());
                    } else {
                        break;
                    }
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.pop());
        }

        return output;
    }

    private int evaluatePostfix(List<Token> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (Token token : postfix) {
            if (token.getType() == TokenType.NUMBER) {
                stack.push(Integer.parseInt(token.getValue()));
            } else if (token.getType() == TokenType.OPERATOR) {
                int right = stack.pop();
                int left = stack.pop();
                Operator operator = parser.getOperator(token.getValue().charAt(0));
                int result = operator.apply(left, right);
                stack.push(result);
            }
        }

        return stack.pop();
    }
}