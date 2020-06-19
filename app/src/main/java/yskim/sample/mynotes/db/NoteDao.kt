package yskim.sample.mynotes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Note)

    @Query("SELECT * FROM Note")
    fun getAllNotes() : List<Note>

    @Insert
    fun addMultipleNotes(vararg note: Note)
}