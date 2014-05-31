package com.livehereandnow.ages.field;

//import com.livehereandnow.ages.components.CardArray;
import com.livehereandnow.ages.card.AgesCard;
import com.livehereandnow.ages.card.AgesCardFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import com.livehereandnow.ages.components.Points;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mark
 */
public class Field {

    AgesCardFactory cardFactory;
    private List<AgesCard> allCards;
    private List<AgesCard> qryCards;
    private List<AgesCard> 卡牌列;
    private List<AgesCard> 時代A內政牌;
    private List<AgesCard> 時代I內政牌;
    private List<AgesCard> 時代II內政牌;
    private List<AgesCard> 時代III內政牌;
    private List<AgesCard> 時代A軍事牌;
    private List<AgesCard> 時代I軍事牌;
    private List<AgesCard> 時代II軍事牌;
    private List<AgesCard> 時代III軍事牌;
    private List<AgesCard> 未來事件;
    private List<AgesCard> 當前事件;
    private List<AgesCard> 現在發生事件;

    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Player 當前操作玩家;
    private List<Player> allPlayers;
    private int 當前時代;
    private int 現在階段;
    public final int 政治階段 = 1;
    public final int 內政階段 = 2;

    public Player get當前操作玩家() {
        return 當前操作玩家;
    }

