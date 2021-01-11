/**
* @file      MonsterPartsHpDAO.java
* @brief     「モンスター部位体力」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 19:31:59
* $Version   1.1
* $Revision  1.3
* @par       リファクタリング：テーブル名とPK名をメンバ変数へ
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;
import static jdbc.consts.ColumnName.*;
import static jdbc.consts.DenormalizedTableName.*;
import static jdbc.consts.IdxName.*;

/**
 * @class MonsterPartsHpDAO
 * @brief 「モンスター部位体力」テーブルのDAO
 */
public class MonsterPartsHpDAO extends BattleDAO {

  /**
   * @fn MonsterPartsHpDAO
   * @brief 「モンスター部位体力」テーブルの作成を行うコンストラクタ
   */
  public MonsterPartsHpDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    this.createMonsterPartsHpTable();
    this.createMonsterPartsHpIdx();
  }

  /**
   * @fn createMonsterPartsHpTable
   * @brief 「モンスター部位体力」テーブルの作成
   */
  private void createMonsterPartsHpTable() {
    // TODO
  }

  /**
   * @fn dropMonsterPartsHpTable
   * @brief 「モンスター部位体力」テーブルの削除
   */
  public void dropMonsterPartsHpTable() {
    // TODO
  }

  /**
   * @fn createMonsterPartsHpIdx
   * @brief テーブルのインデックスを張る
   */
  private void createMonsterPartsHpIdx() {
    super.createIdx(TODO, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE);
  }

  //////////////////////////////////////////////////
  // SELECT SELECT ALL
  //////////////////////////////////////////////////

  /**
   * @fn selectAllMonsterPartsName
   * @brief 「モンスター部位体力」テーブルの、モンスター部位名カラムの全てのフィールドを返す
   * @return 全モンスター部位名のリスト
   */
  public ArrayList<String> selectAllMonsterPartsName() {
    return super.selectColumn(MONSTER_PART_NAME, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE);
  }

  /**
   * @fn selectAllMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの全てのフィールドを返す
   * @return 全モンスター部位体力のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHp() {
    return super.toIntegerList(super.selectColumn(MONSTER_PART_HITPOINT, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE));
  }

  /**
   * @fn selectAllMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの全てのフィールドを返す
   * @return 全モンスター部位肉質のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHardness() {
    return super.toIntegerList(super.selectColumn(MONSTER_PART_HARDNESS, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE));
  }

  //////////////////////////////////////////////////
  // UPADATE
  //////////////////////////////////////////////////

  /**
   * @fn updateMonsterPartsName
   * @brief 「モンスター部位体力」テーブルの、モンスター部位名カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsName(String monsterPartsName, String primaryKey) {
    this.updateField(monsterPartsName, MONSTER_PART_NAME, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE, primaryKey);
  }

  /**
   * @fn updateMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHp(int monsterPartsHp, String primaryKey) {
    this.updateField(Integer.toString(monsterPartsHp), MONSTER_PART_HITPOINT, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE,
        primaryKey);
  }

  /**
   * @fn updateMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHardness(int monsterPartsHardness, String primaryKey) {
    this.updateField(Integer.toString(monsterPartsHardness), MONSTER_PART_HARDNESS, MONSTERS_PARTS_HITPOINTS,
        MONSTER_CODE, primaryKey);
  }
}
