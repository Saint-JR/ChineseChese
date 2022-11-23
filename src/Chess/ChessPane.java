package Chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Pair;
import javafx.scene.shape.Rectangle;

import java.awt.*;

import static Chess.AI.*;
import static Chess.Map.*;
import static java.lang.Math.abs;

public class ChessPane extends Application {
    //@Override

    final int Map_Width=440;  //地图宽度
    final int Map_Height=496; //地图高度
    final int Image_Side=130; //象棋的边长
    final int Each_Dis=86;    //每格间隔
    final int Origin_Co=30;   //第一格的坐标

    int Chess_Selected=0;

    Object[][] Coordinate=new Object[10][9];
    Image ImageBack     =new Image(String.valueOf(ChessPane.class.getResource("/image/背景.png")));
    Image ImageTitle    =new Image(String.valueOf(ChessPane.class.getResource("/image/标题.png")));
    Image ImageMap      =new Image(String.valueOf(ChessPane.class.getResource("/image/ChessPane.jpg")));
    Image ImageRGeneral =new Image(String.valueOf(ChessPane.class.getResource("/image/红帅.png")));
    Image ImageBGeneral =new Image(String.valueOf(ChessPane.class.getResource("/image/黑将.png")));
    Image ImageRChariot =new Image(String.valueOf(ChessPane.class.getResource("/image/红车.png")));
    Image ImageBChariot =new Image(String.valueOf(ChessPane.class.getResource("/image/黑车.png")));
    Image ImageRCannon  =new Image(String.valueOf(ChessPane.class.getResource("/image/红炮.png")));
    Image ImageBCannon  =new Image(String.valueOf(ChessPane.class.getResource("/image/黑炮.png")));
    Image ImageRHorse   =new Image(String.valueOf(ChessPane.class.getResource("/image/红马.png")));
    Image ImageBHorse   =new Image(String.valueOf(ChessPane.class.getResource("/image/黑马.png")));
    Image ImageRElephant=new Image(String.valueOf(ChessPane.class.getResource("/image/红相.png")));
    Image ImageBElephant=new Image(String.valueOf(ChessPane.class.getResource("/image/黑象.png")));
    Image ImageRGuarder =new Image(String.valueOf(ChessPane.class.getResource("/image/红士.png")));
    Image ImageBGuarder =new Image(String.valueOf(ChessPane.class.getResource("/image/黑士.png")));
    Image ImageRPawn    =new Image(String.valueOf(ChessPane.class.getResource("/image/红兵.png")));
    Image ImageBPawn    =new Image(String.valueOf(ChessPane.class.getResource("/image/黑兵.png")));

    ImageView BackGround=new ImageView(ImageBack);
    ImageView Title=new ImageView(ImageTitle);
    ImageView[] ChessImage=new ImageView[33];

    Label[] Title_Label=new Label[4];
    Label Result_Label=new Label("你输了 哈哈");
    Label Result_Label_2=new Label("你赢了 呜呜");
    Label Choose_Label=new Label("开始游戏");
    Label Difficulty_Easy=new Label("简单");
    Label Difficulty_Normal=new Label("一般");
    Label Difficulty_Hard=new Label("困难");
    Button Result_Button=new Button("呜呜呜");
    Button Result_Button_2=new Button("哈哈哈");

    Rectangle[] Choose_Button=new Rectangle[4];

    Pane Choose_Pane=new Pane();
    Pane ChessPane=new Pane();
    Pane Result=new Pane();
    Pane Result_2=new Pane();

    Scene scene=new Scene(ChessPane,Map_Width*1.7,Map_Height*1.7);
    Scene Title_Scene=new Scene(Choose_Pane,Map_Width*1.7,Map_Height*1.7);
    Scene Result_Scene=new Scene(Result,200,150);
    Scene Result_Scene_2=new Scene(Result_2,200,150);

    Stage Result_Stage=new Stage();

