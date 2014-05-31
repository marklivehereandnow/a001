/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.engine;

//import com.livehereandnow.ages.card.Card;
import com.livehereandnow.ages.card.AgesCard;
import com.livehereandnow.ages.exception.AgesException;
import com.livehereandnow.ages.field.Field;
import com.livehereandnow.ages.field.Player;
import com.livehereandnow.ages.field.Points;
import com.livehereandnow.ages.server.AgesGameServerJDBC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/**
 *
 * @author mark
 */
public class AgesEngine {

    private AgesGameServerJDBC server;
//    private EngineCore core;
    private Field field;
    private Player player;
//    private AgesCard card;
    private String debug;

    public Player getPlayer(int player) {
        switch (player) {
            case 1:
                return field.getP1();
            case 2:
                return field.getP2();
            default:
                return new Player("UNKNOWN");

        }
    }

    public List<AgesCard> getPlayerSector(int player, int sector) {
        return getPlayer(player).getSector(sector);
    }

    public String getDebug() {
        return debug;
    }

    public void setDebgug(String str) {
        debug = str;
    }

    public void moveOneCard(List<AgesCard> from, int index, List<AgesCard> to) {

        to.add(from.remove(index));
    }

    public Field getField() {
        return field;
    }

    public AgesCard getNOCARD() {
        return field.getNOCARD();

    }

    public AgesCard getCardFromCardRow(int index) {

        try {
            return field.getCardRow().get(index);
        } catch (Exception ex) {
            return field.getNOCARD();
        }
    }

    public AgesEngine() throws AgesException {
        server = new AgesGameServerJDBC();
        init();

    }

    private void init() {
        field = new Field();
        field.reset();
    }

    String returnStr = " return str...";

    public String getFeedback() {
//        return core.getCardRowInfo();
//        return core.getFeedback();
//        return returnStr;
        return "...";
    }

    public void setFeedback(String str) {
        returnStr = str;
    }

    public boolean parser(String cmd) throws IOException, AgesException {
        setDebgug("...start to parse " + cmd);
        //
        // 1. init
        //
        int tokenCnt = 0;//命令行裡共有幾個字，給予初值為0
        String keyword = "";//指令是什麼，給予初值空字符串
        int p1 = -1;//指令的參數是什麼，給予初值為-1，-1通常是指不能用的值
        int p2 = -1;
        int p3 = -1;

        //
        // 2. parser to words 
        //
        //將命令行的句子拆解為字，以空格格開為依據，空格都不記
        String[] strTokens = cmd.split(" ");
        List<String> tokens = new ArrayList<>();
        for (String item : strTokens) {
            if (item.length() > 0) {
                tokens.add(item);
            }
        }
        tokenCnt = tokens.size();//賦予變量tokenCnt真正的值，真正的值是指到底打個幾個字

        //
        // 3. to execute command based on size
        //
        if (tokenCnt == 0) {//when simple enter
            return true; // silently ignore it
        }
        // 
        keyword = tokens.get(0);//指令的關鍵字是第0個字，例如take 3的take

        if (tokenCnt == 1) {//如果輸入的是一個字的話
            String feedback = doCmd(keyword);
            setDebgug(feedback);

            System.out.println("123456789");
            field.getP1().更新文明板塊上所提供的數據();
            field.getP2().更新文明板塊上所提供的數據();

            return true;
        }
        if (tokenCnt == 2) {//如果輸入的是2個字的話
            try {
                p1 = Integer.parseInt(tokens.get(1));
            } catch (Exception ex) {
                System.out.println("Parameter must be integer!");
                return false;
            }
            return doCmd(keyword, p1);
        }

        if (tokenCnt == 3) {//如果輸入的是2個字的話
            try {
                p1 = Integer.parseInt(tokens.get(1));
                p2 = Integer.parseInt(tokens.get(2));
            } catch (Exception ex) {
                System.out.println("Parameter must be integer!");
                return false;
            }
            return doCmd(keyword, p1, p2);
        }

        // ver 0.62 for upgrad 3 0 1, Upgrad Farm from Age A to Age I
        if (tokenCnt == 4) {//如果輸入的是3個字的話
            try {
                p1 = Integer.parseInt(tokens.get(1));
                p2 = Integer.parseInt(tokens.get(2));
                p3 = Integer.parseInt(tokens.get(3));
            } catch (Exception ex) {
                System.out.println("Parameter must be integer!");
                return false;
            }

            return doCmd(keyword, p1, p2, p3);
        }

        //
//        System.out.println("Cureently command must be one or two words only!");
//        setFeedback("   unknown command," + cmd + ", just ignore it!");
//        setFeedback();
        setDebgug("[parser]: unknown command," + cmd + ", just ignore it!");
        System.out.println("123456789");
        field.getP1().更新文明板塊上所提供的數據();
        field.getP2().更新文明板塊上所提供的數據();
        return false;

    }

