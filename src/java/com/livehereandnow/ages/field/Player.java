/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.field;

import com.livehereandnow.ages.Sector;
import com.livehereandnow.ages.card.AgesCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Player {

    Score score;

    Token token黃;

    Token token藍;

    final int 人力庫_黃 = 1;

    final int 工人區_黃 = 2;

    final int 資源庫_藍 = 3;

    public Token getToken黃() {

        return token黃;

    }

    public Token getToken藍() {

        return token藍;

    }

    Player() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    private List<AgesCard> 行政牌暫存區;

    public void moveOneCard(List<AgesCard> from, int index, List<AgesCard> to) {

        to.add(from.remove(index));
    }

    public String getName() {
        return name;
    }

    public void pay內政點數(int cost) {
        內政點數.addPoints((-1) * cost);
    }

    public Points get內政點數() {
        return 內政點數;
    }

    public Points get軍事點數() {
        return 軍事點數;
    }

    /**
     * 假設獲得9點資源，該玩家有礦山科技等級0.1.3 系統先從最高等級(III
     * 石油:5石頭)的礦山先放置9點資源，於是9/5=1...4，該礦山藍點數+1
     * 並且剩下4點再從次等級(1等:2石頭)的礦山等級放置4/2=2....0，該礦山藍點點數+2 結束
     *
     * @param val
     */
    public void 獲得資源(int val) {
        System.out.println("正在開發獲得資源");
        System.out.println(getScore().getMap());
        System.out.println(this.getToken藍().getMap());
//       while(val) 
//        effectStone=5,
//        時代:0 礦山 1032 青銅　　　　　　  石頭:2 石頭:1
//時代:1 礦山 1099 鐵礦　　　　　　  燈泡:5;石頭:5 石頭:2
//時代:2 礦山 1150 煤礦　　　　　　  燈泡:7;石頭:8 石頭:3
//時代:3 礦山 1234 石油　　　　　　  燈泡:9;石頭:11 石頭:5

        for (int x = this.礦山區.size() - 1; x >= 0; x--) {
            System.out.println("獲得[" + val + "]點資源");
            System.out.println("這是" + 礦山區.get(x).getAge() + "的礦山");

            //設定礦山藍點為 原本藍點+獲得藍點/礦山效果:石頭
            System.out.println("目標藍點=" + this.礦山區.get(x).getEffectStone() + "點資源");
            System.out.println("現在有" + this.礦山區.get(x).getTokenBlue() + "點藍點，要+" + val / this.礦山區.get(x).getEffectStone() + "個藍點");
            this.礦山區.get(x).setTokenBlue(this.礦山區.get(x).getTokenBlue() + (val / this.礦山區.get(x).getEffectStone()));

//            System.out.println("現在將時代"+礦山區.get(x).getAge()+"的礦山放入"+val/this.礦山區.get(x).getEffectStone()+"個藍點");
            val = val % this.礦山區.get(x).getEffectStone();

            System.out.println("剩下[" + val + "]點資源要處理");

        }
    }

    public Points get建築上限() {
        return 建築上限;
    }

    public Points get內政手牌上限() {
        return 內政手牌上限;
    }

    public void 更新文明板塊上所提供的數據() {
//        暫存應用區
        int val = 0;
        int 內政點數val = 0;
        int 軍事點數val = 0;
        int 建築上限val = 0;
        int 殖民點數val = 0;
        int 文化增加val = 0;
        int 科技增加val = 0;
        int 軍力val = 0;
        int 笑臉val = 0;

        暫存應用區 = new ArrayList<>();
        暫存應用區.addAll(實驗室);

        暫存應用區.addAll(圖書館區);
        暫存應用區.addAll(劇院區);
        暫存應用區.addAll(競技場區);
        暫存應用區.addAll(神廟區);

        暫存應用區.addAll(步兵區);
        暫存應用區.addAll(騎兵區);
        暫存應用區.addAll(炮兵區);
        暫存應用區.addAll(空軍區);

        暫存應用區.addAll(政府區);
        暫存應用區.addAll(領袖區);
        暫存應用區.addAll(this.已完成的奇蹟);

        暫存應用區.addAll(內政區);
        暫存應用區.addAll(殖民區);
        暫存應用區.addAll(軍事區);
        for (int x = 0; x < 暫存應用區.size(); x++) {
//            System.out.println(暫存應用區.get(x).getName());
            switch (暫存應用區.get(x).getTag()) {
                case "實驗室":
                case "圖書館":
                case "劇院":
                case "競技場":
                case "神廟":
                case "步兵":
                case "騎兵":
                case "炮兵":
                case "空軍":
                    if (暫存應用區.get(x).getEffectIdea() != 0) {
                        科技增加val = 科技增加val + (暫存應用區.get(x).getTokenYellow() * 暫存應用區.get(x).getEffectIdea());
                    }
                    if (暫存應用區.get(x).getEffectSmile() != 0) {
                        System.out.println("有笑臉");
                        笑臉val = 笑臉val + (暫存應用區.get(x).getTokenYellow() * 暫存應用區.get(x).getEffectSmile());
                    }
                    break;
                case "政府":
                case "領袖":
                case "奇蹟":
                    if (暫存應用區.get(x).getEffectSmile() != 0) {
                        笑臉val = 笑臉val + 暫存應用區.get(x).getEffectSmile();
                    }
                    break;
                case "內政":
                case "殖民":
                case "軍事":
                    break;
                default:

            }
        }
//        暫存應用區.addAll(戰術區);

        /*
         內政點數   2 　　　　軍事點數   0 　　　　建築上限   0 　　內政手牌上限   4 　　軍事手牌上限   2 　　　　殖民點數   0 
         文化   0 　　　文化﹝＋﹞   0 　　　　　　科技   0 　　　科技﹝＋﹞   1 　　　　　　軍力   0 　笑臉【】   0 
         */
//        for (int x = 0; x < this.實驗室.size(); x++) {
//            System.out.println("現在科技+是" + val + "要處理時代" + 實驗室.get(x).getAge().intValue());
//            System.out.println("要增加" + 實驗室.get(x).getEffectIdea() + "乘" + 實驗室.get(x).getTokenYellow() + "共" + 實驗室.get(x).getEffectIdea() * 實驗室.get(x).getTokenYellow());
//            val = val + (實驗室.get(x).getEffectIdea() * 實驗室.get(x).getTokenYellow());
//            System.out.println("目前的科技+是" + val);
//            System.out.println("==========檢測結束==========");
//        }
        this.科技生產_當回合.setVal(科技增加val);
        this.笑臉_幸福指數.setVal(笑臉val);
    }

    public void init建造中的奇蹟區() {
        wonderStages = new ArrayList<>();
        AgesCard card = 建造中的奇蹟區.get(0);
//            System.out.println(" WE KNOW CURRENT 建造中的奇蹟區 IS " + card.getName() + " " + card.getIconPoints());

        String cost1 = card.getIconPoints();
        String[] cost2 = cost1.split(":");
        String cost3 = cost2[1];
//            System.out.println(" COST IS " + cost3);
        String[] cost4 = cost3.split("-");

        for (String cost5 : cost4) {
//                System.out.println(" " + cost5);
            int cost6 = Integer.parseInt(cost5);
            wonderStages.add(cost6);
        }

    }

    public Points get軍事手牌上限() {
        return 軍事手牌上限;
    }

    public Points get殖民點數() {
        return 殖民點數;
    }

    public Score getScore() {
        return score;
    }

    public void produce() {
        produce文化();
        produce礦山();
        produce科技();
        produce農場();
        Iterator iterator = token黃.getMap().entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();

            if (entry.getKey() > 1000) {

                System.out.println(" K:" + entry.getKey() + " V:" + entry.getValue());

                token藍.moveTokensFromAtoB(entry.getValue(), 資源庫_藍, entry.getKey());

            }

        }
    }

    private void produce文化() {
        get文化().addPoints(get文化生產_當回合().getVal());
    }

    private void produce農場() {
        for (AgesCard card : 農場區) {
            card.setTokenBlue(card.getTokenBlue() + card.getTokenYellow());
        }
    }

    private void produce礦山() {
        for (AgesCard card : 礦山區) {
            card.setTokenBlue(card.getTokenBlue() + card.getTokenYellow());
        }
    }

    private void produce科技() {
        get科技().addPoints(get科技生產_當回合().getVal());
    }

    public Points get文化() {
        return 文化;
    }

    public Points get文化生產_當回合() {
        return 文化生產_當回合;
    }

    public Points get科技() {
        return 科技;
    }

    public Points get科技生產_當回合() {
        return 科技生產_當回合;
    }

    public Points get軍力() {
        return 軍力;
    }

    public Points get資源庫_藍點() {
        return 資源庫_藍點;
    }

    public Points get人力庫_黃點() {
        return 人力庫_黃點;
    }

    public Points get笑臉_幸福指數() {
        return 笑臉_幸福指數;
    }

    public Points get工人區_黃點() {
        return 工人區_黃點;
    }

    public List<AgesCard> get領袖區() {
        return 領袖區;
    }

    public List<AgesCard> getOnTable() {
        List<AgesCard> onTable;
        onTable = new ArrayList<>();
        onTable.addAll(政府區);
        onTable.addAll(領袖區);
        onTable.addAll(建造中的奇蹟區);

        onTable.addAll(實驗室);
        onTable.addAll(神廟區);
        onTable.addAll(農場區);
        onTable.addAll(礦山區);
        onTable.addAll(步兵區);
        onTable.addAll(已完成的奇蹟);
        onTable.addAll(劇院區);
        onTable.addAll(圖書館區);
        onTable.addAll(殖民領土區);
        onTable.addAll(炮兵區);
        onTable.addAll(特殊科技區);
        onTable.addAll(競技場區);
        onTable.addAll(空軍區);
        onTable.addAll(騎兵區);
        onTable.addAll(未分類區);
        onTable.addAll(戰術區);
        onTable.addAll(戰爭區);

        onTable.addAll(內政區);
        onTable.addAll(軍事區);
        onTable.addAll(建築區);
        onTable.addAll(殖民區);
        onTable.addAll(行動牌區);
        return onTable;

    }

    public List<AgesCard> get戰爭區() {
        return 戰爭區;
    }

    public void set戰爭區(List<AgesCard> 戰爭區) {
        this.戰爭區 = 戰爭區;
    }

    public List<AgesCard> get戰術區() {
        return 戰術區;
    }

    public void set戰術區(List<AgesCard> 戰術區) {
        this.戰術區 = 戰術區;
    }

    public List<AgesCard> get行動區() {
        return 行動區;
    }

    public void set行動區(List<AgesCard> 行動區) {
        this.行動區 = 行動區;
    }

    public List<AgesCard> get政府區() {
        return 政府區;
    }

    public List<AgesCard> get實驗室() {
        return 實驗室;
    }

    public List<AgesCard> get神廟區() {
        return 神廟區;
    }

    public Points get額外用於建造軍事單位的資源() {
        return 額外用於建造軍事單位的資源;
    }

    public void set額外用於建造軍事單位的資源(Points 額外用於建造軍事單位的資源) {
        this.額外用於建造軍事單位的資源 = 額外用於建造軍事單位的資源;
    }

    public List<AgesCard> get未分類區() {
        return 未分類區;
    }

    public void set未分類區(List<AgesCard> 未分類區) {
        this.未分類區 = 未分類區;
    }

    public List<AgesCard> get騎兵區() {
        return 騎兵區;
    }

    public void set騎兵區(List<AgesCard> 騎兵區) {
        this.騎兵區 = 騎兵區;
    }

