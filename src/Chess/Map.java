package Chess;

public class Map
{
    public static Chess[] AllChess=new Chess[33];

    public static int[][] Map =             //棋盘
             {
                    {18,22,24,26,17,27,25,23,19},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0,20, 0, 0, 0, 0, 0,21, 0},
                    {28, 0,29, 0,30, 0,31, 0,32},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {12, 0,13, 0,14, 0,15, 0,16},
                    { 0, 4, 0, 0, 0, 0, 0, 5, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 2, 6, 8,10, 1,11, 9, 7, 3}
            };

    public static int[][] RMap=             //棋盘副本
            {
                    {18,22,24,26,17,27,25,23,19},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0,20, 0, 0, 0, 0, 0,21, 0},
                    {28, 0,29, 0,30, 0,31, 0,32},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {12, 0,13, 0,14, 0,15, 0,16},
                    { 0, 4, 0, 0, 0, 0, 0, 5, 0},
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    { 2, 6, 8,10, 1,11, 9, 7, 3}
            };

    public static int Checkmate()
    {
        if(AllChess[1].Exi==0)
            return 1;
        else if(AllChess[17].Exi==0)
            return 2;
        else return 0;
    }

    public static void Define()
    {
        for (int i = 0; i <= 9; i++)
        {
            for (int k = 0; k <= 8; k++)
            {
                if (Map[i][k] == 1)
                    AllChess[Map[i][k]] = new RGeneral(i, k);
                else if (Map[i][k] == 2 || Map[i][k] == 3)
                    AllChess[Map[i][k]] = new RChariot(i, k);
                else if (Map[i][k] == 4 || Map[i][k] == 5)
                    AllChess[Map[i][k]] = new RCannon(i, k);
                else if (Map[i][k] == 6 || Map[i][k] == 7)
                    AllChess[Map[i][k]] = new RHorse(i, k);
                else if (Map[i][k] == 8 || Map[i][k] == 9)
                    AllChess[Map[i][k]] = new RElephant(i, k);
                else if (Map[i][k] == 10 || Map[i][k] == 11)
                    AllChess[Map[i][k]] = new RGuarder(i, k);
                else if (Map[i][k] == 12 || Map[i][k] == 13 || Map[i][k] == 14 || Map[i][k] == 15 || Map[i][k] == 16)
                    AllChess[Map[i][k]] = new RPawn(i, k);
                else if (Map[i][k] == 17)
                    AllChess[Map[i][k]] = new BGeneral(i, k);
                else if (Map[i][k] == 18 || Map[i][k] == 19)
                    AllChess[Map[i][k]] = new BChariot(i, k);
                else if (Map[i][k] == 20 || Map[i][k] == 21)
                    AllChess[Map[i][k]] = new BCannon(i, k);
                else if (Map[i][k] == 22 || Map[i][k] == 23)
                    AllChess[Map[i][k]] = new BHorse(i, k);
                else if (Map[i][k] == 24 || Map[i][k] == 25)
                    AllChess[Map[i][k]] = new BElephant(i, k);
                else if (Map[i][k] == 26 || Map[i][k] == 27)
                    AllChess[Map[i][k]] = new BGuarder(i, k);
                else if (Map[i][k] == 28 || Map[i][k] == 29 || Map[i][k] == 30 || Map[i][k] == 31 || Map[i][k] == 32)
                    AllChess[Map[i][k]] = new BPawn(i, k);
            }
        }
    }
}