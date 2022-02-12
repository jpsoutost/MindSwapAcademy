package academy.mindswap.field;

import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;

public final class Field {

    private static final String BORDER_STRING = "▒";
    private static final String SNAKE_BODY_STRING = "#";
    private static final String SNAKE_HEAD_STRING = "0";
    private static final String FRUIT_STRING = "@";
    private static final String SCORE = "SCORE: ";
    private static final String HIGH_SCORE = "HIGHEST SCORE: ";
    private static final String GAME_OVER_1 =
            ".d8888b.         d8888 888b     d888 8888888888     .d88888b.  888     888 8888888888 8888888b.   ";
    private static final String GAME_OVER_2 =
            "d88P  Y88b       d88888 8888b   d8888 888           d88P\" \"Y88b 888     888 888        888   Y88b ";
    private static final String GAME_OVER_3 =
            "888    888      d88P888 88888b.d88888 888           888     888 888     888 888        888    888 ";
    private static final String GAME_OVER_4 =
            "888            d88P 888 888Y88888P888 8888888       888     888 Y88b   d88P 8888888    888   d88P ";
    private static final String GAME_OVER_5 =
            "888  88888    d88P  888 888 Y888P 888 888           888     888  Y88b d88P  888        8888888P\"  ";
    private static final String GAME_OVER_6 =
            "888    888   d88P   888 888  Y8P  888 888           888     888   Y88o88P   888        888 T88b   ";
    private static final String GAME_OVER_7 =
            "Y88b  d88P  d8888888888 888   \"   888 888           Y88b. .d88P    Y888P    888        888  T88b0 ";
    private static final String GAME_OVER_8 =
            " \"Y8888P88 d88P     888 888       888 8888888888     \"Y88888P\"      Y8P     8888888888 888   T88b ";

    private static int width;
    private static int height;
    private static Screen screen;
    private static ScreenWriter screenWriter;

    private Field() {
    }

    public static void init(int width, int height) {

        screen = TerminalFacade.createScreen();

        Field.width = width;
        Field.height = height;
        screen.getTerminal().getTerminalSize().setColumns(width);
        screen.getTerminal().getTerminalSize().setRows(height);

        screenWriter = new ScreenWriter(screen);
        screen.setCursorPosition(null);
        screen.startScreen();

        drawWalls();
        screen.refresh();
    }

    public static void drawSnake(Snake snake) {

        Terminal.Color snakeColor = Terminal.Color.GREEN;

        if (!snake.isAlive()){
            snakeColor = Terminal.Color.RED;
        }

        Position head = snake.getHead();

        for (Position p : snake.getFullSnake()) {
            if (!p.equals(head)) {
                screen.putString(p.getCol(), p.getRow(), SNAKE_BODY_STRING, snakeColor, null);
            } else {
                screen.putString(p.getCol(), p.getRow(), SNAKE_HEAD_STRING, snakeColor, null);
            }
        }
        screen.refresh();
    }

    public static void clearTail(Snake snake) {
        Position tail = snake.getTail();
        screen.putString(tail.getCol(), tail.getRow(), " ", null, null);
    }


    private static void drawWalls() {
        for (int i = 0; i < width; i++) {
            screenWriter.drawString(i, 0, BORDER_STRING);
            screenWriter.drawString(i, height - 1, BORDER_STRING);
        }

        for (int j = 0; j < height; j++) {
            screenWriter.drawString(0, j, BORDER_STRING);
            screenWriter.drawString(width - 1, j, BORDER_STRING);
        }
    }

    public static Key readInput() {
        return screen.readInput();
    }

    public static void drawFruit(Fruit fruit) {
        screen.putString(fruit.getPosition().getCol(), fruit.getPosition().getRow(), FRUIT_STRING, Terminal.Color.MAGENTA, null);
    }

    public static void score(int score) {
        screen.putString(3, 0, SCORE + String.valueOf(score), Terminal.Color.BLUE, Terminal.Color.YELLOW);
        screen.refresh();
    }

    public static int getWidth() {
        return width;
    }

    public static void drawGameOver(Terminal.Color terminalColor){
       screen.putString(1, 7,GAME_OVER_1, terminalColor, Terminal.Color.CYAN);
       screen.putString(1, 8,GAME_OVER_2, terminalColor, Terminal.Color.CYAN);
       screen.putString(1, 9,GAME_OVER_3, terminalColor, Terminal.Color.CYAN);
       screen.putString(1, 10,GAME_OVER_4, terminalColor, Terminal.Color.CYAN);
       screen.putString(1, 11,GAME_OVER_5, terminalColor, Terminal.Color.CYAN);
       screen.putString(1, 12,GAME_OVER_6, terminalColor, Terminal.Color.CYAN);
       screen.putString(1, 13,GAME_OVER_7, terminalColor, Terminal.Color.CYAN);
       screen.putString(1, 14,GAME_OVER_8, terminalColor, Terminal.Color.CYAN);
       screen.refresh();
    }

    public static int getHeight() {
        return height;
    }
}
