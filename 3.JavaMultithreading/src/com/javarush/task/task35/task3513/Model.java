package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score = 0;
    protected int maxTile = 2;
    private boolean isSaveNeeded = true;
    private Stack previousStates = new Stack();
    private Stack previousScores = new Stack();

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value) {
                    return true;
                }
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value) {
                    return true;
                }
            }
        }return false;
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                    gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();


    }

    private ArrayList<Tile> getEmptyTiles(){
        ArrayList<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }
    private void addTile(){
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles != null && !emptyTiles.isEmpty()) {
            // Random random = new Random();
            int randomTileNumber = (int) (Math.random() * emptyTiles.size()); //random.nextInt(emptyTiles.size());
            emptyTiles.get(randomTileNumber).value = (Math.random() < 0.9 ? 2 : 4);
        }

    }

    private boolean compressTiles(Tile[] tiles){
        boolean change = false;
        for (int i = 0; i < tiles.length; i++) {
            if(tiles[i].value == 0&& i < tiles.length - 1 && tiles[i + 1].value != 0){
                change = true;
                Tile temp = tiles[i];
                tiles[i] = tiles[i + 1];
                tiles[i + 1] = temp;
                i = -1;
            }
        }
        return change;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean change = false;
        for (int i = 1; i < tiles.length; i++) {
            if(tiles[i].value == tiles[i - 1].value && tiles[i].value!=0){
                change = true;
                tiles[i - 1].value = tiles[i].value * 2;
                score += tiles[i-1].value;
                if(tiles[i - 1].value > maxTile){
                    maxTile = tiles[i - 1].value;
                }
                int k = i + 1;
                for (int j = i; j < tiles.length; j++) {
                    if(j == tiles.length - 1){
                        tiles[j] = new Tile();
                    } else {
                        tiles[j] = tiles[k];
                        k++;
                    }
                }
            }
        }
        return change;
    }

    public void left(){
        if (isSaveNeeded)
            saveState(gameTiles);
        int j = 0;
        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]))
                j++;
        }
        isSaveNeeded = true;
        if (j != 0) {
            addTile();
        }
    }

    public void rotate(){
        for (int i = 0; i < FIELD_WIDTH/2; i++){
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++){
                Tile tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH - 1 - j][i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[j][FIELD_WIDTH - 1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = tmp;

            }
        }
    }

    public void right(){
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }
    public void up(){
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();

    }
    public void down(){
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();

    }
    private void saveState(Tile[][] tile){
        Tile[][] newtiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tile.length; i++){
            for (int j = 0; j < tile[i].length; j++){
                newtiles[i][j] = new Tile(tile[i][j].value);

            }
        }
        previousStates.push(newtiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }
    public void rollback(){
        if (!previousStates.isEmpty()){
            gameTiles = (Tile[][])previousStates.pop();
        }
        if (!previousScores.isEmpty()){
            score = (int) previousScores.pop();
        }
    }

    public void randomMove(){
        switch (((int) (Math.random() * 100)) % 4){
            case 0: {
                left();
                break;
            }
            case 1:{
                right();
                break;
            }
            case 2:{
                up();
                break;
            }
            case 3:{
                down();
                break;
            }

        }
    }
    public boolean hasBoardChanged(){
        int sumN = 0;
        int sumPrev = 0;
        Tile[][] temp = (Tile[][]) previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++){
            for (int j = 0; j < gameTiles[i].length; j++){
                sumN += gameTiles[i][j].value;
                sumPrev += temp[i][j].value;
            }
        }
        return sumN != sumPrev;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged())
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }


}