    public void set當前操作玩家(Player 當前操作玩家) {
        this.當前操作玩家 = 當前操作玩家;
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public int get現在階段() {
        return 現在階段;
    }

    public void set現在階段(int 現在階段) {
        this.現在階段 = 現在階段;
    }

//    public String getCurrentStage(){
//        if (當前時代==政治階段){
//            return "政治階段";
//        }
//        if (當前時代==內政階段){
//            return "內政階段";
//        }
//        System.out.println("what is 當前時代?"+當前時代);
//        
//        
//        return "???";
//    }
    public int get當前時代() {
        return 當前時代;
    }

    public void set當前時代(int 當前時代) {
        this.當前時代 = 當前時代;
    }

    private Points round;

    public List<AgesCard> get現在發生事件() {
        return 現在發生事件;
    }

    public void set現在發生事件(List<AgesCard> 現在發生事件) {
        this.現在發生事件 = 現在發生事件;
    }

    public void 交換玩家() {

        if (currentPlayer == p1) {
            currentPlayer = p2;
            return;
        }
        if (currentPlayer == p2) {
            currentPlayer = p1;
//            System.out.println("auto to next 回合");
            round.addPoints(1);

            return;
        }

    }

    public AgesCard getNOCARD() {
        return cardFactory.getNOCARD();
    }

    public List<AgesCard> getAllCards() {
        return allCards;
    }

    public void moveOneCard(List<AgesCard> from, int index, List<AgesCard> to) {

        to.add(from.remove(index));
    }

    public List<AgesCard> getCardRow() {
        return 卡牌列;
    }

    public List<AgesCard> get時代A內政牌() {
        return 時代A內政牌;
    }

    public List<AgesCard> get時代I內政牌() {
        return 時代I內政牌;
    }

    public List<AgesCard> get時代II內政牌() {
        return 時代II內政牌;
    }

    public List<AgesCard> get時代III內政牌() {
        return 時代III內政牌;
    }

    public List<AgesCard> get時代A軍事牌() {
        return 時代A軍事牌;
    }

    public AgesCard getCardByName(List<AgesCard> list, String name) {
        //   List<Card> list=new List<>();
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getName().equals(name)) {
                return list.get(k);
            }
        }
        return null;
    }

    public List<AgesCard> get時代I軍事牌() {
        return 時代I軍事牌;
    }

    public List<AgesCard> get時代II軍事牌() {
        return 時代II軍事牌;
    }

    public List<AgesCard> get時代III軍事牌() {
        return 時代III軍事牌;
    }

    public List<AgesCard> get未來事件() {
        return 未來事件;
    }

    public List<AgesCard> get當前事件() {
        return 當前事件;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    /**
     * 5/15 17:15, by Mark
     */
    public void produce() {
        getCurrentPlayer().produce();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

//    public Player getCurrentPlayer() {
//        return currentPlayer;
//    }
    public Points getRound() {
        return round;
    }

    public List<AgesCard> getAgeCivil(List<AgesCard> list, int age) {
        List<AgesCard> newList = new ArrayList<>();
        for (AgesCard card : list) {
            if (card.getCivilMilitary().endsWith("內政")) {
                if (card.getAge() == age) {
                    newList.add(card);
                    list.remove(card);
                }
            }
        }
        return newList;
    }

    public List<AgesCard> getAgeMilitary(List<AgesCard> list, int age) {
        List<AgesCard> newList = new ArrayList<>();
        for (AgesCard card : list) {
            if (card.getCivilMilitary().endsWith("軍事")) {
                if (card.getAge() == age) {
                    newList.add(card);
                }
            }
        }
        return newList;
    }

    public void showCardInfo(int id) {
//        System.out.println(" qry card id=" + id);
//        System.out.println(" size=" + qryCards.size());

        for (AgesCard card : qryCards) {
            if (card.getId() == id) {
                System.out.println("編號:" + card.getId());
                System.out.println("卡名:" + card.getName());
                System.out.println("類型:" + card.getCivilMilitary());
                System.out.println("時代:" + card.getAge());
                System.out.println("右上:" + card.getTag());
                System.out.println("行動:" + card.getAction());
                System.out.println("成本:" + card.getIconPoints());
                System.out.println("效果:" + card.getEffect());
                System.out.println(card.toString());

//                System.out.println(card.getName());
                return;
            }
        }
    }

    public Field() {
    }

    public void reset() {
        //
        round = new Points("回合");
        round.setVal(0);
        //
        p1 = new Player("AAA");
        p2 = new Player("BBB");
        allPlayers = new ArrayList<>();
        allPlayers.add(p1);
        allPlayers.add(p2);
        currentPlayer = p1;

        //
        cardFactory = new AgesCardFactory();
        allCards = cardFactory.getEntireList();
        qryCards = cardFactory.getEntireList();

        //
        卡牌列 = new ArrayList<>();
        未來事件 = new ArrayList<>();
        當前事件 = new ArrayList<>();
        現在發生事件 = new ArrayList<>();

        //
        //
        //
        時代A內政牌 = cardFactory.getAgeCivil(0);
        時代I內政牌 = cardFactory.getAgeCivil(1);
        時代II內政牌 = cardFactory.getAgeCivil(2);
        時代III內政牌 = cardFactory.getAgeCivil(3);
        時代A軍事牌 = cardFactory.getAgeMilitary(0);
        時代I軍事牌 = cardFactory.getAgeMilitary(1);
        時代II軍事牌 = cardFactory.getAgeMilitary(2);
        時代III軍事牌 = cardFactory.getAgeMilitary(3);

        //
        // Shuffle
        //
        Collections.shuffle(時代A內政牌);
        Collections.shuffle(時代A軍事牌);
        Collections.shuffle(時代I內政牌);
        Collections.shuffle(時代I軍事牌);
        Collections.shuffle(時代II內政牌);
        Collections.shuffle(時代II軍事牌);
        Collections.shuffle(時代III內政牌);
        Collections.shuffle(時代III軍事牌);

        //
        // basic 6 cards for each player
        //
        for (Player player : allPlayers) {
            player.get政府區().add(cardFactory.getCardByName("專制"));
            player.get實驗室().add(cardFactory.getCardByName("哲學"));
            player.get神廟區().add(cardFactory.getCardByName("宗教"));
            player.get農場區().add(cardFactory.getCardByName("農業"));
            player.get礦山區().add(cardFactory.getCardByName("青銅"));
            player.get步兵區().add(cardFactory.getCardByName("戰士"));

            player.get步兵區().get(0).setTokenYellow(1);
            player.get實驗室().get(0).setTokenYellow(1);
            player.get礦山區().get(0).setTokenYellow(2);
            player.get農場區().get(0).setTokenYellow(2);
            player.get人力庫_黃點().setVal(18);
            player.get工人區_黃點().setVal(1);
            player.get資源庫_藍點().setVal(18);

            //
            player.update手牌上限();
        }

    }

    public List<AgesCard> getQryCards() {
        return qryCards;
    }

    public void show(List<AgesCard> list, String title) {

        switch (title) {
            case "卡牌列":
//                System.out.print("\u3000");
//                System.out.print(title + " (" + list.size() + ")");
                System.out.print("卡牌列\u3000");
                if (list.size() == 0) {
                    return;
                }
                System.out.print("(1)");
                for (int k = 0; k <= 4; k++) {
                    System.out.print("" + k + list.get(k).toString(2) + "\t");
                }
                System.out.print("\n\u3000\u3000\u3000\u3000(2)");
                for (int k = 5; k <= 8; k++) {
                    System.out.print("" + k + list.get(k).toString(2) + "\t");
                }
                System.out.print("\n\u3000\u3000\u3000\u3000(3)");
                for (int k = 9; k <= 12; k++) {
                    System.out.print("" + k + list.get(k).toString(2) + "\t");
                }
//                System.out.println("");
                break;
            default:
                System.out.println("");
                System.out.print(title + " (" + list.size() + ")");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(2));
                }

        }

    }
