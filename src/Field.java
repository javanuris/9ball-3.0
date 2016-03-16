public class Field {
    int varible;
    private  Player playerOne;
    private  Player playerTwo;
    private  int playerBoxOne ;
    private  int playerBoxTwo;

    public Field(){
        playerOne = new Player();
        playerTwo = new Player();
    }

    public Player getPlayerOne() {
        return playerOne;

    }

    public int getPlayerBoxOne() {
        return playerBoxOne;
    }

    public int getPlayerBoxTwo() {
        return playerBoxTwo;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void playerData(){
        for(int i =0; i<=8 ; i++){
            playerTwo.setBalls(i , 9);
            playerOne.setBalls(i , 9);
        }
    }

    public void mainLogicGame(Player player ,int currentBox) {
        int currentValue = player.getBalls(currentBox);

            varible = Math.abs(9 - currentValue-currentBox);


        int minus = 8 - currentBox;

        if(currentBox == 8 && player.getBalls(currentBox)== 1){
            if(player == playerOne) {
                playerOne.setBalls(currentBox, 0);
                playerTwo.setBalls(0, playerTwo.getBalls(0) + 1);
                if(playerTwo.getBalls(0)%2 == 0){
                    playerOne.setKingBalls(0 , playerOne.getBalls(0));
                    playerBoxOne +=playerOne.getKingBalls(0);
                    playerTwo.setBalls(0 , 0);

                }
            }else if(player == playerTwo){
                playerTwo.setBalls(currentBox, 0);
                playerOne.setBalls(0, playerOne.getBalls(0) + 1);
                if(playerOne.getBalls(0)%2 == 0){
                    playerTwo.setKingBalls(0 , playerTwo.getBalls(0));
                    playerBoxTwo +=playerTwo.getKingBalls(0);
                    playerOne.setBalls(0 , 0);
                }
            }
        }
        if(player.getBalls(currentBox) == 1){
            player.setBalls(currentBox , 0);
            player.setBalls(currentBox+1 , player.getBalls(currentBox+1)+1);
        }
        if(player.getBalls(currentBox) == 0){
            player.setBalls(currentBox , 0);
        }

         else {
            player.setBalls(currentBox, 1);
            for (int i = 0; i <= minus; i++) {
                if (i == 0)
                    player.setBalls(currentBox + i, player.getBalls(currentBox + i));
                else
                    player.setBalls(currentBox + i, player.getBalls(currentBox + i) + 1);
            }
            if (varible <= 0) {

            } else {
                if (player == playerOne) {
                    playerOneFirst(varible);
                }
                if (player == playerTwo) {
                    playerTwoFirst(varible);
                }
            }
        }
    }
    public void playerOneFirst(int x){
        System.out.println(x + "Это Х");
        int s = x;
        int b = x;
        int c = -1;
        if(s <=8){
            for(int i =0; i <= b-1 ; i++){
              playerTwo.setBalls(i , playerTwo.getBalls(i)+1);
                s--;
                c++;
            }
            if( playerTwo.getBalls(c)%2 ==0){
                playerOne.setKingBalls(0 , playerTwo.getBalls(c));
                playerBoxOne +=playerOne.getKingBalls(0);
                playerTwo.setBalls(c,0);

            }
        }else if(s >8){
            for (int i = 0; i <= 8; i++) {
                playerTwo.setBalls(i, playerTwo.getBalls(i) + 1);
                s--;
            }
        }
        if (s > 0) {
            playerOneSecond(s);
        }


    }
    public void playerOneSecond(int x){
        System.out.println(x);
        int s = x;
        if(s <=8){
            for(int i =0; i <= x ; i++){
                playerOne.setBalls(i , playerOne.getBalls(i)+1);
                s--;
            }

        }else if(s >8){
            for (int i = 0; i <= 8; i++) {
                playerOne.setBalls(i, playerOne.getBalls(i) + 1);
                s--;
            }
        }
        if (s >=0) {
          //  playerTwoSecond(s);
        }


    }
    public void playerTwoFirst(int x){
        System.out.println(x);
        int s = x-1;
        int b = x;
        int c = -1;
        if(s <=8){
            for(int i = 0; i <=b-1 ; i++){
                playerOne.setBalls(i , playerOne.getBalls(i)+1);
                s--;
                c++;
            }
            if( playerOne.getBalls(c)%2 ==0){
                playerTwo.setKingBalls(0 , playerTwo.getBalls(c));
                playerBoxTwo +=playerOne.getKingBalls(0);
                playerOne.setBalls(c ,0);
            }
        }else if(s >8){
            for (int i = 1; i <= 8; i++) {
                playerOne.setBalls(i, playerOne.getBalls(i) + 1);
                s--;
            }
        }
        if (s >0) {
      playerTwoSecond(s);
        }
    }
    public void playerTwoSecond(int x){
        System.out.println(x);
        int s = x;
        if(s <=8){
            for(int i = 1; i <= x ; i++){
                playerTwo.setBalls(i , playerTwo.getBalls(i)+1);
                s--;
            };

        }else if(s >8){
            for (int i = 0; i <= 8; i++) {
                playerOne.setBalls(i, playerTwo.getBalls(i) + 1);
                s--;
            }
        }
        if (s > 0) {
            playerOneFirst(s);
        }
    }
}