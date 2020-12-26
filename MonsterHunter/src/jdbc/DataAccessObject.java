/**
* @file      DataAccessObject.java
* @brief     DAOの汎用部分を実装する抽象クラス
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-27 04:00:43
* $Version   1.0
* $Revision  1.1
* @par       追加：createTableメソッド，dropTableメソッドの形のみ
* @see       https://www.kenschool.jp/blog/?p=1644
 */

package jdbc;

import java.sql.*;
import java.util.ArrayList;

/**
 * @class DataAccessObject
 * @brief DAOの汎用部分を実装する抽象クラス
 */
abstract class DataAccessObject extends DBConnector {

  /**
   * @fn selectColumn
   * @brief カラム内のフィールドを全て返す
   * @param[in] columnName: 検索したいカラムの名前
   * @param[in] tableName: 検索したいカラムが存在するテーブルの名前
   * @param[in] primaryKeyName: 検索したいカラムの主キーの名前
   * @return 指定されたカラムの全フィールドのオブジェクトリスト
   */
  protected ArrayList<String> selectColumn(String columnName, String tableName, String primaryKeyName) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ArrayList<String> rtnColumnList = new ArrayList<String>();

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    String sql = "";
    sql += "SELECT " + columnName;
    sql += " FROM " + tableName;
    sql += "ORDER BY " + primaryKeyName;

    try {
      // DBに接続
      connection = DBConnector.getConnection();
      statement = connection.createStatement();

      // SQL文発行
      ResultSet rs = statement.executeQuery(sql);

      // 検索結果をArrayListに格納
      while (rs.next()) {
        rtnColumnList.add(rs.getString("isbn"));
      }

      // 例外処理
    } catch (SQLException e) {
      System.out.println("Error: Failed to select column" + e);

      // 後処理
    } finally {
      this.closeResources(statement, connection);
    }

    return rtnColumnList;
  }

  /**
   * @fn toIntegerList
   * @brief StringのリストをIntegerのリストに変換
   * @param[in] strList
   * @return intList
   */
  protected ArrayList<Integer> toIntegerList(ArrayList<String> strList) {
    ArrayList<Integer> intList = new ArrayList<Integer>();
    for (String str : strList) {
      intList.add(Integer.parseInt(str));
    }
    return intList;
  }

  /**
   * @fn createTable
   * @brief SQL文でよく使うカラムを非正規化する汎用メソッド
   */
  protected void createTable(String tableName) {
    // TODO
  }

  /**
   * @fn dropTable
   * @brief テーブルを削除する汎用メソッド
   */
  protected void dropTable(String tableName) {
    // TODO
  }

  /**
   * @fn closeResources
   * @brief ステートメントとコネクションをこの順番にクローズする
   * @param[in] statement: DBのステートメント
   * @param[in] connection: DBの接続情報
   */
  protected void closeResources(Statement statement, Connection connection) {
    // statementの後処理
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException ignore) {
      }
    }

    // connectionの後処理
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException ignore) {
      }
    }
  }
}
