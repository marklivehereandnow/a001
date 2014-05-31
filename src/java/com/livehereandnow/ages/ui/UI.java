package com.livehereandnow.ages.ui;

import com.livehereandnow.ages.card.AgesCard;
import com.livehereandnow.ages.cardrow.Cardrow;
import com.livehereandnow.ages.engine.Ages;
import com.livehereandnow.ages.exception.AgesException;
//import com.livehereandnow.ages.engine.Player;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UI {

    Ages engine;
//    Ages.Field field;
    private String text;
    private String debug;
    private int counter;
    private String militaryCardOption;

    public Map<String, Integer> getPlayerScore(int player) {
        return engine.getPlayerScore(player);

    }

    public Map<Integer, Integer> getPlayerTokens黃(int player) {

        if (player == 1) {

            return engine.getP1().getToken黃().getMap();

        }

        if (player == 2) {

            return engine.getP2().getToken黃().getMap();

        }

        return null;

    }

    public Map<Integer, Integer> getPlayerTokens藍(int player) {

        if (player == 1) {

            return engine.getP1().getToken藍().getMap();

        }

        if (player == 2) {

            return engine.getP2().getToken藍().getMap();

        }

        return null;

    }

    public String getMilitaryCardOption() {
        return militaryCardOption;
    }

    public void setMilitaryCardOption(String militaryCardOption) {
        this.militaryCardOption = militaryCardOption;
    }

    public String getAgeStr(int age) {
        String strAge[] = {"A", "I", "II", "III", "IV"};
        return strAge[age];
    }

    public String getCurrentAge() {
        String strAge[] = {"A", "I", "II", "III", "IV"};
        return strAge[engine.get當前時代()];
    }

    public int getRoundNumber() {
        return engine.getRound().getVal();
    }

    public String getCurrentPlayer() {
        return engine.getCurrentPlayerName();
    }

    public int getCurrentStage() {
        return engine.get現在階段();
    }

    public void doStart() throws IOException, AgesException {
        engine.doCmd("start");
    }

    public void doNewGame() throws IOException, AgesException {
        engine.doCmd("new-game");
    }

    public void doChangeTurn() throws IOException, AgesException {

        engine.doCmd("c");
    }
//
//    public List<AgesCard> getPlayerAAA政府區(){
//        return engine.getField().getP1().get政府區();
//    }

    public List<AgesCard> getSector未來事件() {
        return engine.getField().get未來事件();
    }

    public List<AgesCard> getSector現在發生事件() {
        return engine.getField().get現在發生事件();
    }

    public List<AgesCard> getSector當前事件() {
        return engine.getField().get當前事件();
    }

    public List<AgesCard> getSector時代I軍事牌() {
        return engine.getField().get時代I軍事牌();
    }

    public List<AgesCard> getSector時代II軍事牌() {
        return engine.getField().get時代II軍事牌();
    }

    public List<AgesCard> getSector時代III軍事牌() {
        return engine.getField().get時代III軍事牌();
    }

    public List<AgesCard> getSector時代軍事牌() {

        switch (this.getCurrentAge()) {
            case "I":
                return this.getSector時代I軍事牌();
            case "II":
                return this.getSector時代II軍事牌();
            case "III":
                return this.getSector時代III軍事牌();
            default:
                return new ArrayList<>();
        }
    }

    public List<AgesCard> getPlayerAAA手牌軍事牌區() {
        return engine.getP1().get手牌軍事牌區();
    }

    public List<AgesCard> getPlayerAAA政府區() {
        return engine.getP1().get政府區();
    }

    public List<AgesCard> getPlayerBBB政府區() {
        return engine.getP2().get政府區();
    }

    public List<AgesCard> getPlayerAAA領袖區() {
        return engine.getP1().get領袖區();
    }

    public List<AgesCard> getPlayerAAA建造中的奇蹟區() {
        return engine.getP1().get建造中的奇蹟區();
    }

    public List<AgesCard> getPlayerAAA實驗室() {
        return engine.getP1().get實驗室();
    }

    public List<AgesCard> getPlayerAAAOnTable() {
        return engine.getP1().getOnTable();
    }

    public List<AgesCard> getPlayerBBBOnTable() {
        return engine.getP2().getOnTable();
    }

    public List<AgesCard> getPlayerAAA神廟區() {
        return engine.getP1().get神廟區();
    }

    public List<AgesCard> getPlayerAAA農場區() {
        return engine.getP1().get農場區();
    }

    public List<AgesCard> getPlayerAAA礦山區() {
        return engine.getP1().get礦山區();
    }

    public List<AgesCard> getPlayerAAA步兵區() {
        return engine.getP1().get步兵區();
    }

    public void doNOTHING(int index) throws IOException, AgesException {
        System.out.println(" DO NOTHING , SEQ=" + index);
//        engine.parser("take-card "+index);
//        engine.actTakeCardBySeq(index);

    }

    public void doTakeCard(int index) throws IOException, AgesException {
//        System.out.println(" DOING... USE SEQ TO TAKE CARD, SEQ="+index);
        engine.actTakeCardBySeq(index);

    }

    public void doPlayCard(int index) throws IOException, AgesException {
        System.out.println(" doPlayCard... , SEQ=" + index);
        engine.actPlayCardBySeq(index);
    }

    public void doPlayMilitaryCard(int index) throws IOException, AgesException {
        System.out.println(" doPlayMilitaryCard... , SEQ=" + index);
        engine.actPlayMilitaryCardBySeq(index);
    }

