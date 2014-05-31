/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.card;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mark
 */
@Entity
//@Table(name = "AGES_CARD")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgesCard.findAll", query = "SELECT a FROM AgesCard a"),
    @NamedQuery(name = "AgesCard.findBySeq", query = "SELECT a FROM AgesCard a WHERE a.seq = :seq"),
    @NamedQuery(name = "AgesCard.findById", query = "SELECT a FROM AgesCard a WHERE a.id = :id"),
    @NamedQuery(name = "AgesCard.findByName", query = "SELECT a FROM AgesCard a WHERE a.name = :name"),
    @NamedQuery(name = "AgesCard.findByAge", query = "SELECT a FROM AgesCard a WHERE a.age = :age"),
    @NamedQuery(name = "AgesCard.findByCivilMilitary", query = "SELECT a FROM AgesCard a WHERE a.civilMilitary = :civilMilitary"),
    @NamedQuery(name = "AgesCard.findByTag", query = "SELECT a FROM AgesCard a WHERE a.tag = :tag"),
    @NamedQuery(name = "AgesCard.findByAction", query = "SELECT a FROM AgesCard a WHERE a.action = :action"),
    @NamedQuery(name = "AgesCard.findByIconPoints", query = "SELECT a FROM AgesCard a WHERE a.iconPoints = :iconPoints"),
    @NamedQuery(name = "AgesCard.findByEffect", query = "SELECT a FROM AgesCard a WHERE a.effect = :effect"),
    @NamedQuery(name = "AgesCard.findByCost", query = "SELECT a FROM AgesCard a WHERE a.cost = :cost"),
    @NamedQuery(name = "AgesCard.findByColor", query = "SELECT a FROM AgesCard a WHERE a.color = :color"),
    @NamedQuery(name = "AgesCard.findByCnt", query = "SELECT a FROM AgesCard a WHERE a.cnt = :cnt"),
    @NamedQuery(name = "AgesCard.findByTokenWhite", query = "SELECT a FROM AgesCard a WHERE a.tokenWhite = :tokenWhite"),
    @NamedQuery(name = "AgesCard.findByTokenRed", query = "SELECT a FROM AgesCard a WHERE a.tokenRed = :tokenRed"),
    @NamedQuery(name = "AgesCard.findByTokenYellow", query = "SELECT a FROM AgesCard a WHERE a.tokenYellow = :tokenYellow"),
    @NamedQuery(name = "AgesCard.findByTokenBlue", query = "SELECT a FROM AgesCard a WHERE a.tokenBlue = :tokenBlue"),
    @NamedQuery(name = "AgesCard.findByEffectWhite", query = "SELECT a FROM AgesCard a WHERE a.effectWhite = :effectWhite"),
    @NamedQuery(name = "AgesCard.findByEffectFood", query = "SELECT a FROM AgesCard a WHERE a.effectFood = :effectFood"),
    @NamedQuery(name = "AgesCard.findByEffectRed", query = "SELECT a FROM AgesCard a WHERE a.effectRed = :effectRed"),
    @NamedQuery(name = "AgesCard.findByEffectMusic", query = "SELECT a FROM AgesCard a WHERE a.effectMusic = :effectMusic"),
    @NamedQuery(name = "AgesCard.findByEffectStone", query = "SELECT a FROM AgesCard a WHERE a.effectStone = :effectStone"),
    @NamedQuery(name = "AgesCard.findByEffectIdea", query = "SELECT a FROM AgesCard a WHERE a.effectIdea = :effectIdea"),
    @NamedQuery(name = "AgesCard.findByEffectSmile", query = "SELECT a FROM AgesCard a WHERE a.effectSmile = :effectSmile"),
    @NamedQuery(name = "AgesCard.findByEffectHouse", query = "SELECT a FROM AgesCard a WHERE a.effectHouse = :effectHouse"),
    @NamedQuery(name = "AgesCard.findByEffectBlue", query = "SELECT a FROM AgesCard a WHERE a.effectBlue = :effectBlue"),
    @NamedQuery(name = "AgesCard.findByEffectWeapon", query = "SELECT a FROM AgesCard a WHERE a.effectWeapon = :effectWeapon"),
    @NamedQuery(name = "AgesCard.findByEffectWeaponOld", query = "SELECT a FROM AgesCard a WHERE a.effectWeaponOld = :effectWeaponOld"),
    @NamedQuery(name = "AgesCard.findByEffectYellow", query = "SELECT a FROM AgesCard a WHERE a.effectYellow = :effectYellow"),
    @NamedQuery(name = "AgesCard.findByCostPeople", query = "SELECT a FROM AgesCard a WHERE a.costPeople = :costPeople"),
    @NamedQuery(name = "AgesCard.findByCostFoot", query = "SELECT a FROM AgesCard a WHERE a.costFoot = :costFoot"),
    @NamedQuery(name = "AgesCard.findByCostWonder", query = "SELECT a FROM AgesCard a WHERE a.costWonder = :costWonder"),
    @NamedQuery(name = "AgesCard.findByCostMilitary", query = "SELECT a FROM AgesCard a WHERE a.costMilitary = :costMilitary"),
    @NamedQuery(name = "AgesCard.findByCostHorse", query = "SELECT a FROM AgesCard a WHERE a.costHorse = :costHorse"),
    @NamedQuery(name = "AgesCard.findByCostCannon", query = "SELECT a FROM AgesCard a WHERE a.costCannon = :costCannon"),
    @NamedQuery(name = "AgesCard.findByCostPeace", query = "SELECT a FROM AgesCard a WHERE a.costPeace = :costPeace"),
    @NamedQuery(name = "AgesCard.findByCostRevolution", query = "SELECT a FROM AgesCard a WHERE a.costRevolution = :costRevolution"),
    @NamedQuery(name = "AgesCard.findByCostRed", query = "SELECT a FROM AgesCard a WHERE a.costRed = :costRed"),
    @NamedQuery(name = "AgesCard.findByCostStone", query = "SELECT a FROM AgesCard a WHERE a.costStone = :costStone"),
    @NamedQuery(name = "AgesCard.findByCostIdea", query = "SELECT a FROM AgesCard a WHERE a.costIdea = :costIdea"),
    @NamedQuery(name = "AgesCard.findByCostFood", query = "SELECT a FROM AgesCard a WHERE a.costFood = :costFood"),
    @NamedQuery(name = "AgesCard.findByCostMusic", query = "SELECT a FROM AgesCard a WHERE a.costMusic = :costMusic")})
