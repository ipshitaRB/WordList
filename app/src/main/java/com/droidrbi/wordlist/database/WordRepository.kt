package com.droidrbi.wordlist.database

import androidx.lifecycle.LiveData
import com.droidrbi.wordlist.model.Word

class WordRepository(private val wordDao: WordDao) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}