//    public void doPlayMilitaryCard(int index) throws IOException, AgesException{
//        System.out.println(" doPlayMilitaryCard... , SEQ="+index);
//        if (engine.getCurrentPlayer().equals("AAA") ){
//           
//        }
////        engine.actPlayCardBySeq(index);                
//    }
//    public void doDiscardCard(int index) throws IOException, AgesException{
//        System.out.println(" doDiscardCard... , SEQ="+index);
////        engine.actPlayCardBySeq(index);                
//    }
    public void doSubmitCommand() throws IOException, AgesException {
        engine.parser(getText());
//        setDebug(this.getText()+"...");

    }
    List<Cardrow> listCardRowInTable;

    private String getCardrowUI(AgesCard ac) {
        StringBuilder sb = new StringBuilder();
        String ageStr[] = {"A", "I", "II", "III", ""};
        sb.append("【 ").append(ageStr[ac.getAge()]).append("-");
        sb.append(ac.getId()).append(" ");
//        sb.append(ac.getTag()).append("-");
        sb.append(ac.getName()).append(" 】 ");
        return sb.toString();
    }

    public String getImgBaseDir() {
//        return "2nd2go.org/ages/img/abcd/d";
        return "http://2nd2go.org/ages/img/abcd/d";
//        return "/resources/img/d";
    }

    public String getImgExt() {
        return ".jpg";
    }

    public List<AgesCard> getCardRowIdList() {
        return engine.getField().getCardRow();
    }

    public List<AgesCard> getP1Hand() {
        return engine.getP1().get手牌內政牌區();
    }

    public List<AgesCard> getP2Hand() {
        return engine.getP2().get手牌內政牌區();
    }

    public List<Cardrow> getCardRowInTable() {
        List<AgesCard> cardrow = engine.getField().getCardRow();

        listCardRowInTable = new ArrayList<>();
        Cardrow r1 = new Cardrow();
        Cardrow r2 = new Cardrow();
        Cardrow r3 = new Cardrow();

        if (cardrow.size() > 0) {
            r1.setId(1);
            r1.setF1("0" + getCardrowUI(cardrow.get(0)));
            r1.setF2("1" + getCardrowUI(cardrow.get(1)));
            r1.setF3("2" + getCardrowUI(cardrow.get(2)));
            r1.setF4("3" + getCardrowUI(cardrow.get(3)));
            r1.setF5("4" + getCardrowUI(cardrow.get(4)));

            r2.setId(2);
            r2.setF1("5" + getCardrowUI(cardrow.get(5)));
            r2.setF2("6" + getCardrowUI(cardrow.get(6)));
            r2.setF3("7" + getCardrowUI(cardrow.get(7)));
            r2.setF4("8" + getCardrowUI(cardrow.get(8)));
            r2.setF5(engine.getNOCARD().getName());

            r3.setId(3);
            r3.setF1("9" + getCardrowUI(cardrow.get(9)));
            r3.setF2("10" + getCardrowUI(cardrow.get(10)));
            r3.setF3("11" + getCardrowUI(cardrow.get(11)));
            r3.setF4("12" + getCardrowUI(cardrow.get(12)));
            r3.setF5(engine.getNOCARD().getName());
        } else {
            r1.setId(1);
            r1.setF1(engine.getNOCARD().getName());
            r1.setF2(engine.getNOCARD().getName());
            r1.setF3(engine.getNOCARD().getName());
            r1.setF4(engine.getNOCARD().getName());
            r1.setF5(engine.getNOCARD().getName());

            r2.setId(2);
            r2.setF1(engine.getNOCARD().getName());
            r2.setF2(engine.getNOCARD().getName());
            r2.setF3(engine.getNOCARD().getName());
            r2.setF4(engine.getNOCARD().getName());
            r2.setF5(engine.getNOCARD().getName());

            r3.setId(3);
            r3.setF1(engine.getNOCARD().getName());
            r3.setF2(engine.getNOCARD().getName());
            r3.setF3(engine.getNOCARD().getName());
            r3.setF4(engine.getNOCARD().getName());
            r3.setF5(engine.getNOCARD().getName());

        }

        listCardRowInTable.add(r1);
        listCardRowInTable.add(r2);
        listCardRowInTable.add(r3);

        return listCardRowInTable;
    }

    public Ages getEngine() {
        return engine;
    }

    public UI() throws AgesException {
        counter = 0;
        engine = new Ages();
    }

    public String getDebug() {
        return engine.getDebug();
    }

//    public void setDebug(String debug) {
//        this.debug = debug;
//    }
    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException, AgesException {
        this.text = text;
        counter++;
//        engine.doCmd("start");
//        setDebug("counter=" + counter + " " + text);
    }
}