//)
public class AgesCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "SEQ")
    private Integer seq;
//    @Basic(optional = false)
//    @Column(name = "ID")
    private int id;
//    @Column(name = "NAME")
    private String name;
//    @Column(name = "AGE")
    private Integer age;
//    @Column(name = "CIVIL_MILITARY")
    private String civilMilitary;
//    @Column(name = "TAG")
    private String tag;
//    @Basic(optional = false)
//    @Column(name = "ACTION")
    private String action;
//    @Basic(optional = false)
//    @Column(name = "ICON_POINTS")
    private String iconPoints;
//    @Basic(optional = false)
//    @Column(name = "EFFECT")
    private String effect;
//    @Column(name = "COST")
    private String cost;
//    @Column(name = "COLOR")
    private String color;
//    @Basic(optional = false)
//    @Column(name = "CNT")
    private int cnt;
//    @Basic(optional = false)
//    @Column(name = "TOKEN_WHITE")
    private int tokenWhite;
//    @Basic(optional = false)
//    @Column(name = "TOKEN_RED")
    private int tokenRed;
//    @Basic(optional = false)
//    @Column(name = "TOKEN_YELLOW")
    private int tokenYellow;
//    @Basic(optional = false)
//    @Column(name = "TOKEN_BLUE")
    private int tokenBlue;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_WHITE")
    private int effectWhite;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_FOOD")
    private int effectFood;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_RED")
    private int effectRed;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_MUSIC")
    private int effectMusic;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_STONE")
    private int effectStone;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_IDEA")
    private int effectIdea;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_SMILE")
    private int effectSmile;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_HOUSE")
    private int effectHouse;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_BLUE")
    private int effectBlue;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_WEAPON")
    private int effectWeapon;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_WEAPON_OLD")
    private int effectWeaponOld;
//    @Basic(optional = false)
//    @Column(name = "EFFECT_YELLOW")
    private int effectYellow;
