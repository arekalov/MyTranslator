import com.arekalov.data.TranslationApi
import com.arekalov.data.TranslationDAO
import com.arekalov.data.TranslationRemoteDataSource
import com.arekalov.data.models.TranslationEntity
import javax.inject.Inject

class TranslationRepository @Inject constructor(
    private val translationApi: TranslationApi,
    private val translationDAO: TranslationDAO
) {
    suspend fun getTranslation(search: String): TranslationEntity? {
        try {
            val response = translationApi.getTranslation(search)
            if (response.isSuccessful) {
                val meaning = response.body()!![0].meanings[0]
                val entity = TranslationEntity(
                    imageUrl = meaning.imageUrl,
                    soundUrl = meaning.soundUrl,
                    translation = meaning.translation.text,
                    transcription = meaning.transcription
                )
                insertTranslation(entity)
                return entity
            }
            return null
        } catch (ex: Exception) {
            return null
        }
    }

    suspend fun getHistory(): List<TranslationEntity> {
        return translationDAO.getHistory()
    }

    suspend fun getFavorite(): List<TranslationEntity> {
        return translationDAO.getFavorite()
    }

    suspend fun insertTranslation(translation: TranslationEntity) {
        translationDAO.insertTranslation(translation)
    }

    suspend fun deleteTranslation(translation: TranslationEntity) {
        translationDAO.deleteTranslation(translation)
    }
}
