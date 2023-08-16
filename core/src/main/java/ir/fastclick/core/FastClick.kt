import android.content.Context
import android.content.SharedPreferences
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import ir.fastclick.core.FastClickAdvertiseListener
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class FastClick(private val context: Context) : FastClickAdvertiseListener {

    companion object {
        private const val PREF_NAME = "pref_name"
        private var instance: FastClick? = null

        fun getInstance(context: Context): FastClick {
            if (instance == null) {
                instance = FastClick(context.applicationContext)
            }
            return instance!!
        }
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }
    private val apiService: ApiService by lazy {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val retrofit = Retrofit.Builder().baseUrl("https://play-core.huma.ir/")
            .addConverterFactory(json.asConverterFactory("application/json; charset=utf-8".toMediaType()))
            .build()

        retrofit.create(ApiService::class.java)
    }

    override suspend fun getVAST(): String {
        return apiService.getVASTUrl().title
    }
}
