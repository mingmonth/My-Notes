package yskim.sample.mynotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch
import yskim.sample.mynotes.R
import yskim.sample.mynotes.db.Note
import yskim.sample.mynotes.db.NoteDatabase

class AddNoteFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        NoteDatabase(activity!!).getNoteDao().

        button_save.setOnClickListener {

            val noteTitle = edit_text_title.text.toString().trim()
            val noteBody = edit_text_note.text.toString().trim()

            if(noteTitle.isEmpty()) {
                edit_text_title.error = "title required"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }

            if(noteBody.isEmpty()) {
                edit_text_note.error = "note required"
                edit_text_note.requestFocus()
                return@setOnClickListener
            }

            launch {
                val note = Note(noteTitle, noteBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    //Toast.makeText(activity, "Note Saved", Toast.LENGTH_LONG).show()
                    it.toast("Note Saved")
                }
            }
//            saveNote(note)
//            NoteDatabase(activity!!).getNoteDao().addNote(note)

//            val action = AddNoteFragmentDirections.actionSaveNote()
//            Navigation.findNavController(it).navigate(action)

        }
    }

//    private fun saveNote(note: Note) {
//        class SaveNote : AsyncTask<Void, Void, Void>() {
//
//            override fun doInBackground(vararg params: Void?): Void? {
//                NoteDatabase(activity!!).getNoteDao().addNote(note)
//                return null
//            }
//
//            override fun onPostExecute(result: Void?) {
//                super.onPostExecute(result)
//
//                Toast.makeText(activity, "Note Saved", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        SaveNote().execute()
//    }
}