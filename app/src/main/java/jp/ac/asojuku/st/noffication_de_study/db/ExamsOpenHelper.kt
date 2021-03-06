package jp.ac.asojuku.st.noffication_de_study.db

import android.content.ContentValues
import android.database.CursorIndexOutOfBoundsException
import android.database.sqlite.SQLiteDatabase

class ExamsOpenHelper(var db: SQLiteDatabase) {
    val tableName: String = "exams";

    fun find_exam_name(exams_id: Int): String? {
        val query = "SELECT * FROM " + tableName + " where exams_id = " + exams_id
        val cursor = db.rawQuery(query, null)

        return try {
            cursor.moveToFirst()
            var result = cursor.getString(1)
            cursor.close()
            result
        } catch (e: CursorIndexOutOfBoundsException) {
            cursor.close()
            null
        }
    }

    fun add_record(q_id: Int, a_num: String) {
        val values = ContentValues()
        values.put("exams_id", q_id)
        values.put("exams_name", a_num)

        db.insertOrThrow(tableName, null, values)
    }
}