    public boolean doCmd(int id) throws IOException, AgesException {
//        return field.
        field.showCardInfo(id);

        return true;
    }

    public String doCmd(String keyword) throws IOException, AgesException {
        switch (keyword) {
            case "9999":
                field.getP1().更新文明板塊上所提供的數據();
                field.getP2().更新文明板塊上所提供的數據();
                return "9999";
            case "server":

                return doServer();
            case "new-game":
                return doNewGame();
            case "p"://工人區_黃點 
                return doPopulation();

            case "act":
                return actActV1();
            case "list":
                return doList();
            case "start":
                return doStart();
            case "increase-population"://v0.52
            case "population"://v0.52
//                return core.doIncreasePopulation();
            case "revolution"://v0.39
//                return core.doRevolution();
            case "govt"://v0.39
            case "change-government"://v0.39
//                return core.doChangeGovernment();

            case "construct-wonder":
            case "wonder":
            case "w":
//                return core.doConstructWonder();

            case "help":
//                return core.doHelp();
            case "h":
//                return core.doHelpShort();
            case "s":
            case "status":
//                return core.doStatus();
                field.show(0);
                return " just did field.show(0)";
            case "ss":
                field.show(10);
                return " just did field.show(10)";
            case "version":
                return doVersion();
            case "shuffle":
                return shuffle();
            case "change-turn":
            case "c":
            case "":
                return doChangeTurn();
            case "cc":

                doChangeTurnV2();
                return " just did doChangeTurnV2()";
            case "change-stage":
            case "cs":
                doChangeStage();
                return " just did doChangeStage()";
            case "to":
            case "tt":

                return do拿牌打牌測試用();

            default:
                System.out.println("Unknown keyword, " + keyword);
                return "Unknown keyword, " + keyword;
        }

    }

    public boolean doCmd(String keyword, int val) throws IOException, AgesException {
        switch (keyword) {
            case "status":
            case "s":
                return doStatus(val);
            case "list":
                return doList(val);

            case "b":
            case "build":
                actBuild(val);

                return true;

            case "act":
                return actAct(val);
            case "打":
            case "p":
            case "o":
            case "out":

            case "play":
            case "play-card":
            case "out-card":
                return actPlayCard(val);
            case "military":
            case "m":
                return actPlayMilitaryCard(val);
            case "oo":
//                return core.doPlayCard革命(val);
            case "拿"://在我的環境NetBeans無法執行，但是在DOS可以
            case "拿牌":
            case "t":
            case "take":
            case "take-card":
                return actTakeCard(val);
            case "doEvent":
            case "e":
                return doEvent(val);
            default:
                System.out.println("Unknown keyword, " + keyword);
                return false;
        }
    }

    public boolean doCmd(String keyword, int p1, int p2) throws IOException, AgesException {
        switch (keyword) {
            case "upgrade":
            case "u":
                return actUpgrade(p1, p2);

            default:
                System.out.println("Unknown keyword, " + keyword);
                return false;
        }
    }

    public boolean doCmd(String keyword, int p1, int p2, int p3) throws IOException, AgesException {
        switch (keyword) {
            case "upgrade":
            case "u":
//                return core.doUpgrade(p1, p2, p3);

            default:
                System.out.println("Unknown keyword, " + keyword);
                return false;
        }
    }