//       onTable.addAll(政府區);
//    onTable.addAll(領袖區);
//    onTable.addAll(建造中的奇蹟區);
//    
//    onTable.addAll(實驗室);
//    onTable.addAll(神廟區);
    public List<AgesCard> getSector(int k) {
        switch (k) {
            case Sector.政府區:
                return 政府區;
            case Sector.領袖區:
                return 領袖區;
            case Sector.建造中的奇蹟區:
                return 建造中的奇蹟區;
            case Sector.實驗室:
                return 實驗室;
            case Sector.神廟區:
                return 神廟區;
            case Sector.農場區:
                return 農場區;
            case Sector.礦山區:
                return 礦山區;
            case Sector.步兵區:
                return 步兵區;
            case Sector.已完成的奇蹟:
                return 已完成的奇蹟;
//                
//                
            case Sector.劇院區: // 9
                return 劇院區;
            case Sector.圖書館區: //10
                return 圖書館區;
            case Sector.殖民領土區://11
                return 殖民領土區;
            case Sector.炮兵區://12
                return 炮兵區;
            case Sector.特殊科技區://13
                return 特殊科技區;
            case Sector.競技場區://14
                return 競技場區;
            case Sector.空軍區://15
                return 空軍區;
            case Sector.騎兵區://16
                return 騎兵區;
            case Sector.未分類區://17
                return 未分類區;

            case Sector.內政區://18
                return 內政區;
            case Sector.軍事區://19
                return 軍事區;
            case Sector.建築區://20
                return 建築區;
            case Sector.殖民區://21
                return 殖民區;
            case Sector.行動牌區://22
                return 行動牌區;
            case Sector.戰術區://23
                return 戰術區;
            case Sector.戰爭區://24
                return 戰爭區;
//            case Sector.建築區://19
//                return 建築區;

            default:
                return null;
        }
    }

    public List<AgesCard> get炮兵區() {
        return 炮兵區;
    }

    public void set炮兵區(List<AgesCard> 炮兵區) {
        this.炮兵區 = 炮兵區;
    }

    public List<AgesCard> get空軍區() {
        return 空軍區;
    }

    public void set空軍區(List<AgesCard> 空軍區) {
        this.空軍區 = 空軍區;
    }

    public List<AgesCard> get劇院區() {
        return 劇院區;
    }

    public void set劇院區(List<AgesCard> 劇院區) {
        this.劇院區 = 劇院區;
    }

    public List<AgesCard> get圖書館區() {
        return 圖書館區;
    }

    public void set圖書館區(List<AgesCard> 圖書館區) {
        this.圖書館區 = 圖書館區;
    }

    public List<AgesCard> get競技場區() {
        return 競技場區;
    }

    public void set競技場區(List<AgesCard> 競技場區) {
        this.競技場區 = 競技場區;
    }

    public List<Integer> getWonderStages() {
        return wonderStages;
    }

    public void setWonderStages(List<Integer> wonderStages) {
        this.wonderStages = wonderStages;
    }

    public List<AgesCard> get行動牌區() {
        return 行動牌區;
    }

    public void set行動牌區(List<AgesCard> 行動牌區) {
        this.行動牌區 = 行動牌區;
    }

    public List<AgesCard> get農場區() {
        return 農場區;
    }

    public List<AgesCard> get礦山區() {
        return 礦山區;
    }

    public List<AgesCard> get步兵區() {
        return 步兵區;
    }

    public List<AgesCard> get內政區() {
        return 內政區;
    }

    public void set內政區(List<AgesCard> 內政區) {
        this.內政區 = 內政區;
    }

    public List<AgesCard> get軍事區() {
        return 軍事區;
    }

    public void set軍事區(List<AgesCard> 軍事區) {
        this.軍事區 = 軍事區;
    }

    public List<AgesCard> get建築區() {
        return 建築區;
    }

    public void set建築區(List<AgesCard> 建築區) {
        this.建築區 = 建築區;
    }

    public List<AgesCard> get殖民區() {
        return 殖民區;
    }

    public void set殖民區(List<AgesCard> 殖民區) {
        this.殖民區 = 殖民區;
    }

    public List<AgesCard> get建造中的奇蹟區() {
        return 建造中的奇蹟區;
    }

    public List<AgesCard> get已完成的奇蹟() {
        return 已完成的奇蹟;
    }

    public List<AgesCard> get殖民領土區() {
        return 殖民領土區;
    }

    public List<AgesCard> get特殊科技區() {
        return 特殊科技區;
    }

    public List<AgesCard> get手牌內政牌區() {
        return 手牌內政牌區;
    }

    public List<AgesCard> get行動牌暫存區() {
        return 行動牌區;
    }

    public List<AgesCard> get手牌軍事牌區() {
        return 手牌軍事牌區;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String str) {
        name = str;
        init();
    }

    public void actBuild(int id) {
//2014-5-19-max 針對實驗室、神廟區、農場區、礦山區、步兵區
        List<AgesCard> buildList = new ArrayList<>();
        buildList.addAll(實驗室);
        buildList.addAll(神廟區);
        buildList.addAll(農場區);
        buildList.addAll(礦山區);
        buildList.addAll(步兵區);

        for (AgesCard card : buildList) {
            if (card.getId() == id) {
                System.out.println("before  內政點數:" + this.內政點數 + "  工人區:" + this.工人區_黃點 + "  這張牌的黃點:"
                        + +card.getTokenYellow() + "  (成本" + card.getIconPoints() + ")" + "  礦山區 A青銅1032 藍點:" + this.get礦山區().get(0).getTokenBlue() + "  資源庫【藍】:" + this.資源庫_藍點);
                card.setTokenYellow(card.getTokenYellow() + 1);//指定的卡上黃點+1
                this.工人區_黃點.addPoints(-1);//玩家的工人區-1
                this.內政點數.addPoints(-1);
                //支付石頭
                this.礦山區.get(0).setTokenBlue(礦山區.get(0).getTokenBlue() - card.getCostStone());
                //增加資源庫的藍點
                this.資源庫_藍點.addPoints(card.getCostStone());
                System.out.println("after  內政點數:" + this.內政點數 + "  工人區:" + this.工人區_黃點 + "  這張牌的黃點:"
                        + +card.getTokenYellow() + "  (成本" + card.getIconPoints() + ")" + "  礦山區 A青銅1032 藍點:" + this.get礦山區().get(0).getTokenBlue() + "  資源庫【藍】:" + this.資源庫_藍點);
                return;//一次只操作一張牌，找到後返回
            }
        }
//2014-5-19-max 針對奇蹟的部分
        for (AgesCard card : 建造中的奇蹟區) {
            if (card.getId() == id) {
//                this.礦山區.get(0).setTokenBlue(礦山區.get(0).getTokenBlue() - wonderStages.get(0);
                this.礦山區.get(0).setTokenBlue(礦山區.get(0).getTokenBlue() - 1);
                wonderStages.remove(0);
                this.內政點數.addPoints(-1);
                if (wonderStages.size() == 0) {
                    moveOneCard(建造中的奇蹟區, 0, 已完成的奇蹟);
                    int temp = 內政手牌上限.getVal();
                    update手牌上限();
//                    
                    if (內政手牌上限.getVal() != temp) {
                        System.out.println("************* 內政手牌上限 HAS BEEN CHANGED , SHOULD WE ADD 內政點數 TOKEN NOW?????");
                        System.out.println("max-2014-5-19，以金字塔為例建造完成後立即生效行動:獲得一點內政行動");
                        System.out.println("手牌上限值要+1");
                        System.out.println("內政點數也要+1，如同在遊戲盒裡拿出一個白色標記");
                    }
                }
                return;//一次只操作一張牌，找到後返回
            }
        }
//如果要建造的不在實驗室、神廟區、農場區、礦山區、步兵區
//如果不是奇蹟的建造
//提示該指令無效        
        System.out.println("your assigned ID " + id + " IS NOT FOUND???");
    }

    public void actAct(int id) {
//2014-5-19-max 針對實驗室、神廟區、農場區、礦山區、步兵區
        List<AgesCard> actbuildList = new ArrayList<>();
        actbuildList.addAll(實驗室);
        actbuildList.addAll(神廟區);
        actbuildList.addAll(農場區);
        actbuildList.addAll(礦山區);
        actbuildList.addAll(步兵區);
        System.out.println(get行動牌暫存區().get(0).getName() + "  效果:" + get行動牌暫存區().get(0).getAction());
        for (AgesCard card : actbuildList) {
            if (card.getId() == id) {
                System.out.println("目標卡名:" + card.getName());

                switch (get行動牌暫存區().get(0).getId()) {
                    //富饒之土
                    case 1013:
                    case 1061:
                    case 1025:
                        System.out.println("處理富饒之土");
                        if ((card.getTag().equals("農場")) || (card.getTag().equals("礦山"))) {
                            System.out.println("正確的對象");
                            if (get行動牌暫存區().get(0).getAge() + 1 > card.getCostStone()) {//如果減少>花費
                                card.setTokenYellow(card.getTokenYellow() + 1);//黃點+1
                                this.工人區_黃點.addPoints(-1);
                            } else {
                                System.out.println("此次花費:" + (card.getCostStone() - (get行動牌暫存區().get(0).getAge() + 1)));
                                this.礦山區.get(0).setTokenBlue(礦山區.get(0).getTokenBlue() - (card.getCostStone() - (get行動牌暫存區().get(0).getAge() + 1)));//支付成本
                                card.setTokenYellow(card.getTokenYellow() + 1);//黃點+1
                                this.工人區_黃點.addPoints(-1);
                            }
                            get行動牌暫存區().remove(0);
                        } else {
                            System.out.println("錯誤的目標");
                        }
                        break;
                    //                        建築工地
                    case 1017:
                    case 1065:
                    case 1132:
                    case 1215:
                        System.out.println("處理建築工地");
                        switch (card.getTag()) {
                            case "神廟":
                            case "實驗室":
                                System.out.println("正確的對象");
                                if (get行動牌暫存區().get(0).getAge() + 1 > card.getCostStone()) {//如果減少>花費
                                    card.setTokenYellow(card.getTokenYellow() + 1);//黃點+1
                                    this.工人區_黃點.addPoints(-1);
                                } else {
                                    System.out.println("此次花費:" + (card.getCostStone() - (get行動牌暫存區().get(0).getAge() + 1)));
                                    this.礦山區.get(0).setTokenBlue(礦山區.get(0).getTokenBlue() - (card.getCostStone() - (get行動牌暫存區().get(0).getAge() + 1)));//支付成本
                                    card.setTokenYellow(card.getTokenYellow() + 1);//黃點+1
                                    this.工人區_黃點.addPoints(-1);
                                }
                                get行動牌暫存區().remove(0);
                                break;

                            default:
                                System.out.println("錯誤的目標");
                                break;
                        }

                    default:
                        System.out.println("待處理中");
                        break;
                }

            }
//            System.out.println("your assigned ID " + id + " IS NOT FOUND???");
        }
    }

    public void act摧毀(int id) {
//            System.out.println("這是在player裡面的");
//            this.農場區.get(0).setTokenYellow(this.農場區.get(0).getTokenYellow() + 1);
            /* OLD STYLE, ONE BY ONE
         for (AgesCard card : 農場區) {
         if (card.getId() == id) {
         card.setTokenYellow(card.getTokenYellow() - 1);
         this.工人區_黃點.addPoints(1);
         //                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
         }
         }
         for (AgesCard card : 礦山區) {
         if (card.getId() == id) {
         card.setTokenYellow(card.getTokenYellow() - 1);
         this.工人區_黃點.addPoints(1);
         //                    System.out.println(" " + key + " " + getSameSizeName(card.getName()) + " " + card.getAction());
         }
         }
         */

        List<AgesCard> buildList = new ArrayList<>();
        buildList.addAll(實驗室);
        buildList.addAll(神廟區);
        buildList.addAll(農場區);
        buildList.addAll(礦山區);
        buildList.addAll(步兵區);
        for (AgesCard card : buildList) {
            if (card.getId() == id) {
                card.setTokenYellow(card.getTokenYellow() - 1);
                this.工人區_黃點.addPoints(+1);
                return;
            }
        }

    }

    public void act擴充人口() {
        System.out.println("現在要擴充人口了");
//            this.農場區.get(0).setTokenYellow(this.農場區.get(0).getTokenYellow() + 1);
        this.人力庫_黃點.addPoints(-1);
        this.工人區_黃點.addPoints(1);

    }

    private String name;
    private Points 內政點數;
    private Points 軍事點數;
    private Points 建築上限;
    private Points 內政手牌上限;
    private Points 軍事手牌上限;
    private Points 殖民點數;
    private Points 文化;
    private Points 文化生產_當回合;
    private Points 科技;
    private Points 科技生產_當回合;
    private Points 軍力;
    private Points 資源庫_藍點;
    private Points 額外用於建造軍事單位的資源;

    private Points 人力庫_黃點;
    private Points 笑臉_幸福指數;
    private Points 工人區_黃點;

    public void setScore(Score score) {
        this.score = score;
    }

    public void setToken黃(Token token黃) {
        this.token黃 = token黃;
    }

    public void setToken藍(Token token藍) {
        this.token藍 = token藍;
    }

    public void set內政點數(Points 內政點數) {
        this.內政點數 = 內政點數;
    }

    public void set軍事點數(Points 軍事點數) {
        this.軍事點數 = 軍事點數;
    }

    public void set建築上限(Points 建築上限) {
        this.建築上限 = 建築上限;
    }

    public void set內政手牌上限(Points 內政手牌上限) {
        this.內政手牌上限 = 內政手牌上限;
    }

    public void set軍事手牌上限(Points 軍事手牌上限) {
        this.軍事手牌上限 = 軍事手牌上限;
    }

    public void set殖民點數(Points 殖民點數) {
        this.殖民點數 = 殖民點數;
    }

    public void set文化(Points 文化) {
        this.文化 = 文化;
    }

    public void set文化生產_當回合(Points 文化生產_當回合) {
        this.文化生產_當回合 = 文化生產_當回合;
    }

    public void set科技(Points 科技) {
        this.科技 = 科技;
    }

    public void set科技生產_當回合(Points 科技生產_當回合) {
        this.科技生產_當回合 = 科技生產_當回合;
    }

    public void set軍力(Points 軍力) {
        this.軍力 = 軍力;
    }

    public void set資源庫_藍點(Points 資源庫_藍點) {
        this.資源庫_藍點 = 資源庫_藍點;
    }

    public void set人力庫_黃點(Points 人力庫_黃點) {
        this.人力庫_黃點 = 人力庫_黃點;
    }

    public void set笑臉_幸福指數(Points 笑臉_幸福指數) {
        this.笑臉_幸福指數 = 笑臉_幸福指數;
    }

    public void set工人區_黃點(Points 工人區_黃點) {
        this.工人區_黃點 = 工人區_黃點;
    }

    public void set領袖區(List<AgesCard> 領袖區) {
        this.領袖區 = 領袖區;
    }

    public void set政府區(List<AgesCard> 政府區) {
        this.政府區 = 政府區;
    }

    public void set實驗室(List<AgesCard> 實驗室) {
        this.實驗室 = 實驗室;
    }

    public void set神廟區(List<AgesCard> 神廟區) {
        this.神廟區 = 神廟區;
    }

    public void set農場區(List<AgesCard> 農場區) {
        this.農場區 = 農場區;
    }

    public void set礦山區(List<AgesCard> 礦山區) {
        this.礦山區 = 礦山區;
    }

    public void set步兵區(List<AgesCard> 步兵區) {
        this.步兵區 = 步兵區;
    }

    public void set建造中的奇蹟區(List<AgesCard> 建造中的奇蹟區) {
        this.建造中的奇蹟區 = 建造中的奇蹟區;
    }

    public void set已完成的奇蹟(List<AgesCard> 已完成的奇蹟) {
        this.已完成的奇蹟 = 已完成的奇蹟;
    }

    public void set殖民領土區(List<AgesCard> 殖民領土區) {
        this.殖民領土區 = 殖民領土區;
    }

    public void set特殊科技區(List<AgesCard> 特殊科技區) {
        this.特殊科技區 = 特殊科技區;
    }

    public void set手牌內政牌區(List<AgesCard> 手牌內政牌區) {
        this.手牌內政牌區 = 手牌內政牌區;
    }

    public void set手牌軍事牌區(List<AgesCard> 手牌軍事牌區) {
        this.手牌軍事牌區 = 手牌軍事牌區;
    }
    
    private List<AgesCard> 暫存應用區;
    private List<AgesCard> 戰爭區;
    private List<AgesCard> 戰術區;
    private List<AgesCard> 領袖區;
    private List<AgesCard> 政府區;
    private List<AgesCard> 實驗室;
    private List<AgesCard> 神廟區;
    private List<AgesCard> 農場區;
    private List<AgesCard> 礦山區;
    private List<AgesCard> 步兵區;
    private List<AgesCard> 未分類區;
