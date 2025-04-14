package org.example.lld_questions.design_chess;



class Player {
    private boolean color;

    public Player(boolean color) {
        this.color = color;
    }

    public boolean getColor() {
        return color;
    }
}


abstract class Piece {
    private Player player;

    public Piece(Player p) {
        this.player = p;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean getColor() {
        return this.player.getColor();
    }

    abstract int[][] getPossibleMoves(Cell[][] board, int x, int y);

    protected String getLabel() {
        return this.player.getColor() ? "W" : "B";
    }
}


class Pawn extends Piece {

    public Pawn(Player p) {
        super(p);
    }

    @Override
    public int[][] getPossibleMoves(Cell[][] board, int x, int y) {
        return new int[2][2];
    }

    public String getLabel() {
        return super.getLabel() + "P";
    }
}

class Rook extends Piece {
    public Rook(Player p) {
        super(p);
    }

    @Override
    public int[][] getPossibleMoves(Cell[][] board, int x, int y) {
        return new int[2][2];
    }

    public String getLabel() {
        return super.getLabel() + "R";
    }
}

class Bishop extends Piece {
    public Bishop(Player p) {
        super(p);
    }

    @Override
    public int[][] getPossibleMoves(Cell[][] board, int x, int y) {
        return new int[2][2];
    }

    public String getLabel() {
        return super.getLabel() + "B";
    }
}

class Knight extends Piece {
    public Knight(Player p) {
        super(p);
    }

    @Override
    public int[][] getPossibleMoves(Cell[][] board, int x, int y) {
        return new int[2][2];
    }

    public String getLabel() {
        return super.getLabel() + "K";
    }
}

class Queen extends Piece {

    private String label;

    public Queen(Player p) {
        super(p);
    }

    @Override
    public int[][] getPossibleMoves(Cell[][] board, int x, int y) {
        return new int[2][2];
    }

    public String getLabel() {
        return super.getLabel() + "Q";
    }
}

class King extends Piece {
    public King(Player p) {
        super(p);
    }

    @Override
    public int[][] getPossibleMoves(Cell[][] board, int x, int y) {
        return new int[2][2];
    }

    public String getLabel() {
        return super.getLabel() + "T";
    }
}


class Cell {
    private boolean color;
    private Piece piece;
    int x, y;

    public Cell(boolean color) {
        this.color = color;
    }

    public void putPiece(Piece piece) {
        this.piece = piece;
    }

    private void removePiece() {
        this.piece = null;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public boolean getColor() {
        return this.color;
    }
}




class Game {
    private Cell[][] board;

    public Game() {
        this.board = new Cell[8][8];

        boolean color = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(color);
                color = !color;
            }
            color = !color;
        }

        Player p1 = new Player(true);
        Player p2 = new Player(false);

        for (int j = 0; j < 8; j++) {
            board[6][j].putPiece(new Pawn(p1));
        }
        for (int j = 0; j < 8; j++) {
            board[1][j].putPiece(new Pawn(p2));
        }

        board[0][0].putPiece(new Rook(p2));
        board[0][7].putPiece(new Rook(p2));
        board[0][1].putPiece(new Knight(p2));
        board[0][6].putPiece(new Knight(p2));
        board[0][2].putPiece(new Bishop(p2));
        board[0][5].putPiece(new Bishop(p2));
        board[0][3].putPiece(new Queen(p2));
        board[0][4].putPiece(new King(p2));

        board[7][0].putPiece(new Rook(p1));
        board[7][7].putPiece(new Rook(p1));
        board[7][1].putPiece(new Knight(p1));
        board[7][6].putPiece(new Knight(p1));
        board[7][2].putPiece(new Bishop(p1));
        board[7][5].putPiece(new Bishop(p1));
        board[7][4].putPiece(new Queen(p1));
        board[7][3].putPiece(new King(p1));


        this.getBoardStatus();
    }

    public void getBoardStatus() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getPiece() == null) {
                    String val = board[i][j].getColor() ? "OO" : "XX";
                    System.out.print(val + " ");
                } else {
                    System.out.print(board[i][j].getPiece().getLabel() + " ");
                }
            }
            System.out.println();
        }
    }
}


public class Chess {
    public static void main(String[] args) {
        Game game = new Game();
    }
}