//    
//    public void show(int style) {
//        switch (style) {
//            case 0:
//                round.show();
//                卡牌列.show(1);
//                System.out.println("Current Player: " + currentPlayer.name);
//                break;
//            case 1:
//                p1.show(1);
//                break;
//            case 2:
//                p2.show(1);
//                break;
//            case 11:
//                p1.show(2);
//                break;
//            case 22:
//                p2.show(2);
//                break;
//
//            default:
//                show();
//        }
//    }

//    public void show() {
//        round.show();
//        System.out.println("\nCurrent Player: " + currentPlayer.name);
//        show(卡牌列, "卡牌列");
//        show(時代A內政牌, "時代A內政牌");
//        show(時代I內政牌, "時代I內政牌");
//        show(時代II內政牌, "時代II內政牌");
//        show(時代III內政牌, "時代III內政牌");
//        show(時代A軍事牌, "時代A軍事牌");
//        show(時代I軍事牌, "時代I軍事牌");
//        show(時代II軍事牌, "時代II軍事牌");
//        show(時代III軍事牌, "時代III軍事牌");
//        for (Player player : allPlayers) {
//            player.show();
//        }
//    }
    public void show(int style) {

        switch (style) {
            case 0:
                System.out.println("**********************當前時代:" + this.當前時代 + "  回合:" + round.getVal() + "  Current Player: " + currentPlayer.getName() + " ******************************************************");
                show(卡牌列, "卡牌列");
                show(當前事件, "當前事件");
                show(未來事件, "未來事件");
                show(現在發生事件, "現在發生事件");
                show(時代A軍事牌, "時代A軍事牌");
                show(時代I軍事牌, "時代I軍事牌");
                show(時代II軍事牌, "時代II軍事牌");
                show(時代III軍事牌, "時代III軍事牌");
                allPlayers.stream().forEach((p) -> {
                    p.show();
                });
                break;
            case 1:
                System.out.println("**********************當前時代:" + this.當前時代 + "  回合:" + round.getVal() + "  Current Player: " + currentPlayer.getName() + " ******************************************************");
                show(卡牌列, "卡牌列");
                show(時代A內政牌, "時代A內政牌");
                show(時代I內政牌, "時代I內政牌");
                show(時代II內政牌, "時代II內政牌");
                show(時代III內政牌, "時代III內政牌");
                show(時代A軍事牌, "時代A軍事牌");
                show(時代I軍事牌, "時代I軍事牌");
                show(時代II軍事牌, "時代II軍事牌");
                show(時代III軍事牌, "時代III軍事牌");
                allPlayers.stream().forEach((p) -> {
                    p.show();
                });
                break;
            case 10:
                String[] stage = {" ", "政治階段", "內政階段"};
                System.out.println("當前時代:" + this.當前時代 + "  回合:" + round.getVal() + "  Current Player: " + currentPlayer.getName() + " 目前階段(政治/內政):" + stage[this.現在階段]);
                break;
            default:
                show(卡牌列, "卡牌列");
                currentPlayer.show();
        }

    }

    public String getServerStatus() {
        StringBuilder sb = new StringBuilder();
        for (AgesCard card : 卡牌列) {
            sb.append(card.getId()).append(",");
        }
        return sb.toString();
    }

    public void 交換當前操作玩家() {
        if (當前操作玩家 == p1) {
            當前操作玩家 = p2;
            return;
        }
        if (當前操作玩家 == p2) {
            當前操作玩家 = p1;
//            System.out.println("auto to next 回合");
            round.addPoints(1);

            return;
        }
    }

}