// [09:54:37] maxchen20041: 請按照步兵區方式
// [09:55:19] maxchen20041: 建立騎兵區、炮兵區、空軍區、劇院區、圖書館區、競技場區
    private List<AgesCard> 騎兵區;
    private List<AgesCard> 炮兵區;
    private List<AgesCard> 空軍區;
    private List<AgesCard> 劇院區;
    private List<AgesCard> 圖書館區;
    private List<AgesCard> 競技場區;

    private List<AgesCard> 內政區;
    private List<AgesCard> 軍事區;
    private List<AgesCard> 建築區;
    private List<AgesCard> 殖民區;
    private List<AgesCard> 行動區;
    private List<AgesCard> 建造中的奇蹟區;
    private List<Integer> wonderStages;

    private List<AgesCard> 已完成的奇蹟;
    private List<AgesCard> 殖民領土區;
    private List<AgesCard> 特殊科技區;
    private List<AgesCard> 手牌內政牌區;
    private List<AgesCard> 行動牌區;
    public List<AgesCard> 手牌軍事牌區;

    public List<AgesCard> get暫存應用區() {
        return 暫存應用區;
    }

    public void set暫存應用區(List<AgesCard> 暫存應用區) {
        this.暫存應用區 = 暫存應用區;
    }

    public void init() {
        score = new Score();

        score.getMap().put("內政點數", 0);

        score.getMap().put("軍事點數", 0);

        score.getMap().put("建築上限", 0);

        score.getMap().put("內政手牌上限", 0);

        score.getMap().put("軍事手牌上限", 0);

        score.getMap().put("殖民點數", 0);

        score.getMap().put("文化", 0);

        score.getMap().put("文化﹝＋﹞", 0);

        score.getMap().put("科技", 0);

        score.getMap().put("科技﹝＋﹞", 0);

        score.getMap().put("軍力", 0);

        score.getMap().put("笑臉", 0);

        this.token藍 = new Token();

        this.token黃 = new Token();

        token黃.getMap().put(1010, 1);

        token黃.getMap().put(1007, 2);

        token黃.getMap().put(1032, 2);

        token黃.getMap().put(1018, 1);

        token黃.getMap().put(2, 1);

        token黃.getMap().put(1, 18);

        token藍.getMap().put(3, 18);

        內政點數 = new Points("內政點數");
        軍事點數 = new Points("軍事點數");

        建築上限 = new Points("建築上限");
        內政手牌上限 = new Points("內政手牌上限");
        軍事手牌上限 = new Points("軍事手牌上限");
        殖民點數 = new Points("殖民點數");
        文化 = new Points("文化");
        文化生產_當回合 = new Points("文化﹝＋﹞");//
        科技 = new Points("科技");
        科技生產_當回合 = new Points("科技﹝＋﹞");
        軍力 = new Points("軍力");
        資源庫_藍點 = new Points("資源庫【藍】");
        人力庫_黃點 = new Points("人力庫【黃】");
        笑臉_幸福指數 = new Points("笑臉【】");
        工人區_黃點 = new Points("工人區【黃】");

        戰爭區 = new ArrayList<>();
        戰術區 = new ArrayList<>();
        領袖區 = new ArrayList<>();
        政府區 = new ArrayList<>();
        實驗室 = new ArrayList<>();
        神廟區 = new ArrayList<>();
        農場區 = new ArrayList<>();
        礦山區 = new ArrayList<>();
        步兵區 = new ArrayList<>();
        未分類區 = new ArrayList<>();
// [09:54:37] maxchen20041: 請按照步兵區方式
// [09:55:19] maxchen20041: 建立 騎兵區、炮兵區、空軍區、劇院區、圖書館區、競技場區            
        騎兵區 = new ArrayList<>();
        炮兵區 = new ArrayList<>();
        空軍區 = new ArrayList<>();
        劇院區 = new ArrayList<>();
        圖書館區 = new ArrayList<>();
        競技場區 = new ArrayList<>();

        建造中的奇蹟區 = new ArrayList<>();
        wonderStages = new ArrayList<>();

        已完成的奇蹟 = new ArrayList<>();
        殖民領土區 = new ArrayList<>();
        特殊科技區 = new ArrayList<>();
        手牌內政牌區 = new ArrayList<>();
        行動牌區 = new ArrayList<>();
        手牌軍事牌區 = new ArrayList<>();

        內政區 = new ArrayList<>();
        軍事區 = new ArrayList<>();
        建築區 = new ArrayList<>();
        殖民區 = new ArrayList<>();

    }

    public void update手牌上限() {
//        int new回合內政點數 = 政府區.get(0).getEffectWhite();
//        int new回合軍事點數 = 政府區.get(0).getEffectRed();
////            System.out.println(""+政府區.get(0));
//        if (領袖區.size() == 1) {
//            AgesCard leader = 領袖區.get(0);
//            if (leader.getId() == 1023) {// A漢摩拉比1023-內政行動CA+1 軍事行動MA-1】
//                new回合內政點數++;
//                new回合軍事點數--;
//            }
//            if (leader.getId() == 1009) { //【A凱薩1009-軍事力量+1 軍事行動 MA+1】
////                    new回合內政點數++;
//                new回合軍事點數++;
//            }
//        }
//        內政手牌上限.setVal(new回合內政點數);
//        軍事手牌上限.setVal(new回合軍事點數);
        int white = 0;
        int red = 0;
        List<AgesCard> buildList = new ArrayList<>();
        buildList.addAll(政府區);
        buildList.addAll(領袖區);
        buildList.addAll(已完成的奇蹟);
        for (AgesCard card : buildList) {
            if (card.getEffectWhite() > 0) {
                white += card.getEffectWhite();
            }
            if (card.getEffectRed() > 0) {
                red += card.getEffectRed();
            }

        }

        內政手牌上限.setVal(white);
        軍事手牌上限.setVal(red);
//        System.out.println("內政手牌上限，軍事手牌上限剛剛更新");
    }

    public void show建造中的奇蹟區Stages() {

        System.out.print("  建造中的奇蹟區Stages ");
        for (Integer stage : wonderStages) {
            System.out.print(" " + stage);
        }
    }

    public void show(List<AgesCard> list, String title) {

        switch (title) {

            case "政府區":
                System.out.println("  ");
                System.out.print("  " + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(1));
                }
                break;
            case "戰術區":
            case "領袖區":
                System.out.print("  " + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(101));
                }
                break;
            case "建造中的奇蹟區":
                System.out.print("\n  " + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(102));
                }
                break;
            case "已完成的奇蹟":
                System.out.print("\n  " + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(103));
                }
                break;

            case "劇院區":
            case "競技場區":
            case "圖書館區":
            case "實驗室":
            case "神廟區":
            case "步兵區":
            case "騎兵區":
            case "炮兵區":
            case "空軍區":

                System.out.println("  ");
                System.out.print("  " + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(104));
                }
                break;

            case "農場區":
            case "礦山區":
                System.out.println("  ");
                System.out.print("  " + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(8));
                }
                break;
            case "行動牌區":

                System.out.println("  ");
                System.out.print("" + title + " ");
                int j = 0;
                for (AgesCard card : list) {
                    System.out.print("" + (j++) + card.toString(105));
                }
                break;
            case "手牌內政牌區":
                System.out.println("  ");
                System.out.print("" + title + " ");
                int k = 0;
                for (AgesCard card : list) {
                    System.out.print("" + (k++) + card.toString(4));
                }
                break;
            case "手牌軍事牌區":
                System.out.println("  ");
                System.out.print("" + title + " ");
                int p = 0;
                for (AgesCard card : list) {
                    System.out.print("" + (p++) + card.toString(5));
                }
                break;
            case "戰爭區":
                System.out.print("  " + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(101));
                }
                break;
            default:
                System.out.println("");
                System.out.print("" + title + " ");
                for (AgesCard card : list) {
                    System.out.print("" + card.toString(4));

                }
        }

    }

    public void show() {
        System.out.println("\n  === " + name + " ===");
        內政點數.show();
        軍事點數.show();
        建築上限.show();
//            System.out.println("");
        內政手牌上限.show();
        軍事手牌上限.show();
        殖民點數.show();
        System.out.println("");
        文化.show();
        文化生產_當回合.show();
        科技.show();
        科技生產_當回合.show();
        軍力.show();
        System.out.println("");
        資源庫_藍點.show();
        人力庫_黃點.show();
        笑臉_幸福指數.show();
        工人區_黃點.show();
        System.out.println("");
        show(政府區, "政府區");
        show(領袖區, "領袖區");

        show(劇院區, "劇院區");
        show(競技場區, "競技場區");
        show(圖書館區, "圖書館區");
//        show(實驗室, "實驗室");
//        show(實驗室, "實驗室");
        show(實驗室, "實驗室");
        show(神廟區, "神廟區");
        show(農場區, "農場區");
        show(礦山區, "礦山區");
        show(步兵區, "步兵區");
        show(騎兵區, "騎兵區");
        show(炮兵區, "炮兵區");
        show(空軍區, "空軍區");

        show(未分類區, "未分類區");
        show(戰術區, "戰術區");
        show(戰爭區, "戰爭區");
        show(建造中的奇蹟區, "建造中的奇蹟區");
        show建造中的奇蹟區Stages();
        show(已完成的奇蹟, "已完成的奇蹟");
        show(手牌內政牌區, "手牌內政牌區");
        show(行動牌區, "行動牌區");
        show(手牌軍事牌區, "手牌軍事牌區");
        System.out.println("");

    }

    public void actPlayCard(int val) {
        if (val > 手牌內政牌區.size() - 1) {
            System.out.println("我無法作出這個動作，我這個位置沒有牌");
            return;
        }
        AgesCard card = this.手牌內政牌區.get(val);
//        System.out.println(""+card.getCostRevolution());
        System.out.println("打出這張牌需要花費(" + card.getCostIdea() + ")科技");
        switch (card.getTag()) {
            case "農場":
                System.out.println("現在打的是農場牌準本要放到農場區");
                moveOneCard(this.手牌內政牌區, val, this.農場區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "領袖":
                System.out.println("***REPLACE CURRENT ONE");
                while (領袖區.size() > 0) {
                    領袖區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.領袖區);
                break;
            case "戰術":
                System.out.println("***REPLACE CURRENT ONE");
                while (戰術區.size() > 0) {
                    戰術區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.戰術區);
                break;
            case "戰爭":
                System.out.println("***REPLACE CURRENT ONE");
                while (戰爭區.size() > 0) {
                    戰爭區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.戰爭區);
                break;
            case "行動":
                System.out.println("打行動牌");
                while (行動牌區.size() > 0) {
                    行動牌區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.行動牌區);
                break;
            case "礦山":
                moveOneCard(this.手牌內政牌區, val, this.礦山區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "實驗室":
                moveOneCard(this.手牌內政牌區, val, this.實驗室);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "神廟":
                moveOneCard(this.手牌內政牌區, val, this.神廟區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "步兵":
                moveOneCard(this.手牌內政牌區, val, this.步兵區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "騎兵":
                moveOneCard(this.手牌內政牌區, val, this.騎兵區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "炮兵":
                moveOneCard(this.手牌內政牌區, val, this.炮兵區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "空軍":
                moveOneCard(this.手牌內政牌區, val, this.空軍區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "競技場":
                moveOneCard(this.手牌內政牌區, val, this.競技場區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "圖書館":
                moveOneCard(this.手牌內政牌區, val, this.圖書館區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "劇院":
                moveOneCard(this.手牌內政牌區, val, this.劇院區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "政府":
                System.out.println("***REPLACE CURRENT ONE");
//                    System.out.print("" + card.toString(1));
                while (政府區.size() > 0) {
                    政府區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.政府區);
                this.科技.addPoints(-card.getCostIdea());
                break;

            case "內政":
                while (內政區.size() > 0) {
                    內政區.remove(0);
                }
                System.out.println("打出內政牌" + card.getId() + card.getName());
                moveOneCard(this.手牌內政牌區, val, this.內政區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "軍事":
                while (軍事區.size() > 0) {
                    軍事區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.軍事區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "建築":
                while (建築區.size() > 0) {
                    建築區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.建築區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "殖民":
                while (殖民區.size() > 0) {
                    殖民區.remove(0);
                }
                moveOneCard(this.手牌內政牌區, val, this.殖民區);
                this.科技.addPoints(-card.getCostIdea());
                break;

            default:
//                    System.out.println("");
                System.out.print("" + card.toString(1));
                moveOneCard(this.手牌內政牌區, val, this.未分類區);
        }

        //
        // 06/16 13:30, by Mark
        //
        update手牌上限();
    }

    /**
     *
     * @param p1 from
     * @param p2 to
     */
    public void actUpgrade(int p1, int p2) {

        List<AgesCard> buildList = new ArrayList<>();
        buildList.addAll(實驗室);
        buildList.addAll(神廟區);
        buildList.addAll(農場區);
        buildList.addAll(礦山區);
        buildList.addAll(步兵區);
        System.out.println(" checking 實驗室|神廟區|農場區|礦山區|步兵區, how many cards now? " + buildList.size());

        for (AgesCard card : buildList) {
            if (card.getId() == p1) {
                card.setTokenYellow(card.getTokenYellow() - 1);
                break;
            }
        }

        for (AgesCard card : buildList) {
            if (card.getId() == p2) {
                card.setTokenYellow(card.getTokenYellow() + 1);
                break;
            }
        }

    }

    public void compute當回合文化and科技and軍力() {
        System.out.println("compute當回合文化and科技");
        // 1. Prepare source
        List<AgesCard> list = new ArrayList<>();

//        System.out.println("CURRENTLY ONLY CHECK 已完成的奇蹟");
        list.addAll(政府區);
        list.addAll(領袖區);
        list.addAll(實驗室);
        list.addAll(神廟區);
        list.addAll(農場區);
        list.addAll(步兵區);
        list.addAll(已完成的奇蹟);

        // 2. Process
        int 音樂 = 0;
        int 燈泡 = 0;
        int 武器 = 0;

        for (AgesCard card : list) {
            if (card.getTokenYellow() > 0) {

                if (card.getEffectMusic() != 0) {
                    System.out.println(".....getEffectMusic " + card.toString(103));

                    音樂 += card.getEffectMusic();
                }
                if (card.getEffectIdea() != 0) {

                    System.out.println("######getEffectIdea " + card.toString(103));
                    燈泡 += card.getEffectIdea();
                }
                if (card.getEffectWeapon() != 0) {

                    System.out.println("@@@@getEffectWeapon " + card.toString(103));
                    武器 += card.getEffectWeapon();
                }
            }

        }

        // 3. Update result
        文化生產_當回合.setVal(音樂);
        科技生產_當回合.setVal(燈泡);
        軍力.setVal(武器);

    }

    public void refill內政點數軍事點數() {
        內政點數.setVal(內政手牌上限.getVal());
        軍事點數.setVal(軍事手牌上限.getVal());

    }

    public void actActV1() {
        switch (get行動牌暫存區().get(0).getId()) {
            //富饒之土
            case 1027:
            case 1092:
            case 1171:
            case 1243:
                System.out.println("處理藝術作品");
                System.out.println(文化);
                this.文化.addPoints(6 - get行動牌暫存區().get(0).getAge());
                System.out.println(文化);
                get行動牌暫存區().remove(0);
                break;
            default:
                System.out.println("使用方式不正確");
                break;
        }
    }

    public void actPlayMilitaryCard(int val) {
        if (val > 手牌軍事牌區.size() - 1) {
            System.out.println("我無法作出這個動作，我這個位置沒有牌");
            return;
        }
        AgesCard card = this.手牌軍事牌區.get(val);
//        System.out.println(""+card.getCostRevolution());
        System.out.println("打出這張牌需要花費(" + card.getCostIdea() + ")科技");
        switch (card.getTag()) {
            case "事件":
                System.out.println("現在打的是農場牌準本要放到農場區");
                moveOneCard(this.手牌軍事牌區, val, this.農場區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "":
                System.out.println("***REPLACE CURRENT ONE");
                while (領袖區.size() > 0) {
                    領袖區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.領袖區);
                break;
            case "戰術":
                System.out.println("***REPLACE CURRENT ONE");
                while (戰術區.size() > 0) {
                    戰術區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.戰術區);
                break;
            case "戰爭":
                System.out.println("***REPLACE CURRENT ONE");
                while (戰爭區.size() > 0) {
                    戰爭區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.戰爭區);
                break;
            case "行動":
                System.out.println("打行動牌");
                while (行動牌區.size() > 0) {
                    行動牌區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.行動牌區);
                break;
            case "礦山":
                moveOneCard(this.手牌軍事牌區, val, this.礦山區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "實驗室":
                moveOneCard(this.手牌軍事牌區, val, this.實驗室);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "神廟":
                moveOneCard(this.手牌軍事牌區, val, this.神廟區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "步兵":
                moveOneCard(this.手牌軍事牌區, val, this.步兵區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "騎兵":
                moveOneCard(this.手牌軍事牌區, val, this.騎兵區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "炮兵":
                moveOneCard(this.手牌軍事牌區, val, this.炮兵區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "空軍":
                moveOneCard(this.手牌軍事牌區, val, this.空軍區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "競技場":
                moveOneCard(this.手牌軍事牌區, val, this.競技場區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "圖書館":
                moveOneCard(this.手牌軍事牌區, val, this.圖書館區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "劇院":
                moveOneCard(this.手牌軍事牌區, val, this.劇院區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "政府":
                System.out.println("***REPLACE CURRENT ONE");
//                    System.out.print("" + card.toString(1));
                while (政府區.size() > 0) {
                    政府區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.政府區);
                this.科技.addPoints(-card.getCostIdea());
                break;

            case "內政":
                while (內政區.size() > 0) {
                    內政區.remove(0);
                }
                System.out.println("打出內政牌" + card.getId() + card.getName());
                moveOneCard(this.手牌軍事牌區, val, this.內政區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "軍事":
                while (軍事區.size() > 0) {
                    軍事區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.軍事區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "建築":
                while (建築區.size() > 0) {
                    建築區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.建築區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            case "殖民":
                while (殖民區.size() > 0) {
                    殖民區.remove(0);
                }
                moveOneCard(this.手牌軍事牌區, val, this.殖民區);
                this.科技.addPoints(-card.getCostIdea());
                break;
            default:
//                    System.out.println("");
                System.out.print("" + card.toString(1));
                moveOneCard(this.手牌軍事牌區, val, this.未分類區);
        }

        //
        // 06/16 13:30, by Mark
        //
        update手牌上限();
    }

    public int get文明所需的笑臉() {
        int val = 0;
        /*
         0黃需要8
         1~2黃需要7
         3~4黃需要6
         5~6黃需要5
         7~8黃需要4
         9~10黃需要3
         11~12黃需要2
         13~16黃需要1
         17以上黃需要0
         */
        System.out.println("人力庫黃點為" + 人力庫_黃點.getVal());
        int[] val2 = {8, 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1, 1, 1, 0};
        if (this.人力庫_黃點.getVal() > 16) {
            val = val2[17];
        } else {
            val = val2[this.人力庫_黃點.getVal()];
        }

        return val;
    }

}