//    @Basic(optional = false)
//    @Column(name = "COST_PEOPLE")
    private int costPeople;
//    @Basic(optional = false)
//    @Column(name = "COST_FOOT")
    private int costFoot;
//    @Basic(optional = false)
//    @Column(name = "COST_WONDER")
    private int costWonder;
//    @Basic(optional = false)
//    @Column(name = "COST_MILITARY")
    private int costMilitary;
//    @Basic(optional = false)
//    @Column(name = "COST_HORSE")
    private int costHorse;
//    @Basic(optional = false)
//    @Column(name = "COST_CANNON")
    private int costCannon;
//    @Basic(optional = false)
//    @Column(name = "COST_PEACE")
    private int costPeace;
//    @Basic(optional = false)
//    @Column(name = "COST_REVOLUTION")
    private int costRevolution;
//    @Basic(optional = false)
//    @Column(name = "COST_RED")
    private int costRed;
//    @Basic(optional = false)
//    @Column(name = "COST_STONE")
    private int costStone;
//    @Basic(optional = false)
//    @Column(name = "COST_IDEA")
    private int costIdea;
//    @Basic(optional = false)
//    @Column(name = "COST_FOOD")
    private int costFood;
//    @Basic(optional = false)
//    @Column(name = "COST_MUSIC")
    private int costMusic;

    public AgesCard() {
    }

    public AgesCard(Integer seq) {
        this.seq = seq;
    }

    public AgesCard(Integer seq, int id, String name, Integer age, String civilMilitary, String tag, String action, String iconPoints, String effect, String cost, String color, int cnt, int tokenWhite, int tokenRed, int tokenYellow, int tokenBlue, int effectWhite, int effectFood, int effectRed, int effectMusic, int effectStone, int effectIdea, int effectSmile, int effectHouse, int effectBlue, int effectWeapon, int effectWeaponOld, int effectYellow, int costPeople, int costFoot, int costWonder, int costMilitary, int costHorse, int costCannon, int costPeace, int costRevolution, int costRed, int costStone, int costIdea, int costFood, int costMusic) {
        this.seq = seq;
        this.id = id;
        this.name = name;
        this.age = age;
        this.civilMilitary = civilMilitary;
        this.tag = tag;
        this.action = action;
        this.iconPoints = iconPoints;
        this.effect = effect;
        this.cost = cost;
        this.color = color;
        this.cnt = cnt;
        this.tokenWhite = tokenWhite;
        this.tokenRed = tokenRed;
        this.tokenYellow = tokenYellow;
        this.tokenBlue = tokenBlue;
        this.effectWhite = effectWhite;
        this.effectFood = effectFood;
        this.effectRed = effectRed;
        this.effectMusic = effectMusic;
        this.effectStone = effectStone;
        this.effectIdea = effectIdea;
        this.effectSmile = effectSmile;
        this.effectHouse = effectHouse;
        this.effectBlue = effectBlue;
        this.effectWeapon = effectWeapon;
        this.effectWeaponOld = effectWeaponOld;
        this.effectYellow = effectYellow;
        this.costPeople = costPeople;
        this.costFoot = costFoot;
        this.costWonder = costWonder;
        this.costMilitary = costMilitary;
        this.costHorse = costHorse;
        this.costCannon = costCannon;
        this.costPeace = costPeace;
        this.costRevolution = costRevolution;
        this.costRed = costRed;
        this.costStone = costStone;
        this.costIdea = costIdea;
        this.costFood = costFood;
        this.costMusic = costMusic;
    }

    public AgesCard(Integer seq, int id, String action, String iconPoints, String effect, int cnt, int tokenWhite, int tokenRed, int tokenYellow, int tokenBlue, int effectWhite, int effectFood, int effectRed, int effectMusic, int effectStone, int effectIdea, int effectSmile, int effectHouse, int effectBlue, int effectWeapon, int effectWeaponOld, int effectYellow, int costPeople, int costFoot, int costWonder, int costMilitary, int costHorse, int costCannon, int costPeace, int costRevolution, int costRed, int costStone, int costIdea, int costFood, int costMusic) {
        this.seq = seq;
        this.id = id;
        this.action = action;
        this.iconPoints = iconPoints;
        this.effect = effect;
        this.cnt = cnt;
        this.tokenWhite = tokenWhite;
        this.tokenRed = tokenRed;
        this.tokenYellow = tokenYellow;
        this.tokenBlue = tokenBlue;
        this.effectWhite = effectWhite;
        this.effectFood = effectFood;
        this.effectRed = effectRed;
        this.effectMusic = effectMusic;
        this.effectStone = effectStone;
        this.effectIdea = effectIdea;
        this.effectSmile = effectSmile;
        this.effectHouse = effectHouse;
        this.effectBlue = effectBlue;
        this.effectWeapon = effectWeapon;
        this.effectWeaponOld = effectWeaponOld;
        this.effectYellow = effectYellow;
        this.costPeople = costPeople;
        this.costFoot = costFoot;
        this.costWonder = costWonder;
        this.costMilitary = costMilitary;
        this.costHorse = costHorse;
        this.costCannon = costCannon;
        this.costPeace = costPeace;
        this.costRevolution = costRevolution;
        this.costRed = costRed;
        this.costStone = costStone;
        this.costIdea = costIdea;
        this.costFood = costFood;
        this.costMusic = costMusic;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgeStr() {
        String strAge[] = {"A", "I", "II", "III", "IV"};
        return strAge[age];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCivilMilitary() {
        return civilMilitary;
    }

    public void setCivilMilitary(String civilMilitary) {
        this.civilMilitary = civilMilitary;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIconPoints() {
        return iconPoints;
    }

    public void setIconPoints(String iconPoints) {
        this.iconPoints = iconPoints;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getTokenWhite() {
        return tokenWhite;
    }

    public void setTokenWhite(int tokenWhite) {
        this.tokenWhite = tokenWhite;
    }

    public int getTokenRed() {
        return tokenRed;
    }

    public void setTokenRed(int tokenRed) {
        this.tokenRed = tokenRed;
    }

    public int getTokenYellow() {
        return tokenYellow;
    }

    public void setTokenYellow(int tokenYellow) {
        this.tokenYellow = tokenYellow;
    }

    public int getTokenBlue() {
        return tokenBlue;
    }

    public void setTokenBlue(int tokenBlue) {
        this.tokenBlue = tokenBlue;
    }

    public int getEffectWhite() {
        return effectWhite;
    }

    public void setEffectWhite(int effectWhite) {
        this.effectWhite = effectWhite;
    }

    public int getEffectFood() {
        return effectFood;
    }

    public void setEffectFood(int effectFood) {
        this.effectFood = effectFood;
    }

    public int getEffectRed() {
        return effectRed;
    }

    public void setEffectRed(int effectRed) {
        this.effectRed = effectRed;
    }

    public int getEffectMusic() {
        return effectMusic;
    }

    public void setEffectMusic(int effectMusic) {
        this.effectMusic = effectMusic;
    }

    public int getEffectStone() {
        return effectStone;
    }

    public void setEffectStone(int effectStone) {
        this.effectStone = effectStone;
    }

    public int getEffectIdea() {
        return effectIdea;
    }

    public void setEffectIdea(int effectIdea) {
        this.effectIdea = effectIdea;
    }

    public int getEffectSmile() {
        return effectSmile;
    }

    public void setEffectSmile(int effectSmile) {
        this.effectSmile = effectSmile;
    }

    public int getEffectHouse() {
        return effectHouse;
    }

    public void setEffectHouse(int effectHouse) {
        this.effectHouse = effectHouse;
    }

    public int getEffectBlue() {
        return effectBlue;
    }

    public void setEffectBlue(int effectBlue) {
        this.effectBlue = effectBlue;
    }

    public int getEffectWeapon() {
        return effectWeapon;
    }

    public void setEffectWeapon(int effectWeapon) {
        this.effectWeapon = effectWeapon;
    }

    public int getEffectWeaponOld() {
        return effectWeaponOld;
    }

    public void setEffectWeaponOld(int effectWeaponOld) {
        this.effectWeaponOld = effectWeaponOld;
    }

    public int getEffectYellow() {
        return effectYellow;
    }

    public void setEffectYellow(int effectYellow) {
        this.effectYellow = effectYellow;
    }

    public int getCostPeople() {
        return costPeople;
    }

    public void setCostPeople(int costPeople) {
        this.costPeople = costPeople;
    }

    public int getCostFoot() {
        return costFoot;
    }

    public void setCostFoot(int costFoot) {
        this.costFoot = costFoot;
    }

    public int getCostWonder() {
        return costWonder;
    }

    public void setCostWonder(int costWonder) {
        this.costWonder = costWonder;
    }

    public int getCostMilitary() {
        return costMilitary;
    }

    public void setCostMilitary(int costMilitary) {
        this.costMilitary = costMilitary;
    }

    public int getCostHorse() {
        return costHorse;
    }

    public void setCostHorse(int costHorse) {
        this.costHorse = costHorse;
    }

    public int getCostCannon() {
        return costCannon;
    }

    public void setCostCannon(int costCannon) {
        this.costCannon = costCannon;
    }

    public int getCostPeace() {
        return costPeace;
    }

    public void setCostPeace(int costPeace) {
        this.costPeace = costPeace;
    }

    public int getCostRevolution() {
        return costRevolution;
    }

    public void setCostRevolution(int costRevolution) {
        this.costRevolution = costRevolution;
    }

    public int getCostRed() {
        return costRed;
    }

    public void setCostRed(int costRed) {
        this.costRed = costRed;
    }

    public int getCostStone() {
        return costStone;
    }

    public void setCostStone(int costStone) {
        this.costStone = costStone;
    }

    public int getCostIdea() {
        return costIdea;
    }

    public void setCostIdea(int costIdea) {
        this.costIdea = costIdea;
    }

    public int getCostFood() {
        return costFood;
    }

    public void setCostFood(int costFood) {
        this.costFood = costFood;
    }

    public int getCostMusic() {
        return costMusic;
    }

    public void setCostMusic(int costMusic) {
        this.costMusic = costMusic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seq != null ? seq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgesCard)) {
            return false;
        }
        AgesCard other = (AgesCard) object;
        if ((this.seq == null && other.seq != null) || (this.seq != null && !this.seq.equals(other.seq))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.livehereandnow.ages.card.AgesCard[ seq=" + seq + " ]";
//    }
    /**
     *
     * @param style <br>
     * case 1:// 政府區 <br>
     * case 2:// ,農場區,礦山區, 實驗室,神廟區,步兵區
     * @return
     */
    public String toString(int style) {
        String[] ageStr = {"A", "I", "II", "III", "-"};

        switch (style) {
            case 1:// 政府區
                StringBuilder sb1 = new StringBuilder();
//                System.out.println("");
                sb1.append("[");
                sb1.append(ageStr[age]);
                sb1.append("");
                sb1.append(name);
                sb1.append(id);
                sb1.append("-");
                sb1.append(tag);
                sb1.append(" 白");
                sb1.append(this.effectWhite);
                sb1.append(" 紅");
                sb1.append(this.effectRed);
                sb1.append("] ");

                return sb1.toString();
            case 8:// 農場區,礦山區
                StringBuilder sb8 = new StringBuilder();
//                System.out.println("");
                sb8.append("[");
                sb8.append(ageStr[age]);
                sb8.append("");
                sb8.append(name);
                sb8.append(id);

                sb8.append(" 黃");
                sb8.append(this.tokenYellow);

                sb8.append(" 藍");
                sb8.append(this.getTokenBlue());
                sb8.append(" #");
                sb8.append(effect);
                sb8.append("#");
                sb8.append(" 成本:");
                sb8.append(this.iconPoints);

                sb8.append("] ");
                return sb8.toString();
            case 2:// 農場區,礦山區
                StringBuilder sb2 = new StringBuilder();
//                System.out.println("");
                sb2.append("[");
                sb2.append(ageStr[age]);
                sb2.append("");

                sb2.append(name);
                sb2.append(id);
                sb2.append("-");
                sb2.append(tag);

//                sb2.append(" 黃:");
//                sb2.append(this.tokenYellow);
//                
//                sb2.append(" 藍:");
//                sb2.append(this.getTokenBlue());
                sb2.append("] ");
                return sb2.toString();
            case 3:// for CardNow
                StringBuilder sb3 = new StringBuilder();
//                System.out.println("");
                sb3.append("xxx[");
                sb3.append(ageStr[age]);
                sb3.append("");
                sb3.append(name);
                sb3.append(id);
                sb3.append("-");
                sb3.append(tag);
                sb3.append("] ");
                return sb3.toString();

            //【
            case 5:
                StringBuilder sb5 = new StringBuilder();
//                sb5.append(seq);
                sb5.append("[");
                sb5.append("");
                sb5.append(name);
                sb5.append(id);
                sb5.append("] ");
                return sb5.toString();
            case 101:// 領袖區
                StringBuilder sb101 = new StringBuilder();
//                System.out.println("");
                sb101.append("【");
                sb101.append(ageStr[age]);
                sb101.append("");
                sb101.append(name);
                sb101.append(id);
                sb101.append("-");

                sb101.append(action);

                sb101.append("】 ");
                return sb101.toString();

            case 102:// 建造中的奇蹟區
                StringBuilder sb102 = new StringBuilder();
//                System.out.println("");
                sb102.append("【");
                sb102.append(ageStr[age]);
                sb102.append("");
                sb102.append(name);
                sb102.append(id);
                sb102.append("-");
                sb102.append(iconPoints);
                sb102.append("】 ");
                return sb102.toString();

            case 103:// 已完成的奇蹟
                StringBuilder sb103 = new StringBuilder();
//                System.out.println("");
                sb103.append("【");
                sb103.append(ageStr[age]);
                sb103.append("");
                sb103.append(name);
                sb103.append(id);
                sb103.append(" #");
                sb103.append(effect);
                sb103.append("#");
                sb103.append("】 ");
                return sb103.toString();
            case 104:// 實驗室 神廟區 步兵區
                StringBuilder sb104 = new StringBuilder();
//                System.out.println("");
                sb104.append("【");
                sb104.append(ageStr[age]);
                sb104.append("");
                sb104.append(name);
                sb104.append(id);

                sb104.append(" 黃:");
                sb104.append(tokenYellow);
                sb104.append(" #");
                sb104.append(effect);
                sb104.append("#");
                sb104.append("】 ");
                return sb104.toString();

            case 105:// 行動牌
                StringBuilder sb105 = new StringBuilder();
//                System.out.println("");
                sb105.append("【");
                sb105.append(ageStr[age]);
                sb105.append("");
                sb105.append(name);
                sb105.append(id);

                sb105.append(" #");
                sb105.append(this.action);
                sb105.append("#");
                sb105.append("】");
                return sb105.toString();
            default:
                StringBuilder sb99 = new StringBuilder();
                sb99.append("[");

                sb99.append("");
                sb99.append(name);
                sb99.append(id);
                sb99.append("] ");
                return sb99.toString();

//                return toString();
        }
    }
//\n

    @Override
    public String toString() {
        return "AgesCard{" + "seq=" + seq + ", id=" + id + ", name=" + name + ", age=" + age + ", civilMilitary=" + civilMilitary + ", tag=" + tag + ", action=" + action + ", iconPoints=" + iconPoints + ", effect=" + effect + ", cost=" + cost + ", color=" + color + ", \ncnt=" + cnt + ", tokenWhite=" + tokenWhite + ", tokenRed=" + tokenRed + ", tokenYellow=" + tokenYellow + ", tokenBlue=" + tokenBlue + ", effectWhite=" + effectWhite + ", effectFood=" + effectFood + ", effectRed=" + effectRed + ", effectMusic=" + effectMusic + ", effectStone=" + effectStone + ", effectIdea=" + effectIdea + ", \neffectSmile=" + effectSmile + ", effectHouse=" + effectHouse + ", effectBlue=" + effectBlue + ", effectWeapon=" + effectWeapon + ", effectWeaponOld=" + effectWeaponOld + ", effectYellow=" + effectYellow + ", costPeople=" + costPeople + ", costFoot=" + costFoot + ", costWonder=" + costWonder + ", \ncostMilitary=" + costMilitary + ", costHorse=" + costHorse + ", costCannon=" + costCannon + ", costPeace=" + costPeace + ", costRevolution=" + costRevolution + ", costRed=" + costRed + ", costStone=" + costStone + ", costIdea=" + costIdea + ", costFood=" + costFood + ", costMusic=" + costMusic + '}';
    }

    public void produce() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