    void Initialize(Stage primaryStage)//初始化
    {
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<9;j++)
            {
                Coordinate[i][j]=new Pair<Integer,Integer>(Origin_Co+j*Each_Dis,Origin_Co+i*Each_Dis);
            }
        }
        ChessImage[0]  =new ImageView((ImageMap      ));
        ChessImage[1]  =new ImageView((ImageRGeneral ));
        ChessImage[2]  =new ImageView((ImageRChariot ));
        ChessImage[3]  =new ImageView((ImageRChariot ));
        ChessImage[4]  =new ImageView((ImageRCannon  ));
        ChessImage[5]  =new ImageView((ImageRCannon  ));
        ChessImage[6]  =new ImageView((ImageRHorse   ));
        ChessImage[7]  =new ImageView((ImageRHorse   ));
        ChessImage[8]  =new ImageView((ImageRElephant));
        ChessImage[9]  =new ImageView((ImageRElephant));
        ChessImage[10] =new ImageView((ImageRGuarder ));
        ChessImage[11] =new ImageView((ImageRGuarder ));
        ChessImage[12] =new ImageView((ImageRPawn    ));
        ChessImage[13] =new ImageView((ImageRPawn    ));
        ChessImage[14] =new ImageView((ImageRPawn    ));
        ChessImage[15] =new ImageView((ImageRPawn    ));
        ChessImage[16] =new ImageView((ImageRPawn    ));
        ChessImage[17] =new ImageView((ImageBGeneral ));
        ChessImage[18] =new ImageView((ImageBChariot ));
        ChessImage[19] =new ImageView((ImageBChariot ));
        ChessImage[20] =new ImageView((ImageBCannon  ));
        ChessImage[21] =new ImageView((ImageBCannon  ));
        ChessImage[22] =new ImageView((ImageBHorse   ));
        ChessImage[23] =new ImageView((ImageBHorse   ));
        ChessImage[24] =new ImageView((ImageBElephant));
        ChessImage[25] =new ImageView((ImageBElephant));
        ChessImage[26] =new ImageView((ImageBGuarder ));
        ChessImage[27] =new ImageView((ImageBGuarder ));
        ChessImage[28] =new ImageView((ImageBPawn    ));
        ChessImage[29] =new ImageView((ImageBPawn    ));
        ChessImage[30] =new ImageView((ImageBPawn    ));
        ChessImage[31] =new ImageView((ImageBPawn    ));
        ChessImage[32] =new ImageView((ImageBPawn    ));

        BackGround.setFitHeight(Map_Height*1.7);
        BackGround.setFitWidth(Map_Width*1.7);
        Title.setLayoutX(30);
        Title.setLayoutY(50);
        Choose_Pane.getChildren().add(BackGround);
        Choose_Pane.getChildren().add(Title);
        for(int i=0;i<4;i++)
        {
            final int THIS=i;
            Choose_Button[i]=new Rectangle(200,100);
            Choose_Button[i].setStroke(Color.BROWN);
            Choose_Button[i].setFill(Color.rgb(255,235,205,0.8));
            Title_Label[i]=new Label();
            Title_Label[i].setFont(Font.font("KaiTi", FontWeight.BOLD, FontPosture.ITALIC,40));
            Title_Label[i].setTextFill(Color.rgb(139,69,19));
            Title_Label[i].setLayoutX(50);
            Title_Label[i].setGraphic(Choose_Button[i]);
            Title_Label[i].setOnMouseEntered(e->{
                Choose_Button[THIS].setFill(Color.rgb(255,160,122,0.3));
            });
            Title_Label[i].setOnMouseExited(e->{
                Choose_Button[THIS].setFill(Color.rgb(255,235,205,0.8));
            });
            Title_Label[i].setOnMousePressed(e->
            {
                Choose_Button[THIS].setFill(Color.rgb(188,143,143));
            });
            Choose_Pane.getChildren().add(Title_Label[i]);
        }
        Title_Label[0].setText("开始游戏");
        Title_Label[1].setText("简单");
        Title_Label[2].setText("一般");
        Title_Label[3].setText("困难");
        Title_Label[0].setLayoutY(480);
        Title_Label[0].setGraphicTextGap(-180);
        for(int i=1;i<4;i++)
        {
            Title_Label[i].setVisible(false);
            Title_Label[i].setGraphicTextGap(-145);
        }
        Title_Label[1].setLayoutY(400);
        Title_Label[2].setLayoutY(550);
        Title_Label[3].setLayoutY(700);
        Title_Label[0].setOnMouseReleased(e->
        {
            Choose_Button[0].setFill(Color.rgb(255,160,122,0.3));
            Title_Label[0].setVisible(false);
            for(int i=1;i<4;i++)
                Title_Label[i].setVisible(true);
        });
        Title_Label[1].setOnMouseReleased(e->
        {
            Choose_Button[1].setFill(Color.rgb(255,160,122,0.3));
            Const_Depth=4;
            primaryStage.setScene(scene);
        });
        Title_Label[2].setOnMouseReleased(e->
        {
            Choose_Button[2].setFill(Color.rgb(255,160,122,0.3));
            Const_Depth=5;
            primaryStage.setScene(scene);
        });
        Title_Label[3].setOnMouseReleased(e->
        {
            Choose_Button[3].setFill(Color.rgb(255,160,122,0.3));
            Const_Depth=6;
            primaryStage.setScene(scene);
        });

        Result_Label.setFont(Font.font("SimHei", FontWeight.BOLD, FontPosture.ITALIC,20));
        Result.getChildren().add(Result_Label);
        Result.getChildren().add(Result_Button);
        Result_Label.setLayoutX(50);
        Result_Label.setLayoutY(60);
        Result_Button.setLayoutX(75);
        Result_Button.setLayoutY(110);
        Result_Button.setOnMousePressed(e->{
            Result_Stage.close();
            primaryStage.close();
        });
        Result_Label_2.setFont(Font.font("SimHei", FontWeight.BOLD, FontPosture.ITALIC,20));
        Result_2.getChildren().add(Result_Label_2);
        Result_2.getChildren().add(Result_Button_2);
        Result_Label_2.setLayoutX(50);
        Result_Label_2.setLayoutY(60);
        Result_Button_2.setLayoutX(75);
        Result_Button_2.setLayoutY(110);
        Result_Button_2.setOnMousePressed(e->{
            Result_Stage.close();
            primaryStage.close();
        });


        for(int i=0;i<33;i++)
        {
            if(i!=0)
            {
                ChessImage[i].setFitWidth(0.67*Image_Side);
                ChessImage[i].setFitHeight(0.67*Image_Side);
            }
            else
            {
                ChessImage[i].setFitWidth(Map_Width*1.7);
                ChessImage[i].setFitHeight(Map_Height*1.7);
            }

            ChessPane.getChildren().add(ChessImage[i]);
        }

        for(int i=1;i<=16;i++)
        {
            final int THIS=i;
            ChessImage[i].setOnMousePressed(e->{
                Chess_Selected=THIS;
                for(int j=1;j<=16;j++)
                {
                    ChessImage[j].setFitWidth(Image_Side*0.67);
                    ChessImage[j].setFitHeight(Image_Side*0.67);
                    Paint();
                }
                ChessImage[THIS].setFitWidth(Image_Side*0.77);
                ChessImage[THIS].setFitHeight(Image_Side*0.77);
                ChessImage[THIS].setX(ChessImage[THIS].getX()-8);
                ChessImage[THIS].setY(ChessImage[THIS].getY()-5);
            });
        }

        ChessPane.setOnMousePressed(e->{
            if(Chess_Selected!=0)
            {
                double Clicked_x=e.getX();
                double Clicked_y=e.getY();
                int Cor_x=0;
                int Cor_y=0;
                for(;Cor_x<10;Cor_x++)
                {
                    for(Cor_y=0;Cor_y<9;Cor_y++)
                    {
                        double Dis_x=abs(Clicked_x-((Pair<Integer,Integer>)Coordinate[Cor_x][Cor_y]).getKey());
                        double Dis_y=abs(Clicked_y-((Pair<Integer,Integer>)Coordinate[Cor_x][Cor_y]).getValue());
                        if(Dis_x<=(Each_Dis/2)&&Dis_y<=(Each_Dis/2))
                            break;
                    }
                    if(Cor_y!=9)
                        break;
                }

                if((Map[Cor_x][Cor_y]>16)||(Map[Cor_x][Cor_y]==0))
                {
                    AllChess[Chess_Selected].MovAtk();
                    for(int i=0;i<AllChess[Chess_Selected].Available_Pos.size();i++)
                    {
                        if(AllChess[Chess_Selected].Available_Pos.get(i).Available_x==Cor_x&&AllChess[Chess_Selected].Available_Pos.get(i).Available_y==Cor_y)
                        {
                            if( Map[Cor_x][Cor_y]==0)
                            {
                                Map[AllChess[Chess_Selected].x][AllChess[Chess_Selected].y]=0;
                                Map[Cor_x][Cor_y]=Chess_Selected;
                                RMap[AllChess[Chess_Selected].x][AllChess[Chess_Selected].y]=0;
                                RMap[Cor_x][Cor_y]=Chess_Selected;
                                AllChess[Chess_Selected].x=Cor_x;
                                AllChess[Chess_Selected].y=Cor_y;
                            }
                            else
                            {
                                int Enemy=Map[Cor_x][Cor_y];
                                Map[AllChess[Chess_Selected].x][AllChess[Chess_Selected].y]=0;
                                Map[Cor_x][Cor_y]=Chess_Selected;
                                RMap[AllChess[Chess_Selected].x][AllChess[Chess_Selected].y]=0;
                                RMap[Cor_x][Cor_y]=Chess_Selected;
                                AllChess[Chess_Selected].x=Cor_x;
                                AllChess[Chess_Selected].y=Cor_y;
                                AllChess[Enemy].Exi=0;
                            }
                            primaryStage.show();
                            MinDeepSearch(Const_Depth,99999,-99999);
                            for (int j = 0; j <= 9; j++)
                            {
                                for (int k = 0; k <= 8; k++)
                                {
                                    if (Best_Map[j][k] != Map[j][k])
                                    {
                                        if (Best_Map[j][k] != 0)
                                        {
                                            if(Map[j][k]!=0)
                                                AllChess[Map[j][k]].Exi = 0;
                                            AllChess[Best_Map[j][k]].x = j;
                                            AllChess[Best_Map[j][k]].y = k;
                                            Map[j][k] = Best_Map[j][k];
                                        }
                                        else Map[j][k] = Best_Map[j][k];
                                    }
                                    RMap[j][k]=Map[j][k];
                                }
                            }
                            Paint();
                        }
                    }
                    ChessImage[Chess_Selected].setFitWidth(Image_Side*0.67);
                    ChessImage[Chess_Selected].setFitHeight(Image_Side*0.67);
                    ChessImage[Chess_Selected].setX(ChessImage[Chess_Selected].getX()+8);
                    ChessImage[Chess_Selected].setY(ChessImage[Chess_Selected].getY()+5);
                    Paint();
                    Chess_Selected=0;
                    //if(Checkmate()==2)
                    if(Checkmate()==1)
                    {
                        Result_Stage.setScene(Result_Scene);
                        Result_Stage.show();
                    }
                    else if(Checkmate()==2)
                    {
                        Result_Stage.setScene(Result_Scene_2);
                        Result_Stage.show();
                    }
                }
            }
        });
    }

    void Paint()//重定义棋子坐标
    {
        for(int i=1;i<33;i++)
        {
            if(AllChess[i].Exi!=0)
            {
                ChessImage[i].setX(((Pair<Integer,Integer>)Coordinate[AllChess[i].x][AllChess[i].y]).getKey()-0.67*Image_Side/2);
                ChessImage[i].setY(((Pair<Integer,Integer>)Coordinate[AllChess[i].x][AllChess[i].y]).getValue()-0.67*Image_Side/2);
            }
            else ChessImage[i].setVisible(false);
        }
    }

    public void start(Stage primaryStage)
    {
        //ChessPane.setStyle("-fx-background-color:gray");
        Define();
        Initialize(primaryStage);
        Paint();


        primaryStage.setTitle("象棋");
        primaryStage.setScene(Title_Scene);
        primaryStage.show();
    }
}