    public String doVersion() {
        //  System.out.println(" TODO   [A內政-亞歷山大圖書館 科技生產+1，文化生產+1，內政手牌上限+1，軍事手牌上限+1]  ");
        //getBuildingLimit()

        System.out.println("  === ver 0.5 ===  2014-5-12, 12:32, by Max　");
        System.out.println("    1.處理回合數內的生產");

        System.out.println("  === ver 0.4 ===  2014-5-12, 12:32, by Max　");
        System.out.println("    1.要處理回合數");

        System.out.println("  === ver 0.3 ===  2014-5-12, 11:45, by Max　");
        System.out.println("    1.準備作交換玩家");
        System.out.println("  === ver 0.2 ===  2014-5-12, 10:05, by Max　");
        System.out.println("    Done 需要增加setCurrentPlayer");
        System.out.println("    1.建立騎兵區、炮兵區、空軍區、劇院區、圖書館區、競技場區");
        System.out.println("  === ver 0.1 ===  2014-5-10, 16:47, by Max　");
        System.out.println("    1. 建立遊戲引擎的變量，能夠運作的地方");

        return " just did doVersion";
    }

    public String getCurrentPlayer() {
        return field.getCurrentPlayer().getName();
    }

    private String doNewGame() {
        field.reset();
        return "New Game is set!";
    }

    private boolean actPlayCard(int val) {
        field.getCurrentPlayer().actPlayCard(val);
        return true;
    }

    public boolean actTakeCardBySeq(int seq) {
        AgesCard ac;
        for (int k = 0; k < 13; k++) {
            ac = field.getCardRow().get(k);
            if (ac.getSeq() == seq) {
                return actTakeCard(k);
            }
        }

        return true;
    }

    public boolean actPlayCardBySeq(int seq) {
        int index = 0;
        for (AgesCard ac : field.getCurrentPlayer().get手牌內政牌區()) {
            if (ac.getSeq() == seq) {
                return actPlayCard(index);
            }
            index++;
        }
        return true;
    }

    public boolean actPlayMilitaryCardBySeq(int seq) {
        int index = 0;
        for (AgesCard ac : field.getCurrentPlayer().get手牌軍事牌區()) {
            if (ac.getSeq() == seq) {
                System.out.println("actPlayMilitaryCardBySeq seq=" + seq);
                System.out.println("going to actPlayMilitaryCard index=" + index);
                return actPlayMilitaryCard(index);
            }
            index++;
        }
        return true;
    }

    private boolean actTakeCard(int val) {

        int[] cardCost = {1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        int cost = cardCost[val];
        player = field.getCurrentPlayer();

//        目前拿牌不扣內政點
//        if (player.get內政點數().getVal() < cardCost[cost]) {
//            System.out.println("NOT ENOUGH 內政點數");
//            return false;
//        }
        AgesCard card = field.getCardRow().get(val);//宣告 card，並將卡牌列裡的指定編號的卡牌指定到這個card變量裡
        if (card.getId() == 1000) {
            System.out.println("這裡沒有牌");
            return true;
        }

        //奇蹟 is the only one not go to ON-HAND
        if (card.getTag().equals("奇蹟")) {
            List<AgesCard> list = field.getCurrentPlayer().get建造中的奇蹟區();
            while (list.size() > 0) { // easy for dev
                list.remove(0);
            }
            list.add(card);//當前玩家的手牌加入上一行的card
            field.getCardRow().remove(val);//從卡牌列拿掉剛剛那張card

            field.getCardRow().add(val, field.getNOCARD());//在卡牌列同樣的位子，補上一張空卡

            //
            // to start to track stages
            //
            field.getCurrentPlayer().init建造中的奇蹟區();

            player.pay內政點數(cost);
        } else {//除了奇蹟牌以外
            field.getCurrentPlayer().get手牌內政牌區().add(card);//當前玩家的手牌加入上一行的card
            field.getCardRow().remove(val);//從卡牌列拿掉剛剛那張card
            field.getCardRow().add(val, field.getNOCARD());//在卡牌列同樣的位子，補上一張空卡
            player.pay內政點數(cost);
        }
        return true;
    }

    private String doStart() {
        //
        field.reset();
        field.set現在階段(field.內政階段);
        System.out.println(" just update set現在階段 to be " + field.get當前時代());
        //卡牌列
        for (int k = 0; k < 13; k++) {
            field.moveOneCard(field.get時代A內政牌(), 0, field.getCardRow());
        }

        for (int k = 0; k < 4; k++) {
            field.moveOneCard(field.get時代A軍事牌(), 0, field.get當前事件());
        }
        // AAA 內政點數=1, BBB 內政點數=2
        for (int turnOrder = 1; turnOrder <= field.getAllPlayers().size(); turnOrder++) {
            Player player = field.getCurrentPlayer();
            player.get內政點數().setVal(turnOrder);
//            player.update手牌上限();
            field.交換玩家();
        }
        //
        //
        //
        return "jsut did doStart()";
    }

    private String doChangeTurn() {

        //檢測暴動();
        field.getCurrentPlayer().compute當回合文化and科技and軍力();

        //執行生產
        field.getCurrentPlayer().produce();

        //抽取軍事牌
        int draw = field.getCurrentPlayer().get軍事點數().getVal();
        if (draw > 3) {
            draw = 3;
        }
        for (int k = 0; k < draw; k++) {
            switch (field.get當前時代()) {
                case 0:
                    System.out.println("抽取時代 " + field.get當前時代() + " 的軍事牌");
                    field.moveOneCard(field.get時代A軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
                    break;
                case 1:
                    System.out.println("抽取時代 " + field.get當前時代() + " 的軍事牌");
                    field.moveOneCard(field.get時代I軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
                    break;
                case 2:
                    System.out.println("抽取時代 " + field.get當前時代() + " 的軍事牌");
                    field.moveOneCard(field.get時代II軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
                    break;
                case 3:
                    System.out.println("抽取時代 " + field.get當前時代() + " 的軍事牌");
                    field.moveOneCard(field.get時代III軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
                    break;
                default:
                    System.out.println("不該存在");
            }
        }
        //檢測哪一疊內政牌庫不為0
//        for (int k = 0; k < draw; k++) {
//            if (field.get時代A內政牌().size() != 0) {
//                field.moveOneCard(field.get時代A軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
//            }else if (field.get時代I內政牌().size() != 0) {
//                field.moveOneCard(field.get時代I軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
//            }else if (field.get時代II內政牌().size() != 0) {
//                field.moveOneCard(field.get時代II軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
//            }else if (field.get時代III內政牌().size() != 0) {
//                field.moveOneCard(field.get時代III軍事牌(), 0, field.getCurrentPlayer().get手牌軍事牌區());
//            }
//        }

        //腐敗();
        field.交換玩家();
        // before turn
        if (field.getRound().getVal() == 1) {
            return "this round#1 case, not to update手牌上限 refill內政點數軍事點數";
        }

        field.getCurrentPlayer().update手牌上限();
        field.getCurrentPlayer().refill內政點數軍事點數();
        補牌();
        if (field.getRound().getVal() > 2) {
            field.set現在階段(field.政治階段);
        } else {
            field.set現在階段(field.內政階段);

        }
        return " just did doChangeTurn";
    }

    private boolean doChangeTurnV2() {
        for (int k = 0; k < 46; k++) {
            doChangeTurn();
        }
        return true;
    }

    private boolean doStatus(int val) {
        field.show(val);
        return true;
    }

    private void 補牌() {
//        System.out.println("在這裡作補牌");

//        移除前三張，實際作法是移除前三張增加三張三張空卡
        field.getCardRow().remove(0);
        field.getCardRow().remove(0);
        field.getCardRow().remove(0);
        AgesCard temp = new AgesCard();
        temp.setId(1000);
        temp.setName("");
        temp.setAge(4);
        temp.setTag("");
//        field.getCardRow().add(0, temp);//在卡牌列同樣的位子，補上一張空卡
//        field.getCardRow().add(0, temp);//在卡牌列同樣的位子，補上一張空卡

//      左推
        for (int k = 0; k < field.getCardRow().size(); k++) {
            if (field.getCardRow().get(k).getId() == 1000) {
                field.getCardRow().remove(k);
                k--;

            }
        }
        for (int k = field.getCardRow().size(); k < 13; k++) {

            if (field.get時代A內政牌().size() != 0) {
                field.moveOneCard(field.get時代A內政牌(), 0, field.getCardRow());
                for (int x = 0; x < field.get時代A內政牌().size(); x++) {
                    field.get時代A內政牌().remove(0);
                }
            } else if (field.get時代I內政牌().size() != 0) {
                field.set當前時代(1);
                field.moveOneCard(field.get時代I內政牌(), 0, field.getCardRow());
            } else if (field.get時代II內政牌().size() != 0) {
                field.set當前時代(2);
                field.moveOneCard(field.get時代II內政牌(), 0, field.getCardRow());
            } else if (field.get時代III內政牌().size() != 0) {
                //如果還有牌
                field.set當前時代(3);
                field.moveOneCard(field.get時代III內政牌(), 0, field.getCardRow());
            } else if (field.get時代III內政牌().size() == 0) {
                field.set當前時代(4);
                System.out.println("沒牌了");
                field.getCardRow().add(k, temp);//在卡牌列同樣的位子，補上一張空卡
                if (field.getCurrentPlayer() == field.getP1()) {
                    System.out.println("遊戲要結束了");
                } else {
                    System.out.println("遊戲下回合要結束了");
                }
            }
        }

    }

//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    private String doList() {
//        Set<AgesCard> set=new HashSet(field.getQryCards());

        doList(0);
        return " just did doList(0)";
    }

    private String getSameSizeName(String name) {
        int times = 8 - name.length();
        String cnSpace = "\u3000";
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < times; k++) {
            sb.append("\u3000");
        }
        return name + sb.toString();
    }

    private boolean doList(int style) {

        Map<Integer, AgesCard> map = new HashMap<>();

        for (AgesCard card : field.getQryCards()) {
            map.put(card.getId(), card);
//           System.out.println(" "+card.getId()+" "+card.getName());
        }

//        System.out.println(" map size is " + map.size());
        Set<Integer> idSet = map.keySet();
        List<Integer> idList = new ArrayList<>(idSet);
        Collections.sort(idList);
        for (Integer key : idList) {
            AgesCard card = map.get(key);
            switch (style) {
                case 0:
                    System.out.println(card.getTag() + " " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction().trim() + " " + card.getIconPoints() + " " + card.getEffect());
                    break;
                case 1:
                    if (card.getAction().length() > 0) {
                        System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());

//                        \u3000
                    }
                    break;
                case 2:
                    if (card.getIconPoints().length() > 0) {

                        System.out.println(" " + key + " " + card.getName() + " " + card.getIconPoints());
                    }
                    break;
                case 3:
                    if (card.getEffect().length() > 0) {
                        System.out.println(" " + key + " " + card.getName() + " " + card.getEffect());
                    }
                    break;
                case 4:
                    if (card.getEffectWhite() > 0) {
                        System.out.println(card.getTag() + " " + key + " " + card.getName() + " +白點: " + card.getEffectWhite());
                    }
                    break;
                case 5:
                    if (card.getEffectRed() > 0) {
                        System.out.println(" " + key + " " + card.getName() + " +紅點: " + card.getEffectRed());
                    }
                    break;
                case 6:
                    if (card.getEffectSmile() > 0) {
                        System.out.println(" " + key + " " + card.getName() + " +笑臉: " + card.getEffectSmile());
                    }
                    break;
                case 7:
                    if (card.getTag().equals("行動")) {
                        System.out.println("時代:" + card.getAge() + " " + card.getTag() + " " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction().trim() + " " + card.getIconPoints() + " " + card.getEffect());
                    }
                    break;
                case 8:
                    if (card.getTag().equals("事件")) {
                        System.out.println("時代:" + card.getAge() + " " + card.getTag() + " " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction().trim() + " " + card.getIconPoints() + " " + card.getEffect());
                    }
                    break;
                case 9:
                    if (card.getTag().equals("礦山")) {
                        System.out.println("時代:" + card.getAge() + " " + card.getTag() + " " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction().trim() + " " + card.getIconPoints() + " " + card.getEffect());
                    }
                    break;
                case 10:
                    if (card.getTag().equals("實驗室")) {
                        System.out.println("時代:" + card.getAge() + " " + card.getTag() + " " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction().trim() + " " + card.getEffect());
                    }
                    break;
                default:
                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction().trim());

            }
        }
        System.out.println("");
        System.out.println(" list 4      SHOW +白點");
        System.out.println(" list 5      SHOW +紅點");
        System.out.println(" list 6      SHOW 笑臉");
        System.out.println(" list 7      SHOW TAG=行動");
        System.out.println(" list 8      SHOW TAG=事件");
        System.out.println(" list 9      SHOW TAG=礦山");
        System.out.println(" list 10      SHOW TAG=實驗室，只顯示Effect");
        return true;

    }

    private boolean actBuild(int val) {
        System.out.println("按卡號build,適合所有的情況, including 奇蹟區");
        field.getCurrentPlayer().actBuild(val);

        return true;
    }

    private boolean actAct(int val) {
        System.out.println("執行行動牌");
//           System.out.println(field.getCurrentPlayer().get行動牌暫存區().get(0).getName()+"  效果:"+field.getCurrentPlayer().get行動牌暫存區().get(0).getAction());
        field.getCurrentPlayer().actAct(val);

        return true;
    }

    private String do拿牌打牌測試用() {
//        for(int k=0;)
        actTakeCard(0);
        actPlayCard(0);

        actTakeCard(1);
        actPlayCard(0);

        actTakeCard(2);
        actPlayCard(0);

        actTakeCard(3);
        actPlayCard(0);

        actTakeCard(4);
        actPlayCard(0);
        doChangeTurn();
        field.show(1);
        return "測試";
    }

    private String doPopulation() {
        field.getCurrentPlayer().act擴充人口();
        return " just did 擴充人口";
    }

    private boolean actUpgrade(int p1, int p2) {
        field.getCurrentPlayer().actUpgrade(p1, p2);
        return true;
    }

    private String doServer() {
        String idx13 = field.getServerStatus();
        server.updateGameLiveCardRow(idx13);

        return " updated DB";
    }

    private String actActV1() {
        System.out.println("執行行動牌");
//           System.out.println(field.getCurrentPlayer().get行動牌暫存區().get(0).getName()+"  效果:"+field.getCurrentPlayer().get行動牌暫存區().get(0).getAction());
        field.getCurrentPlayer().actActV1();

        return "just did 執行行動牌";
    }
// private void doEvent() {
// 
// }
// 

    private void doChangeStage() {
        field.set現在階段(field.內政階段);
    }

    private boolean actPlayMilitaryCard(int val) {
//            field.getCurrentPlayer().actPlayMilitaryCard(val);
        if (val > field.getCurrentPlayer().手牌軍事牌區.size() - 1) {
            System.out.println("我無法作出這個動作，我這個位置沒有牌");
            return true;
        }
        AgesCard card = field.getCurrentPlayer().手牌軍事牌區.get(val);
        System.out.println("actPlayMilitaryCard, index is " + val + " and card name is " + card.getName() + " " + card.getTag());
//        System.out.println(""+card.getCostRevolution());
//        System.out.println("打出這張牌需要花費(" + card.getCostIdea() + ")科技");
        switch (card.getTag()) {
            case "事件":
            case "領土":
                System.out.println("將Tag= 事件 or 領土 牌放入未來事件");
                moveOneCard(field.getCurrentPlayer().手牌軍事牌區, val, field.get未來事件());
                field.getCurrentPlayer().get文化().addPoints(card.getAge());//放事件得分數
                System.out.println("依照牌的時代給予" + card.getAge() + "分");
                if (field.get現在發生事件().size() != 0) {
                    field.get現在發生事件().remove(0);
                }
                moveOneCard(field.get當前事件(), 0, field.get現在發生事件());
                if (field.get當前事件().size() == 0) {
                    Collections.shuffle(field.get未來事件());
                    for (int j = 0; j < 4; j++) {
                        for (int k = 0; k < 3; k++) {
                            if (field.get未來事件().get(k).getAge() > field.get未來事件().get(k + 1).getAge()) {
                                moveOneCard(field.get未來事件(), k, field.get未來事件());
                                k--;
                            }
                        }
                    }
                    moveOneCard(field.get未來事件(), 0, field.get當前事件());
                    moveOneCard(field.get未來事件(), 0, field.get當前事件());
                    moveOneCard(field.get未來事件(), 0, field.get當前事件());
                    moveOneCard(field.get未來事件(), 0, field.get當前事件());
                }
//                Collections.shuffle(時代A內政牌);
//                field.getCurrentPlayer().科技.addPoints(-card.getCostIdea());
                break;

            default:
                System.out.println("現在只針對事件卡");

        }

        //
        // 06/16 13:30, by Mark
        //
//        update手牌上限();
        //
        // 06/16 13:30, by Mark
        //
        return true;
    }

    private String shuffle() {
        Collections.shuffle(field.get當前事件());
        return "123";
    }

    private boolean doEvent(int val) throws IOException {
        System.out.println("現在執行卡號ID為:" + val + "的事件");
        System.out.println("只執行Tag=事件");
//        System.out.println(field.get現在發生事件().get(0).getAction());
        switch (val) {
            case 8888:
                System.out.println(field.getCurrentPlayer().get文明所需的笑臉());
                break;
            case 9999:
                field.getP1().更新文明板塊上所提供的數據();
                break;
            case 1005:
                field.getP1().act擴充人口();
                field.getP2().act擴充人口();
                break;
            case 1006:
                field.set當前操作玩家(field.getCurrentPlayer());
                InputStreamReader cin = new InputStreamReader(System.in);
                BufferedReader in = new BufferedReader(cin);
                System.out.println(field.get當前操作玩家().getName() + "是否將一名閒置工人免費升級為戰士(Y/N)");
                if (in.readLine().equalsIgnoreCase("Y")) {
                    System.out.println(field.get當前操作玩家().getName() + "決定閒置工人免費升級為戰士");
                    field.get當前操作玩家().get步兵區().get(0).setTokenYellow(field.get當前操作玩家().get步兵區().get(0).getTokenYellow() + 1);
                } else {
                    System.out.println(field.get當前操作玩家().getName() + "決定不把閒置工人免費升級為戰士");
                }
                field.交換當前操作玩家();
                System.out.println(field.get當前操作玩家().getName() + "是否將一名閒置工人免費升級為戰士(Y/N)");
                if (in.readLine().equalsIgnoreCase("Y")) {
                    System.out.println(field.get當前操作玩家().getName() + "決定閒置工人免費升級為戰士");
                    field.get當前操作玩家().get步兵區().get(0).setTokenYellow(field.get當前操作玩家().get步兵區().get(0).getTokenYellow() + 1);
                } else {
                    System.out.println(field.get當前操作玩家().getName() + "決定不把閒置工人免費升級為戰士");
                }
                field.交換當前操作玩家();
                break;

            case 1008:
//                field.getP1().get內政區
                field.getP2().act擴充人口();

                break;
            case 1019:
                field.getP1().獲得資源(9);
                field.getP2().獲得資源(5);
                break;
            case 1129:
//                                行動:所有的文明每有一個不高興的工人，就失去四點文明分數
//                                
//13.2.1 [不高興的工人]=[文明所需要的笑臉]-[文明當前笑臉]
//                System.out.println("AAA所需要的笑臉數=" + field.getP1().get文明所需的笑臉());
//                System.out.println("BBB所需要的笑臉數=" + field.getP2().get文明所需的笑臉());
                int p1不高興的工人數 = field.getP1().get文明所需的笑臉() - field.getP1().get笑臉_幸福指數().getVal();
                if (p1不高興的工人數 > 0) {
                    field.getP1().get文化().addPoints(p1不高興的工人數 * (-4));
                    System.out.println("AAA失去"+p1不高興的工人數 * (4)+"文化");
                }
                
                int p2不高興的工人數 = field.getP2().get文明所需的笑臉() - field.getP2().get笑臉_幸福指數().getVal();
                
                if (p2不高興的工人數 > 0) {
                    field.getP2().get文化().addPoints(p2不高興的工人數 * (-4));
                    System.out.println("BBB失去"+p2不高興的工人數 * (4)+"文化");
                
                }
            /*
             
             case :
             break;
             case :
             break;
             case :
             break;
             case :
             break;
             case :
             break;
             case :
             break;
             case :
             break;
             case :
             break;
             */

            default:
        }
        return true;
    }
}
